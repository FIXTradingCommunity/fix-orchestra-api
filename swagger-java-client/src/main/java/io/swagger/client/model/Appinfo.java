package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Usage specific annotation, optionally with link to an external reference or standard
 */
@ApiModel(description = "Usage specific annotation, optionally with link to an external reference or standard")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-27T18:19:20.110Z")
public class Appinfo {
  @SerializedName("$")
  private String value = null;

  @SerializedName("specURL")
  private String specURL = null;

  @SerializedName("langId")
  private String langId = null;

  @SerializedName("purpose")
  private String purpose = null;

  public Appinfo value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(required = true, value = "")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
    return Objects.equals(this.value, appinfo.value) &&
        Objects.equals(this.specURL, appinfo.specURL) &&
        Objects.equals(this.langId, appinfo.langId) &&
        Objects.equals(this.purpose, appinfo.purpose);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, specURL, langId, purpose);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Appinfo {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

