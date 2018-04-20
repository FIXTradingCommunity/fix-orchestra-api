package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Structure
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-20T19:56:10.305Z")
public class Structure {
  @JsonProperty("fields")
  private List<FieldRef> fields = null;

  @JsonProperty("components")
  private List<ComponentRef> components = null;

  @JsonProperty("groups")
  private List<GroupRef> groups = null;

  public Structure fields(List<FieldRef> fields) {
    this.fields = fields;
    return this;
  }

  public Structure addFieldsItem(FieldRef fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * Get fields
   * @return fields
  **/
  @ApiModelProperty(value = "")
  public List<FieldRef> getFields() {
    return fields;
  }

  public void setFields(List<FieldRef> fields) {
    this.fields = fields;
  }

  public Structure components(List<ComponentRef> components) {
    this.components = components;
    return this;
  }

  public Structure addComponentsItem(ComponentRef componentsItem) {
    if (this.components == null) {
      this.components = new ArrayList<>();
    }
    this.components.add(componentsItem);
    return this;
  }

   /**
   * Get components
   * @return components
  **/
  @ApiModelProperty(value = "")
  public List<ComponentRef> getComponents() {
    return components;
  }

  public void setComponents(List<ComponentRef> components) {
    this.components = components;
  }

  public Structure groups(List<GroupRef> groups) {
    this.groups = groups;
    return this;
  }

  public Structure addGroupsItem(GroupRef groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * Get groups
   * @return groups
  **/
  @ApiModelProperty(value = "")
  public List<GroupRef> getGroups() {
    return groups;
  }

  public void setGroups(List<GroupRef> groups) {
    this.groups = groups;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Structure structure = (Structure) o;
    return Objects.equals(this.fields, structure.fields) &&
        Objects.equals(this.components, structure.components) &&
        Objects.equals(this.groups, structure.groups);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fields, components, groups);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Structure {\n");
    
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    components: ").append(toIndentedString(components)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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

