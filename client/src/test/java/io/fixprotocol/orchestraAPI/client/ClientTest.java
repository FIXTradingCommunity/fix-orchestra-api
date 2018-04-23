/**
 * 
 */
package io.fixprotocol.orchestraAPI.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.fixprotocol.orchestra.ApiClient;
import io.fixprotocol.orchestra.ApiException;
import io.swagger.client.model.Actor;
import io.swagger.client.model.Annotation;
import io.swagger.client.model.Appinfo;
import io.swagger.client.model.Code;
import io.swagger.client.model.CodeSet;
import io.swagger.client.model.Component;
import io.swagger.client.model.ComponentRef;
import io.swagger.client.model.Datatype;
import io.swagger.client.model.Documentation;
import io.swagger.client.model.Field;
import io.swagger.client.model.FieldRef;
import io.swagger.client.model.Flow;
import io.swagger.client.model.Group;
import io.swagger.client.model.GroupProperties;
import io.swagger.client.model.GroupRef;
import io.swagger.client.model.Message;
import io.swagger.client.model.MessageRef;
import io.swagger.client.model.Metadata;
import io.swagger.client.model.ObjectId;
import io.swagger.client.model.Repository;
import io.swagger.client.model.Response;
import io.swagger.client.model.State;
import io.swagger.client.model.StateMachine;
import io.swagger.client.model.Structure;
import io.swagger.client.model.Transition;
import io.swagger.client.model.Trigger;


/**
 * @author Don Mendelson
 *
 */
public class ClientTest {

  private Client client;
  private final Random random = new Random();

  @Test
  public void addActor() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setStructure(new Structure());
    actor.setName("actor1");
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void addFlow() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Flow flow = new Flow();
    flow.setName("flow1");
    client.addFlow("test1", identifier, flow);

    Flow flow2 = client.findFlowByName("test1", identifier, "flow1");
    assertNotNull(flow2);

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void addMessageResponse() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Order");
    oid.setId(14);
    oid.setName("NewOrderSingle");
    message.setOid(oid);
    message.setMsgType("D");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    client.addMessage("test1", identifier, message);

    Response response = new Response();
    response.setName("trade");
    MessageRef messageRef = new MessageRef();
    messageRef.setName("ExecutionReport");
    messageRef.setMsgType("8");
    messageRef.setScenario("trade");
    response.setMessageRef(messageRef);
    client.addMessageResponse("test1", identifier, 14, response);

    Message message2 = client.findMessageById("test1", identifier, 14);
    assertNotNull(message2);

    Response response2 = client.findMessageResponseById("test1", identifier, 14, "trade");
    assertNotNull(response2);
    MessageRef messageRef2 = response2.getMessageRef();
    assertNotNull(messageRef2);

    client.deleteRepository(repository.getName(), identifier);
  }

  @Test
  public void addStateMachine() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setStructure(new Structure());
    actor.setName("actor1");
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);

    StateMachine stateMachine = new StateMachine();
    stateMachine.setName("switch");
    State off = new State();
    off.setName("off");
    stateMachine.setInitial(off);
    List<State> states = new ArrayList<State>();
    State on = new State();
    on.setName("on");
    states.add(on);
    stateMachine.setStates(states);
    client.addStateMachine("test1", identifier, "actor1", stateMachine);

    StateMachine stateMachine2 = client.findStateMachine("test1", identifier, "actor1", "switch");
    assertNotNull(stateMachine2);

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void deleteActor() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setName("actor1");
    actor.setStructure(new Structure());
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);

    client.deleteActor("test1", identifier, "actor1");
    try {
      client.findActorByName("test1", identifier, "actor1");
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void deleteFlow() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Flow flow = new Flow();
    flow.setName("flow1");
    client.addFlow("test1", identifier, flow);

    Flow flow2 = client.findFlowByName("test1", identifier, "flow1");
    assertNotNull(flow2);

    client.deleteFlow("test1", identifier, "flow1");
    try {
      client.deleteFlow("test1", identifier, "flow1");
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void deleteMessageResponse() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Order");
    oid.setId(14);
    oid.setName("NewOrderSingle");
    message.setOid(oid);
    message.setMsgType("D");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    client.addMessage("test1", identifier, message);

    Response response = new Response();
    response.setName("trade");
    MessageRef messageRef = new MessageRef();
    messageRef.setName("ExecutionReport");
    messageRef.setMsgType("8");
    messageRef.setScenario("trade");
    response.setMessageRef(messageRef);
    client.addMessageResponse("test1", identifier, 14, response);

    Message message2 = client.findMessageById("test1", identifier, 14);
    assertNotNull(message2);

    Response response2 = client.findMessageResponseById("test1", identifier, 14, "trade");
    assertNotNull(response2);
    MessageRef messageRef2 = response2.getMessageRef();
    assertNotNull(messageRef2);

    client.deleteMessageResponse("test1", identifier, 14, "trade");

    try {
      client.deleteMessageResponse("test1", identifier, 14, "trade");
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository(repository.getName(), identifier);
  }

  @Test
  public void deleteStateMachine() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setStructure(new Structure());
    actor.setName("actor1");
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);

    StateMachine stateMachine = new StateMachine();
    stateMachine.setName("switch");
    State off = new State();
    off.setName("off");
    stateMachine.setInitial(off);
    List<State> states = new ArrayList<State>();
    State on = new State();
    on.setName("on");
    states.add(on);
    stateMachine.setStates(states);
    client.addStateMachine("test1", identifier, "actor1", stateMachine);

    StateMachine stateMachine2 = client.findStateMachine("test1", identifier, "actor1", "switch");
    assertNotNull(stateMachine2);

    client.deleteStateMachine("test1", identifier, "actor1", "switch");
    try {
      client.findStateMachine("test1", identifier, "actor1", "switch");
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void findActorByName() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setName("actor1");
    actor.setExtends("actor2");
    actor.setStructure(new Structure());
    Annotation annotation = new Annotation();
    Documentation documentation = new Documentation();
    documentation.setLangId("en");
    documentation.setPurpose("ELABORATION");
    documentation.setText("The best actor");
    annotation.addDocumentationItem(documentation );
    Appinfo appinfo = new Appinfo();
    appinfo.setText("my app info");
    annotation.addAppinfoItem(appinfo);
    actor.setAnnotation(annotation);
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);
    assertEquals("actor1", actor2.getName());
       
    Annotation annotation2 = client.searchAnnotations("test1", identifier, "actor1", "actor", null, null, null, null);
    assertNotNull(annotation2);
    assertEquals(1, annotation2.getAppinfo().size());
    assertEquals(1, annotation2.getDocumentation().size());
    Documentation documentation2 = annotation2.getDocumentation().get(0);
    assertEquals("en", documentation2.getLangId());
    assertEquals("ELABORATION", documentation2.getPurpose());
    assertEquals("The best actor", documentation2.getText());
    
    annotation2.getAppinfo().get(0).setSpecURL("http:anywhere.com");
    client.updateAnnotation("test1", identifier, "actor1", "actor", annotation2, null);
    
    Actor actor3 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor3);
    
    client.deleteRepository("test1", identifier);
  }

  @Test
  public void findFlowByName() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Flow flow = new Flow();
    flow.setName("flow1");
    flow.setSource("actor1");
    flow.setDestination("actor2");
    client.addFlow("test1", identifier, flow);

    Flow flow2 = client.findFlowByName("test1", identifier, "flow1");
    assertNotNull(flow2);
    assertEquals("flow1", flow2.getName());
    assertEquals("actor1", flow2.getSource());
    assertEquals("actor2", flow2.getDestination());
    client.deleteRepository("test1", identifier);
  }


  @Test
  public void findMessageResponse() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Order");
    oid.setId(14);
    oid.setName("NewOrderSingle");
    message.setOid(oid);
    message.setMsgType("D");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    client.addMessage("test1", identifier, message);

    Response response = new Response();
    response.setName("trade");
    MessageRef messageRef = new MessageRef();
    messageRef.setName("ExecutionReport");
    messageRef.setMsgType("8");
    messageRef.setScenario("trade");
    response.setMessageRef(messageRef);
    response.setAssign("OrdQty = in.OrdQty");
    client.addMessageResponse("test1", identifier, 14, response);

    Message message2 = client.findMessageById("test1", identifier, 14);
    assertNotNull(message2);

    Response response2 = client.findMessageResponseById("test1", identifier, 14, "trade");
    assertNotNull(response2);
    assertEquals("trade", response2.getName());
    MessageRef messageRef2 = response2.getMessageRef();
    assertNotNull(messageRef2);
    assertEquals("ExecutionReport", messageRef2.getName());
    assertEquals("8", messageRef2.getMsgType());
    assertEquals("trade", messageRef2.getScenario());
    assertNotNull(response2.getAssign());

    client.deleteRepository(repository.getName(), identifier);
  }

  @Test
  public void findStateMachine() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setStructure(new Structure());
    actor.setName("actor1");
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);

    StateMachine stateMachine = new StateMachine();
    stateMachine.setName("switch");
    State off = new State();
    off.setName("off");
    stateMachine.setInitial(off);
    Transition onTransition = new Transition();
    onTransition.setTarget("on");
    off.addTransitionsItem(onTransition);
    List<State> states = new ArrayList<State>();
    State on = new State();
    on.setName("on");
    states.add(on);
    stateMachine.setStates(states);
    client.addStateMachine("test1", identifier, "actor1", stateMachine);

    StateMachine stateMachine2 = client.findStateMachine("test1", identifier, "actor1", "switch");
    assertNotNull(stateMachine2);
    assertEquals("switch", stateMachine2.getName());
    assertEquals("off", stateMachine2.getInitial().getName());
    assertEquals(1, stateMachine2.getInitial().getTransitions().size());
    assertEquals(1, stateMachine2.getStates().size());
    
    client.deleteStateMachine("test1", identifier, "actor1", "switch");

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void searchActors() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setStructure(new Structure());
    actor.setName("actor1");
    client.addActor("test1", identifier, actor);

    List<Actor> actors = client.searchActors("test1", identifier, null, null, null);
    assertEquals(1, actors.size());

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void searchFlows() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Flow flow = new Flow();
    flow.setName("flow1");
    client.addFlow("test1", identifier, flow);

    List<Flow> flows = client.searchFlows("test1", identifier, null, null, null);
    assertEquals(1, flows.size());

    List<Actor> actors = client.searchActors("test1", identifier, null, null, null);
    assertEquals(0, actors.size());

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void searchMessageResponses() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Order");
    oid.setId(14);
    oid.setName("NewOrderSingle");
    message.setOid(oid);
    message.setMsgType("D");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    client.addMessage("test1", identifier, message);

    Response response = new Response();
    response.setName("trade");
    MessageRef messageRef = new MessageRef();
    messageRef.setName("ExecutionReport");
    messageRef.setMsgType("8");
    messageRef.setScenario("trade");
    response.setMessageRef(messageRef);
    client.addMessageResponse("test1", identifier, 14, response);

    Message message2 = client.findMessageById("test1", identifier, 14);
    assertNotNull(message2);

    List<Response> responses =
        client.searchMessageResponses("test1", identifier, 14, null, null, null);
    assertNotNull(responses);
    assertEquals(1, responses.size());
    Response response2 = responses.get(0);
    assertEquals("trade", response2.getName());
    MessageRef messageRef2 = response2.getMessageRef();
    assertNotNull(messageRef2);
    assertEquals("ExecutionReport", messageRef2.getName());
    assertEquals("8", messageRef2.getMsgType());
    assertEquals("trade", messageRef2.getScenario());

    client.deleteRepository(repository.getName(), identifier);
  }

  @Test
  public void searchStateMachines() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setStructure(new Structure());
    actor.setName("actor1");
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);

    StateMachine stateMachine = new StateMachine();
    stateMachine.setName("switch");
    State off = new State();
    off.setName("off");
    stateMachine.setInitial(off);
    List<State> states = new ArrayList<State>();
    State on = new State();
    on.setName("on");
    states.add(on);
    stateMachine.setStates(states);
    client.addStateMachine("test1", identifier, "actor1", stateMachine);

    StateMachine stateMachine2 = new StateMachine();
    stateMachine2.setName("switch2");
    State off2 = new State();
    off2.setName("off");
    stateMachine2.setInitial(off2);
    List<State> states2 = new ArrayList<State>();
    State on2 = new State();
    on2.setName("on");
    states2.add(on2);
    State maybe = new State();
    maybe.setName("maybe");
    states2.add(maybe);
    stateMachine2.setStates(states2);
    client.addStateMachine("test1", identifier, "actor1", stateMachine2);

    List<StateMachine> stateMachines =
        client.searchStateMachines("test1", identifier, "actor1", null, null, null);
    assertEquals(2, stateMachines.size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    final ApiClient apiClient = new ApiClient();
    apiClient.setBasePath("http://localhost:8080/FIXTradingCommunity/orchestra-api/1.0.0");
    // apiClient.setDebugging(true);
    client = new Client(apiClient);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addCode(java.lang.String, java.lang.Integer, io.swagger.client.model.Code)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testAddCode() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    Code code = new Code();
    ObjectId codeOid = new ObjectId();
    codeOid.setId(4001);
    codeOid.setName("Buy");
    code.setOid(codeOid);
    code.setValue("B");
    client.addCode("test1", identifier, 4, code);

    CodeSet codeSet2 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);

    Code code2 = client.findCodeById("test1", identifier, 4, 4001);
    assertNotNull(code2);

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addCodeSet(java.lang.String, io.swagger.client.model.CodeSet)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testAddCodeSet() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    CodeSet codeSet2 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addComponent(java.lang.String, io.swagger.client.model.Component)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testAddComponentStringComponent() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Component component = new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid);
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid);
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid);
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);

    Component component2 = client.findComponentById("test1", identifier, 1003);
    assertNotNull(component2);

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addComponent(java.lang.String, io.swagger.client.model.Component, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testAddComponentStringComponentInteger() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Component component = new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid);
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid);
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid);
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);

    Component component2 = client.findComponentById("test1", identifier, 1003);
    assertNotNull(component2);

    Component component3 = new Component();
    ObjectId oid3 = new ObjectId();
    oid3.setAbbrName("CInstrmt");
    oid3.setId(9003);
    oid3.setName("CInstrument");
    component3.setOid(oid3);
    client.addComponent("test1", identifier, component3, 1003);

    Component component4 = client.findComponentById("test1", identifier, 9003);
    assertNotNull(component4);
    assertEquals(9003, component4.getOid().getId().intValue());
    assertEquals("CInstrument", component4.getOid().getName());
    Structure structure4 = component4.getStructure();
    assertEquals(1, structure4.getFields().size());
    assertEquals(1, structure4.getGroups().size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addDatatype(java.lang.String, io.swagger.client.model.Datatype)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testAddDatatype() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Datatype datatype = new Datatype();
    datatype.setName("UTCDateOnly");
    client.addDatatype("test1", identifier, datatype);

    Datatype datatype2 = client.findDatatypeByName("test1", identifier, "UTCDateOnly");
    assertNotNull(datatype2);
    assertEquals("UTCDateOnly", datatype2.getName());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addField(java.lang.String, io.swagger.client.model.Field)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testAddField() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    final Field field = new Field();
    final ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setAbbrName("Acct");
    oid.setId(1);
    field.setOid(oid);
    client.addField("test1", identifier, field);

    Field field2 = client.findFieldById("test1", identifier, 1);
    assertNotNull(field2);
    assertEquals(field.getOid().getName(), field2.getOid().getName());

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void testAddGroup() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Group group = new Group();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(1007);
    groupOid.setName("LegStipulations");
    group.setOid(groupOid);
    GroupProperties groupProperties = new GroupProperties();
    group.setGroupProperties(groupProperties);
    groupProperties.setNumInGroupId(683);
    groupProperties.setNumInGroupName("NoLegStipulations");
    Structure structure = new Structure();
    group.setStructure(structure);
    client.addGroup("test1", identifier, group);

    Component component2 = client.findComponentById("test1", identifier, 1007);
    assertNotNull(component2);

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addMessage(java.lang.String, io.swagger.client.model.Message)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testAddMessageStringMessage() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("IOI");
    oid.setId(7);
    oid.setName("IOI");
    message.setOid(oid);
    message.setMsgType("6");
    message.setScenario("base");
    message.setCategory("Indication");
    Structure structure = new Structure();
    message.setStructure(structure);
    ComponentRef componentsItem = new ComponentRef();
    ObjectId componentOid = new ObjectId();
    componentOid.setId(1057);
    componentOid.setName("ApplicationSequenceControl");
    componentsItem.setOid(componentOid);
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem);
    client.addMessage("test1", identifier, message);

    Message message2 = client.findMessageById("test1", identifier, 7);
    assertNotNull(message2);

    client.deleteRepository(repository.getName(), identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addMessage(java.lang.String, io.swagger.client.model.Message, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testAddMessageStringMessageInteger() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("IOI");
    oid.setId(7);
    oid.setName("IOI");
    message.setOid(oid);
    message.setMsgType("6");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    ComponentRef componentsItem = new ComponentRef();
    ObjectId componentOid = new ObjectId();
    componentOid.setId(1057);
    componentOid.setName("ApplicationSequenceControl");
    componentsItem.setOid(componentOid);
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem);
    client.addMessage("test1", identifier, message);

    Message message2 = client.findMessageById("test1", identifier, 7);
    assertNotNull(message2);
    assertEquals(7, message2.getOid().getId().intValue());

    ObjectId oid2 = new ObjectId();
    oid2.setAbbrName("CIOI");
    oid2.setId(9007);
    oid2.setName("CIOI");
    message2.setOid(oid2);
    message2.setScenario("Special");
    message2.setExtends("base");
    assertEquals(9007, message2.getOid().getId().intValue());
    client.addMessage("test1", identifier, message2, 7);

    Message message4 = client.findMessageById("test1", identifier, 9007);
    assertNotNull(message4);
    assertEquals(9007, message4.getOid().getId().intValue());
    assertEquals("CIOI", message4.getOid().getName());
    assertEquals("Special", message4.getScenario());
    assertEquals("base", message4.getExtends());

    client.deleteRepository(repository.getName(), identifier);
  }


  @Test
  public void testAddRepository() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void testCloneGroup() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Group group = new Group();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(1007);
    groupOid.setName("LegStipulations");
    group.setOid(groupOid);
    GroupProperties groupProperties = new GroupProperties();
    group.setGroupProperties(groupProperties);
    groupProperties.setNumInGroupId(683);
    groupProperties.setNumInGroupName("NoLegStipulations");
    Structure structure = new Structure();
    group.setStructure(structure);
    client.addGroup("test1", identifier, group);

    Group group2 = client.findGroupById("test1", identifier, 1007);
    assertNotNull(group2);
    ObjectId groupOid2 = new ObjectId();
    groupOid2.setId(9007);
    groupOid2.setName("CLegStipulations");
    group2.setOid(groupOid2);
    client.addGroup("test1", identifier, group2, 1007);

    Group group4 = client.findGroupById("test1", identifier, 9007);
    assertNotNull(group4);
    assertEquals(9007, group4.getOid().getId().intValue());
    assertEquals("CLegStipulations", group4.getOid().getName());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#deleteCode(java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testDeleteCode() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    Code code = new Code();
    ObjectId codeOid = new ObjectId();
    codeOid.setId(4001);
    codeOid.setName("Buy");
    code.setOid(codeOid);
    code.setValue("B");
    client.addCode("test1", identifier, 4, code);

    CodeSet codeSet2 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);

    Code code2 = client.findCodeById("test1", identifier, 4, 4001);
    assertNotNull(code2);

    client.deleteCode("test1", identifier, 4, 4001);
    try {
      client.findCodeById("test1", identifier, 4, 4001);
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#deleteCodeSet(java.lang.String, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testDeleteCodeSet() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    CodeSet codeSet2 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);

    client.deleteCodeSet("test1", identifier, 4);

    try {
      client.findCodeSetById("test1", identifier, 4);
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#deleteComponent(java.lang.String, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testDeleteComponent() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Component component = new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid);
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid);
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid);
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);

    Component component2 = client.findComponentById("test1", identifier, 1003);
    assertNotNull(component2);

    client.deleteComponent("test1", identifier, 1003);

    try {
      client.findComponentById("test1", identifier, 1003);
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#deleteDatatype(java.lang.String, java.lang.String)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testDeleteDatatype() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Datatype datatype = new Datatype();
    datatype.setName("UTCDateOnly");
    client.addDatatype("test1", identifier, datatype);

    Datatype datatype2 = new Datatype();
    datatype2.setName("Price");
    client.addDatatype("test1", identifier, datatype2);

    List<Datatype> datatypes = client.searchDatatypes("test1", identifier, null, null, null);
    assertEquals(2, datatypes.size());

    client.deleteDatatype("test1", identifier, "UTCDateOnly");

    try {
      client.findDatatypeByName("test1", identifier, "UTCDateOnly");
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository("test1", identifier);
  }


  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#deleteField(java.lang.String, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testDeleteField() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    final Field field = new Field();
    final ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setAbbrName("Acct");
    oid.setId(1);
    field.setOid(oid);
    client.addField("test1", identifier, field);

    Field field2 = client.findFieldById("test1", identifier, 1);
    assertNotNull(field2);

    client.deleteField("test1", identifier, 1);

    try {
      client.findFieldById("test1", identifier, 1);
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#deleteMessage(java.lang.String, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testDeleteMessage() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("IOI");
    oid.setId(7);
    oid.setName("IOI");
    message.setOid(oid);
    message.setMsgType("6");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    ComponentRef componentsItem = new ComponentRef();
    ObjectId componentOid = new ObjectId();
    componentOid.setId(1057);
    componentOid.setName("ApplicationSequenceControl");
    componentsItem.setOid(componentOid);
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem);
    client.addMessage("test1", identifier, message);

    Message message2 = client.findMessageById("test1", identifier, 7);
    assertNotNull(message2);
    client.deleteMessage("test1", identifier, 7);

    try {
      client.findMessageById("test1", identifier, 7);
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }

    client.deleteRepository(repository.getName(), identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#deleteRepository(java.lang.String)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testDeleteRepository() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    client.deleteRepository("test1", identifier);

    try {
      client.findRepositoryById("test1", identifier);
      fail("deletion failed");
    } catch (ApiException e) {
      assertEquals(404, e.getCode());
    }
  }

  @Ignore
  @Test
  public void testDownloadRepository() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    Code code = new Code();
    ObjectId codeOid = new ObjectId();
    codeOid.setId(4001);
    codeOid.setName("Buy");
    code.setOid(codeOid);
    code.setValue("B");
    client.addCode("test1", identifier, 4, code);

    File file = client.downloadRepository("test1", identifier);
    assertNotNull(file);

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#findCodeById(java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testFindCodeById() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    Code code = new Code();
    ObjectId codeOid = new ObjectId();
    codeOid.setId(4001);
    codeOid.setName("Buy");
    code.setOid(codeOid);
    code.setValue("B");
    client.addCode("test1", identifier, 4, code);

    CodeSet codeSet2 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);

    Code code2 = client.findCodeById("test1", identifier, 4, 4001);
    assertNotNull(code2);
    assertEquals(code.getOid().getName(), code2.getOid().getName());
    assertEquals(code.getOid().getId(), code2.getOid().getId());
    assertEquals(code.getValue(), code2.getValue());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#findCodeSetById(java.lang.String, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testFindCodeSetById() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    CodeSet codeSet2 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);
    assertEquals(codeSet.getOid().getName(), codeSet2.getOid().getName());
    assertEquals(codeSet.getOid().getId(), codeSet2.getOid().getId());
    assertEquals(codeSet.getType(), codeSet2.getType());
    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#findComponentById(java.lang.String, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testFindComponentById() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Component component = new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid);
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid);
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid);
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);

    Component component2 = client.findComponentById("test1", identifier, 1003);
    assertNotNull(component2);
    assertEquals(1003, component2.getOid().getId().intValue());
    assertEquals("Instrument", component2.getOid().getName());
    Structure structure2 = component2.getStructure();
    assertEquals(1, structure2.getFields().size());
    assertEquals(1, structure2.getGroups().size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#findDatatypeByName(java.lang.String, java.lang.String)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testFindDatatypeByName() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Datatype datatype = new Datatype();
    datatype.setName("UTCDateOnly");
    client.addDatatype("test1", identifier, datatype);

    Datatype datatype2 = client.findDatatypeByName("test1", identifier, "UTCDateOnly");
    assertNotNull(datatype2);
    assertEquals("UTCDateOnly", datatype2.getName());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#findFieldById(java.lang.String, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testFindFieldById() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    final Field field = new Field();
    final ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setAbbrName("Acct");
    oid.setId(1);
    field.setOid(oid);
    client.addField("test1", identifier, field);

    Field field2 = client.findFieldById("test1", identifier, 1);
    assertNotNull(field2);
    assertEquals("Account", field2.getOid().getName());
    assertEquals("Acct", field2.getOid().getAbbrName());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#findMessageById(java.lang.String, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testFindMessageById() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("IOI");
    oid.setId(7);
    oid.setName("IOI");
    message.setOid(oid);
    message.setMsgType("6");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    ComponentRef componentsItem = new ComponentRef();
    ObjectId componentOid = new ObjectId();
    componentOid.setId(1057);
    componentOid.setName("ApplicationSequenceControl");
    componentsItem.setOid(componentOid);
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem);
    client.addMessage("test1", identifier, message);

    Message message2 = client.findMessageById("test1", identifier, 7);
    assertEquals("IOI", message2.getOid().getName());
    assertEquals("base", message2.getScenario());
    Structure structure2 = message2.getStructure();
    List<ComponentRef> components = structure2.getComponents();
    assertEquals(1, components.size());
    List<FieldRef> fields = structure2.getFields();
    assertEquals(1, fields.size());

    client.deleteRepository(repository.getName(), identifier);

  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#findRepositoryById(java.lang.String)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testFindRepositoryById() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    client.findRepositoryById("test1", identifier);

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchCodes(java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testSearchCodes() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    Code code = new Code();
    ObjectId codeOid = new ObjectId();
    codeOid.setId(4001);
    codeOid.setName("Buy");
    code.setOid(codeOid);
    code.setValue("B");
    client.addCode("test1", identifier, 4, code);

    Code code2 = new Code();
    ObjectId codeOid2 = new ObjectId();
    codeOid2.setId(4002);
    codeOid2.setName("Sell");
    code2.setOid(codeOid2);
    code2.setValue("S");
    client.addCode("test1", identifier, 4, code2);

    List<Code> codes = client.searchCodes("test1", identifier, 4, null, null, null);
    assertEquals(2, codes.size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchCodeSets(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testSearchCodeSets() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    CodeSet codeSet2 = new CodeSet();
    ObjectId oid2 = new ObjectId();
    oid2.setId(5);
    oid2.setName("AdvTransTypeCodeSet");
    codeSet2.setOid(oid2);
    codeSet2.setType("String");
    client.addCodeSet("test1", identifier, codeSet2);

    List<CodeSet> codeSets = client.searchCodeSets("test1", identifier, null, null, null);
    assertEquals(2, codeSets.size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchComponents(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testSearchComponents() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Component component = new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid);
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid);
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupRefOid = new ObjectId();
    groupRefOid.setId(2226);
    groupRefOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupRefOid);
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);

    Group group = new Group();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(1007);
    groupOid.setName("LegStipulations");
    group.setOid(groupOid);
    GroupProperties groupProperties = new GroupProperties();
    group.setGroupProperties(groupProperties);
    groupProperties.setNumInGroupId(683);
    groupProperties.setNumInGroupName("NoLegStipulations");
    Structure groupStruct = new Structure();
    group.setStructure(groupStruct);
    client.addGroup("test1", identifier, group);

    List<Component> componentList = client.searchComponents("test1", identifier, null, null, null);
    assertEquals(1, componentList.size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchDatatypes(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testSearchDatatypes() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Datatype datatype = new Datatype();
    datatype.setName("UTCDateOnly");
    client.addDatatype("test1", identifier, datatype);

    Datatype datatype2 = new Datatype();
    datatype2.setName("Price");
    client.addDatatype("test1", identifier, datatype2);

    List<Datatype> datatypes = client.searchDatatypes("test1", identifier, null, null, null);
    assertEquals(2, datatypes.size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchFields(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testSearchFields() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    final Field field = new Field();
    final ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setAbbrName("Acct");
    oid.setId(1);
    field.setOid(oid);
    client.addField("test1", identifier, field);

    final Field field2 = new Field();
    final ObjectId oid2 = new ObjectId();
    oid2.setName("OrderID");
    oid2.setAbbrName("OrdID");
    oid2.setId(37);
    field2.setOid(oid2);
    client.addField("test1", identifier, field2);

    List<Field> fields = client.searchFields("test1", identifier, null, null, null);
    assertEquals(2, fields.size());

    List<Field> fields2 = client.searchFields("test1", identifier, "Acct", null, null);
    assertEquals(1, fields2.size());

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void testSearchGroups() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Component component = new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid);
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid);
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupRefOid = new ObjectId();
    groupRefOid.setId(2226);
    groupRefOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupRefOid);
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);

    Group group = new Group();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(1007);
    groupOid.setName("LegStipulations");
    group.setOid(groupOid);
    GroupProperties groupProperties = new GroupProperties();
    group.setGroupProperties(groupProperties);
    groupProperties.setNumInGroupId(683);
    groupProperties.setNumInGroupName("NoLegStipulations");

    Structure groupStruct = new Structure();
    group.setStructure(groupStruct);

    client.addGroup("test1", identifier, group);

    List<Group> groupList = client.searchGroups("test1", identifier, null, null, null);
    assertEquals(1, groupList.size());

    List<Group> groupList2 =
        client.searchGroups("test1", identifier, "LegStipulations", null, null);
    assertEquals(1, groupList2.size());

    List<Group> groupList3 = client.searchGroups("test1", identifier, "Foo", null, null);
    assertEquals(0, groupList3.size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchMessages(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testSearchMessages() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("IOI");
    oid.setId(7);
    oid.setName("IOI");
    message.setOid(oid);
    message.setMsgType("6");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    ComponentRef componentsItem = new ComponentRef();
    ObjectId componentOid = new ObjectId();
    componentOid.setId(1057);
    componentOid.setName("ApplicationSequenceControl");
    componentsItem.setOid(componentOid);
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem);
    client.addMessage("test1", identifier, message);

    Message message2 = new Message();
    ObjectId oid2 = new ObjectId();
    oid2.setAbbrName("Adv");
    oid2.setId(8);
    oid2.setName("Advertisement");
    message2.setOid(oid2);
    message2.setMsgType("7");
    message2.setScenario("base");
    Structure structure2 = new Structure();
    message2.setStructure(structure2);
    FieldRef fieldsItem2 = new FieldRef();
    ObjectId fieldOid2 = new ObjectId();
    fieldOid2.setId(2);
    fieldOid2.setName("AdvId");
    fieldsItem2.setOid(fieldOid2);
    structure.addFieldsItem(fieldsItem2);
    client.addMessage("test1", identifier, message2);

    List<Message> messages = client.searchMessages("test1", identifier, null, null, null);
    assertEquals(2, messages.size());

    List<Message> messages2 =
        client.searchMessages("test1", identifier, "Advertisement", null, null);
    assertEquals(1, messages2.size());

    client.deleteRepository(repository.getName(), identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchRepositories(java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testSearchRepositories() throws ApiException {
    List<Repository> metadataList = client.searchRepositories(null, null, null);
    assertNotNull(metadataList);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#updateCodeById(java.lang.String, java.lang.Integer, java.lang.Integer, io.swagger.client.model.Code)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testUpdateCodeById() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    Code code = new Code();
    ObjectId codeOid = new ObjectId();
    codeOid.setId(4001);
    codeOid.setName("Buy");
    code.setOid(codeOid);
    code.setValue("B");
    client.addCode("test1", identifier, 4, code);

    CodeSet codeSet2 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);

    Code code2 = client.findCodeById("test1", identifier, 4, 4001);
    assertNotNull(code2);
    code2.setValue("X");

    client.updateCodeById("test1", identifier, 4, 4001, code2);

    Code code3 = client.findCodeById("test1", identifier, 4, 4001);
    assertNotNull(code3);
    assertEquals("X", code3.getValue());

    client.deleteRepository("test1", identifier);

  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#updateCodeSetById(java.lang.String, java.lang.Integer, io.swagger.client.model.CodeSet)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testUpdateCodeSetById() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    client.addCodeSet("test1", identifier, codeSet);

    CodeSet codeSet2 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);
    codeSet2.setType("String");

    client.updateCodeSetById("test1", identifier, 4, codeSet2);

    CodeSet codeSet3 = client.findCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet3);
    assertEquals("String", codeSet3.getType());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#updateComponentById(java.lang.String, java.lang.Integer, io.swagger.client.model.Component)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testUpdateComponentById() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Component component = new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid);
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid);
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid);
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);

    Component component2 = client.findComponentById("test1", identifier, 1003);
    assertNotNull(component2);
    component2.setCategory("Uncommon");

    client.updateComponentById("test1", identifier, 1003, component2);

    Component component3 = client.findComponentById("test1", identifier, 1003);
    assertNotNull(component3);
    assertEquals("Uncommon", component3.getCategory());

    client.deleteRepository("test1", identifier);

  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#updateDatatypeByName(java.lang.String, java.lang.String, io.swagger.client.model.Datatype)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testUpdateDatatypeByName() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Datatype datatype = new Datatype();
    datatype.setName("UTCDateOnly");
    client.addDatatype("test1", identifier, datatype);

    Datatype datatype2 = new Datatype();
    datatype2.setName("Price");
    client.addDatatype("test1", identifier, datatype2);

    List<Datatype> datatypes = client.searchDatatypes("test1", identifier, null, null, null);
    assertEquals(2, datatypes.size());

    datatype2.setBaseType("float");
    client.updateDatatypeByName("test1", identifier, "Price", datatype2);

    Datatype datatype3 = client.findDatatypeByName("test1", identifier, "Price");
    assertEquals("float", datatype3.getBaseType());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#updateFieldById(java.lang.String, java.lang.Integer, io.swagger.client.model.Field)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testUpdateFieldById() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    final Field field = new Field();
    final ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setAbbrName("Acct");
    oid.setId(1);
    field.setOid(oid);
    client.addField("test1", identifier, field);

    field.setCategory("MarketData");
    client.updateFieldById("test1", identifier, 1, field);

    Field field2 = client.findFieldById("test1", identifier, 1);
    assertNotNull(field2);
    assertEquals("MarketData", field2.getCategory());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#updateMessageById(java.lang.String, java.lang.Integer, io.swagger.client.model.Message)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testUpdateMessageById() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("IOI");
    oid.setId(7);
    oid.setName("IOI");
    message.setOid(oid);
    message.setMsgType("6");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    ComponentRef componentsItem = new ComponentRef();
    ObjectId componentOid = new ObjectId();
    componentOid.setId(1057);
    componentOid.setName("ApplicationSequenceControl");
    componentsItem.setOid(componentOid);
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem);
    client.addMessage("test1", identifier, message);

    Message message2 = client.findMessageById("test1", identifier, 7);
    assertNotNull(message2);
    message2.setFlow("Upstream");

    client.updateMessageById("test1", identifier, 7, message2);
    Message message3 = client.findMessageById("test1", identifier, 7);
    assertNotNull(message3);
    assertEquals("Upstream", message3.getFlow());

    client.deleteRepository(repository.getName(), identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#updateRepositoryById(java.lang.String, io.swagger.client.model.Metadata)}.
   * 
   * @throws ApiException
   */
  @Test
  public void testUpdateRepositoryById() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    metadata.setSubject("My subject");
    client.updateRepositoryById("test1", identifier, repository);

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void updateActorByName() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setName("actor1");
    actor.setStructure(new Structure());
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);
    actor2.setExtends("actor2");

    client.updateActorByName("test1", identifier, "actor1", actor2);

    Actor actor3 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor3);
    assertEquals("actor1", actor3.getName());
    assertEquals("actor2", actor3.getExtends());

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void updateFlowByName() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Flow flow = new Flow();
    flow.setName("flow1");
    flow.setSource("actor1");
    flow.setDestination("actor2");
    client.addFlow("test1", identifier, flow);

    Flow flow2 = client.findFlowByName("test1", identifier, "flow1");
    assertNotNull(flow2);
    flow2.setDestination("actor4");

    client.updateFlowByName("test1", identifier, "flow1", flow2);

    Flow flow4 = client.findFlowByName("test1", identifier, "flow1");
    assertNotNull(flow4);

    assertEquals("flow1", flow4.getName());
    assertEquals("actor1", flow4.getSource());
    assertEquals("actor4", flow4.getDestination());

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void updateMessageResponse() throws ApiException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Order");
    oid.setId(14);
    oid.setName("NewOrderSingle");
    message.setOid(oid);
    message.setMsgType("D");
    message.setScenario("base");
    Structure structure = new Structure();
    message.setStructure(structure);
    client.addMessage("test1", identifier, message);

    Response response = new Response();
    response.setName("trade");
    MessageRef messageRef = new MessageRef();
    messageRef.setName("ExecutionReport");
    messageRef.setMsgType("8");
    messageRef.setScenario("trade");
    response.setMessageRef(messageRef);
    client.addMessageResponse("test1", identifier, 14, response);

    Message message2 = client.findMessageById("test1", identifier, 14);
    assertNotNull(message2);

    Response response2 = client.findMessageResponseById("test1", identifier, 14, "trade");
    assertNotNull(response2);
    assertEquals("trade", response2.getName());

    response2.setWhen("match happened");
    Trigger trigger = new Trigger();
    trigger.setActor("a1");
    trigger.setName("t1");
    trigger.setStateMachine("sm1");
    response2.setTrigger(trigger);
    client.updateMessageResponse("test1", identifier, 14, "trade", response2);

    Response response3 = client.findMessageResponseById("test1", identifier, 14, "trade");
    assertNotNull(response3);
    assertEquals("trade", response3.getName());
    assertEquals("match happened", response3.getWhen());
    assertEquals("trade", response3.getName());
    MessageRef messageRef3 = response3.getMessageRef();
    assertNotNull(messageRef3);
    assertEquals("ExecutionReport", messageRef3.getName());
    assertNotNull(response3.getTrigger());

    client.deleteRepository(repository.getName(), identifier);
  }

  @Test
  public void updateStateMachine() throws ApiException {
    final Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    client.addRepository(repository);

    Actor actor = new Actor();
    actor.setStructure(new Structure());
    actor.setName("actor1");
    client.addActor("test1", identifier, actor);

    Actor actor2 = client.findActorByName("test1", identifier, "actor1");
    assertNotNull(actor2);

    StateMachine stateMachine = new StateMachine();
    stateMachine.setName("switch");
    State off = new State();
    off.setName("off");
    stateMachine.setInitial(off);
    Transition onTransition = new Transition();
    onTransition.setTarget("on");
    off.addTransitionsItem(onTransition);
    List<State> states = new ArrayList<State>();
    State on = new State();
    on.setName("on");
    states.add(on);
    stateMachine.setStates(states);
    client.addStateMachine("test1", identifier, "actor1", stateMachine);

    StateMachine stateMachine2 = client.findStateMachine("test1", identifier, "actor1", "switch");
    assertNotNull(stateMachine2);

    State state = stateMachine2.getStates().get(0);
    Transition offTransition = new Transition();
    offTransition.setTarget("off");
    state.addTransitionsItem(offTransition);
    
    client.updateStateMachine("test1", identifier, "actor1", "switch", stateMachine2);

    StateMachine stateMachine3 = client.findStateMachine("test1", identifier, "actor1", "switch");
    assertEquals("switch", stateMachine3.getName());
    assertEquals("off", stateMachine3.getInitial().getName());
    assertEquals(1, stateMachine3.getInitial().getTransitions().size());
    assertEquals(1, stateMachine3.getStates().size());
    assertEquals(1, stateMachine3.getStates().get(0).getTransitions().size());

    client.deleteRepository("test1", identifier);
  }

  @Test
  public void uploadAndDownload() throws ApiException {
    File upfile = new File("FixRepository44.xml");
    client.uploadRepositoryById(upfile );
    client.findRepositoryById("FIX.4.4", "FIX.4.4");
    client.uploadRepositoryForUpdateById(upfile);
    client.findRepositoryById("FIX.4.4", "FIX.4.4");
    File downFile = client.downloadRepository("FIX.4.4", "FIX.4.4");
    System.out.println("Downloaded file: " + downFile.toString());
    
    client.deleteRepository("FIX.4.4", "FIX.4.4");
  }
  
  @Test
  public void uploadAndSearch() throws ApiException {
    File upfile = new File("FixRepository44.xml");
    client.uploadRepositoryById(upfile );
    client.findRepositoryById("FIX.4.4", "FIX.4.4");
    
    List<CodeSet> codeSets = client.searchCodeSets("FIX.4.4", "FIX.4.4", "CorporateAction", null, null);
    assertNotNull(codeSets);
    assertTrue(codeSets.size() >= 1);
    
    List<Component> allComponents = client.searchComponents("FIX.4.4", "FIX.4.4", null, null, null);
    assertNotNull(allComponents);
    List<Component> someComponents = client.searchComponents("FIX.4.4", "FIX.4.4", "Common", null, null);
    assertNotNull(someComponents);
    assertTrue(allComponents.size() > someComponents.size());
    
    List<Field> fields = client.searchFields("FIX.4.4", "FIX.4.4", "CommTyp", null, null);
    assertNotNull(fields);
    assertTrue(fields.size() == 1);

    client.deleteRepository("FIX.4.4", "FIX.4.4");
  }
  
}
