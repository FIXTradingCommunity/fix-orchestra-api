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
 * StateMachine
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-20T19:56:10.305Z")
public class StateMachine {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("initial")
  private State initial = null;

  @JsonProperty("states")
  private List<State> states = null;

  @JsonProperty("annotation")
  private Annotation annotation = null;

  public StateMachine name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StateMachine initial(State initial) {
    this.initial = initial;
    return this;
  }

   /**
   * Get initial
   * @return initial
  **/
  @ApiModelProperty(value = "")
  public State getInitial() {
    return initial;
  }

  public void setInitial(State initial) {
    this.initial = initial;
  }

  public StateMachine states(List<State> states) {
    this.states = states;
    return this;
  }

  public StateMachine addStatesItem(State statesItem) {
    if (this.states == null) {
      this.states = new ArrayList<>();
    }
    this.states.add(statesItem);
    return this;
  }

   /**
   * Get states
   * @return states
  **/
  @ApiModelProperty(value = "")
  public List<State> getStates() {
    return states;
  }

  public void setStates(List<State> states) {
    this.states = states;
  }

  public StateMachine annotation(Annotation annotation) {
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
    StateMachine stateMachine = (StateMachine) o;
    return Objects.equals(this.name, stateMachine.name) &&
        Objects.equals(this.initial, stateMachine.initial) &&
        Objects.equals(this.states, stateMachine.states) &&
        Objects.equals(this.annotation, stateMachine.annotation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, initial, states, annotation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateMachine {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    initial: ").append(toIndentedString(initial)).append("\n");
    sb.append("    states: ").append(toIndentedString(states)).append("\n");
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

