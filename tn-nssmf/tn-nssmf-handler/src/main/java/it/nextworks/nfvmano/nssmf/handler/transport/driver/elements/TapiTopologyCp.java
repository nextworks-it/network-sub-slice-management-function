package it.nextworks.nfvmano.nssmf.handler.transport.driver.elements;

import it.nextworks.nfvmano.libs.vs.common.topology.LayerProtocol;
import it.nextworks.nfvmano.libs.vs.common.topology.TopologyCp;
import it.nextworks.nfvmano.libs.vs.common.topology.TopologyLink;
import it.nextworks.nfvmano.libs.vs.common.topology.TopologyNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This class models a generalized connection point as in TAPI topologies.
 * In particular, it includes a list of "Service Interface Points", referred with
 * their IDs, which identify network interfaces that can be used as end-points of
 * connectivity services.
 * 
 *  Technology specific resource constraints and characteristics are defined in
 *  other classes that extends this one, e.g. TapiTopologySdmCp.
 * 
 * @author nextworks
 *
 */
public class TapiTopologyCp extends TopologyCp {

	/**
	 * ID of the mapped Service Interface Point
	 */
	protected List<String> mappedServiceInterfacePoint = new ArrayList<>();
	
	public TapiTopologyCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink,
						  String cpId, String cpdId) {
		super(node, outgoingLink, incomingLink, cpId, cpdId);
	}

	public TapiTopologyCp(TopologyNode node, TopologyLink outgoingLink, TopologyLink incomingLink,
                          String cpId) {
		super(node, outgoingLink, incomingLink, cpId);
	}

	public TapiTopologyCp(TopologyNode node, LayerProtocol layerProtocol, TopologyLink outgoingLink,
						  TopologyLink incomingLink, String cpId, String cpdId) {
		super(node, layerProtocol, outgoingLink, incomingLink, cpId, cpdId);
	}

	public TapiTopologyCp(TopologyNode node, LayerProtocol layerProtocol, TopologyLink outgoingLink,
                          TopologyLink incomingLink, String cpId) {
		super(node, layerProtocol, outgoingLink, incomingLink, cpId);
	}

	/**
	 * @return the mappedServiceInterfacePoint
	 */
	public List<String> getMappedServiceInterfacePoint() {
		return mappedServiceInterfacePoint;
	}
	
	/**
	 * Add a mapper service interface point
	 * 
	 * @param mappedSip
	 */
	public void addSip(String mappedSip) {
		this.mappedServiceInterfacePoint.add(mappedSip);
	}

}
