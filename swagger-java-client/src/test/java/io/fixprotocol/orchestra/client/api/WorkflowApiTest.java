package io.fixprotocol.orchestra.client.api;

import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.model.Actor;
import io.fixprotocol.orchestra.client.model.ErrorModel;
import io.fixprotocol.orchestra.client.model.Flow;
import io.fixprotocol.orchestra.client.model.Response;
import io.fixprotocol.orchestra.client.model.StateMachine;
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
     * adds a response to a message scenario
     *
     * Adds a message scenario response
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addMessageResponseTest() throws ApiException {
        String reposName = null;
        String version = null;
        Integer id = null;
        Response response = null;
        // api.addMessageResponse(reposName, version, id, response);

        // TODO: test validations
    }
    
    /**
     * adds a state machine
     *
     * Adds a StateMachine
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addStateMachineTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        StateMachine stateMachine = null;
        // api.addStateMachine(reposName, version, name, stateMachine);

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
     * deletes a single response to a message scenario based on the ID supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteMessageResponseTest() throws ApiException {
        String reposName = null;
        String version = null;
        Integer id = null;
        String name = null;
        // api.deleteMessageResponse(reposName, version, id, name);

        // TODO: test validations
    }
    
    /**
     * deletes a single StateMachine based on the name supplied
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteStateMachineTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        String smName = null;
        // api.deleteStateMachine(reposName, version, name, smName);

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
     * Returns a single response to a message scenario, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findMessageResponseByIdTest() throws ApiException {
        String reposName = null;
        String version = null;
        Integer id = null;
        String name = null;
        // Response response = api.findMessageResponseById(reposName, version, id, name);

        // TODO: test validations
    }
    
    /**
     * Returns a single StateMachine, if found
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findStateMachineTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        String smName = null;
        // StateMachine response = api.findStateMachine(reposName, version, name, smName);

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
     * searches message responses
     *
     * By passing in the appropriate options, you can search for message responses
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchMessageResponsesTest() throws ApiException {
        String reposName = null;
        String version = null;
        Integer id = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<Response> response = api.searchMessageResponses(reposName, version, id, searchString, skip, limit);

        // TODO: test validations
    }
    
    /**
     * searches state machines
     *
     * By passing in the appropriate options, you can search for state machines
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchStateMachinesTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        // List<StateMachine> response = api.searchStateMachines(reposName, version, name, searchString, skip, limit);

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
    
    /**
     * Updates a single response to a message scenario, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateMessageResponseTest() throws ApiException {
        String reposName = null;
        String version = null;
        Integer id = null;
        String name = null;
        Response response = null;
        // api.updateMessageResponse(reposName, version, id, name, response);

        // TODO: test validations
    }
    
    /**
     * Updates a single StateMachine, if found (idempotent)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateStateMachineTest() throws ApiException {
        String reposName = null;
        String version = null;
        String name = null;
        String smName = null;
        StateMachine stateMachine = null;
        // api.updateStateMachine(reposName, version, name, smName, stateMachine);

        // TODO: test validations
    }
    
}
