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
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.FileApi;

import java.io.File;
import java.util.*;

public class FileApiExample {

    public static void main(String[] args) {
        
        FileApi apiInstance = new FileApi();
        Orchestra orchestra = new Orchestra(); // Orchestra | Orchestra file to add
        try {
            apiInstance.addOrchestra(orchestra);
        } catch (ApiException e) {
            System.err.println("Exception when calling FileApi#addOrchestra");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*FileApi* | [**addOrchestra**](docs/FileApi.md#addOrchestra) | **POST** /orchestra | adds an Orchestra file
*FileApi* | [**findOrchestraById**](docs/FileApi.md#findOrchestraById) | **GET** /orchestra/{fileid} | Returns a single Orchestra file metadata, if found
*FileApi* | [**searchOrchestra**](docs/FileApi.md#searchOrchestra) | **GET** /orchestra | searches Orchestra files
*MessagesApi* | [**addComponent**](docs/MessagesApi.md#addComponent) | **POST** /orchestra/{fileid}/components | adds a component
*MessagesApi* | [**addField**](docs/MessagesApi.md#addField) | **POST** /orchestra/{fileid}/fields | adds a field
*MessagesApi* | [**addMessage**](docs/MessagesApi.md#addMessage) | **POST** /orchestra/{fileid}/messages | adds a message scenario
*MessagesApi* | [**deleteComponent**](docs/MessagesApi.md#deleteComponent) | **DELETE** /orchestra/{fileid}/components/{id} | deletes a single component based on the ID supplied
*MessagesApi* | [**deleteField**](docs/MessagesApi.md#deleteField) | **DELETE** /orchestra/{fileid}/fields/{id} | deletes a single field based on the ID supplied
*MessagesApi* | [**deleteMessage**](docs/MessagesApi.md#deleteMessage) | **DELETE** /orchesra/{fileid}/messages/{id} | deletes a single message based on the ID supplied
*MessagesApi* | [**deleteOrchestra**](docs/MessagesApi.md#deleteOrchestra) | **DELETE** /orchestra/{fileid} | deletes a single Orchestra file based on the ID supplied
*MessagesApi* | [**findComponentById**](docs/MessagesApi.md#findComponentById) | **GET** /orchestra/{fileid}/components/{id} | Returns a single component, if found
*MessagesApi* | [**findFieldById**](docs/MessagesApi.md#findFieldById) | **GET** /orchestra/{fileid}/fields/{id} | Returns a single field, if found
*MessagesApi* | [**findMessageById**](docs/MessagesApi.md#findMessageById) | **GET** /orchesra/{fileid}/messages/{id} | Returns a single message, if found
*MessagesApi* | [**searchComponents**](docs/MessagesApi.md#searchComponents) | **GET** /orchestra/{fileid}/components | searches components
*MessagesApi* | [**searchFields**](docs/MessagesApi.md#searchFields) | **GET** /orchestra/{fileid}/fields | searches fields
*MessagesApi* | [**searchMessages**](docs/MessagesApi.md#searchMessages) | **GET** /orchestra/{fileid}/messages | searches messages
*MessagesApi* | [**updateComponentById**](docs/MessagesApi.md#updateComponentById) | **PUT** /orchestra/{fileid}/components/{id} | Updates a single component, if found (idempotent)
*MessagesApi* | [**updateFieldById**](docs/MessagesApi.md#updateFieldById) | **PUT** /orchestra/{fileid}/fields/{id} | Updates a single field, if found (idempotent)
*MessagesApi* | [**updateMessageById**](docs/MessagesApi.md#updateMessageById) | **PUT** /orchesra/{fileid}/messages/{id} | Updates a single message, if found (idempotent)
*MessagesApi* | [**updateOrchestraById**](docs/MessagesApi.md#updateOrchestraById) | **PUT** /orchestra/{fileid} | Updates a Orchestra file, if found (idempotent)


## Documentation for Models

 - [Annotation](docs/Annotation.md)
 - [Appinfo](docs/Appinfo.md)
 - [Component](docs/Component.md)
 - [ComponentRef](docs/ComponentRef.md)
 - [Documentation](docs/Documentation.md)
 - [ElementRef](docs/ElementRef.md)
 - [EntityAttributes](docs/EntityAttributes.md)
 - [ErrorModel](docs/ErrorModel.md)
 - [Field](docs/Field.md)
 - [FieldRef](docs/FieldRef.md)
 - [Group](docs/Group.md)
 - [GroupRef](docs/GroupRef.md)
 - [Message](docs/Message.md)
 - [MessageElement](docs/MessageElement.md)
 - [MessageElements](docs/MessageElements.md)
 - [ObjectId](docs/ObjectId.md)
 - [Orchestra](docs/Orchestra.md)
 - [Response](docs/Response.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

donmendelson@silverflash.net

