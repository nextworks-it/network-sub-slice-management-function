package it.nextworks.nfvmano.nssmf.record.tapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
public class TapiNetworkSliceSubnetInstance {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private UUID nssiId;

    @ElementCollection(targetClass=String.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private String connectivityServiceIds;

    public TapiNetworkSliceSubnetInstance(){}

    public TapiNetworkSliceSubnetInstance(UUID nssiId,
                                          String connectivityServiceIds){
        this.nssiId=nssiId;
        this.connectivityServiceIds=connectivityServiceIds;
    }

    public UUID getNssiId() {
        return nssiId;
    }

    public void setNssiId(UUID nssiId) {
        this.nssiId = nssiId;
    }

    public String getConnectivityServiceIds() {
        return connectivityServiceIds;
    }

    public void setConnectivityServiceIds(String connectivityServiceIds) {
        this.connectivityServiceIds = connectivityServiceIds;
    }

}
