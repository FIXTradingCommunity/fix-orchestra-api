package io.fixprotocol.orchestra.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.MessageRef;
import io.fixprotocol.orchestra.client.model.Trigger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-21T23:02:09.711Z")
public class Response {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("when")
  private String when = null;

  @JsonProperty("messageRef")
  private MessageRef messageRef = null;

  @JsonProperty("assign")
  private String assign = null;

  @JsonProperty("trigger")
  private Trigger trigger = null;

  @JsonProperty("annotation")
  private Annotation annotation = null;

  public Response name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Response when(String when) {
    this.when = when;
    return this;
  }

   /**
   * conditional expression; if not present, then response is unconditional
   * @return when
  **/
  @ApiModelProperty(value = "conditional expression; if not present, then response is unconditional")
  public String getWhen() {
    return when;
  }

  public void setWhen(String when) {
    this.when = when;
  }

  public Response messageRef(MessageRef messageRef) {
    this.messageRef = messageRef;
    return this;
  }

   /**
   * send a response message
   * @return messageRef
  **/
  @ApiModelProperty(value = "send a response message")
  public MessageRef getMessageRef() {
    return messageRef;
  }

  public void setMessageRef(MessageRef messageRef) {
    this.messageRef = messageRef;
  }

  public Response assign(String assign) {
    this.assign = assign;
    return this;
  }

   /**
   * assignment expression
   * @return assign
  **/
  @ApiModelProperty(value = "assignment expression")
  public String getAssign() {
    return assign;
  }

  public void setAssign(String assign) {
    this.assign = assign;
  }

  public Response trigger(Trigger trigger) {
    this.trigger = trigger;
    return this;
  }

   /**
   * Get trigger
   * @return trigger
  **/
  @ApiModelProperty(value = "")
  public Trigger getTrigger() {
    return trigger;
  }

  public void setTrigger(Trigger trigger) {
    this.trigger = trigger;
  }

  public Response annotation(Annotation annotation) {
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
    Response response = (Response) o;
    return Objects.equals(this.name, response.name) &&
        Objects.equals(this.when, response.when) &&
        Objects.equals(this.messageRef, response.messageRef) &&
        Objects.equals(this.assign, response.assign) &&
        Objects.equals(this.trigger, response.trigger) &&
        Objects.equals(this.annotation, response.annotation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, when, messageRef, assign, trigger, annotation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    when: ").append(toIndentedString(when)).append("\n");
    sb.append("    messageRef: ").append(toIndentedString(messageRef)).append("\n");
    sb.append("    assign: ").append(toIndentedString(assign)).append("\n");
    sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
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

