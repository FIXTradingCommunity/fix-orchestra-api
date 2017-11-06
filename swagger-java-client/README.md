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
import io.swagger.client.api.RepositoryApi;

import java.io.File;
import java.util.*;

public class RepositoryApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*RepositoryApi* | [**addCode**](docs/RepositoryApi.md#addCode) | **POST** /repositories/{fileid}/codesets/{codesetid}/codes | adds a Code to CodeSet
*RepositoryApi* | [**addCodeSet**](docs/RepositoryApi.md#addCodeSet) | **POST** /repositories/{fileid}/codesets | adds a CodeSet
*RepositoryApi* | [**addComponent**](docs/RepositoryApi.md#addComponent) | **POST** /repositories/{fileid}/components | adds a component
*RepositoryApi* | [**addDatatype**](docs/RepositoryApi.md#addDatatype) | **POST** /repositories/{fileid}/datatypes | adds a datatype
*RepositoryApi* | [**addField**](docs/RepositoryApi.md#addField) | **POST** /repositories/{fileid}/fields | adds a field
*RepositoryApi* | [**addMessage**](docs/RepositoryApi.md#addMessage) | **POST** /repositories/{fileid}/messages | adds a message scenario
*RepositoryApi* | [**addRepository**](docs/RepositoryApi.md#addRepository) | **POST** /repositories | adds an Orchestra repository file
*RepositoryApi* | [**deleteCode**](docs/RepositoryApi.md#deleteCode) | **DELETE** /repositories/{fileid}/codesets/{codesetid}/codes/{id} | deletes a single Code based on the ID supplied
*RepositoryApi* | [**deleteCodeSet**](docs/RepositoryApi.md#deleteCodeSet) | **DELETE** /repositories/{fileid}/codesets/{id} | deletes a single CodeSet based on the ID supplied
*RepositoryApi* | [**deleteComponent**](docs/RepositoryApi.md#deleteComponent) | **DELETE** /repositories/{fileid}/components/{id} | deletes a single component based on the ID supplied
*RepositoryApi* | [**deleteDatatype**](docs/RepositoryApi.md#deleteDatatype) | **DELETE** /repositories/{fileid}/datatypes/{name} | deletes a single datatype based on the name supplied
*RepositoryApi* | [**deleteField**](docs/RepositoryApi.md#deleteField) | **DELETE** /repositories/{fileid}/fields/{id} | deletes a single field based on the ID supplied
*RepositoryApi* | [**deleteMessage**](docs/RepositoryApi.md#deleteMessage) | **DELETE** /repositories/{fileid}/messages/{id} | deletes a single message scenario based on the ID supplied
*RepositoryApi* | [**deleteRepository**](docs/RepositoryApi.md#deleteRepository) | **DELETE** /repositories/{fileid} | deletes a single Orchestra repository file based on the ID supplied
*RepositoryApi* | [**findCodeById**](docs/RepositoryApi.md#findCodeById) | **GET** /repositories/{fileid}/codesets/{codesetid}/codes/{id} | Returns a single Code, if found
*RepositoryApi* | [**findCodeSetById**](docs/RepositoryApi.md#findCodeSetById) | **GET** /repositories/{fileid}/codesets/{id} | Returns a single CodeSet, if found
*RepositoryApi* | [**findComponentById**](docs/RepositoryApi.md#findComponentById) | **GET** /repositories/{fileid}/components/{id} | Returns a single component, if found
*RepositoryApi* | [**findDatatypeByName**](docs/RepositoryApi.md#findDatatypeByName) | **GET** /repositories/{fileid}/datatypes/{name} | Returns a single datatype, if found
*RepositoryApi* | [**findFieldById**](docs/RepositoryApi.md#findFieldById) | **GET** /repositories/{fileid}/fields/{id} | Returns a single field, if found
*RepositoryApi* | [**findMessageById**](docs/RepositoryApi.md#findMessageById) | **GET** /repositories/{fileid}/messages/{id} | Returns a single message scenario, if found
*RepositoryApi* | [**findRepositoryById**](docs/RepositoryApi.md#findRepositoryById) | **GET** /repositories/{fileid} | Returns a single Orchestra repository file metadata, if found
*RepositoryApi* | [**searchCodeSets**](docs/RepositoryApi.md#searchCodeSets) | **GET** /repositories/{fileid}/codesets | searches CodeSets
*RepositoryApi* | [**searchCodes**](docs/RepositoryApi.md#searchCodes) | **GET** /repositories/{fileid}/codesets/{codesetid}/codes | searches Codes within a CodeSet
*RepositoryApi* | [**searchComponents**](docs/RepositoryApi.md#searchComponents) | **GET** /repositories/{fileid}/components | searches components
*RepositoryApi* | [**searchDatatypes**](docs/RepositoryApi.md#searchDatatypes) | **GET** /repositories/{fileid}/datatypes | searches datatypes
*RepositoryApi* | [**searchFields**](docs/RepositoryApi.md#searchFields) | **GET** /repositories/{fileid}/fields | searches fields
*RepositoryApi* | [**searchMessages**](docs/RepositoryApi.md#searchMessages) | **GET** /repositories/{fileid}/messages | searches messages
*RepositoryApi* | [**searchRepositories**](docs/RepositoryApi.md#searchRepositories) | **GET** /repositories | searches Orchestra repository files
*RepositoryApi* | [**updateCodeById**](docs/RepositoryApi.md#updateCodeById) | **PUT** /repositories/{fileid}/codesets/{codesetid}/codes/{id} | Updates a single Code, if found (idempotent)
*RepositoryApi* | [**updateCodeSetById**](docs/RepositoryApi.md#updateCodeSetById) | **PUT** /repositories/{fileid}/codesets/{id} | Updates a single CodeSet, if found (idempotent)
*RepositoryApi* | [**updateComponentById**](docs/RepositoryApi.md#updateComponentById) | **PUT** /repositories/{fileid}/components/{id} | Updates a single component, if found (idempotent)
*RepositoryApi* | [**updateDatatypeByName**](docs/RepositoryApi.md#updateDatatypeByName) | **PUT** /repositories/{fileid}/datatypes/{name} | Updates a single datatype, if found (idempotent)
*RepositoryApi* | [**updateFieldById**](docs/RepositoryApi.md#updateFieldById) | **PUT** /repositories/{fileid}/fields/{id} | Updates a single field, if found (idempotent)
*RepositoryApi* | [**updateMessageById**](docs/RepositoryApi.md#updateMessageById) | **PUT** /repositories/{fileid}/messages/{id} | Updates a single message scenario, if found (idempotent)
*RepositoryApi* | [**updateRepositoryById**](docs/RepositoryApi.md#updateRepositoryById) | **PUT** /repositories/{fileid} | Updates an Orchestra repository file, if found (idempotent)


## Documentation for Models

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
 - [Group](docs/Group.md)
 - [GroupRef](docs/GroupRef.md)
 - [Message](docs/Message.md)
 - [MessageElement](docs/MessageElement.md)
 - [MessageElements](docs/MessageElements.md)
 - [Metadata](docs/Metadata.md)
 - [ObjectId](docs/ObjectId.md)
 - [Response](docs/Response.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



