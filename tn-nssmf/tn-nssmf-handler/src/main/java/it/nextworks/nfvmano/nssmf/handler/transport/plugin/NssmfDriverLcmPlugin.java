package it.nextworks.nfvmano.nssmf.handler.transport.plugin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.nextworks.nfvmano.libs.vs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.vs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.vs.common.ra.elements.ComputeNssResourceAllocation;
import it.nextworks.nfvmano.libs.vs.common.ra.elements.NssResourceAllocation;
import it.nextworks.nfvmano.libs.vs.common.ra.elements.VirtualLinkResourceAllocation;
import it.nextworks.nfvmano.libs.vs.common.topology.NetworkTopology;
import it.nextworks.nfvmano.libs.vs.common.topology.TopologyServiceInterfacePoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import tapi.eth.client.api.DefaultApi;
//import tapi.eth.client.invoker.ApiClient;
//import tapi.eth.client.invoker.ApiException;
//import tapi.eth.client.invoker.auth.HttpBasicAuth;
import it.nextworks.TapiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NssmfDriverLcmPlugin {

    private static final Logger log = LoggerFactory.getLogger(NssmfDriverLcmPlugin.class);

    private String ip;
    private String port;
    private String username;
    private String password;

    private Map<String, String> idMapping=new ConcurrentHashMap<>();

    private TapiClient cttcclient;

    public NssmfDriverLcmPlugin(){}

    public NssmfDriverLcmPlugin(String basePath, String username, String password){
        this.username=username;
        this.password=password;
    }

    public String setupPaths(NssResourceAllocation nssra, NetworkTopology topology) throws NotExistingEntityException, FailedOperationException {
        log.debug("Creating network path through TAPI connectivity service");
        // TODO
        this.cttcclient = new TapiClient()
        log.debug("Starting thread to create network paths through TAPI connectivity service");

        String csId="";
        try{
            csId=buildEthPath(((ComputeNssResourceAllocation) nssra).getvLinkResources().get(0), topology);
        } catch (ApiException e){
            log.error("Got API exception while creating connectivity service");
            log.error("ApiException Message: "+e.getMessage());
        }
        return csId;
    }


    public String removePaths(List<String> connServiceIds) throws NotExistingEntityException, FailedOperationException {
        log.debug("Removing network path through TAPI connectivity service");
        String operationId = UUID.randomUUID().toString();
        DefaultApi api= buildApiClient();
        log.debug("Starting thread to remove network paths through TAPI connectivity service");

        List<String> idsToDelete=new ArrayList<>();
        idsToDelete.add(idMapping.get(connServiceIds.get(0)));
        try{
            for(String id: idsToDelete)
                removeEthPath(id);
        } catch (ApiException e){
            log.error("Got API exception while creating connectivity service");
            log.error("ApiException Message: "+e.getMessage());
        }

        return operationId;
    }

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

    private String buildEthPath(VirtualLinkResourceAllocation virtualLinkResourceAllocation, NetworkTopology topology) throws ApiException {
        String csUuid= UUID.randomUUID().toString();
        log.debug("Creating path with ID "+csUuid);

        CreateConnectivityServiceRPCInputSchema connectivityService = new CreateConnectivityServiceRPCInputSchema();

        TopologyServiceInterfacePoint egressSip=topology.getSipById(virtualLinkResourceAllocation.getEgressSipId());
        TopologyServiceInterfacePoint ingressSip=topology.getSipById(virtualLinkResourceAllocation.getIngressSipId());

        String source=egressSip.getTopologyCpId();
        String dest=ingressSip.getTopologyCpId();
        log.debug("Source SIP: "+ source+" - Destination SIP: "+ dest);

        EndPointSchema srcEndpoint=new EndPointSchema();
        srcEndpoint.setLayerProtocolName(EndPointSchema.LayerProtocolNameEnum.ETH);
        srcEndpoint.setLocalId(source);
        srcEndpoint.setDirection(EndPointSchema.DirectionEnum.BIDIRECTIONAL);
        ServiceInterfacePointRef srcSip=new ServiceInterfacePointRef();
        srcSip.setServiceInterfacePointUuid(virtualLinkResourceAllocation.getEgressSipId());
        srcEndpoint.setServiceInterfacePoint(srcSip);
        EthConnectivityServiceEndPointSpec connectivityServiceEndPointSpec=new EthConnectivityServiceEndPointSpec();
        EthTerminationCommonPac etcPac=new EthTerminationCommonPac();
        etcPac.setPriorityCodePointConfig(EthTerminationCommonPac.PriorityCodePointConfigEnum._8P0D);
        etcPac.setEtherType(EthTerminationCommonPac.EtherTypeEnum.C_TAG);
        if(egressSip.getClassifiers()!=null && virtualLinkResourceAllocation.getServiceClassifierAllocation().containsKey(egressSip.getClassifiers().get(0)))
            etcPac.setPortVid(virtualLinkResourceAllocation.getServiceClassifierAllocation().get(egressSip.getClassifiers().get(0)));
        connectivityServiceEndPointSpec.setEthTerminationCommonPac(etcPac);
        srcEndpoint.setEthConnectivityServiceEndPointSpec(connectivityServiceEndPointSpec);

        EndPointSchema dstEndpoint= new EndPointSchema();
        dstEndpoint.setLayerProtocolName(EndPointSchema.LayerProtocolNameEnum.ETH);
        dstEndpoint.setLocalId(dest);
        dstEndpoint.setDirection(EndPointSchema.DirectionEnum.BIDIRECTIONAL);
        ServiceInterfacePointRef dstSip=new  ServiceInterfacePointRef();
        dstSip.setServiceInterfacePointUuid(virtualLinkResourceAllocation.getIngressSipId());
        dstEndpoint.setServiceInterfacePoint(dstSip);
        dstEndpoint.setEthConnectivityServiceEndPointSpec(connectivityServiceEndPointSpec);
        connectivityService.addEndPointItem(srcEndpoint);
        connectivityService.addEndPointItem(dstEndpoint);

        log.debug("Creating new connectivity service");
        TapiConnectivityOutput output=api.createCreateConnectivityServiceById(connectivityService);
        String replyUuid=output.getOutput().getService().getUuid();
        idMapping.put(csUuid,replyUuid);
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(output);
            log.debug("Created connectivity service \n{}",json);
        } catch (JsonProcessingException e){
            log.error(e.getMessage());
        }
        return csUuid;
    }

    private void removeEthPath(String csId) throws ApiException{
        log.debug("Deleting network path");

        DeleteConnectivityServiceRPCInputSchema connectivityService= new DeleteConnectivityServiceRPCInputSchema();
        connectivityService.setServiceIdOrName(csId);
        TapiDeleteInput deleteInput=new TapiDeleteInput();
        deleteInput.setDeleteConnectivityServiceRPCInputSchema(connectivityService);
        api.createDeleteConnectivityServiceById(connectivityService);
        log.debug("Network path successfully deleted");
    }
}
