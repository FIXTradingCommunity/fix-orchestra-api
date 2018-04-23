package io.fixprotocol.orchestra.client.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Annotation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-23T17:52:38.213Z")
public class Annotation {
  @JsonProperty("appinfo")
  private List<Appinfo> appinfo = null;

  @JsonProperty("documentation")
  private List<Documentation> documentation = null;

  public Annotation appinfo(List<Appinfo> appinfo) {
    this.appinfo = appinfo;
    return this;
  }

  public Annotation addAppinfoItem(Appinfo appinfoItem) {
    if (this.appinfo == null) {
      this.appinfo = new ArrayList<>();
    }
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
    if (this.documentation == null) {
      this.documentation = new ArrayList<>();
    }
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

