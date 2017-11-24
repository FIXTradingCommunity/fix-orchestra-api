package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.ComponentRef;
import io.fixprotocol.orchestra.client.model.FieldRef;
import io.fixprotocol.orchestra.client.model.GroupRef;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Structure
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-21T23:02:09.711Z")
public class Structure {
  @JsonProperty("fields")
  private List<FieldRef> fields = new ArrayList<FieldRef>();

  @JsonProperty("components")
  private List<ComponentRef> components = new ArrayList<ComponentRef>();

  @JsonProperty("groups")
  private List<GroupRef> groups = new ArrayList<GroupRef>();

  public Structure fields(List<FieldRef> fields) {
    this.fields = fields;
    return this;
  }

  public Structure addFieldsItem(FieldRef fieldsItem) {
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

