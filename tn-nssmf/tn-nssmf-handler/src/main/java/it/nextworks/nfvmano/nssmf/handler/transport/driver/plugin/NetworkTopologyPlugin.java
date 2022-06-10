package it.nextworks.nfvmano.nssmf.handler.transport.driver.plugin;

import it.nextworks.nfvmano.libs.vs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.vs.common.topology.*;
import it.nextworks.nfvmano.nssmf.handler.transport.driver.elements.TapiTopologyCp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tapi.eth.client.api.DefaultApi;
import tapi.eth.client.invoker.ApiClient;
import tapi.eth.client.invoker.ApiException;
import tapi.eth.client.invoker.auth.HttpBasicAuth;
import tapi.eth.client.model.*;

import java.util.*;

public class NetworkTopologyPlugin {

    private static final Logger log = LoggerFactory.getLogger(NetworkTopologyPlugin.class);

    private String basePath;
    private String username;
    private String password;
    private boolean enableVlanClassifier;

    public NetworkTopologyPlugin(){}

    public NetworkTopologyPlugin(String basePath, String username, String password, boolean enableVlanClassifier){
        this.basePath=basePath;
        this.username=username;
        this.password=password;
        this.enableVlanClassifier=enableVlanClassifier;
    }

    public NetworkTopology getNetworkTopology() throws NotExistingEntityException {
        log.debug("Retrieving network topology via TAPI ETH");
        DefaultApi api= buildApiClient();

        try{
            ContextSchema response = api.retrieveContext().getContextSchema();
            TopologyContext topologyList= response.getTopologyContext();

            if(topologyList==null){
                log.error("Null topology");
                throw new NotExistingEntityException("Impossible to read topology, null returned");
            }

            if (topologyList.getTopology().size() == 0) {
                log.error("Empty topology list!");
                throw new NotExistingEntityException("Impossible to read topology, empty list returned.");
            }
            if (topologyList.getTopology().size() > 1)
                log.debug("More that one topology returned!, using the first one");

            Topology topologyOut = topologyList.getTopology().get(0);
            NetworkTopology result = translateEthTapiTopology(topologyOut, response);
            log.debug("Topology successfully translated");
            return result;
        } catch (ApiException e){
            log.error("Got API Exception trying to get topology");
            throw new NotExistingEntityException("Impossible to read topology: got API exception");
        }
    }

    /**
     * This method creates the handler to interact with the SDN controller via TAPI REST client
     *
     * @return TAPI consumer handler
     */
    private DefaultApi buildApiClient() {
        DefaultApi api= new DefaultApi();
        ApiClient apiClient = new ApiClient()
                .setBasePath(basePath)
                .setDebugging(true)
                .setConnectTimeout(0)
                .setReadTimeout(30000)
                .setWriteTimeout(30000);
        //TODO: set the authorization properties i don't know why
        HttpBasicAuth authentication = new HttpBasicAuth();
        authentication.setUsername(username);
        authentication.setPassword(password);
        apiClient.getAuthentications().put("basic", authentication);
        log.debug("Authentications {}",apiClient.getAuthentications());

        api.setApiClient(apiClient);
        return api;
    }

    public NetworkTopology translateEthTapiTopology(Topology source, ContextSchema contextSchema) throws NotExistingEntityException{
        log.debug("Translate TAPI topology into NSMF Driver topology format");
        log.debug("Source TAPI topology: " + source.toString());
        NetworkTopology target = translateEthTapiNodes(source, contextSchema);

        List<Link> links=source.getLink();

        log.debug("The TAPI topology has " + source.getNode().size() + " nodes and " + links.size() + " links.");
        List<Topology.LayerProtocolNameEnum> origProtocolLayers=source.getLayerProtocolName();
        Set<LayerProtocol> supportedProtocolLayers=new HashSet<>();
        if(origProtocolLayers!=null)
            for(Topology.LayerProtocolNameEnum lp: origProtocolLayers){
                if (lp.equals(Topology.LayerProtocolNameEnum.ETH))
                    supportedProtocolLayers.add(LayerProtocol.ETHERNET);
                else if (lp.equals(Topology.LayerProtocolNameEnum.PHOTONIC_MEDIA))
                    supportedProtocolLayers.add(LayerProtocol.SDM);
                else {
                    log.warn("Unsopported layer protocol. Setting to NOT_SPECIFIED.");
                    supportedProtocolLayers.add(LayerProtocol.NOT_SPECIFIED);
                }
            }

        log.debug("Adding links to topology");
        for(Link l: links){
            String linkId=l.getUuid();
            List<NodeEdgePointRef> neprs= l.getNodeEdgePoint();

            String srcPortId = neprs.get(0).getNodeEdgePointUuid();
            String srcNodeId = neprs.get(0).getNodeUuid();
            String dstPortId = neprs.get(neprs.size()-1).getNodeEdgePointUuid();
            String dstNodeId = neprs.get(neprs.size()-1).getNodeUuid();

            if ((srcNodeId != null) && (dstNodeId != null)) {
                TopologyLink targetLink = new TopologyLink(linkId,
                        target.fetchNodeById(srcNodeId),
                        target.fetchNodeById(dstNodeId),
                        target.getCpById(srcNodeId, srcPortId),
                        target.getCpById(dstNodeId, dstPortId),
                        0,
                        0,
                        null,
                        0
                );
                log.debug("Created link with ID " + linkId + " between port " + srcPortId + " and port " + dstPortId);

                target.addLink(targetLink);
                target.getCpById(srcNodeId, srcPortId).setOutgoingLink(targetLink);
                target.getCpById(dstNodeId, dstPortId).setIncomingLink(targetLink);
            } else {
                log.error("Source or destination node not found for link " + linkId + ". Skipping it.");
            }
        }
        log.debug("All links have been added to the topology");

        return target;
    }

    public NetworkTopology translateEthTapiNodes(Topology source, ContextSchema contextSchema) throws NotExistingEntityException{
        List<Node> nodes= source.getNode();
        if(nodes==null)
            throw new NotExistingEntityException("Topology without nodes");
        NetworkTopology target = new NetworkTopology(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        log.debug("Adding nodes to topology");
        for(Node n: nodes){
            String nodeId= n.getUuid();
            List<TopologyCp> connectionPoints = new ArrayList<>();

            TopologyNode targetNode= new TopologyNode(nodeId, null, null, null, null, null, null, null);
            List<NodeEdgePoint> ports= n.getOwnedNodeEdgePoint();
            List<String> sipUuids=new ArrayList<>();
            Map<String, List<String>> onepSips=new HashMap<>();
            for(NodeEdgePoint p: ports){
                NodeEdgePoint.LayerProtocolNameEnum proto=p.getLayerProtocolName();
                String portId= p.getUuid();
                if(p.getMappedServiceInterfacePoint()!=null) {
                    for (ServiceInterfacePointRef sipr : p.getMappedServiceInterfacePoint()) {
                        String sipId=sipr.getServiceInterfacePointUuid();
                        sipUuids.add(sipId);
                        TopologyServiceInterfacePoint sip=new TopologyServiceInterfacePoint();
                        sip.setSipId(sipId);
                        sip.setTopologyCpId(p.getUuid());
                        sip.setTopologyNodeId(n.getUuid());
                        if(enableVlanClassifier) {
                            List<SupportedServiceClassifier> classifiers=new ArrayList<>();
                            classifiers.add(SupportedServiceClassifier.VLAN);
                            sip.setClassifiers(classifiers);
                        }
                        for(ServiceInterfacePoint s:contextSchema.getServiceInterfacePoint()){
                            if(s.getUuid().equals(sipId))
                                switch (s.getDirection()){
                                    case INPUT:
                                        sip.setDirection(ServiceInterfacePointDirection.INPUT);
                                        break;
                                    case OUTPUT:
                                        sip.setDirection(ServiceInterfacePointDirection.OUTPUT);
                                        break;
                                    case BIDIRECTIONAL:
                                        sip.setDirection(ServiceInterfacePointDirection.BIDERECTIONAL);
                                        break;
                                    default:
                                        sip.setDirection(null);
                                        break;
                                }
                        }
                        target.sips.add(sip);
                    }
                    onepSips.put(portId, sipUuids);
                }
                if(proto!=null && proto.equals(NodeEdgePoint.LayerProtocolNameEnum.ETH)) {
                    TapiTopologyCp tapiCp = new TapiTopologyCp(targetNode, null, null, portId);
                    log.debug("Created ETH port with ID " + portId);
                    connectionPoints.add(tapiCp);
                    target.addCp(targetNode, tapiCp);
                }
                log.debug("Added ports to topology");
                targetNode.setCps(new HashSet<>(connectionPoints));
                target.addNode(targetNode);
            }
            targetNode.setMapOnepSipUuids(onepSips);
        }
        log.debug("All nodes and ports have been added to the topology");
        return target;
    }

}
