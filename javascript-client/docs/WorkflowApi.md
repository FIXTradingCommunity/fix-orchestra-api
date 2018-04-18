# OrchestraApi.WorkflowApi

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addActor**](WorkflowApi.md#addActor) | **POST** /repositories/{repos-name}/{version}/actors | adds an Actor
[**addFlow**](WorkflowApi.md#addFlow) | **POST** /repositories/{repos-name}/{version}/flows | adds a Flow
[**addMessageResponse**](WorkflowApi.md#addMessageResponse) | **POST** /repositories/{repos-name}/{version}/messages/{id}/responses | adds a response to a message scenario
[**addStateMachine**](WorkflowApi.md#addStateMachine) | **POST** /repositories/{repos-name}/{version}/actors/{name}/statemachines | adds a state machine
[**deleteActor**](WorkflowApi.md#deleteActor) | **DELETE** /repositories/{repos-name}/{version}/actors/{name} | deletes a single Actor based on the name supplied
[**deleteFlow**](WorkflowApi.md#deleteFlow) | **DELETE** /repositories/{repos-name}/{version}/flows/{name} | deletes a single Flow based on the name supplied
[**deleteMessageResponse**](WorkflowApi.md#deleteMessageResponse) | **DELETE** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | deletes a single response to a message scenario based on the ID supplied
[**deleteStateMachine**](WorkflowApi.md#deleteStateMachine) | **DELETE** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | deletes a single StateMachine based on the name supplied
[**findActorByName**](WorkflowApi.md#findActorByName) | **GET** /repositories/{repos-name}/{version}/actors/{name} | Returns a single Actor, if found
[**findFlowByName**](WorkflowApi.md#findFlowByName) | **GET** /repositories/{repos-name}/{version}/flows/{name} | Returns a single Flow, if found
[**findMessageResponseById**](WorkflowApi.md#findMessageResponseById) | **GET** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | Returns a single response to a message scenario, if found
[**findStateMachine**](WorkflowApi.md#findStateMachine) | **GET** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | Returns a single StateMachine, if found
[**searchActors**](WorkflowApi.md#searchActors) | **GET** /repositories/{repos-name}/{version}/actors | searches actors
[**searchFlows**](WorkflowApi.md#searchFlows) | **GET** /repositories/{repos-name}/{version}/flows | searches flows
[**searchMessageResponses**](WorkflowApi.md#searchMessageResponses) | **GET** /repositories/{repos-name}/{version}/messages/{id}/responses | searches message responses
[**searchStateMachines**](WorkflowApi.md#searchStateMachines) | **GET** /repositories/{repos-name}/{version}/actors/{name}/statemachines | searches state machines
[**updateActorByName**](WorkflowApi.md#updateActorByName) | **PUT** /repositories/{repos-name}/{version}/actors/{name} | Updates a single Actor, if found (idempotent)
[**updateFlowByName**](WorkflowApi.md#updateFlowByName) | **PUT** /repositories/{repos-name}/{version}/flows/{name} | Updates a single Flow, if found (idempotent)
[**updateMessageResponse**](WorkflowApi.md#updateMessageResponse) | **PUT** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | Updates a single response to a message scenario, if found (idempotent)
[**updateStateMachine**](WorkflowApi.md#updateStateMachine) | **PUT** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | Updates a single StateMachine, if found (idempotent)


<a name="addActor"></a>
# **addActor**
> addActor(reposName, version, opts)

adds an Actor

Adds an Actor

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'actor': new OrchestraApi.Actor() // Actor | Actor to add
};

apiInstance.addActor(reposName, version, opts, (error, data, response) => {
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
 **actor** | [**Actor**](Actor.md)| Actor to add | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addFlow"></a>
# **addFlow**
> addFlow(reposName, version, opts)

adds a Flow

Adds a Flow

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'flow': new OrchestraApi.Flow() // Flow | Flow to add
};

apiInstance.addFlow(reposName, version, opts, (error, data, response) => {
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
 **flow** | [**Flow**](Flow.md)| Flow to add | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addMessageResponse"></a>
# **addMessageResponse**
> addMessageResponse(reposName, version, id, opts)

adds a response to a message scenario

Adds a message scenario response

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of message to update

let opts = { 
  'response': new OrchestraApi.Response() // Response | message response to add
};

apiInstance.addMessageResponse(reposName, version, id, opts, (error, data, response) => {
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
 **response** | [**Response**](Response.md)| message response to add | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addStateMachine"></a>
# **addStateMachine**
> addStateMachine(reposName, version, name, opts)

adds a state machine

Adds a StateMachine

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Actor to update

let opts = { 
  'stateMachine': new OrchestraApi.StateMachine() // StateMachine | StateMachine to add
};

apiInstance.addStateMachine(reposName, version, name, opts, (error, data, response) => {
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
 **name** | **String**| name of Actor to update | 
 **stateMachine** | [**StateMachine**](StateMachine.md)| StateMachine to add | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteActor"></a>
# **deleteActor**
> deleteActor(reposName, version, name)

deletes a single Actor based on the name supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Actor to delete


apiInstance.deleteActor(reposName, version, name, (error, data, response) => {
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
 **name** | **String**| name of Actor to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteFlow"></a>
# **deleteFlow**
> deleteFlow(reposName, version, name)

deletes a single Flow based on the name supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Flow to delete


apiInstance.deleteFlow(reposName, version, name, (error, data, response) => {
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
 **name** | **String**| name of Flow to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteMessageResponse"></a>
# **deleteMessageResponse**
> deleteMessageResponse(reposName, version, id, name)

deletes a single response to a message scenario based on the ID supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of message

let name = "name_example"; // String | name of message response to delete


apiInstance.deleteMessageResponse(reposName, version, id, name, (error, data, response) => {
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
 **id** | **Number**| ID of message | 
 **name** | **String**| name of message response to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteStateMachine"></a>
# **deleteStateMachine**
> deleteStateMachine(reposName, version, name, smName)

deletes a single StateMachine based on the name supplied

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Actor to update

let smName = "smName_example"; // String | name of StateMachine to delete


apiInstance.deleteStateMachine(reposName, version, name, smName, (error, data, response) => {
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
 **name** | **String**| name of Actor to update | 
 **smName** | **String**| name of StateMachine to delete | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findActorByName"></a>
# **findActorByName**
> Actor findActorByName(reposName, version, name)

Returns a single Actor, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Actor to fetch


apiInstance.findActorByName(reposName, version, name, (error, data, response) => {
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
 **name** | **String**| name of Actor to fetch | 

### Return type

[**Actor**](Actor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findFlowByName"></a>
# **findFlowByName**
> Flow findFlowByName(reposName, version, name)

Returns a single Flow, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Flow to fetch


apiInstance.findFlowByName(reposName, version, name, (error, data, response) => {
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
 **name** | **String**| name of Flow to fetch | 

### Return type

[**Flow**](Flow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findMessageResponseById"></a>
# **findMessageResponseById**
> Response findMessageResponseById(reposName, version, id, name)

Returns a single response to a message scenario, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of message

let name = "name_example"; // String | name of message response to fetch


apiInstance.findMessageResponseById(reposName, version, id, name, (error, data, response) => {
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
 **id** | **Number**| ID of message | 
 **name** | **String**| name of message response to fetch | 

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findStateMachine"></a>
# **findStateMachine**
> StateMachine findStateMachine(reposName, version, name, smName)

Returns a single StateMachine, if found

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Actor to search

let smName = "smName_example"; // String | name of StateMachine to fetch


apiInstance.findStateMachine(reposName, version, name, smName, (error, data, response) => {
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
 **name** | **String**| name of Actor to search | 
 **smName** | **String**| name of StateMachine to fetch | 

### Return type

[**StateMachine**](StateMachine.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchActors"></a>
# **searchActors**
> [Actor] searchActors(reposName, version, opts)

searches actors

By passing in the appropriate options, you can search for actors 

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up actors
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchActors(reposName, version, opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up actors | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Actor]**](Actor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchFlows"></a>
# **searchFlows**
> [Flow] searchFlows(reposName, version, opts)

searches flows

By passing in the appropriate options, you can search for flows 

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up flows
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchFlows(reposName, version, opts, (error, data, response) => {
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
 **searchString** | **String**| pass an optional search string for looking up flows | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Flow]**](Flow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchMessageResponses"></a>
# **searchMessageResponses**
> [Response] searchMessageResponses(reposName, version, id, opts)

searches message responses

By passing in the appropriate options, you can search for message responses

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of message to search

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up responses
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchMessageResponses(reposName, version, id, opts, (error, data, response) => {
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
 **id** | **Number**| ID of message to search | 
 **searchString** | **String**| pass an optional search string for looking up responses | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[Response]**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchStateMachines"></a>
# **searchStateMachines**
> [StateMachine] searchStateMachines(reposName, version, name, opts)

searches state machines

By passing in the appropriate options, you can search for state machines

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Actor to search

let opts = { 
  'searchString': "searchString_example", // String | pass an optional search string for looking up actors
  'skip': 56, // Number | number of records to skip for pagination
  'limit': 56 // Number | maximum number of records to return
};

apiInstance.searchStateMachines(reposName, version, name, opts, (error, data, response) => {
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
 **name** | **String**| name of Actor to search | 
 **searchString** | **String**| pass an optional search string for looking up actors | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] 
 **limit** | **Number**| maximum number of records to return | [optional] 

### Return type

[**[StateMachine]**](StateMachine.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateActorByName"></a>
# **updateActorByName**
> updateActorByName(reposName, version, name, actor)

Updates a single Actor, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of CodeSet to update

let actor = new OrchestraApi.Actor(); // Actor | Actor to update


apiInstance.updateActorByName(reposName, version, name, actor, (error, data, response) => {
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
 **name** | **String**| name of CodeSet to update | 
 **actor** | [**Actor**](Actor.md)| Actor to update | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateFlowByName"></a>
# **updateFlowByName**
> updateFlowByName(reposName, version, name, actor)

Updates a single Flow, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Flow to update

let actor = new OrchestraApi.Flow(); // Flow | Flow to update


apiInstance.updateFlowByName(reposName, version, name, actor, (error, data, response) => {
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
 **name** | **String**| name of Flow to update | 
 **actor** | [**Flow**](Flow.md)| Flow to update | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateMessageResponse"></a>
# **updateMessageResponse**
> updateMessageResponse(reposName, version, id, name, response)

Updates a single response to a message scenario, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let id = 56; // Number | ID of message

let name = "name_example"; // String | name of message response to update

let response = new OrchestraApi.Response(); // Response | message response to update


apiInstance.updateMessageResponse(reposName, version, id, name, response, (error, data, response) => {
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
 **id** | **Number**| ID of message | 
 **name** | **String**| name of message response to update | 
 **response** | [**Response**](Response.md)| message response to update | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateStateMachine"></a>
# **updateStateMachine**
> updateStateMachine(reposName, version, name, smName, stateMachine)

Updates a single StateMachine, if found (idempotent)

### Example
```javascript
import OrchestraApi from 'orchestra_api';

let apiInstance = new OrchestraApi.WorkflowApi();

let reposName = "reposName_example"; // String | name of Orchestra repository

let version = "version_example"; // String | version of Orchestra repository

let name = "name_example"; // String | name of Actor to update

let smName = "smName_example"; // String | name of StateMachine to update

let stateMachine = new OrchestraApi.StateMachine(); // StateMachine | StateMachine to update


apiInstance.updateStateMachine(reposName, version, name, smName, stateMachine, (error, data, response) => {
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
 **name** | **String**| name of Actor to update | 
 **smName** | **String**| name of StateMachine to update | 
 **stateMachine** | [**StateMachine**](StateMachine.md)| StateMachine to update | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

