package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.EntityAttributes;
import io.fixprotocol.orchestra.client.model.ObjectId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * MessageElement
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-10T17:10:04.535Z")
public class MessageElement {
  @JsonProperty("elementType")
  private String elementType = null;

  @JsonProperty("oid")
  private ObjectId oid = null;

  @JsonProperty("annotation")
  private Annotation annotation = null;

  @JsonProperty("entityAttributes")
  private EntityAttributes entityAttributes = null;

  @JsonProperty("category")
  private String category = null;

  public MessageElement elementType(String elementType) {
    this.elementType = elementType;
    return this;
  }

   /**
   * Get elementType
   * @return elementType
  **/
  @ApiModelProperty(required = true, value = "")
  public String getElementType() {
    return elementType;
  }

  public void setElementType(String elementType) {
    this.elementType = elementType;
  }

  public MessageElement oid(ObjectId oid) {
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

  public MessageElement annotation(Annotation annotation) {
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

  public MessageElement entityAttributes(EntityAttributes entityAttributes) {
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

  public MessageElement category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageElement messageElement = (MessageElement) o;
    return Objects.equals(this.elementType, messageElement.elementType) &&
        Objects.equals(this.oid, messageElement.oid) &&
        Objects.equals(this.annotation, messageElement.annotation) &&
        Objects.equals(this.entityAttributes, messageElement.entityAttributes) &&
        Objects.equals(this.category, messageElement.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementType, oid, annotation, entityAttributes, category);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MessageElement {\n");
    
    sb.append("    elementType: ").append(toIndentedString(elementType)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
    sb.append("    entityAttributes: ").append(toIndentedString(entityAttributes)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
