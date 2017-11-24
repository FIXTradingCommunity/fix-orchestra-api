package io.fixprotocol.orchestra.client.api;

import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.ApiClient;
import io.fixprotocol.orchestra.client.Configuration;
import io.fixprotocol.orchestra.client.Pair;

import javax.ws.rs.core.GenericType;

import io.fixprotocol.orchestra.client.model.Actor;
import io.fixprotocol.orchestra.client.model.ErrorModel;
import io.fixprotocol.orchestra.client.model.Flow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-21T23:02:09.711Z")
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
    String localVarPath = "/repositories/{repos-name}/{version}/actors".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
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
    String localVarPath = "/repositories/{repos-name}/{version}/flows".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
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
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
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
    String localVarPath = "/repositories/{repos-name}/{version}/flows/{name}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
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
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}".replaceAll("\\{format\\}","json")
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
    String localVarPath = "/repositories/{repos-name}/{version}/flows/{name}".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Flow> localVarReturnType = new GenericType<Flow>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches actors
   * By passing in the appropriate options, you can search for actors 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up actors (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Actor>
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
    String localVarPath = "/repositories/{repos-name}/{version}/actors".replaceAll("\\{format\\}","json")
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
   * @param searchString pass an optional search string for looking up flows (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Flow>
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
    String localVarPath = "/repositories/{repos-name}/{version}/flows".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Flow>> localVarReturnType = new GenericType<List<Flow>>() {};
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
    String localVarPath = "/repositories/{repos-name}/{version}/actors/{name}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
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
    String localVarPath = "/repositories/{repos-name}/{version}/flows/{name}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      
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
