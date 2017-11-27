/*
 * Orchestra API
 * API to edit FIX Orchestra (machine readable rules of engagement) specification version 1.0 RC3
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.fixprotocol.orchestra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * GroupProperties
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T16:52:01.174Z")
public class GroupProperties   {
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

