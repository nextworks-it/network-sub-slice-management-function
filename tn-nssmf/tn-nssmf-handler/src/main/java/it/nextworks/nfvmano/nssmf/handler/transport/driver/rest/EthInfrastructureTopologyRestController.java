package it.nextworks.nfvmano.nssmf.handler.transport.driver.rest;

import it.nextworks.nfvmano.libs.vs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.vs.common.topology.NetworkTopology;
import it.nextworks.nfvmano.nssmf.handler.transport.driver.service.EthInfrastructureTopologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/nsmf/infrastructure")
public class EthInfrastructureTopologyRestController {
    private static final Logger log = LoggerFactory.getLogger(EthInfrastructureTopologyRestController.class);

    @Autowired
    private EthInfrastructureTopologyService topologyService;

    public EthInfrastructureTopologyRestController(){}

    @RequestMapping(value = "/networkTopology", method = RequestMethod.GET)
    public ResponseEntity<?> getNetworkTopology(){
        log.debug("RECEIVED REQUEST TO RETRIEVE NETWORK TOPOLOGY");
        try{
            NetworkTopology nt= topologyService.getNetworkTopology();
            return new ResponseEntity<>(nt, HttpStatus.CREATED);
        } catch (NotExistingEntityException e){
            log.error("Entity does not exist");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
