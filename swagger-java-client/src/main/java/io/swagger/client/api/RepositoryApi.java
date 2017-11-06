

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.swagger.client.model.Code;
import io.swagger.client.model.CodeSet;
import io.swagger.client.model.Component;
import io.swagger.client.model.Datatype;
import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Field;
import io.swagger.client.model.Message;
import io.swagger.client.model.Metadata;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /* Build call for addCode */
    private com.squareup.okhttp.Call addCodeCall(String fileid, Integer codesetid, Code code, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = code;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling addCode(Async)");
        }
        
        // verify the required parameter 'codesetid' is set
        if (codesetid == null) {
            throw new ApiException("Missing the required parameter 'codesetid' when calling addCode(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets/{codesetid}/codes".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * adds a Code to CodeSet
     * Adds a Code
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param code Code to add (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addCode(String fileid, Integer codesetid, Code code) throws ApiException {
        addCodeWithHttpInfo(fileid, codesetid, code);
    }

    /**
     * adds a Code to CodeSet
     * Adds a Code
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param code Code to add (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addCodeWithHttpInfo(String fileid, Integer codesetid, Code code) throws ApiException {
        com.squareup.okhttp.Call call = addCodeCall(fileid, codesetid, code, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a Code to CodeSet (asynchronously)
     * Adds a Code
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param code Code to add (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addCodeAsync(String fileid, Integer codesetid, Code code, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addCodeCall(fileid, codesetid, code, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for addCodeSet */
    private com.squareup.okhttp.Call addCodeSetCall(String fileid, CodeSet codeSet, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = codeSet;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling addCodeSet(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * adds a CodeSet
     * Adds a CodeSet
     * @param fileid ID of Orchestra repository file (required)
     * @param codeSet CodeSet to add (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addCodeSet(String fileid, CodeSet codeSet) throws ApiException {
        addCodeSetWithHttpInfo(fileid, codeSet);
    }

    /**
     * adds a CodeSet
     * Adds a CodeSet
     * @param fileid ID of Orchestra repository file (required)
     * @param codeSet CodeSet to add (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addCodeSetWithHttpInfo(String fileid, CodeSet codeSet) throws ApiException {
        com.squareup.okhttp.Call call = addCodeSetCall(fileid, codeSet, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a CodeSet (asynchronously)
     * Adds a CodeSet
     * @param fileid ID of Orchestra repository file (required)
     * @param codeSet CodeSet to add (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addCodeSetAsync(String fileid, CodeSet codeSet, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addCodeSetCall(fileid, codeSet, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for addComponent */
    private com.squareup.okhttp.Call addComponentCall(String fileid, Component component, Integer toClone, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = component;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling addComponent(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/components".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (toClone != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "toClone", toClone));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * adds a component
     * Adds a component
     * @param fileid ID of Orchestra repository file (required)
     * @param component Component to add (optional)
     * @param toClone ID of component to clone (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addComponent(String fileid, Component component, Integer toClone) throws ApiException {
        addComponentWithHttpInfo(fileid, component, toClone);
    }

    /**
     * adds a component
     * Adds a component
     * @param fileid ID of Orchestra repository file (required)
     * @param component Component to add (optional)
     * @param toClone ID of component to clone (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addComponentWithHttpInfo(String fileid, Component component, Integer toClone) throws ApiException {
        com.squareup.okhttp.Call call = addComponentCall(fileid, component, toClone, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a component (asynchronously)
     * Adds a component
     * @param fileid ID of Orchestra repository file (required)
     * @param component Component to add (optional)
     * @param toClone ID of component to clone (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addComponentAsync(String fileid, Component component, Integer toClone, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addComponentCall(fileid, component, toClone, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for addDatatype */
    private com.squareup.okhttp.Call addDatatypeCall(String fileid, Datatype datatype, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = datatype;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling addDatatype(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/datatypes".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * adds a datatype
     * Adds a datatype
     * @param fileid ID of Orchestra repository file (required)
     * @param datatype Datatype to add (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addDatatype(String fileid, Datatype datatype) throws ApiException {
        addDatatypeWithHttpInfo(fileid, datatype);
    }

    /**
     * adds a datatype
     * Adds a datatype
     * @param fileid ID of Orchestra repository file (required)
     * @param datatype Datatype to add (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addDatatypeWithHttpInfo(String fileid, Datatype datatype) throws ApiException {
        com.squareup.okhttp.Call call = addDatatypeCall(fileid, datatype, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a datatype (asynchronously)
     * Adds a datatype
     * @param fileid ID of Orchestra repository file (required)
     * @param datatype Datatype to add (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addDatatypeAsync(String fileid, Datatype datatype, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addDatatypeCall(fileid, datatype, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for addField */
    private com.squareup.okhttp.Call addFieldCall(String fileid, Field field, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = field;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling addField(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/fields".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * adds a field
     * Adds a field
     * @param fileid ID of Orchestra repository file (required)
     * @param field field to add (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addField(String fileid, Field field) throws ApiException {
        addFieldWithHttpInfo(fileid, field);
    }

    /**
     * adds a field
     * Adds a field
     * @param fileid ID of Orchestra repository file (required)
     * @param field field to add (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addFieldWithHttpInfo(String fileid, Field field) throws ApiException {
        com.squareup.okhttp.Call call = addFieldCall(fileid, field, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a field (asynchronously)
     * Adds a field
     * @param fileid ID of Orchestra repository file (required)
     * @param field field to add (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addFieldAsync(String fileid, Field field, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addFieldCall(fileid, field, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for addMessage */
    private com.squareup.okhttp.Call addMessageCall(String fileid, Message message, Integer toClone, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = message;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling addMessage(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/messages".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (toClone != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "toClone", toClone));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * adds a message scenario
     * Adds a message scenario
     * @param fileid ID of Orchestra repository file (required)
     * @param message message to add (optional)
     * @param toClone ID of message to clone (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addMessage(String fileid, Message message, Integer toClone) throws ApiException {
        addMessageWithHttpInfo(fileid, message, toClone);
    }

    /**
     * adds a message scenario
     * Adds a message scenario
     * @param fileid ID of Orchestra repository file (required)
     * @param message message to add (optional)
     * @param toClone ID of message to clone (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addMessageWithHttpInfo(String fileid, Message message, Integer toClone) throws ApiException {
        com.squareup.okhttp.Call call = addMessageCall(fileid, message, toClone, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a message scenario (asynchronously)
     * Adds a message scenario
     * @param fileid ID of Orchestra repository file (required)
     * @param message message to add (optional)
     * @param toClone ID of message to clone (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addMessageAsync(String fileid, Message message, Integer toClone, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addMessageCall(fileid, message, toClone, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for addRepository */
    private com.squareup.okhttp.Call addRepositoryCall(Metadata repository, String toClone, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = repository;
        
        // verify the required parameter 'repository' is set
        if (repository == null) {
            throw new ApiException("Missing the required parameter 'repository' when calling addRepository(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (toClone != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "toClone", toClone));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * adds an Orchestra repository file
     * Adds an Orchestra repository file
     * @param repository Orchestra repository file to add (required)
     * @param toClone ID of Orchestra repository file to clone (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addRepository(Metadata repository, String toClone) throws ApiException {
        addRepositoryWithHttpInfo(repository, toClone);
    }

    /**
     * adds an Orchestra repository file
     * Adds an Orchestra repository file
     * @param repository Orchestra repository file to add (required)
     * @param toClone ID of Orchestra repository file to clone (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addRepositoryWithHttpInfo(Metadata repository, String toClone) throws ApiException {
        com.squareup.okhttp.Call call = addRepositoryCall(repository, toClone, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds an Orchestra repository file (asynchronously)
     * Adds an Orchestra repository file
     * @param repository Orchestra repository file to add (required)
     * @param toClone ID of Orchestra repository file to clone (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addRepositoryAsync(Metadata repository, String toClone, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addRepositoryCall(repository, toClone, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for deleteCode */
    private com.squareup.okhttp.Call deleteCodeCall(String fileid, Integer codesetid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling deleteCode(Async)");
        }
        
        // verify the required parameter 'codesetid' is set
        if (codesetid == null) {
            throw new ApiException("Missing the required parameter 'codesetid' when calling deleteCode(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteCode(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets/{codesetid}/codes/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * deletes a single Code based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of field to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteCode(String fileid, Integer codesetid, Integer id) throws ApiException {
        deleteCodeWithHttpInfo(fileid, codesetid, id);
    }

    /**
     * deletes a single Code based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of field to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteCodeWithHttpInfo(String fileid, Integer codesetid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteCodeCall(fileid, codesetid, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single Code based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of field to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCodeAsync(String fileid, Integer codesetid, Integer id, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteCodeCall(fileid, codesetid, id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for deleteCodeSet */
    private com.squareup.okhttp.Call deleteCodeSetCall(String fileid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling deleteCodeSet(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteCodeSet(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * deletes a single CodeSet based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteCodeSet(String fileid, Integer id) throws ApiException {
        deleteCodeSetWithHttpInfo(fileid, id);
    }

    /**
     * deletes a single CodeSet based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteCodeSetWithHttpInfo(String fileid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteCodeSetCall(fileid, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single CodeSet based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteCodeSetAsync(String fileid, Integer id, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteCodeSetCall(fileid, id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for deleteComponent */
    private com.squareup.okhttp.Call deleteComponentCall(String fileid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling deleteComponent(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteComponent(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/components/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * deletes a single component based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteComponent(String fileid, Integer id) throws ApiException {
        deleteComponentWithHttpInfo(fileid, id);
    }

    /**
     * deletes a single component based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteComponentWithHttpInfo(String fileid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteComponentCall(fileid, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single component based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteComponentAsync(String fileid, Integer id, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteComponentCall(fileid, id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for deleteDatatype */
    private com.squareup.okhttp.Call deleteDatatypeCall(String fileid, String name, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling deleteDatatype(Async)");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling deleteDatatype(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/datatypes/{name}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * deletes a single datatype based on the name supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteDatatype(String fileid, String name) throws ApiException {
        deleteDatatypeWithHttpInfo(fileid, name);
    }

    /**
     * deletes a single datatype based on the name supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteDatatypeWithHttpInfo(String fileid, String name) throws ApiException {
        com.squareup.okhttp.Call call = deleteDatatypeCall(fileid, name, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single datatype based on the name supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteDatatypeAsync(String fileid, String name, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteDatatypeCall(fileid, name, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for deleteField */
    private com.squareup.okhttp.Call deleteFieldCall(String fileid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling deleteField(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteField(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/fields/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * deletes a single field based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteField(String fileid, Integer id) throws ApiException {
        deleteFieldWithHttpInfo(fileid, id);
    }

    /**
     * deletes a single field based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteFieldWithHttpInfo(String fileid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteFieldCall(fileid, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single field based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFieldAsync(String fileid, Integer id, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFieldCall(fileid, id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for deleteMessage */
    private com.squareup.okhttp.Call deleteMessageCall(String fileid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling deleteMessage(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteMessage(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/messages/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * deletes a single message scenario based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteMessage(String fileid, Integer id) throws ApiException {
        deleteMessageWithHttpInfo(fileid, id);
    }

    /**
     * deletes a single message scenario based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteMessageWithHttpInfo(String fileid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteMessageCall(fileid, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single message scenario based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteMessageAsync(String fileid, Integer id, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteMessageCall(fileid, id, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for deleteRepository */
    private com.squareup.okhttp.Call deleteRepositoryCall(String fileid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling deleteRepository(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * deletes a single Orchestra repository file based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteRepository(String fileid) throws ApiException {
        deleteRepositoryWithHttpInfo(fileid);
    }

    /**
     * deletes a single Orchestra repository file based on the ID supplied
     * 
     * @param fileid ID of Orchestra repository file to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteRepositoryWithHttpInfo(String fileid) throws ApiException {
        com.squareup.okhttp.Call call = deleteRepositoryCall(fileid, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single Orchestra repository file based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteRepositoryAsync(String fileid, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteRepositoryCall(fileid, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for findCodeById */
    private com.squareup.okhttp.Call findCodeByIdCall(String fileid, Integer codesetid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling findCodeById(Async)");
        }
        
        // verify the required parameter 'codesetid' is set
        if (codesetid == null) {
            throw new ApiException("Missing the required parameter 'codesetid' when calling findCodeById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling findCodeById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets/{codesetid}/codes/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Returns a single Code, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of Code to fetch (required)
     * @return Code
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Code findCodeById(String fileid, Integer codesetid, Integer id) throws ApiException {
        ApiResponse<Code> resp = findCodeByIdWithHttpInfo(fileid, codesetid, id);
        return resp.getData();
    }

    /**
     * Returns a single Code, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of Code to fetch (required)
     * @return ApiResponse&lt;Code&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Code> findCodeByIdWithHttpInfo(String fileid, Integer codesetid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = findCodeByIdCall(fileid, codesetid, id, null, null);
        Type localVarReturnType = new TypeToken<Code>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a single Code, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of Code to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findCodeByIdAsync(String fileid, Integer codesetid, Integer id, final ApiCallback<Code> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findCodeByIdCall(fileid, codesetid, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Code>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for findCodeSetById */
    private com.squareup.okhttp.Call findCodeSetByIdCall(String fileid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling findCodeSetById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling findCodeSetById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Returns a single CodeSet, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of CodeSet to fetch (required)
     * @return CodeSet
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CodeSet findCodeSetById(String fileid, Integer id) throws ApiException {
        ApiResponse<CodeSet> resp = findCodeSetByIdWithHttpInfo(fileid, id);
        return resp.getData();
    }

    /**
     * Returns a single CodeSet, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of CodeSet to fetch (required)
     * @return ApiResponse&lt;CodeSet&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CodeSet> findCodeSetByIdWithHttpInfo(String fileid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = findCodeSetByIdCall(fileid, id, null, null);
        Type localVarReturnType = new TypeToken<CodeSet>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a single CodeSet, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of CodeSet to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findCodeSetByIdAsync(String fileid, Integer id, final ApiCallback<CodeSet> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findCodeSetByIdCall(fileid, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CodeSet>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for findComponentById */
    private com.squareup.okhttp.Call findComponentByIdCall(String fileid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling findComponentById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling findComponentById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/components/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Returns a single component, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to fetch (required)
     * @return Component
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Component findComponentById(String fileid, Integer id) throws ApiException {
        ApiResponse<Component> resp = findComponentByIdWithHttpInfo(fileid, id);
        return resp.getData();
    }

    /**
     * Returns a single component, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to fetch (required)
     * @return ApiResponse&lt;Component&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Component> findComponentByIdWithHttpInfo(String fileid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = findComponentByIdCall(fileid, id, null, null);
        Type localVarReturnType = new TypeToken<Component>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a single component, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findComponentByIdAsync(String fileid, Integer id, final ApiCallback<Component> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findComponentByIdCall(fileid, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Component>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for findDatatypeByName */
    private com.squareup.okhttp.Call findDatatypeByNameCall(String fileid, String name, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling findDatatypeByName(Async)");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling findDatatypeByName(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/datatypes/{name}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Returns a single datatype, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to fetch (required)
     * @return Datatype
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Datatype findDatatypeByName(String fileid, String name) throws ApiException {
        ApiResponse<Datatype> resp = findDatatypeByNameWithHttpInfo(fileid, name);
        return resp.getData();
    }

    /**
     * Returns a single datatype, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to fetch (required)
     * @return ApiResponse&lt;Datatype&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Datatype> findDatatypeByNameWithHttpInfo(String fileid, String name) throws ApiException {
        com.squareup.okhttp.Call call = findDatatypeByNameCall(fileid, name, null, null);
        Type localVarReturnType = new TypeToken<Datatype>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a single datatype, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findDatatypeByNameAsync(String fileid, String name, final ApiCallback<Datatype> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findDatatypeByNameCall(fileid, name, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Datatype>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for findFieldById */
    private com.squareup.okhttp.Call findFieldByIdCall(String fileid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling findFieldById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling findFieldById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/fields/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Returns a single field, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to fetch (required)
     * @return Field
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Field findFieldById(String fileid, Integer id) throws ApiException {
        ApiResponse<Field> resp = findFieldByIdWithHttpInfo(fileid, id);
        return resp.getData();
    }

    /**
     * Returns a single field, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to fetch (required)
     * @return ApiResponse&lt;Field&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Field> findFieldByIdWithHttpInfo(String fileid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = findFieldByIdCall(fileid, id, null, null);
        Type localVarReturnType = new TypeToken<Field>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a single field, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findFieldByIdAsync(String fileid, Integer id, final ApiCallback<Field> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findFieldByIdCall(fileid, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Field>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for findMessageById */
    private com.squareup.okhttp.Call findMessageByIdCall(String fileid, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling findMessageById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling findMessageById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/messages/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Returns a single message scenario, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to fetch (required)
     * @return Message
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Message findMessageById(String fileid, Integer id) throws ApiException {
        ApiResponse<Message> resp = findMessageByIdWithHttpInfo(fileid, id);
        return resp.getData();
    }

    /**
     * Returns a single message scenario, if found
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to fetch (required)
     * @return ApiResponse&lt;Message&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Message> findMessageByIdWithHttpInfo(String fileid, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = findMessageByIdCall(fileid, id, null, null);
        Type localVarReturnType = new TypeToken<Message>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a single message scenario, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findMessageByIdAsync(String fileid, Integer id, final ApiCallback<Message> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findMessageByIdCall(fileid, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Message>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for findRepositoryById */
    private com.squareup.okhttp.Call findRepositoryByIdCall(String fileid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling findRepositoryById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Returns a single Orchestra repository file metadata, if found
     * 
     * @param fileid ID of Orchestra repository file to fetch (required)
     * @return Metadata
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Metadata findRepositoryById(String fileid) throws ApiException {
        ApiResponse<Metadata> resp = findRepositoryByIdWithHttpInfo(fileid);
        return resp.getData();
    }

    /**
     * Returns a single Orchestra repository file metadata, if found
     * 
     * @param fileid ID of Orchestra repository file to fetch (required)
     * @return ApiResponse&lt;Metadata&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Metadata> findRepositoryByIdWithHttpInfo(String fileid) throws ApiException {
        com.squareup.okhttp.Call call = findRepositoryByIdCall(fileid, null, null);
        Type localVarReturnType = new TypeToken<Metadata>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a single Orchestra repository file metadata, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findRepositoryByIdAsync(String fileid, final ApiCallback<Metadata> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findRepositoryByIdCall(fileid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Metadata>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchCodeSets */
    private com.squareup.okhttp.Call searchCodeSetsCall(String fileid, String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling searchCodeSets(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (searchString != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * searches CodeSets
     * By passing in the appropriate options, you can search for CodeSets 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up CodeSets (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;CodeSet&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<CodeSet> searchCodeSets(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        ApiResponse<List<CodeSet>> resp = searchCodeSetsWithHttpInfo(fileid, searchString, skip, limit);
        return resp.getData();
    }

    /**
     * searches CodeSets
     * By passing in the appropriate options, you can search for CodeSets 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up CodeSets (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;CodeSet&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<CodeSet>> searchCodeSetsWithHttpInfo(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchCodeSetsCall(fileid, searchString, skip, limit, null, null);
        Type localVarReturnType = new TypeToken<List<CodeSet>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches CodeSets (asynchronously)
     * By passing in the appropriate options, you can search for CodeSets 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up CodeSets (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchCodeSetsAsync(String fileid, String searchString, Integer skip, Integer limit, final ApiCallback<List<CodeSet>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchCodeSetsCall(fileid, searchString, skip, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<CodeSet>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchCodes */
    private com.squareup.okhttp.Call searchCodesCall(String fileid, Integer codesetid, String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling searchCodes(Async)");
        }
        
        // verify the required parameter 'codesetid' is set
        if (codesetid == null) {
            throw new ApiException("Missing the required parameter 'codesetid' when calling searchCodes(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets/{codesetid}/codes".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (searchString != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * searches Codes within a CodeSet
     * By passing in the appropriate options, you can search for Codes 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param searchString pass an optional search string for looking up Codes (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;Code&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Code> searchCodes(String fileid, Integer codesetid, String searchString, Integer skip, Integer limit) throws ApiException {
        ApiResponse<List<Code>> resp = searchCodesWithHttpInfo(fileid, codesetid, searchString, skip, limit);
        return resp.getData();
    }

    /**
     * searches Codes within a CodeSet
     * By passing in the appropriate options, you can search for Codes 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param searchString pass an optional search string for looking up Codes (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;Code&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Code>> searchCodesWithHttpInfo(String fileid, Integer codesetid, String searchString, Integer skip, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchCodesCall(fileid, codesetid, searchString, skip, limit, null, null);
        Type localVarReturnType = new TypeToken<List<Code>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches Codes within a CodeSet (asynchronously)
     * By passing in the appropriate options, you can search for Codes 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param searchString pass an optional search string for looking up Codes (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchCodesAsync(String fileid, Integer codesetid, String searchString, Integer skip, Integer limit, final ApiCallback<List<Code>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchCodesCall(fileid, codesetid, searchString, skip, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Code>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchComponents */
    private com.squareup.okhttp.Call searchComponentsCall(String fileid, String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling searchComponents(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/components".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (searchString != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * searches components
     * By passing in the appropriate options, you can search for components 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;Component&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Component> searchComponents(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        ApiResponse<List<Component>> resp = searchComponentsWithHttpInfo(fileid, searchString, skip, limit);
        return resp.getData();
    }

    /**
     * searches components
     * By passing in the appropriate options, you can search for components 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;Component&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Component>> searchComponentsWithHttpInfo(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchComponentsCall(fileid, searchString, skip, limit, null, null);
        Type localVarReturnType = new TypeToken<List<Component>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches components (asynchronously)
     * By passing in the appropriate options, you can search for components 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchComponentsAsync(String fileid, String searchString, Integer skip, Integer limit, final ApiCallback<List<Component>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchComponentsCall(fileid, searchString, skip, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Component>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchDatatypes */
    private com.squareup.okhttp.Call searchDatatypesCall(String fileid, String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling searchDatatypes(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/datatypes".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (searchString != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * searches datatypes
     * By passing in the appropriate options, you can search for datatypes 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up datatypes (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;Datatype&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Datatype> searchDatatypes(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        ApiResponse<List<Datatype>> resp = searchDatatypesWithHttpInfo(fileid, searchString, skip, limit);
        return resp.getData();
    }

    /**
     * searches datatypes
     * By passing in the appropriate options, you can search for datatypes 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up datatypes (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;Datatype&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Datatype>> searchDatatypesWithHttpInfo(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchDatatypesCall(fileid, searchString, skip, limit, null, null);
        Type localVarReturnType = new TypeToken<List<Datatype>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches datatypes (asynchronously)
     * By passing in the appropriate options, you can search for datatypes 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up datatypes (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchDatatypesAsync(String fileid, String searchString, Integer skip, Integer limit, final ApiCallback<List<Datatype>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchDatatypesCall(fileid, searchString, skip, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Datatype>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchFields */
    private com.squareup.okhttp.Call searchFieldsCall(String fileid, String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling searchFields(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/fields".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (searchString != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * searches fields
     * By passing in the appropriate options, you can search for fields 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up fields (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;Field&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Field> searchFields(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        ApiResponse<List<Field>> resp = searchFieldsWithHttpInfo(fileid, searchString, skip, limit);
        return resp.getData();
    }

    /**
     * searches fields
     * By passing in the appropriate options, you can search for fields 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up fields (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;Field&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Field>> searchFieldsWithHttpInfo(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchFieldsCall(fileid, searchString, skip, limit, null, null);
        Type localVarReturnType = new TypeToken<List<Field>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches fields (asynchronously)
     * By passing in the appropriate options, you can search for fields 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up fields (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchFieldsAsync(String fileid, String searchString, Integer skip, Integer limit, final ApiCallback<List<Field>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchFieldsCall(fileid, searchString, skip, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Field>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchMessages */
    private com.squareup.okhttp.Call searchMessagesCall(String fileid, String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling searchMessages(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/messages".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (searchString != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * searches messages
     * By passing in the appropriate options, you can search for messages 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up messages (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;Message&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Message> searchMessages(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        ApiResponse<List<Message>> resp = searchMessagesWithHttpInfo(fileid, searchString, skip, limit);
        return resp.getData();
    }

    /**
     * searches messages
     * By passing in the appropriate options, you can search for messages 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up messages (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;Message&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Message>> searchMessagesWithHttpInfo(String fileid, String searchString, Integer skip, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchMessagesCall(fileid, searchString, skip, limit, null, null);
        Type localVarReturnType = new TypeToken<List<Message>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches messages (asynchronously)
     * By passing in the appropriate options, you can search for messages 
     * @param fileid ID of Orchestra repository file (required)
     * @param searchString pass an optional search string for looking up messages (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchMessagesAsync(String fileid, String searchString, Integer skip, Integer limit, final ApiCallback<List<Message>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchMessagesCall(fileid, searchString, skip, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Message>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchRepositories */
    private com.squareup.okhttp.Call searchRepositoriesCall(String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/repositories".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (searchString != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchString", searchString));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * searches Orchestra repository files
     * By passing in the appropriate options, you can search for Orchestra repository files 
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;Metadata&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Metadata> searchRepositories(String searchString, Integer skip, Integer limit) throws ApiException {
        ApiResponse<List<Metadata>> resp = searchRepositoriesWithHttpInfo(searchString, skip, limit);
        return resp.getData();
    }

    /**
     * searches Orchestra repository files
     * By passing in the appropriate options, you can search for Orchestra repository files 
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;Metadata&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Metadata>> searchRepositoriesWithHttpInfo(String searchString, Integer skip, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchRepositoriesCall(searchString, skip, limit, null, null);
        Type localVarReturnType = new TypeToken<List<Metadata>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches Orchestra repository files (asynchronously)
     * By passing in the appropriate options, you can search for Orchestra repository files 
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchRepositoriesAsync(String searchString, Integer skip, Integer limit, final ApiCallback<List<Metadata>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchRepositoriesCall(searchString, skip, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Metadata>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for updateCodeById */
    private com.squareup.okhttp.Call updateCodeByIdCall(String fileid, Integer codesetid, Integer id, Code code, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = code;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling updateCodeById(Async)");
        }
        
        // verify the required parameter 'codesetid' is set
        if (codesetid == null) {
            throw new ApiException("Missing the required parameter 'codesetid' when calling updateCodeById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateCodeById(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling updateCodeById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets/{codesetid}/codes/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "codesetid" + "\\}", apiClient.escapeString(codesetid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Updates a single Code, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of Code to update (required)
     * @param code Code to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateCodeById(String fileid, Integer codesetid, Integer id, Code code) throws ApiException {
        updateCodeByIdWithHttpInfo(fileid, codesetid, id, code);
    }

    /**
     * Updates a single Code, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of Code to update (required)
     * @param code Code to update (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateCodeByIdWithHttpInfo(String fileid, Integer codesetid, Integer id, Code code) throws ApiException {
        com.squareup.okhttp.Call call = updateCodeByIdCall(fileid, codesetid, id, code, null, null);
        return apiClient.execute(call);
    }

    /**
     * Updates a single Code, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param codesetid ID of CodeSet (required)
     * @param id ID of Code to update (required)
     * @param code Code to update (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateCodeByIdAsync(String fileid, Integer codesetid, Integer id, Code code, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateCodeByIdCall(fileid, codesetid, id, code, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for updateCodeSetById */
    private com.squareup.okhttp.Call updateCodeSetByIdCall(String fileid, Integer id, CodeSet codeSet, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = codeSet;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling updateCodeSetById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateCodeSetById(Async)");
        }
        
        // verify the required parameter 'codeSet' is set
        if (codeSet == null) {
            throw new ApiException("Missing the required parameter 'codeSet' when calling updateCodeSetById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/codesets/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Updates a single CodeSet, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of CodeSet to update (required)
     * @param codeSet CodeSet to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateCodeSetById(String fileid, Integer id, CodeSet codeSet) throws ApiException {
        updateCodeSetByIdWithHttpInfo(fileid, id, codeSet);
    }

    /**
     * Updates a single CodeSet, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of CodeSet to update (required)
     * @param codeSet CodeSet to update (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateCodeSetByIdWithHttpInfo(String fileid, Integer id, CodeSet codeSet) throws ApiException {
        com.squareup.okhttp.Call call = updateCodeSetByIdCall(fileid, id, codeSet, null, null);
        return apiClient.execute(call);
    }

    /**
     * Updates a single CodeSet, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of CodeSet to update (required)
     * @param codeSet CodeSet to update (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateCodeSetByIdAsync(String fileid, Integer id, CodeSet codeSet, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateCodeSetByIdCall(fileid, id, codeSet, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for updateComponentById */
    private com.squareup.okhttp.Call updateComponentByIdCall(String fileid, Integer id, Component component, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = component;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling updateComponentById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateComponentById(Async)");
        }
        
        // verify the required parameter 'component' is set
        if (component == null) {
            throw new ApiException("Missing the required parameter 'component' when calling updateComponentById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/components/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Updates a single component, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to update (required)
     * @param component component to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateComponentById(String fileid, Integer id, Component component) throws ApiException {
        updateComponentByIdWithHttpInfo(fileid, id, component);
    }

    /**
     * Updates a single component, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to update (required)
     * @param component component to update (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateComponentByIdWithHttpInfo(String fileid, Integer id, Component component) throws ApiException {
        com.squareup.okhttp.Call call = updateComponentByIdCall(fileid, id, component, null, null);
        return apiClient.execute(call);
    }

    /**
     * Updates a single component, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of component to update (required)
     * @param component component to update (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateComponentByIdAsync(String fileid, Integer id, Component component, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateComponentByIdCall(fileid, id, component, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for updateDatatypeByName */
    private com.squareup.okhttp.Call updateDatatypeByNameCall(String fileid, String name, Datatype datatype, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = datatype;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling updateDatatypeByName(Async)");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling updateDatatypeByName(Async)");
        }
        
        // verify the required parameter 'datatype' is set
        if (datatype == null) {
            throw new ApiException("Missing the required parameter 'datatype' when calling updateDatatypeByName(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/datatypes/{name}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "name" + "\\}", apiClient.escapeString(name.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Updates a single datatype, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to update (required)
     * @param datatype datatype to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateDatatypeByName(String fileid, String name, Datatype datatype) throws ApiException {
        updateDatatypeByNameWithHttpInfo(fileid, name, datatype);
    }

    /**
     * Updates a single datatype, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to update (required)
     * @param datatype datatype to update (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateDatatypeByNameWithHttpInfo(String fileid, String name, Datatype datatype) throws ApiException {
        com.squareup.okhttp.Call call = updateDatatypeByNameCall(fileid, name, datatype, null, null);
        return apiClient.execute(call);
    }

    /**
     * Updates a single datatype, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param name name of datatype to update (required)
     * @param datatype datatype to update (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateDatatypeByNameAsync(String fileid, String name, Datatype datatype, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateDatatypeByNameCall(fileid, name, datatype, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for updateFieldById */
    private com.squareup.okhttp.Call updateFieldByIdCall(String fileid, Integer id, Field field, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = field;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling updateFieldById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateFieldById(Async)");
        }
        
        // verify the required parameter 'field' is set
        if (field == null) {
            throw new ApiException("Missing the required parameter 'field' when calling updateFieldById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/fields/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Updates a single field, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to update (required)
     * @param field field to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateFieldById(String fileid, Integer id, Field field) throws ApiException {
        updateFieldByIdWithHttpInfo(fileid, id, field);
    }

    /**
     * Updates a single field, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to update (required)
     * @param field field to update (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateFieldByIdWithHttpInfo(String fileid, Integer id, Field field) throws ApiException {
        com.squareup.okhttp.Call call = updateFieldByIdCall(fileid, id, field, null, null);
        return apiClient.execute(call);
    }

    /**
     * Updates a single field, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of field to update (required)
     * @param field field to update (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateFieldByIdAsync(String fileid, Integer id, Field field, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateFieldByIdCall(fileid, id, field, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for updateMessageById */
    private com.squareup.okhttp.Call updateMessageByIdCall(String fileid, Integer id, Message message, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = message;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling updateMessageById(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateMessageById(Async)");
        }
        
        // verify the required parameter 'message' is set
        if (message == null) {
            throw new ApiException("Missing the required parameter 'message' when calling updateMessageById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}/messages/{id}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()))
        .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Updates a single message scenario, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to update (required)
     * @param message message to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateMessageById(String fileid, Integer id, Message message) throws ApiException {
        updateMessageByIdWithHttpInfo(fileid, id, message);
    }

    /**
     * Updates a single message scenario, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to update (required)
     * @param message message to update (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateMessageByIdWithHttpInfo(String fileid, Integer id, Message message) throws ApiException {
        com.squareup.okhttp.Call call = updateMessageByIdCall(fileid, id, message, null, null);
        return apiClient.execute(call);
    }

    /**
     * Updates a single message scenario, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file (required)
     * @param id ID of message to update (required)
     * @param message message to update (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateMessageByIdAsync(String fileid, Integer id, Message message, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateMessageByIdCall(fileid, id, message, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for updateRepositoryById */
    private com.squareup.okhttp.Call updateRepositoryByIdCall(String fileid, Metadata repository, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = repository;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling updateRepositoryById(Async)");
        }
        
        // verify the required parameter 'repository' is set
        if (repository == null) {
            throw new ApiException("Missing the required parameter 'repository' when calling updateRepositoryById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/repositories/{fileid}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "fileid" + "\\}", apiClient.escapeString(fileid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Updates an Orchestra repository file, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file to update (required)
     * @param repository Orchestra repository file to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateRepositoryById(String fileid, Metadata repository) throws ApiException {
        updateRepositoryByIdWithHttpInfo(fileid, repository);
    }

    /**
     * Updates an Orchestra repository file, if found (idempotent)
     * 
     * @param fileid ID of Orchestra repository file to update (required)
     * @param repository Orchestra repository file to update (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateRepositoryByIdWithHttpInfo(String fileid, Metadata repository) throws ApiException {
        com.squareup.okhttp.Call call = updateRepositoryByIdCall(fileid, repository, null, null);
        return apiClient.execute(call);
    }

    /**
     * Updates an Orchestra repository file, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra repository file to update (required)
     * @param repository Orchestra repository file to update (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateRepositoryByIdAsync(String fileid, Metadata repository, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateRepositoryByIdCall(fileid, repository, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
