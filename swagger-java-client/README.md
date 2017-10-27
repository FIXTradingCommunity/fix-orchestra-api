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
        String codesetid = "codesetid_example"; // String | ID of CodeSet
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
*RepositoryApi* | [**addCode**](docs/RepositoryApi.md#addCode) | **POST** /repository/{fileid}/codesets{codesetid}/code | adds a Code to CodeSet
*RepositoryApi* | [**addCodeSet**](docs/RepositoryApi.md#addCodeSet) | **POST** /repository/{fileid}/codesets | adds a CodeSet
*RepositoryApi* | [**addComponent**](docs/RepositoryApi.md#addComponent) | **POST** /repository/{fileid}/components | adds a component
*RepositoryApi* | [**addDatatype**](docs/RepositoryApi.md#addDatatype) | **POST** /repository/{fileid}/datatypes | adds a datatype
*RepositoryApi* | [**addField**](docs/RepositoryApi.md#addField) | **POST** /repository/{fileid}/fields | adds a field
*RepositoryApi* | [**addMessage**](docs/RepositoryApi.md#addMessage) | **POST** /repository/{fileid}/messages | adds a message scenario
*RepositoryApi* | [**addRepository**](docs/RepositoryApi.md#addRepository) | **POST** /repository | adds an Orchestra repository file
*RepositoryApi* | [**deleteCode**](docs/RepositoryApi.md#deleteCode) | **DELETE** /repository/{fileid}/codesets/{codesetid}/code{id} | deletes a single Code based on the ID supplied
*RepositoryApi* | [**deleteCodeSet**](docs/RepositoryApi.md#deleteCodeSet) | **DELETE** /repository/{fileid}/codesets/{id} | deletes a single CodeSet based on the ID supplied
*RepositoryApi* | [**deleteComponent**](docs/RepositoryApi.md#deleteComponent) | **DELETE** /repository/{fileid}/components/{id} | deletes a single component based on the ID supplied
*RepositoryApi* | [**deleteDatatype**](docs/RepositoryApi.md#deleteDatatype) | **DELETE** /repository/{fileid}/datatypes/{name} | deletes a single datatype based on the name supplied
*RepositoryApi* | [**deleteField**](docs/RepositoryApi.md#deleteField) | **DELETE** /repository/{fileid}/fields/{id} | deletes a single field based on the ID supplied
*RepositoryApi* | [**deleteMessage**](docs/RepositoryApi.md#deleteMessage) | **DELETE** /repository/{fileid}/messages/{id} | deletes a single message scenario based on the ID supplied
*RepositoryApi* | [**deleteRepository**](docs/RepositoryApi.md#deleteRepository) | **DELETE** /repository/{fileid} | deletes a single Orchestra repository file based on the ID supplied
*RepositoryApi* | [**findCodeById**](docs/RepositoryApi.md#findCodeById) | **GET** /repository/{fileid}/codesets/{codesetid}/code{id} | Returns a single Code, if found
*RepositoryApi* | [**findCodeSetById**](docs/RepositoryApi.md#findCodeSetById) | **GET** /repository/{fileid}/codesets/{id} | Returns a single CodeSet, if found
*RepositoryApi* | [**findComponentById**](docs/RepositoryApi.md#findComponentById) | **GET** /repository/{fileid}/components/{id} | Returns a single component, if found
*RepositoryApi* | [**findDatatypeByName**](docs/RepositoryApi.md#findDatatypeByName) | **GET** /repository/{fileid}/datatypes/{name} | Returns a single datatype, if found
*RepositoryApi* | [**findFieldById**](docs/RepositoryApi.md#findFieldById) | **GET** /repository/{fileid}/fields/{id} | Returns a single field, if found
*RepositoryApi* | [**findMessageById**](docs/RepositoryApi.md#findMessageById) | **GET** /repository/{fileid}/messages/{id} | Returns a single message scenario, if found
*RepositoryApi* | [**findRepositoryById**](docs/RepositoryApi.md#findRepositoryById) | **GET** /repository/{fileid} | Returns a single Orchestra repository file metadata, if found
*RepositoryApi* | [**searchCodeSets**](docs/RepositoryApi.md#searchCodeSets) | **GET** /repository/{fileid}/codesets | searches CodeSets
*RepositoryApi* | [**searchCodes**](docs/RepositoryApi.md#searchCodes) | **GET** /repository/{fileid}/codesets{codesetid}/code | searches Codes within a CodeSet
*RepositoryApi* | [**searchComponents**](docs/RepositoryApi.md#searchComponents) | **GET** /repository/{fileid}/components | searches components
*RepositoryApi* | [**searchDatatypes**](docs/RepositoryApi.md#searchDatatypes) | **GET** /repository/{fileid}/datatypes | searches datatypes
*RepositoryApi* | [**searchFields**](docs/RepositoryApi.md#searchFields) | **GET** /repository/{fileid}/fields | searches fields
*RepositoryApi* | [**searchMessages**](docs/RepositoryApi.md#searchMessages) | **GET** /repository/{fileid}/messages | searches messages
*RepositoryApi* | [**searchRepository**](docs/RepositoryApi.md#searchRepository) | **GET** /repository | searches Orchestra repository files
*RepositoryApi* | [**updateCodeById**](docs/RepositoryApi.md#updateCodeById) | **PUT** /repository/{fileid}/codesets/{codesetid}/code{id} | Updates a single Code, if found (idempotent)
*RepositoryApi* | [**updateCodeSetById**](docs/RepositoryApi.md#updateCodeSetById) | **PUT** /repository/{fileid}/codesets/{id} | Updates a single CodeSet, if found (idempotent)
*RepositoryApi* | [**updateComponentById**](docs/RepositoryApi.md#updateComponentById) | **PUT** /repository/{fileid}/components/{id} | Updates a single component, if found (idempotent)
*RepositoryApi* | [**updateDatatypeByName**](docs/RepositoryApi.md#updateDatatypeByName) | **PUT** /repository/{fileid}/datatypes/{name} | Updates a single datatype, if found (idempotent)
*RepositoryApi* | [**updateFieldById**](docs/RepositoryApi.md#updateFieldById) | **PUT** /repository/{fileid}/fields/{id} | Updates a single field, if found (idempotent)
*RepositoryApi* | [**updateMessageById**](docs/RepositoryApi.md#updateMessageById) | **PUT** /repository/{fileid}/messages/{id} | Updates a single message scenario, if found (idempotent)
*RepositoryApi* | [**updateRepositoryById**](docs/RepositoryApi.md#updateRepositoryById) | **PUT** /repository/{fileid} | Updates an Orchestra repository file, if found (idempotent)


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



