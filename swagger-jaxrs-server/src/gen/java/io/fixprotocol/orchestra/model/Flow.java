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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * A stream of messages in one direction
 */
@ApiModel(description = "A stream of messages in one direction")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-18T14:21:53.325Z")
public class Flow   {
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
  @JsonProperty("name")
  @ApiModelProperty(required = true, value = "unique flow name")
  @NotNull
 @Size(max=64)  public String getName() {
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
  @JsonProperty("source")
  @ApiModelProperty(required = true, value = "Name of the actor that originates messages")
  @NotNull
 @Size(max=64)  public String getSource() {
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
  @JsonProperty("destination")
  @ApiModelProperty(required = true, value = "Name of the actor that receives messages")
  @NotNull
 @Size(max=64)  public String getDestination() {
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
  @JsonProperty("annotation")
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

