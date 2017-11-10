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

import io.fixprotocol.orchestra.client.*;
import io.fixprotocol.orchestra.client.auth.*;
import io.fixprotocol.orchestra.client.model.*;
import io.fixprotocol.orchestra.client.api.RepositoryApi;

import java.io.File;
import java.util.*;

public class RepositoryApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/FIXTradingCommunity/orchestra-api/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*RepositoryApi* | [**addCode**](docs/RepositoryApi.md#addCode) | **POST** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes | adds a Code to CodeSet
*RepositoryApi* | [**addCodeSet**](docs/RepositoryApi.md#addCodeSet) | **POST** /repositories/{repos-name}/{version}/codesets | adds a CodeSet
*RepositoryApi* | [**addComponent**](docs/RepositoryApi.md#addComponent) | **POST** /repositories/{repos-name}/{version}/components | adds a component
*RepositoryApi* | [**addDatatype**](docs/RepositoryApi.md#addDatatype) | **POST** /repositories/{repos-name}/{version}/datatypes | adds a datatype
*RepositoryApi* | [**addField**](docs/RepositoryApi.md#addField) | **POST** /repositories/{repos-name}/{version}/fields | adds a field
*RepositoryApi* | [**addMessage**](docs/RepositoryApi.md#addMessage) | **POST** /repositories/{repos-name}/{version}/messages | adds a message scenario
*RepositoryApi* | [**addRepository**](docs/RepositoryApi.md#addRepository) | **POST** /repositories | adds an Orchestra repository
*RepositoryApi* | [**deleteCode**](docs/RepositoryApi.md#deleteCode) | **DELETE** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | deletes a single Code based on the ID supplied
*RepositoryApi* | [**deleteCodeSet**](docs/RepositoryApi.md#deleteCodeSet) | **DELETE** /repositories/{repos-name}/{version}/codesets/{id} | deletes a single CodeSet based on the ID supplied
*RepositoryApi* | [**deleteComponent**](docs/RepositoryApi.md#deleteComponent) | **DELETE** /repositories/{repos-name}/{version}/components/{id} | deletes a single component based on the ID supplied
*RepositoryApi* | [**deleteDatatype**](docs/RepositoryApi.md#deleteDatatype) | **DELETE** /repositories/{repos-name}/{version}/datatypes/{name} | deletes a single datatype based on the name supplied
*RepositoryApi* | [**deleteField**](docs/RepositoryApi.md#deleteField) | **DELETE** /repositories/{repos-name}/{version}/fields/{id} | deletes a single field based on the ID supplied
*RepositoryApi* | [**deleteMessage**](docs/RepositoryApi.md#deleteMessage) | **DELETE** /repositories/{repos-name}/{version}/messages/{id} | deletes a single message scenario based on the ID supplied
*RepositoryApi* | [**deleteRepository**](docs/RepositoryApi.md#deleteRepository) | **DELETE** /repositories/{repos-name}/{version} | deletes a single Orchestra repository  based on the ID supplied
*RepositoryApi* | [**findCodeById**](docs/RepositoryApi.md#findCodeById) | **GET** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | Returns a single Code, if found
*RepositoryApi* | [**findCodeSetById**](docs/RepositoryApi.md#findCodeSetById) | **GET** /repositories/{repos-name}/{version}/codesets/{id} | Returns a single CodeSet, if found
*RepositoryApi* | [**findComponentById**](docs/RepositoryApi.md#findComponentById) | **GET** /repositories/{repos-name}/{version}/components/{id} | Returns a single component, if found
*RepositoryApi* | [**findDatatypeByName**](docs/RepositoryApi.md#findDatatypeByName) | **GET** /repositories/{repos-name}/{version}/datatypes/{name} | Returns a single datatype, if found
*RepositoryApi* | [**findFieldById**](docs/RepositoryApi.md#findFieldById) | **GET** /repositories/{repos-name}/{version}/fields/{id} | Returns a single field, if found
*RepositoryApi* | [**findMessageById**](docs/RepositoryApi.md#findMessageById) | **GET** /repositories/{repos-name}/{version}/messages/{id} | Returns a single message scenario, if found
*RepositoryApi* | [**findRepositoryById**](docs/RepositoryApi.md#findRepositoryById) | **GET** /repositories/{repos-name}/{version} | Returns a single Orchestra repository metadata, if found
*RepositoryApi* | [**searchCodeSets**](docs/RepositoryApi.md#searchCodeSets) | **GET** /repositories/{repos-name}/{version}/codesets | searches CodeSets
*RepositoryApi* | [**searchCodes**](docs/RepositoryApi.md#searchCodes) | **GET** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes | searches Codes within a CodeSet
*RepositoryApi* | [**searchComponents**](docs/RepositoryApi.md#searchComponents) | **GET** /repositories/{repos-name}/{version}/components | searches components
*RepositoryApi* | [**searchDatatypes**](docs/RepositoryApi.md#searchDatatypes) | **GET** /repositories/{repos-name}/{version}/datatypes | searches datatypes
*RepositoryApi* | [**searchFields**](docs/RepositoryApi.md#searchFields) | **GET** /repositories/{repos-name}/{version}/fields | searches fields
*RepositoryApi* | [**searchMessages**](docs/RepositoryApi.md#searchMessages) | **GET** /repositories/{repos-name}/{version}/messages | searches messages
*RepositoryApi* | [**searchRepositories**](docs/RepositoryApi.md#searchRepositories) | **GET** /repositories | searches Orchestra repositories
*RepositoryApi* | [**updateCodeById**](docs/RepositoryApi.md#updateCodeById) | **PUT** /repositories/{repos-name}/{version}/codesets/{codesetid}/codes/{id} | Updates a single Code, if found (idempotent)
*RepositoryApi* | [**updateCodeSetById**](docs/RepositoryApi.md#updateCodeSetById) | **PUT** /repositories/{repos-name}/{version}/codesets/{id} | Updates a single CodeSet, if found (idempotent)
*RepositoryApi* | [**updateComponentById**](docs/RepositoryApi.md#updateComponentById) | **PUT** /repositories/{repos-name}/{version}/components/{id} | Updates a single component, if found (idempotent)
*RepositoryApi* | [**updateDatatypeByName**](docs/RepositoryApi.md#updateDatatypeByName) | **PUT** /repositories/{repos-name}/{version}/datatypes/{name} | Updates a single datatype, if found (idempotent)
*RepositoryApi* | [**updateFieldById**](docs/RepositoryApi.md#updateFieldById) | **PUT** /repositories/{repos-name}/{version}/fields/{id} | Updates a single field, if found (idempotent)
*RepositoryApi* | [**updateMessageById**](docs/RepositoryApi.md#updateMessageById) | **PUT** /repositories/{repos-name}/{version}/messages/{id} | Updates a single message scenario, if found (idempotent)
*RepositoryApi* | [**updateRepositoryById**](docs/RepositoryApi.md#updateRepositoryById) | **PUT** /repositories/{repos-name}/{version} | Updates an Orchestra repository, if found (idempotent)


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
 - [Repository](docs/Repository.md)
 - [Response](docs/Response.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



