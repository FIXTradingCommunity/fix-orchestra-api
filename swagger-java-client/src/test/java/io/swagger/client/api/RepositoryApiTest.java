package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Code;
import io.swagger.client.model.CodeSet;
import io.swagger.client.model.Component;
import io.swagger.client.model.Datatype;
import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Field;
import io.swagger.client.model.Message;
import io.swagger.client.model.Metadata;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RepositoryApi
 */
public class RepositoryApiTest {

    private final RepositoryApi api = new RepositoryApi();

    
    /**
     * adds a Code to CodeSet
     *
     * Adds a Code
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addCodeTest() throws ApiException {
        String fileid = null;
        String codesetid = null;
        Code code = null;
        // api.addCode(fileid, codesetid, code);

        // TODO: test validations
    }
    
    /**
     * adds a CodeSet
     *
     * Adds a CodeSet
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addCodeSetTest() throws ApiException {
        String fileid = null;
        CodeSet codeSet = null;
        // api.addCodeSet(fileid, codeSet);

        // TODO: test validations
    }
    
    /**
     * adds a component
     *
     * Adds a component
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addComponentTest() throws ApiException {
        String fileid = null;
        Component component = null;
        // api.addComponent(fileid, component);

        // TODO: test validations
    }
    
    /**
     * adds a datatype
     *
     * Adds a datatype
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addDatatypeTest() throws ApiException {
        String fileid = null;
        Datatype datatype = null;
        // api.addDatatype(fileid, datatype);

        // TODO: test validations
    }
    
    /**
     * adds a field
     *
     * Adds a field
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addFieldTest() throws ApiException {
        String fileid = null;
        Field field = null;
        // api.addField(fileid, field);

        // TODO: test validations
    }
    
    /**
     * adds a message scenario
     *
     * Adds a message scenario
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addMessageTest() throws ApiException {
        String fileid = null;
        Message message = null;
        // api.addMessage(fileid, message);

        // TODO: test validations
    }
    
    /**
     * adds an Orchestra repository file
     *
     * Adds an Orchestra repository file
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addRepositoryTest() throws ApiException {
        Metadata repository = null;
        // api.addRepository(repository);

        // TODO: test validations
    }
    
    /**
     * deletes a single Code based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteCodeTest() throws ApiException {
        String fileid = null;
        String codesetid = null;
        Long id = null;
        // api.deleteCode(fileid, codesetid, id);

        // TODO: test validations
    }
    
    /**
     * deletes a single CodeSet based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteCodeSetTest() throws ApiException {
        String fileid = null;
        Long id = null;
        // api.deleteCodeSet(fileid, id);

        // TODO: test validations
    }
    
    /**
     * deletes a single component based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteComponentTest() throws ApiException {
        String fileid = null;
        Long id = null;
        // api.deleteComponent(fileid, id);

        // TODO: test validations
    }
    
    /**
     * deletes a single datatype based on the name supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteDatatypeTest() throws ApiException {
        String fileid = null;
        String name = null;
        // api.deleteDatatype(fileid, name);

        // TODO: test validations
    }
    
    /**
     * deletes a single field based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFieldTest() throws ApiException {
        String fileid = null;
        Long id = null;
        // api.deleteField(fileid, id);

        // TODO: test validations
    }
    
    /**
     * deletes a single message scenario based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteMessageTest() throws ApiException {
        String fileid = null;
        Long id = null;
        // api.deleteMessage(fileid, id);

        // TODO: test validations
    }
    
    /**
     * deletes a single Orchestra repository file based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteRepositoryTest() throws ApiException {
        String fileid = null;
        // api.deleteRepository(fileid);

        // TODO: test validations
    }
    
    /**
     * Returns a single Code, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findCodeByIdTest() throws ApiException {
        String fileid = null;
        String codesetid = null;
        Integer id = null;
        // Code response = api.findCodeById(fileid, codesetid, id);

        // TODO: test validations
    }
    
    /**
     * Returns a single CodeSet, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findCodeSetByIdTest() throws ApiException {
        String fileid = null;
        Integer id = null;
        // CodeSet response = api.findCodeSetById(fileid, id);

        // TODO: test validations
    }
    
    /**
     * Returns a single component, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findComponentByIdTest() throws ApiException {
        String fileid = null;
        Integer id = null;
        // Component response = api.findComponentById(fileid, id);

        // TODO: test validations
    }
    
    /**
     * Returns a single datatype, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findDatatypeByNameTest() throws ApiException {
        String fileid = null;
        String name = null;
        // Datatype response = api.findDatatypeByName(fileid, name);

        // TODO: test validations
    }
    
    /**
     * Returns a single field, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findFieldByIdTest() throws ApiException {
        String fileid = null;
        Integer id = null;
        // Field response = api.findFieldById(fileid, id);

        // TODO: test validations
    }
    
    /**
     * Returns a single message scenario, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findMessageByIdTest() throws ApiException {
        String fileid = null;
        Integer id = null;
        // Message response = api.findMessageById(fileid, id);

        // TODO: test validations
    }
    
    /**
     * Returns a single Orchestra repository file metadata, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findRepositoryByIdTest() throws ApiException {
        String fileid = null;
        // Metadata response = api.findRepositoryById(fileid);

        // TODO: test validations
    }
    
    /**
     * searches CodeSets
     *
     * By passing in the appropriate options, you can search for CodeSets 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchCodeSetsTest() throws ApiException {
        String fileid = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<CodeSet> response = api.searchCodeSets(fileid, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches Codes within a CodeSet
     *
     * By passing in the appropriate options, you can search for Codes 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchCodesTest() throws ApiException {
        String fileid = null;
        String codesetid = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Code> response = api.searchCodes(fileid, codesetid, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches components
     *
     * By passing in the appropriate options, you can search for components 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchComponentsTest() throws ApiException {
        String fileid = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Component> response = api.searchComponents(fileid, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches datatypes
     *
     * By passing in the appropriate options, you can search for datatypes 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchDatatypesTest() throws ApiException {
        String fileid = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Datatype> response = api.searchDatatypes(fileid, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches fields
     *
     * By passing in the appropriate options, you can search for fields 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchFieldsTest() throws ApiException {
        String fileid = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Field> response = api.searchFields(fileid, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches messages
     *
     * By passing in the appropriate options, you can search for messages 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchMessagesTest() throws ApiException {
        String fileid = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Message> response = api.searchMessages(fileid, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches Orchestra repository files
     *
     * By passing in the appropriate options, you can search for Orchestra repository files 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchRepositoryTest() throws ApiException {
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Metadata> response = api.searchRepository(searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * Updates a single Code, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateCodeByIdTest() throws ApiException {
        String fileid = null;
        String codesetid = null;
        Integer id = null;
        Code code = null;
        // api.updateCodeById(fileid, codesetid, id, code);

        // TODO: test validations
    }
    
    /**
     * Updates a single CodeSet, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateCodeSetByIdTest() throws ApiException {
        String fileid = null;
        Integer id = null;
        CodeSet codeSet = null;
        // api.updateCodeSetById(fileid, id, codeSet);

        // TODO: test validations
    }
    
    /**
     * Updates a single component, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateComponentByIdTest() throws ApiException {
        String fileid = null;
        Integer id = null;
        Component component = null;
        // api.updateComponentById(fileid, id, component);

        // TODO: test validations
    }
    
    /**
     * Updates a single datatype, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateDatatypeByNameTest() throws ApiException {
        String fileid = null;
        String name = null;
        Datatype datatype = null;
        // api.updateDatatypeByName(fileid, name, datatype);

        // TODO: test validations
    }
    
    /**
     * Updates a single field, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateFieldByIdTest() throws ApiException {
        String fileid = null;
        Integer id = null;
        Field field = null;
        // api.updateFieldById(fileid, id, field);

        // TODO: test validations
    }
    
    /**
     * Updates a single message scenario, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateMessageByIdTest() throws ApiException {
        String fileid = null;
        Integer id = null;
        Message message = null;
        // api.updateMessageById(fileid, id, message);

        // TODO: test validations
    }
    
    /**
     * Updates an Orchestra repository file, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateRepositoryByIdTest() throws ApiException {
        String fileid = null;
        Metadata repository = null;
        // api.updateRepositoryById(fileid, repository);

        // TODO: test validations
    }
    
}
