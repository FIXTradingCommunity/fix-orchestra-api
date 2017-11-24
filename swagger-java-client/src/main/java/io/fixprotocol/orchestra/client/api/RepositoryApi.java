package io.fixprotocol.orchestra.client.api;

import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.ApiClient;
import io.fixprotocol.orchestra.client.Configuration;
import io.fixprotocol.orchestra.client.Pair;

import javax.ws.rs.core.GenericType;

import io.fixprotocol.orchestra.client.model.Code;
import io.fixprotocol.orchestra.client.model.CodeSet;
import io.fixprotocol.orchestra.client.model.Component;
import io.fixprotocol.orchestra.client.model.Datatype;
import io.fixprotocol.orchestra.client.model.ErrorModel;
import io.fixprotocol.orchestra.client.model.Field;
import java.io.File;
import io.fixprotocol.orchestra.client.model.Group;
import io.fixprotocol.orchestra.client.model.Message;
import io.fixprotocol.orchestra.client.model.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-21T23:02:09.711Z")
public class RepositoryApi {
  private ApiClient apiClient;

  public RepositoryApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RepositoryApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * adds a Code to CodeSet
   * Adds a Code
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid ID of CodeSet (required)
   * @param code Code to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addCode(String reposName, String version, Integer codesetid, Code code) throws ApiException {
    Object localVarPostBody = code;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addCode");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addCode");
    }
    
    // verify the required parameter 'codesetid' is set
    if (codesetid == null) {
      throw new ApiException(400, "Missing the required parameter 'codesetid' when calling addCode");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets/{codesetid}/codes".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()));

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
   * adds a CodeSet
   * Adds a CodeSet
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codeSet CodeSet to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addCodeSet(String reposName, String version, CodeSet codeSet) throws ApiException {
    Object localVarPostBody = codeSet;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addCodeSet");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addCodeSet");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets".replaceAll("\\{format\\}","json")
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
   * adds a component
   * Adds a component
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param component Component to add (optional)
   * @param toClone ID of component to clone (optional)
   * @throws ApiException if fails to make API call
   */
  public void addComponent(String reposName, String version, Component component, Integer toClone) throws ApiException {
    Object localVarPostBody = component;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addComponent");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addComponent");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/components".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "toClone", toClone));

    
    
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
   * adds a datatype
   * Adds a datatype
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param datatype Datatype to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addDatatype(String reposName, String version, Datatype datatype) throws ApiException {
    Object localVarPostBody = datatype;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addDatatype");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addDatatype");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/datatypes".replaceAll("\\{format\\}","json")
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
   * adds a field
   * Adds a field
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param field field to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addField(String reposName, String version, Field field) throws ApiException {
    Object localVarPostBody = field;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addField");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addField");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/fields".replaceAll("\\{format\\}","json")
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
   * adds a repeating group
   * Adds a group
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param group Group to add (optional)
   * @param toClone ID of group to clone (optional)
   * @throws ApiException if fails to make API call
   */
  public void addGroup(String reposName, String version, Group group, Integer toClone) throws ApiException {
    Object localVarPostBody = group;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addGroup");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addGroup");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/groups".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "toClone", toClone));

    
    
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
   * adds a message scenario
   * Adds a message scenario
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param message message to add (optional)
   * @param toClone ID of message to clone (optional)
   * @throws ApiException if fails to make API call
   */
  public void addMessage(String reposName, String version, Message message, Integer toClone) throws ApiException {
    Object localVarPostBody = message;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addMessage");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addMessage");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "toClone", toClone));

    
    
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
   * adds an Orchestra repository
   * Adds an Orchestra repository
   * @param repository Orchestra repository to add (required)
   * @param nameToClone name of Orchestra repository to clone (optional)
   * @param versionToClone version of Orchestra repository to clone (optional)
   * @throws ApiException if fails to make API call
   */
  public void addRepository(Repository repository, String nameToClone, String versionToClone) throws ApiException {
    Object localVarPostBody = repository;
    
    // verify the required parameter 'repository' is set
    if (repository == null) {
      throw new ApiException(400, "Missing the required parameter 'repository' when calling addRepository");
    }
    
    // create path and map variables
    String localVarPath = "/repositories".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameToClone", nameToClone));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "versionToClone", versionToClone));

    
    
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
   * deletes a single Code based on the ID supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid ID of CodeSet (required)
   * @param id ID of Code to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteCode(String reposName, String version, Integer codesetid, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteCode");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteCode");
    }
    
    // verify the required parameter 'codesetid' is set
    if (codesetid == null) {
      throw new ApiException(400, "Missing the required parameter 'codesetid' when calling deleteCode");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteCode");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * deletes a single CodeSet based on the ID supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of CodeSet to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteCodeSet(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteCodeSet");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteCodeSet");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteCodeSet");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * deletes a single component based on the ID supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of component to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteComponent(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteComponent");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteComponent");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteComponent");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/components/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * deletes a single datatype based on the name supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of datatype to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteDatatype(String reposName, String version, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteDatatype");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteDatatype");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling deleteDatatype");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/datatypes/{name}".replaceAll("\\{format\\}","json")
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
   * deletes a single field based on the ID supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of field to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteField(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteField");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteField");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteField");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/fields/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * deletes a single group based on the ID supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of group to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteGroup(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteGroup");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteGroup");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteGroup");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/groups/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * deletes a single message scenario based on the ID supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteMessage(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteMessage");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteMessage");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteMessage");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * deletes a single Orchestra repository  based on the ID supplied
   * 
   * @param reposName name of Orchestra repository to delete (required)
   * @param version version of Orchestra repository to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteRepository(String reposName, String version) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteRepository");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteRepository");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };


    apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
  /**
   * Retreives a single Orchestra repository file, if found
   * 
   * @param reposName name of Orchestra repository to fetch (required)
   * @param version version of Orchestra repository to fetch (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File downloadRepositoryById(String reposName, String version) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling downloadRepositoryById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling downloadRepositoryById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/file".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/xml"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<File> localVarReturnType = new GenericType<File>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single Code, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid ID of CodeSet (required)
   * @param id ID of Code to fetch (required)
   * @return Code
   * @throws ApiException if fails to make API call
   */
  public Code findCodeById(String reposName, String version, Integer codesetid, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findCodeById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findCodeById");
    }
    
    // verify the required parameter 'codesetid' is set
    if (codesetid == null) {
      throw new ApiException(400, "Missing the required parameter 'codesetid' when calling findCodeById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling findCodeById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()))
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Code> localVarReturnType = new GenericType<Code>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single CodeSet, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of CodeSet to fetch (required)
   * @return CodeSet
   * @throws ApiException if fails to make API call
   */
  public CodeSet findCodeSetById(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findCodeSetById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findCodeSetById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling findCodeSetById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets/{id}".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<CodeSet> localVarReturnType = new GenericType<CodeSet>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single component, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of component to fetch (required)
   * @return Component
   * @throws ApiException if fails to make API call
   */
  public Component findComponentById(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findComponentById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findComponentById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling findComponentById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/components/{id}".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Component> localVarReturnType = new GenericType<Component>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single datatype, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of datatype to fetch (required)
   * @return Datatype
   * @throws ApiException if fails to make API call
   */
  public Datatype findDatatypeByName(String reposName, String version, String name) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findDatatypeByName");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findDatatypeByName");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling findDatatypeByName");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/datatypes/{name}".replaceAll("\\{format\\}","json")
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

    GenericType<Datatype> localVarReturnType = new GenericType<Datatype>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single field, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of field to fetch (required)
   * @return Field
   * @throws ApiException if fails to make API call
   */
  public Field findFieldById(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findFieldById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findFieldById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling findFieldById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/fields/{id}".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Field> localVarReturnType = new GenericType<Field>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single group, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of group to fetch (required)
   * @return Group
   * @throws ApiException if fails to make API call
   */
  public Group findGroupById(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findGroupById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findGroupById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling findGroupById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/groups/{id}".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Group> localVarReturnType = new GenericType<Group>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single message scenario, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message to fetch (required)
   * @return Message
   * @throws ApiException if fails to make API call
   */
  public Message findMessageById(String reposName, String version, Integer id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findMessageById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findMessageById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling findMessageById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages/{id}".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Message> localVarReturnType = new GenericType<Message>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Returns a single Orchestra repository metadata, if found
   * 
   * @param reposName name of Orchestra repository to fetch (required)
   * @param version version of Orchestra repository to fetch (required)
   * @return Repository
   * @throws ApiException if fails to make API call
   */
  public Repository findRepositoryById(String reposName, String version) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling findRepositoryById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling findRepositoryById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}".replaceAll("\\{format\\}","json")
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Repository> localVarReturnType = new GenericType<Repository>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches CodeSets
   * By passing in the appropriate options, you can search for CodeSets 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up CodeSets (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<CodeSet>
   * @throws ApiException if fails to make API call
   */
  public List<CodeSet> searchCodeSets(String reposName, String version, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchCodeSets");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchCodeSets");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets".replaceAll("\\{format\\}","json")
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

    GenericType<List<CodeSet>> localVarReturnType = new GenericType<List<CodeSet>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches Codes within a CodeSet
   * By passing in the appropriate options, you can search for Codes
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid ID of CodeSet (required)
   * @param searchString pass an optional search string for looking up Codes (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Code>
   * @throws ApiException if fails to make API call
   */
  public List<Code> searchCodes(String reposName, String version, Integer codesetid, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchCodes");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchCodes");
    }
    
    // verify the required parameter 'codesetid' is set
    if (codesetid == null) {
      throw new ApiException(400, "Missing the required parameter 'codesetid' when calling searchCodes");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets/{codesetid}/codes".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()));

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

    GenericType<List<Code>> localVarReturnType = new GenericType<List<Code>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches components
   * By passing in the appropriate options, you can search for components 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up components (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Component>
   * @throws ApiException if fails to make API call
   */
  public List<Component> searchComponents(String reposName, String version, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchComponents");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchComponents");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/components".replaceAll("\\{format\\}","json")
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

    GenericType<List<Component>> localVarReturnType = new GenericType<List<Component>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches datatypes
   * By passing in the appropriate options, you can search for datatypes 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up datatypes (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Datatype>
   * @throws ApiException if fails to make API call
   */
  public List<Datatype> searchDatatypes(String reposName, String version, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchDatatypes");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchDatatypes");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/datatypes".replaceAll("\\{format\\}","json")
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

    GenericType<List<Datatype>> localVarReturnType = new GenericType<List<Datatype>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches fields
   * By passing in the appropriate options, you can search for fields 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up fields (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Field>
   * @throws ApiException if fails to make API call
   */
  public List<Field> searchFields(String reposName, String version, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchFields");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchFields");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/fields".replaceAll("\\{format\\}","json")
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

    GenericType<List<Field>> localVarReturnType = new GenericType<List<Field>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches groups
   * By passing in the appropriate options, you can search for groups 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up groups (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Group>
   * @throws ApiException if fails to make API call
   */
  public List<Group> searchGroups(String reposName, String version, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchGroups");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchGroups");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/groups".replaceAll("\\{format\\}","json")
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

    GenericType<List<Group>> localVarReturnType = new GenericType<List<Group>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches messages
   * By passing in the appropriate options, you can search for messages 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up messages (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Message>
   * @throws ApiException if fails to make API call
   */
  public List<Message> searchMessages(String reposName, String version, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchMessages");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchMessages");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages".replaceAll("\\{format\\}","json")
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

    GenericType<List<Message>> localVarReturnType = new GenericType<List<Message>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * searches Orchestra repositories
   * By passing in the appropriate options, you can search for Orchestra repositories
   * @param searchString pass an optional search string for looking up repositories (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Repository>
   * @throws ApiException if fails to make API call
   */
  public List<Repository> searchRepositories(String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/repositories".replaceAll("\\{format\\}","json");

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

    GenericType<List<Repository>> localVarReturnType = new GenericType<List<Repository>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Updates a single Code, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid ID of CodeSet (required)
   * @param id ID of Code to update (required)
   * @param code Code to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateCodeById(String reposName, String version, Integer codesetid, Integer id, Code code) throws ApiException {
    Object localVarPostBody = code;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateCodeById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateCodeById");
    }
    
    // verify the required parameter 'codesetid' is set
    if (codesetid == null) {
      throw new ApiException(400, "Missing the required parameter 'codesetid' when calling updateCodeById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateCodeById");
    }
    
    // verify the required parameter 'code' is set
    if (code == null) {
      throw new ApiException(400, "Missing the required parameter 'code' when calling updateCodeById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * Updates a single CodeSet, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of CodeSet to update (required)
   * @param codeSet CodeSet to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateCodeSetById(String reposName, String version, Integer id, CodeSet codeSet) throws ApiException {
    Object localVarPostBody = codeSet;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateCodeSetById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateCodeSetById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateCodeSetById");
    }
    
    // verify the required parameter 'codeSet' is set
    if (codeSet == null) {
      throw new ApiException(400, "Missing the required parameter 'codeSet' when calling updateCodeSetById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/codesets/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * Updates a single component, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of component to update (required)
   * @param component component to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateComponentById(String reposName, String version, Integer id, Component component) throws ApiException {
    Object localVarPostBody = component;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateComponentById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateComponentById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateComponentById");
    }
    
    // verify the required parameter 'component' is set
    if (component == null) {
      throw new ApiException(400, "Missing the required parameter 'component' when calling updateComponentById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/components/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * Updates a single datatype, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of datatype to update (required)
   * @param datatype datatype to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateDatatypeByName(String reposName, String version, String name, Datatype datatype) throws ApiException {
    Object localVarPostBody = datatype;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateDatatypeByName");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateDatatypeByName");
    }
    
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling updateDatatypeByName");
    }
    
    // verify the required parameter 'datatype' is set
    if (datatype == null) {
      throw new ApiException(400, "Missing the required parameter 'datatype' when calling updateDatatypeByName");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/datatypes/{name}".replaceAll("\\{format\\}","json")
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
   * Updates a single field, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of field to update (required)
   * @param field field to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateFieldById(String reposName, String version, Integer id, Field field) throws ApiException {
    Object localVarPostBody = field;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateFieldById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateFieldById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateFieldById");
    }
    
    // verify the required parameter 'field' is set
    if (field == null) {
      throw new ApiException(400, "Missing the required parameter 'field' when calling updateFieldById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/fields/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * Updates a single group, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of group to update (required)
   * @param group group to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateGroupById(String reposName, String version, Integer id, Group group) throws ApiException {
    Object localVarPostBody = group;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateGroupById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateGroupById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateGroupById");
    }
    
    // verify the required parameter 'group' is set
    if (group == null) {
      throw new ApiException(400, "Missing the required parameter 'group' when calling updateGroupById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/groups/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * Updates a single message scenario, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message to update (required)
   * @param message message to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateMessageById(String reposName, String version, Integer id, Message message) throws ApiException {
    Object localVarPostBody = message;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateMessageById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateMessageById");
    }
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateMessageById");
    }
    
    // verify the required parameter 'message' is set
    if (message == null) {
      throw new ApiException(400, "Missing the required parameter 'message' when calling updateMessageById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/messages/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()))
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

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
   * Updates an Orchestra repository, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository to update (required)
   * @param version version of Orchestra repository to update (required)
   * @param repository Orchestra repository to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateRepositoryById(String reposName, String version, Repository repository) throws ApiException {
    Object localVarPostBody = repository;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateRepositoryById");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateRepositoryById");
    }
    
    // verify the required parameter 'repository' is set
    if (repository == null) {
      throw new ApiException(400, "Missing the required parameter 'repository' when calling updateRepositoryById");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}".replaceAll("\\{format\\}","json")
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


    apiClient.invokeAPI(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, null);
  }
}
