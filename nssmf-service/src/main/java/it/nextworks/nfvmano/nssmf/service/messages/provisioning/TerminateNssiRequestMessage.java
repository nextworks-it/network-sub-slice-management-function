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

package it.nextworks.nfvmano.nssmf.service.messages.provisioning;

import it.nextworks.nfvmano.libs.vs.common.nssmf.messages.provisioning.NssmfBaseProvisioningMessage;
import it.nextworks.nfvmano.nssmf.service.messages.BaseMessage;
import it.nextworks.nfvmano.nssmf.service.messages.NssmfMessageType;

/**
 * Instantiate NSSI message
 *
 * @author Pietro G. Giardina
 */
public class TerminateNssiRequestMessage extends BaseMessage {

    private NssmfBaseProvisioningMessage terminateNssiRequest;
    public TerminateNssiRequestMessage() {
        super.setMessageType(NssmfMessageType.TERMINATE_NSSI_REQUEST);
    }

    public NssmfBaseProvisioningMessage getTerminateNssiRequest() {
        return terminateNssiRequest;
    }

    public void setTerminateNssiRequest(NssmfBaseProvisioningMessage terminateNssiRequest) {
        this.terminateNssiRequest = terminateNssiRequest;
    }


}
