package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Metadata;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Repository
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-15T16:04:56.053Z")
public class Repository {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("oid")
  private String oid = null;

  @JsonProperty("specURL")
  private String specURL = null;

  @JsonProperty("namespace")
  private String namespace = null;

  @JsonProperty("hasComponents")
  private Boolean hasComponents = null;

  @JsonProperty("metadata")
  private Metadata metadata = null;

  public Repository name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Stable name that does not change with minor version updates
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Stable name that does not change with minor version updates")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Repository version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(required = true, value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Repository oid(String oid) {
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

  public Repository specURL(String specURL) {
    this.specURL = specURL;
    return this;
  }

   /**
   * Reference documentation
   * @return specURL
  **/
  @ApiModelProperty(value = "Reference documentation")
  public String getSpecURL() {
    return specURL;
  }

  public void setSpecURL(String specURL) {
    this.specURL = specURL;
  }

  public Repository namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

   /**
   * Associated schema namespace
   * @return namespace
  **/
  @ApiModelProperty(value = "Associated schema namespace")
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public Repository hasComponents(Boolean hasComponents) {
    this.hasComponents = hasComponents;
    return this;
  }

   /**
   * Get hasComponents
   * @return hasComponents
  **/
  @ApiModelProperty(value = "")
  public Boolean getHasComponents() {
    return hasComponents;
  }

  public void setHasComponents(Boolean hasComponents) {
    this.hasComponents = hasComponents;
  }

  public Repository metadata(Metadata metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Repository repository = (Repository) o;
    return Objects.equals(this.name, repository.name) &&
        Objects.equals(this.version, repository.version) &&
        Objects.equals(this.oid, repository.oid) &&
        Objects.equals(this.specURL, repository.specURL) &&
        Objects.equals(this.namespace, repository.namespace) &&
        Objects.equals(this.hasComponents, repository.hasComponents) &&
        Objects.equals(this.metadata, repository.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version, oid, specURL, namespace, hasComponents, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Repository {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    specURL: ").append(toIndentedString(specURL)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    hasComponents: ").append(toIndentedString(hasComponents)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

