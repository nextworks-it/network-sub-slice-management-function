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

package it.nextworks.nfvmano.nssmf.service.messages;

/**
 * Base Class for nssmf internal messages
 */
public abstract class BaseMessage {
    private NssmfMessageType messageType;

    public NssmfMessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(NssmfMessageType messageType) {
        this.messageType = messageType;
    }
}
