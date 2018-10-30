# fix-orchestra-api
**A REST API for querying or editing an Orchestra file**

## NOTICE
This project will no longer be maintained unless there is user demand to do so. If you would like it resumed, then enter an issue stating your expected benefit.

GitHub has reported a security vulnerability in a dependency of Swagger-generated code, so beware of that if you choose to fork this project.

### Overview

FIX Orchestra is intended to provide a standard and some reference implementation for *machine readable rules of engagement* between counterparties. The goal is to reduce the time to get counterparties trading, and improve accuracy of implementations.

The REST API provided by this project provides a standard programmatic means to query or edit Orchestra files. Any number of applications could be built atop the API, such as code and configuration generators or an editor user interface.

### Planned Lifecycle
Major versions of this project will be tied to versioning of the FIX Orchestra standard. Minor versions may be released for new or improved technical features.

### Orchestra references
Specifications for Orchestra are available in GitHub.

[Orchestra specifications](https://github.com/FIXTradingCommunity/fix-orchestra-spec)

Orchestra resources and code project

[Orchestra recources](https://github.com/FIXTradingCommunity/fix-orchestra)

Public Orchestra files for service offerings

[Orchestrations](https://github.com/FIXTradingCommunity/orchestrations)

## Architecture

The server implementation uses standard HTTP interfaces and consumes and produces JSON payloads.

The API wraps features of the Orchestra repository schema. CRUD operations cover:
* Message structures: fields, components, messages, and datatypes
* Workflow: message responses
* Actors with state variables and state machines
* Documentation of all features
* Respositories, messages and components can be created by cloning existing elements

##### Planned API enhancements

* Provide a REST API for the Orchestra Interfaces schema: service offerings, protocol stack, session configuration


### Modules
#### server
An implementation of the API with these features:
* Uses Jetty as a web server for testing, but can be adapted to others using standard interfaces.
* A datastore that maintains Orchestra repositories for querying and editing. Each is stored in memory as an XML DOM, and can be retrieved as an XML file that conforms to the the Orchestra XML schema. 


##### Planned implementation enhancements

* Persist Orchestra files and load into memory on demand.
* Authorization model for read and write access by Orchestra repository ownership
* Maintain pedigree of changes
* Assign unique IDs such as new field tags

#### client
A thin layer over the generated Java client to make it easier to use. This module contains test cases for the API.

#### swagger
Source for the generated code conformant with OpenAPI 2.0. See [Swagger specification](https://swagger.io/specification/). This source can be used to generate clients in other programming languages.

#### swagger-java-client
A generated Java API client 

#### swagger-jaxrs-server
A generated server stub using JAX-RS, the Java RESTful API framework.

## License

© Copyright 2017 FIX Protocol Limited

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

## Prerequisites
This project requires Java 8 or later. It should run on any platform for which the JVM is supported.

## Build
The project is built with Maven version 3.0 or later. 
