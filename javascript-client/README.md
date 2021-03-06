# orchestra_api

OrchestraApi - JavaScript client for orchestra_api
API to edit FIX Orchestra (machine readable rules of engagement) specification version 1.0 RC3
This SDK is automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen) project:

- API version: 1.0.1
- Package version: 1.0.1
- Build package: io.swagger.codegen.languages.JavascriptClientCodegen

## Installation

### For [Node.js](https://nodejs.org/)

#### npm

To publish the library as a [npm](https://www.npmjs.com/),
please follow the procedure in ["Publishing npm packages"](https://docs.npmjs.com/getting-started/publishing-npm-packages).

Then install it via:

```shell
npm install orchestra_api --save
```

#### git
#
If the library is hosted at a git repository, e.g.
https://github.com/YOUR_USERNAME/orchestra_api
then install it via:

```shell
    npm install YOUR_USERNAME/orchestra_api --save
```

### For browser

The library also works in the browser environment via npm and [browserify](http://browserify.org/). After following
the above steps with Node.js and installing browserify with `npm install -g browserify`,
perform the following (assuming *main.js* is your entry file):

```shell
browserify main.js > bundle.js
```

Then include *bundle.js* in the HTML pages.

### Webpack Configuration

Using Webpack you may encounter the following error: "Module not found: Error:
Cannot resolve module", most certainly you should disable AMD loader. Add/merge
the following section to your webpack config:

```javascript
module: {
  rules: [
    {
      parser: {
        amd: false
      }
    }
  ]
}
```

## Getting Started

Please follow the [installation](#installation) instruction and execute the following JS code:

```javascript
var OrchestraApi = require('orchestra_api');

var api = new OrchestraApi.DocumentationApi()

var reposName = "reposName_example"; // {String} name of Orchestra repository

var version = "version_example"; // {String} version of Orchestra repository

var elementId = "elementId_example"; // {String} name or ID as a string of the element to annotate

var elementType = "elementType_example"; // {String} type of element to annotate

var opts = { 
  'parentId': "parentId_example", // {String} name or ID as a string of the parent of the element to annotate. Required for code, actor, stateMachine.
  'annotation': new OrchestraApi.Annotation() // {Annotation} Annotation to add
};

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
};
api.addAnnotation(reposName, version, elementId, elementType, opts, callback);

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*OrchestraApi.DocumentationApi* | [**addAnnotation**](docs/DocumentationApi.md#addAnnotation) | **POST** /repositories/{repos-name}/{version}/annotations | adds an Annotation
*OrchestraApi.DocumentationApi* | [**deleteAnnotation**](docs/DocumentationApi.md#deleteAnnotation) | **DELETE** /repositories/{repos-name}/{version}/annotations | deletes a single Annotation
*OrchestraApi.DocumentationApi* | [**searchAnnotations**](docs/DocumentationApi.md#searchAnnotations) | **GET** /repositories/{repos-name}/{version}/annotations | searches annotations
*OrchestraApi.DocumentationApi* | [**updateAnnotation**](docs/DocumentationApi.md#updateAnnotation) | **PUT** /repositories/{repos-name}/{version}/annotations | Updates a single Annotation, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**addCode**](docs/RepositoryApi.md#addCode) | **POST** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes | adds a Code to CodeSet
*OrchestraApi.RepositoryApi* | [**addCodeSet**](docs/RepositoryApi.md#addCodeSet) | **POST** /repositories/{repos-name}/{version}/codesets | adds a CodeSet
*OrchestraApi.RepositoryApi* | [**addComponent**](docs/RepositoryApi.md#addComponent) | **POST** /repositories/{repos-name}/{version}/components | adds a component
*OrchestraApi.RepositoryApi* | [**addDatatype**](docs/RepositoryApi.md#addDatatype) | **POST** /repositories/{repos-name}/{version}/datatypes | adds a datatype
*OrchestraApi.RepositoryApi* | [**addField**](docs/RepositoryApi.md#addField) | **POST** /repositories/{repos-name}/{version}/fields | adds a field
*OrchestraApi.RepositoryApi* | [**addGroup**](docs/RepositoryApi.md#addGroup) | **POST** /repositories/{repos-name}/{version}/groups | adds a repeating group
*OrchestraApi.RepositoryApi* | [**addMessage**](docs/RepositoryApi.md#addMessage) | **POST** /repositories/{repos-name}/{version}/messages | adds a message scenario
*OrchestraApi.RepositoryApi* | [**addRepository**](docs/RepositoryApi.md#addRepository) | **POST** /repositories | adds an Orchestra repository
*OrchestraApi.RepositoryApi* | [**deleteCode**](docs/RepositoryApi.md#deleteCode) | **DELETE** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | deletes a single Code based on the ID supplied
*OrchestraApi.RepositoryApi* | [**deleteCodeSet**](docs/RepositoryApi.md#deleteCodeSet) | **DELETE** /repositories/{repos-name}/{version}/codesets/{id} | deletes a single CodeSet based on the ID supplied
*OrchestraApi.RepositoryApi* | [**deleteComponent**](docs/RepositoryApi.md#deleteComponent) | **DELETE** /repositories/{repos-name}/{version}/components/{id} | deletes a single component based on the ID supplied
*OrchestraApi.RepositoryApi* | [**deleteDatatype**](docs/RepositoryApi.md#deleteDatatype) | **DELETE** /repositories/{repos-name}/{version}/datatypes/{name} | deletes a single datatype based on the name supplied
*OrchestraApi.RepositoryApi* | [**deleteField**](docs/RepositoryApi.md#deleteField) | **DELETE** /repositories/{repos-name}/{version}/fields/{id} | deletes a single field based on the ID supplied
*OrchestraApi.RepositoryApi* | [**deleteGroup**](docs/RepositoryApi.md#deleteGroup) | **DELETE** /repositories/{repos-name}/{version}/groups/{id} | deletes a single group based on the ID supplied
*OrchestraApi.RepositoryApi* | [**deleteMessage**](docs/RepositoryApi.md#deleteMessage) | **DELETE** /repositories/{repos-name}/{version}/messages/{id} | deletes a single message scenario based on the ID supplied
*OrchestraApi.RepositoryApi* | [**deleteRepository**](docs/RepositoryApi.md#deleteRepository) | **DELETE** /repositories/{repos-name}/{version} | deletes a single Orchestra repository based on the ID supplied
*OrchestraApi.RepositoryApi* | [**downloadRepositoryById**](docs/RepositoryApi.md#downloadRepositoryById) | **GET** /repositories/{repos-name}/{version}/file | Retreives a single Orchestra repository file, if found
*OrchestraApi.RepositoryApi* | [**findCodeById**](docs/RepositoryApi.md#findCodeById) | **GET** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | Returns a single Code, if found
*OrchestraApi.RepositoryApi* | [**findCodeSetById**](docs/RepositoryApi.md#findCodeSetById) | **GET** /repositories/{repos-name}/{version}/codesets/{id} | Returns a single CodeSet, if found
*OrchestraApi.RepositoryApi* | [**findComponentById**](docs/RepositoryApi.md#findComponentById) | **GET** /repositories/{repos-name}/{version}/components/{id} | Returns a single component, if found
*OrchestraApi.RepositoryApi* | [**findDatatypeByName**](docs/RepositoryApi.md#findDatatypeByName) | **GET** /repositories/{repos-name}/{version}/datatypes/{name} | Returns a single datatype, if found
*OrchestraApi.RepositoryApi* | [**findFieldById**](docs/RepositoryApi.md#findFieldById) | **GET** /repositories/{repos-name}/{version}/fields/{id} | Returns a single field, if found
*OrchestraApi.RepositoryApi* | [**findGroupById**](docs/RepositoryApi.md#findGroupById) | **GET** /repositories/{repos-name}/{version}/groups/{id} | Returns a single group, if found
*OrchestraApi.RepositoryApi* | [**findMessageById**](docs/RepositoryApi.md#findMessageById) | **GET** /repositories/{repos-name}/{version}/messages/{id} | Returns a single message scenario, if found
*OrchestraApi.RepositoryApi* | [**findRepositoryById**](docs/RepositoryApi.md#findRepositoryById) | **GET** /repositories/{repos-name}/{version} | Returns a single Orchestra repository metadata, if found
*OrchestraApi.RepositoryApi* | [**searchCodeSets**](docs/RepositoryApi.md#searchCodeSets) | **GET** /repositories/{repos-name}/{version}/codesets | searches CodeSets
*OrchestraApi.RepositoryApi* | [**searchCodes**](docs/RepositoryApi.md#searchCodes) | **GET** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes | searches Codes within a CodeSet
*OrchestraApi.RepositoryApi* | [**searchComponents**](docs/RepositoryApi.md#searchComponents) | **GET** /repositories/{repos-name}/{version}/components | searches components
*OrchestraApi.RepositoryApi* | [**searchDatatypes**](docs/RepositoryApi.md#searchDatatypes) | **GET** /repositories/{repos-name}/{version}/datatypes | searches datatypes
*OrchestraApi.RepositoryApi* | [**searchFields**](docs/RepositoryApi.md#searchFields) | **GET** /repositories/{repos-name}/{version}/fields | searches fields
*OrchestraApi.RepositoryApi* | [**searchGroups**](docs/RepositoryApi.md#searchGroups) | **GET** /repositories/{repos-name}/{version}/groups | searches groups
*OrchestraApi.RepositoryApi* | [**searchMessages**](docs/RepositoryApi.md#searchMessages) | **GET** /repositories/{repos-name}/{version}/messages | searches messages
*OrchestraApi.RepositoryApi* | [**searchRepositories**](docs/RepositoryApi.md#searchRepositories) | **GET** /repositories | searches Orchestra repositories
*OrchestraApi.RepositoryApi* | [**updateCodeById**](docs/RepositoryApi.md#updateCodeById) | **PUT** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | Updates a single Code, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**updateCodeSetById**](docs/RepositoryApi.md#updateCodeSetById) | **PUT** /repositories/{repos-name}/{version}/codesets/{id} | Updates a single CodeSet, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**updateComponentById**](docs/RepositoryApi.md#updateComponentById) | **PUT** /repositories/{repos-name}/{version}/components/{id} | Updates a single component, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**updateDatatypeByName**](docs/RepositoryApi.md#updateDatatypeByName) | **PUT** /repositories/{repos-name}/{version}/datatypes/{name} | Updates a single datatype, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**updateFieldById**](docs/RepositoryApi.md#updateFieldById) | **PUT** /repositories/{repos-name}/{version}/fields/{id} | Updates a single field, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**updateGroupById**](docs/RepositoryApi.md#updateGroupById) | **PUT** /repositories/{repos-name}/{version}/groups/{id} | Updates a single group, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**updateMessageById**](docs/RepositoryApi.md#updateMessageById) | **PUT** /repositories/{repos-name}/{version}/messages/{id} | Updates a single message scenario, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**updateRepositoryById**](docs/RepositoryApi.md#updateRepositoryById) | **PUT** /repositories/{repos-name}/{version} | Updates an Orchestra repository, if found (idempotent)
*OrchestraApi.RepositoryApi* | [**uploadRepositoryById**](docs/RepositoryApi.md#uploadRepositoryById) | **POST** /repositories/{repos-name}/{version}/file | Uploads a file.
*OrchestraApi.RepositoryApi* | [**uploadRepositoryForUpdateById**](docs/RepositoryApi.md#uploadRepositoryForUpdateById) | **PUT** /repositories/{repos-name}/{version}/file | Uploads an updated file.
*OrchestraApi.WorkflowApi* | [**addActor**](docs/WorkflowApi.md#addActor) | **POST** /repositories/{repos-name}/{version}/actors | adds an Actor
*OrchestraApi.WorkflowApi* | [**addFlow**](docs/WorkflowApi.md#addFlow) | **POST** /repositories/{repos-name}/{version}/flows | adds a Flow
*OrchestraApi.WorkflowApi* | [**addMessageResponse**](docs/WorkflowApi.md#addMessageResponse) | **POST** /repositories/{repos-name}/{version}/messages/{id}/responses | adds a response to a message scenario
*OrchestraApi.WorkflowApi* | [**addStateMachine**](docs/WorkflowApi.md#addStateMachine) | **POST** /repositories/{repos-name}/{version}/actors/{name}/statemachines | adds a state machine
*OrchestraApi.WorkflowApi* | [**deleteActor**](docs/WorkflowApi.md#deleteActor) | **DELETE** /repositories/{repos-name}/{version}/actors/{name} | deletes a single Actor based on the name supplied
*OrchestraApi.WorkflowApi* | [**deleteFlow**](docs/WorkflowApi.md#deleteFlow) | **DELETE** /repositories/{repos-name}/{version}/flows/{name} | deletes a single Flow based on the name supplied
*OrchestraApi.WorkflowApi* | [**deleteMessageResponse**](docs/WorkflowApi.md#deleteMessageResponse) | **DELETE** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | deletes a single response to a message scenario based on the ID supplied
*OrchestraApi.WorkflowApi* | [**deleteStateMachine**](docs/WorkflowApi.md#deleteStateMachine) | **DELETE** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | deletes a single StateMachine based on the name supplied
*OrchestraApi.WorkflowApi* | [**findActorByName**](docs/WorkflowApi.md#findActorByName) | **GET** /repositories/{repos-name}/{version}/actors/{name} | Returns a single Actor, if found
*OrchestraApi.WorkflowApi* | [**findFlowByName**](docs/WorkflowApi.md#findFlowByName) | **GET** /repositories/{repos-name}/{version}/flows/{name} | Returns a single Flow, if found
*OrchestraApi.WorkflowApi* | [**findMessageResponseById**](docs/WorkflowApi.md#findMessageResponseById) | **GET** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | Returns a single response to a message scenario, if found
*OrchestraApi.WorkflowApi* | [**findStateMachine**](docs/WorkflowApi.md#findStateMachine) | **GET** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | Returns a single StateMachine, if found
*OrchestraApi.WorkflowApi* | [**searchActors**](docs/WorkflowApi.md#searchActors) | **GET** /repositories/{repos-name}/{version}/actors | searches actors
*OrchestraApi.WorkflowApi* | [**searchFlows**](docs/WorkflowApi.md#searchFlows) | **GET** /repositories/{repos-name}/{version}/flows | searches flows
*OrchestraApi.WorkflowApi* | [**searchMessageResponses**](docs/WorkflowApi.md#searchMessageResponses) | **GET** /repositories/{repos-name}/{version}/messages/{id}/responses | searches message responses
*OrchestraApi.WorkflowApi* | [**searchStateMachines**](docs/WorkflowApi.md#searchStateMachines) | **GET** /repositories/{repos-name}/{version}/actors/{name}/statemachines | searches state machines
*OrchestraApi.WorkflowApi* | [**updateActorByName**](docs/WorkflowApi.md#updateActorByName) | **PUT** /repositories/{repos-name}/{version}/actors/{name} | Updates a single Actor, if found (idempotent)
*OrchestraApi.WorkflowApi* | [**updateFlowByName**](docs/WorkflowApi.md#updateFlowByName) | **PUT** /repositories/{repos-name}/{version}/flows/{name} | Updates a single Flow, if found (idempotent)
*OrchestraApi.WorkflowApi* | [**updateMessageResponse**](docs/WorkflowApi.md#updateMessageResponse) | **PUT** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | Updates a single response to a message scenario, if found (idempotent)
*OrchestraApi.WorkflowApi* | [**updateStateMachine**](docs/WorkflowApi.md#updateStateMachine) | **PUT** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | Updates a single StateMachine, if found (idempotent)


## Documentation for Models

 - [OrchestraApi.Actor](docs/Actor.md)
 - [OrchestraApi.Annotation](docs/Annotation.md)
 - [OrchestraApi.Appinfo](docs/Appinfo.md)
 - [OrchestraApi.Code](docs/Code.md)
 - [OrchestraApi.CodeSet](docs/CodeSet.md)
 - [OrchestraApi.Component](docs/Component.md)
 - [OrchestraApi.ComponentRef](docs/ComponentRef.md)
 - [OrchestraApi.Datatype](docs/Datatype.md)
 - [OrchestraApi.Documentation](docs/Documentation.md)
 - [OrchestraApi.ElementRef](docs/ElementRef.md)
 - [OrchestraApi.EntityAttributes](docs/EntityAttributes.md)
 - [OrchestraApi.ErrorModel](docs/ErrorModel.md)
 - [OrchestraApi.Field](docs/Field.md)
 - [OrchestraApi.FieldRef](docs/FieldRef.md)
 - [OrchestraApi.Flow](docs/Flow.md)
 - [OrchestraApi.Group](docs/Group.md)
 - [OrchestraApi.GroupProperties](docs/GroupProperties.md)
 - [OrchestraApi.GroupRef](docs/GroupRef.md)
 - [OrchestraApi.Message](docs/Message.md)
 - [OrchestraApi.MessageElement](docs/MessageElement.md)
 - [OrchestraApi.MessageRef](docs/MessageRef.md)
 - [OrchestraApi.Metadata](docs/Metadata.md)
 - [OrchestraApi.ObjectId](docs/ObjectId.md)
 - [OrchestraApi.Repository](docs/Repository.md)
 - [OrchestraApi.Response](docs/Response.md)
 - [OrchestraApi.State](docs/State.md)
 - [OrchestraApi.StateMachine](docs/StateMachine.md)
 - [OrchestraApi.Structure](docs/Structure.md)
 - [OrchestraApi.Transition](docs/Transition.md)
 - [OrchestraApi.Trigger](docs/Trigger.md)


## Documentation for Authorization

 All endpoints do not require authorization.

