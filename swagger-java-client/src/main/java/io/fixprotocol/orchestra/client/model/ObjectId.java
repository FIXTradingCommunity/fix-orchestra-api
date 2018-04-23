package io.fixprotocol.orchestra.client.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ObjectId
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-23T17:52:38.213Z")
public class ObjectId {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("abbrName")
  private String abbrName = null;

  @JsonProperty("oid")
  private String oid = null;

  public ObjectId name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name, unique within a file
   * @return name
  **/
  @ApiModelProperty(example = "Account", required = true, value = "Name, unique within a file")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ObjectId id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Numeric ID, unique within a file, e.g. a field tag
   * @return id
  **/
  @ApiModelProperty(example = "1", required = true, value = "Numeric ID, unique within a file, e.g. a field tag")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ObjectId abbrName(String abbrName) {
    this.abbrName = abbrName;
    return this;
  }

   /**
   * Short name
   * @return abbrName
  **/
  @ApiModelProperty(example = "Acct", value = "Short name")
  public String getAbbrName() {
    return abbrName;
  }

  public void setAbbrName(String abbrName) {
    this.abbrName = abbrName;
  }

  public ObjectId oid(String oid) {
    this.oid = oid;
    return this;
  }

   /**
   * Globally unique object identifier, a URI or UUID
   * @return oid
  **/
  @ApiModelProperty(value = "Globally unique object identifier, a URI or UUID")
  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectId objectId = (ObjectId) o;
    return Objects.equals(this.name, objectId.name) &&
        Objects.equals(this.id, objectId.id) &&
        Objects.equals(this.abbrName, objectId.abbrName) &&
        Objects.equals(this.oid, objectId.oid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, abbrName, oid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectId {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    abbrName: ").append(toIndentedString(abbrName)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
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

