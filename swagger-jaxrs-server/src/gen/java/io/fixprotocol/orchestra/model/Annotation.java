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
import io.fixprotocol.orchestra.model.Appinfo;
import io.fixprotocol.orchestra.model.Documentation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Annotation
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-21T23:01:30.114Z")
public class Annotation   {
  @JsonProperty("appinfo")
  private List<Appinfo> appinfo = new ArrayList<Appinfo>();

  @JsonProperty("documentation")
  private List<Documentation> documentation = new ArrayList<Documentation>();

  public Annotation appinfo(List<Appinfo> appinfo) {
    this.appinfo = appinfo;
    return this;
  }

  public Annotation addAppinfoItem(Appinfo appinfoItem) {
    this.appinfo.add(appinfoItem);
    return this;
  }

   /**
   * Get appinfo
   * @return appinfo
  **/
  @ApiModelProperty(value = "")
  public List<Appinfo> getAppinfo() {
    return appinfo;
  }

  public void setAppinfo(List<Appinfo> appinfo) {
    this.appinfo = appinfo;
  }

  public Annotation documentation(List<Documentation> documentation) {
    this.documentation = documentation;
    return this;
  }

  public Annotation addDocumentationItem(Documentation documentationItem) {
    this.documentation.add(documentationItem);
    return this;
  }

   /**
   * Get documentation
   * @return documentation
  **/
  @ApiModelProperty(value = "")
  public List<Documentation> getDocumentation() {
    return documentation;
  }

  public void setDocumentation(List<Documentation> documentation) {
    this.documentation = documentation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Annotation annotation = (Annotation) o;
    return Objects.equals(this.appinfo, annotation.appinfo) &&
        Objects.equals(this.documentation, annotation.documentation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appinfo, documentation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Annotation {\n");
    
    sb.append("    appinfo: ").append(toIndentedString(appinfo)).append("\n");
    sb.append("    documentation: ").append(toIndentedString(documentation)).append("\n");
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

