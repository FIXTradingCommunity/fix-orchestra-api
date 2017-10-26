# MessagesApi

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addComponent**](MessagesApi.md#addComponent) | **POST** /orchestra/{fileid}/components | adds a component
[**addField**](MessagesApi.md#addField) | **POST** /orchestra/{fileid}/fields | adds a field
[**addMessage**](MessagesApi.md#addMessage) | **POST** /orchestra/{fileid}/messages | adds a message scenario
[**deleteComponent**](MessagesApi.md#deleteComponent) | **DELETE** /orchestra/{fileid}/components/{id} | deletes a single component based on the ID supplied
[**deleteField**](MessagesApi.md#deleteField) | **DELETE** /orchestra/{fileid}/fields/{id} | deletes a single field based on the ID supplied
[**deleteMessage**](MessagesApi.md#deleteMessage) | **DELETE** /orchesra/{fileid}/messages/{id} | deletes a single message based on the ID supplied
[**deleteOrchestra**](MessagesApi.md#deleteOrchestra) | **DELETE** /orchestra/{fileid} | deletes a single Orchestra file based on the ID supplied
[**findComponentById**](MessagesApi.md#findComponentById) | **GET** /orchestra/{fileid}/components/{id} | Returns a single component, if found
[**findFieldById**](MessagesApi.md#findFieldById) | **GET** /orchestra/{fileid}/fields/{id} | Returns a single field, if found
[**findMessageById**](MessagesApi.md#findMessageById) | **GET** /orchesra/{fileid}/messages/{id} | Returns a single message, if found
[**searchComponents**](MessagesApi.md#searchComponents) | **GET** /orchestra/{fileid}/components | searches components
[**searchFields**](MessagesApi.md#searchFields) | **GET** /orchestra/{fileid}/fields | searches fields
[**searchMessages**](MessagesApi.md#searchMessages) | **GET** /orchestra/{fileid}/messages | searches messages
[**updateComponentById**](MessagesApi.md#updateComponentById) | **PUT** /orchestra/{fileid}/components/{id} | Updates a single component, if found (idempotent)
[**updateFieldById**](MessagesApi.md#updateFieldById) | **PUT** /orchestra/{fileid}/fields/{id} | Updates a single field, if found (idempotent)
[**updateMessageById**](MessagesApi.md#updateMessageById) | **PUT** /orchesra/{fileid}/messages/{id} | Updates a single message, if found (idempotent)
[**updateOrchestraById**](MessagesApi.md#updateOrchestraById) | **PUT** /orchestra/{fileid} | Updates a Orchestra file, if found (idempotent)


<a name="addComponent"></a>
# **addComponent**
> addComponent(fileid, component)

adds a component

Adds a component

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Component component = new Component(); // Component | Component to add
try {
    apiInstance.addComponent(fileid, component);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#addComponent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **component** | [**Component**](Component.md)| Component to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addField"></a>
# **addField**
> addField(fileid, field)

adds a field

Adds a field

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Field field = new Field(); // Field | field to add
try {
    apiInstance.addField(fileid, field);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#addField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **field** | [**Field**](Field.md)| field to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addMessage"></a>
# **addMessage**
> addMessage(fileid, message)

adds a message scenario

Adds a message scenario

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Message message = new Message(); // Message | message to add
try {
    apiInstance.addMessage(fileid, message);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#addMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **message** | [**Message**](Message.md)| message to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteComponent"></a>
# **deleteComponent**
> deleteComponent(fileid, id)

deletes a single component based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Long id = 789L; // Long | ID of field to delete
try {
    apiInstance.deleteComponent(fileid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#deleteComponent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **id** | **Long**| ID of field to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteField"></a>
# **deleteField**
> deleteField(fileid, id)

deletes a single field based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Long id = 789L; // Long | ID of field to delete
try {
    apiInstance.deleteField(fileid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#deleteField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
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
> deleteMessage(fileid, id)

deletes a single message based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Long id = 789L; // Long | ID of message to delete
try {
    apiInstance.deleteMessage(fileid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#deleteMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **id** | **Long**| ID of message to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteOrchestra"></a>
# **deleteOrchestra**
> deleteOrchestra(fileid)

deletes a single Orchestra file based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file to delete
try {
    apiInstance.deleteOrchestra(fileid);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#deleteOrchestra");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="findComponentById"></a>
# **findComponentById**
> Component findComponentById(fileid, id)

Returns a single component, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Integer id = 56; // Integer | ID of component to fetch
try {
    Component result = apiInstance.findComponentById(fileid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#findComponentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **id** | **Integer**| ID of component to fetch |

### Return type

[**Component**](Component.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findFieldById"></a>
# **findFieldById**
> Field findFieldById(fileid, id)

Returns a single field, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Integer id = 56; // Integer | ID of field to fetch
try {
    Field result = apiInstance.findFieldById(fileid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#findFieldById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
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
> Message findMessageById(fileid, id)

Returns a single message, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Integer id = 56; // Integer | ID of message to fetch
try {
    Message result = apiInstance.findMessageById(fileid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#findMessageById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **id** | **Integer**| ID of message to fetch |

### Return type

[**Message**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchComponents"></a>
# **searchComponents**
> List&lt;Component&gt; searchComponents(fileid, searchString, skip, limit)

searches components

By passing in the appropriate options, you can search for components 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
String searchString = "searchString_example"; // String | pass an optional search string for looking up components
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Component> result = apiInstance.searchComponents(fileid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#searchComponents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **searchString** | **String**| pass an optional search string for looking up components | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Component&gt;**](Component.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchFields"></a>
# **searchFields**
> List&lt;Field&gt; searchFields(fileid, searchString, skip, limit)

searches fields

By passing in the appropriate options, you can search for fields 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
String searchString = "searchString_example"; // String | pass an optional search string for looking up fields
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Field> result = apiInstance.searchFields(fileid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#searchFields");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **searchString** | **String**| pass an optional search string for looking up fields | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Field&gt;**](Field.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchMessages"></a>
# **searchMessages**
> List&lt;Message&gt; searchMessages(fileid, searchString, skip, limit)

searches messages

By passing in the appropriate options, you can search for messages 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
String searchString = "searchString_example"; // String | pass an optional search string for looking up messages
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Message> result = apiInstance.searchMessages(fileid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#searchMessages");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **searchString** | **String**| pass an optional search string for looking up messages | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Message&gt;**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateComponentById"></a>
# **updateComponentById**
> updateComponentById(fileid, id, component)

Updates a single component, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Integer id = 56; // Integer | ID of component to update
Component component = new Component(); // Component | component to update
try {
    apiInstance.updateComponentById(fileid, id, component);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#updateComponentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **id** | **Integer**| ID of component to update |
 **component** | [**Component**](Component.md)| component to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateFieldById"></a>
# **updateFieldById**
> updateFieldById(fileid, id, field)

Updates a single field, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Integer id = 56; // Integer | ID of field to update
Field field = new Field(); // Field | field to update
try {
    apiInstance.updateFieldById(fileid, id, field);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#updateFieldById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **id** | **Integer**| ID of field to update |
 **field** | [**Field**](Field.md)| field to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateMessageById"></a>
# **updateMessageById**
> updateMessageById(fileid, id, message)

Updates a single message, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file
Integer id = 56; // Integer | ID of message to update
Message message = new Message(); // Message | message to update
try {
    apiInstance.updateMessageById(fileid, id, message);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#updateMessageById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file |
 **id** | **Integer**| ID of message to update |
 **message** | [**Message**](Message.md)| message to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateOrchestraById"></a>
# **updateOrchestraById**
> updateOrchestraById(fileid, orchestra)

Updates a Orchestra file, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MessagesApi;


MessagesApi apiInstance = new MessagesApi();
String fileid = "fileid_example"; // String | ID of Orchestra file to update
Orchestra orchestra = new Orchestra(); // Orchestra | Orchestra file to update
try {
    apiInstance.updateOrchestraById(fileid, orchestra);
} catch (ApiException e) {
    System.err.println("Exception when calling MessagesApi#updateOrchestraById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra file to update |
 **orchestra** | [**Orchestra**](Orchestra.md)| Orchestra file to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

