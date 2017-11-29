package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Transition
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-29T15:57:45.378Z")
public class Transition {
  @JsonProperty("when")
  private String when = null;

  @JsonProperty("target")
  private String target = null;

  @JsonProperty("annotation")
  private Annotation annotation = null;

  public Transition when(String when) {
    this.when = when;
    return this;
  }

   /**
   * Optional guard condition
   * @return when
  **/
  @ApiModelProperty(value = "Optional guard condition")
  public String getWhen() {
    return when;
  }

  public void setWhen(String when) {
    this.when = when;
  }

  public Transition target(String target) {
    this.target = target;
    return this;
  }

   /**
   * name of the target state
   * @return target
  **/
  @ApiModelProperty(value = "name of the target state")
  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Transition annotation(Annotation annotation) {
    this.annotation = annotation;
    return this;
  }

   /**
   * Get annotation
   * @return annotation
  **/
  @ApiModelProperty(value = "")
  public Annotation getAnnotation() {
    return annotation;
  }

  public void setAnnotation(Annotation annotation) {
    this.annotation = annotation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transition transition = (Transition) o;
    return Objects.equals(this.when, transition.when) &&
        Objects.equals(this.target, transition.target) &&
        Objects.equals(this.annotation, transition.annotation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(when, target, annotation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transition {\n");
    
    sb.append("    when: ").append(toIndentedString(when)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
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

