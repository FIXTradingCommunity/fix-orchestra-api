package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Documentation
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-21T23:02:09.711Z")
public class Documentation {
  @JsonProperty("$")
  private String value = null;

  @JsonProperty("langId")
  private String langId = null;

  @JsonProperty("purpose")
  private String purpose = null;

  public Documentation value(String value) {
    this.value = value;
    return this;
  }

   /**
   * text of Documentation
   * @return value
  **/
  @ApiModelProperty(required = true, value = "text of Documentation")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Documentation langId(String langId) {
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

  public Documentation purpose(String purpose) {
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
    Documentation documentation = (Documentation) o;
    return Objects.equals(this.value, documentation.value) &&
        Objects.equals(this.langId, documentation.langId) &&
        Objects.equals(this.purpose, documentation.purpose);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, langId, purpose);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Documentation {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

