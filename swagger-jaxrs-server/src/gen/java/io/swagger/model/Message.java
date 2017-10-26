/*
 * Orchestra API
 * API to edit FIX Orchestra (machine readable rules of engagement) specification version 1.0 RC3
 *
 * OpenAPI spec version: 1.0.0
 * Contact: donmendelson@silverflash.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.MessageElements;
import io.swagger.model.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Message
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T19:00:28.823Z")
public class Message   {
  @JsonProperty("scenario")
  private String scenario = "base";

  @JsonProperty("flow")
  private String flow = null;

  @JsonProperty("msgType")
  private String msgType = null;

  @JsonProperty("structure")
  private MessageElements structure = null;

  @JsonProperty("responses")
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

