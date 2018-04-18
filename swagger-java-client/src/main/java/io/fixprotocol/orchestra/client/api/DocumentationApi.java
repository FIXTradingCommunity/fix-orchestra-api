package io.fixprotocol.orchestra.client.api;

import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.ApiClient;
import io.fixprotocol.orchestra.client.Configuration;
import io.fixprotocol.orchestra.client.Pair;

import javax.ws.rs.core.GenericType;

import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.ErrorModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-18T14:22:43.321Z")
public class DocumentationApi {
  private ApiClient apiClient;

  public DocumentationApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DocumentationApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * adds an Annotation
   * Adds an Annotation
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId name or ID as a string of the element to annotate (required)
   * @param elementType type of element to annotate (required)
   * @param parentId name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. (optional)
   * @param annotation Annotation to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addAnnotation(String reposName, String version, String elementId, String elementType, String parentId, Annotation annotation) throws ApiException {
    Object localVarPostBody = annotation;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling addAnnotation");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling addAnnotation");
    }
    
    // verify the required parameter 'elementId' is set
    if (elementId == null) {
      throw new ApiException(400, "Missing the required parameter 'elementId' when calling addAnnotation");
    }
    
    // verify the required parameter 'elementType' is set
    if (elementType == null) {
      throw new ApiException(400, "Missing the required parameter 'elementType' when calling addAnnotation");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/annotations"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "elementId", elementId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parentId", parentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "elementType", elementType));

    
    
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
   * deletes a single Annotation
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId name or ID as a string of the element to annotate (required)
   * @param elementType type of element to annotate (required)
   * @param parentId name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. (optional)
   * @throws ApiException if fails to make API call
   */
  public void deleteAnnotation(String reposName, String version, String elementId, String elementType, String parentId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling deleteAnnotation");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling deleteAnnotation");
    }
    
    // verify the required parameter 'elementId' is set
    if (elementId == null) {
      throw new ApiException(400, "Missing the required parameter 'elementId' when calling deleteAnnotation");
    }
    
    // verify the required parameter 'elementType' is set
    if (elementType == null) {
      throw new ApiException(400, "Missing the required parameter 'elementType' when calling deleteAnnotation");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/annotations"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "elementId", elementId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parentId", parentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "elementType", elementType));

    
    
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
   * searches annotations
   * By passing in the appropriate options, you can search for annotations
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId name or ID as a string of the element to annotate (required)
   * @param elementType type of element to annotate (required)
   * @param parentId name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. (optional)
   * @param searchString pass an optional search string for looking up annotations (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return Annotation
   * @throws ApiException if fails to make API call
   */
  public Annotation searchAnnotations(String reposName, String version, String elementId, String elementType, String parentId, String searchString, Integer skip, Integer limit) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling searchAnnotations");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling searchAnnotations");
    }
    
    // verify the required parameter 'elementId' is set
    if (elementId == null) {
      throw new ApiException(400, "Missing the required parameter 'elementId' when calling searchAnnotations");
    }
    
    // verify the required parameter 'elementType' is set
    if (elementType == null) {
      throw new ApiException(400, "Missing the required parameter 'elementType' when calling searchAnnotations");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/annotations"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "elementId", elementId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parentId", parentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "elementType", elementType));
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

    GenericType<Annotation> localVarReturnType = new GenericType<Annotation>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Updates a single Annotation, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId name or ID as a string of the element to annotate (required)
   * @param elementType type of element to annotate (required)
   * @param annotation Annotation to update (required)
   * @param parentId name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. (optional)
   * @throws ApiException if fails to make API call
   */
  public void updateAnnotation(String reposName, String version, String elementId, String elementType, Annotation annotation, String parentId) throws ApiException {
    Object localVarPostBody = annotation;
    
    // verify the required parameter 'reposName' is set
    if (reposName == null) {
      throw new ApiException(400, "Missing the required parameter 'reposName' when calling updateAnnotation");
    }
    
    // verify the required parameter 'version' is set
    if (version == null) {
      throw new ApiException(400, "Missing the required parameter 'version' when calling updateAnnotation");
    }
    
    // verify the required parameter 'elementId' is set
    if (elementId == null) {
      throw new ApiException(400, "Missing the required parameter 'elementId' when calling updateAnnotation");
    }
    
    // verify the required parameter 'elementType' is set
    if (elementType == null) {
      throw new ApiException(400, "Missing the required parameter 'elementType' when calling updateAnnotation");
    }
    
    // verify the required parameter 'annotation' is set
    if (annotation == null) {
      throw new ApiException(400, "Missing the required parameter 'annotation' when calling updateAnnotation");
    }
    
    // create path and map variables
    String localVarPath = "/repositories/{repos-name}/{version}/annotations"
      .replaceAll("\\{" + "repos-name" + "\\}", apiClient.escapeString(reposName.toString()))
      .replaceAll("\\{" + "version" + "\\}", apiClient.escapeString(version.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "elementId", elementId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parentId", parentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "elementType", elementType));

    
    
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
