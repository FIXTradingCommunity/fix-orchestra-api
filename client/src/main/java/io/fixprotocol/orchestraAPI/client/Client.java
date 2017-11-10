package io.fixprotocol.orchestraAPI.client;

import java.util.List;

import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.api.RepositoryApi;
import io.fixprotocol.orchestra.client.model.Code;
import io.fixprotocol.orchestra.client.model.CodeSet;
import io.fixprotocol.orchestra.client.model.Component;
import io.fixprotocol.orchestra.client.model.Datatype;
import io.fixprotocol.orchestra.client.model.Field;
import io.fixprotocol.orchestra.client.model.Message;
import io.fixprotocol.orchestra.client.model.Repository;

public class Client {

  private final RepositoryApi apiInstance;

  public Client() {
    apiInstance = new RepositoryApi();
  }
  
  public Client(RepositoryApi apiInstance) {
    this.apiInstance = apiInstance;
  }

  /**
   * Adds a Code to a CodeSet
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet ID
   * @param code Code to add
   * @throws ApiException if the API call fails
   */
  public void addCode(String reposName, String version, Integer codesetid, Code code) throws ApiException {
    apiInstance.addCode(reposName, version, codesetid, code);
  }

  /**
   * Adds a CodeSet
   * 
   * @param fileid Orchestra repository file identifier
   * @param codeSet to add
   * @throws ApiException if the API call fails
   */
  public void addCodeSet(String reposName, String version, CodeSet codeSet) throws ApiException {
    apiInstance.addCodeSet(reposName, version, codeSet);
  }

  /**
   * Adds a Component
   * 
   * @param fileid Orchestra repository file identifier
   * @param component to add
   * @throws ApiException if the API call fails
   */
  public void addComponent(String reposName, String version, Component component) throws ApiException {
    apiInstance.addComponent(reposName, version, component, null);
  }

  /**
   * Clones a Component
   * 
   * @param fileid Orchestra repository file identifier
   * @param component to add
   * @param toClone ID of component to clone
   * @throws ApiException if the API call fails
   */
  public void addComponent(String reposName, String version, Component component, Integer toClone) throws ApiException {
    apiInstance.addComponent(reposName, version, component, toClone);
  }
  
  /**
   * Adds a Datatype
   * 
   * @param fileid Orchestra repository file identifier
   * @param datatype to add
   * @throws ApiException if the API call fails
   */
  public void addDatatype(String reposName, String version, Datatype datatype) throws ApiException {
    apiInstance.addDatatype(reposName, version, datatype);
  }

  /**
   * Adds a Field
   * 
   * @param fileid Orchestra repository file identifier
   * @param field to add
   * @throws ApiException if the API call fails
   */
  public void addField(String reposName, String version, Field field) throws ApiException {
    apiInstance.addField(reposName, version, field);
  }

  /**
   * Adds a message scenario
   * 
   * @param fileid Orchestra repository file identifier
   * @param message to add
   * @throws ApiException if the API call fails
   */
  public void addMessage(String reposName, String version, Message message) throws ApiException {
    apiInstance.addMessage(reposName, version, message, null);
  }
  
  /**
   * Clones a message scenario
   * 
   * @param fileid Orchestra repository file identifier
   * @param message to add
   * @param toClone ID of message to clone
   * @throws ApiException if the API call fails
   */
  public void addMessage(String reposName, String version, Message message, Integer toClone) throws ApiException {
    apiInstance.addMessage(reposName, version, message, toClone);
  }

  /**
   * Adds an Orchestra repository file
   * 
   * @param repository metadata of an Orchestra file to add
   * @throws ApiException if the API call fails
   */
  public void addRepository(Repository repository) throws ApiException {
    apiInstance.addRepository(repository, null, null);
  }
  
  /**
   * Clones an Orchestra repository file
   * 
   * @param repository metadata of an Orchestra file to add
   * @param nameToClone name of repository to clone
   * @param versionToClone version of repository to clone
   * @throws ApiException if the API call fails
   */
  public void addRepository(Repository repository, String nameToClone, String versionToClone) throws ApiException {
    apiInstance.addRepository(repository, nameToClone, versionToClone);
  }

  /**
   * Deletes a single Code based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet identifier
   * @param codeid Code identifier
   * @throws ApiException if the API call fails
   */
  public void deleteCode(String reposName, String version, Integer codesetid, Integer codeid) throws ApiException {
    apiInstance.deleteCode(reposName, version, codesetid, codeid);
  }

  /**
   * Deletes a single CodeSet based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet identifier
   * @throws ApiException if the API call fails
   */
  public void deleteCodeSet(String reposName, String version, Integer codesetid) throws ApiException {
    apiInstance.deleteCodeSet(reposName, version, codesetid);
  }

  /**
   * Deletes a single Component based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param componentid Component identifier
   * @throws ApiException if the API call fails
   */
  public void deleteComponent(String reposName, String version, Integer componentid) throws ApiException {
    apiInstance.deleteComponent(reposName, version, componentid);
  }

  /**
   * Deletes a single Datatype based on the name supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param name name of a Datatype to delete
   * @throws ApiException if the API call fails
   */
  public void deleteDatatype(String reposName, String version, String name) throws ApiException {
    apiInstance.deleteDatatype(reposName, version, name);
  }

  /**
   * Deletes a single Field based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param fieldid Field identifier
   * @throws ApiException if the API call fails
   */
  public void deleteField(String reposName, String version, Integer fieldid) throws ApiException {
    apiInstance.deleteField(reposName, version, fieldid);
  }

  /**
   * Deletes a single message scenario based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param messageid Message identifier
   * @throws ApiException if the API call fails
   */
  public void deleteMessage(String reposName, String version, Integer messageid) throws ApiException {
    apiInstance.deleteMessage(reposName, version, messageid);
  }

  /**
   * Deletes a single Orchestra repository file based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @throws ApiException if the API call fails
   */
  public void deleteRepository(String reposName, String version) throws ApiException {
    apiInstance.deleteRepository(reposName, version);
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
  public Code findCodeById(String reposName, String version, Integer codesetid, Integer codeid) throws ApiException {
    return apiInstance.findCodeById(reposName, version, codesetid, codeid);
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
  public CodeSet findCodeSetById(String reposName, String version, Integer codesetid) throws ApiException {
    return apiInstance.findCodeSetById(reposName, version, codesetid);
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
  public Component findComponentById(String reposName, String version, Integer componentid) throws ApiException {
    return apiInstance.findComponentById(reposName, version, componentid);
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
  public Datatype findDatatypeByName(String reposName, String version, String name) throws ApiException {
    return apiInstance.findDatatypeByName(reposName, version, name);
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
  public Field findFieldById(String reposName, String version, Integer fieldid) throws ApiException {
    return apiInstance.findFieldById(reposName, version, fieldid);
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
  public Message findMessageById(String reposName, String version, Integer messageid) throws ApiException {
    return apiInstance.findMessageById(reposName, version, messageid);
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
    return apiInstance.findRepositoryById(reposName, version);
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
  public List<CodeSet> searchCodeSets(String reposName, String version, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchCodeSets(reposName, version, searchString, skip, limit);
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
  public List<Code> searchCodes(String reposName, String version, Integer codesetid, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchCodes(reposName, version, codesetid, searchString, skip, limit);
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
  public List<Component> searchComponents(String reposName, String version, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchComponents(reposName, version, searchString, skip, limit);
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
  public List<Datatype> searchDatatypes(String reposName, String version, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchDatatypes(reposName, version, searchString, skip, limit);
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
  public List<Field> searchFields(String reposName, String version, String searchString, Integer skip, Integer limit)
      throws ApiException {
    return apiInstance.searchFields(reposName, version, searchString, skip, limit);
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
  public List<Message> searchMessages(String reposName, String version, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchMessages(reposName, version, searchString, skip, limit);
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
    return apiInstance.searchRepositories(searchString, skip, limit);
  }

  /**
   * Updates a single Code, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet ID
   * @param codeid Code ID
   * @param code Code to update
   * @throws ApiException if the API call fails or the Code is not found
   */
  public void updateCodeById(String reposName, String version, Integer codesetid, Integer codeid, Code code)
      throws ApiException {
    apiInstance.updateCodeById(reposName, version, codesetid, codeid, code);
  }

  /**
   * Updates a single CodeSet, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet ID
   * @param codeSet to update
   * @throws ApiException if the API call fails or the CodeSet is not found
   */
  public void updateCodeSetById(String reposName, String version, Integer codesetid, CodeSet codeSet)
      throws ApiException {
    apiInstance.updateCodeSetById(reposName, version, codesetid, codeSet);
  }

  /**
   * Updates a single Component, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param componentid Component ID
   * @param component to update
   * @throws ApiException if the API call fails or the Component is not found
   */

  public void updateComponentById(String reposName, String version, Integer componentid, Component component)
      throws ApiException {
    apiInstance.updateComponentById(reposName, version, componentid, component);
  }

  /**
   * Updates a single Datatype, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param name Datatype name
   * @param datatype to update
   * @throws ApiException if API call fails or the Datatype is not found
   */
  public void updateDatatypeByName(String reposName, String version, String name, Datatype datatype)
      throws ApiException {
    apiInstance.updateDatatypeByName(reposName, version, name, datatype);
  }

  /**
   * Updates a single Field, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param fieldid Field id
   * @param field to update
   * @throws ApiException if the API call fails or the Field is not found
   */
  public void updateFieldById(String reposName, String version, Integer fieldid, Field field) throws ApiException {
    apiInstance.updateFieldById(reposName, version, fieldid, field);
  }

  /**
   * Updates a single message scenario, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param messageid Message ID
   * @param message to update
   * @throws ApiException if the API call fails or the Message is not found
   */
  public void updateMessageById(String reposName, String version, Integer messageid, Message message) throws ApiException {
    apiInstance.updateMessageById(reposName, version, messageid, message);
  }

  /**
   * Updates Metadata of an Orchestra repository file, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param repository to update
   * @throws ApiException if the API call fails or the Metadata is not found
   */
  public void updateRepositoryById(String reposName, String version, Repository repository) throws ApiException {
    apiInstance.updateRepositoryById(reposName, version, repository);
  }

}
