package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.MessageElements;
import io.swagger.client.model.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Message
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-06T20:14:38.153Z")
public class Message {
  @SerializedName("scenario")
  private String scenario = "base";

  @SerializedName("flow")
  private String flow = null;

  @SerializedName("msgType")
  private String msgType = null;

  @SerializedName("structure")
  private MessageElements structure = null;

  @SerializedName("responses")
  private List<Response> responses = new ArrayList<Response>();

  public Message scenario(String scenario) {
    this.scenario = scenario;
    return this;
  }

   /**
   * Use case of a message type
   * @return scenario
  **/
  @ApiModelProperty(value = "Use case of a message type")
  public String getScenario() {
    return scenario;
  }

  public void setScenario(String scenario) {
    this.scenario = scenario;
  }

  public Message flow(String flow) {
    this.flow = flow;
    return this;
  }

   /**
   * A stream of messages between actors
   * @return flow
  **/
  @ApiModelProperty(value = "A stream of messages between actors")
  public String getFlow() {
    return flow;
  }

  public void setFlow(String flow) {
    this.flow = flow;
  }

  public Message msgType(String msgType) {
    this.msgType = msgType;
    return this;
  }

   /**
   * Get msgType
   * @return msgType
  **/
  @ApiModelProperty(value = "")
  public String getMsgType() {
    return msgType;
  }

  public void setMsgType(String msgType) {
    this.msgType = msgType;
  }

  public Message structure(MessageElements structure) {
    this.structure = structure;
    return this;
  }

   /**
   * Get structure
   * @return structure
  **/
  @ApiModelProperty(value = "")
  public MessageElements getStructure() {
    return structure;
  }

  public void setStructure(MessageElements structure) {
    this.structure = structure;
  }

  public Message responses(List<Response> responses) {
    this.responses = responses;
    return this;
  }

  public Message addResponsesItem(Response responsesItem) {
    this.responses.add(responsesItem);
    return this;
  }

   /**
   * Get responses
   * @return responses
  **/
  @ApiModelProperty(value = "")
  public List<Response> getResponses() {
    return responses;
  }

  public void setResponses(List<Response> responses) {
    this.responses = responses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Message message = (Message) o;
    return Objects.equals(this.scenario, message.scenario) &&
        Objects.equals(this.flow, message.flow) &&
        Objects.equals(this.msgType, message.msgType) &&
        Objects.equals(this.structure, message.structure) &&
        Objects.equals(this.responses, message.responses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scenario, flow, msgType, structure, responses);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Message {\n");
    
    sb.append("    scenario: ").append(toIndentedString(scenario)).append("\n");
    sb.append("    flow: ").append(toIndentedString(flow)).append("\n");
    sb.append("    msgType: ").append(toIndentedString(msgType)).append("\n");
    sb.append("    structure: ").append(toIndentedString(structure)).append("\n");
    sb.append("    responses: ").append(toIndentedString(responses)).append("\n");
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

