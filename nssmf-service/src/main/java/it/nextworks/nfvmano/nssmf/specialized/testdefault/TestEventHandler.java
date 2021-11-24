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

package it.nextworks.nfvmano.nssmf.specialized.testdefault;


import com.google.common.eventbus.EventBus;
import it.nextworks.nfvmano.nssmf.messages.provisioning.InstantiateNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.messages.provisioning.TerminateNssiRequestMessage;
import it.nextworks.nfvmano.nssmf.nssmanagement.NssLcmEventHandler;
import it.nextworks.nfvmano.nssmf.nssmanagement.NssiStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestEventHandler extends NssLcmEventHandler {


    public TestEventHandler() {
    }

    @Override
    protected void processInstantiateNssRequest(InstantiateNssiRequestMessage message) {
        log.debug("Invoked processInstantiateNssRequest of class " + TestEventHandler.class.getName());
        TestInstantiationPayload testInstantiationPayload = (TestInstantiationPayload) message.getBaseProvisioningPayload();
        System.out.println("NssiID: "+ this.getNetworkSubSliceInstanceId().toString() + "\nMessage Content:\n"+
                testInstantiationPayload.getInstantiationDetail1()+"\n"+testInstantiationPayload.getGetInstantiationDetail2());

        this.setNssiStatus(NssiStatus.INSTANTIATED);


    }
    @Override
    protected void processTerminateNssRequest(TerminateNssiRequestMessage message) {
        log.debug("Invoked processTerminateNssRequest of class " + TestEventHandler.class.getName());
        this.setNssiStatus(NssiStatus.TERMINATED);
    }

}

