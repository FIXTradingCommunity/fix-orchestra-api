# OrchestraApi.RepositoryApi

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
> addCode(reposName, version, codesetid, opts)

adds a Code to CodeSet

Adds a Code

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let codesetid = 56; // Number | ID of CodeSet

let opts = { 
  'code': new OrchestraApi.Code() // Code | Code to add
};

apiInstance.addCode(reposName, version, codesetid, opts, (error, data, response) => {
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
 **codesetid** | **Number**| ID of CodeSet | 
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
> addCodeSet(reposName, version, opts)

adds a CodeSet

Adds a CodeSet

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'codeSet': new OrchestraApi.CodeSet() // CodeSet | CodeSet to add
};

apiInstance.addCodeSet(reposName, version, opts, (error, data, response) => {
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
> addComponent(reposName, version, opts)

adds a component

Adds a component

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'component': new OrchestraApi.Component(), // Component | Component to add
  'toClone': 56 // Number | ID of component to clone
};

apiInstance.addComponent(reposName, version, opts, (error, data, response) => {
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
 **component** | [**Component**](Component.md)| Component to add | [optional] 
 **toClone** | **Number**| ID of component to clone | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="addDatatype"></a>
# **addDatatype**
> addDatatype(reposName, version, opts)

adds a datatype

Adds a datatype

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'datatype': new OrchestraApi.Datatype() // Datatype | Datatype to add
};

apiInstance.addDatatype(reposName, version, opts, (error, data, response) => {
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
> addField(reposName, version, opts)

adds a field

Adds a field

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'field': new OrchestraApi.Field() // Field | field to add
};

apiInstance.addField(reposName, version, opts, (error, data, response) => {
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
 **field** | [**Field**](Field.md)| field to add | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addGroup"></a>
# **addGroup**
> addGroup(reposName, version, opts)

adds a repeating group

Adds a group

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'group': new OrchestraApi.Group(), // Group | Group to add
  'toClone': 56 // Number | ID of group to clone
};

apiInstance.addGroup(reposName, version, opts, (error, data, response) => {
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
 **group** | [**Group**](Group.md)| Group to add | [optional] 
 **toClone** | **Number**| ID of group to clone | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="addMessage"></a>
# **addMessage**
> addMessage(reposName, version, opts)

adds a message scenario

Adds a message scenario

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'message': new OrchestraApi.Message(), // Message | message to add
  'toClone': 56 // Number | ID of message to clone
};

apiInstance.addMessage(reposName, version, opts, (error, data, response) => {
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
 **message** | [**Message**](Message.md)| message to add | [optional] 
 **toClone** | **Number**| ID of message to clone | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addRepository"></a>
# **addRepository**
> addRepository(repository, opts)

adds an Orchestra repository

Adds an Orchestra repository

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let repository = new OrchestraApi.Repository(); // Repository | Orchestra repository to add

let opts = { 
  'nameToClone': "nameToClone_example", // String | name of Orchestra repository to clone
  'versionToClone': "versionToClone_example" // String | version of Orchestra repository to clone
};

apiInstance.addRepository(repository, opts, (error, data, response) => {
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
 **repository** | [**Repository**](Repository.md)| Orchestra repository to add | 
 **nameToClone** | **String**| name of Orchestra repository to clone | [optional] 
 **versionToClone** | **String**| version of Orchestra repository to clone | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCode"></a>
# **deleteCode**
> deleteCode(reposName, version, codesetid, id)

deletes a single Code based on the ID supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let codesetid = 56; // Number | ID of CodeSet

let id = 56; // Number | ID of Code to delete


apiInstance.deleteCode(reposName, version, codesetid, id, (error, data, response) => {
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
 **codesetid** | **Number**| ID of CodeSet | 
 **id** | **Number**| ID of Code to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteCodeSet"></a>
# **deleteCodeSet**
> deleteCodeSet(reposName, version, id)

deletes a single CodeSet based on the ID supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of CodeSet to delete


apiInstance.deleteCodeSet(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of CodeSet to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteComponent"></a>
# **deleteComponent**
> deleteComponent(reposName, version, id)

deletes a single component based on the ID supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of component to delete


apiInstance.deleteComponent(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of component to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteDatatype"></a>
# **deleteDatatype**
> deleteDatatype(reposName, version, name)

deletes a single datatype based on the name supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of datatype to delete


apiInstance.deleteDatatype(reposName, version, name, (error, data, response) => {
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
> deleteField(reposName, version, id)

deletes a single field based on the ID supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of field to delete


apiInstance.deleteField(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of field to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteGroup"></a>
# **deleteGroup**
> deleteGroup(reposName, version, id)

deletes a single group based on the ID supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of group to delete


apiInstance.deleteGroup(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of group to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteMessage"></a>
# **deleteMessage**
> deleteMessage(reposName, version, id)

deletes a single message scenario based on the ID supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of message to delete


apiInstance.deleteMessage(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of message to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteRepository"></a>
# **deleteRepository**
> deleteRepository(reposName, version)

deletes a single Orchestra repository based on the ID supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository to delete

let version = "version_example"; // String | version of Orchestra repository to delete


apiInstance.deleteRepository(reposName, version, (error, data, response) => {
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
 **reposName** | **String**| name of Orchestra repository to delete | 
 **version** | **String**| version of Orchestra repository to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="downloadRepositoryById"></a>
# **downloadRepositoryById**
> File downloadRepositoryById(reposName, version)

Retreives a single Orchestra repository file, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository to fetch

let version = "version_example"; // String | version of Orchestra repository to fetch


apiInstance.downloadRepositoryById(reposName, version, (error, data, response) => {
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
 **reposName** | **String**| name of Orchestra repository to fetch | 
 **version** | **String**| version of Orchestra repository to fetch | 

### Return type

**File**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml

<a name="findCodeById"></a>
# **findCodeById**
> Code findCodeById(reposName, version, codesetid, id)

Returns a single Code, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let codesetid = 56; // Number | ID of CodeSet

let id = 56; // Number | ID of Code to fetch


apiInstance.findCodeById(reposName, version, codesetid, id, (error, data, response) => {
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
 **codesetid** | **Number**| ID of CodeSet | 
 **id** | **Number**| ID of Code to fetch | 

### Return type

[**Code**](Code.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findCodeSetById"></a>
# **findCodeSetById**
> CodeSet findCodeSetById(reposName, version, id)

Returns a single CodeSet, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of CodeSet to fetch


apiInstance.findCodeSetById(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of CodeSet to fetch | 

### Return type

[**CodeSet**](CodeSet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findComponentById"></a>
# **findComponentById**
> Component findComponentById(reposName, version, id)

Returns a single component, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of component to fetch


apiInstance.findComponentById(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of component to fetch | 

### Return type

[**Component**](Component.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findDatatypeByName"></a>
# **findDatatypeByName**
> Datatype findDatatypeByName(reposName, version, name)

Returns a single datatype, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of datatype to fetch


apiInstance.findDatatypeByName(reposName, version, name, (error, data, response) => {
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
> Field findFieldById(reposName, version, id)

Returns a single field, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of field to fetch


apiInstance.findFieldById(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of field to fetch | 

### Return type

[**Field**](Field.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findGroupById"></a>
# **findGroupById**
> Group findGroupById(reposName, version, id)

Returns a single group, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of group to fetch


apiInstance.findGroupById(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of group to fetch | 

### Return type

[**Group**](Group.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findMessageById"></a>
# **findMessageById**
> Message findMessageById(reposName, version, id)

Returns a single message scenario, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of message to fetch


apiInstance.findMessageById(reposName, version, id, (error, data, response) => {
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
 **id** | **Number**| ID of message to fetch | 

### Return type

[**Message**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="findRepositoryById"></a>
# **findRepositoryById**
> Repository findRepositoryById(reposName, version)

Returns a single Orchestra repository metadata, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository to fetch

let version = "version_example"; // String | version of Orchestra repository to fetch


apiInstance.findRepositoryById(reposName, version, (error, data, response) => {
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
 **reposName** | **String**| name of Orchestra repository to fetch | 
 **version** | **String**| version of Orchestra repository to fetch | 

### Return type

[**Repository**](Repository.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchCodeSets"></a>
# **searchCodeSets**
> [CodeSet] searchCodeSets(reposName, version, opts)

searches CodeSets

By passing in the appropriate options, you can search for CodeSets 

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up CodeSets
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchCodeSets(reposName, version, opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up CodeSets | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[CodeSet]**](CodeSet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchCodes"></a>
# **searchCodes**
> [Code] searchCodes(reposName, version, codesetid, opts)

searches Codes within a CodeSet

By passing in the appropriate options, you can search for Codes

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let codesetid = 56; // Number | ID of CodeSet

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up Codes
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchCodes(reposName, version, codesetid, opts, (error, data, response) => {
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
 **codesetid** | **Number**| ID of CodeSet | 
 **searchString** | **String**| pass an optional search string for looking up Codes | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Code]**](Code.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchComponents"></a>
# **searchComponents**
> [Component] searchComponents(reposName, version, opts)

searches components

By passing in the appropriate options, you can search for components 

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up components
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchComponents(reposName, version, opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up components | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Component]**](Component.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchDatatypes"></a>
# **searchDatatypes**
> [Datatype] searchDatatypes(reposName, version, opts)

searches datatypes

By passing in the appropriate options, you can search for datatypes 

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up datatypes
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchDatatypes(reposName, version, opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up datatypes | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Datatype]**](Datatype.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchFields"></a>
# **searchFields**
> [Field] searchFields(reposName, version, opts)

searches fields

By passing in the appropriate options, you can search for fields 

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up fields
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchFields(reposName, version, opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up fields | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Field]**](Field.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchGroups"></a>
# **searchGroups**
> [Group] searchGroups(reposName, version, opts)

searches groups

By passing in the appropriate options, you can search for groups 

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up groups
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchGroups(reposName, version, opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up groups | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Group]**](Group.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchMessages"></a>
# **searchMessages**
> [Message] searchMessages(reposName, version, opts)

searches messages

By passing in the appropriate options, you can search for messages 

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up messages
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchMessages(reposName, version, opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up messages | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Message]**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="searchRepositories"></a>
# **searchRepositories**
> [Repository] searchRepositories(opts)

searches Orchestra repositories

By passing in the appropriate options, you can search for Orchestra repositories

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up repositories
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchRepositories(opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up repositories | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Repository]**](Repository.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateCodeById"></a>
# **updateCodeById**
> updateCodeById(reposName, version, codesetid, id, code)

Updates a single Code, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let codesetid = 56; // Number | ID of CodeSet

let id = 56; // Number | ID of Code to update

let code = new OrchestraApi.Code(); // Code | Code to update


apiInstance.updateCodeById(reposName, version, codesetid, id, code, (error, data, response) => {
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
 **codesetid** | **Number**| ID of CodeSet | 
 **id** | **Number**| ID of Code to update | 
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
> updateCodeSetById(reposName, version, id, codeSet)

Updates a single CodeSet, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of CodeSet to update

let codeSet = new OrchestraApi.CodeSet(); // CodeSet | CodeSet to update


apiInstance.updateCodeSetById(reposName, version, id, codeSet, (error, data, response) => {
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
 **id** | **Number**| ID of CodeSet to update | 
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
> updateComponentById(reposName, version, id, component)

Updates a single component, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of component to update

let component = new OrchestraApi.Component(); // Component | component to update


apiInstance.updateComponentById(reposName, version, id, component, (error, data, response) => {
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
 **id** | **Number**| ID of component to update | 
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
> updateDatatypeByName(reposName, version, name, datatype)

Updates a single datatype, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of datatype to update

let datatype = new OrchestraApi.Datatype(); // Datatype | datatype to update


apiInstance.updateDatatypeByName(reposName, version, name, datatype, (error, data, response) => {
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
> updateFieldById(reposName, version, id, field)

Updates a single field, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of field to update

let field = new OrchestraApi.Field(); // Field | field to update


apiInstance.updateFieldById(reposName, version, id, field, (error, data, response) => {
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
 **id** | **Number**| ID of field to update | 
 **field** | [**Field**](Field.md)| field to update | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateGroupById"></a>
# **updateGroupById**
> updateGroupById(reposName, version, id, group)

Updates a single group, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of group to update

let group = new OrchestraApi.Group(); // Group | group to update


apiInstance.updateGroupById(reposName, version, id, group, (error, data, response) => {
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
 **id** | **Number**| ID of group to update | 
 **group** | [**Group**](Group.md)| group to update | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="updateMessageById"></a>
# **updateMessageById**
> updateMessageById(reposName, version, id, message)

Updates a single message scenario, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of message to update

let message = new OrchestraApi.Message(); // Message | message to update


apiInstance.updateMessageById(reposName, version, id, message, (error, data, response) => {
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
 **id** | **Number**| ID of message to update | 
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
> updateRepositoryById(reposName, version, repository)

Updates an Orchestra repository, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.RepositoryApi();

let reposName = "reposName_example"; // String | name of Orchestra repository to update

let version = "version_example"; // String | version of Orchestra repository to update

let repository = new OrchestraApi.Repository(); // Repository | Orchestra repository to update


apiInstance.updateRepositoryById(reposName, version, repository, (error, data, response) => {
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
 **reposName** | **String**| name of Orchestra repository to update | 
 **version** | **String**| version of Orchestra repository to update | 
 **repository** | [**Repository**](Repository.md)| Orchestra repository to update | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

