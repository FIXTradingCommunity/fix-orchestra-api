package io.fixprotocol.orchestraAPI.client;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.fixprotocol.orchestra.client.ApiClient;
import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.JSON;
import io.fixprotocol.orchestra.client.api.DocumentationApi;
import io.fixprotocol.orchestra.client.api.RepositoryApi;
import io.fixprotocol.orchestra.client.api.WorkflowApi;
import io.fixprotocol.orchestra.client.model.Actor;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.Code;
import io.fixprotocol.orchestra.client.model.CodeSet;
import io.fixprotocol.orchestra.client.model.Component;
import io.fixprotocol.orchestra.client.model.Datatype;
import io.fixprotocol.orchestra.client.model.Field;
import io.fixprotocol.orchestra.client.model.Flow;
import io.fixprotocol.orchestra.client.model.Group;
import io.fixprotocol.orchestra.client.model.Message;
import io.fixprotocol.orchestra.client.model.Repository;
import io.fixprotocol.orchestra.client.model.Response;
import io.fixprotocol.orchestra.client.model.StateMachine;

public class Client {

  private final DocumentationApi documentationApi = new DocumentationApi();;
  private final RepositoryApi repositoryApi = new RepositoryApi();
  private final WorkflowApi workflowApi = new WorkflowApi();

  /**
   * Constructor with defaults
   */
  public Client() {
    this(new ApiClient());
  }

  /**
   * Constructor with supplied HTTP client
   * 
   * @param apiClient an HTTP client
   */
  public Client(ApiClient apiClient) {
    JSON json = apiClient.getJSON();
    ObjectMapper mapper = json.getContext(null);
    // allows deserialization of ArrayList with a single element as an array (why isn't this the
    // default?)
    mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    repositoryApi.setApiClient(apiClient);
    workflowApi.setApiClient(apiClient);
  }

  /**
   * adds an Actor Adds an Actor
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param actor Actor to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addActor(String reposName, String version, Actor actor) throws ApiException {
    workflowApi.addActor(reposName, version, actor);
  }

  /**
   * adds an Annotation Adds an Annotation
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId name or ID as a string of the element to annotate (required)
   * @param elementType type of element to annotate (required)
   * @param parentId name or ID as a string of the parent of the element to annotate. Required for
   *        code, actor, stateMachine. (optional)
   * @param annotation Annotation to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addAnnotation(String reposName, String version, String elementId, String elementType,
      String parentId, Annotation annotation) throws ApiException {
    documentationApi.addAnnotation(reposName, version, elementId, elementType, parentId,
        annotation);
  }

  /**
   * Adds a Code to a CodeSet
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param codesetid CodeSet ID
   * @param code Code to add
   * @throws ApiException if the API call fails
   */
  public void addCode(String reposName, String version, Integer codesetid, Code code)
      throws ApiException {
    repositoryApi.addCode(reposName, version, codesetid, code);
  }

  /**
   * Adds a CodeSet
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param codeSet to add
   * @throws ApiException if the API call fails
   */
  public void addCodeSet(String reposName, String version, CodeSet codeSet) throws ApiException {
    repositoryApi.addCodeSet(reposName, version, codeSet);
  }

  /**
   * Adds a Component
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param component to add
   * @throws ApiException if the API call fails
   */
  public void addComponent(String reposName, String version, Component component)
      throws ApiException {
    repositoryApi.addComponent(reposName, version, component, null);
  }

  /**
   * Clones a Component
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param component to add
   * @param toClone ID of component to clone
   * @throws ApiException if the API call fails
   */
  public void addComponent(String reposName, String version, Component component, Integer toClone)
      throws ApiException {
    repositoryApi.addComponent(reposName, version, component, toClone);
  }

  /**
   * Adds a Datatype
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param datatype to add
   * @throws ApiException if the API call fails
   */
  public void addDatatype(String reposName, String version, Datatype datatype) throws ApiException {
    repositoryApi.addDatatype(reposName, version, datatype);
  }

  /**
   * Adds a Field
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param field to add
   * @throws ApiException if the API call fails
   */
  public void addField(String reposName, String version, Field field) throws ApiException {
    repositoryApi.addField(reposName, version, field);
  }

  /**
   * adds a Flow Adds a Flow
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param flow Flow to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addFlow(String reposName, String version, Flow flow) throws ApiException {
    workflowApi.addFlow(reposName, version, flow);
  }

  /**
   * Add a Group
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param group to add
   * @throws ApiException if the API call fails
   */
  public void addGroup(String reposName, String version, Group group) throws ApiException {
    repositoryApi.addGroup(reposName, version, group, null);
  }

  /**
   * Clones a Group
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param group to add
   * @param toClone ID of group to clone
   * @throws ApiException if the API call fails
   */
  public void addGroup(String reposName, String version, Group group, Integer toClone)
      throws ApiException {
    repositoryApi.addGroup(reposName, version, group, toClone);
  }

  /**
   * Adds a message scenario
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param message to add
   * @throws ApiException if the API call fails
   */
  public void addMessage(String reposName, String version, Message message) throws ApiException {
    repositoryApi.addMessage(reposName, version, message, null);
  }

  /**
   * Clones a message scenario
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param message to add
   * @param toClone ID of message to clone
   * @throws ApiException if the API call fails
   */
  public void addMessage(String reposName, String version, Message message, Integer toClone)
      throws ApiException {
    repositoryApi.addMessage(reposName, version, message, toClone);
  }

  /**
   * Adds a Response to a message
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param id message ID
   * @param response Response to add
   * @throws ApiException if the API call fails
   */
  public void addMessageResponse(String reposName, String version, Integer id, Response response)
      throws ApiException {
    workflowApi.addMessageResponse(reposName, version, id, response);
  }

  /**
   * Adds an Orchestra repository file
   * 
   * @param repository metadata of an Orchestra file to add
   * @throws ApiException if the API call fails
   */
  public void addRepository(Repository repository) throws ApiException {
    repositoryApi.addRepository(repository, null, null);
  }

  /**
   * Clones an Orchestra repository file
   * 
   * @param repository metadata of an Orchestra file to add
   * @param nameToClone name of repository to clone
   * @param versionToClone version of repository to clone
   * @throws ApiException if the API call fails
   */
  public void addRepository(Repository repository, String nameToClone, String versionToClone)
      throws ApiException {
    repositoryApi.addRepository(repository, nameToClone, versionToClone);
  }

  /**
   * adds a state machine Adds a StateMachine
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to update (required)
   * @param stateMachine StateMachine to add (optional)
   * @throws ApiException if fails to make API call
   */
  public void addStateMachine(String reposName, String version, String name,
      StateMachine stateMachine) throws ApiException {
    workflowApi.addStateMachine(reposName, version, name, stateMachine);
  }

  /**
   * deletes a single Actor based on the name supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteActor(String reposName, String version, String name) throws ApiException {
    workflowApi.deleteActor(reposName, version, name);
  }

  /**
   * deletes a single Annotation
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId name or ID as a string of the element to annotate (required)
   * @param elementType type of element to annotate (required)
   * @param parentId name or ID as a string of the parent of the element to annotate. Required for
   *        code, actor, stateMachine. (optional)
   * @throws ApiException if fails to make API call
   */
  public void deleteAnnotation(String reposName, String version, String elementId,
      String elementType, String parentId) throws ApiException {
    documentationApi.deleteAnnotation(reposName, version, elementId, elementType, parentId);
  }

  /**
   * Deletes a single Code based on the ID supplied
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param codesetid CodeSet identifier
   * @param codeid Code identifier
   * @throws ApiException if the API call fails
   */
  public void deleteCode(String reposName, String version, Integer codesetid, Integer codeid)
      throws ApiException {
    repositoryApi.deleteCode(reposName, version, codesetid, codeid);
  }

  /**
   * Deletes a single CodeSet based on the ID supplied
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param codesetid CodeSet identifier
   * @throws ApiException if the API call fails
   */
  public void deleteCodeSet(String reposName, String version, Integer codesetid)
      throws ApiException {
    repositoryApi.deleteCodeSet(reposName, version, codesetid);
  }

  /**
   * Deletes a single Component based on the ID supplied
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param componentid Component identifier
   * @throws ApiException if the API call fails
   */
  public void deleteComponent(String reposName, String version, Integer componentid)
      throws ApiException {
    repositoryApi.deleteComponent(reposName, version, componentid);
  }

  /**
   * Deletes a single Datatype based on the name supplied
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param name name of a Datatype to delete
   * @throws ApiException if the API call fails
   */
  public void deleteDatatype(String reposName, String version, String name) throws ApiException {
    repositoryApi.deleteDatatype(reposName, version, name);
  }

  /**
   * Deletes a single Field based on the ID supplied
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param fieldid Field identifier
   * @throws ApiException if the API call fails
   */
  public void deleteField(String reposName, String version, Integer fieldid) throws ApiException {
    repositoryApi.deleteField(reposName, version, fieldid);
  }

  /**
   * deletes a single Flow based on the name supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Flow to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteFlow(String reposName, String version, String name) throws ApiException {
    workflowApi.deleteFlow(reposName, version, name);
  }

  /**
   * Deletes a single message scenario based on the ID supplied
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param messageid Message identifier
   * @throws ApiException if the API call fails
   */
  public void deleteMessage(String reposName, String version, Integer messageid)
      throws ApiException {
    repositoryApi.deleteMessage(reposName, version, messageid);
  }

  /**
   * Deletes a Response to a message
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param id Message identifier
   * @param name Response name
   * @throws ApiException if the API call fails
   */

  public void deleteMessageResponse(String reposName, String version, Integer id, String name)
      throws ApiException {
    workflowApi.deleteMessageResponse(reposName, version, id, name);
  }

  /**
   * Deletes a single Orchestra repository file based on the ID supplied
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @throws ApiException if the API call fails
   */
  public void deleteRepository(String reposName, String version) throws ApiException {
    repositoryApi.deleteRepository(reposName, version);
  }

  /**
   * deletes a single StateMachine based on the name supplied
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to update (required)
   * @param smName name of StateMachine to delete (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteStateMachine(String reposName, String version, String name, String smName)
      throws ApiException {
    workflowApi.deleteStateMachine(reposName, version, name, smName);
  }

  /**
   * Downloads a repository file
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @return file holding serialized repository
   * @throws ApiException if the API call fails
   */
  public File downloadRepository(String reposName, String version) throws ApiException {
    return repositoryApi.downloadRepositoryById(reposName, version);
  }

  /**
   * Returns a single Actor, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to fetch (required)
   * @return Actor
   * @throws ApiException if fails to make API call
   */
  public Actor findActorByName(String reposName, String version, String name) throws ApiException {
    return workflowApi.findActorByName(reposName, version, name);
  }

  /**
   * Returns a single Code, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param codesetid CodeSet identifier
   * @param codeid Code identifier
   * @return a Code
   * @throws ApiException if the API call fails or the Code is not found
   */
  public Code findCodeById(String reposName, String version, Integer codesetid, Integer codeid)
      throws ApiException {
    return repositoryApi.findCodeById(reposName, version, codesetid, codeid);
  }

  /**
   * Returns a single CodeSet, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param codesetid CodeSet identifier
   * @return a CodeSet
   * @throws ApiException if the API call fails or the CodeSet is not found
   */
  public CodeSet findCodeSetById(String reposName, String version, Integer codesetid)
      throws ApiException {
    return repositoryApi.findCodeSetById(reposName, version, codesetid);
  }

  /**
   * Returns a single Component, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param componentid Component identifier
   * @return a Component
   * @throws ApiException if the API call fails or the CodeSet is not found
   */
  public Component findComponentById(String reposName, String version, Integer componentid)
      throws ApiException {
    return repositoryApi.findComponentById(reposName, version, componentid);
  }

  /**
   * Returns a single Datatype, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param name name of a Datatype
   * @return a Datatype
   * @throws ApiException if the API call fails or the Datatype is not found
   */
  public Datatype findDatatypeByName(String reposName, String version, String name)
      throws ApiException {
    return repositoryApi.findDatatypeByName(reposName, version, name);
  }

  /**
   * Returns a single Field, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param fieldid Field identifier
   * @return a Field
   * @throws ApiException if the API call fails or the Field is not found
   */
  public Field findFieldById(String reposName, String version, Integer fieldid)
      throws ApiException {
    return repositoryApi.findFieldById(reposName, version, fieldid);
  }

  /**
   * Returns a single Flow, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Flow to fetch (required)
   * @return Flow
   * @throws ApiException if fails to make API call
   */
  public Flow findFlowByName(String reposName, String version, String name) throws ApiException {
    return workflowApi.findFlowByName(reposName, version, name);
  }

  /**
   * Returns a single Group, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param id Group identifier
   * @return a Group
   * @throws ApiException if the API call fails or the Group is not found
   */
  public Group findGroupById(String reposName, String version, Integer id) throws ApiException {
    return repositoryApi.findGroupById(reposName, version, id);
  }

  /**
   * Returns a single message scenario, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param messageid Message identifier
   * @return a Message
   * @throws ApiException if the API call fails or the Message is not found
   */
  public Message findMessageById(String reposName, String version, Integer messageid)
      throws ApiException {
    return repositoryApi.findMessageById(reposName, version, messageid);
  }

  /**
   * Returns a single message Response, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param id Message identifier
   * @param name Response name
   * @return a Response
   * @throws ApiException if the API call fails or the Response is not found
   */

  public Response findMessageResponseById(String reposName, String version, Integer id, String name)
      throws ApiException {
    return workflowApi.findMessageResponseById(reposName, version, id, name);
  }

  /**
   * Returns a single Orchestra repository file Metadata, if found
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @return a Repository metadata
   * @throws ApiException if the API call fails or the Metadata is not found
   */
  public Repository findRepositoryById(String reposName, String version) throws ApiException {
    return repositoryApi.findRepositoryById(reposName, version);
  }

  /**
   * Returns a single StateMachine, if found
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to search (required)
   * @param smName name of StateMachine to fetch (required)
   * @return StateMachine
   * @throws ApiException if fails to make API call
   */
  public StateMachine findStateMachine(String reposName, String version, String name, String smName)
      throws ApiException {
    return workflowApi.findStateMachine(reposName, version, name, smName);
  }

  /**
   * searches actors By passing in the appropriate options, you can search for actors
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up actors (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Actor>
   * @throws ApiException if fails to make API call
   */
  public List<Actor> searchActors(String reposName, String version, String searchString,
      Integer skip, Integer limit) throws ApiException {
    return workflowApi.searchActors(reposName, version, searchString, skip, limit);
  }

  /**
   * searches annotations By passing in the appropriate options, you can search for annotations
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId name or ID as a string of the element to annotate (required)
   * @param elementType type of element to annotate (required)
   * @param parentId name or ID as a string of the parent of the element to annotate. Required for
   *        code, actor, stateMachine. (optional)
   * @param searchString pass an optional search string for looking up annotations (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return Annotation
   * @throws ApiException if fails to make API call
   */
  public Annotation searchAnnotations(String reposName, String version, String elementId,
      String elementType, String parentId, String searchString, Integer skip, Integer limit)
      throws ApiException {
    return documentationApi.searchAnnotations(reposName, version, elementId, elementType, parentId,
        searchString, skip, limit);
  }

  /**
   * searches Codes within a CodeSet
   *
   * By passing in the appropriate options, you can search for Codes
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param codesetid CodeSet identifier
   * @param searchString pass an optional search string for looking up Codes (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Code&gt;
   * @throws ApiException if the API call fails
   */
  public List<Code> searchCodes(String reposName, String version, Integer codesetid,
      String searchString, Integer skip, Integer limit) throws ApiException {
    return repositoryApi.searchCodes(reposName, version, codesetid, searchString, skip, limit);
  }

  /**
   * searches CodeSets
   *
   * By passing in the appropriate options, you can search for CodeSets
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up CodeSets (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;CodeSet&gt;
   * @throws ApiException if the API call fails
   */
  public List<CodeSet> searchCodeSets(String reposName, String version, String searchString,
      Integer skip, Integer limit) throws ApiException {
    return repositoryApi.searchCodeSets(reposName, version, searchString, skip, limit);
  }

  /**
   * searches Components
   *
   * By passing in the appropriate options, you can search for Components
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up Components (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Component&gt;
   * @throws ApiException if the API call fails
   */
  public List<Component> searchComponents(String reposName, String version, String searchString,
      Integer skip, Integer limit) throws ApiException {
    return repositoryApi.searchComponents(reposName, version, searchString, skip, limit);
  }

  /**
   * searches Datatypes
   *
   * By passing in the appropriate options, you can search for Datatypes
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up Datatypes (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Datatype&gt;
   * @throws ApiException if the API call fails
   */
  public List<Datatype> searchDatatypes(String reposName, String version, String searchString,
      Integer skip, Integer limit) throws ApiException {
    return repositoryApi.searchDatatypes(reposName, version, searchString, skip, limit);
  }

  /**
   * searches Fields
   *
   * By passing in the appropriate options, you can search for Fields
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up Fields (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Field&gt;
   * @throws ApiException if the API call fails
   */
  public List<Field> searchFields(String reposName, String version, String searchString,
      Integer skip, Integer limit) throws ApiException {
    return repositoryApi.searchFields(reposName, version, searchString, skip, limit);
  }

  /**
   * searches flows By passing in the appropriate options, you can search for flows
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param searchString pass an optional search string for looking up flows (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<Flow>
   * @throws ApiException if fails to make API call
   */
  public List<Flow> searchFlows(String reposName, String version, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return workflowApi.searchFlows(reposName, version, searchString, skip, limit);
  }

  /**
   * searches groups
   *
   * By passing in the appropriate options, you can search for groups
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up groups (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Component&gt;
   * @throws ApiException if the API call fails
   */
  public List<Group> searchGroups(String reposName, String version, String searchString,
      Integer skip, Integer limit) throws ApiException {
    return repositoryApi.searchGroups(reposName, version, searchString, skip, limit);
  }

  /**
   * searches responses to a Message
   *
   * By passing in the appropriate options, you can search for responses
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param id message identifier
   * @param searchString pass an optional search string for looking up responses (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Response&gt;
   * @throws ApiException if the API call fails
   */
  public List<Response> searchMessageResponses(String reposName, String version, Integer id,
      String searchString, Integer skip, Integer limit) throws ApiException {
    return workflowApi.searchMessageResponses(reposName, version, id, searchString, skip, limit);
  }

  /**
   * searches Messages
   *
   * By passing in the appropriate options, you can search for Messages
   * 
   * @param reposName name of Orchestra repository file (required)
   * @param version version of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up Messages (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Message&gt;
   * @throws ApiException if the API call fails
   */
  public List<Message> searchMessages(String reposName, String version, String searchString,
      Integer skip, Integer limit) throws ApiException {
    return repositoryApi.searchMessages(reposName, version, searchString, skip, limit);
  }

  /**
   * searches Orchestra repository files
   *
   * By passing in the appropriate options, you can search for Orchestra repository files
   * 
   * @param searchString pass an optional search string for looking up Metadata (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List of Repository metadata
   * @throws ApiException if the API call fails
   */

  public List<Repository> searchRepositories(String searchString, Integer skip, Integer limit)
      throws ApiException {
    return repositoryApi.searchRepositories(searchString, skip, limit);
  }

  /**
   * searches state machines By passing in the appropriate options, you can search for state
   * machines
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to search (required)
   * @param searchString pass an optional search string for looking up actors (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List<StateMachine>
   * @throws ApiException if fails to make API call
   */
  public List<StateMachine> searchStateMachines(String reposName, String version, String name,
      String searchString, Integer skip, Integer limit) throws ApiException {
    return workflowApi.searchStateMachines(reposName, version, name, searchString, skip, limit);
  }

  /**
   * Updates a single Actor, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of CodeSet to update (required)
   * @param actor Actor to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateActorByName(String reposName, String version, String name, Actor actor)
      throws ApiException {
    workflowApi.updateActorByName(reposName, version, name, actor);
  }

  /**
   * Updates a single Annotation, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId name or ID as a string of the element to annotate (required)
   * @param elementType type of element to annotate (required)
   * @param annotation Annotation to update (required)
   * @param parentId name or ID as a string of the parent of the element to annotate. Required for
   *        code, actor, stateMachine. (optional)
   * @throws ApiException if fails to make API call
   */
  public void updateAnnotation(String reposName, String version, String elementId,
      String elementType, Annotation annotation, String parentId) throws ApiException {
    documentationApi.updateAnnotation(reposName, version, elementId, elementType, annotation,
        parentId);
  }

  /**
   * Updates a single Code, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param codesetid CodeSet ID
   * @param codeid Code ID
   * @param code Code to update
   * @throws ApiException if the API call fails or the Code is not found
   */
  public void updateCodeById(String reposName, String version, Integer codesetid, Integer codeid,
      Code code) throws ApiException {
    repositoryApi.updateCodeById(reposName, version, codesetid, codeid, code);
  }

  /**
   * Updates a single CodeSet, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param codesetid CodeSet ID
   * @param codeSet to update
   * @throws ApiException if the API call fails or the CodeSet is not found
   */
  public void updateCodeSetById(String reposName, String version, Integer codesetid,
      CodeSet codeSet) throws ApiException {
    repositoryApi.updateCodeSetById(reposName, version, codesetid, codeSet);
  }

  /**
   * Updates a single Component, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param componentid Component ID
   * @param component to update
   * @throws ApiException if the API call fails or the Component is not found
   */

  public void updateComponentById(String reposName, String version, Integer componentid,
      Component component) throws ApiException {
    repositoryApi.updateComponentById(reposName, version, componentid, component);
  }

  /**
   * Updates a single Datatype, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param name Datatype name
   * @param datatype to update
   * @throws ApiException if API call fails or the Datatype is not found
   */
  public void updateDatatypeByName(String reposName, String version, String name, Datatype datatype)
      throws ApiException {
    repositoryApi.updateDatatypeByName(reposName, version, name, datatype);
  }

  /**
   * Updates a single Field, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param fieldid Field id
   * @param field to update
   * @throws ApiException if the API call fails or the Field is not found
   */
  public void updateFieldById(String reposName, String version, Integer fieldid, Field field)
      throws ApiException {
    repositoryApi.updateFieldById(reposName, version, fieldid, field);
  }

  /**
   * Updates a single Flow, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Flow to update (required)
   * @param flow Flow to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateFlowByName(String reposName, String version, String name, Flow flow)
      throws ApiException {
    workflowApi.updateFlowByName(reposName, version, name, flow);
  }

  /**
   * Updates a single Group, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param id Group ID
   * @param group to update
   * @throws ApiException if the API call fails or the Group is not found
   */
  public void updateGroupById(String reposName, String version, Integer id, Group group)
      throws ApiException {
    repositoryApi.updateGroupById(reposName, version, id, group);
  }

  /**
   * Updates a single message scenario, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param messageid Message ID
   * @param message to update
   * @throws ApiException if the API call fails or the Message is not found
   */
  public void updateMessageById(String reposName, String version, Integer messageid,
      Message message) throws ApiException {
    repositoryApi.updateMessageById(reposName, version, messageid, message);
  }

  /**
   * Updates a single message Response, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param id Message ID
   * @param name Response name
   * @param message to update
   * @throws ApiException if the API call fails or the Message is not found
   */
  public void updateMessageResponse(String reposName, String version, Integer id, String name,
      Response response) throws ApiException {
    workflowApi.updateMessageResponse(reposName, version, id, name, response);
  }

  /**
   * Updates Metadata of an Orchestra repository file, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository
   * @param version version of Orchestra repository
   * @param repository to update
   * @throws ApiException if the API call fails or the Metadata is not found
   */
  public void updateRepositoryById(String reposName, String version, Repository repository)
      throws ApiException {
    repositoryApi.updateRepositoryById(reposName, version, repository);
  }

  /**
   * Updates a single StateMachine, if found (idempotent)
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of Actor to update (required)
   * @param smName name of StateMachine to update (required)
   * @param stateMachine StateMachine to update (required)
   * @throws ApiException if fails to make API call
   */
  public void updateStateMachine(String reposName, String version, String name, String smName,
      StateMachine stateMachine) throws ApiException {
    workflowApi.updateStateMachine(reposName, version, name, smName, stateMachine);
  }

}
