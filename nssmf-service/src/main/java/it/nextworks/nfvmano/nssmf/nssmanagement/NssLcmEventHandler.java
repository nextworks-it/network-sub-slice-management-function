/*
 * Copyright (c) 2021 Nextworks s.r.l.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.nextworks.nfvmano.nssmf.nssmanagement;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import it.nextworks.nfvmano.nssmf.messages.*;
import it.nextworks.nfvmano.nssmf.messages.provisioning.InstantiateNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.messages.provisioning.ModifyNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.messages.provisioning.TerminateNssiRequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Class managing the events related to a nss
 *
 * @author Pietro G. Giardina
 *
 */
public abstract class NssLcmEventHandler {
    protected static final Logger log = LoggerFactory.getLogger(NssLcmEventHandler.class);
    private UUID networkSubSliceInstanceId;
    private NssiStatus nssiStatus = NssiStatus.NOT_INSTANTIATED;
    private EventBus eventBus; //required: it will be forwarded to other services for notifications


//    public NssLcmEventHandler(UUID networkSubSliceInstanceId, EventBus eventBus) {
//        this.eventBus = eventBus;
//        this.networkSubSliceInstanceId = networkSubSliceInstanceId;
//    }

    public UUID getNetworkSubSliceInstanceId() {
        return networkSubSliceInstanceId;
    }

    public void setNetworkSubSliceInstanceId(UUID networkSubSliceInstanceId) {
        this.networkSubSliceInstanceId = networkSubSliceInstanceId;
    }

    public NssiStatus getNssiStatus() {
        return nssiStatus;
    }

    public void setNssiStatus(NssiStatus nssiStatus) {
        this.nssiStatus = nssiStatus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    @Subscribe
    private void eventHandler(BaseMessage message){
        log.info("Received message for NSI " + networkSubSliceInstanceId + "\n" + message);
        NssmfMessageType messageType = message.getMessageType();
        switch (messageType){
            case INSTANTIATE_NSSI_REQUEST: {
                log.info("Processing NSSI instantiation request.");
                processInstantiateNssRequest((InstantiateNssiRequestMessage)message);
                break;
            }
            case MODIFY_NSSI_REQUEST: {
                log.info("Processing NSSI modification request.");
                processModifyNssRequest((ModifyNssiRequestMessage)message);
                break;
            }
            case TERMINATE_NSSI_REQUEST: {
                log.info("Processing NSSI termination request.");
                processTerminateNssRequest((TerminateNssiRequestMessage)message);
                break;
            }
            case SET_NSSI_CONFIG: {
                log.info("Processing set NSSI configuration request.");
                processNssSetConfigRequest(message);
                break;
            }
            case UPDATE_NSSI_CONFIG: {
                log.info("Processing update NSSI configuration request.");
                processNssUpdateConfigRequest(message);
                break;
            }
            case REMOVE_NSSI_CONFIG: {
                log.info("Processing remove NSSI configuration request.");
                processNssRemoveConfigRequest(message);
                break;
            }
            default:{
                log.error("Received message with not supported type. Skipping.");
                break;
            }
        }

    }

    protected void processInstantiateNssRequest(InstantiateNssiRequestMessage message) {
        log.error("processInstantiateNssRequest not implemented." + message);
    }
    protected void processModifyNssRequest(ModifyNssiRequestMessage message) {
        log.error("processModifyNssRequest not implemented." + message);
    }
    protected void processTerminateNssRequest(TerminateNssiRequestMessage message) {
        log.error("processTerminateNssRequest not implemented." + message);
    }
    protected void processNssSetConfigRequest(BaseMessage message) {
        log.error("processNssSetConfigRequest not implemented."+ message);
    }
    protected void processNssUpdateConfigRequest(BaseMessage message) {
        log.error("processNssUpdateConfigRequest not implemented." + message);
    }
    protected void processNssRemoveConfigRequest(BaseMessage message) {
        log.error("processNssUpdateConfigRequest not implemented." + message);
    }

}
