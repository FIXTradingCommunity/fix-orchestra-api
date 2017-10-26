package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Component;
import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Field;
import io.swagger.client.model.Message;
import io.swagger.client.model.Orchestra;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MessagesApi
 */
public class MessagesApiTest {

    private final MessagesApi api = new MessagesApi();

    
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
     * deletes a single message based on the ID supplied
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
     * deletes a single Orchestra file based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteOrchestraTest() throws ApiException {
        String fileid = null;
        // api.deleteOrchestra(fileid);

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
     * Returns a single message, if found
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
     * Updates a single message, if found (idempotent)
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
     * Updates a Orchestra file, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateOrchestraByIdTest() throws ApiException {
        String fileid = null;
        Orchestra orchestra = null;
        // api.updateOrchestraById(fileid, orchestra);

        // TODO: test validations
    }
    
}
