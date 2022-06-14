package it.nextworks.nfvmano.nssmf.handler.transport.nssmanagement;

import it.nextworks.TapiClient;
import it.nextworks.nfvmano.libs.vs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.vs.common.nssmf.messages.specialized.transport.TransportInstantiatePayload;
import it.nextworks.nfvmano.libs.vs.common.ra.elements.ConnectivityServiceResourceAllocation;
import it.nextworks.nfvmano.libs.vs.common.ra.elements.SdnNssResourceAllocation;
import it.nextworks.nfvmano.nssmf.record.RecordServiceFactory;
import it.nextworks.nfvmano.nssmf.record.tapi.service.TapiRecordService;
import it.nextworks.nfvmano.nssmf.service.messages.BaseMessage;
import it.nextworks.nfvmano.nssmf.service.messages.notification.NssiStatusChangeNotiticationMessage;
import it.nextworks.nfvmano.nssmf.service.messages.provisioning.InstantiateNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.service.messages.provisioning.ModifyNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.service.messages.provisioning.TerminateNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.service.nssmanagement.NssLcmEventHandler;
import it.nextworks.tapi.common.ServiceInterfacePoint;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransportNssLcmEventHandler extends NssLcmEventHandler {

    private TapiClient tapiClient;
    private TapiRecordService tapiRecordService;

    public TransportNssLcmEventHandler(){}

    @Override
    public void setRecordServiceFactory(RecordServiceFactory recordServiceFactory) {
        super.setRecordServiceFactory(recordServiceFactory);

        // TODO: stessa cosa di sopra
        this.tapiRecordService=(TapiRecordService) recordServiceFactory.getRecordService("tapiRecordService");
        tapiRecordService.createTapiNetworkSliceSubnetIdentifier(this.getNetworkSubSliceInstanceId());
    }

    private void configPlugins(){
        String basePath= getEnvironment().getProperty("controller.basepath");

        this.tapiClient=new TapiClient(basePath);
    }

    private String getLayerProtocolQualifier(String inputSipId){
        List<ServiceInterfacePoint> sips=tapiClient.retrieveServiceInterfacePoints();
        for(ServiceInterfacePoint sip: sips)
            if(sip.getUuid().equals(inputSipId))
                return sip.getSupportedLayerProtocolQualifier().get(0);
        return null;
    }
    // TODO to be implemented
    @Override
    protected void processInstantiateNssRequest(InstantiateNssiRequestMessage message) throws NotExistingEntityException {
        log.debug("Processing request to instantiate new TN NSSI with ID {}", this.getNetworkSubSliceInstanceId().toString());
        configPlugins();

        NssiStatusChangeNotiticationMessage notif=new NssiStatusChangeNotiticationMessage();
        TransportInstantiatePayload payload=(TransportInstantiatePayload) message.getInstantiateNssiRequest();

        String connectivityServiceId="";
        List<String> csIds=new ArrayList<>();
        for(ConnectivityServiceResourceAllocation csResource: ((SdnNssResourceAllocation) payload.getNssResourceAllocation()).getCsResources()) {
            connectivityServiceId=UUID.randomUUID().toString(); // generate UUID
            log.info("Creating Connectivity Service in CTTC domain with ID {}", connectivityServiceId);
            if(tapiClient.createConnectivityService(connectivityServiceId, csResource.getIngressSipId(), csResource.getEgressSipId(), getLayerProtocolQualifier(csResource.getIngressSipId()), csResource.getCapacity())){
                csIds.add(connectivityServiceId);
            } else {
                if(!csIds.isEmpty()){
                    tapiClient.deleteConnectivityService(csIds.get(0));
                }
                log.error("Impossible to create connectivity service, instantiation failed");
                notif.setSuccess(false);
                this.getEventBus().post(notif);
                return ;
            }
        }

        tapiRecordService.setConnectivityServices(this.getNetworkSubSliceInstanceId(),csIds);

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

        List<String> connectivityServiceIds=tapiRecordService.getConnectivityServiceIds(nssiId);
        for(String csId: connectivityServiceIds){
            if(!tapiClient.deleteConnectivityService(csId)){
                log.error("Impossible to delete connectivity service, termination failed");
                notif.setSuccess(false);
                this.getEventBus().post(notif);
                return;
            }
        }
        tapiRecordService.deleteNssInstance(nssiId);
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
