package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.EntityAttributes;
import io.fixprotocol.orchestra.client.model.MessageElement;
import io.fixprotocol.orchestra.client.model.ObjectId;
import io.fixprotocol.orchestra.client.model.Structure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Component
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-20T22:08:15.770Z")
public class Component extends MessageElement {
  @JsonProperty("structure")
  private Structure structure = null;

  public Component structure(Structure structure) {
    this.structure = structure;
    return this;
  }

   /**
   * Get structure
   * @return structure
  **/
  @ApiModelProperty(required = true, value = "")
  public Structure getStructure() {
    return structure;
  }

  public void setStructure(Structure structure) {
    this.structure = structure;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Component component = (Component) o;
    return Objects.equals(this.structure, component.structure) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(structure, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Component {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    structure: ").append(toIndentedString(structure)).append("\n");
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

