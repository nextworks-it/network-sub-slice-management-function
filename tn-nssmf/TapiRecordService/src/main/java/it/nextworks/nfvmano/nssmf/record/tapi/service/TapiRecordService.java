package it.nextworks.nfvmano.nssmf.record.tapi.service;

import it.nextworks.nfvmano.libs.vs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.nssmf.record.tapi.TapiNetworkSliceSubnetInstance;
import it.nextworks.nfvmano.nssmf.record.tapi.repo.TapiNetworkSliceSubnetInstanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TapiRecordService {
    private static final Logger log= LoggerFactory.getLogger(TapiRecordService.class);

    @Autowired
    private TapiNetworkSliceSubnetInstanceRepository nssiRepository;

    public synchronized void createTapiNetworkSliceSubnetIdentifier(UUID nssiId){
        log.debug("Creating a new network slice subnet instance");

        TapiNetworkSliceSubnetInstance nssi=new TapiNetworkSliceSubnetInstance();
        nssi.setNssiId(nssiId);
        nssiRepository.saveAndFlush(nssi);
        log.debug("Created new network slice subnet instance  with ID {}", nssiId.toString());
    }

    /**
     * This method returns the NSSI stored in DB that matches a given ID
     *
     * @param nssiId ID of the Network Slice Subnet Instance to be returned
     * @return the Network Slice Subnet instance
     * @throws NotExistingEntityException if the NSSI with the given ID is not present in DB
     */
    public TapiNetworkSliceSubnetInstance getNssInstance(UUID nssiId) throws NotExistingEntityException {
        log.debug("Retrieving nssi with ID {} from DB", nssiId.toString());
        Optional<TapiNetworkSliceSubnetInstance> nssi=nssiRepository.findByNssiId(nssiId);
        if(!nssi.isPresent())
            throw new NotExistingEntityException("Nssi with ID "+nssiId+" is not present in DB");

        return nssi.get();
    }

    public synchronized void setConnectivityServices(UUID nssiId,
                                                    List<String> connectivityServiceIds) throws NotExistingEntityException {
        log.debug("Updating NssInstance with ID {}", nssiId);
        try{
            TapiNetworkSliceSubnetInstance nssi=getNssInstance(nssiId);
            nssi.setConnectivityServiceIds(connectivityServiceIds);
            nssiRepository.saveAndFlush(nssi);
            log.debug("Updated nssi with ID {}", nssiId);
        }catch (NotExistingEntityException e){
            log.error("NSSI with ID "+nssiId.toString()+" not present in DB. Impossible to update it");
        }
    }

    public List<String> getConnectivityServiceIds(UUID nssiId) throws NotExistingEntityException {
        log.debug("Retrieving CS IDs from NSSI with ID {}", nssiId);
        try{
            TapiNetworkSliceSubnetInstance nssi=getNssInstance(nssiId);
            return nssi.getConnectivityServiceIds();
        } catch (NotExistingEntityException e){
            log.error("NSSI with ID "+nssiId.toString()+" not present in DB. Impossible to retrieve CS IDs");
            return null;
        }
    }

    public synchronized void addConnectivityService(UUID nssiId, String connectivityServiceId)throws NotExistingEntityException{
        log.debug("Updating NssInstance with ID {} adding a connectivity service", nssiId);
        try{
            TapiNetworkSliceSubnetInstance nssi=getNssInstance(nssiId);
            nssi.addConnectivityServiceId(connectivityServiceId);
            nssiRepository.saveAndFlush(nssi);
            log.debug("Updated nssi with ID {}", nssiId);
        }catch (NotExistingEntityException e){
            log.error("NSSI with ID "+nssiId.toString()+" not present in DB. Impossible to update it");
        }
    }

    public synchronized void deleteNssInstance(UUID nssiId) throws NotExistingEntityException{
        log.debug("Deleting NssInstance with ID {}", nssiId);
        try{
            TapiNetworkSliceSubnetInstance nssi=getNssInstance(nssiId);
            nssiRepository.delete(nssi);
            log.debug("Deleted nssi with ID {}", nssiId);
        }catch (NotExistingEntityException e){
            log.error("NSSI with ID "+nssiId.toString()+" not present in DB. Impossible to delete it");
        }
    }
}
