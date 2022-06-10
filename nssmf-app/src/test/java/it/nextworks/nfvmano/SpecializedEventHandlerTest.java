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

package it.nextworks.nfvmano;
import it.nextworks.nfvmano.libs.vs.common.exceptions.*;
import it.nextworks.nfvmano.libs.vs.common.nssmf.messages.provisioning.InstantiateNssiRequest;
import it.nextworks.nfvmano.libs.vs.common.nssmf.messages.provisioning.TerminateNssiRequest;
//import it.nextworks.nfvmano.nssmf.NssmfLcmService;
//import it.nextworks.nfvmano.nssmf.specialized.testdefault.TestInstantiationPayload;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = NssmfApplication.class)
public class SpecializedEventHandlerTest {

//    @Autowired
//    private NssmfLcmService nssmfLcmService;
//    @Test
//    public void instantiationTest() throws IllegalAccessException, MethodNotImplementedException, InstantiationException,
//            ClassNotFoundException, NotPermittedOperationException, MalformattedElementException, FailedOperationException,
//            NotExistingEntityException, AlreadyExistingEntityException {
//
//        //nssmfLcmService.setSpecializedEventHandlerClass("it.nextworks.nfvmano.nssmf.specialized.testdefault.TestEventHandler");
//        UUID nssiId = nssmfLcmService.createNetworkSubSliceIdentifier();
//        InstantiateNssiRequest instantiateNssiRequest = new InstantiateNssiRequest(nssiId);
//
//        //Specialized provisioning payload
//        TestInstantiationPayload testInstantiationPayload = new TestInstantiationPayload();
//        testInstantiationPayload.setInstantiationDetail1("This is the end");
//        testInstantiationPayload.setGetInstantiationDetail2("My only friend, the end");
//
//        //Assemble request
//        instantiateNssiRequest.setProvisioningPayload(testInstantiationPayload);
//
//        nssmfLcmService.instantiateNetworkSubSlice(instantiateNssiRequest);
//
//        TerminateNssiRequest terminateNssiRequest = new TerminateNssiRequest(nssiId);
//        nssmfLcmService.terminateNetworkSliceInstance(terminateNssiRequest);
//
//    }
}
