package io.fixprotocol.orchestra.client.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import io.fixprotocol.orchestra.client.ApiClient;
import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.Configuration;
import io.fixprotocol.orchestra.client.Pair;
import io.fixprotocol.orchestra.client.model.Actor;
import io.fixprotocol.orchestra.client.model.Flow;
import io.fixprotocol.orchestra.client.model.Response;
import io.fixprotocol.orchestra.client.model.StateMachine;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-23T17:52:38.213Z")
public class WorkflowApi {
  private ApiClient apiClient;

  public WorkflowApi() {
    this(Configuration.getDefaultApiClient());
  }

  public WorkflowApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * adds an Actor
   * Adds an Actor
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param actor Actor to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addActor(String reposName, String version, Actor actor) throws ApiException {
    Object localVarPostBody = actor;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addActor");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addActor");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * adds a Flow
   * Adds a Flow
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param flow Flow to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addFlow(String reposName, String version, Flow flow) throws ApiException {
    Object localVarPostBody = flow;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addFlow");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addFlow");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/flows"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * adds a response to a message scenario
   * Adds a message scenario response
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message to update (required)
   * @param response message response to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addMessageResponse(String reposName, String version, Integer id, Response response) throws ApiException {
    Object localVarPostBody = response;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addMessageResponse");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addMessageResponse");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling addMessageResponse");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages/{id}/responses"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * adds a state machine
   * Adds a StateMachine
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to update (required)
   * @param stateMachine StateMachine to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addStateMachine(String reposName, String version, String name, StateMachine stateMachine) throws ApiException {
    Object localVarPostBody = stateMachine;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addStateMachine");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addStateMachine");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling addStateMachine");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}/statemachines"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * deletes a single Actor based on the name supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteActor(String reposName, String version, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteActor");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteActor");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling deleteActor");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * deletes a single Flow based on the name supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Flow to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteFlow(String reposName, String version, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteFlow");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteFlow");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling deleteFlow");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/flows/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * deletes a single response to a message scenario based on the ID supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message (required)
   * @param name name of message response to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteMessageResponse(String reposName, String version, Integer id, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteMessageResponse");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteMessageResponse");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteMessageResponse");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling deleteMessageResponse");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages/{id}/responses/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * deletes a single StateMachine based on the name supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to update (required)
   * @param smName name of StateMachine to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteStateMachine(String reposName, String version, String name, String smName) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteStateMachine");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteStateMachine");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling deleteStateMachine");
    }
    
    // verify the required parameter 'smName' is set
    if (smName == null) {
      throw new ApiException(400, "Missing the required parameter 'smName' when calling deleteStateMachine");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()))
      .replaceAll("\\{" + "sm-name" + "\\}", apiClient.escapeString(smName.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Returns a single Actor, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to fetch (required)
   * @return Actor
   * @throws ApiException if fails to make API call
   */
  public Actor findActorByName(String reposName, String version, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findActorByName");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findActorByName");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling findActorByName");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Actor> localVarReturnType = new GenericType<Actor>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single Flow, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Flow to fetch (required)
   * @return Flow
   * @throws ApiException if fails to make API call
   */
  public Flow findFlowByName(String reposName, String version, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findFlowByName");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findFlowByName");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling findFlowByName");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/flows/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Flow> localVarReturnType = new GenericType<Flow>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single response to a message scenario, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message (required)
   * @param name name of message response to fetch (required)
   * @return Response
   * @throws ApiException if fails to make API call
   */
  public Response findMessageResponseById(String reposName, String version, Integer id, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findMessageResponseById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findMessageResponseById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling findMessageResponseById");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling findMessageResponseById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages/{id}/responses/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Response> localVarReturnType = new GenericType<Response>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single StateMachine, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to search (required)
   * @param smName name of StateMachine to fetch (required)
   * @return StateMachine
   * @throws ApiException if fails to make API call
   */
  public StateMachine findStateMachine(String reposName, String version, String name, String smName) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findStateMachine");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findStateMachine");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling findStateMachine");
    }
    
    // verify the required parameter 'smName' is set
    if (smName == null) {
      throw new ApiException(400, "Missing the required parameter 'smName' when calling findStateMachine");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()))
      .replaceAll("\\{" + "sm-name" + "\\}", apiClient.escapeString(smName.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<StateMachine> localVarReturnType = new GenericType<StateMachine>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches actors
   * By passing in the appropriate options, you can search for actors 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString Pass an optional search string for looking up actors. It may match on name or abbrName. (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Actor&gt;
   * @throws ApiException if fails to make API call
   */
  public List<Actor> searchActors(String reposName, String version, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchActors");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchActors");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Actor>> localVarReturnType = new GenericType<List<Actor>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches flows
   * By passing in the appropriate options, you can search for flows 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString Pass an optional search string for looking up flows. It may match on name, source, or destination. (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Flow&gt;
   * @throws ApiException if fails to make API call
   */
  public List<Flow> searchFlows(String reposName, String version, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchFlows");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchFlows");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/flows"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Flow>> localVarReturnType = new GenericType<List<Flow>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches message responses
   * By passing in the appropriate options, you can search for message responses
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message to search (required)
   * @param searchString pass an optional search string for looking up responses (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Response&gt;
   * @throws ApiException if fails to make API call
   */
  public List<Response> searchMessageResponses(String reposName, String version, Integer id, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchMessageResponses");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchMessageResponses");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling searchMessageResponses");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages/{id}/responses"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Response>> localVarReturnType = new GenericType<List<Response>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches state machines
   * By passing in the appropriate options, you can search for state machines
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to search (required)
   * @param searchString pass an optional search string for looking up actors (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;StateMachine&gt;
   * @throws ApiException if fails to make API call
   */
  public List<StateMachine> searchStateMachines(String reposName, String version, String name, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchStateMachines");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchStateMachines");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling searchStateMachines");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}/statemachines"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<StateMachine>> localVarReturnType = new GenericType<List<StateMachine>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Updates a single Actor, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of CodeSet to update (required)
   * @param actor Actor to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateActorByName(String reposName, String version, String name, Actor actor) throws ApiException {
    Object localVarPostBody = actor;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateActorByName");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateActorByName");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling updateActorByName");
    }
    
    // verify the required parameter 'actor' is set
    if (actor == null) {
      throw new ApiException(400, "Missing the required parameter 'actor' when calling updateActorByName");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Updates a single Flow, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Flow to update (required)
   * @param actor Flow to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateFlowByName(String reposName, String version, String name, Flow actor) throws ApiException {
    Object localVarPostBody = actor;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateFlowByName");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateFlowByName");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling updateFlowByName");
    }
    
    // verify the required parameter 'actor' is set
    if (actor == null) {
      throw new ApiException(400, "Missing the required parameter 'actor' when calling updateFlowByName");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/flows/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Updates a single response to a message scenario, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message (required)
   * @param name name of message response to update (required)
   * @param response message response to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateMessageResponse(String reposName, String version, Integer id, String name, Response response) throws ApiException {
    Object localVarPostBody = response;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateMessageResponse");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateMessageResponse");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateMessageResponse");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling updateMessageResponse");
    }
    
    // verify the required parameter 'response' is set
    if (response == null) {
      throw new ApiException(400, "Missing the required parameter 'response' when calling updateMessageResponse");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages/{id}/responses/{name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Updates a single StateMachine, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to update (required)
   * @param smName name of StateMachine to update (required)
   * @param stateMachine StateMachine to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateStateMachine(String reposName, String version, String name, String smName, StateMachine stateMachine) throws ApiException {
    Object localVarPostBody = stateMachine;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateStateMachine");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateStateMachine");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling updateStateMachine");
    }
    
    // verify the required parameter 'smName' is set
    if (smName == null) {
      throw new ApiException(400, "Missing the required parameter 'smName' when calling updateStateMachine");
    }
    
    // verify the required parameter 'stateMachine' is set
    if (stateMachine == null) {
      throw new ApiException(400, "Missing the required parameter 'stateMachine' when calling updateStateMachine");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name}"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()))
      .replaceAll("\\{" + "sm-name" + "\\}", apiClient.escapeString(smName.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
