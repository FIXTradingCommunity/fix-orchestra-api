package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.Structure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a class of participants
 */
@ApiModel(description = "Represents a class of participants")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-24T16:52:38.175Z")
public class Actor {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("extends")
  private String _extends = null;

  @JsonProperty("structure")
  private Structure structure = null;

  @JsonProperty("annotation")
  private Annotation annotation = null;

  public Actor name(String name) {
    this.name = name;
    return this;
  }

   /**
   * unique name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "unique name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Actor _extends(String _extends) {
    this._extends = _extends;
    return this;
  }

   /**
   * Inherits properties from another Actor
   * @return _extends
  **/
  @ApiModelProperty(value = "Inherits properties from another Actor")
  public String getExtends() {
    return _extends;
  }

  public void setExtends(String _extends) {
    this._extends = _extends;
  }

  public Actor structure(Structure structure) {
    this.structure = structure;
    return this;
  }

   /**
   * State variables
   * @return structure
  **/
  @ApiModelProperty(value = "State variables")
  public Structure getStructure() {
    return structure;
  }

  public void setStructure(Structure structure) {
    this.structure = structure;
  }

  public Actor annotation(Annotation annotation) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Actor actor = (Actor) o;
    return Objects.equals(this.name, actor.name) &&
        Objects.equals(this._extends, actor._extends) &&
        Objects.equals(this.structure, actor.structure) &&
        Objects.equals(this.annotation, actor.annotation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, _extends, structure, annotation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Actor {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    _extends: ").append(toIndentedString(_extends)).append("\n");
    sb.append("    structure: ").append(toIndentedString(structure)).append("\n");
    sb.append("    annotation: ").append(toIndentedString(annotation)).append("\n");
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

