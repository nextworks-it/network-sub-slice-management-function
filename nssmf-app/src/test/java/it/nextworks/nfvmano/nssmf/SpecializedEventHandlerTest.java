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

package it.nextworks.nfvmano.nssmf;
import it.nextworks.nfvmano.nssmf.NssmfApplication;
import it.nextworks.nfvmano.nssmf.service.NssmfLcmService;
import it.nextworks.nfvmano.nssmf.service.specialized.testdefault.TestInstantiationPayload;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NssmfApplication.class)
public class SpecializedEventHandlerTest {

    @Autowired
    private NssmfLcmService nssmfLcmService;
    /*@Test
    public void instantiationTest() throws IllegalAccessException, MethodNotImplementedException, InstantiationException,
            ClassNotFoundException, NotPermittedOperationException, MalformattedElementException, FailedOperationException,
            NotExistingEntityException, AlreadyExistingEntityException {

        //nssmfLcmService.setSpecializedEventHandlerClass("it.nextworks.nfvmano.nssmf.specialized.testdefault.TestEventHandler");
        UUID nssiId = nssmfLcmService.createNetworkSubSliceIdentifier();
        InstantiateNssiRequest instantiateNssiRequest = new InstantiateNssiRequest(nssiId);

        //Specialized provisioning payload
        TestInstantiationPayload testInstantiationPayload = new TestInstantiationPayload();
        testInstantiationPayload.setInstantiationDetail1("This is the end");
        testInstantiationPayload.setGetInstantiationDetail2("My only friend, the end");

        //Assemble request
        instantiateNssiRequest.setProvisioningPayload(testInstantiationPayload);

        nssmfLcmService.instantiateNetworkSubSlice(instantiateNssiRequest);

        TerminateNssiRequest terminateNssiRequest = new TerminateNssiRequest(nssiId);
        nssmfLcmService.terminateNetworkSliceInstance(terminateNssiRequest);
    }*/

    /*@Test
    public void instantiateRanNssiTest()throws IllegalAccessException, MethodNotImplementedException, InstantiationException,
            ClassNotFoundException, NotPermittedOperationException, MalformattedElementException, FailedOperationException,
            NotExistingEntityException, AlreadyExistingEntityException {

        ObjectMapper mapper=new ObjectMapper();

        UUID nssiId = nssmfLcmService.createNetworkSubSliceIdentifier();
        InstantiateNssiRequest instantiateNssiRequest = new InstantiateNssiRequest(nssiId);

        ORanNearRTRicPayload payload=new ORanNearRTRicPayload();
        ORanPayloadWrapper wrapper= new ORanPayloadWrapper();
        Map<String, String> additionalParams=new HashMap<>();
        additionalParams.put("ueId", "test-id");
        additionalParams.put("qosId", "1234");
        additionalParams.put("groupId", "2345");
        wrapper.setAdditionalParams(additionalParams);
        SliceProfile sliceProfile=null;
        try {
            File file = new File("/home/nicola/network-sub-slice-management-function/nssmf-app/src/test/resources/sliceProfile.json");
            sliceProfile = mapper.readValue(file, SliceProfile.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        List<ORanPayloadWrapper> payloadWrappers= new ArrayList<>();
        wrapper.setSliceProfile(sliceProfile);

        payloadWrappers.add(wrapper);
        payload.setPayload(payloadWrappers);
        instantiateNssiRequest.setProvisioningPayload(payload);

        nssmfLcmService.instantiateNetworkSubSlice(instantiateNssiRequest);

        TerminateNssiRequest terminateNssiRequest = new TerminateNssiRequest(nssiId);
        nssmfLcmService.terminateNetworkSliceInstance(terminateNssiRequest);
    }*/
}
