package io.fixprotocol.orchestra.client.api;

import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.model.Annotation;
import io.fixprotocol.orchestra.client.model.ErrorModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DocumentationApi
 */
public class DocumentationApiTest {

    private final DocumentationApi api = new DocumentationApi();

    
    /**
     * adds an Annotation
     *
     * Adds an Annotation
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addAnnotationTest() throws ApiException {
        String reposName = null;
        String version = null;
        String elementId = null;
        String elementType = null;
        Annotation annotation = null;
        // api.addAnnotation(reposName, version, elementId, elementType, annotation);

        // TODO: test validations
    }
    
    /**
     * deletes a single Annotation
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteAnnotationTest() throws ApiException {
        String reposName = null;
        String version = null;
        String elementId = null;
        String elementType = null;
        // api.deleteAnnotation(reposName, version, elementId, elementType);

        // TODO: test validations
    }
    
    /**
     * searches annotations
     *
     * By passing in the appropriate options, you can search for annotations
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchAnnotationsTest() throws ApiException {
        String reposName = null;
        String version = null;
        String elementId = null;
        String elementType = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // Annotation response = api.searchAnnotations(reposName, version, elementId, elementType, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * Updates a single Annotation, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateAnnotationTest() throws ApiException {
        String reposName = null;
        String version = null;
        String elementId = null;
        Annotation annotation = null;
        String elementType = null;
        // api.updateAnnotation(reposName, version, elementId, annotation, elementType);

        // TODO: test validations
    }
    
}