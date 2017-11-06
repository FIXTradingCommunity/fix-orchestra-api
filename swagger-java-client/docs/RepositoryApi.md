# RepositoryApi

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCode**](RepositoryApi.md#addCode) | **POST** /repositories/{fileid}/codesets/{codesetid}/codes | adds a Code to CodeSet
[**addCodeSet**](RepositoryApi.md#addCodeSet) | **POST** /repositories/{fileid}/codesets | adds a CodeSet
[**addComponent**](RepositoryApi.md#addComponent) | **POST** /repositories/{fileid}/components | adds a component
[**addDatatype**](RepositoryApi.md#addDatatype) | **POST** /repositories/{fileid}/datatypes | adds a datatype
[**addField**](RepositoryApi.md#addField) | **POST** /repositories/{fileid}/fields | adds a field
[**addMessage**](RepositoryApi.md#addMessage) | **POST** /repositories/{fileid}/messages | adds a message scenario
[**addRepository**](RepositoryApi.md#addRepository) | **POST** /repositories | adds an Orchestra repository file
[**deleteCode**](RepositoryApi.md#deleteCode) | **DELETE** /repositories/{fileid}/codesets/{codesetid}/codes/{id} | deletes a single Code based on the ID supplied
[**deleteCodeSet**](RepositoryApi.md#deleteCodeSet) | **DELETE** /repositories/{fileid}/codesets/{id} | deletes a single CodeSet based on the ID supplied
[**deleteComponent**](RepositoryApi.md#deleteComponent) | **DELETE** /repositories/{fileid}/components/{id} | deletes a single component based on the ID supplied
[**deleteDatatype**](RepositoryApi.md#deleteDatatype) | **DELETE** /repositories/{fileid}/datatypes/{name} | deletes a single datatype based on the name supplied
[**deleteField**](RepositoryApi.md#deleteField) | **DELETE** /repositories/{fileid}/fields/{id} | deletes a single field based on the ID supplied
[**deleteMessage**](RepositoryApi.md#deleteMessage) | **DELETE** /repositories/{fileid}/messages/{id} | deletes a single message scenario based on the ID supplied
[**deleteRepository**](RepositoryApi.md#deleteRepository) | **DELETE** /repositories/{fileid} | deletes a single Orchestra repository file based on the ID supplied
[**findCodeById**](RepositoryApi.md#findCodeById) | **GET** /repositories/{fileid}/codesets/{codesetid}/codes/{id} | Returns a single Code, if found
[**findCodeSetById**](RepositoryApi.md#findCodeSetById) | **GET** /repositories/{fileid}/codesets/{id} | Returns a single CodeSet, if found
[**findComponentById**](RepositoryApi.md#findComponentById) | **GET** /repositories/{fileid}/components/{id} | Returns a single component, if found
[**findDatatypeByName**](RepositoryApi.md#findDatatypeByName) | **GET** /repositories/{fileid}/datatypes/{name} | Returns a single datatype, if found
[**findFieldById**](RepositoryApi.md#findFieldById) | **GET** /repositories/{fileid}/fields/{id} | Returns a single field, if found
[**findMessageById**](RepositoryApi.md#findMessageById) | **GET** /repositories/{fileid}/messages/{id} | Returns a single message scenario, if found
[**findRepositoryById**](RepositoryApi.md#findRepositoryById) | **GET** /repositories/{fileid} | Returns a single Orchestra repository file metadata, if found
[**searchCodeSets**](RepositoryApi.md#searchCodeSets) | **GET** /repositories/{fileid}/codesets | searches CodeSets
[**searchCodes**](RepositoryApi.md#searchCodes) | **GET** /repositories/{fileid}/codesets/{codesetid}/codes | searches Codes within a CodeSet
[**searchComponents**](RepositoryApi.md#searchComponents) | **GET** /repositories/{fileid}/components | searches components
[**searchDatatypes**](RepositoryApi.md#searchDatatypes) | **GET** /repositories/{fileid}/datatypes | searches datatypes
[**searchFields**](RepositoryApi.md#searchFields) | **GET** /repositories/{fileid}/fields | searches fields
[**searchMessages**](RepositoryApi.md#searchMessages) | **GET** /repositories/{fileid}/messages | searches messages
[**searchRepositories**](RepositoryApi.md#searchRepositories) | **GET** /repositories | searches Orchestra repository files
[**updateCodeById**](RepositoryApi.md#updateCodeById) | **PUT** /repositories/{fileid}/codesets/{codesetid}/codes/{id} | Updates a single Code, if found (idempotent)
[**updateCodeSetById**](RepositoryApi.md#updateCodeSetById) | **PUT** /repositories/{fileid}/codesets/{id} | Updates a single CodeSet, if found (idempotent)
[**updateComponentById**](RepositoryApi.md#updateComponentById) | **PUT** /repositories/{fileid}/components/{id} | Updates a single component, if found (idempotent)
[**updateDatatypeByName**](RepositoryApi.md#updateDatatypeByName) | **PUT** /repositories/{fileid}/datatypes/{name} | Updates a single datatype, if found (idempotent)
[**updateFieldById**](RepositoryApi.md#updateFieldById) | **PUT** /repositories/{fileid}/fields/{id} | Updates a single field, if found (idempotent)
[**updateMessageById**](RepositoryApi.md#updateMessageById) | **PUT** /repositories/{fileid}/messages/{id} | Updates a single message scenario, if found (idempotent)
[**updateRepositoryById**](RepositoryApi.md#updateRepositoryById) | **PUT** /repositories/{fileid} | Updates an Orchestra repository file, if found (idempotent)


<a name="addCode"></a>
# **addCode**
> addCode(fileid, codesetid, code)

adds a Code to CodeSet

Adds a Code

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer codesetid = 56; // Integer | ID of CodeSet
Code code = new Code(); // Code | Code to add
try {
    apiInstance.addCode(fileid, codesetid, code);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **codesetid** | **Integer**| ID of CodeSet |
 **code** | [**Code**](Code.md)| Code to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addCodeSet"></a>
# **addCodeSet**
> addCodeSet(fileid, codeSet)

adds a CodeSet

Adds a CodeSet

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
CodeSet codeSet = new CodeSet(); // CodeSet | CodeSet to add
try {
    apiInstance.addCodeSet(fileid, codeSet);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addCodeSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **codeSet** | [**CodeSet**](CodeSet.md)| CodeSet to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addComponent"></a>
# **addComponent**
> addComponent(fileid, component, toClone)

adds a component

Adds a component

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Component component = new Component(); // Component | Component to add
Integer toClone = 56; // Integer | ID of component to clone
try {
    apiInstance.addComponent(fileid, component, toClone);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addComponent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **component** | [**Component**](Component.md)| Component to add | [optional]
 **toClone** | **Integer**| ID of component to clone | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addDatatype"></a>
# **addDatatype**
> addDatatype(fileid, datatype)

adds a datatype

Adds a datatype

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Datatype datatype = new Datatype(); // Datatype | Datatype to add
try {
    apiInstance.addDatatype(fileid, datatype);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addDatatype");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **datatype** | [**Datatype**](Datatype.md)| Datatype to add | [optional]

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
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Field field = new Field(); // Field | field to add
try {
    apiInstance.addField(fileid, field);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
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
> addMessage(fileid, message, toClone)

adds a message scenario

Adds a message scenario

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Message message = new Message(); // Message | message to add
Integer toClone = 56; // Integer | ID of message to clone
try {
    apiInstance.addMessage(fileid, message, toClone);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **message** | [**Message**](Message.md)| message to add | [optional]
 **toClone** | **Integer**| ID of message to clone | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addRepository"></a>
# **addRepository**
> addRepository(repository, toClone)

adds an Orchestra repository file

Adds an Orchestra repository file

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
Metadata repository = new Metadata(); // Metadata | Orchestra repository file to add
String toClone = "toClone_example"; // String | ID of Orchestra repository file to clone
try {
    apiInstance.addRepository(repository, toClone);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addRepository");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **repository** | [**Metadata**](Metadata.md)| Orchestra repository file to add |
 **toClone** | **String**| ID of Orchestra repository file to clone | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCode"></a>
# **deleteCode**
> deleteCode(fileid, codesetid, id)

deletes a single Code based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer codesetid = 56; // Integer | ID of CodeSet
Integer id = 56; // Integer | ID of field to delete
try {
    apiInstance.deleteCode(fileid, codesetid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **codesetid** | **Integer**| ID of CodeSet |
 **id** | **Integer**| ID of field to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteCodeSet"></a>
# **deleteCodeSet**
> deleteCodeSet(fileid, id)

deletes a single CodeSet based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of field to delete
try {
    apiInstance.deleteCodeSet(fileid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteCodeSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of field to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteComponent"></a>
# **deleteComponent**
> deleteComponent(fileid, id)

deletes a single component based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of component to delete
try {
    apiInstance.deleteComponent(fileid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteComponent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of component to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteDatatype"></a>
# **deleteDatatype**
> deleteDatatype(fileid, name)

deletes a single datatype based on the name supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
String name = "name_example"; // String | name of datatype to delete
try {
    apiInstance.deleteDatatype(fileid, name);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteDatatype");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **name** | **String**| name of datatype to delete |

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
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of field to delete
try {
    apiInstance.deleteField(fileid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of field to delete |

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

deletes a single message scenario based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of message to delete
try {
    apiInstance.deleteMessage(fileid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of message to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteRepository"></a>
# **deleteRepository**
> deleteRepository(fileid)

deletes a single Orchestra repository file based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file to delete
try {
    apiInstance.deleteRepository(fileid);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteRepository");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="findCodeById"></a>
# **findCodeById**
> Code findCodeById(fileid, codesetid, id)

Returns a single Code, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer codesetid = 56; // Integer | ID of CodeSet
Integer id = 56; // Integer | ID of Code to fetch
try {
    Code result = apiInstance.findCodeById(fileid, codesetid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findCodeById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **codesetid** | **Integer**| ID of CodeSet |
 **id** | **Integer**| ID of Code to fetch |

### Return type

[**Code**](Code.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findCodeSetById"></a>
# **findCodeSetById**
> CodeSet findCodeSetById(fileid, id)

Returns a single CodeSet, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of CodeSet to fetch
try {
    CodeSet result = apiInstance.findCodeSetById(fileid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findCodeSetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of CodeSet to fetch |

### Return type

[**CodeSet**](CodeSet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findComponentById"></a>
# **findComponentById**
> Component findComponentById(fileid, id)

Returns a single component, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of component to fetch
try {
    Component result = apiInstance.findComponentById(fileid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findComponentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of component to fetch |

### Return type

[**Component**](Component.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findDatatypeByName"></a>
# **findDatatypeByName**
> Datatype findDatatypeByName(fileid, name)

Returns a single datatype, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
String name = "name_example"; // String | name of datatype to fetch
try {
    Datatype result = apiInstance.findDatatypeByName(fileid, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findDatatypeByName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **name** | **String**| name of datatype to fetch |

### Return type

[**Datatype**](Datatype.md)

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
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of field to fetch
try {
    Field result = apiInstance.findFieldById(fileid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findFieldById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
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

Returns a single message scenario, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of message to fetch
try {
    Message result = apiInstance.findMessageById(fileid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findMessageById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of message to fetch |

### Return type

[**Message**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findRepositoryById"></a>
# **findRepositoryById**
> Metadata findRepositoryById(fileid)

Returns a single Orchestra repository file metadata, if found

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file to fetch
try {
    Metadata result = apiInstance.findRepositoryById(fileid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findRepositoryById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file to fetch |

### Return type

[**Metadata**](Metadata.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchCodeSets"></a>
# **searchCodeSets**
> List&lt;CodeSet&gt; searchCodeSets(fileid, searchString, skip, limit)

searches CodeSets

By passing in the appropriate options, you can search for CodeSets 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
String searchString = "searchString_example"; // String | pass an optional search string for looking up CodeSets
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<CodeSet> result = apiInstance.searchCodeSets(fileid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchCodeSets");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **searchString** | **String**| pass an optional search string for looking up CodeSets | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;CodeSet&gt;**](CodeSet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchCodes"></a>
# **searchCodes**
> List&lt;Code&gt; searchCodes(fileid, codesetid, searchString, skip, limit)

searches Codes within a CodeSet

By passing in the appropriate options, you can search for Codes 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer codesetid = 56; // Integer | ID of CodeSet
String searchString = "searchString_example"; // String | pass an optional search string for looking up Codes
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Code> result = apiInstance.searchCodes(fileid, codesetid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchCodes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **codesetid** | **Integer**| ID of CodeSet |
 **searchString** | **String**| pass an optional search string for looking up Codes | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Code&gt;**](Code.md)

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
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
String searchString = "searchString_example"; // String | pass an optional search string for looking up components
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Component> result = apiInstance.searchComponents(fileid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchComponents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
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

<a name="searchDatatypes"></a>
# **searchDatatypes**
> List&lt;Datatype&gt; searchDatatypes(fileid, searchString, skip, limit)

searches datatypes

By passing in the appropriate options, you can search for datatypes 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
String searchString = "searchString_example"; // String | pass an optional search string for looking up datatypes
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Datatype> result = apiInstance.searchDatatypes(fileid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchDatatypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **searchString** | **String**| pass an optional search string for looking up datatypes | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Datatype&gt;**](Datatype.md)

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
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
String searchString = "searchString_example"; // String | pass an optional search string for looking up fields
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Field> result = apiInstance.searchFields(fileid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchFields");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
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
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
String searchString = "searchString_example"; // String | pass an optional search string for looking up messages
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Message> result = apiInstance.searchMessages(fileid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchMessages");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
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

<a name="searchRepositories"></a>
# **searchRepositories**
> List&lt;Metadata&gt; searchRepositories(searchString, skip, limit)

searches Orchestra repository files

By passing in the appropriate options, you can search for Orchestra repository files 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String searchString = "searchString_example"; // String | pass an optional search string for looking up components
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Metadata> result = apiInstance.searchRepositories(searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchRepositories");
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

[**List&lt;Metadata&gt;**](Metadata.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCodeById"></a>
# **updateCodeById**
> updateCodeById(fileid, codesetid, id, code)

Updates a single Code, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer codesetid = 56; // Integer | ID of CodeSet
Integer id = 56; // Integer | ID of Code to update
Code code = new Code(); // Code | Code to update
try {
    apiInstance.updateCodeById(fileid, codesetid, id, code);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateCodeById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **codesetid** | **Integer**| ID of CodeSet |
 **id** | **Integer**| ID of Code to update |
 **code** | [**Code**](Code.md)| Code to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateCodeSetById"></a>
# **updateCodeSetById**
> updateCodeSetById(fileid, id, codeSet)

Updates a single CodeSet, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of CodeSet to update
CodeSet codeSet = new CodeSet(); // CodeSet | CodeSet to update
try {
    apiInstance.updateCodeSetById(fileid, id, codeSet);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateCodeSetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of CodeSet to update |
 **codeSet** | [**CodeSet**](CodeSet.md)| CodeSet to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateComponentById"></a>
# **updateComponentById**
> updateComponentById(fileid, id, component)

Updates a single component, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of component to update
Component component = new Component(); // Component | component to update
try {
    apiInstance.updateComponentById(fileid, id, component);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateComponentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of component to update |
 **component** | [**Component**](Component.md)| component to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateDatatypeByName"></a>
# **updateDatatypeByName**
> updateDatatypeByName(fileid, name, datatype)

Updates a single datatype, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
String name = "name_example"; // String | name of datatype to update
Datatype datatype = new Datatype(); // Datatype | datatype to update
try {
    apiInstance.updateDatatypeByName(fileid, name, datatype);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateDatatypeByName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **name** | **String**| name of datatype to update |
 **datatype** | [**Datatype**](Datatype.md)| datatype to update |

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
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of field to update
Field field = new Field(); // Field | field to update
try {
    apiInstance.updateFieldById(fileid, id, field);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateFieldById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
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

Updates a single message scenario, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file
Integer id = 56; // Integer | ID of message to update
Message message = new Message(); // Message | message to update
try {
    apiInstance.updateMessageById(fileid, id, message);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateMessageById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file |
 **id** | **Integer**| ID of message to update |
 **message** | [**Message**](Message.md)| message to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateRepositoryById"></a>
# **updateRepositoryById**
> updateRepositoryById(fileid, repository)

Updates an Orchestra repository file, if found (idempotent)

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String fileid = "fileid_example"; // String | ID of Orchestra repository file to update
Metadata repository = new Metadata(); // Metadata | Orchestra repository file to update
try {
    apiInstance.updateRepositoryById(fileid, repository);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateRepositoryById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fileid** | **String**| ID of Orchestra repository file to update |
 **repository** | [**Metadata**](Metadata.md)| Orchestra repository file to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

