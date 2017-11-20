/**
 * 
 */
package io.fixprotocol.orchestraAPI.client;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.fixprotocol.orchestra.client.ApiClient;
import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.api.RepositoryApi;
import io.fixprotocol.orchestra.client.model.Code;
import io.fixprotocol.orchestra.client.model.CodeSet;
import io.fixprotocol.orchestra.client.model.Component;
import io.fixprotocol.orchestra.client.model.Datatype;
import io.fixprotocol.orchestra.client.model.Field;
import io.fixprotocol.orchestra.client.model.FieldRef;
import io.fixprotocol.orchestra.client.model.Group;
import io.fixprotocol.orchestra.client.model.GroupProperties;
import io.fixprotocol.orchestra.client.model.GroupRef;
import io.fixprotocol.orchestra.client.model.Metadata;
import io.fixprotocol.orchestra.client.model.ObjectId;
import io.fixprotocol.orchestra.client.model.Repository;
import io.fixprotocol.orchestra.client.model.Structure;
import io.fixprotocol.orchestra.client.model.ComponentRef;
import io.fixprotocol.orchestra.client.model.Message;


/**
 * @author Don Mendelson
 *
 */
public class ClientTest {

  private Client client;
  private final Random random = new Random();

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    final RepositoryApi apiInstance = new RepositoryApi();
    final ApiClient apiClient = new ApiClient();
    apiClient.setBasePath("http://localhost:8080/FIXTradingCommunity/orchestra-api/1.0.0");
    // apiClient.setDebugging(true);
    apiInstance.setApiClient(apiClient);
    client = new Client(apiInstance);
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

    Component component =  new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid );
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid );
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid =  new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid );
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);

    Component component2 = client.findComponentById("test1", identifier, 1003);
    assertNotNull(component2);

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
    group.setGroupProperties(groupProperties );
    groupProperties.setNumInGroupId(683);
    groupProperties.setNumInGroupName("NoLegStipulations");
    Structure structure = new Structure();
    group.setStructure(structure );
    client.addGroup("test1", identifier, group);

    Component component2 = client.findComponentById("test1", identifier, 1007);
    assertNotNull(component2);

    client.deleteRepository("test1", identifier);
  }
  
  @Ignore // need to fix find group
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
    group.setGroupProperties(groupProperties );
    groupProperties.setNumInGroupId(683);
    groupProperties.setNumInGroupName("NoLegStipulations");
    Structure structure = new Structure();
    group.setStructure(structure );
    client.addGroup("test1", identifier, group);

    Group group2 = (Group) client.findComponentById("test1", identifier, 1007);
    assertNotNull(group2);
    ObjectId groupOid2 = new ObjectId();
    groupOid2.setId(9007);
    groupOid2.setName("CLegStipulations");
    group2.setOid(groupOid2);
    client.addGroup("test1", identifier, group2, 1007);
    
    Group group4 = (Group) client.findComponentById("test1", identifier, 9007);
    assertNotNull(group4);
    assertEquals(9007, group4.getOid().getId().intValue());
    assertEquals("CLegStipulations", group4.getOid().getName());

    client.deleteRepository("test1", identifier);
  }


  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addComponent(java.lang.String, io.swagger.client.model.Component, java.lang.Integer)}.
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

    Component component =  new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid );
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid );
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid =  new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid );
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

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addMessage(java.lang.String, io.swagger.client.model.Message)}.
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
    Structure structure = new Structure();
    message.setStructure(structure);
    ComponentRef componentsItem = new ComponentRef();
    ObjectId componentOid = new ObjectId();
    componentOid.setId(1057);
    componentOid.setName("ApplicationSequenceControl");
    componentsItem.setOid(componentOid );
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem );
    client.addMessage("test1", identifier, message);
    
    Message message2 = client.findMessageById("test1", identifier, 7);
    assertNotNull(message2);
    
    client.deleteRepository(repository.getName(), identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addMessage(java.lang.String, io.swagger.client.model.Message, java.lang.Integer)}.
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
    componentsItem.setOid(componentOid );
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem );
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
    assertEquals(9007, message2.getOid().getId().intValue());
    client.addMessage("test1", identifier, message2, 7);
    
    Message message4 = client.findMessageById("test1", identifier, 9007);  
    assertNotNull(message4);
    assertEquals(9007, message4.getOid().getId().intValue());
    assertEquals("CIOI", message4.getOid().getName());
    assertEquals("Special", message4.getScenario());
    
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

    Component component =  new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid );
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid );
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid =  new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid );
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
    componentsItem.setOid(componentOid );
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem );
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

  @Ignore // the file is downloaded, but ApiClient is bypassing the code to get filename from Content-Disposition header
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

    Component component =  new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid );
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid );
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid =  new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid );
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
    componentsItem.setOid(componentOid );
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem );
    client.addMessage("test1", identifier, message);
    
    Message message2 = client.findMessageById("test1", identifier, 7);
    assertEquals("IOI" , message2.getOid().getName());
    assertEquals("base" , message2.getScenario());
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

    Component component =  new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid );
    Structure structure = new Structure();
    component.setStructure(structure);
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid );
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupRefOid =  new ObjectId();
    groupRefOid.setId(2226);
    groupRefOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupRefOid );
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);
    
    Group group = new Group();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(1007);
    groupOid.setName("LegStipulations");
    group.setOid(groupOid);
    GroupProperties groupProperties = new GroupProperties();
    group.setGroupProperties(groupProperties );
    groupProperties.setNumInGroupId(683);
    groupProperties.setNumInGroupName("NoLegStipulations");
    Structure groupStruct = new Structure();
    group.setStructure(groupStruct);
    client.addGroup("test1", identifier, group);

    List<Component> componentList = client.searchComponents("test1", identifier, null, null, null);
    assertEquals(1, componentList.size());

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

    Component component =  new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid );
    Structure structure = new Structure();
    component.setStructure(structure );
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid );
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupRefOid =  new ObjectId();
    groupRefOid.setId(2226);
    groupRefOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupRefOid );
    structure.addGroupsItem(groupRef);
    client.addComponent("test1", identifier, component);
    
    Group group = new Group();
    ObjectId groupOid = new ObjectId();
    groupOid.setId(1007);
    groupOid.setName("LegStipulations");
    group.setOid(groupOid);
    GroupProperties groupProperties = new GroupProperties();
    group.setGroupProperties(groupProperties );
    groupProperties.setNumInGroupId(683);
    groupProperties.setNumInGroupName("NoLegStipulations");
    
    Structure groupStruct = new Structure();
    group.setStructure(groupStruct);

    client.addGroup("test1", identifier, group);

    List<Group> groupList = client.searchGroups("test1", identifier, null, null, null);
    assertEquals(1, groupList.size());

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

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchMessages(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
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
    componentsItem.setOid(componentOid );
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem );
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
    
    List<Message> messages2 = client.searchMessages("test1", identifier, "Advertisement", null, null);
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

    Component component =  new Component();
    ObjectId oid = new ObjectId();
    oid.setAbbrName("Instrmt");
    oid.setId(1003);
    oid.setName("Instrument");
    component.setCategory("Common");
    component.setOid(oid );
    Structure structure = new Structure();
    component.setStructure(structure );
    FieldRef fieldRef = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setName("SecurityID");
    fieldOid.setId(48);
    fieldRef.setOid(fieldOid );
    structure.addFieldsItem(fieldRef);
    GroupRef groupRef = new GroupRef();
    ObjectId groupOid =  new ObjectId();
    groupOid.setId(2226);
    groupOid.setName("SecondaryAssetGrp");
    groupRef.setOid(groupOid );
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
    componentsItem.setOid(componentOid );
    structure.addComponentsItem(componentsItem);
    FieldRef fieldsItem = new FieldRef();
    ObjectId fieldOid = new ObjectId();
    fieldOid.setId(23);
    fieldOid.setName("IOIID");
    fieldsItem.setOid(fieldOid);
    structure.addFieldsItem(fieldsItem );
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

}
