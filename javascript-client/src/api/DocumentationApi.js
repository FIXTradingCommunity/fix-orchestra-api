/**
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
 */


import ApiClient from "../ApiClient";
import Annotation from '../model/Annotation';
import ErrorModel from '../model/ErrorModel';

/**
* Documentation service.
* @module api/DocumentationApi
* @version 1.0.0
*/
export default class DocumentationApi {

    /**
    * Constructs a new DocumentationApi. 
    * @alias module:api/DocumentationApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instance} if unspecified.
    */
    constructor(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;
    }


    /**
     * Callback function to receive the result of the addAnnotation operation.
     * @callback module:api/DocumentationApi~addAnnotationCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * adds an Annotation
     * Adds an Annotation
     * @param {String} reposName name of Orchestra repository
     * @param {String} version version of Orchestra repository
     * @param {String} elementId name or ID as a string of the element to annotate
     * @param {module:model/String} elementType type of element to annotate
     * @param {Object} opts Optional parameters
     * @param {String} opts.parentId name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
     * @param {module:model/Annotation} opts.annotation Annotation to add
     * @param {module:api/DocumentationApi~addAnnotationCallback} callback The callback function, accepting three arguments: error, data, response
     */
    addAnnotation(reposName, version, elementId, elementType, opts, callback) {
      opts = opts || {};
      let postBody = opts['annotation'];

      // verify the required parameter 'reposName' is set
      if (reposName === undefined || reposName === null) {
        throw new Error("Missing the required parameter 'reposName' when calling addAnnotation");
      }

      // verify the required parameter 'version' is set
      if (version === undefined || version === null) {
        throw new Error("Missing the required parameter 'version' when calling addAnnotation");
      }

      // verify the required parameter 'elementId' is set
      if (elementId === undefined || elementId === null) {
        throw new Error("Missing the required parameter 'elementId' when calling addAnnotation");
      }

      // verify the required parameter 'elementType' is set
      if (elementType === undefined || elementType === null) {
        throw new Error("Missing the required parameter 'elementType' when calling addAnnotation");
      }


      let pathParams = {
        'repos-name': reposName,
        'version': version
      };
      let queryParams = {
        'elementId': elementId,
        'parentId': opts['parentId'],
        'elementType': elementType
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = ['application/json', 'application/xml'];
      let accepts = ['application/json', 'application/xml'];
      let returnType = null;

      return this.apiClient.callApi(
        '/repositories/{repos-name}/{version}/annotations', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the deleteAnnotation operation.
     * @callback module:api/DocumentationApi~deleteAnnotationCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * deletes a single Annotation
     * @param {String} reposName name of Orchestra repository
     * @param {String} version version of Orchestra repository
     * @param {String} elementId name or ID as a string of the element to annotate
     * @param {module:model/String} elementType type of element to annotate
     * @param {Object} opts Optional parameters
     * @param {String} opts.parentId name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
     * @param {module:api/DocumentationApi~deleteAnnotationCallback} callback The callback function, accepting three arguments: error, data, response
     */
    deleteAnnotation(reposName, version, elementId, elementType, opts, callback) {
      opts = opts || {};
      let postBody = null;

      // verify the required parameter 'reposName' is set
      if (reposName === undefined || reposName === null) {
        throw new Error("Missing the required parameter 'reposName' when calling deleteAnnotation");
      }

      // verify the required parameter 'version' is set
      if (version === undefined || version === null) {
        throw new Error("Missing the required parameter 'version' when calling deleteAnnotation");
      }

      // verify the required parameter 'elementId' is set
      if (elementId === undefined || elementId === null) {
        throw new Error("Missing the required parameter 'elementId' when calling deleteAnnotation");
      }

      // verify the required parameter 'elementType' is set
      if (elementType === undefined || elementType === null) {
        throw new Error("Missing the required parameter 'elementType' when calling deleteAnnotation");
      }


      let pathParams = {
        'repos-name': reposName,
        'version': version
      };
      let queryParams = {
        'elementId': elementId,
        'parentId': opts['parentId'],
        'elementType': elementType
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = ['application/json', 'application/xml'];
      let accepts = ['application/json', 'application/xml'];
      let returnType = null;

      return this.apiClient.callApi(
        '/repositories/{repos-name}/{version}/annotations', 'DELETE',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the searchAnnotations operation.
     * @callback module:api/DocumentationApi~searchAnnotationsCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Annotation} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * searches annotations
     * By passing in the appropriate options, you can search for annotations
     * @param {String} reposName name of Orchestra repository
     * @param {String} version version of Orchestra repository
     * @param {String} elementId name or ID as a string of the element to annotate
     * @param {module:model/String} elementType type of element to annotate
     * @param {Object} opts Optional parameters
     * @param {String} opts.parentId name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
     * @param {String} opts.searchString pass an optional search string for looking up annotations
     * @param {Number} opts.skip number of records to skip for pagination
     * @param {Number} opts.limit maximum number of records to return
     * @param {module:api/DocumentationApi~searchAnnotationsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/Annotation}
     */
    searchAnnotations(reposName, version, elementId, elementType, opts, callback) {
      opts = opts || {};
      let postBody = null;

      // verify the required parameter 'reposName' is set
      if (reposName === undefined || reposName === null) {
        throw new Error("Missing the required parameter 'reposName' when calling searchAnnotations");
      }

      // verify the required parameter 'version' is set
      if (version === undefined || version === null) {
        throw new Error("Missing the required parameter 'version' when calling searchAnnotations");
      }

      // verify the required parameter 'elementId' is set
      if (elementId === undefined || elementId === null) {
        throw new Error("Missing the required parameter 'elementId' when calling searchAnnotations");
      }

      // verify the required parameter 'elementType' is set
      if (elementType === undefined || elementType === null) {
        throw new Error("Missing the required parameter 'elementType' when calling searchAnnotations");
      }


      let pathParams = {
        'repos-name': reposName,
        'version': version
      };
      let queryParams = {
        'elementId': elementId,
        'parentId': opts['parentId'],
        'elementType': elementType,
        'searchString': opts['searchString'],
        'skip': opts['skip'],
        'limit': opts['limit']
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = ['application/json', 'application/xml'];
      let accepts = ['application/json', 'application/xml'];
      let returnType = Annotation;

      return this.apiClient.callApi(
        '/repositories/{repos-name}/{version}/annotations', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the updateAnnotation operation.
     * @callback module:api/DocumentationApi~updateAnnotationCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Updates a single Annotation, if found (idempotent)
     * @param {String} reposName name of Orchestra repository
     * @param {String} version version of Orchestra repository
     * @param {String} elementId name or ID as a string of the element to annotate
     * @param {module:model/String} elementType type of element to annotate
     * @param {module:model/Annotation} annotation Annotation to update
     * @param {Object} opts Optional parameters
     * @param {String} opts.parentId name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
     * @param {module:api/DocumentationApi~updateAnnotationCallback} callback The callback function, accepting three arguments: error, data, response
     */
    updateAnnotation(reposName, version, elementId, elementType, annotation, opts, callback) {
      opts = opts || {};
      let postBody = annotation;

      // verify the required parameter 'reposName' is set
      if (reposName === undefined || reposName === null) {
        throw new Error("Missing the required parameter 'reposName' when calling updateAnnotation");
      }

      // verify the required parameter 'version' is set
      if (version === undefined || version === null) {
        throw new Error("Missing the required parameter 'version' when calling updateAnnotation");
      }

      // verify the required parameter 'elementId' is set
      if (elementId === undefined || elementId === null) {
        throw new Error("Missing the required parameter 'elementId' when calling updateAnnotation");
      }

      // verify the required parameter 'elementType' is set
      if (elementType === undefined || elementType === null) {
        throw new Error("Missing the required parameter 'elementType' when calling updateAnnotation");
      }

      // verify the required parameter 'annotation' is set
      if (annotation === undefined || annotation === null) {
        throw new Error("Missing the required parameter 'annotation' when calling updateAnnotation");
      }


      let pathParams = {
        'repos-name': reposName,
        'version': version
      };
      let queryParams = {
        'elementId': elementId,
        'parentId': opts['parentId'],
        'elementType': elementType
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = ['application/json', 'application/xml'];
      let accepts = ['application/json', 'application/xml'];
      let returnType = null;

      return this.apiClient.callApi(
        '/repositories/{repos-name}/{version}/annotations', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }


}
