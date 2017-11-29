package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.ElementRef;
import io.fixprotocol.orchestra.client.model.EntityAttributes;
import io.fixprotocol.orchestra.client.model.ObjectId;

/**
 * GroupRef
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-29T15:57:45.378Z")
public class GroupRef extends ElementRef {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupRef {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

