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
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.EntityAttributes;
import io.fixprotocol.orchestra.model.ObjectId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * CodeSet
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-12-04T16:01:43.421Z")
public class CodeSet   {
  @JsonProperty("oid")
  private ObjectId oid = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("specURL")
  private String specURL = null;

  @JsonProperty("default")
  private String _default = null;

  @JsonProperty("codes")
  private List<Code> codes = null;

  @JsonProperty("annotation")
  private Annotation annotation = null;

  @JsonProperty("entityAttributes")
  private EntityAttributes entityAttributes = null;

  public CodeSet oid(ObjectId oid) {
    this.oid = oid;
    return this;
  }

  /**
   * Get oid
   * @return oid
   **/
  @JsonProperty("oid")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public ObjectId getOid() {
    return oid;
  }

  public void setOid(ObjectId oid) {
    this.oid = oid;
  }

  public CodeSet type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @JsonProperty("type")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CodeSet specURL(String specURL) {
    this.specURL = specURL;
    return this;
  }

  /**
   * Get specURL
   * @return specURL
   **/
  @JsonProperty("specURL")
  @ApiModelProperty(value = "")
  public String getSpecURL() {
    return specURL;
  }

  public void setSpecURL(String specURL) {
    this.specURL = specURL;
  }

  public CodeSet _default(String _default) {
    this._default = _default;
    return this;
  }

  /**
   * Get _default
   * @return _default
   **/
  @JsonProperty("default")
  @ApiModelProperty(value = "")
  public String getDefault() {
    return _default;
  }

  public void setDefault(String _default) {
    this._default = _default;
  }

  public CodeSet codes(List<Code> codes) {
    this.codes = codes;
    return this;
  }

  public CodeSet addCodesItem(Code codesItem) {
    if (this.codes == null) {
      this.codes = new ArrayList<>();
    }
    this.codes.add(codesItem);
    return this;
  }

  /**
   * Get codes
   * @return codes
   **/
  @JsonProperty("codes")
  @ApiModelProperty(value = "")
  public List<Code> getCodes() {
    return codes;
  }

  public void setCodes(List<Code> codes) {
    this.codes = codes;
  }

  public CodeSet annotation(Annotation annotation) {
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

  public CodeSet entityAttributes(EntityAttributes entityAttributes) {
    this.entityAttributes = entityAttributes;
    return this;
  }

  /**
   * Get entityAttributes
   * @return entityAttributes
   **/
  @JsonProperty("entityAttributes")
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
    CodeSet codeSet = (CodeSet) o;
    return Objects.equals(this.oid, codeSet.oid) &&
        Objects.equals(this.type, codeSet.type) &&
        Objects.equals(this.specURL, codeSet.specURL) &&
        Objects.equals(this._default, codeSet._default) &&
        Objects.equals(this.codes, codeSet.codes) &&
        Objects.equals(this.annotation, codeSet.annotation) &&
        Objects.equals(this.entityAttributes, codeSet.entityAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oid, type, specURL, _default, codes, annotation, entityAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeSet {\n");
    
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    specURL: ").append(toIndentedString(specURL)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    codes: ").append(toIndentedString(codes)).append("\n");
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

