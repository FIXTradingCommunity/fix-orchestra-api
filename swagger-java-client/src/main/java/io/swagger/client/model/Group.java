package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Annotation;
import io.swagger.client.model.Component;
import io.swagger.client.model.EntityAttributes;
import io.swagger.client.model.MessageElements;
import io.swagger.client.model.ObjectId;

/**
 * Group
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-27T18:19:20.110Z")
public class Group extends Component {
  @SerializedName("numInGroupId")
  private Integer numInGroupId = null;

  @SerializedName("numInGroupName")
  private String numInGroupName = null;

  @SerializedName("implMinOccurs")
  private Integer implMinOccurs = null;

  @SerializedName("implMaxOccurs")
  private Integer implMaxOccurs = null;

  public Group numInGroupId(Integer numInGroupId) {
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

  public Group numInGroupName(String numInGroupName) {
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

  public Group implMinOccurs(Integer implMinOccurs) {
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

  public Group implMaxOccurs(Integer implMaxOccurs) {
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
    Group group = (Group) o;
    return Objects.equals(this.numInGroupId, group.numInGroupId) &&
        Objects.equals(this.numInGroupName, group.numInGroupName) &&
        Objects.equals(this.implMinOccurs, group.implMinOccurs) &&
        Objects.equals(this.implMaxOccurs, group.implMaxOccurs) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numInGroupId, numInGroupName, implMinOccurs, implMaxOccurs, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

