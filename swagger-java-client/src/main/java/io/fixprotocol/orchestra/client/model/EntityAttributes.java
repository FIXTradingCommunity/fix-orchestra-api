package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * element metadata including pedigree
 */
@ApiModel(description = "element metadata including pedigree")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-20T19:56:10.305Z")
public class EntityAttributes {
  @JsonProperty("added")
  private String added = null;

  @JsonProperty("addedEP")
  private Integer addedEP = null;

  /**
   * Gets or Sets changeType
   */
  public enum ChangeTypeEnum {
    EDITORIAL("Editorial"),
    
    DEFINITIONAL("Definitional");

    private String value;

    ChangeTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ChangeTypeEnum fromValue(String text) {
      for (ChangeTypeEnum b : ChangeTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("changeType")
  private ChangeTypeEnum changeType = null;

  @JsonProperty("deprecated")
  private String deprecated = null;

  @JsonProperty("deprecatedEP")
  private Integer deprecatedEP = null;

  @JsonProperty("issue")
  private String issue = null;

  @JsonProperty("lastModified")
  private String lastModified = null;

  @JsonProperty("replaced")
  private String replaced = null;

  @JsonProperty("replacedEP")
  private Integer replacedEP = null;

  @JsonProperty("replacedByField")
  private Integer replacedByField = null;

  /**
   * Gets or Sets supported
   */
  public enum SupportedEnum {
    SUPPORTED("supported"),
    
    FORBIDDEN("forbidden"),
    
    IGNORED("ignored");

    private String value;

    SupportedEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SupportedEnum fromValue(String text) {
      for (SupportedEnum b : SupportedEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("supported")
  private SupportedEnum supported = SupportedEnum.SUPPORTED;

  @JsonProperty("updated")
  private String updated = null;

  @JsonProperty("updatedEP")
  private Integer updatedEP = null;

  public EntityAttributes added(String added) {
    this.added = added;
    return this;
  }

   /**
   * Get added
   * @return added
  **/
  @ApiModelProperty(value = "")
  public String getAdded() {
    return added;
  }

  public void setAdded(String added) {
    this.added = added;
  }

  public EntityAttributes addedEP(Integer addedEP) {
    this.addedEP = addedEP;
    return this;
  }

   /**
   * Get addedEP
   * @return addedEP
  **/
  @ApiModelProperty(value = "")
  public Integer getAddedEP() {
    return addedEP;
  }

  public void setAddedEP(Integer addedEP) {
    this.addedEP = addedEP;
  }

  public EntityAttributes changeType(ChangeTypeEnum changeType) {
    this.changeType = changeType;
    return this;
  }

   /**
   * Get changeType
   * @return changeType
  **/
  @ApiModelProperty(value = "")
  public ChangeTypeEnum getChangeType() {
    return changeType;
  }

  public void setChangeType(ChangeTypeEnum changeType) {
    this.changeType = changeType;
  }

  public EntityAttributes deprecated(String deprecated) {
    this.deprecated = deprecated;
    return this;
  }

   /**
   * Get deprecated
   * @return deprecated
  **/
  @ApiModelProperty(value = "")
  public String getDeprecated() {
    return deprecated;
  }

  public void setDeprecated(String deprecated) {
    this.deprecated = deprecated;
  }

  public EntityAttributes deprecatedEP(Integer deprecatedEP) {
    this.deprecatedEP = deprecatedEP;
    return this;
  }

   /**
   * Get deprecatedEP
   * @return deprecatedEP
  **/
  @ApiModelProperty(value = "")
  public Integer getDeprecatedEP() {
    return deprecatedEP;
  }

  public void setDeprecatedEP(Integer deprecatedEP) {
    this.deprecatedEP = deprecatedEP;
  }

  public EntityAttributes issue(String issue) {
    this.issue = issue;
    return this;
  }

   /**
   * Get issue
   * @return issue
  **/
  @ApiModelProperty(value = "")
  public String getIssue() {
    return issue;
  }

  public void setIssue(String issue) {
    this.issue = issue;
  }

  public EntityAttributes lastModified(String lastModified) {
    this.lastModified = lastModified;
    return this;
  }

   /**
   * Get lastModified
   * @return lastModified
  **/
  @ApiModelProperty(value = "")
  public String getLastModified() {
    return lastModified;
  }

  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
  }

  public EntityAttributes replaced(String replaced) {
    this.replaced = replaced;
    return this;
  }

   /**
   * Get replaced
   * @return replaced
  **/
  @ApiModelProperty(value = "")
  public String getReplaced() {
    return replaced;
  }

  public void setReplaced(String replaced) {
    this.replaced = replaced;
  }

  public EntityAttributes replacedEP(Integer replacedEP) {
    this.replacedEP = replacedEP;
    return this;
  }

   /**
   * Get replacedEP
   * @return replacedEP
  **/
  @ApiModelProperty(value = "")
  public Integer getReplacedEP() {
    return replacedEP;
  }

  public void setReplacedEP(Integer replacedEP) {
    this.replacedEP = replacedEP;
  }

  public EntityAttributes replacedByField(Integer replacedByField) {
    this.replacedByField = replacedByField;
    return this;
  }

   /**
   * Get replacedByField
   * @return replacedByField
  **/
  @ApiModelProperty(value = "")
  public Integer getReplacedByField() {
    return replacedByField;
  }

  public void setReplacedByField(Integer replacedByField) {
    this.replacedByField = replacedByField;
  }

  public EntityAttributes supported(SupportedEnum supported) {
    this.supported = supported;
    return this;
  }

   /**
   * Get supported
   * @return supported
  **/
  @ApiModelProperty(value = "")
  public SupportedEnum getSupported() {
    return supported;
  }

  public void setSupported(SupportedEnum supported) {
    this.supported = supported;
  }

  public EntityAttributes updated(String updated) {
    this.updated = updated;
    return this;
  }

   /**
   * Get updated
   * @return updated
  **/
  @ApiModelProperty(value = "")
  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public EntityAttributes updatedEP(Integer updatedEP) {
    this.updatedEP = updatedEP;
    return this;
  }

   /**
   * Get updatedEP
   * @return updatedEP
  **/
  @ApiModelProperty(value = "")
  public Integer getUpdatedEP() {
    return updatedEP;
  }

  public void setUpdatedEP(Integer updatedEP) {
    this.updatedEP = updatedEP;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityAttributes entityAttributes = (EntityAttributes) o;
    return Objects.equals(this.added, entityAttributes.added) &&
        Objects.equals(this.addedEP, entityAttributes.addedEP) &&
        Objects.equals(this.changeType, entityAttributes.changeType) &&
        Objects.equals(this.deprecated, entityAttributes.deprecated) &&
        Objects.equals(this.deprecatedEP, entityAttributes.deprecatedEP) &&
        Objects.equals(this.issue, entityAttributes.issue) &&
        Objects.equals(this.lastModified, entityAttributes.lastModified) &&
        Objects.equals(this.replaced, entityAttributes.replaced) &&
        Objects.equals(this.replacedEP, entityAttributes.replacedEP) &&
        Objects.equals(this.replacedByField, entityAttributes.replacedByField) &&
        Objects.equals(this.supported, entityAttributes.supported) &&
        Objects.equals(this.updated, entityAttributes.updated) &&
        Objects.equals(this.updatedEP, entityAttributes.updatedEP);
  }

  @Override
  public int hashCode() {
    return Objects.hash(added, addedEP, changeType, deprecated, deprecatedEP, issue, lastModified, replaced, replacedEP, replacedByField, supported, updated, updatedEP);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityAttributes {\n");
    
    sb.append("    added: ").append(toIndentedString(added)).append("\n");
    sb.append("    addedEP: ").append(toIndentedString(addedEP)).append("\n");
    sb.append("    changeType: ").append(toIndentedString(changeType)).append("\n");
    sb.append("    deprecated: ").append(toIndentedString(deprecated)).append("\n");
    sb.append("    deprecatedEP: ").append(toIndentedString(deprecatedEP)).append("\n");
    sb.append("    issue: ").append(toIndentedString(issue)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    replaced: ").append(toIndentedString(replaced)).append("\n");
    sb.append("    replacedEP: ").append(toIndentedString(replacedEP)).append("\n");
    sb.append("    replacedByField: ").append(toIndentedString(replacedByField)).append("\n");
    sb.append("    supported: ").append(toIndentedString(supported)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
    sb.append("    updatedEP: ").append(toIndentedString(updatedEP)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

