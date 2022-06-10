package it.nextworks.nfvmano.nssmf.record.tapi.repo;

import it.nextworks.nfvmano.nssmf.record.tapi.TapiNetworkSliceSubnetInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TapiNetworkSliceSubnetInstanceRepository extends JpaRepository<TapiNetworkSliceSubnetInstance, Long> {
    Optional<TapiNetworkSliceSubnetInstance> findByNssiId(UUID id);
}
