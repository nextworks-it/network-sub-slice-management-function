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
 * ScaleNsRequestScaleVnfDataScaleByStepData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T13:48:18.253Z[GMT]")
public class ScaleNsRequestScaleVnfDataScaleByStepData {
  @SerializedName("scaling-group-descriptor")
  private String scalingGroupDescriptor = null;

  @SerializedName("scaling-policy")
  private String scalingPolicy = null;

  @SerializedName("member-vnf-index")
  private String memberVnfIndex = null;

  public ScaleNsRequestScaleVnfDataScaleByStepData scalingGroupDescriptor(String scalingGroupDescriptor) {
    this.scalingGroupDescriptor = scalingGroupDescriptor;
    return this;
  }

   /**
   * Get scalingGroupDescriptor
   * @return scalingGroupDescriptor
  **/
  @Schema(required = true, description = "")
  public String getScalingGroupDescriptor() {
    return scalingGroupDescriptor;
  }

  public void setScalingGroupDescriptor(String scalingGroupDescriptor) {
    this.scalingGroupDescriptor = scalingGroupDescriptor;
  }

  public ScaleNsRequestScaleVnfDataScaleByStepData scalingPolicy(String scalingPolicy) {
    this.scalingPolicy = scalingPolicy;
    return this;
  }

   /**
   * Get scalingPolicy
   * @return scalingPolicy
  **/
  @Schema(description = "")
  public String getScalingPolicy() {
    return scalingPolicy;
  }

  public void setScalingPolicy(String scalingPolicy) {
    this.scalingPolicy = scalingPolicy;
  }

  public ScaleNsRequestScaleVnfDataScaleByStepData memberVnfIndex(String memberVnfIndex) {
    this.memberVnfIndex = memberVnfIndex;
    return this;
  }

   /**
   * Get memberVnfIndex
   * @return memberVnfIndex
  **/
  @Schema(required = true, description = "")
  public String getMemberVnfIndex() {
    return memberVnfIndex;
  }

  public void setMemberVnfIndex(String memberVnfIndex) {
    this.memberVnfIndex = memberVnfIndex;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScaleNsRequestScaleVnfDataScaleByStepData scaleNsRequestScaleVnfDataScaleByStepData = (ScaleNsRequestScaleVnfDataScaleByStepData) o;
    return Objects.equals(this.scalingGroupDescriptor, scaleNsRequestScaleVnfDataScaleByStepData.scalingGroupDescriptor) &&
        Objects.equals(this.scalingPolicy, scaleNsRequestScaleVnfDataScaleByStepData.scalingPolicy) &&
        Objects.equals(this.memberVnfIndex, scaleNsRequestScaleVnfDataScaleByStepData.memberVnfIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scalingGroupDescriptor, scalingPolicy, memberVnfIndex);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScaleNsRequestScaleVnfDataScaleByStepData {\n");
    
    sb.append("    scalingGroupDescriptor: ").append(toIndentedString(scalingGroupDescriptor)).append("\n");
    sb.append("    scalingPolicy: ").append(toIndentedString(scalingPolicy)).append("\n");
    sb.append("    memberVnfIndex: ").append(toIndentedString(memberVnfIndex)).append("\n");
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
