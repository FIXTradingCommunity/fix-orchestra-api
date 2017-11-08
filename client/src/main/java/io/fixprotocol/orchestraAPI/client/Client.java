package io.fixprotocol.orchestraAPI.client;

import java.util.List;

import io.swagger.client.ApiException;
import io.swagger.client.api.RepositoryApi;
import io.swagger.client.model.Code;
import io.swagger.client.model.CodeSet;
import io.swagger.client.model.Component;
import io.swagger.client.model.Datatype;
import io.swagger.client.model.Field;
import io.swagger.client.model.Message;
import io.swagger.client.model.Metadata;

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
  public void addCode(String fileid, Integer codesetid, Code code) throws ApiException {
    apiInstance.addCode(fileid, codesetid, code);
  }

  /**
   * Adds a CodeSet
   * 
   * @param fileid Orchestra repository file identifier
   * @param codeSet to add
   * @throws ApiException if the API call fails
   */
  public void addCodeSet(String fileid, CodeSet codeSet) throws ApiException {
    apiInstance.addCodeSet(fileid, codeSet);
  }

  /**
   * Adds a Component
   * 
   * @param fileid Orchestra repository file identifier
   * @param component to add
   * @throws ApiException if the API call fails
   */
  public void addComponent(String fileid, Component component) throws ApiException {
    apiInstance.addComponent(fileid, component, null);
  }

  /**
   * Clones a Component
   * 
   * @param fileid Orchestra repository file identifier
   * @param component to add
   * @param toClone ID of component to clone
   * @throws ApiException if the API call fails
   */
  public void addComponent(String fileid, Component component, Integer toClone) throws ApiException {
    apiInstance.addComponent(fileid, component, toClone);
  }
  
  /**
   * Adds a Datatype
   * 
   * @param fileid Orchestra repository file identifier
   * @param datatype to add
   * @throws ApiException if the API call fails
   */
  public void addDatatype(String fileid, Datatype datatype) throws ApiException {
    apiInstance.addDatatype(fileid, datatype);
  }

  /**
   * Adds a Field
   * 
   * @param fileid Orchestra repository file identifier
   * @param field to add
   * @throws ApiException if the API call fails
   */
  public void addField(String fileid, Field field) throws ApiException {
    apiInstance.addField(fileid, field);
  }

  /**
   * Adds a message scenario
   * 
   * @param fileid Orchestra repository file identifier
   * @param message to add
   * @throws ApiException if the API call fails
   */
  public void addMessage(String fileid, Message message) throws ApiException {
    apiInstance.addMessage(fileid, message, null);
  }
  
  /**
   * Clones a message scenario
   * 
   * @param fileid Orchestra repository file identifier
   * @param message to add
   * @param toClone ID of message to clone
   * @throws ApiException if the API call fails
   */
  public void addMessage(String fileid, Message message, Integer toClone) throws ApiException {
    apiInstance.addMessage(fileid, message, toClone);
  }

  /**
   * Adds an Orchestra repository file
   * 
   * @param repository metadata of an Orchestra file to add
   * @throws ApiException if the API call fails
   */
  public void addRepository(Metadata repository) throws ApiException {
    apiInstance.addRepository(repository, null);
  }
  
  /**
   * Clones an Orchestra repository file
   * 
   * @param repository metadata of an Orchestra file to add
   * @param toClone file ID of repository to clone
   * @throws ApiException if the API call fails
   */
  public void addRepository(Metadata repository, String toClone) throws ApiException {
    apiInstance.addRepository(repository, toClone);
  }

  /**
   * Deletes a single Code based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet identifier
   * @param codeid Code identifier
   * @throws ApiException if the API call fails
   */
  public void deleteCode(String fileid, Integer codesetid, Integer codeid) throws ApiException {
    apiInstance.deleteCode(fileid, codesetid, codeid);
  }

  /**
   * Deletes a single CodeSet based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet identifier
   * @throws ApiException if the API call fails
   */
  public void deleteCodeSet(String fileid, Integer codesetid) throws ApiException {
    apiInstance.deleteCodeSet(fileid, codesetid);
  }

  /**
   * Deletes a single Component based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param componentid Component identifier
   * @throws ApiException if the API call fails
   */
  public void deleteComponent(String fileid, Integer componentid) throws ApiException {
    apiInstance.deleteComponent(fileid, componentid);
  }

  /**
   * Deletes a single Datatype based on the name supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param name name of a Datatype to delete
   * @throws ApiException if the API call fails
   */
  public void deleteDatatype(String fileid, String name) throws ApiException {
    apiInstance.deleteDatatype(fileid, name);
  }

  /**
   * Deletes a single Field based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param fieldid Field identifier
   * @throws ApiException if the API call fails
   */
  public void deleteField(String fileid, Integer fieldid) throws ApiException {
    apiInstance.deleteField(fileid, fieldid);
  }

  /**
   * Deletes a single message scenario based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @param messageid Message identifier
   * @throws ApiException if the API call fails
   */
  public void deleteMessage(String fileid, Integer messageid) throws ApiException {
    apiInstance.deleteMessage(fileid, messageid);
  }

  /**
   * Deletes a single Orchestra repository file based on the ID supplied
   * 
   * @param fileid Orchestra repository file identifier
   * @throws ApiException if the API call fails
   */
  public void deleteRepository(String fileid) throws ApiException {
    apiInstance.deleteRepository(fileid);
  }

  /**
   * Returns a single Code, if found
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet identifier
   * @param codeid Code identifier
   * @return a Code
   * @throws ApiException if the API call fails or the Code is not found
   */
  public Code findCodeById(String fileid, Integer codesetid, Integer codeid) throws ApiException {
    return apiInstance.findCodeById(fileid, codesetid, codeid);
  }

  /**
   * Returns a single CodeSet, if found
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet identifier
   * @return a CodeSet
   * @throws ApiException if the API call fails or the CodeSet is not found
   */
  public CodeSet findCodeSetById(String fileid, Integer codesetid) throws ApiException {
    return apiInstance.findCodeSetById(fileid, codesetid);
  }

  /**
   * Returns a single Component, if found
   * 
   * @param fileid Orchestra repository file identifier
   * @param componentid Component identifier
   * @return a Component
   * @throws ApiException if the API call fails or the CodeSet is not found
   */
  public Component findComponentById(String fileid, Integer componentid) throws ApiException {
    return apiInstance.findComponentById(fileid, componentid);
  }

  /**
   * Returns a single Datatype, if found
   * 
   * @param fileid Orchestra repository file identifier
   * @param name name of a Datatype
   * @return a Datatype
   * @throws ApiException if the API call fails or the Datatype is not found
   */
  public Datatype findDatatypeByName(String fileid, String name) throws ApiException {
    return apiInstance.findDatatypeByName(fileid, name);
  }

  /**
   * Returns a single Field, if found
   * 
   * @param fileid Orchestra repository file identifier
   * @param fieldid Field identifier
   * @return a Field
   * @throws ApiException if the API call fails or the Field is not found
   */
  public Field findFieldById(String fileid, Integer fieldid) throws ApiException {
    return apiInstance.findFieldById(fileid, fieldid);
  }

  /**
   * Returns a single message scenario, if found
   * 
   * @param fileid Orchestra repository file identifier
   * @param messageid Message identifier
   * @return a Message
   * @throws ApiException if the API call fails or the Message is not found
   */
  public Message findMessageById(String fileid, Integer messageid) throws ApiException {
    return apiInstance.findMessageById(fileid, messageid);
  }

  /**
   * Returns a single Orchestra repository file Metadata, if found
   * 
   * @param fileid Orchestra repository file identifier
   * @return a Metadata
   * @throws ApiException if the API call fails or the Metadata is not found
   */
  public Metadata findRepositoryById(String fileid) throws ApiException {
    return apiInstance.findRepositoryById(fileid);
  }

  /**
   * searches CodeSets
   *
   * By passing in the appropriate options, you can search for CodeSets
   * 
   * @param fileid ID of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up CodeSets (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;CodeSet&gt;
   * @throws ApiException if the API call fails
   */
  public List<CodeSet> searchCodeSets(String fileid, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchCodeSets(fileid, searchString, skip, limit);
  }

  /**
   * searches Codes within a CodeSet
   *
   * By passing in the appropriate options, you can search for Codes
   * 
   * @param fileid ID of Orchestra repository file (required)
   * @param codesetid CodeSet identifier
   * @param searchString pass an optional search string for looking up Codes (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Code&gt;
   * @throws ApiException if the API call fails
   */
  public List<Code> searchCodes(String fileid, Integer codesetid, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchCodes(fileid, codesetid, searchString, skip, limit);
  }

  /**
   * searches Components
   *
   * By passing in the appropriate options, you can search for Components
   * 
   * @param fileid ID of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up Components (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Component&gt;
   * @throws ApiException if the API call fails
   */
  public List<Component> searchComponents(String fileid, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchComponents(fileid, searchString, skip, limit);
  }

  /**
   * searches Datatypes
   *
   * By passing in the appropriate options, you can search for Datatypes
   * 
   * @param fileid ID of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up Datatypes (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Datatype&gt;
   * @throws ApiException if the API call fails
   */
  public List<Datatype> searchDatatypes(String fileid, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchDatatypes(fileid, searchString, skip, limit);
  }

  /**
   * searches Fields
   *
   * By passing in the appropriate options, you can search for Fields
   * 
   * @param fileid ID of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up Fields (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Field&gt;
   * @throws ApiException if the API call fails
   */
  public List<Field> searchFields(String fileid, String searchString, Integer skip, Integer limit)
      throws ApiException {
    return apiInstance.searchFields(fileid, searchString, skip, limit);
  }

  /**
   * searches Messages
   *
   * By passing in the appropriate options, you can search for Messages
   * 
   * @param fileid ID of Orchestra repository file (required)
   * @param searchString pass an optional search string for looking up Messages (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Message&gt;
   * @throws ApiException if the API call fails
   */
  public List<Message> searchMessages(String fileid, String searchString, Integer skip,
      Integer limit) throws ApiException {
    return apiInstance.searchMessages(fileid, searchString, skip, limit);
  }

  /**
   * searches Orchestra repository files
   *
   * By passing in the appropriate options, you can search for Orchestra repository files
   * 
   * @param searchString pass an optional search string for looking up Metadata (optional)
   * @param skip number of records to skip for pagination (optional)
   * @param limit maximum number of records to return (optional)
   * @return List&lt;Metadata&gt;
   * @throws ApiException if the API call fails
   */

  public List<Metadata> searchRepositories(String searchString, Integer skip, Integer limit)
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
  public void updateCodeById(String fileid, Integer codesetid, Integer codeid, Code code)
      throws ApiException {
    apiInstance.updateCodeById(fileid, codesetid, codeid, code);
  }

  /**
   * Updates a single CodeSet, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param codesetid CodeSet ID
   * @param codeSet to update
   * @throws ApiException if the API call fails or the CodeSet is not found
   */
  public void updateCodeSetById(String fileid, Integer codesetid, CodeSet codeSet)
      throws ApiException {
    apiInstance.updateCodeSetById(fileid, codesetid, codeSet);
  }

  /**
   * Updates a single Component, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param componentid Component ID
   * @param component to update
   * @throws ApiException if the API call fails or the Component is not found
   */

  public void updateComponentById(String fileid, Integer componentid, Component component)
      throws ApiException {
    apiInstance.updateComponentById(fileid, componentid, component);
  }

  /**
   * Updates a single Datatype, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param name Datatype name
   * @param datatype to update
   * @throws ApiException if API call fails or the Datatype is not found
   */
  public void updateDatatypeByName(String fileid, String name, Datatype datatype)
      throws ApiException {
    apiInstance.updateDatatypeByName(fileid, name, datatype);
  }

  /**
   * Updates a single Field, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param fieldid Field id
   * @param field to update
   * @throws ApiException if the API call fails or the Field is not found
   */
  public void updateFieldById(String fileid, Integer fieldid, Field field) throws ApiException {
    apiInstance.updateFieldById(fileid, fieldid, field);
  }

  /**
   * Updates a single message scenario, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param messageid Message ID
   * @param message to update
   * @throws ApiException if the API call fails or the Message is not found
   */
  public void updateMessageById(String fileid, Integer messageid, Message message) throws ApiException {
    apiInstance.updateMessageById(fileid, messageid, message);
  }

  /**
   * Updates Metadata of an Orchestra repository file, if found (idempotent)
   * 
   * @param fileid Orchestra repository file identifier
   * @param repository to update
   * @throws ApiException if the API call fails or the Metadata is not found
   */
  public void updateRepositoryById(String fileid, Metadata repository) throws ApiException {
    apiInstance.updateRepositoryById(fileid, repository);
  }

}
