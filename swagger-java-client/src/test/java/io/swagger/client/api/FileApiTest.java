package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Orchestra;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FileApi
 */
public class FileApiTest {

    private final FileApi api = new FileApi();

    
    /**
     * adds an Orchestra file
     *
     * Adds an Orchestra file
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addOrchestraTest() throws ApiException {
        Orchestra orchestra = null;
        // api.addOrchestra(orchestra);

        // TODO: test validations
    }
    
    /**
     * Returns a single Orchestra file metadata, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findOrchestraByIdTest() throws ApiException {
        String fileid = null;
        // Orchestra response = api.findOrchestraById(fileid);

        // TODO: test validations
    }
    
    /**
     * searches Orchestra files
     *
     * By passing in the appropriate options, you can search for Orchestra files 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchOrchestraTest() throws ApiException {
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Orchestra> response = api.searchOrchestra(searchString, skip, limit);

        // TODO: test validations
    }
    
}
