# DefaultApi

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteField**](DefaultApi.md#deleteField) | **DELETE** /fields/{id} | 
[**deleteMessage**](DefaultApi.md#deleteMessage) | **DELETE** /messages/{id} | 
[**findFieldById**](DefaultApi.md#findFieldById) | **GET** /fields/{id} | 
[**findMessageById**](DefaultApi.md#findMessageById) | **GET** /messages/{id} | 


<a name="deleteField"></a>
# **deleteField**
> deleteField(id)



deletes a single field based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Long id = 789L; // Long | ID of field to delete
try {
    apiInstance.deleteField(id);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| ID of field to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteMessage"></a>
# **deleteMessage**
> deleteMessage(id)



deletes a single message based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Long id = 789L; // Long | ID of message to delete
try {
    apiInstance.deleteMessage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| ID of message to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="findFieldById"></a>
# **findFieldById**
> Field findFieldById(id)



Returns a single field, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Integer id = 56; // Integer | ID of field to fetch
try {
    Field result = apiInstance.findFieldById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findFieldById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of field to fetch |

### Return type

[**Field**](Field.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findMessageById"></a>
# **findMessageById**
> Message findMessageById(id)



Returns a single message, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Integer id = 56; // Integer | ID of message to fetch
try {
    Message result = apiInstance.findMessageById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#findMessageById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| ID of message to fetch |

### Return type

[**Message**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

