package io.fixprotocol.orchestraAPI.store;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.function.Predicate;

import io.fixprotocol.orchestra.model.Actor;
import io.fixprotocol.orchestra.model.Annotation;
import io.fixprotocol.orchestra.model.Appinfo;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Datatype;
import io.fixprotocol.orchestra.model.Documentation;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Flow;
import io.fixprotocol.orchestra.model.Group;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.Repository;
import io.fixprotocol.orchestra.model.Response;
import io.fixprotocol.orchestra.model.StateMachine;



public interface RepositoryStore {

  /**
   * Creates a new Actor in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param actor to add to the repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createActor(String reposName, String version, Actor actor) throws RepositoryStoreException;

  /**
   * Creates a new Annotation to an element in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId identifier of the element to annotate
   * @param elementType type of the element
   * @param parentId identifier of the parent of the element to annotate
   * @param annotation to add to an element
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   * @throws IllegalArgumentException if elementType is not a supported type
   */
  void createAnnotation(String reposName, String version, String elementId, ElementType elementType,
      String parentId, Annotation annotation) throws RepositoryStoreException;

  /**
   * Creates a new Code in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid ID of the CodeSet in which to add the new Code
   * @param code to add to the repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createCode(String reposName, String version, Integer codesetid, Code code)
      throws RepositoryStoreException;

  /**
   * Creates a new CodeSet in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codeSet to add to the repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createCodeSet(String reposName, String version, CodeSet codeSet)
      throws RepositoryStoreException;

  /**
   * Creates a new Component in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param component to add to the repository
   * @param toClone identifier of Component to clone (optional). If the component to clone is found,
   *        its properties are copied except for the key fields provided by
   *        {@link Component#getOid()}
   * @throws ResourceNotFoundException if the repository to update or component to clone does not
   *         exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createComponent(String reposName, String version, Component component, Integer toClone)
      throws RepositoryStoreException;

  /**
   * Creates a new datatype in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param datatype to add to the repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createDatatype(String reposName, String version, Datatype datatype)
      throws RepositoryStoreException;

  /**
   * Creates a new field in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param field to add to the repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createField(String reposName, String version, Field field) throws RepositoryStoreException;

  /**
   * Creates a new Flow in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param flow to add to the repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createFlow(String reposName, String version, Flow flow) throws RepositoryStoreException;

  /**
   * Creates a new Message in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param message to add to the repository
   * @param toClone identifier of Message to clone (optional). If the message to clone is found, its
   *        properties are copied except for the key fields provided by {@link Message#getOid()} and
   *        {@link Message#getScenario()}.
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createMessage(String reposName, String version, Message message, Integer toClone)
      throws RepositoryStoreException;

  /**
   * Creates a new message response in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of message
   * @param response Response to add
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createMessageResponse(String reposName, String version, Integer id, Response response)
      throws RepositoryStoreException;

  /**
   * Creates a new repository if it does not already exist.
   * 
   * @param metadata describes the repository to be created
   * @param toClone identifier of repository to clone (optional)
   * @return metadata of the successfully added repository. The returned value may be modified from
   *         the {@code metadata} parameter.
   * @throws DuplicateKeyException if the repository already exists
   * @throws RepositoryStoreException if the store operation fails
   */
  Metadata createRepository(Repository repository, String nameToClone, String versionToClone)
      throws RepositoryStoreException;

  /**
   * Creates a new repository if it does not already exist.
   * 
   * @param stream input stream contains a repository
   * @return
   * @throws DuplicateKeyException if the repository already exists
   * @throws RepositoryStoreException if the store operation fails
   */
  Metadata createRepositoryFromFile(InputStream stream) throws RepositoryStoreException;

  /**
   * Creates a new Actor in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param actor to add to the repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createStateMachine(String reposName, String version, String actor, StateMachine stateMachine)
      throws RepositoryStoreException;

  /**
   * Deletes one Actor if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name actor name
   * @throws ResourceNotFoundException if the repository or actor to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteActor(String reposName, String version, String name) throws RepositoryStoreException;

  /**
   * Deletes one Annotation if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId identifier of the element to remove Annotation
   * @param elementType type of the element
   * @param parentId identifier of the parent of the element to annotate
   * @throws ResourceNotFoundException if the repository or actor to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   * @throws IllegalArgumentException if elementType is not a supported type
   */
  void deleteAnnotation(String reposName, String version, String elementId, ElementType elementType,
      String parentId) throws RepositoryStoreException;

  /**
   * Deletes one Code if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid CodeSet identifier
   * @param id Code identifier
   * @throws ResourceNotFoundException if the repository or code to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteCode(String reposName, String version, Integer codesetid, Integer id)
      throws RepositoryStoreException;

  /**
   * Deletes one CodeSet if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id CodeSet identifier
   * @throws ResourceNotFoundException if the repository or field to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteCodeSet(String reposName, String version, Integer id) throws RepositoryStoreException;

  /**
   * Deletes one Component if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id Component identifier
   * @throws ResourceNotFoundException if the repository or field to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteComponent(String reposName, String version, Integer id)
      throws RepositoryStoreException;

  /**
   * Deletes one datatype if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name datatype name
   * @throws ResourceNotFoundException if the repository or field to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteDatatype(String reposName, String version, String name)
      throws RepositoryStoreException;

  /**
   * Deletes one Field if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id field identifier
   * @throws ResourceNotFoundException if the repository or field to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteField(String reposName, String version, Integer id) throws RepositoryStoreException;

  /**
   * Deletes one Flow if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name flow name
   * @throws ResourceNotFoundException if the repository or flow to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteFlow(String reposName, String version, String name) throws RepositoryStoreException;

  /**
   * Deletes one Group if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id group identifier
   * @throws ResourceNotFoundException if the repository or group to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteGroup(String reposName, String version, Integer id) throws RepositoryStoreException;

  /**
   * Deletes one Message if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id message identifier
   * @throws ResourceNotFoundException if the repository or message to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteMessage(String reposName, String version, Integer id) throws RepositoryStoreException;

  /**
   * Deletes one message response if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id message identifier
   * @param name of response
   * @throws ResourceNotFoundException if the repository or message response to delete does not
   *         exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteMessageResponse(String reposName, String version, Integer id, String name)
      throws RepositoryStoreException;

  /**
   * Deletes one repository if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @throws ResourceNotFoundException if the repository to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteRepository(String reposName, String version) throws RepositoryStoreException;

  /**
   * Deletes one StateMachine if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param actor actor name
   * @param name state machine name
   * @throws ResourceNotFoundException if the repository or actor to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteStateMachine(String reposName, String version, String actor, String name)
      throws RepositoryStoreException;

  /**
   * Retrieves an Actor by name
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name actor name
   * @return the actor
   * @throws ResourceNotFoundException if the repository or actor does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Actor getActor(String reposName, String version, String name) throws RepositoryStoreException;

  /**
   * Retrieves all actors in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for actors to return
   * @return a list of actors
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Actor> getActors(String reposName, String version, Predicate<Actor> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves all annotations in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId identifier of the element to annotate
   * @param elementType type of the element
   * @param parentId identifier of the parent of the element to annotate
   * @param documentationPredicate filter for Documentation elements to return
   * @param appInfoPredicate filter for Appinfo elements to return
   * @return a list of annotations
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Annotation getAnnotations(String reposName, String version, String elementId,
      ElementType elementType, String parentId, Predicate<Documentation> documentationPredicate,
      Predicate<Appinfo> appInfoPredicate) throws RepositoryStoreException;

  /**
   * Retrieves a Code by its ID
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid CodeSet identifier
   * @param id Code identifier
   * @return the Code
   * @throws ResourceNotFoundException if the repository or Code does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Code getCodeById(String reposName, String version, Integer codesetid, Integer id)
      throws RepositoryStoreException;

  /**
   * Retrieves all codes in a CodeSet
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid ID of CodeSet
   * @param predicate filter for codes to return
   * @return a list of codes
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Code> getCodes(String reposName, String version, Integer codesetid,
      Predicate<Code> predicate) throws RepositoryStoreException;

  /**
   * Retrieves a CodeSet by its ID
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id CodeSet identifier
   * @return the CodeSet
   * @throws ResourceNotFoundException if the repository or CodeSet does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  CodeSet getCodeSetById(String reposName, String version, Integer id)
      throws RepositoryStoreException;

  /**
   * Retrieves all CodeSets in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for CodeSets to return
   * @return a list of CodeSets
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<CodeSet> getCodeSets(String reposName, String version, Predicate<CodeSet> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves a Component by its ID
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id Component identifier
   * @return the Component
   * @throws ResourceNotFoundException if the repository or Component does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Component getComponentById(String reposName, String version, Integer id)
      throws RepositoryStoreException;

  /**
   * Retrieves all components in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for components to return
   * @return a list of components
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Component> getComponents(String reposName, String version, Predicate<Component> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves a datatype by name
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name datatype identifier
   * @return the datatype
   * @throws ResourceNotFoundException if the repository or datatype does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Datatype getDatatype(String reposName, String version, String name)
      throws RepositoryStoreException;

  /**
   * Retrieves all datatypes in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for datatypes to return
   * @return a list of datatypes
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Datatype> getDatatypes(String reposName, String version, Predicate<Datatype> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves a Field by its ID
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id field identifier
   * @return the field
   * @throws ResourceNotFoundException if the repository or field does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Field getFieldById(String reposName, String version, Integer id) throws RepositoryStoreException;

  /**
   * Retrieves all fields in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for fields to return
   * @return a list of fields
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Field> getFields(String reposName, String version, Predicate<Field> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves a Flow by name
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name flow name
   * @return the flow
   * @throws ResourceNotFoundException if the repository or flow does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Flow getFlow(String reposName, String version, String name) throws RepositoryStoreException;

  /**
   * Retrieves all flows in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for flows to return
   * @return a list of flows
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Flow> getFlows(String reposName, String version, Predicate<Flow> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves a Group by its ID
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id group identifier
   * @return the group
   * @throws ResourceNotFoundException if the repository or group does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Group getGroupById(String reposName, String version, Integer id) throws RepositoryStoreException;

  /**
   * Retrieves all groups in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for groups to return
   * @return a list of groups
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Group> getGroups(String reposName, String version, Predicate<Group> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves a Message by its ID
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id message identifier
   * @return the message
   * @throws ResourceNotFoundException if the repository or message does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Message getMessageById(String reposName, String version, Integer id)
      throws RepositoryStoreException;

  /**
   * Retrieves a message response by name
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of the message
   * @param name response identifier
   * @return the message response
   * @throws ResourceNotFoundException if the repository or response does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Response getMessageResponse(String reposName, String version, Integer id, String name)
      throws RepositoryStoreException;

  /**
   * Retrieves all responses to a message
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of a message
   * @param predicate filter for responses to return
   * @return a list of responses
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */

  List<Response> getMessageResponses(String reposName, String version, Integer id,
      Predicate<Response> predicate) throws RepositoryStoreException;

  /**
   * Retrieves all messages in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for messages to return
   * @return a list of messages
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Message> getMessages(String reposName, String version, Predicate<Message> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves the metadata of all repositories
   * 
   * @param search filter for selection of repositories 
   * @return list of Metadata. The identifier field of a Metadata carries the identifier of its
   *         containing repository.
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Metadata> getRepositoriesMetadata(Predicate<Repository> search)
      throws RepositoryStoreException;

  /**
   * Serialize a repository to a file
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @return a repository file
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  File getRepositoryFile(String reposName, String version) throws RepositoryStoreException;

  /**
   * Retrieves the metadata of a repository, if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @return the metadata of a repository
   * @throws ResourceNotFoundException if the repository to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Metadata getRepositoryMetadata(String reposName, String version) throws RepositoryStoreException;

  /**
   * Retrieves an StateMachine by name
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param actor actor name
   * @param name state machine name
   * @return the state machine
   * @throws ResourceNotFoundException if the repository or actor does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  StateMachine getStateMachine(String reposName, String version, String actor, String name)
      throws RepositoryStoreException;

  /**
   * Retrieves all state machines in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for state machines to return
   * @return a list of state machines
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<StateMachine> getStateMachines(String reposName, String version,
      Predicate<StateMachine> predicate) throws RepositoryStoreException;

  /**
   * Update an existing Actor
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name name of actor to update
   * @param actor new value of the Actor
   * @throws ResourceNotFoundException if the repository or actor to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateActor(String reposName, String version, String name, Actor actor)
      throws RepositoryStoreException;

  /**
   * Update an existing Annotation
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param elementId identifier of the element to annotate
   * @param elementType type of the element
   * @param parentId identifier of the parent of the element to annotate
   * @param annotation new value of Annotation
   * @throws ResourceNotFoundException if the repository or element to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateAnnotation(String reposName, String version, String elementId, ElementType elementType,
      String parentId, Annotation annotation) throws RepositoryStoreException;

  /**
   * Update an existing Code
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param codesetid ID of the CodeSet
   * @param code new value of the Code
   * @throws ResourceNotFoundException if the repository or CodeSet to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateCode(String reposName, String version, Integer codesetid, Integer id, Code code)
      throws RepositoryStoreException;

  /**
   * Update an existing CodeSet
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of the CodeSet to update
   * @param codeSet new value of the CodeSet
   * @throws ResourceNotFoundException if the repository or CodeSet to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateCodeSet(String reposName, String version, Integer id, CodeSet codeSet)
      throws RepositoryStoreException;

  /**
   * Update an existing Component
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of the Component to update
   * @param component new value of the Component
   * @throws ResourceNotFoundException if the repository or Component to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateComponent(String reposName, String version, Integer id, Component component)
      throws RepositoryStoreException;

  /**
   * Update an existing datatype
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param name ID of the datatype to update
   * @param datatype new value of the datatype
   * @throws ResourceNotFoundException if the repository or datatype to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateDatatype(String reposName, String version, String name, Datatype datatype)
      throws RepositoryStoreException;

  /**
   * Update an existing field
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of the field to update
   * @param field new value of the field
   * @throws ResourceNotFoundException if the repository or field to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateField(String reposName, String version, Integer id, Field field)
      throws RepositoryStoreException;

  void updateFlow(String reposName, String version, String name, Flow flow)
      throws RepositoryStoreException;

  /**
   * Update an existing Group
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of the group to update
   * @param group new value of the Group
   * @throws ResourceNotFoundException if the repository or field to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateGroup(String reposName, String version, Integer id, Group group)
      throws RepositoryStoreException;

  /**
   * Update an existing Message
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of the message to update
   * @param field new value of the Message
   * @throws ResourceNotFoundException if the repository or message to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateMessage(String reposName, String version, Integer id, Message message)
      throws RepositoryStoreException;

  /**
   * Update an existing message response
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of the message to update
   * @param name of the Response to update
   * @param response new value of the Response
   * @throws ResourceNotFoundException if the repository or message to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateMessageResponse(String reposName, String version, Integer id, String name,
      Response response) throws RepositoryStoreException;

  /**
   * Update an existing repository from an input stream
   * 
   * @param upfileInputStream input stream containing a repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateRepositoryFromFile(InputStream upfileInputStream)
      throws ResourceNotFoundException, RepositoryStoreException;

  /**
   * Update the metadata of an existing repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param repository new value of metadata
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateRepositoryMetadata(String reposName, String version, Repository repository)
      throws RepositoryStoreException;

  /**
   * Update an existing StateMachine
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param actor name of actor to update
   * @param name name of StateMachine to update
   * @param stateMachine new value of StateMachine
   * @throws ResourceNotFoundException if the repository or actor to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateStateMachine(String reposName, String version, String actor, String name,
      StateMachine stateMachine) throws RepositoryStoreException;
}
