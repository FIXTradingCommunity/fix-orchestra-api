

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

import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Orchestra;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileApi {
    private ApiClient apiClient;

    public FileApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FileApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for addOrchestra */
    private com.squareup.okhttp.Call addOrchestraCall(Orchestra orchestra, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = orchestra;
        
        // verify the required parameter 'orchestra' is set
        if (orchestra == null) {
            throw new ApiException("Missing the required parameter 'orchestra' when calling addOrchestra(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/orchestra".replaceAll("\\{format\\}","json");

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
     * adds an Orchestra file
     * Adds an Orchestra file
     * @param orchestra Orchestra file to add (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void addOrchestra(Orchestra orchestra) throws ApiException {
        addOrchestraWithHttpInfo(orchestra);
    }

    /**
     * adds an Orchestra file
     * Adds an Orchestra file
     * @param orchestra Orchestra file to add (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> addOrchestraWithHttpInfo(Orchestra orchestra) throws ApiException {
        com.squareup.okhttp.Call call = addOrchestraCall(orchestra, null, null);
        return apiClient.execute(call);
    }

    /**
     * adds an Orchestra file (asynchronously)
     * Adds an Orchestra file
     * @param orchestra Orchestra file to add (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addOrchestraAsync(Orchestra orchestra, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addOrchestraCall(orchestra, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for findOrchestraById */
    private com.squareup.okhttp.Call findOrchestraByIdCall(String fileid, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'fileid' is set
        if (fileid == null) {
            throw new ApiException("Missing the required parameter 'fileid' when calling findOrchestraById(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/orchestra/{fileid}".replaceAll("\\{format\\}","json")
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
     * Returns a single Orchestra file metadata, if found
     * 
     * @param fileid ID of Orchestra file to fetch (required)
     * @return Orchestra
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Orchestra findOrchestraById(String fileid) throws ApiException {
        ApiResponse<Orchestra> resp = findOrchestraByIdWithHttpInfo(fileid);
        return resp.getData();
    }

    /**
     * Returns a single Orchestra file metadata, if found
     * 
     * @param fileid ID of Orchestra file to fetch (required)
     * @return ApiResponse&lt;Orchestra&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Orchestra> findOrchestraByIdWithHttpInfo(String fileid) throws ApiException {
        com.squareup.okhttp.Call call = findOrchestraByIdCall(fileid, null, null);
        Type localVarReturnType = new TypeToken<Orchestra>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a single Orchestra file metadata, if found (asynchronously)
     * 
     * @param fileid ID of Orchestra file to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findOrchestraByIdAsync(String fileid, final ApiCallback<Orchestra> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = findOrchestraByIdCall(fileid, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Orchestra>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for searchOrchestra */
    private com.squareup.okhttp.Call searchOrchestraCall(String searchString, Integer skip, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/orchestra".replaceAll("\\{format\\}","json");

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
     * searches Orchestra files
     * By passing in the appropriate options, you can search for Orchestra files 
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return List&lt;Orchestra&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Orchestra> searchOrchestra(String searchString, Integer skip, Integer limit) throws ApiException {
        ApiResponse<List<Orchestra>> resp = searchOrchestraWithHttpInfo(searchString, skip, limit);
        return resp.getData();
    }

    /**
     * searches Orchestra files
     * By passing in the appropriate options, you can search for Orchestra files 
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return ApiResponse&lt;List&lt;Orchestra&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Orchestra>> searchOrchestraWithHttpInfo(String searchString, Integer skip, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = searchOrchestraCall(searchString, skip, limit, null, null);
        Type localVarReturnType = new TypeToken<List<Orchestra>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * searches Orchestra files (asynchronously)
     * By passing in the appropriate options, you can search for Orchestra files 
     * @param searchString pass an optional search string for looking up components (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchOrchestraAsync(String searchString, Integer skip, Integer limit, final ApiCallback<List<Orchestra>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = searchOrchestraCall(searchString, skip, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Orchestra>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
