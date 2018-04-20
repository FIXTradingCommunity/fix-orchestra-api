# WorkflowApi

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
> addActor(reposName, version, actor)

adds an Actor

Adds an Actor

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Actor actor = new Actor(); // Actor | Actor to add
try {
    apiInstance.addActor(reposName, version, actor);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#addActor");
    e.printStackTrace();
}
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
> addFlow(reposName, version, flow)

adds a Flow

Adds a Flow

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Flow flow = new Flow(); // Flow | Flow to add
try {
    apiInstance.addFlow(reposName, version, flow);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#addFlow");
    e.printStackTrace();
}
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
> addMessageResponse(reposName, version, id, response)

adds a response to a message scenario

Adds a message scenario response

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of message to update
Response response = new Response(); // Response | message response to add
try {
    apiInstance.addMessageResponse(reposName, version, id, response);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#addMessageResponse");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of message to update |
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
> addStateMachine(reposName, version, name, stateMachine)

adds a state machine

Adds a StateMachine

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Actor to update
StateMachine stateMachine = new StateMachine(); // StateMachine | StateMachine to add
try {
    apiInstance.addStateMachine(reposName, version, name, stateMachine);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#addStateMachine");
    e.printStackTrace();
}
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Actor to delete
try {
    apiInstance.deleteActor(reposName, version, name);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#deleteActor");
    e.printStackTrace();
}
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Flow to delete
try {
    apiInstance.deleteFlow(reposName, version, name);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#deleteFlow");
    e.printStackTrace();
}
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of message
String name = "name_example"; // String | name of message response to delete
try {
    apiInstance.deleteMessageResponse(reposName, version, id, name);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#deleteMessageResponse");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of message |
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Actor to update
String smName = "smName_example"; // String | name of StateMachine to delete
try {
    apiInstance.deleteStateMachine(reposName, version, name, smName);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#deleteStateMachine");
    e.printStackTrace();
}
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Actor to fetch
try {
    Actor result = apiInstance.findActorByName(reposName, version, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#findActorByName");
    e.printStackTrace();
}
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Flow to fetch
try {
    Flow result = apiInstance.findFlowByName(reposName, version, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#findFlowByName");
    e.printStackTrace();
}
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of message
String name = "name_example"; // String | name of message response to fetch
try {
    Response result = apiInstance.findMessageResponseById(reposName, version, id, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#findMessageResponseById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of message |
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Actor to search
String smName = "smName_example"; // String | name of StateMachine to fetch
try {
    StateMachine result = apiInstance.findStateMachine(reposName, version, name, smName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#findStateMachine");
    e.printStackTrace();
}
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
> List&lt;Actor&gt; searchActors(reposName, version, searchString, skip, limit)

searches actors

By passing in the appropriate options, you can search for actors 

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String searchString = "searchString_example"; // String | pass an optional search string for looking up actors
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Actor> result = apiInstance.searchActors(reposName, version, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#searchActors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **searchString** | **String**| pass an optional search string for looking up actors | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Actor&gt;**](Actor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchFlows"></a>
# **searchFlows**
> List&lt;Flow&gt; searchFlows(reposName, version, searchString, skip, limit)

searches flows

By passing in the appropriate options, you can search for flows 

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String searchString = "searchString_example"; // String | pass an optional search string for looking up flows
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Flow> result = apiInstance.searchFlows(reposName, version, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#searchFlows");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **searchString** | **String**| pass an optional search string for looking up flows | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Flow&gt;**](Flow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchMessageResponses"></a>
# **searchMessageResponses**
> List&lt;Response&gt; searchMessageResponses(reposName, version, id, searchString, skip, limit)

searches message responses

By passing in the appropriate options, you can search for message responses

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of message to search
String searchString = "searchString_example"; // String | pass an optional search string for looking up responses
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<Response> result = apiInstance.searchMessageResponses(reposName, version, id, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#searchMessageResponses");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of message to search |
 **searchString** | **String**| pass an optional search string for looking up responses | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;Response&gt;**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="searchStateMachines"></a>
# **searchStateMachines**
> List&lt;StateMachine&gt; searchStateMachines(reposName, version, name, searchString, skip, limit)

searches state machines

By passing in the appropriate options, you can search for state machines

### Example
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Actor to search
String searchString = "searchString_example"; // String | pass an optional search string for looking up actors
Integer skip = 56; // Integer | number of records to skip for pagination
Integer limit = 56; // Integer | maximum number of records to return
try {
    List<StateMachine> result = apiInstance.searchStateMachines(reposName, version, name, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#searchStateMachines");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **name** | **String**| name of Actor to search |
 **searchString** | **String**| pass an optional search string for looking up actors | [optional]
 **skip** | **Integer**| number of records to skip for pagination | [optional]
 **limit** | **Integer**| maximum number of records to return | [optional]

### Return type

[**List&lt;StateMachine&gt;**](StateMachine.md)

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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of CodeSet to update
Actor actor = new Actor(); // Actor | Actor to update
try {
    apiInstance.updateActorByName(reposName, version, name, actor);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#updateActorByName");
    e.printStackTrace();
}
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Flow to update
Flow actor = new Flow(); // Flow | Flow to update
try {
    apiInstance.updateFlowByName(reposName, version, name, actor);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#updateFlowByName");
    e.printStackTrace();
}
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
Integer id = 56; // Integer | ID of message
String name = "name_example"; // String | name of message response to update
Response response = new Response(); // Response | message response to update
try {
    apiInstance.updateMessageResponse(reposName, version, id, name, response);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#updateMessageResponse");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reposName** | **String**| name of Orchestra repository |
 **version** | **String**| version of Orchestra repository |
 **id** | **Integer**| ID of message |
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
```java
// Import classes:
//import io.fixprotocol.orchestra.ApiException;
//import io.fixprotocol.orchestra.client.WorkflowApi;


WorkflowApi apiInstance = new WorkflowApi();
String reposName = "reposName_example"; // String | name of Orchestra repository
String version = "version_example"; // String | version of Orchestra repository
String name = "name_example"; // String | name of Actor to update
String smName = "smName_example"; // String | name of StateMachine to update
StateMachine stateMachine = new StateMachine(); // StateMachine | StateMachine to update
try {
    apiInstance.updateStateMachine(reposName, version, name, smName, stateMachine);
} catch (ApiException e) {
    System.err.println("Exception when calling WorkflowApi#updateStateMachine");
    e.printStackTrace();
}
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

