package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Appinfo;
import io.fixprotocol.orchestra.client.model.Documentation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Annotation
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-29T15:57:45.378Z")
public class Annotation {
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

