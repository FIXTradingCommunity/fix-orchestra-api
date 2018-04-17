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
import io.fixprotocol.orchestra.model.Annotation;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.EntityAttributes;
import io.fixprotocol.orchestra.model.GroupProperties;
import io.fixprotocol.orchestra.model.ObjectId;
import io.fixprotocol.orchestra.model.Structure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * Group
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-17T14:14:51.195Z")
public class Group extends Component  {
  @JsonProperty("groupProperties")
  private GroupProperties groupProperties = null;

  public Group groupProperties(GroupProperties groupProperties) {
    this.groupProperties = groupProperties;
    return this;
  }

  /**
   * Get groupProperties
   * @return groupProperties
   **/
  @JsonProperty("groupProperties")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public GroupProperties getGroupProperties() {
    return groupProperties;
  }

  public void setGroupProperties(GroupProperties groupProperties) {
    this.groupProperties = groupProperties;
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
    return Objects.equals(this.groupProperties, group.groupProperties) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupProperties, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    groupProperties: ").append(toIndentedString(groupProperties)).append("\n");
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

