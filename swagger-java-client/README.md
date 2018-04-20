# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.fixprotocol.orchestra.api</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0-RC3-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.fixprotocol.orchestra.api:swagger-java-client:1.0.0-RC3-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0-RC3-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.fixprotocol.orchestra.*;
import io.fixprotocol.orchestra.auth.*;
import io.fixprotocol.orchestra.client.model.*;
import io.fixprotocol.orchestra.client.DocumentationApi;

import java.io.File;
import java.util.*;

public class DocumentationApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DocumentationApi* | [**addAnnotation**](docs/DocumentationApi.md#addAnnotation) | **POST** /repositories/{repos-name}/{version}/annotations | adds an Annotation
*DocumentationApi* | [**deleteAnnotation**](docs/DocumentationApi.md#deleteAnnotation) | **DELETE** /repositories/{repos-name}/{version}/annotations | deletes a single Annotation
*DocumentationApi* | [**searchAnnotations**](docs/DocumentationApi.md#searchAnnotations) | **GET** /repositories/{repos-name}/{version}/annotations | searches annotations
*DocumentationApi* | [**updateAnnotation**](docs/DocumentationApi.md#updateAnnotation) | **PUT** /repositories/{repos-name}/{version}/annotations | Updates a single Annotation, if found (idempotent)
*RepositoryApi* | [**addCode**](docs/RepositoryApi.md#addCode) | **POST** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes | adds a Code to CodeSet
*RepositoryApi* | [**addCodeSet**](docs/RepositoryApi.md#addCodeSet) | **POST** /repositories/{repos-name}/{version}/codesets | adds a CodeSet
*RepositoryApi* | [**addComponent**](docs/RepositoryApi.md#addComponent) | **POST** /repositories/{repos-name}/{version}/components | adds a component
*RepositoryApi* | [**addDatatype**](docs/RepositoryApi.md#addDatatype) | **POST** /repositories/{repos-name}/{version}/datatypes | adds a datatype
*RepositoryApi* | [**addField**](docs/RepositoryApi.md#addField) | **POST** /repositories/{repos-name}/{version}/fields | adds a field
*RepositoryApi* | [**addGroup**](docs/RepositoryApi.md#addGroup) | **POST** /repositories/{repos-name}/{version}/groups | adds a repeating group
*RepositoryApi* | [**addMessage**](docs/RepositoryApi.md#addMessage) | **POST** /repositories/{repos-name}/{version}/messages | adds a message scenario
*RepositoryApi* | [**addRepository**](docs/RepositoryApi.md#addRepository) | **POST** /repositories | adds an Orchestra repository
*RepositoryApi* | [**deleteCode**](docs/RepositoryApi.md#deleteCode) | **DELETE** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | deletes a single Code based on the ID supplied
*RepositoryApi* | [**deleteCodeSet**](docs/RepositoryApi.md#deleteCodeSet) | **DELETE** /repositories/{repos-name}/{version}/codesets/{id} | deletes a single CodeSet based on the ID supplied
*RepositoryApi* | [**deleteComponent**](docs/RepositoryApi.md#deleteComponent) | **DELETE** /repositories/{repos-name}/{version}/components/{id} | deletes a single component based on the ID supplied
*RepositoryApi* | [**deleteDatatype**](docs/RepositoryApi.md#deleteDatatype) | **DELETE** /repositories/{repos-name}/{version}/datatypes/{name} | deletes a single datatype based on the name supplied
*RepositoryApi* | [**deleteField**](docs/RepositoryApi.md#deleteField) | **DELETE** /repositories/{repos-name}/{version}/fields/{id} | deletes a single field based on the ID supplied
*RepositoryApi* | [**deleteGroup**](docs/RepositoryApi.md#deleteGroup) | **DELETE** /repositories/{repos-name}/{version}/groups/{id} | deletes a single group based on the ID supplied
*RepositoryApi* | [**deleteMessage**](docs/RepositoryApi.md#deleteMessage) | **DELETE** /repositories/{repos-name}/{version}/messages/{id} | deletes a single message scenario based on the ID supplied
*RepositoryApi* | [**deleteRepository**](docs/RepositoryApi.md#deleteRepository) | **DELETE** /repositories/{repos-name}/{version} | deletes a single Orchestra repository based on the ID supplied
*RepositoryApi* | [**downloadRepositoryById**](docs/RepositoryApi.md#downloadRepositoryById) | **GET** /repositories/{repos-name}/{version}/file | Retreives a single Orchestra repository file, if found
*RepositoryApi* | [**findCodeById**](docs/RepositoryApi.md#findCodeById) | **GET** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | Returns a single Code, if found
*RepositoryApi* | [**findCodeSetById**](docs/RepositoryApi.md#findCodeSetById) | **GET** /repositories/{repos-name}/{version}/codesets/{id} | Returns a single CodeSet, if found
*RepositoryApi* | [**findComponentById**](docs/RepositoryApi.md#findComponentById) | **GET** /repositories/{repos-name}/{version}/components/{id} | Returns a single component, if found
*RepositoryApi* | [**findDatatypeByName**](docs/RepositoryApi.md#findDatatypeByName) | **GET** /repositories/{repos-name}/{version}/datatypes/{name} | Returns a single datatype, if found
*RepositoryApi* | [**findFieldById**](docs/RepositoryApi.md#findFieldById) | **GET** /repositories/{repos-name}/{version}/fields/{id} | Returns a single field, if found
*RepositoryApi* | [**findGroupById**](docs/RepositoryApi.md#findGroupById) | **GET** /repositories/{repos-name}/{version}/groups/{id} | Returns a single group, if found
*RepositoryApi* | [**findMessageById**](docs/RepositoryApi.md#findMessageById) | **GET** /repositories/{repos-name}/{version}/messages/{id} | Returns a single message scenario, if found
*RepositoryApi* | [**findRepositoryById**](docs/RepositoryApi.md#findRepositoryById) | **GET** /repositories/{repos-name}/{version} | Returns a single Orchestra repository metadata, if found
*RepositoryApi* | [**searchCodeSets**](docs/RepositoryApi.md#searchCodeSets) | **GET** /repositories/{repos-name}/{version}/codesets | searches CodeSets
*RepositoryApi* | [**searchCodes**](docs/RepositoryApi.md#searchCodes) | **GET** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes | searches Codes within a CodeSet
*RepositoryApi* | [**searchComponents**](docs/RepositoryApi.md#searchComponents) | **GET** /repositories/{repos-name}/{version}/components | searches components
*RepositoryApi* | [**searchDatatypes**](docs/RepositoryApi.md#searchDatatypes) | **GET** /repositories/{repos-name}/{version}/datatypes | searches datatypes
*RepositoryApi* | [**searchFields**](docs/RepositoryApi.md#searchFields) | **GET** /repositories/{repos-name}/{version}/fields | searches fields
*RepositoryApi* | [**searchGroups**](docs/RepositoryApi.md#searchGroups) | **GET** /repositories/{repos-name}/{version}/groups | searches groups
*RepositoryApi* | [**searchMessages**](docs/RepositoryApi.md#searchMessages) | **GET** /repositories/{repos-name}/{version}/messages | searches messages
*RepositoryApi* | [**searchRepositories**](docs/RepositoryApi.md#searchRepositories) | **GET** /repositories | searches Orchestra repositories
*RepositoryApi* | [**updateCodeById**](docs/RepositoryApi.md#updateCodeById) | **PUT** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | Updates a single Code, if found (idempotent)
*RepositoryApi* | [**updateCodeSetById**](docs/RepositoryApi.md#updateCodeSetById) | **PUT** /repositories/{repos-name}/{version}/codesets/{id} | Updates a single CodeSet, if found (idempotent)
*RepositoryApi* | [**updateComponentById**](docs/RepositoryApi.md#updateComponentById) | **PUT** /repositories/{repos-name}/{version}/components/{id} | Updates a single component, if found (idempotent)
*RepositoryApi* | [**updateDatatypeByName**](docs/RepositoryApi.md#updateDatatypeByName) | **PUT** /repositories/{repos-name}/{version}/datatypes/{name} | Updates a single datatype, if found (idempotent)
*RepositoryApi* | [**updateFieldById**](docs/RepositoryApi.md#updateFieldById) | **PUT** /repositories/{repos-name}/{version}/fields/{id} | Updates a single field, if found (idempotent)
*RepositoryApi* | [**updateGroupById**](docs/RepositoryApi.md#updateGroupById) | **PUT** /repositories/{repos-name}/{version}/groups/{id} | Updates a single group, if found (idempotent)
*RepositoryApi* | [**updateMessageById**](docs/RepositoryApi.md#updateMessageById) | **PUT** /repositories/{repos-name}/{version}/messages/{id} | Updates a single message scenario, if found (idempotent)
*RepositoryApi* | [**updateRepositoryById**](docs/RepositoryApi.md#updateRepositoryById) | **PUT** /repositories/{repos-name}/{version} | Updates an Orchestra repository, if found (idempotent)
*RepositoryApi* | [**uploadRepositoryById**](docs/RepositoryApi.md#uploadRepositoryById) | **POST** /repositories/{repos-name}/{version}/file | Uploads a file.
*RepositoryApi* | [**uploadRepositoryForUpdateById**](docs/RepositoryApi.md#uploadRepositoryForUpdateById) | **PUT** /repositories/{repos-name}/{version}/file | Uploads an updated file.
*WorkflowApi* | [**addActor**](docs/WorkflowApi.md#addActor) | **POST** /repositories/{repos-name}/{version}/actors | adds an Actor
*WorkflowApi* | [**addFlow**](docs/WorkflowApi.md#addFlow) | **POST** /repositories/{repos-name}/{version}/flows | adds a Flow
*WorkflowApi* | [**addMessageResponse**](docs/WorkflowApi.md#addMessageResponse) | **POST** /repositories/{repos-name}/{version}/messages/{id}/responses | adds a response to a message scenario
*WorkflowApi* | [**addStateMachine**](docs/WorkflowApi.md#addStateMachine) | **POST** /repositories/{repos-name}/{version}/actors/{name}/statemachines | adds a state machine
*WorkflowApi* | [**deleteActor**](docs/WorkflowApi.md#deleteActor) | **DELETE** /repositories/{repos-name}/{version}/actors/{name} | deletes a single Actor based on the name supplied
*WorkflowApi* | [**deleteFlow**](docs/WorkflowApi.md#deleteFlow) | **DELETE** /repositories/{repos-name}/{version}/flows/{name} | deletes a single Flow based on the name supplied
*WorkflowApi* | [**deleteMessageResponse**](docs/WorkflowApi.md#deleteMessageResponse) | **DELETE** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | deletes a single response to a message scenario based on the ID supplied
*WorkflowApi* | [**deleteStateMachine**](docs/WorkflowApi.md#deleteStateMachine) | **DELETE** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | deletes a single StateMachine based on the name supplied
*WorkflowApi* | [**findActorByName**](docs/WorkflowApi.md#findActorByName) | **GET** /repositories/{repos-name}/{version}/actors/{name} | Returns a single Actor, if found
*WorkflowApi* | [**findFlowByName**](docs/WorkflowApi.md#findFlowByName) | **GET** /repositories/{repos-name}/{version}/flows/{name} | Returns a single Flow, if found
*WorkflowApi* | [**findMessageResponseById**](docs/WorkflowApi.md#findMessageResponseById) | **GET** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | Returns a single response to a message scenario, if found
*WorkflowApi* | [**findStateMachine**](docs/WorkflowApi.md#findStateMachine) | **GET** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | Returns a single StateMachine, if found
*WorkflowApi* | [**searchActors**](docs/WorkflowApi.md#searchActors) | **GET** /repositories/{repos-name}/{version}/actors | searches actors
*WorkflowApi* | [**searchFlows**](docs/WorkflowApi.md#searchFlows) | **GET** /repositories/{repos-name}/{version}/flows | searches flows
*WorkflowApi* | [**searchMessageResponses**](docs/WorkflowApi.md#searchMessageResponses) | **GET** /repositories/{repos-name}/{version}/messages/{id}/responses | searches message responses
*WorkflowApi* | [**searchStateMachines**](docs/WorkflowApi.md#searchStateMachines) | **GET** /repositories/{repos-name}/{version}/actors/{name}/statemachines | searches state machines
*WorkflowApi* | [**updateActorByName**](docs/WorkflowApi.md#updateActorByName) | **PUT** /repositories/{repos-name}/{version}/actors/{name} | Updates a single Actor, if found (idempotent)
*WorkflowApi* | [**updateFlowByName**](docs/WorkflowApi.md#updateFlowByName) | **PUT** /repositories/{repos-name}/{version}/flows/{name} | Updates a single Flow, if found (idempotent)
*WorkflowApi* | [**updateMessageResponse**](docs/WorkflowApi.md#updateMessageResponse) | **PUT** /repositories/{repos-name}/{version}/messages/{id}/responses/{name} | Updates a single response to a message scenario, if found (idempotent)
*WorkflowApi* | [**updateStateMachine**](docs/WorkflowApi.md#updateStateMachine) | **PUT** /repositories/{repos-name}/{version}/actors/{name}/statemachines/{sm-name} | Updates a single StateMachine, if found (idempotent)


## Documentation for Models

 - [Actor](docs/Actor.md)
 - [Annotation](docs/Annotation.md)
 - [Appinfo](docs/Appinfo.md)
 - [Code](docs/Code.md)
 - [CodeSet](docs/CodeSet.md)
 - [Component](docs/Component.md)
 - [ComponentRef](docs/ComponentRef.md)
 - [Datatype](docs/Datatype.md)
 - [Documentation](docs/Documentation.md)
 - [ElementRef](docs/ElementRef.md)
 - [EntityAttributes](docs/EntityAttributes.md)
 - [ErrorModel](docs/ErrorModel.md)
 - [Field](docs/Field.md)
 - [FieldRef](docs/FieldRef.md)
 - [Flow](docs/Flow.md)
 - [Group](docs/Group.md)
 - [GroupProperties](docs/GroupProperties.md)
 - [GroupRef](docs/GroupRef.md)
 - [Message](docs/Message.md)
 - [MessageElement](docs/MessageElement.md)
 - [MessageRef](docs/MessageRef.md)
 - [Metadata](docs/Metadata.md)
 - [ObjectId](docs/ObjectId.md)
 - [Repository](docs/Repository.md)
 - [Response](docs/Response.md)
 - [State](docs/State.md)
 - [StateMachine](docs/StateMachine.md)
 - [Structure](docs/Structure.md)
 - [Transition](docs/Transition.md)
 - [Trigger](docs/Trigger.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



