package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Annotation;
import io.swagger.client.model.EntityAttributes;
import io.swagger.client.model.MessageElement;
import io.swagger.client.model.MessageElements;
import io.swagger.client.model.ObjectId;

/**
 * Component
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-26T18:59:32.669Z")
public class Component extends MessageElement {
  @SerializedName("elements")
  private MessageElements elements = null;

  public Component elements(MessageElements elements) {
    this.elements = elements;
    return this;
  }

   /**
   * Get elements
   * @return elements
  **/
  @ApiModelProperty(value = "")
  public MessageElements getElements() {
    return elements;
  }

  public void setElements(MessageElements elements) {
    this.elements = elements;
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
    return Objects.equals(this.elements, component.elements) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elements, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Component {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    elements: ").append(toIndentedString(elements)).append("\n");
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

