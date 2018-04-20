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
> addAnnotation(reposName, version, elementId, elementType, parentId, annotation)

adds an Annotation

Adds an Annotation

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.DocumentationApi;


DocumentationApi apiInstance = new DocumentationApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String elementId = "elementId_example"; // String | name or ID as a string of the element to annotate
String elementType = "elementType_example"; // String | type of element to annotate
String parentId = "parentId_example"; // String | name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
Annotation annotation = new Annotation(); // Annotation | Annotation to add
try {
    apiInstance.addAnnotation(reposName, version, elementId, elementType, parentId, annotation);
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
 **elementId** | **String**| name or ID as a string of the element to annotate |
 **elementType** | **String**| type of element to annotate | [enum: code, codeSet, component, datatype, field, group, message, actor, flow, response, stateMachine]
 **parentId** | **String**| name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. | [optional]
 **annotation** | [**Annotation**](Annotation.md)| Annotation to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteAnnotation"></a>
# **deleteAnnotation**
> deleteAnnotation(reposName, version, elementId, elementType, parentId)

deletes a single Annotation

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.DocumentationApi;


DocumentationApi apiInstance = new DocumentationApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String elementId = "elementId_example"; // String | name or ID as a string of the element to annotate
String elementType = "elementType_example"; // String | type of element to annotate
String parentId = "parentId_example"; // String | name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
try {
    apiInstance.deleteAnnotation(reposName, version, elementId, elementType, parentId);
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
 **elementId** | **String**| name or ID as a string of the element to annotate |
 **elementType** | **String**| type of element to annotate | [enum: code, codeSet, component, datatype, field, group, message, actor, flow, response, stateMachine]
 **parentId** | **String**| name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchAnnotations"></a>
# **searchAnnotations**
> Annotation searchAnnotations(reposName, version, elementId, elementType, parentId, searchString, skip, limit)

searches annotations

By passing in the appropriate options, you can search for annotations

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.DocumentationApi;


DocumentationApi apiInstance = new DocumentationApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String elementId = "elementId_example"; // String | name or ID as a string of the element to annotate
String elementType = "elementType_example"; // String | type of element to annotate
String parentId = "parentId_example"; // String | name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
String searchString = "searchString_example"; // String | pass an optional search string for looking up annotations
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    Annotation result = apiInstance.searchAnnotations(reposName, version, elementId, elementType, parentId, searchString, skip, limit);
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
 **elementId** | **String**| name or ID as a string of the element to annotate |
 **elementType** | **String**| type of element to annotate | [enum: code, codeSet, component, datatype, field, group, message, actor, flow, response, stateMachine]
 **parentId** | **String**| name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. | [optional]
 **searchString** | **String**| pass an optional search string for looking up annotations | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**Annotation**](Annotation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAnnotation"></a>
# **updateAnnotation**
> updateAnnotation(reposName, version, elementId, elementType, annotation, parentId)

Updates a single Annotation, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.DocumentationApi;


DocumentationApi apiInstance = new DocumentationApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String elementId = "elementId_example"; // String | name or ID as a string of the element to annotate
String elementType = "elementType_example"; // String | type of element to annotate
Annotation annotation = new Annotation(); // Annotation | Annotation to update
String parentId = "parentId_example"; // String | name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
try {
    apiInstance.updateAnnotation(reposName, version, elementId, elementType, annotation, parentId);
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
 **elementId** | **String**| name or ID as a string of the element to annotate |
 **elementType** | **String**| type of element to annotate | [enum: code, codeSet, component, datatype, field, group, message, actor, flow, response, stateMachine]
 **annotation** | [**Annotation**](Annotation.md)| Annotation to update |
 **parentId** | **String**| name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

