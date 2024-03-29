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
 * Nslcmsubschema
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-03-04T13:48:18.253Z[GMT]")
public class Nslcmsubschema {
  @SerializedName("nsInstanceSubscriptionFilter")
  private NsInstanceSubscriptionFilter nsInstanceSubscriptionFilter = null;

  /**
   * Gets or Sets notificationTypes
   */
  @JsonAdapter(NotificationTypesEnum.Adapter.class)
  public enum NotificationTypesEnum {
    NSIDENTIFIERCREATIONNOTIFICATION("NsIdentifierCreationNotification"),
    NSIDENTIFIERDELETIONNOTIFICATION("NsIdentifierDeletionNotification"),
    NSLCMOPERATIONOCCURRENCENOTIFICATION("NsLcmOperationOccurrenceNotification"),
    NSCHANGENOTIFICATION("NsChangeNotification");

    private String value;

    NotificationTypesEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static NotificationTypesEnum fromValue(String input) {
      for (NotificationTypesEnum b : NotificationTypesEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<NotificationTypesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final NotificationTypesEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public NotificationTypesEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return NotificationTypesEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("notificationTypes")
  private List<NotificationTypesEnum> notificationTypes = null;

  /**
   * Gets or Sets operationTypes
   */
  @JsonAdapter(OperationTypesEnum.Adapter.class)
  public enum OperationTypesEnum {
    INSTANTIATE("INSTANTIATE"),
    SCALE("SCALE"),
    TERMINATE("TERMINATE"),
    UPDATE("UPDATE"),
    HEAL("HEAL");

    private String value;

    OperationTypesEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static OperationTypesEnum fromValue(String input) {
      for (OperationTypesEnum b : OperationTypesEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<OperationTypesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OperationTypesEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public OperationTypesEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return OperationTypesEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("operationTypes")
  private List<OperationTypesEnum> operationTypes = null;

  /**
   * Gets or Sets operationStates
   */
  @JsonAdapter(OperationStatesEnum.Adapter.class)
  public enum OperationStatesEnum {
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED"),
    PARTIALLY_COMPLETED("PARTIALLY_COMPLETED"),
    FAILED("FAILED"),
    FAILED_TEMP("FAILED_TEMP"),
    ROLLING_BACK("ROLLING_BACK"),
    ROLLED_BACK("ROLLED_BACK");

    private String value;

    OperationStatesEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static OperationStatesEnum fromValue(String input) {
      for (OperationStatesEnum b : OperationStatesEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<OperationStatesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OperationStatesEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public OperationStatesEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return OperationStatesEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("operationStates")
  private List<OperationStatesEnum> operationStates = null;

  /**
   * Gets or Sets nsComponentTypes
   */
  @JsonAdapter(NsComponentTypesEnum.Adapter.class)
  public enum NsComponentTypesEnum {
    VNF("VNF"),
    NS("NS"),
    PNF("PNF");

    private String value;

    NsComponentTypesEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static NsComponentTypesEnum fromValue(String input) {
      for (NsComponentTypesEnum b : NsComponentTypesEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<NsComponentTypesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final NsComponentTypesEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public NsComponentTypesEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return NsComponentTypesEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("nsComponentTypes")
  private List<NsComponentTypesEnum> nsComponentTypes = null;

  /**
   * Gets or Sets lcmOpNameImpactingNsComponent
   */
  @JsonAdapter(LcmOpNameImpactingNsComponentEnum.Adapter.class)
  public enum LcmOpNameImpactingNsComponentEnum {
    VNF_INSTANTIATE("VNF_INSTANTIATE"),
    VNF_SCALE("VNF_SCALE"),
    VNF_SCALE_TO_LEVEL("VNF_SCALE_TO_LEVEL"),
    VNF_CHANGE_FLAVOUR("VNF_CHANGE_FLAVOUR"),
    VNF_TERMINATE("VNF_TERMINATE"),
    VNF_HEAL("VNF_HEAL"),
    VNF_OPERATE("VNF_OPERATE"),
    VNF_CHANGE_EXT_CONN("VNF_CHANGE_EXT_CONN"),
    VNF_MODIFY_INFO("VNF_MODIFY_INFO"),
    NS_INSTANTIATE("NS_INSTANTIATE"),
    NS_SCALE("NS_SCALE"),
    NS_UPDATE("NS_UPDATE"),
    NS_TERMINATE("NS_TERMINATE"),
    NS_HEAL("NS_HEAL");

    private String value;

    LcmOpNameImpactingNsComponentEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static LcmOpNameImpactingNsComponentEnum fromValue(String input) {
      for (LcmOpNameImpactingNsComponentEnum b : LcmOpNameImpactingNsComponentEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<LcmOpNameImpactingNsComponentEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LcmOpNameImpactingNsComponentEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public LcmOpNameImpactingNsComponentEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return LcmOpNameImpactingNsComponentEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("lcmOpNameImpactingNsComponent")
  private List<LcmOpNameImpactingNsComponentEnum> lcmOpNameImpactingNsComponent = null;

  /**
   * Gets or Sets lcmOpOccStatusImpactingNsComponent
   */
  @JsonAdapter(LcmOpOccStatusImpactingNsComponentEnum.Adapter.class)
  public enum LcmOpOccStatusImpactingNsComponentEnum {
    START("START"),
    COMPLETED("COMPLETED"),
    PARTIALLY_COMPLETED("PARTIALLY_COMPLETED"),
    FAILED("FAILED"),
    ROLLED_BACK("ROLLED_BACK");

    private String value;

    LcmOpOccStatusImpactingNsComponentEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static LcmOpOccStatusImpactingNsComponentEnum fromValue(String input) {
      for (LcmOpOccStatusImpactingNsComponentEnum b : LcmOpOccStatusImpactingNsComponentEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<LcmOpOccStatusImpactingNsComponentEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LcmOpOccStatusImpactingNsComponentEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public LcmOpOccStatusImpactingNsComponentEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return LcmOpOccStatusImpactingNsComponentEnum.fromValue((String)(value));
      }
    }
  }  @SerializedName("lcmOpOccStatusImpactingNsComponent")
  private List<LcmOpOccStatusImpactingNsComponentEnum> lcmOpOccStatusImpactingNsComponent = null;

  public Nslcmsubschema nsInstanceSubscriptionFilter(NsInstanceSubscriptionFilter nsInstanceSubscriptionFilter) {
    this.nsInstanceSubscriptionFilter = nsInstanceSubscriptionFilter;
    return this;
  }

   /**
   * Get nsInstanceSubscriptionFilter
   * @return nsInstanceSubscriptionFilter
  **/
  @Schema(description = "")
  public NsInstanceSubscriptionFilter getNsInstanceSubscriptionFilter() {
    return nsInstanceSubscriptionFilter;
  }

  public void setNsInstanceSubscriptionFilter(NsInstanceSubscriptionFilter nsInstanceSubscriptionFilter) {
    this.nsInstanceSubscriptionFilter = nsInstanceSubscriptionFilter;
  }

  public Nslcmsubschema notificationTypes(List<NotificationTypesEnum> notificationTypes) {
    this.notificationTypes = notificationTypes;
    return this;
  }

  public Nslcmsubschema addNotificationTypesItem(NotificationTypesEnum notificationTypesItem) {
    if (this.notificationTypes == null) {
      this.notificationTypes = new ArrayList<NotificationTypesEnum>();
    }
    this.notificationTypes.add(notificationTypesItem);
    return this;
  }

   /**
   * If NsLcmOperationOccurrenceNotification is selected then at least operationTypes or states is required. If NsLcmOperationOccurrenceNotification is selected then at least nsComponentTypes, lcmOpName and lcmOpOccStatus is required 
   * @return notificationTypes
  **/
  @Schema(description = "If NsLcmOperationOccurrenceNotification is selected then at least operationTypes or states is required. If NsLcmOperationOccurrenceNotification is selected then at least nsComponentTypes, lcmOpName and lcmOpOccStatus is required ")
  public List<NotificationTypesEnum> getNotificationTypes() {
    return notificationTypes;
  }

  public void setNotificationTypes(List<NotificationTypesEnum> notificationTypes) {
    this.notificationTypes = notificationTypes;
  }

  public Nslcmsubschema operationTypes(List<OperationTypesEnum> operationTypes) {
    this.operationTypes = operationTypes;
    return this;
  }

  public Nslcmsubschema addOperationTypesItem(OperationTypesEnum operationTypesItem) {
    if (this.operationTypes == null) {
      this.operationTypes = new ArrayList<OperationTypesEnum>();
    }
    this.operationTypes.add(operationTypesItem);
    return this;
  }

   /**
   * Get operationTypes
   * @return operationTypes
  **/
  @Schema(description = "")
  public List<OperationTypesEnum> getOperationTypes() {
    return operationTypes;
  }

  public void setOperationTypes(List<OperationTypesEnum> operationTypes) {
    this.operationTypes = operationTypes;
  }

  public Nslcmsubschema operationStates(List<OperationStatesEnum> operationStates) {
    this.operationStates = operationStates;
    return this;
  }

  public Nslcmsubschema addOperationStatesItem(OperationStatesEnum operationStatesItem) {
    if (this.operationStates == null) {
      this.operationStates = new ArrayList<OperationStatesEnum>();
    }
    this.operationStates.add(operationStatesItem);
    return this;
  }

   /**
   * Get operationStates
   * @return operationStates
  **/
  @Schema(description = "")
  public List<OperationStatesEnum> getOperationStates() {
    return operationStates;
  }

  public void setOperationStates(List<OperationStatesEnum> operationStates) {
    this.operationStates = operationStates;
  }

  public Nslcmsubschema nsComponentTypes(List<NsComponentTypesEnum> nsComponentTypes) {
    this.nsComponentTypes = nsComponentTypes;
    return this;
  }

  public Nslcmsubschema addNsComponentTypesItem(NsComponentTypesEnum nsComponentTypesItem) {
    if (this.nsComponentTypes == null) {
      this.nsComponentTypes = new ArrayList<NsComponentTypesEnum>();
    }
    this.nsComponentTypes.add(nsComponentTypesItem);
    return this;
  }

   /**
   * Get nsComponentTypes
   * @return nsComponentTypes
  **/
  @Schema(description = "")
  public List<NsComponentTypesEnum> getNsComponentTypes() {
    return nsComponentTypes;
  }

  public void setNsComponentTypes(List<NsComponentTypesEnum> nsComponentTypes) {
    this.nsComponentTypes = nsComponentTypes;
  }

  public Nslcmsubschema lcmOpNameImpactingNsComponent(List<LcmOpNameImpactingNsComponentEnum> lcmOpNameImpactingNsComponent) {
    this.lcmOpNameImpactingNsComponent = lcmOpNameImpactingNsComponent;
    return this;
  }

  public Nslcmsubschema addLcmOpNameImpactingNsComponentItem(LcmOpNameImpactingNsComponentEnum lcmOpNameImpactingNsComponentItem) {
    if (this.lcmOpNameImpactingNsComponent == null) {
      this.lcmOpNameImpactingNsComponent = new ArrayList<LcmOpNameImpactingNsComponentEnum>();
    }
    this.lcmOpNameImpactingNsComponent.add(lcmOpNameImpactingNsComponentItem);
    return this;
  }

   /**
   * Get lcmOpNameImpactingNsComponent
   * @return lcmOpNameImpactingNsComponent
  **/
  @Schema(description = "")
  public List<LcmOpNameImpactingNsComponentEnum> getLcmOpNameImpactingNsComponent() {
    return lcmOpNameImpactingNsComponent;
  }

  public void setLcmOpNameImpactingNsComponent(List<LcmOpNameImpactingNsComponentEnum> lcmOpNameImpactingNsComponent) {
    this.lcmOpNameImpactingNsComponent = lcmOpNameImpactingNsComponent;
  }

  public Nslcmsubschema lcmOpOccStatusImpactingNsComponent(List<LcmOpOccStatusImpactingNsComponentEnum> lcmOpOccStatusImpactingNsComponent) {
    this.lcmOpOccStatusImpactingNsComponent = lcmOpOccStatusImpactingNsComponent;
    return this;
  }

  public Nslcmsubschema addLcmOpOccStatusImpactingNsComponentItem(LcmOpOccStatusImpactingNsComponentEnum lcmOpOccStatusImpactingNsComponentItem) {
    if (this.lcmOpOccStatusImpactingNsComponent == null) {
      this.lcmOpOccStatusImpactingNsComponent = new ArrayList<LcmOpOccStatusImpactingNsComponentEnum>();
    }
    this.lcmOpOccStatusImpactingNsComponent.add(lcmOpOccStatusImpactingNsComponentItem);
    return this;
  }

   /**
   * Get lcmOpOccStatusImpactingNsComponent
   * @return lcmOpOccStatusImpactingNsComponent
  **/
  @Schema(description = "")
  public List<LcmOpOccStatusImpactingNsComponentEnum> getLcmOpOccStatusImpactingNsComponent() {
    return lcmOpOccStatusImpactingNsComponent;
  }

  public void setLcmOpOccStatusImpactingNsComponent(List<LcmOpOccStatusImpactingNsComponentEnum> lcmOpOccStatusImpactingNsComponent) {
    this.lcmOpOccStatusImpactingNsComponent = lcmOpOccStatusImpactingNsComponent;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Nslcmsubschema nslcmsubschema = (Nslcmsubschema) o;
    return Objects.equals(this.nsInstanceSubscriptionFilter, nslcmsubschema.nsInstanceSubscriptionFilter) &&
        Objects.equals(this.notificationTypes, nslcmsubschema.notificationTypes) &&
        Objects.equals(this.operationTypes, nslcmsubschema.operationTypes) &&
        Objects.equals(this.operationStates, nslcmsubschema.operationStates) &&
        Objects.equals(this.nsComponentTypes, nslcmsubschema.nsComponentTypes) &&
        Objects.equals(this.lcmOpNameImpactingNsComponent, nslcmsubschema.lcmOpNameImpactingNsComponent) &&
        Objects.equals(this.lcmOpOccStatusImpactingNsComponent, nslcmsubschema.lcmOpOccStatusImpactingNsComponent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nsInstanceSubscriptionFilter, notificationTypes, operationTypes, operationStates, nsComponentTypes, lcmOpNameImpactingNsComponent, lcmOpOccStatusImpactingNsComponent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Nslcmsubschema {\n");
    
    sb.append("    nsInstanceSubscriptionFilter: ").append(toIndentedString(nsInstanceSubscriptionFilter)).append("\n");
    sb.append("    notificationTypes: ").append(toIndentedString(notificationTypes)).append("\n");
    sb.append("    operationTypes: ").append(toIndentedString(operationTypes)).append("\n");
    sb.append("    operationStates: ").append(toIndentedString(operationStates)).append("\n");
    sb.append("    nsComponentTypes: ").append(toIndentedString(nsComponentTypes)).append("\n");
    sb.append("    lcmOpNameImpactingNsComponent: ").append(toIndentedString(lcmOpNameImpactingNsComponent)).append("\n");
    sb.append("    lcmOpOccStatusImpactingNsComponent: ").append(toIndentedString(lcmOpOccStatusImpactingNsComponent)).append("\n");
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
