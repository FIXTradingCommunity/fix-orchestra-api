package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Field;
import io.swagger.client.model.Message;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    
    /**
     * 
     *
     * deletes a single field based on the ID supplied
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFieldTest() throws ApiException {
        Long id = null;
        // api.deleteField(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * deletes a single message based on the ID supplied
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteMessageTest() throws ApiException {
        Long id = null;
        // api.deleteMessage(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Returns a single field, if found
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findFieldByIdTest() throws ApiException {
        Integer id = null;
        // Field response = api.findFieldById(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Returns a single message, if found
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findMessageByIdTest() throws ApiException {
        Integer id = null;
        // Message response = api.findMessageById(id);

        // TODO: test validations
    }
    
}
