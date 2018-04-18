# OrchestraApi.DocumentationApi

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAnnotation**](DocumentationApi.md#addAnnotation) | **POST** /repositories/{repos-name}/{version}/annotations | adds an Annotation
[**deleteAnnotation**](DocumentationApi.md#deleteAnnotation) | **DELETE** /repositories/{repos-name}/{version}/annotations | deletes a single Annotation
[**searchAnnotations**](DocumentationApi.md#searchAnnotations) | **GET** /repositories/{repos-name}/{version}/annotations | searches annotations
[**updateAnnotation**](DocumentationApi.md#updateAnnotation) | **PUT** /repositories/{repos-name}/{version}/annotations | Updates a single Annotation, if found (idempotent)


<a name="addAnnotation"></a>
# **addAnnotation**
> addAnnotation(reposName, version, elementId, elementType, opts)

adds an Annotation

Adds an Annotation

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.DocumentationApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let elementId = "elementId_example"; // String | name or ID as a string of the element to annotate

let elementType = "elementType_example"; // String | type of element to annotate

let opts = { 
  'parentId': "parentId_example", // String | name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
  'annotation': new OrchestraApi.Annotation() // Annotation | Annotation to add
};

apiInstance.addAnnotation(reposName, version, elementId, elementType, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository | 
 **version** | **String**| version of Orchestra repository | 
 **elementId** | **String**| name or ID as a string of the element to annotate | 
 **elementType** | **String**| type of element to annotate | 
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
> deleteAnnotation(reposName, version, elementId, elementType, opts)

deletes a single Annotation

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.DocumentationApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let elementId = "elementId_example"; // String | name or ID as a string of the element to annotate

let elementType = "elementType_example"; // String | type of element to annotate

let opts = { 
  'parentId': "parentId_example" // String | name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
};

apiInstance.deleteAnnotation(reposName, version, elementId, elementType, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository | 
 **version** | **String**| version of Orchestra repository | 
 **elementId** | **String**| name or ID as a string of the element to annotate | 
 **elementType** | **String**| type of element to annotate | 
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
> Annotation searchAnnotations(reposName, version, elementId, elementType, opts)

searches annotations

By passing in the appropriate options, you can search for annotations

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.DocumentationApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let elementId = "elementId_example"; // String | name or ID as a string of the element to annotate

let elementType = "elementType_example"; // String | type of element to annotate

let opts = { 
  'parentId': "parentId_example", // String | name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
  'searchString': "searchString_example", // String | pass an optional search string for looking up annotations
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchAnnotations(reposName, version, elementId, elementType, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository | 
 **version** | **String**| version of Orchestra repository | 
 **elementId** | **String**| name or ID as a string of the element to annotate | 
 **elementType** | **String**| type of element to annotate | 
 **parentId** | **String**| name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. | [optional] 
 **searchString** | **String**| pass an optional search string for looking up annotations | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**Annotation**](Annotation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateAnnotation"></a>
# **updateAnnotation**
> updateAnnotation(reposName, version, elementId, elementType, annotation, opts)

Updates a single Annotation, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.DocumentationApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let elementId = "elementId_example"; // String | name or ID as a string of the element to annotate

let elementType = "elementType_example"; // String | type of element to annotate

let annotation = new OrchestraApi.Annotation(); // Annotation | Annotation to update

let opts = { 
  'parentId': "parentId_example" // String | name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
};

apiInstance.updateAnnotation(reposName, version, elementId, elementType, annotation, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository | 
 **version** | **String**| version of Orchestra repository | 
 **elementId** | **String**| name or ID as a string of the element to annotate | 
 **elementType** | **String**| type of element to annotate | 
 **annotation** | [**Annotation**](Annotation.md)| Annotation to update | 
 **parentId** | **String**| name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine. | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

