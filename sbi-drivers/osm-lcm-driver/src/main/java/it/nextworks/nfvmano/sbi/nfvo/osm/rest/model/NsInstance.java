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

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/**
 * NS Instance Information Only generic fields (_id, id, name, description) are described For a full specification of the NS Instance see: http://osm-download.etsi.org/ftp/osm-doc/nsr.html 
 */
@Schema(description = "NS Instance Information Only generic fields (_id, id, name, description) are described For a full specification of the NS Instance see: http://osm-download.etsi.org/ftp/osm-doc/nsr.html ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T13:48:18.253Z[GMT]")
public class NsInstance {
  @SerializedName("_id")
  private UUID _id = null;

  @SerializedName("id")
  private UUID id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("constituent-vnfr-ref")
  private ArrayList<String> constituentVnfrRef;
  public NsInstance _id(UUID _id) {
    this._id = _id;
    return this;
  }

   /**
   * Identifier of the NS instance.
   * @return _id
  **/
  @Schema(required = true, description = "Identifier of the NS instance.")
  public UUID getId() {
    return _id;
  }

  public void setId(UUID _id) {
    this._id = _id;
  }

  public NsInstance id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Identifier of the NS instance.
   * @return id
  **/
  @Schema(required = true, description = "Identifier of the NS instance.")
  public UUID getIdentifier() {
    return id;
  }

  public void setIdentifier(UUID id) {
    this.id = id;
  }

  public NsInstance name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Human readable name of the NS instance.
   * @return name
  **/
  @Schema(required = true, description = "Human readable name of the NS instance.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NsInstance description(String description) {
    this.description = description;
    return this;
  }

  public ArrayList<String> getConstituentVnfrRef() {
    return constituentVnfrRef;
  }

  public void setConstituentVnfrRef(ArrayList<String> constituentVnfrRef) {
    this.constituentVnfrRef = constituentVnfrRef;
  }

  /**
   * Human readable description of the NS instance.
   * @return description
  **/
  @Schema(description = "Human readable description of the NS instance.")
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
    NsInstance nsInstance = (NsInstance) o;
    return Objects.equals(this._id, nsInstance._id) &&
        Objects.equals(this.id, nsInstance.id) &&
        Objects.equals(this.name, nsInstance.name) &&
        Objects.equals(this.description, nsInstance.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, id, name, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstance {\n");
    
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
