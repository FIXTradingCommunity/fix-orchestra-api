/*
 * Orchestra API
 * API to edit FIX Orchestra (machine readable rules of engagement) specification version 1.0 RC3
 *
 * OpenAPI spec version: 1.0.0
 * 
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


package io.fixprotocol.orchestra.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.fixprotocol.orchestra.model.ObjectId;
import io.fixprotocol.orchestra.model.Response;
import io.fixprotocol.orchestra.model.Structure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * Message
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-30T16:33:12.690Z")
public class Message   {
  @JsonProperty("oid")
  private ObjectId oid = null;

  @JsonProperty("scenario")
  private String scenario = "base";

  @JsonProperty("extends")
  private String _extends = null;

  @JsonProperty("flow")
  private String flow = null;

  @JsonProperty("msgType")
  private String msgType = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("structure")
  private Structure structure = null;

  @JsonProperty("responses")
  private List<Response> responses = null;

  public Message oid(ObjectId oid) {
    this.oid = oid;
    return this;
  }

  /**
   * Get oid
   * @return oid
   **/
  @JsonProperty("oid")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public ObjectId getOid() {
    return oid;
  }

  public void setOid(ObjectId oid) {
    this.oid = oid;
  }

  public Message scenario(String scenario) {
    this.scenario = scenario;
    return this;
  }

  /**
   * Use case of a message type
   * @return scenario
   **/
  @JsonProperty("scenario")
  @ApiModelProperty(value = "Use case of a message type")
 @Size(max=64)  public String getScenario() {
    return scenario;
  }

  public void setScenario(String scenario) {
    this.scenario = scenario;
  }

  public Message _extends(String _extends) {
    this._extends = _extends;
    return this;
  }

  /**
   * Inherits properties from another scenario
   * @return _extends
   **/
  @JsonProperty("extends")
  @ApiModelProperty(value = "Inherits properties from another scenario")
 @Size(max=64)  public String getExtends() {
    return _extends;
  }

  public void setExtends(String _extends) {
    this._extends = _extends;
  }

  public Message flow(String flow) {
    this.flow = flow;
    return this;
  }

  /**
   * A stream of messages between actors
   * @return flow
   **/
  @JsonProperty("flow")
  @ApiModelProperty(value = "A stream of messages between actors")
 @Size(max=64)  public String getFlow() {
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
  @JsonProperty("msgType")
  @ApiModelProperty(value = "")
 @Size(max=2)  public String getMsgType() {
    return msgType;
  }

  public void setMsgType(String msgType) {
    this.msgType = msgType;
  }

  public Message category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @JsonProperty("category")
  @ApiModelProperty(value = "")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Message structure(Structure structure) {
    this.structure = structure;
    return this;
  }

  /**
   * Get structure
   * @return structure
   **/
  @JsonProperty("structure")
  @ApiModelProperty(value = "")
  public Structure getStructure() {
    return structure;
  }

  public void setStructure(Structure structure) {
    this.structure = structure;
  }

  public Message responses(List<Response> responses) {
    this.responses = responses;
    return this;
  }

  public Message addResponsesItem(Response responsesItem) {
    if (this.responses == null) {
      this.responses = new ArrayList<>();
    }
    this.responses.add(responsesItem);
    return this;
  }

  /**
   * Get responses
   * @return responses
   **/
  @JsonProperty("responses")
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
    return Objects.equals(this.oid, message.oid) &&
        Objects.equals(this.scenario, message.scenario) &&
        Objects.equals(this._extends, message._extends) &&
        Objects.equals(this.flow, message.flow) &&
        Objects.equals(this.msgType, message.msgType) &&
        Objects.equals(this.category, message.category) &&
        Objects.equals(this.structure, message.structure) &&
        Objects.equals(this.responses, message.responses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oid, scenario, _extends, flow, msgType, category, structure, responses);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Message {\n");
    
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    scenario: ").append(toIndentedString(scenario)).append("\n");
    sb.append("    _extends: ").append(toIndentedString(_extends)).append("\n");
    sb.append("    flow: ").append(toIndentedString(flow)).append("\n");
    sb.append("    msgType: ").append(toIndentedString(msgType)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

