package io.fixprotocol.orchestra.client.api;

import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.model.Actor;
import io.fixprotocol.orchestra.client.model.ErrorModel;
import io.fixprotocol.orchestra.client.model.Flow;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for WorkflowApi
 */
public class WorkflowApiTest {

    private final WorkflowApi api = new WorkflowApi();

    
    /**
     * adds an Actor
     *
     * Adds an Actor
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addActorTest() throws ApiException {
        String reposName = null;
        String version = null;
        Actor actor = null;
        // api.addActor(reposName, version, actor);

        // TODO: test validations
    }
    
    /**
     * adds a Flow
     *
     * Adds a Flow
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addFlowTest() throws ApiException {
        String reposName = null;
        String version = null;
        Flow flow = null;
        // api.addFlow(reposName, version, flow);

        // TODO: test validations
    }
    
    /**
     * deletes a single Actor based on the name supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteActorTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        // api.deleteActor(reposName, version, name);

        // TODO: test validations
    }
    
    /**
     * deletes a single Flow based on the name supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFlowTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        // api.deleteFlow(reposName, version, name);

        // TODO: test validations
    }
    
    /**
     * Returns a single Actor, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findActorByNameTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        // Actor response = api.findActorByName(reposName, version, name);

        // TODO: test validations
    }
    
    /**
     * Returns a single Flow, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findFlowByNameTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        // Flow response = api.findFlowByName(reposName, version, name);

        // TODO: test validations
    }
    
    /**
     * searches actors
     *
     * By passing in the appropriate options, you can search for actors 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchActorsTest() throws ApiException {
        String reposName = null;
        String version = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Actor> response = api.searchActors(reposName, version, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches flows
     *
     * By passing in the appropriate options, you can search for flows 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchFlowsTest() throws ApiException {
        String reposName = null;
        String version = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Flow> response = api.searchFlows(reposName, version, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * Updates a single Actor, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateActorByNameTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        Actor actor = null;
        // api.updateActorByName(reposName, version, name, actor);

        // TODO: test validations
    }
    
    /**
     * Updates a single Flow, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateFlowByNameTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        Flow actor = null;
        // api.updateFlowByName(reposName, version, name, actor);

        // TODO: test validations
    }
    
}
