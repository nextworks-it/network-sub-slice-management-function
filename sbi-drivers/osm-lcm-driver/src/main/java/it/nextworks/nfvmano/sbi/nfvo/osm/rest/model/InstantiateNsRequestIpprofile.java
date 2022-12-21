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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InstantiateNsRequestIpprofile
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T13:48:18.253Z[GMT]")
public class InstantiateNsRequestIpprofile {
  /**
   * Gets or Sets ipVersion
   */
  @JsonAdapter(IpVersionEnum.Adapter.class)
  public enum IpVersionEnum {
    IPV4("ipv4"),
    IPV6("ipv6");

    private String value;

    IpVersionEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static IpVersionEnum fromValue(String input) {
      for (IpVersionEnum b : IpVersionEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<IpVersionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final IpVersionEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public IpVersionEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return IpVersionEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("ip-version")
  private IpVersionEnum ipVersion = null;

  @SerializedName("subnet-address")
  private String subnetAddress = null;

  @SerializedName("gateway-address")
  private String gatewayAddress = null;

  @SerializedName("dns-server")
  private List<InstantiateNsRequestIpprofileDnsserver> dnsServer = null;

  @SerializedName("dhcp-params")
  private InstantiateNsRequestIpprofileDhcpparams dhcpParams = null;

  public InstantiateNsRequestIpprofile ipVersion(IpVersionEnum ipVersion) {
    this.ipVersion = ipVersion;
    return this;
  }

   /**
   * Get ipVersion
   * @return ipVersion
  **/
  @Schema(description = "")
  public IpVersionEnum getIpVersion() {
    return ipVersion;
  }

  public void setIpVersion(IpVersionEnum ipVersion) {
    this.ipVersion = ipVersion;
  }

  public InstantiateNsRequestIpprofile subnetAddress(String subnetAddress) {
    this.subnetAddress = subnetAddress;
    return this;
  }

   /**
   * Get subnetAddress
   * @return subnetAddress
  **/
  @Schema(description = "")
  public String getSubnetAddress() {
    return subnetAddress;
  }

  public void setSubnetAddress(String subnetAddress) {
    this.subnetAddress = subnetAddress;
  }

  public InstantiateNsRequestIpprofile gatewayAddress(String gatewayAddress) {
    this.gatewayAddress = gatewayAddress;
    return this;
  }

   /**
   * Get gatewayAddress
   * @return gatewayAddress
  **/
  @Schema(description = "")
  public String getGatewayAddress() {
    return gatewayAddress;
  }

  public void setGatewayAddress(String gatewayAddress) {
    this.gatewayAddress = gatewayAddress;
  }

  public InstantiateNsRequestIpprofile dnsServer(List<InstantiateNsRequestIpprofileDnsserver> dnsServer) {
    this.dnsServer = dnsServer;
    return this;
  }

  public InstantiateNsRequestIpprofile addDnsServerItem(InstantiateNsRequestIpprofileDnsserver dnsServerItem) {
    if (this.dnsServer == null) {
      this.dnsServer = new ArrayList<InstantiateNsRequestIpprofileDnsserver>();
    }
    this.dnsServer.add(dnsServerItem);
    return this;
  }

   /**
   * Get dnsServer
   * @return dnsServer
  **/
  @Schema(description = "")
  public List<InstantiateNsRequestIpprofileDnsserver> getDnsServer() {
    return dnsServer;
  }

  public void setDnsServer(List<InstantiateNsRequestIpprofileDnsserver> dnsServer) {
    this.dnsServer = dnsServer;
  }

  public InstantiateNsRequestIpprofile dhcpParams(InstantiateNsRequestIpprofileDhcpparams dhcpParams) {
    this.dhcpParams = dhcpParams;
    return this;
  }

   /**
   * Get dhcpParams
   * @return dhcpParams
  **/
  @Schema(description = "")
  public InstantiateNsRequestIpprofileDhcpparams getDhcpParams() {
    return dhcpParams;
  }

  public void setDhcpParams(InstantiateNsRequestIpprofileDhcpparams dhcpParams) {
    this.dhcpParams = dhcpParams;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstantiateNsRequestIpprofile instantiateNsRequestIpprofile = (InstantiateNsRequestIpprofile) o;
    return Objects.equals(this.ipVersion, instantiateNsRequestIpprofile.ipVersion) &&
        Objects.equals(this.subnetAddress, instantiateNsRequestIpprofile.subnetAddress) &&
        Objects.equals(this.gatewayAddress, instantiateNsRequestIpprofile.gatewayAddress) &&
        Objects.equals(this.dnsServer, instantiateNsRequestIpprofile.dnsServer) &&
        Objects.equals(this.dhcpParams, instantiateNsRequestIpprofile.dhcpParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipVersion, subnetAddress, gatewayAddress, dnsServer, dhcpParams);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstantiateNsRequestIpprofile {\n");
    
    sb.append("    ipVersion: ").append(toIndentedString(ipVersion)).append("\n");
    sb.append("    subnetAddress: ").append(toIndentedString(subnetAddress)).append("\n");
    sb.append("    gatewayAddress: ").append(toIndentedString(gatewayAddress)).append("\n");
    sb.append("    dnsServer: ").append(toIndentedString(dnsServer)).append("\n");
    sb.append("    dhcpParams: ").append(toIndentedString(dhcpParams)).append("\n");
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
