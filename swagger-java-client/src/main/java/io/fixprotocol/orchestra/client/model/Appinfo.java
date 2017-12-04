package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Usage specific annotation, optionally with link to an external reference or standard
 */
@ApiModel(description = "Usage specific annotation, optionally with link to an external reference or standard")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-04T16:02:31.392Z")
public class Appinfo {
  @JsonProperty("text")
  private String text = null;

  @JsonProperty("specURL")
  private String specURL = null;

  @JsonProperty("langId")
  private String langId = null;

  @JsonProperty("purpose")
  private String purpose = null;

  public Appinfo text(String text) {
    this.text = text;
    return this;
  }

   /**
   * Get text
   * @return text
  **/
  @ApiModelProperty(required = true, value = "")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Appinfo specURL(String specURL) {
    this.specURL = specURL;
    return this;
  }

   /**
   * Get specURL
   * @return specURL
  **/
  @ApiModelProperty(value = "")
  public String getSpecURL() {
    return specURL;
  }

  public void setSpecURL(String specURL) {
    this.specURL = specURL;
  }

  public Appinfo langId(String langId) {
    this.langId = langId;
    return this;
  }

   /**
   * a language code (ISO 639-1)
   * @return langId
  **/
  @ApiModelProperty(example = "en", value = "a language code (ISO 639-1)")
  public String getLangId() {
    return langId;
  }

  public void setLangId(String langId) {
    this.langId = langId;
  }

  public Appinfo purpose(String purpose) {
    this.purpose = purpose;
    return this;
  }

   /**
   * Get purpose
   * @return purpose
  **/
  @ApiModelProperty(example = "SYNOPSIS", value = "")
  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Appinfo appinfo = (Appinfo) o;
    return Objects.equals(this.text, appinfo.text) &&
        Objects.equals(this.specURL, appinfo.specURL) &&
        Objects.equals(this.langId, appinfo.langId) &&
        Objects.equals(this.purpose, appinfo.purpose);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, specURL, langId, purpose);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Appinfo {\n");
    
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    specURL: ").append(toIndentedString(specURL)).append("\n");
    sb.append("    langId: ").append(toIndentedString(langId)).append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
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

