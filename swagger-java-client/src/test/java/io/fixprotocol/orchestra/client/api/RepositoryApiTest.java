package io.fixprotocol.orchestra.client.api;

import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.model.Code;
import io.fixprotocol.orchestra.client.model.CodeSet;
import io.fixprotocol.orchestra.client.model.Component;
import io.fixprotocol.orchestra.client.model.Datatype;
import io.fixprotocol.orchestra.client.model.ErrorModel;
import io.fixprotocol.orchestra.client.model.Field;
import io.fixprotocol.orchestra.client.model.Message;
import io.fixprotocol.orchestra.client.model.Repository;
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
        String reposName = null;
        String version = null;
        Integer codesetid = null;
        Code code = null;
        // api.addCode(reposName, version, codesetid, code);

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
        String reposName = null;
        String version = null;
        CodeSet codeSet = null;
        // api.addCodeSet(reposName, version, codeSet);

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
        String reposName = null;
        String version = null;
        Component component = null;
        Integer toClone = null;
        // api.addComponent(reposName, version, component, toClone);

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
        String reposName = null;
        String version = null;
        Datatype datatype = null;
        // api.addDatatype(reposName, version, datatype);

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
        String reposName = null;
        String version = null;
        Field field = null;
        // api.addField(reposName, version, field);

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
        String reposName = null;
        String version = null;
        Message message = null;
        Integer toClone = null;
        // api.addMessage(reposName, version, message, toClone);

        // TODO: test validations
    }
    
    /**
     * adds an Orchestra repository
     *
     * Adds an Orchestra repository
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addRepositoryTest() throws ApiException {
        Repository repository = null;
        String nameToClone = null;
        String versionToClone = null;
        // api.addRepository(repository, nameToClone, versionToClone);

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
        String reposName = null;
        String version = null;
        Integer codesetid = null;
        Integer id = null;
        // api.deleteCode(reposName, version, codesetid, id);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        // api.deleteCodeSet(reposName, version, id);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        // api.deleteComponent(reposName, version, id);

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
        String reposName = null;
        String version = null;
        String name = null;
        // api.deleteDatatype(reposName, version, name);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        // api.deleteField(reposName, version, id);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        // api.deleteMessage(reposName, version, id);

        // TODO: test validations
    }
    
    /**
     * deletes a single Orchestra repository  based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteRepositoryTest() throws ApiException {
        String reposName = null;
        String version = null;
        // api.deleteRepository(reposName, version);

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
        String reposName = null;
        String version = null;
        Integer codesetid = null;
        Integer id = null;
        // Code response = api.findCodeById(reposName, version, codesetid, id);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        // CodeSet response = api.findCodeSetById(reposName, version, id);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        // Component response = api.findComponentById(reposName, version, id);

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
        String reposName = null;
        String version = null;
        String name = null;
        // Datatype response = api.findDatatypeByName(reposName, version, name);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        // Field response = api.findFieldById(reposName, version, id);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        // Message response = api.findMessageById(reposName, version, id);

        // TODO: test validations
    }
    
    /**
     * Returns a single Orchestra repository metadata, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findRepositoryByIdTest() throws ApiException {
        String reposName = null;
        String version = null;
        // Repository response = api.findRepositoryById(reposName, version);

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
        String reposName = null;
        String version = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<CodeSet> response = api.searchCodeSets(reposName, version, searchString, skip, limit);

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
        String reposName = null;
        String version = null;
        Integer codesetid = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Code> response = api.searchCodes(reposName, version, codesetid, searchString, skip, limit);

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
        String reposName = null;
        String version = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Component> response = api.searchComponents(reposName, version, searchString, skip, limit);

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
        String reposName = null;
        String version = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Datatype> response = api.searchDatatypes(reposName, version, searchString, skip, limit);

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
        String reposName = null;
        String version = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Field> response = api.searchFields(reposName, version, searchString, skip, limit);

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
        String reposName = null;
        String version = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Message> response = api.searchMessages(reposName, version, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches Orchestra repositories
     *
     * By passing in the appropriate options, you can search for Orchestra repositories
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchRepositoriesTest() throws ApiException {
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Repository> response = api.searchRepositories(searchString, skip, limit);

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
        String reposName = null;
        String version = null;
        Integer codesetid = null;
        Integer id = null;
        Code code = null;
        // api.updateCodeById(reposName, version, codesetid, id, code);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        CodeSet codeSet = null;
        // api.updateCodeSetById(reposName, version, id, codeSet);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        Component component = null;
        // api.updateComponentById(reposName, version, id, component);

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
        String reposName = null;
        String version = null;
        String name = null;
        Datatype datatype = null;
        // api.updateDatatypeByName(reposName, version, name, datatype);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        Field field = null;
        // api.updateFieldById(reposName, version, id, field);

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
        String reposName = null;
        String version = null;
        Integer id = null;
        Message message = null;
        // api.updateMessageById(reposName, version, id, message);

        // TODO: test validations
    }
    
    /**
     * Updates an Orchestra repository, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateRepositoryByIdTest() throws ApiException {
        String reposName = null;
        String version = null;
        Repository repository = null;
        // api.updateRepositoryById(reposName, version, repository);

        // TODO: test validations
    }
    
}
