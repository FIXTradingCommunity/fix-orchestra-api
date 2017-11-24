package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.Component;
import io.fixprotocol.orchestra.client.model.EntityAttributes;
import io.fixprotocol.orchestra.client.model.GroupProperties;
import io.fixprotocol.orchestra.client.model.ObjectId;
import io.fixprotocol.orchestra.client.model.Structure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Group
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-21T23:02:09.711Z")
public class Group extends Component {
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
  @ApiModelProperty(required = true, value = "")
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

