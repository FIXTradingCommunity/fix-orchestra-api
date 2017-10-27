package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;

/**
 * description of an Orchestra file, conforms to Dublin Core Terms
 */
@ApiModel(description = "description of an Orchestra file, conforms to Dublin Core Terms")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-27T18:19:20.110Z")
public class Metadata {
  @SerializedName("identifier")
  private String identifier = null;

  @SerializedName("abstract")
  private String _abstract = null;

  @SerializedName("audience")
  private String audience = null;

  @SerializedName("conformsTo")
  private String conformsTo = null;

  @SerializedName("coverage")
  private String coverage = null;

  @SerializedName("creator")
  private String creator = null;

  @SerializedName("date")
  private LocalDate date = null;

  @SerializedName("publisher")
  private String publisher = null;

  @SerializedName("title")
  private String title = null;

  @SerializedName("valid")
  private LocalDate valid = null;

  public Metadata identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

   /**
   * unique ID of an Orchestra file
   * @return identifier
  **/
  @ApiModelProperty(required = true, value = "unique ID of an Orchestra file")
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public Metadata _abstract(String _abstract) {
    this._abstract = _abstract;
    return this;
  }

   /**
   * a summary
   * @return _abstract
  **/
  @ApiModelProperty(value = "a summary")
  public String getAbstract() {
    return _abstract;
  }

  public void setAbstract(String _abstract) {
    this._abstract = _abstract;
  }

  public Metadata audience(String audience) {
    this.audience = audience;
    return this;
  }

   /**
   * who it applies to
   * @return audience
  **/
  @ApiModelProperty(value = "who it applies to")
  public String getAudience() {
    return audience;
  }

  public void setAudience(String audience) {
    this.audience = audience;
  }

  public Metadata conformsTo(String conformsTo) {
    this.conformsTo = conformsTo;
    return this;
  }

   /**
   * a governing standard or specification
   * @return conformsTo
  **/
  @ApiModelProperty(example = "FIX 5.0SP2", value = "a governing standard or specification")
  public String getConformsTo() {
    return conformsTo;
  }

  public void setConformsTo(String conformsTo) {
    this.conformsTo = conformsTo;
  }

  public Metadata coverage(String coverage) {
    this.coverage = coverage;
    return this;
  }

   /**
   * a FIX category or guideline
   * @return coverage
  **/
  @ApiModelProperty(example = "SingleGeneralOrderHandling", value = "a FIX category or guideline")
  public String getCoverage() {
    return coverage;
  }

  public void setCoverage(String coverage) {
    this.coverage = coverage;
  }

  public Metadata creator(String creator) {
    this.creator = creator;
    return this;
  }

   /**
   * Get creator
   * @return creator
  **/
  @ApiModelProperty(value = "")
  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Metadata date(LocalDate date) {
    this.date = date;
    return this;
  }

   /**
   * when the file was produced
   * @return date
  **/
  @ApiModelProperty(value = "when the file was produced")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Metadata publisher(String publisher) {
    this.publisher = publisher;
    return this;
  }

   /**
   * Get publisher
   * @return publisher
  **/
  @ApiModelProperty(example = "FIX Trading Community", value = "")
  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Metadata title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Metadata valid(LocalDate valid) {
    this.valid = valid;
    return this;
  }

   /**
   * when the file becomes valid
   * @return valid
  **/
  @ApiModelProperty(value = "when the file becomes valid")
  public LocalDate getValid() {
    return valid;
  }

  public void setValid(LocalDate valid) {
    this.valid = valid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Metadata metadata = (Metadata) o;
    return Objects.equals(this.identifier, metadata.identifier) &&
        Objects.equals(this._abstract, metadata._abstract) &&
        Objects.equals(this.audience, metadata.audience) &&
        Objects.equals(this.conformsTo, metadata.conformsTo) &&
        Objects.equals(this.coverage, metadata.coverage) &&
        Objects.equals(this.creator, metadata.creator) &&
        Objects.equals(this.date, metadata.date) &&
        Objects.equals(this.publisher, metadata.publisher) &&
        Objects.equals(this.title, metadata.title) &&
        Objects.equals(this.valid, metadata.valid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, _abstract, audience, conformsTo, coverage, creator, date, publisher, title, valid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Metadata {\n");
    
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    _abstract: ").append(toIndentedString(_abstract)).append("\n");
    sb.append("    audience: ").append(toIndentedString(audience)).append("\n");
    sb.append("    conformsTo: ").append(toIndentedString(conformsTo)).append("\n");
    sb.append("    coverage: ").append(toIndentedString(coverage)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    publisher: ").append(toIndentedString(publisher)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    valid: ").append(toIndentedString(valid)).append("\n");
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

