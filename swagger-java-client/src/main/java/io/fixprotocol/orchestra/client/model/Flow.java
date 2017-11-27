package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A stream of messages in one direction
 */
@ApiModel(description = "A stream of messages in one direction")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-24T16:52:38.175Z")
public class Flow {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("destination")
  private String destination = null;

  @JsonProperty("annotation")
  private Annotation annotation = null;

  public Flow name(String name) {
    this.name = name;
    return this;
  }

   /**
   * unique flow name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "unique flow name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Flow source(String source) {
    this.source = source;
    return this;
  }

   /**
   * Name of the actor that originates messages
   * @return source
  **/
  @ApiModelProperty(required = true, value = "Name of the actor that originates messages")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Flow destination(String destination) {
    this.destination = destination;
    return this;
  }

   /**
   * Name of the actor that receives messages
   * @return destination
  **/
  @ApiModelProperty(required = true, value = "Name of the actor that receives messages")
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Flow annotation(Annotation annotation) {
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
    Flow flow = (Flow) o;
    return Objects.equals(this.name, flow.name) &&
        Objects.equals(this.source, flow.source) &&
        Objects.equals(this.destination, flow.destination) &&
        Objects.equals(this.annotation, flow.annotation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, source, destination, annotation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Flow {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
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

