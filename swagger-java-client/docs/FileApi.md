# FileApi

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addOrchestra**](FileApi.md#addOrchestra) | **POST** /orchestra | adds an Orchestra file
[**findOrchestraById**](FileApi.md#findOrchestraById) | **GET** /orchestra/{fileid} | Returns a single Orchestra file metadata, if found
[**searchOrchestra**](FileApi.md#searchOrchestra) | **GET** /orchestra | searches Orchestra files


<a name="addOrchestra"></a>
# **addOrchestra**
> addOrchestra(orchestra)

adds an Orchestra file

Adds an Orchestra file

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
Orchestra orchestra = new Orchestra(); // Orchestra | Orchestra file to add
try {
    apiInstance.addOrchestra(orchestra);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#addOrchestra");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orchestra** | [**Orchestra**](Orchestra.md)| Orchestra file to add |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findOrchestraById"></a>
# **findOrchestraById**
> Orchestra findOrchestraById(fileid)

Returns a single Orchestra file metadata, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
String fileid = "fileid_example"; // String | ID of Orchestra file to fetch
try {
    Orchestra result = apiInstance.findOrchestraById(fileid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#findOrchestraById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file to fetch |

### Return type

[**Orchestra**](Orchestra.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchOrchestra"></a>
# **searchOrchestra**
> List&lt;Orchestra&gt; searchOrchestra(searchString, skip, limit)

searches Orchestra files

By passing in the appropriate options, you can search for Orchestra files 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FileApi;


FileApi apiInstance = new FileApi();
String searchString = "searchString_example"; // String | pass an optional search string for looking up components
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Orchestra> result = apiInstance.searchOrchestra(searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileApi#searchOrchestra");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **searchString** | **String**| pass an optional search string for looking up components | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Orchestra&gt;**](Orchestra.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

