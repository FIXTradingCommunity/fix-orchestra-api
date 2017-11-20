package io.fixprotocol.orchestraAPI.store;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Datatype;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Group;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.Repository;



public interface RepositoryStore {

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
   * @param toClone identifier of Component to clone (optional)
   * @throws ResourceNotFoundException if the repository to update does not exist
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
   * Creates a new Message in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param message to add to the repository
   * @param toClone identifier of Message to clone (optional)
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createMessage(String reposName, String version, Message message, Integer toClone)
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
   * @param file contains a repository
   * @throws DuplicateKeyException if the repository already exists
   * @throws RepositoryStoreException if the store operation fails
   */
  void createRepositoryFromFile(File file) throws RepositoryStoreException;

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
   * Deletes one repository if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @throws ResourceNotFoundException if the repository to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteRepository(String reposName, String version) throws RepositoryStoreException;

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
   * @param search filter for selection of repositories by their Metadata
   * @return list of Metadata. The identifier field of a Metadata carries the identifier of its
   *         containing repository.
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Metadata> getRepositoriesMetadata(Predicate<Metadata> search)
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


}
