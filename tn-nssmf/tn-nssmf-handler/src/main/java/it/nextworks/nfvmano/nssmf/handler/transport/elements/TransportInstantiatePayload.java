package it.nextworks.nfvmano.nssmf.handler.transport.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.vs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vs.common.nssmf.messages.provisioning.NssmfBaseProvisioningMessage;
import it.nextworks.nfvmano.libs.vs.common.ra.elements.NssResourceAllocation;

import java.util.UUID;

public class TransportInstantiatePayload extends NssmfBaseProvisioningMessage {

    @JsonProperty("sourceSip")
    private String sourceSip;
    @JsonProperty("destinationSip")
    private String destinationSip;

    public TransportInstantiatePayload(){}

    public TransportInstantiatePayload(UUID nssiId, String instantiationDetail1, String instantiationDetail2) {
        super(nssiId);
        this.sourceSip = instantiationDetail1;
        this.destinationSip = instantiationDetail2;
    }

    public void setDestinationSip(String destinationSip) {
        this.destinationSip = destinationSip;
    }

    public void setSourceSip(String sourceSip) {
        this.sourceSip = sourceSip;
    }

    public String getDestinationSip() {
        return destinationSip;
    }

    public String getSourceSip() {
        return sourceSip;
    }
}
