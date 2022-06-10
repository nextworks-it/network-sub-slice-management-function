package it.nextworks.nfvmano.nssmf.handler.transport.nssmanagement;

import it.nextworks.nfvmano.libs.vs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.vs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.vs.common.ra.elements.ComputeNssResourceAllocation;
import it.nextworks.nfvmano.libs.vs.common.topology.NetworkTopology;
import it.nextworks.nfvmano.nssmf.handler.transport.elements.TransportInstantiatePayload;
import it.nextworks.nfvmano.nssmf.handler.transport.plugin.NssmfDriverLcmPlugin;
import it.nextworks.nfvmano.nssmf.record.RecordServiceFactory;
import it.nextworks.nfvmano.nssmf.record.tapi.service.TapiRecordService;
import it.nextworks.nfvmano.nssmf.service.factory.DriverFactory;
import it.nextworks.nfvmano.nssmf.service.messages.BaseMessage;
import it.nextworks.nfvmano.nssmf.service.messages.notification.NssiStatusChangeNotiticationMessage;
import it.nextworks.nfvmano.nssmf.service.messages.provisioning.InstantiateNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.service.messages.provisioning.ModifyNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.service.messages.provisioning.TerminateNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.service.nssmanagement.NssLcmEventHandler;

import java.util.UUID;

public class TransportNssLcmEventHandler extends NssLcmEventHandler {

//    private EthInfrastructureTopologyService topologyService;
    private NssmfDriverLcmPlugin nssmfDriverLcmPlugin;
    private TapiRecordService tapiRecordService;

    public TransportNssLcmEventHandler(){}

    @Override
    public void setDriverFactory(DriverFactory driverFactory) {
        super.setDriverFactory(driverFactory);

        // TODO: capire cosa devo fare qua?
        // Passargli il nome del bean !? di cosa?
        this.topologyService=(EthInfrastructureTopologyService) driverFactory.getDriver("ethInfrastructureTopologyService");
    }

    @Override
    public void setRecordServiceFactory(RecordServiceFactory recordServiceFactory) {
        super.setRecordServiceFactory(recordServiceFactory);

        // TODO: stessa cosa di sopra
        this.tapiRecordService=(TapiRecordService) recordServiceFactory.getRecordService("tapiRecordService");
        tapiRecordService.createTapiNetworkSliceSubnetIdentifier(this.getNetworkSubSliceInstanceId());
    }

    private void configPlugins(){
        String basePath= getEnvironment().getProperty("controller.basepath");
        String username= getEnvironment().getProperty("controller.username");
        String password= getEnvironment().getProperty("controller.password");
        boolean enableVlanClassifier=new Boolean(getEnvironment().getProperty("tapitnsmf.enable_vlan_classifiers"));

        // TODO: da vedere
//        topologyService.configPlugin(basePath, username, password, enableVlanClassifier);
        this.nssmfDriverLcmPlugin=new NssmfDriverLcmPlugin(basePath, username, password);
    }

    // TODO to be implemented
    @Override
    protected void processInstantiateNssRequest(InstantiateNssiRequestMessage message) throws NotExistingEntityException {
        log.debug("Processing request to instantiate new TN NSSI with ID {}", this.getNetworkSubSliceInstanceId().toString());
        configPlugins();

        NssiStatusChangeNotiticationMessage notif=new NssiStatusChangeNotiticationMessage();
        TransportInstantiatePayload payload=(TransportInstantiatePayload) message.getInstantiateNssiRequest();

        // Retrieve SIPs info from NBI message
        String srcSip= payload.getSourceSip();
        String dstSip= payload.getDestinationSip();

        String connectivityServiceId=""; // generate UUID
        log.info("Creating Connectivity Service in CTTC domain");
        // TODO: qua dovrei chiamare il mio client?!
//        try {
//             connectivityServiceId= nssmfDriverLcmPlugin.setupPaths(nssra, topology);
//        }catch (FailedOperationException e){
//            log.error("Impossible to create connectivity service, instantiation failed");
//            notif.setSuccess(false);
//            this.getEventBus().post(notif);
//        }
        tapiRecordService.addConnectivityService(this.getNetworkSubSliceInstanceId(),connectivityServiceId);

        notif.setSuccess(true);
        this.getEventBus().post(notif);
    }

    @Override
    protected void processModifyNssRequest(ModifyNssiRequestMessage message) throws NotExistingEntityException {
        super.processModifyNssRequest(message);
    }

    // TODO to be implemented
    @Override
    protected void processTerminateNssRequest(TerminateNssiRequestMessage message) throws NotExistingEntityException {
        log.debug("Processing request to terminate network slice subnet instance with ID {}", message.getTerminateNssiRequest().getNssiId());
        UUID nssiId=message.getTerminateNssiRequest().getNssiId();
        NssiStatusChangeNotiticationMessage notif= new NssiStatusChangeNotiticationMessage();

        try {
            nssmfDriverLcmPlugin.removePaths(tapiRecordService.getConnectivityServiceIds(nssiId));
        } catch (FailedOperationException e){
            log.error("Impossible to delete connectivity service, termination failed");
            notif.setSuccess(false);
            this.getEventBus().post(notif);
        }

        notif.setSuccess(true);
        this.getEventBus().post(notif);
    }

    @Override
    protected void processNssSetConfigRequest(BaseMessage message) throws NotExistingEntityException {
        super.processNssSetConfigRequest(message);
    }

    @Override
    protected void processNssUpdateConfigRequest(BaseMessage message) throws NotExistingEntityException {
        super.processNssUpdateConfigRequest(message);
    }

    @Override
    protected void processNssRemoveConfigRequest(BaseMessage message) throws NotExistingEntityException {
        super.processNssRemoveConfigRequest(message);
    }

    @Override
    protected void processNssStatusChangeNotification(NssiStatusChangeNotiticationMessage message) throws NotExistingEntityException {
        super.processNssStatusChangeNotification(message);
    }
}
