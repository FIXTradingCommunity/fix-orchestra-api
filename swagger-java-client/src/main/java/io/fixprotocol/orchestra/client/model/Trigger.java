package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trigger
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-12-04T16:02:31.392Z")
public class Trigger {
  @JsonProperty("stateMachine")
  private String stateMachine = null;

  @JsonProperty("actor")
  private String actor = null;

  @JsonProperty("name")
  private String name = null;

  public Trigger stateMachine(String stateMachine) {
    this.stateMachine = stateMachine;
    return this;
  }

   /**
   * name of StateMachine
   * @return stateMachine
  **/
  @ApiModelProperty(required = true, value = "name of StateMachine")
  public String getStateMachine() {
    return stateMachine;
  }

  public void setStateMachine(String stateMachine) {
    this.stateMachine = stateMachine;
  }

  public Trigger actor(String actor) {
    this.actor = actor;
    return this;
  }

   /**
   * name of the Actor that owns the StateMachine
   * @return actor
  **/
  @ApiModelProperty(required = true, value = "name of the Actor that owns the StateMachine")
  public String getActor() {
    return actor;
  }

  public void setActor(String actor) {
    this.actor = actor;
  }

  public Trigger name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name of Transition to invoke
   * @return name
  **/
  @ApiModelProperty(required = true, value = "name of Transition to invoke")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trigger trigger = (Trigger) o;
    return Objects.equals(this.stateMachine, trigger.stateMachine) &&
        Objects.equals(this.actor, trigger.actor) &&
        Objects.equals(this.name, trigger.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateMachine, actor, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Trigger {\n");
    
    sb.append("    stateMachine: ").append(toIndentedString(stateMachine)).append("\n");
    sb.append("    actor: ").append(toIndentedString(actor)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

