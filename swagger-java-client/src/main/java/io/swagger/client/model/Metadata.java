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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-06T20:14:38.153Z")
public class Metadata {
  @SerializedName("identifier")
  private String identifier = null;

  @SerializedName("contributor")
  private String contributor = null;

  @SerializedName("coverage")
  private String coverage = null;

  @SerializedName("creator")
  private String creator = null;

  @SerializedName("date")
  private LocalDate date = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("format")
  private String format = null;

  @SerializedName("language")
  private String language = null;

  @SerializedName("relation")
  private String relation = null;

  @SerializedName("rights")
  private String rights = null;

  @SerializedName("publisher")
  private String publisher = null;

  @SerializedName("source")
  private String source = null;

  @SerializedName("subject")
  private String subject = null;

  @SerializedName("title")
  private String title = null;

  @SerializedName("type")
  private String type = null;

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

  public Metadata contributor(String contributor) {
    this.contributor = contributor;
    return this;
  }

   /**
   * Get contributor
   * @return contributor
  **/
  @ApiModelProperty(value = "")
  public String getContributor() {
    return contributor;
  }

  public void setContributor(String contributor) {
    this.contributor = contributor;
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

  public Metadata description(String description) {
    this.description = description;
    return this;
  }

   /**
   * a summary
   * @return description
  **/
  @ApiModelProperty(value = "a summary")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Metadata format(String format) {
    this.format = format;
    return this;
  }

   /**
   * file format
   * @return format
  **/
  @ApiModelProperty(value = "file format")
  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public Metadata language(String language) {
    this.language = language;
    return this;
  }

   /**
   * Get language
   * @return language
  **/
  @ApiModelProperty(value = "")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Metadata relation(String relation) {
    this.relation = relation;
    return this;
  }

   /**
   * a related resource
   * @return relation
  **/
  @ApiModelProperty(value = "a related resource")
  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public Metadata rights(String rights) {
    this.rights = rights;
    return this;
  }

   /**
   * Get rights
   * @return rights
  **/
  @ApiModelProperty(value = "")
  public String getRights() {
    return rights;
  }

  public void setRights(String rights) {
    this.rights = rights;
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

  public Metadata source(String source) {
    this.source = source;
    return this;
  }

   /**
   * a resource from which this one was derived
   * @return source
  **/
  @ApiModelProperty(value = "a resource from which this one was derived")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Metadata subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * Get subject
   * @return subject
  **/
  @ApiModelProperty(value = "")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
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

  public Metadata type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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
        Objects.equals(this.contributor, metadata.contributor) &&
        Objects.equals(this.coverage, metadata.coverage) &&
        Objects.equals(this.creator, metadata.creator) &&
        Objects.equals(this.date, metadata.date) &&
        Objects.equals(this.description, metadata.description) &&
        Objects.equals(this.format, metadata.format) &&
        Objects.equals(this.language, metadata.language) &&
        Objects.equals(this.relation, metadata.relation) &&
        Objects.equals(this.rights, metadata.rights) &&
        Objects.equals(this.publisher, metadata.publisher) &&
        Objects.equals(this.source, metadata.source) &&
        Objects.equals(this.subject, metadata.subject) &&
        Objects.equals(this.title, metadata.title) &&
        Objects.equals(this.type, metadata.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, contributor, coverage, creator, date, description, format, language, relation, rights, publisher, source, subject, title, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Metadata {\n");
    
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    contributor: ").append(toIndentedString(contributor)).append("\n");
    sb.append("    coverage: ").append(toIndentedString(coverage)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
    sb.append("    rights: ").append(toIndentedString(rights)).append("\n");
    sb.append("    publisher: ").append(toIndentedString(publisher)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

