/*
 * OSM NB API featuring ETSI NFV SOL005
 * This is Open Source MANO Northbound API featuring ETSI NFV SOL005. For more information on OSM, you can visit [http://osm.etsi.org](http://osm.etsi.org). You can send us your comments and questions to OSM_TECH@list.etsi.org or join the [OpenSourceMANO Slack Workplace](https://join.slack.com/t/opensourcemano/shared_invite/enQtMzQ3MzYzNTQ0NDIyLWVkNTE4ZjZjNWI0ZTQyN2VhOTI1MjViMzU1NWYwMWM3ODI4NTQyY2VlODA2ZjczMWIyYTFkZWNiZmFkM2M2ZDk) 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: OSM_TECH@list.etsi.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package it.nextworks.nfvmano.sbi.nfvo.osm.rest.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * InstantiateNsRequestInterface
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T13:48:18.253Z[GMT]")
public class InstantiateNsRequestInterface {
  @SerializedName("name")
  private String name = null;

  @SerializedName("ip-address")
  private String ipAddress = null;

  @SerializedName("mac-address")
  private String macAddress = null;

  @SerializedName("floating-ip-required")
  private Boolean floatingIpRequired = null;

  public InstantiateNsRequestInterface name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(required = true, description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InstantiateNsRequestInterface ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * Get ipAddress
   * @return ipAddress
  **/
  @Schema(description = "")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public InstantiateNsRequestInterface macAddress(String macAddress) {
    this.macAddress = macAddress;
    return this;
  }

   /**
   * Get macAddress
   * @return macAddress
  **/
  @Schema(description = "")
  public String getMacAddress() {
    return macAddress;
  }

  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }

  public InstantiateNsRequestInterface floatingIpRequired(Boolean floatingIpRequired) {
    this.floatingIpRequired = floatingIpRequired;
    return this;
  }

   /**
   * Get floatingIpRequired
   * @return floatingIpRequired
  **/
  @Schema(description = "")
  public Boolean isFloatingIpRequired() {
    return floatingIpRequired;
  }

  public void setFloatingIpRequired(Boolean floatingIpRequired) {
    this.floatingIpRequired = floatingIpRequired;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstantiateNsRequestInterface instantiateNsRequestInterface = (InstantiateNsRequestInterface) o;
    return Objects.equals(this.name, instantiateNsRequestInterface.name) &&
        Objects.equals(this.ipAddress, instantiateNsRequestInterface.ipAddress) &&
        Objects.equals(this.macAddress, instantiateNsRequestInterface.macAddress) &&
        Objects.equals(this.floatingIpRequired, instantiateNsRequestInterface.floatingIpRequired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, ipAddress, macAddress, floatingIpRequired);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstantiateNsRequestInterface {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    macAddress: ").append(toIndentedString(macAddress)).append("\n");
    sb.append("    floatingIpRequired: ").append(toIndentedString(floatingIpRequired)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
