# DocumentationApi

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAnnotation**](DocumentationApi.md#addAnnotation) | **POST** /repositories/{repos-name}/{version}/annotations | adds an Annotation
[**deleteAnnotation**](DocumentationApi.md#deleteAnnotation) | **DELETE** /repositories/{repos-name}/{version}/annotations | deletes a single Annotation
[**searchAnnotations**](DocumentationApi.md#searchAnnotations) | **GET** /repositories/{repos-name}/{version}/annotations | searches annotations
[**updateAnnotation**](DocumentationApi.md#updateAnnotation) | **PUT** /repositories/{repos-name}/{version}/annotations | Updates a single Annotation, if found (idempotent)


<a name="addAnnotation"></a>
# **addAnnotation**
> addAnnotation(reposName, version, elementId, elementType, annotation)

adds an Annotation

Adds an Annotation

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.DocumentationApi;


DocumentationApi apiInstance = new DocumentationApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String elementId = "elementId_example"; // String | 
String elementType = "elementType_example"; // String | 
Annotation annotation = new Annotation(); // Annotation | Annotation to add
try {
    apiInstance.addAnnotation(reposName, version, elementId, elementType, annotation);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentationApi#addAnnotation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **elementId** | **String**|  |
 **elementType** | **String**|  | [optional] [enum: codeSet, component, datatype, field, group, message, actor, flow, response]
 **annotation** | [**Annotation**](Annotation.md)| Annotation to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteAnnotation"></a>
# **deleteAnnotation**
> deleteAnnotation(reposName, version, elementId, elementType)

deletes a single Annotation

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.DocumentationApi;


DocumentationApi apiInstance = new DocumentationApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String elementId = "elementId_example"; // String | 
String elementType = "elementType_example"; // String | 
try {
    apiInstance.deleteAnnotation(reposName, version, elementId, elementType);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentationApi#deleteAnnotation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **elementId** | **String**|  |
 **elementType** | **String**|  | [optional] [enum: codeSet, component, datatype, field, group, message, actor, flow, response]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="searchAnnotations"></a>
# **searchAnnotations**
> Annotation searchAnnotations(reposName, version, elementId, elementType, searchString, skip, limit)

searches annotations

By passing in the appropriate options, you can search for annotations

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.DocumentationApi;


DocumentationApi apiInstance = new DocumentationApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String elementId = "elementId_example"; // String | 
String elementType = "elementType_example"; // String | 
String searchString = "searchString_example"; // String | pass an optional search string for looking up annotations
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    Annotation result = apiInstance.searchAnnotations(reposName, version, elementId, elementType, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentationApi#searchAnnotations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **elementId** | **String**|  |
 **elementType** | **String**|  | [optional] [enum: codeSet, component, datatype, field, group, message, actor, flow, response]
 **searchString** | **String**| pass an optional search string for looking up annotations | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**Annotation**](Annotation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateAnnotation"></a>
# **updateAnnotation**
> updateAnnotation(reposName, version, elementId, annotation, elementType)

Updates a single Annotation, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.DocumentationApi;


DocumentationApi apiInstance = new DocumentationApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String elementId = "elementId_example"; // String | 
Annotation annotation = new Annotation(); // Annotation | Annotation to update
String elementType = "elementType_example"; // String | 
try {
    apiInstance.updateAnnotation(reposName, version, elementId, annotation, elementType);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentationApi#updateAnnotation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **elementId** | **String**|  |
 **annotation** | [**Annotation**](Annotation.md)| Annotation to update |
 **elementType** | **String**|  | [optional] [enum: codeSet, component, datatype, field, group, message, actor, flow, response]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

