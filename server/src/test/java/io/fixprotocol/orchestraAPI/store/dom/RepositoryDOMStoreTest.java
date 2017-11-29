package io.fixprotocol.orchestraAPI.store.dom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import io.fixprotocol.orchestra.model.Actor;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.ComponentRef;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.FieldRef;
import io.fixprotocol.orchestra.model.Flow;
import io.fixprotocol.orchestra.model.GroupRef;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.MessageRef;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.ObjectId;
import io.fixprotocol.orchestra.model.Repository;
import io.fixprotocol.orchestra.model.Response;
import io.fixprotocol.orchestra.model.State;
import io.fixprotocol.orchestra.model.StateMachine;
import io.fixprotocol.orchestra.model.Structure;
import io.fixprotocol.orchestra.model.Transition;
import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;


public class RepositoryDOMStoreTest {

  public static boolean shouldValidate = false;
  private final Random random = new Random();
  private RepositoryDOMStore store;

  @Test
  public void addFindActor() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    Metadata metadata2 = store.createRepository(repository, null, null);

    Actor actor = new Actor();
    actor.setName("actor1");
    actor.setStructure(new Structure());
    store.createActor("test1", identifier, actor);

    Actor actor2 = store.getActor("test1", identifier, "actor1");
    assertEquals("actor1", actor2.getName());

    actor2.setExtends("actor2");

    store.updateActor("test1", identifier, "actor1", actor2);

    Actor actor3 = store.getActor("test1", identifier, "actor1");
    assertNotNull(actor3);
    assertEquals("actor1", actor3.getName());
    assertEquals("actor2", actor3.getExtends());

    store.deleteActor("test1", identifier, "actor1");

    try {
      store.getActor("test1", identifier, "actor1");
      fail("ResourceNotFoundException expected");
    } catch (ResourceNotFoundException e) {

    } catch (Exception e) {
      fail("Wrong exception; ResourceNotFoundException expected");
    }

    store.deleteRepository(repository.getName(), identifier);
  }

  @Test
  public void addFindCode() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    store.createRepository(repository, null, null);

    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setId(4);
    oid.setName("AdvSideCodeSet");
    codeSet.setOid(oid);
    codeSet.setType("char");
    store.createCodeSet("test1", identifier, codeSet);

    Code code = new Code();
    ObjectId codeOid = new ObjectId();
    codeOid.setId(4001);
    codeOid.setName("Buy");
    code.setOid(codeOid);
    code.setValue("B");
    store.createCode("test1", identifier, 4, code);

    CodeSet codeSet2 = store.getCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);
    assertEquals("AdvSideCodeSet", codeSet2.getOid().getName());

    Code code2 = store.getCodeById("test1", identifier, 4, 4001);
    assertNotNull(code2);
    assertEquals("Buy", code2.getOid().getName());
  }

  @Test
  public void addFindComponent() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    store.createRepository(repository, null, null);

    Component component = new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid);
    Structure structure = new Structure();
    component.structure(structure);
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
    store.createComponent("test1", identifier, component, null);

    Component component2 = store.getComponentById("test1", identifier, 1003);
    assertNotNull(component2);
    assertEquals(1003, component2.getOid().getId().intValue());
    assertEquals("Instrument", component2.getOid().getName());
    Structure structure2 = component2.getStructure();
    assertEquals(1, structure2.getFields().size());
    assertEquals(1, structure2.getGroups().size());
    assertEquals(0, structure2.getComponents().size());

    store.deleteRepository(repository.getName(), identifier);
  }

  @Test
  public void addFindFlow() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    Metadata metadata2 = store.createRepository(repository, null, null);

    Flow flow = new Flow();
    flow.setName("flow1");
    flow.setSource("actor1");
    flow.setDestination("actor2");
    store.createFlow("test1", identifier, flow);

    Flow flow2 = store.getFlow("test1", identifier, "flow1");
    assertEquals("flow1", flow2.getName());

    flow2.setDestination("actor4");

    store.updateFlow("test1", identifier, "flow1", flow2);

    Flow flow3 = store.getFlow("test1", identifier, "flow1");
    assertEquals("flow1", flow3.getName());
    assertEquals("actor4", flow3.getDestination());


    store.deleteFlow("test1", identifier, "flow1");

    try {
      store.getFlow("test1", identifier, "flow1");
      fail("ResourceNotFoundException expected");
    } catch (ResourceNotFoundException e) {

    } catch (Exception e) {
      fail("Wrong exception; ResourceNotFoundException expected");
    }

    store.deleteRepository(repository.getName(), identifier);
  };

  @Test
  public void addFindMessage() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    store.createRepository(repository, null, null);

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
    store.createMessage("test1", identifier, message, null);

    Message message2 = store.getMessageById("test1", identifier, 7);
    assertEquals("IOI", message2.getOid().getName());
    assertEquals("base", message2.getScenario());
    Structure structure2 = message2.getStructure();
    List<ComponentRef> components = structure2.getComponents();
    assertEquals(1, components.size());
    List<FieldRef> fields = structure2.getFields();
    assertEquals(1, fields.size());

    store.deleteRepository(repository.getName(), identifier);
  };

  @Test
  public void addFindMessageResponse() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    store.createRepository(repository, null, null);

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
    store.createMessage("test1", identifier, message, null);

    Response response = new Response();
    response.setName("trade");
    MessageRef messageRef = new MessageRef();
    messageRef.setName("ExecutionReport");
    messageRef.setMsgType("8");
    messageRef.setScenario("trade");
    response.setMessageRef(messageRef);
    response.setWhen("match happened");
    store.createMessageResponse("test1", identifier, 14, response);

    Response response2 = store.getMessageResponse("test1", identifier, 14, "trade");
    assertNotNull(response2);
    assertEquals("trade", response2.getName());
    MessageRef messageRef2 = response2.getMessageRef();
    assertNotNull(messageRef2);
    assertEquals("ExecutionReport", messageRef2.getName());

    store.deleteRepository(repository.getName(), identifier);
  };

  @Test
  public void addFindStateMachine() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    Metadata metadata2 = store.createRepository(repository, null, null);

    Actor actor = new Actor();
    actor.setName("actor1");
    actor.setStructure(new Structure());
    store.createActor("test1", identifier, actor);

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
    store.createStateMachine("test1", identifier, "actor1", stateMachine);

    StateMachine stateMachine2 = store.getStateMachine("test1", identifier, "actor1", "switch");
    assertNotNull(stateMachine2);

    State state = stateMachine2.getStates().get(0);
    Transition offTransition = new Transition();
    offTransition.setTarget("off");
    state.addTransitionsItem(offTransition);

    store.updateStateMachine("test1", identifier, "actor1", "switch", stateMachine2);

    StateMachine stateMachine3 = store.getStateMachine("test1", identifier, "actor1", "switch");
    assertNotNull(stateMachine3);
    assertEquals("switch", stateMachine3.getName());
    assertEquals("off", stateMachine3.getInitial().getName());
    assertEquals(1, stateMachine3.getStates().size());
    assertEquals(1, stateMachine3.getStates().get(0).getTransitions().size());

    store.deleteStateMachine("test1", identifier, "actor1", "switch");

    try {
      store.getStateMachine("test1", identifier, "actor1", "switch");
      fail("ResourceNotFoundException expected");
    } catch (ResourceNotFoundException e) {

    } catch (Exception e) {
      fail("Wrong exception; ResourceNotFoundException expected");
    }

    store.deleteRepository(repository.getName(), identifier);
  };

  @Test
  public void addRepository() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);

    Metadata metadata2 = store.createRepository(repository, null, null);
    assertEquals(metadata.getTitle(), metadata2.getTitle());
    assertNotNull(metadata2.getIdentifier());

    store.deleteRepository(repository.getName(), identifier);
  }

  @Test
  public void cloneMessage() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    store.createRepository(repository, null, null);

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
    store.createMessage("test1", identifier, message, null);

    Message message2 = store.getMessageById("test1", identifier, 7);

    ObjectId oid2 = new ObjectId();
    oid2.setAbbrName("CIOI");
    oid2.setId(9007);
    oid2.setName("CIOI");
    message2.setOid(oid2);
    message2.setScenario("Special");
    assertEquals(9007, message2.getOid().getId().intValue());
    store.createMessage("test1", identifier, message2, 7);

    Message message3 = store.getMessageById("test1", identifier, 9007);

    assertEquals("CIOI", message3.getOid().getName());
    assertEquals("Special", message3.getScenario());
    Structure structure3 = message3.getStructure();
    List<ComponentRef> components = structure3.getComponents();
    assertEquals(1, components.size());
    List<FieldRef> fields = structure3.getFields();
    assertEquals(1, fields.size());

    store.deleteRepository(repository.getName(), identifier);
  }


  @Test
  public void cloneRepository() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    store.createRepository(repository, null, null);

    Repository repository2 = new Repository();
    repository2.setName("test1");
    final String identifier2 = Integer.toString(random.nextInt());
    repository2.setVersion(identifier2);
    store.createRepository(repository2, "test1", identifier);
    Metadata metadata2 = store.getRepositoryMetadata("test1", identifier2);
    assertEquals("A test repository", metadata.getDescription());

    List<Metadata> list = store.getRepositoriesMetadata(null);
    assertEquals(2, list.size());

    store.deleteRepository("test1", identifier);
    store.deleteRepository("test1", identifier2);

    list = store.getRepositoriesMetadata(null);
    assertEquals(0, list.size());
  }

  @Test
  public void downloadRepository() throws RepositoryStoreException, SAXException, IOException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);

    Metadata metadata2 = store.createRepository(repository, null, null);

    Field field = new Field();
    ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setId(1);
    field.setOid(oid);
    store.createField("test1", identifier, field);

    Field field2 = store.getFieldById("test1", identifier, 1);
    assertEquals("Account", field2.getOid().getName());

    field.setType("UTCDateOnly");
    field.setCategory("MarketData");
    store.updateField("test1", identifier, 1, field);

    File file = null;
    try {
      file = store.getRepositoryFile("test1", identifier);
      assertNotNull(file);
      // file.deleteOnExit();

      if (shouldValidate) {
        validateXML(file);
      }

      try {
        store.createRepositoryFromFile(file);
        fail("Expected DuplicateKeyException");
      } catch (DuplicateKeyException e) {

      }
    } finally {
      if (file != null) {
        file.delete();
      }
    }

    store.deleteRepository(repository.getName(), identifier);
  }

  @Test(expected = DuplicateKeyException.class)
  public void duplicateRepository() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    store.createRepository(repository, null, null);

    store.createRepository(repository, null, null);
  }

  @Test
  public void getRepository() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);
    Metadata metadata2 = store.createRepository(repository, null, null);

    Metadata metadata3 = store.getRepositoryMetadata("test1", identifier);
    assertEquals("A test repository", metadata3.getDescription());
  }

  @Before
  public void setup() {
    store = new RepositoryDOMStore();
  }

  @Test(expected = ResourceNotFoundException.class)
  public void toCloneNotFound() throws RepositoryStoreException {
    Repository repository = new Repository();
    store.createRepository(repository, "foo", "1");
  }

  @Test
  public void updateRepositoryMetadata() throws RepositoryStoreException {
    Repository repository = new Repository();
    repository.setName("test1");
    final String identifier = Integer.toString(random.nextInt());
    repository.setVersion(identifier);
    repository.setHasComponents(true);
    Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier(identifier);
    repository.setMetadata(metadata);

    store.createRepository(repository, null, null);
    metadata.setSubject("My subject 2");
    store.updateRepositoryMetadata("test1", identifier, repository);

    Metadata metadata2 = store.getRepositoryMetadata("test1", identifier);
    assertEquals(metadata.getSubject(), metadata2.getSubject());

    store.deleteRepository("test1", identifier);
  }

  private void validateXML(File xmlFile) throws SAXException, IOException {
    File schemaFile = new File("xsd/FixRepository2016.xsd");
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(schemaFile);
    Validator validator = schema.newValidator();
    validator.validate(new StreamSource(xmlFile));
  }
}
