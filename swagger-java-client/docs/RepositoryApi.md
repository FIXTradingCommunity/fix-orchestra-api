# RepositoryApi

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCode**](RepositoryApi.md#addCode) | **POST** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes | adds a Code to CodeSet
[**addCodeSet**](RepositoryApi.md#addCodeSet) | **POST** /repositories/{repos-name}/{version}/codesets | adds a CodeSet
[**addComponent**](RepositoryApi.md#addComponent) | **POST** /repositories/{repos-name}/{version}/components | adds a component
[**addDatatype**](RepositoryApi.md#addDatatype) | **POST** /repositories/{repos-name}/{version}/datatypes | adds a datatype
[**addField**](RepositoryApi.md#addField) | **POST** /repositories/{repos-name}/{version}/fields | adds a field
[**addGroup**](RepositoryApi.md#addGroup) | **POST** /repositories/{repos-name}/{version}/groups | adds a repeating group
[**addMessage**](RepositoryApi.md#addMessage) | **POST** /repositories/{repos-name}/{version}/messages | adds a message scenario
[**addRepository**](RepositoryApi.md#addRepository) | **POST** /repositories | adds an Orchestra repository
[**deleteCode**](RepositoryApi.md#deleteCode) | **DELETE** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | deletes a single Code based on the ID supplied
[**deleteCodeSet**](RepositoryApi.md#deleteCodeSet) | **DELETE** /repositories/{repos-name}/{version}/codesets/{id} | deletes a single CodeSet based on the ID supplied
[**deleteComponent**](RepositoryApi.md#deleteComponent) | **DELETE** /repositories/{repos-name}/{version}/components/{id} | deletes a single component based on the ID supplied
[**deleteDatatype**](RepositoryApi.md#deleteDatatype) | **DELETE** /repositories/{repos-name}/{version}/datatypes/{name} | deletes a single datatype based on the name supplied
[**deleteField**](RepositoryApi.md#deleteField) | **DELETE** /repositories/{repos-name}/{version}/fields/{id} | deletes a single field based on the ID supplied
[**deleteGroup**](RepositoryApi.md#deleteGroup) | **DELETE** /repositories/{repos-name}/{version}/groups/{id} | deletes a single group based on the ID supplied
[**deleteMessage**](RepositoryApi.md#deleteMessage) | **DELETE** /repositories/{repos-name}/{version}/messages/{id} | deletes a single message scenario based on the ID supplied
[**deleteRepository**](RepositoryApi.md#deleteRepository) | **DELETE** /repositories/{repos-name}/{version} | deletes a single Orchestra repository based on the ID supplied
[**downloadRepositoryById**](RepositoryApi.md#downloadRepositoryById) | **GET** /repositories/{repos-name}/{version}/file | Retreives a single Orchestra repository file, if found
[**findCodeById**](RepositoryApi.md#findCodeById) | **GET** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | Returns a single Code, if found
[**findCodeSetById**](RepositoryApi.md#findCodeSetById) | **GET** /repositories/{repos-name}/{version}/codesets/{id} | Returns a single CodeSet, if found
[**findComponentById**](RepositoryApi.md#findComponentById) | **GET** /repositories/{repos-name}/{version}/components/{id} | Returns a single component, if found
[**findDatatypeByName**](RepositoryApi.md#findDatatypeByName) | **GET** /repositories/{repos-name}/{version}/datatypes/{name} | Returns a single datatype, if found
[**findFieldById**](RepositoryApi.md#findFieldById) | **GET** /repositories/{repos-name}/{version}/fields/{id} | Returns a single field, if found
[**findGroupById**](RepositoryApi.md#findGroupById) | **GET** /repositories/{repos-name}/{version}/groups/{id} | Returns a single group, if found
[**findMessageById**](RepositoryApi.md#findMessageById) | **GET** /repositories/{repos-name}/{version}/messages/{id} | Returns a single message scenario, if found
[**findRepositoryById**](RepositoryApi.md#findRepositoryById) | **GET** /repositories/{repos-name}/{version} | Returns a single Orchestra repository metadata, if found
[**searchCodeSets**](RepositoryApi.md#searchCodeSets) | **GET** /repositories/{repos-name}/{version}/codesets | searches CodeSets
[**searchCodes**](RepositoryApi.md#searchCodes) | **GET** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes | searches Codes within a CodeSet
[**searchComponents**](RepositoryApi.md#searchComponents) | **GET** /repositories/{repos-name}/{version}/components | searches components
[**searchDatatypes**](RepositoryApi.md#searchDatatypes) | **GET** /repositories/{repos-name}/{version}/datatypes | searches datatypes
[**searchFields**](RepositoryApi.md#searchFields) | **GET** /repositories/{repos-name}/{version}/fields | searches fields
[**searchGroups**](RepositoryApi.md#searchGroups) | **GET** /repositories/{repos-name}/{version}/groups | searches groups
[**searchMessages**](RepositoryApi.md#searchMessages) | **GET** /repositories/{repos-name}/{version}/messages | searches messages
[**searchRepositories**](RepositoryApi.md#searchRepositories) | **GET** /repositories | searches Orchestra repositories
[**updateCodeById**](RepositoryApi.md#updateCodeById) | **PUT** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | Updates a single Code, if found (idempotent)
[**updateCodeSetById**](RepositoryApi.md#updateCodeSetById) | **PUT** /repositories/{repos-name}/{version}/codesets/{id} | Updates a single CodeSet, if found (idempotent)
[**updateComponentById**](RepositoryApi.md#updateComponentById) | **PUT** /repositories/{repos-name}/{version}/components/{id} | Updates a single component, if found (idempotent)
[**updateDatatypeByName**](RepositoryApi.md#updateDatatypeByName) | **PUT** /repositories/{repos-name}/{version}/datatypes/{name} | Updates a single datatype, if found (idempotent)
[**updateFieldById**](RepositoryApi.md#updateFieldById) | **PUT** /repositories/{repos-name}/{version}/fields/{id} | Updates a single field, if found (idempotent)
[**updateGroupById**](RepositoryApi.md#updateGroupById) | **PUT** /repositories/{repos-name}/{version}/groups/{id} | Updates a single group, if found (idempotent)
[**updateMessageById**](RepositoryApi.md#updateMessageById) | **PUT** /repositories/{repos-name}/{version}/messages/{id} | Updates a single message scenario, if found (idempotent)
[**updateRepositoryById**](RepositoryApi.md#updateRepositoryById) | **PUT** /repositories/{repos-name}/{version} | Updates an Orchestra repository, if found (idempotent)


<a name="addCode"></a>
# **addCode**
> addCode(reposName, version, codesetid, code)

adds a Code to CodeSet

Adds a Code

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer codesetid = 56; // Integer | ID of CodeSet
Code code = new Code(); // Code | Code to add
try {
    apiInstance.addCode(reposName, version, codesetid, code);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **codesetid** | **Integer**| ID of CodeSet |
 **code** | [**Code**](Code.md)| Code to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addCodeSet"></a>
# **addCodeSet**
> addCodeSet(reposName, version, codeSet)

adds a CodeSet

Adds a CodeSet

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
CodeSet codeSet = new CodeSet(); // CodeSet | CodeSet to add
try {
    apiInstance.addCodeSet(reposName, version, codeSet);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addCodeSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **codeSet** | [**CodeSet**](CodeSet.md)| CodeSet to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addComponent"></a>
# **addComponent**
> addComponent(reposName, version, component, toClone)

adds a component

Adds a component

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Component component = new Component(); // Component | Component to add
Integer toClone = 56; // Integer | ID of component to clone
try {
    apiInstance.addComponent(reposName, version, component, toClone);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addComponent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **component** | [**Component**](Component.md)| Component to add | [optional]
 **toClone** | **Integer**| ID of component to clone | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addDatatype"></a>
# **addDatatype**
> addDatatype(reposName, version, datatype)

adds a datatype

Adds a datatype

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Datatype datatype = new Datatype(); // Datatype | Datatype to add
try {
    apiInstance.addDatatype(reposName, version, datatype);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addDatatype");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **datatype** | [**Datatype**](Datatype.md)| Datatype to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addField"></a>
# **addField**
> addField(reposName, version, field)

adds a field

Adds a field

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Field field = new Field(); // Field | field to add
try {
    apiInstance.addField(reposName, version, field);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **field** | [**Field**](Field.md)| field to add | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addGroup"></a>
# **addGroup**
> addGroup(reposName, version, group, toClone)

adds a repeating group

Adds a group

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Group group = new Group(); // Group | Group to add
Integer toClone = 56; // Integer | ID of group to clone
try {
    apiInstance.addGroup(reposName, version, group, toClone);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **group** | [**Group**](Group.md)| Group to add | [optional]
 **toClone** | **Integer**| ID of group to clone | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addMessage"></a>
# **addMessage**
> addMessage(reposName, version, message, toClone)

adds a message scenario

Adds a message scenario

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Message message = new Message(); // Message | message to add
Integer toClone = 56; // Integer | ID of message to clone
try {
    apiInstance.addMessage(reposName, version, message, toClone);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **message** | [**Message**](Message.md)| message to add | [optional]
 **toClone** | **Integer**| ID of message to clone | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="addRepository"></a>
# **addRepository**
> addRepository(repository, nameToClone, versionToClone)

adds an Orchestra repository

Adds an Orchestra repository

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
Repository repository = new Repository(); // Repository | Orchestra repository to add
String nameToClone = "nameToClone_example"; // String | name of Orchestra repository to clone
String versionToClone = "versionToClone_example"; // String | version of Orchestra repository to clone
try {
    apiInstance.addRepository(repository, nameToClone, versionToClone);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#addRepository");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **repository** | [**Repository**](Repository.md)| Orchestra repository to add |
 **nameToClone** | **String**| name of Orchestra repository to clone | [optional]
 **versionToClone** | **String**| version of Orchestra repository to clone | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteCode"></a>
# **deleteCode**
> deleteCode(reposName, version, codesetid, id)

deletes a single Code based on the ID supplied

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer codesetid = 56; // Integer | ID of CodeSet
Integer id = 56; // Integer | ID of Code to delete
try {
    apiInstance.deleteCode(reposName, version, codesetid, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteCode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **codesetid** | **Integer**| ID of CodeSet |
 **id** | **Integer**| ID of Code to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteCodeSet"></a>
# **deleteCodeSet**
> deleteCodeSet(reposName, version, id)

deletes a single CodeSet based on the ID supplied

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of CodeSet to delete
try {
    apiInstance.deleteCodeSet(reposName, version, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteCodeSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of CodeSet to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteComponent"></a>
# **deleteComponent**
> deleteComponent(reposName, version, id)

deletes a single component based on the ID supplied

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of component to delete
try {
    apiInstance.deleteComponent(reposName, version, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteComponent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of component to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteDatatype"></a>
# **deleteDatatype**
> deleteDatatype(reposName, version, name)

deletes a single datatype based on the name supplied

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of datatype to delete
try {
    apiInstance.deleteDatatype(reposName, version, name);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteDatatype");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **name** | **String**| name of datatype to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteField"></a>
# **deleteField**
> deleteField(reposName, version, id)

deletes a single field based on the ID supplied

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of field to delete
try {
    apiInstance.deleteField(reposName, version, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of field to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteGroup"></a>
# **deleteGroup**
> deleteGroup(reposName, version, id)

deletes a single group based on the ID supplied

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of group to delete
try {
    apiInstance.deleteGroup(reposName, version, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of group to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteMessage"></a>
# **deleteMessage**
> deleteMessage(reposName, version, id)

deletes a single message scenario based on the ID supplied

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of message to delete
try {
    apiInstance.deleteMessage(reposName, version, id);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of message to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteRepository"></a>
# **deleteRepository**
> deleteRepository(reposName, version)

deletes a single Orchestra repository based on the ID supplied

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository to delete
String version = "version_example"; // String | version of Orchestra repository to delete
try {
    apiInstance.deleteRepository(reposName, version);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#deleteRepository");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository to delete |
 **version** | **String**| version of Orchestra repository to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="downloadRepositoryById"></a>
# **downloadRepositoryById**
> File downloadRepositoryById(reposName, version)

Retreives a single Orchestra repository file, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository to fetch
String version = "version_example"; // String | version of Orchestra repository to fetch
try {
    File result = apiInstance.downloadRepositoryById(reposName, version);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#downloadRepositoryById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository to fetch |
 **version** | **String**| version of Orchestra repository to fetch |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/xml

<a name="findCodeById"></a>
# **findCodeById**
> Code findCodeById(reposName, version, codesetid, id)

Returns a single Code, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer codesetid = 56; // Integer | ID of CodeSet
Integer id = 56; // Integer | ID of Code to fetch
try {
    Code result = apiInstance.findCodeById(reposName, version, codesetid, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findCodeById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **codesetid** | **Integer**| ID of CodeSet |
 **id** | **Integer**| ID of Code to fetch |

### Return type

[**Code**](Code.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="findCodeSetById"></a>
# **findCodeSetById**
> CodeSet findCodeSetById(reposName, version, id)

Returns a single CodeSet, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of CodeSet to fetch
try {
    CodeSet result = apiInstance.findCodeSetById(reposName, version, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findCodeSetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of CodeSet to fetch |

### Return type

[**CodeSet**](CodeSet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="findComponentById"></a>
# **findComponentById**
> Component findComponentById(reposName, version, id)

Returns a single component, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of component to fetch
try {
    Component result = apiInstance.findComponentById(reposName, version, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findComponentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of component to fetch |

### Return type

[**Component**](Component.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="findDatatypeByName"></a>
# **findDatatypeByName**
> Datatype findDatatypeByName(reposName, version, name)

Returns a single datatype, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of datatype to fetch
try {
    Datatype result = apiInstance.findDatatypeByName(reposName, version, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findDatatypeByName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **name** | **String**| name of datatype to fetch |

### Return type

[**Datatype**](Datatype.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="findFieldById"></a>
# **findFieldById**
> Field findFieldById(reposName, version, id)

Returns a single field, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of field to fetch
try {
    Field result = apiInstance.findFieldById(reposName, version, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findFieldById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of field to fetch |

### Return type

[**Field**](Field.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="findGroupById"></a>
# **findGroupById**
> Group findGroupById(reposName, version, id)

Returns a single group, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of group to fetch
try {
    Group result = apiInstance.findGroupById(reposName, version, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findGroupById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of group to fetch |

### Return type

[**Group**](Group.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="findMessageById"></a>
# **findMessageById**
> Message findMessageById(reposName, version, id)

Returns a single message scenario, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of message to fetch
try {
    Message result = apiInstance.findMessageById(reposName, version, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findMessageById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of message to fetch |

### Return type

[**Message**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="findRepositoryById"></a>
# **findRepositoryById**
> Repository findRepositoryById(reposName, version)

Returns a single Orchestra repository metadata, if found

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository to fetch
String version = "version_example"; // String | version of Orchestra repository to fetch
try {
    Repository result = apiInstance.findRepositoryById(reposName, version);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#findRepositoryById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository to fetch |
 **version** | **String**| version of Orchestra repository to fetch |

### Return type

[**Repository**](Repository.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="searchCodeSets"></a>
# **searchCodeSets**
> List&lt;CodeSet&gt; searchCodeSets(reposName, version, searchString, skip, limit)

searches CodeSets

By passing in the appropriate options, you can search for CodeSets 

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String searchString = "searchString_example"; // String | pass an optional search string for looking up CodeSets
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<CodeSet> result = apiInstance.searchCodeSets(reposName, version, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchCodeSets");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **searchString** | **String**| pass an optional search string for looking up CodeSets | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;CodeSet&gt;**](CodeSet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="searchCodes"></a>
# **searchCodes**
> List&lt;Code&gt; searchCodes(reposName, version, codesetid, searchString, skip, limit)

searches Codes within a CodeSet

By passing in the appropriate options, you can search for Codes

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer codesetid = 56; // Integer | ID of CodeSet
String searchString = "searchString_example"; // String | pass an optional search string for looking up Codes
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Code> result = apiInstance.searchCodes(reposName, version, codesetid, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchCodes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **codesetid** | **Integer**| ID of CodeSet |
 **searchString** | **String**| pass an optional search string for looking up Codes | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Code&gt;**](Code.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="searchComponents"></a>
# **searchComponents**
> List&lt;Component&gt; searchComponents(reposName, version, searchString, skip, limit)

searches components

By passing in the appropriate options, you can search for components 

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String searchString = "searchString_example"; // String | pass an optional search string for looking up components
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Component> result = apiInstance.searchComponents(reposName, version, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchComponents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **searchString** | **String**| pass an optional search string for looking up components | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Component&gt;**](Component.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="searchDatatypes"></a>
# **searchDatatypes**
> List&lt;Datatype&gt; searchDatatypes(reposName, version, searchString, skip, limit)

searches datatypes

By passing in the appropriate options, you can search for datatypes 

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String searchString = "searchString_example"; // String | pass an optional search string for looking up datatypes
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Datatype> result = apiInstance.searchDatatypes(reposName, version, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchDatatypes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **searchString** | **String**| pass an optional search string for looking up datatypes | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Datatype&gt;**](Datatype.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="searchFields"></a>
# **searchFields**
> List&lt;Field&gt; searchFields(reposName, version, searchString, skip, limit)

searches fields

By passing in the appropriate options, you can search for fields 

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String searchString = "searchString_example"; // String | pass an optional search string for looking up fields
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Field> result = apiInstance.searchFields(reposName, version, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchFields");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **searchString** | **String**| pass an optional search string for looking up fields | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Field&gt;**](Field.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="searchGroups"></a>
# **searchGroups**
> List&lt;Group&gt; searchGroups(reposName, version, searchString, skip, limit)

searches groups

By passing in the appropriate options, you can search for groups 

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String searchString = "searchString_example"; // String | pass an optional search string for looking up groups
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Group> result = apiInstance.searchGroups(reposName, version, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **searchString** | **String**| pass an optional search string for looking up groups | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Group&gt;**](Group.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="searchMessages"></a>
# **searchMessages**
> List&lt;Message&gt; searchMessages(reposName, version, searchString, skip, limit)

searches messages

By passing in the appropriate options, you can search for messages 

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String searchString = "searchString_example"; // String | pass an optional search string for looking up messages
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Message> result = apiInstance.searchMessages(reposName, version, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchMessages");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **searchString** | **String**| pass an optional search string for looking up messages | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Message&gt;**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="searchRepositories"></a>
# **searchRepositories**
> List&lt;Repository&gt; searchRepositories(searchString, skip, limit)

searches Orchestra repositories

By passing in the appropriate options, you can search for Orchestra repositories

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String searchString = "searchString_example"; // String | pass an optional search string for looking up repositories
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Repository> result = apiInstance.searchRepositories(searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#searchRepositories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **searchString** | **String**| pass an optional search string for looking up repositories | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Repository&gt;**](Repository.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateCodeById"></a>
# **updateCodeById**
> updateCodeById(reposName, version, codesetid, id, code)

Updates a single Code, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer codesetid = 56; // Integer | ID of CodeSet
Integer id = 56; // Integer | ID of Code to update
Code code = new Code(); // Code | Code to update
try {
    apiInstance.updateCodeById(reposName, version, codesetid, id, code);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateCodeById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **codesetid** | **Integer**| ID of CodeSet |
 **id** | **Integer**| ID of Code to update |
 **code** | [**Code**](Code.md)| Code to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateCodeSetById"></a>
# **updateCodeSetById**
> updateCodeSetById(reposName, version, id, codeSet)

Updates a single CodeSet, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of CodeSet to update
CodeSet codeSet = new CodeSet(); // CodeSet | CodeSet to update
try {
    apiInstance.updateCodeSetById(reposName, version, id, codeSet);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateCodeSetById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of CodeSet to update |
 **codeSet** | [**CodeSet**](CodeSet.md)| CodeSet to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateComponentById"></a>
# **updateComponentById**
> updateComponentById(reposName, version, id, component)

Updates a single component, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of component to update
Component component = new Component(); // Component | component to update
try {
    apiInstance.updateComponentById(reposName, version, id, component);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateComponentById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of component to update |
 **component** | [**Component**](Component.md)| component to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateDatatypeByName"></a>
# **updateDatatypeByName**
> updateDatatypeByName(reposName, version, name, datatype)

Updates a single datatype, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of datatype to update
Datatype datatype = new Datatype(); // Datatype | datatype to update
try {
    apiInstance.updateDatatypeByName(reposName, version, name, datatype);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateDatatypeByName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **name** | **String**| name of datatype to update |
 **datatype** | [**Datatype**](Datatype.md)| datatype to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateFieldById"></a>
# **updateFieldById**
> updateFieldById(reposName, version, id, field)

Updates a single field, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of field to update
Field field = new Field(); // Field | field to update
try {
    apiInstance.updateFieldById(reposName, version, id, field);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateFieldById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of field to update |
 **field** | [**Field**](Field.md)| field to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateGroupById"></a>
# **updateGroupById**
> updateGroupById(reposName, version, id, group)

Updates a single group, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of group to update
Group group = new Group(); // Group | group to update
try {
    apiInstance.updateGroupById(reposName, version, id, group);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateGroupById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of group to update |
 **group** | [**Group**](Group.md)| group to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateMessageById"></a>
# **updateMessageById**
> updateMessageById(reposName, version, id, message)

Updates a single message scenario, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of message to update
Message message = new Message(); // Message | message to update
try {
    apiInstance.updateMessageById(reposName, version, id, message);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateMessageById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of message to update |
 **message** | [**Message**](Message.md)| message to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="updateRepositoryById"></a>
# **updateRepositoryById**
> updateRepositoryById(reposName, version, repository)

Updates an Orchestra repository, if found (idempotent)

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.client.ApiException;
//import io.fixprotocol.orchestra.client.api.RepositoryApi;


RepositoryApi apiInstance = new RepositoryApi();
String reposName = "reposName_example"; // String | name of Orchestra repository to update
String version = "version_example"; // String | version of Orchestra repository to update
Repository repository = new Repository(); // Repository | Orchestra repository to update
try {
    apiInstance.updateRepositoryById(reposName, version, repository);
} catch (ApiException e) {
    System.err.println("Exception when calling RepositoryApi#updateRepositoryById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository to update |
 **version** | **String**| version of Orchestra repository to update |
 **repository** | [**Repository**](Repository.md)| Orchestra repository to update |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

