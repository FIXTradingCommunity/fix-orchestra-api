package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * GroupProperties
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-18T14:22:43.321Z")
public class GroupProperties {
  @JsonProperty("numInGroupId")
  private Integer numInGroupId = null;

  @JsonProperty("numInGroupName")
  private String numInGroupName = null;

  @JsonProperty("implMinOccurs")
  private Integer implMinOccurs = null;

  @JsonProperty("implMaxOccurs")
  private Integer implMaxOccurs = null;

  public GroupProperties numInGroupId(Integer numInGroupId) {
    this.numInGroupId = numInGroupId;
    return this;
  }

   /**
   * Get numInGroupId
   * @return numInGroupId
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getNumInGroupId() {
    return numInGroupId;
  }

  public void setNumInGroupId(Integer numInGroupId) {
    this.numInGroupId = numInGroupId;
  }

  public GroupProperties numInGroupName(String numInGroupName) {
    this.numInGroupName = numInGroupName;
    return this;
  }

   /**
   * Get numInGroupName
   * @return numInGroupName
  **/
  @ApiModelProperty(required = true, value = "")
  public String getNumInGroupName() {
    return numInGroupName;
  }

  public void setNumInGroupName(String numInGroupName) {
    this.numInGroupName = numInGroupName;
  }

  public GroupProperties implMinOccurs(Integer implMinOccurs) {
    this.implMinOccurs = implMinOccurs;
    return this;
  }

   /**
   * Get implMinOccurs
   * @return implMinOccurs
  **/
  @ApiModelProperty(value = "")
  public Integer getImplMinOccurs() {
    return implMinOccurs;
  }

  public void setImplMinOccurs(Integer implMinOccurs) {
    this.implMinOccurs = implMinOccurs;
  }

  public GroupProperties implMaxOccurs(Integer implMaxOccurs) {
    this.implMaxOccurs = implMaxOccurs;
    return this;
  }

   /**
   * Get implMaxOccurs
   * @return implMaxOccurs
  **/
  @ApiModelProperty(value = "")
  public Integer getImplMaxOccurs() {
    return implMaxOccurs;
  }

  public void setImplMaxOccurs(Integer implMaxOccurs) {
    this.implMaxOccurs = implMaxOccurs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupProperties groupProperties = (GroupProperties) o;
    return Objects.equals(this.numInGroupId, groupProperties.numInGroupId) &&
        Objects.equals(this.numInGroupName, groupProperties.numInGroupName) &&
        Objects.equals(this.implMinOccurs, groupProperties.implMinOccurs) &&
        Objects.equals(this.implMaxOccurs, groupProperties.implMaxOccurs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numInGroupId, numInGroupName, implMinOccurs, implMaxOccurs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupProperties {\n");
    
    sb.append("    numInGroupId: ").append(toIndentedString(numInGroupId)).append("\n");
    sb.append("    numInGroupName: ").append(toIndentedString(numInGroupName)).append("\n");
    sb.append("    implMinOccurs: ").append(toIndentedString(implMinOccurs)).append("\n");
    sb.append("    implMaxOccurs: ").append(toIndentedString(implMaxOccurs)).append("\n");
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

