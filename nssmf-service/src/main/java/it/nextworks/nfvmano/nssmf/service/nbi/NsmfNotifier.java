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

package it.nextworks.nfvmano.nssmf.service.nbi;

import it.nextworks.nfvmano.libs.vs.common.nsmf.interfaces.NsmfNotificationInterface;
import it.nextworks.nfvmano.libs.vs.common.nsmf.messages.NsmfNotificationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class NsmfNotifier implements NsmfNotificationInterface {
    private static final Logger log = LoggerFactory.getLogger(NsmfNotifier.class);

    @Value("${nssmf.nsmfnotifier.auth.user}")
    private String username;
    @Value("${nssmf.nsmfnotifier.auth.pwd}")
    private String password;
    @Value("${nssmf.nsmfnotifier.notifyUrl}")
    private String notifyUrl;

    @Value("${nssmf.nsmfnotifier.loginUrl:noLogin}")
    private String loginUrl;

    private NsmfRestClient nsmfRestClient;

    @Override
    public void notifyNsmf(NsmfNotificationMessage nsmfNotificationMessage) {
        log.debug("Sending NSSI Status change notification");
        log.debug("Requested by " + nsmfNotificationMessage.getNssiId().toString());

        boolean authenticated;
        if (loginUrl.equals("noLogin"))
            authenticated=true;
        else
            authenticated=nsmfRestClient.authenticate(username, password);

        if (authenticated){
            nsmfRestClient.notifyNsmf(nsmfNotificationMessage);
            log.debug("Notification Sent");
        }else
            log.debug("Error in sending notification to NSMF. Requester: " + nsmfNotificationMessage.getNssiId().toString());
    }

    @PostConstruct
    private void initRestClient(){
        nsmfRestClient = new NsmfRestClient(notifyUrl, loginUrl);
    }
}

class NsmfRestClient implements NsmfNotificationInterface{

    private static final Logger log = LoggerFactory.getLogger(NsmfRestClient.class);
    private RestTemplate restTemplate;
    private String notifyUrl;

    private String loginUrl;
    private String authCookie;

    NsmfRestClient(String notifyUrl, String loginUrl) {
        restTemplate = new RestTemplate();
        this.notifyUrl = notifyUrl;
        this.loginUrl= loginUrl;
    }

    boolean authenticate(String username, String password){
        log.info("Building http request to login");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", username);
        map.add("password", password);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        try{
            ResponseEntity<String> httpResponse = restTemplate.exchange(loginUrl, HttpMethod.POST, request, String.class);
            HttpHeaders headersResp = httpResponse.getHeaders();
            HttpStatus code = httpResponse.getStatusCode();

            if (code.equals(HttpStatus.OK)) {
                authCookie = headersResp.getFirst(HttpHeaders.SET_COOKIE);
                log.info("Authentication performed on Nsmf. Cookie:  " + authCookie);
                return true;
            }

            log.debug("Error while sending notification - HTTP Code: "+code.toString());
            return false;

        }catch (RestClientException e) {
            log.error("Error during authentication process with the NSMF " + e.toString());
            return false;
        }

    }

    @Override
    public void notifyNsmf(NsmfNotificationMessage nsmfNotificationMessage) {
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json");

        if(authCookie!=null)
            header.add("Cookie", this.authCookie);


        HttpEntity<?> postEntity = new HttpEntity<>(nsmfNotificationMessage, header);

        if(notifyUrl.contains("%nssi_id%"))
            notifyUrl=notifyUrl.replace("%nssi_id%", nsmfNotificationMessage.getNssiId().toString());

        try {
            log.debug("Sending HTTP message to notify network slice status change.");
            ResponseEntity<String> httpResponse =
                    restTemplate.exchange(notifyUrl, HttpMethod.POST, postEntity, String.class);

            log.debug("Response code: " + httpResponse.getStatusCode().toString());
            HttpStatus code = httpResponse.getStatusCode();

            if (code.equals(HttpStatus.OK)) {
                log.debug("Notification correctly dispatched.");
            } else {
                log.debug("Error while sending notification");
            }

        } catch (RestClientException e) {
            log.debug("Error while sending notification");
            log.debug(e.toString());
            log.debug("RestClientException response: Message " + e.getMessage());
        }
    }
}