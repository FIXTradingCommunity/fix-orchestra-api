package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;

/**
 * Dublin Core Terms metadata
 */
@ApiModel(description = "Dublin Core Terms metadata")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-26T18:59:32.669Z")
public class Orchestra {
  @SerializedName("identifier")
  private String identifier = null;

  @SerializedName("conformsTo")
  private String conformsTo = null;

  @SerializedName("coverage")
  private String coverage = null;

  @SerializedName("creator")
  private String creator = null;

  @SerializedName("date")
  private LocalDate date = null;

  @SerializedName("title")
  private String title = null;

  public Orchestra identifier(String identifier) {
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

  public Orchestra conformsTo(String conformsTo) {
    this.conformsTo = conformsTo;
    return this;
  }

   /**
   * Get conformsTo
   * @return conformsTo
  **/
  @ApiModelProperty(value = "")
  public String getConformsTo() {
    return conformsTo;
  }

  public void setConformsTo(String conformsTo) {
    this.conformsTo = conformsTo;
  }

  public Orchestra coverage(String coverage) {
    this.coverage = coverage;
    return this;
  }

   /**
   * Get coverage
   * @return coverage
  **/
  @ApiModelProperty(value = "")
  public String getCoverage() {
    return coverage;
  }

  public void setCoverage(String coverage) {
    this.coverage = coverage;
  }

  public Orchestra creator(String creator) {
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

  public Orchestra date(LocalDate date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Orchestra title(String title) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Orchestra orchestra = (Orchestra) o;
    return Objects.equals(this.identifier, orchestra.identifier) &&
        Objects.equals(this.conformsTo, orchestra.conformsTo) &&
        Objects.equals(this.coverage, orchestra.coverage) &&
        Objects.equals(this.creator, orchestra.creator) &&
        Objects.equals(this.date, orchestra.date) &&
        Objects.equals(this.title, orchestra.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier, conformsTo, coverage, creator, date, title);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Orchestra {\n");
    
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    conformsTo: ").append(toIndentedString(conformsTo)).append("\n");
    sb.append("    coverage: ").append(toIndentedString(coverage)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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

