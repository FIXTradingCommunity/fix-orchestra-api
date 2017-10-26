

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

import io.swagger.client.model.Component;
import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Field;
import io.swagger.client.model.Message;
import io.swagger.client.model.Orchestra;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagesApi {
    private ApiClient apiClient;

    public MessagesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MessagesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for addComponent */
    private com.squareup.okhttp.Call addComponentCall(String fileid, Component component, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = component;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling addComponent(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/orchestra/{fileid}/components".replaceAll("\\{format\\}","json")
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
     * adds a component
     * Adds a component
     * @param fileid ID of Orchestra file (required)
     * @param component Component to add (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addComponent(String fileid, Component component) throws ApiException {
        addComponentWithHttpInfo(fileid, component);
    }

    /**
     * adds a component
     * Adds a component
     * @param fileid ID of Orchestra file (required)
     * @param component Component to add (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addComponentWithHttpInfo(String fileid, Component component) throws ApiException {
        com.squareup.okhttp.Call call = addComponentCall(fileid, component, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a component (asynchronously)
     * Adds a component
     * @param fileid ID of Orchestra file (required)
     * @param component Component to add (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addComponentAsync(String fileid, Component component, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addComponentCall(fileid, component, progressListener, progressRequestListener);
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
        String localVarPath = "/orchestra/{fileid}/fields".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
     * @param field field to add (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addField(String fileid, Field field) throws ApiException {
        addFieldWithHttpInfo(fileid, field);
    }

    /**
     * adds a field
     * Adds a field
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
    private com.squareup.okhttp.Call addMessageCall(String fileid, Message message, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = message;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling addMessage(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/orchestra/{fileid}/messages".replaceAll("\\{format\\}","json")
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
     * adds a message scenario
     * Adds a message scenario
     * @param fileid ID of Orchestra file (required)
     * @param message message to add (optional)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addMessage(String fileid, Message message) throws ApiException {
        addMessageWithHttpInfo(fileid, message);
    }

    /**
     * adds a message scenario
     * Adds a message scenario
     * @param fileid ID of Orchestra file (required)
     * @param message message to add (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addMessageWithHttpInfo(String fileid, Message message) throws ApiException {
        com.squareup.okhttp.Call call = addMessageCall(fileid, message, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds a message scenario (asynchronously)
     * Adds a message scenario
     * @param fileid ID of Orchestra file (required)
     * @param message message to add (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addMessageAsync(String fileid, Message message, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addMessageCall(fileid, message, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for deleteComponent */
    private com.squareup.okhttp.Call deleteComponentCall(String fileid, Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
        String localVarPath = "/orchestra/{fileid}/components/{id}".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
     * @param id ID of field to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteComponent(String fileid, Long id) throws ApiException {
        deleteComponentWithHttpInfo(fileid, id);
    }

    /**
     * deletes a single component based on the ID supplied
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of field to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteComponentWithHttpInfo(String fileid, Long id) throws ApiException {
        com.squareup.okhttp.Call call = deleteComponentCall(fileid, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single component based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of field to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteComponentAsync(String fileid, Long id, final ApiCallback<Void> callback) throws ApiException {

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
    /* Build call for deleteField */
    private com.squareup.okhttp.Call deleteFieldCall(String fileid, Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
        String localVarPath = "/orchestra/{fileid}/fields/{id}".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
     * @param id ID of field to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteField(String fileid, Long id) throws ApiException {
        deleteFieldWithHttpInfo(fileid, id);
    }

    /**
     * deletes a single field based on the ID supplied
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of field to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteFieldWithHttpInfo(String fileid, Long id) throws ApiException {
        com.squareup.okhttp.Call call = deleteFieldCall(fileid, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single field based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of field to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFieldAsync(String fileid, Long id, final ApiCallback<Void> callback) throws ApiException {

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
    private com.squareup.okhttp.Call deleteMessageCall(String fileid, Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
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
        String localVarPath = "/orchesra/{fileid}/messages/{id}".replaceAll("\\{format\\}","json")
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
     * deletes a single message based on the ID supplied
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of message to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteMessage(String fileid, Long id) throws ApiException {
        deleteMessageWithHttpInfo(fileid, id);
    }

    /**
     * deletes a single message based on the ID supplied
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of message to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteMessageWithHttpInfo(String fileid, Long id) throws ApiException {
        com.squareup.okhttp.Call call = deleteMessageCall(fileid, id, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single message based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of message to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteMessageAsync(String fileid, Long id, final ApiCallback<Void> callback) throws ApiException {

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
    /* Build call for deleteOrchestra */
    private com.squareup.okhttp.Call deleteOrchestraCall(String fileid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling deleteOrchestra(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/orchestra/{fileid}".replaceAll("\\{format\\}","json")
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
     * deletes a single Orchestra file based on the ID supplied
     * 
     * @param fileid ID of Orchestra file to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteOrchestra(String fileid) throws ApiException {
        deleteOrchestraWithHttpInfo(fileid);
    }

    /**
     * deletes a single Orchestra file based on the ID supplied
     * 
     * @param fileid ID of Orchestra file to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteOrchestraWithHttpInfo(String fileid) throws ApiException {
        com.squareup.okhttp.Call call = deleteOrchestraCall(fileid, null, null);
        return apiClient.execute(call);
    }

    /**
     * deletes a single Orchestra file based on the ID supplied (asynchronously)
     * 
     * @param fileid ID of Orchestra file to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteOrchestraAsync(String fileid, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteOrchestraCall(fileid, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
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
        String localVarPath = "/orchestra/{fileid}/components/{id}".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
        String localVarPath = "/orchestra/{fileid}/fields/{id}".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
        String localVarPath = "/orchesra/{fileid}/messages/{id}".replaceAll("\\{format\\}","json")
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
     * Returns a single message, if found
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of message to fetch (required)
     * @return Message
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Message findMessageById(String fileid, Integer id) throws ApiException {
        ApiResponse<Message> resp = findMessageByIdWithHttpInfo(fileid, id);
        return resp.getData();
    }

    /**
     * Returns a single message, if found
     * 
     * @param fileid ID of Orchestra file (required)
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
     * Returns a single message, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra file (required)
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
    /* Build call for searchComponents */
    private com.squareup.okhttp.Call searchComponentsCall(String fileid, String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling searchComponents(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/orchestra/{fileid}/components".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
    /* Build call for searchFields */
    private com.squareup.okhttp.Call searchFieldsCall(String fileid, String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling searchFields(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/orchestra/{fileid}/fields".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
        String localVarPath = "/orchestra/{fileid}/messages".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
        String localVarPath = "/orchestra/{fileid}/components/{id}".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
        String localVarPath = "/orchestra/{fileid}/fields/{id}".replaceAll("\\{format\\}","json")
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
     * @param fileid ID of Orchestra file (required)
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
        String localVarPath = "/orchesra/{fileid}/messages/{id}".replaceAll("\\{format\\}","json")
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
     * Updates a single message, if found (idempotent)
     * 
     * @param fileid ID of Orchestra file (required)
     * @param id ID of message to update (required)
     * @param message message to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateMessageById(String fileid, Integer id, Message message) throws ApiException {
        updateMessageByIdWithHttpInfo(fileid, id, message);
    }

    /**
     * Updates a single message, if found (idempotent)
     * 
     * @param fileid ID of Orchestra file (required)
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
     * Updates a single message, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra file (required)
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
    /* Build call for updateOrchestraById */
    private com.squareup.okhttp.Call updateOrchestraByIdCall(String fileid, Orchestra orchestra, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = orchestra;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling updateOrchestraById(Async)");
        }
        
        // verify the required parameter 'orchestra' is set
        if (orchestra == null) {
            throw new ApiException("Missing the required parameter 'orchestra' when calling updateOrchestraById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/orchestra/{fileid}".replaceAll("\\{format\\}","json")
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
     * Updates a Orchestra file, if found (idempotent)
     * 
     * @param fileid ID of Orchestra file to update (required)
     * @param orchestra Orchestra file to update (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void updateOrchestraById(String fileid, Orchestra orchestra) throws ApiException {
        updateOrchestraByIdWithHttpInfo(fileid, orchestra);
    }

    /**
     * Updates a Orchestra file, if found (idempotent)
     * 
     * @param fileid ID of Orchestra file to update (required)
     * @param orchestra Orchestra file to update (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> updateOrchestraByIdWithHttpInfo(String fileid, Orchestra orchestra) throws ApiException {
        com.squareup.okhttp.Call call = updateOrchestraByIdCall(fileid, orchestra, null, null);
        return apiClient.execute(call);
    }

    /**
     * Updates a Orchestra file, if found (idempotent) (asynchronously)
     * 
     * @param fileid ID of Orchestra file to update (required)
     * @param orchestra Orchestra file to update (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateOrchestraByIdAsync(String fileid, Orchestra orchestra, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateOrchestraByIdCall(fileid, orchestra, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
