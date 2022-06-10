package it.nextworks.nfvmano.nssmf.handler.transport.driver.service;

import it.nextworks.nfvmano.libs.vs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.vs.common.topology.NetworkTopology;
import it.nextworks.nfvmano.nssmf.handler.transport.driver.plugin.NetworkTopologyPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EthInfrastructureTopologyService {
    private static final Logger log = LoggerFactory.getLogger(EthInfrastructureTopologyService.class);

    @Value("${controller.basepath}")
    private String basePath;

    @Value("${controller.username}")
    private String username;

    @Value("${controller.password}")
    private String password;

    @Value("${tapitnsmf.enable_vlan_classifiers}")
    private boolean enableVlanClassifier;

    private NetworkTopologyPlugin networkTopologyPlugin;

    public EthInfrastructureTopologyService(){}

    @PostConstruct
    public void initPlugin(){
        networkTopologyPlugin=new NetworkTopologyPlugin(basePath, username, password, enableVlanClassifier);
    }

    public void configPlugin(String basePath, String username, String password, boolean enableVlanClassifier){
        networkTopologyPlugin=new NetworkTopologyPlugin(basePath, username, password, enableVlanClassifier);
    }

    public NetworkTopology getNetworkTopology() throws NotExistingEntityException {
        return networkTopologyPlugin.getNetworkTopology();
    }
}
