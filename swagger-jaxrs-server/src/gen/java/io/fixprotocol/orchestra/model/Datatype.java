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
import io.fixprotocol.orchestra.model.EntityAttributes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Datatype
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-21T23:01:30.114Z")
public class Datatype   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("baseType")
  private String baseType = null;

  @JsonProperty("annotation")
  private Annotation annotation = null;

  @JsonProperty("entityAttributes")
  private EntityAttributes entityAttributes = null;

  public Datatype name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Datatype baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

   /**
   * Get baseType
   * @return baseType
  **/
  @ApiModelProperty(value = "")
  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Datatype annotation(Annotation annotation) {
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

  public Datatype entityAttributes(EntityAttributes entityAttributes) {
    this.entityAttributes = entityAttributes;
    return this;
  }

   /**
   * Get entityAttributes
   * @return entityAttributes
  **/
  @ApiModelProperty(value = "")
  public EntityAttributes getEntityAttributes() {
    return entityAttributes;
  }

  public void setEntityAttributes(EntityAttributes entityAttributes) {
    this.entityAttributes = entityAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Datatype datatype = (Datatype) o;
    return Objects.equals(this.name, datatype.name) &&
        Objects.equals(this.baseType, datatype.baseType) &&
        Objects.equals(this.annotation, datatype.annotation) &&
        Objects.equals(this.entityAttributes, datatype.entityAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, baseType, annotation, entityAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Datatype {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
    sb.append("    entityAttributes: ").append(toIndentedString(entityAttributes)).append("\n");
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

