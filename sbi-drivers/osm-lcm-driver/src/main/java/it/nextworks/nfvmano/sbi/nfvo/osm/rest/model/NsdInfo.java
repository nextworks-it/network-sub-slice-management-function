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
 * NS Descriptor Information Only generic fields (_id, id, name, description) are described For a full specification of the NS Descriptor see: http://osm-download.etsi.org/ftp/osm-doc/nsd.html 
 */
@Schema(description = "NS Descriptor Information Only generic fields (_id, id, name, description) are described For a full specification of the NS Descriptor see: http://osm-download.etsi.org/ftp/osm-doc/nsd.html ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T13:48:18.253Z[GMT]")
public class NsdInfo {
  @SerializedName("_id")
  private UUID _id = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  public NsdInfo _id(UUID _id) {
    this._id = _id;
    return this;
  }

   /**
   * Identifier of the onboarded individual NS descriptor resource. This identifier is allocated by the NFVO. 
   * @return _id
  **/
  @Schema(required = true, description = "Identifier of the onboarded individual NS descriptor resource. This identifier is allocated by the NFVO. ")
  public UUID getId() {
    return _id;
  }

  public void setId(UUID _id) {
    this._id = _id;
  }

  public NsdInfo id(String id) {
    this.id = id;
    return this;
  }

   /**
   * This identifier, which is allocated by the NSD designer, identifies the NSD in a globally unique way. It is copied from the NSD content and shall be present after the NSD content is on-boarded. 
   * @return id
  **/
  @Schema(required = true, description = "This identifier, which is allocated by the NSD designer, identifies the NSD in a globally unique way. It is copied from the NSD content and shall be present after the NSD content is on-boarded. ")
  public String getIdentifier() {
    return id;
  }

  public void setIdentifier(String id) {
    this.id = id;
  }

  public NsdInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the onboarded NSD. This information is copied from the NSD content and shall be present after the NSD content is on-boarded. 
   * @return name
  **/
  @Schema(description = "Name of the onboarded NSD. This information is copied from the NSD content and shall be present after the NSD content is on-boarded. ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NsdInfo description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the onboarded NSD. This information is copied from the NSD content. 
   * @return description
  **/
  @Schema(description = "Description of the onboarded NSD. This information is copied from the NSD content. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsdInfo nsdInfo = (NsdInfo) o;
    return Objects.equals(this._id, nsdInfo._id) &&
        Objects.equals(this.id, nsdInfo.id) &&
        Objects.equals(this.name, nsdInfo.name) &&
        Objects.equals(this.description, nsdInfo.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, id, name, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsdInfo {\n");
    
    sb.append("    _id: ").append(toIndentedString(_id)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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