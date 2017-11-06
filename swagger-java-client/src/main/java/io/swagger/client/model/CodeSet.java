package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Annotation;
import io.swagger.client.model.Code;
import io.swagger.client.model.EntityAttributes;
import io.swagger.client.model.ObjectId;
import java.util.ArrayList;
import java.util.List;

/**
 * CodeSet
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-06T20:14:38.153Z")
public class CodeSet {
  @SerializedName("oid")
  private ObjectId oid = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("specURL")
  private String specURL = null;

  @SerializedName("default")
  private String _default = null;

  @SerializedName("codes")
  private List<Code> codes = new ArrayList<Code>();

  @SerializedName("annotation")
  private Annotation annotation = null;

  @SerializedName("entityAttributes")
  private EntityAttributes entityAttributes = null;

  public CodeSet oid(ObjectId oid) {
    this.oid = oid;
    return this;
  }

   /**
   * Get oid
   * @return oid
  **/
  @ApiModelProperty(required = true, value = "")
  public ObjectId getOid() {
    return oid;
  }

  public void setOid(ObjectId oid) {
    this.oid = oid;
  }

  public CodeSet type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CodeSet specURL(String specURL) {
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

  public CodeSet _default(String _default) {
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @ApiModelProperty(value = "")
  public String getDefault() {
    return _default;
  }

  public void setDefault(String _default) {
    this._default = _default;
  }

  public CodeSet codes(List<Code> codes) {
    this.codes = codes;
    return this;
  }

  public CodeSet addCodesItem(Code codesItem) {
    this.codes.add(codesItem);
    return this;
  }

   /**
   * Get codes
   * @return codes
  **/
  @ApiModelProperty(value = "")
  public List<Code> getCodes() {
    return codes;
  }

  public void setCodes(List<Code> codes) {
    this.codes = codes;
  }

  public CodeSet annotation(Annotation annotation) {
    this.annotation = annotation;
    return this;
  }

   /**
   * Get annotation
   * @return annotation
  **/
  @ApiModelProperty(value = "")
  public Annotation getAnnotation() {
    return annotation;
  }

  public void setAnnotation(Annotation annotation) {
    this.annotation = annotation;
  }

  public CodeSet entityAttributes(EntityAttributes entityAttributes) {
    this.entityAttributes = entityAttributes;
    return this;
  }

   /**
   * Get entityAttributes
   * @return entityAttributes
  **/
  @ApiModelProperty(value = "")
  public EntityAttributes getEntityAttributes() {
    return entityAttributes;
  }

  public void setEntityAttributes(EntityAttributes entityAttributes) {
    this.entityAttributes = entityAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodeSet codeSet = (CodeSet) o;
    return Objects.equals(this.oid, codeSet.oid) &&
        Objects.equals(this.type, codeSet.type) &&
        Objects.equals(this.specURL, codeSet.specURL) &&
        Objects.equals(this._default, codeSet._default) &&
        Objects.equals(this.codes, codeSet.codes) &&
        Objects.equals(this.annotation, codeSet.annotation) &&
        Objects.equals(this.entityAttributes, codeSet.entityAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oid, type, specURL, _default, codes, annotation, entityAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodeSet {\n");
    
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    specURL: ").append(toIndentedString(specURL)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    codes: ").append(toIndentedString(codes)).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
    sb.append("    entityAttributes: ").append(toIndentedString(entityAttributes)).append("\n");
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

