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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * InstantiateNsRequestAdditionalParamsForKdu
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T13:48:18.253Z[GMT]")
public class InstantiateNsRequestAdditionalParamsForKdu {
  @SerializedName("kdu_name")
  private String kduName = null;




  @SerializedName("k8s-namespace")
  private String k8sNamespace = null;

  @SerializedName("kdu_model")
  private String kduModel = null;

  @SerializedName("additionalParams")
  private Map<String, Object> additionalParams = null;

  public InstantiateNsRequestAdditionalParamsForKdu kduName(String kduName) {
    this.kduName = kduName;
    return this;
  }

   /**
   * Get kduName
   * @return kduName
  **/
  @Schema(required = true, description = "")
  public String getKduName() {
    return kduName;
  }

  public void setKduName(String kduName) {
    this.kduName = kduName;
  }

  public InstantiateNsRequestAdditionalParamsForKdu k8sNamespace(String k8sNamespace) {
    this.k8sNamespace = k8sNamespace;
    return this;
  }

   /**
   * use this namespace for this KDU
   * @return k8sNamespace
  **/
  @Schema(description = "use this namespace for this KDU")
  public String getK8sNamespace() {
    return k8sNamespace;
  }

  public void setK8sNamespace(String k8sNamespace) {
    this.k8sNamespace = k8sNamespace;
  }

  public InstantiateNsRequestAdditionalParamsForKdu kduModel(String kduModel) {
    this.kduModel = kduModel;
    return this;
  }

   /**
   * Get kduModel
   * @return kduModel
  **/
  @Schema(description = "")
  public String getKduModel() {
    return kduModel;
  }

  public void setKduModel(String kduModel) {
    this.kduModel = kduModel;
  }

  public InstantiateNsRequestAdditionalParamsForKdu additionalParams(Map<String, Object> additionalParams) {
    this.additionalParams = additionalParams;
    return this;
  }

  public InstantiateNsRequestAdditionalParamsForKdu putAdditionalParamsItem(String key, Object additionalParamsItem) {
    if (this.additionalParams == null) {
      this.additionalParams = new HashMap<String, Object>();
    }
    this.additionalParams.put(key, additionalParamsItem);
    return this;
  }

   /**
   * Get additionalParams
   * @return additionalParams
  **/
  @Schema(description = "")
  public Map<String, Object> getAdditionalParams() {
    return additionalParams;
  }

  public void setAdditionalParams(Map<String, Object> additionalParams) {
    this.additionalParams = additionalParams;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstantiateNsRequestAdditionalParamsForKdu instantiateNsRequestAdditionalParamsForKdu = (InstantiateNsRequestAdditionalParamsForKdu) o;
    return Objects.equals(this.kduName, instantiateNsRequestAdditionalParamsForKdu.kduName) &&
        Objects.equals(this.k8sNamespace, instantiateNsRequestAdditionalParamsForKdu.k8sNamespace) &&
        Objects.equals(this.kduModel, instantiateNsRequestAdditionalParamsForKdu.kduModel) &&
        Objects.equals(this.additionalParams, instantiateNsRequestAdditionalParamsForKdu.additionalParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kduName, k8sNamespace, kduModel, additionalParams);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstantiateNsRequestAdditionalParamsForKdu {\n");

    sb.append("    kduName: ").append(toIndentedString(kduName)).append("\n");
    sb.append("    k8sNamespace: ").append(toIndentedString(k8sNamespace)).append("\n");
    sb.append("    kduModel: ").append(toIndentedString(kduModel)).append("\n");
    sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
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
