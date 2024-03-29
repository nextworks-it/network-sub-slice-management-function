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
import java.util.UUID;

/**
 * CreateNSinstanceContentResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T13:48:18.253Z[GMT]")
public class CreateNetworkSliceInstanceContentResponse {
  @SerializedName("id")
  private UUID id = null;

  @SerializedName("nslcmop_id")
  private UUID nslcmopId = null;

  public CreateNetworkSliceInstanceContentResponse id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public CreateNetworkSliceInstanceContentResponse nslcmopId(UUID nslcmopId) {
    this.nslcmopId = nslcmopId;
    return this;
  }

   /**
   * Get nslcmopId
   * @return nslcmopId
  **/
  @Schema(description = "")
  public UUID getNslcmopId() {
    return nslcmopId;
  }

  public void setNslcmopId(UUID nslcmopId) {
    this.nslcmopId = nslcmopId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateNetworkSliceInstanceContentResponse createNSinstanceContentResponse = (CreateNetworkSliceInstanceContentResponse) o;
    return Objects.equals(this.id, createNSinstanceContentResponse.id) &&
        Objects.equals(this.nslcmopId, createNSinstanceContentResponse.nslcmopId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nslcmopId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateNSinstanceContentResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nslcmopId: ").append(toIndentedString(nslcmopId)).append("\n");
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
