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
import io.fixprotocol.orchestra.client.model.Datatype;
import io.fixprotocol.orchestra.client.model.Field;
import io.fixprotocol.orchestra.client.model.Metadata;
import io.fixprotocol.orchestra.client.model.ObjectId;
import io.fixprotocol.orchestra.client.model.Repository;


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
   */
  @Test
  public void testAddComponentStringComponent() {
    fail("Not yet implemented");
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addComponent(java.lang.String, io.swagger.client.model.Component, java.lang.Integer)}.
   */
  @Test
  public void testAddComponentStringComponentInteger() {
    fail("Not yet implemented");
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
    field.setElementType("Field");
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
   */
  @Test
  public void testAddMessageStringMessage() {
    fail("Not yet implemented");
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#addMessage(java.lang.String, io.swagger.client.model.Message, java.lang.Integer)}.
   */
  @Test
  public void testAddMessageStringMessageInteger() {
    fail("Not yet implemented");
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
   */
  @Test
  public void testDeleteComponent() {
    fail("Not yet implemented");
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
    field.setElementType("Field");
    final ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setAbbrName("Acct");
    oid.setId(1);
    field.setOid(oid);
    client.addField("test1", identifier, field);

    Field field2 = client.findFieldById("test1", identifier, 1);
    field2.setElementType("Field");
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
   */
  @Test
  public void testDeleteMessage() {
    fail("Not yet implemented");
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
   */
  @Test
  public void testFindComponentById() {
    fail("Not yet implemented");
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
    field.setElementType("Field");
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
   */
  @Test
  public void testFindMessageById() {
    fail("Not yet implemented");
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
   */
  @Test
  public void testSearchComponents() {
    fail("Not yet implemented");
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
    field.setElementType("Field");
    final ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setAbbrName("Acct");
    oid.setId(1);
    field.setOid(oid);
    client.addField("test1", identifier, field);

    final Field field2 = new Field();
    field2.setElementType("Field");
    final ObjectId oid2 = new ObjectId();
    oid2.setName("OrderID");
    oid2.setAbbrName("OrdID");
    oid2.setId(37);
    field2.setOid(oid2);
    client.addField("test1", identifier, field2);

    List<Field> fields = client.searchFields("test1", identifier, null, null, null);
    assertEquals(2, fields.size());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#searchMessages(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testSearchMessages() {
    fail("Not yet implemented");
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
   */
  @Test
  public void testUpdateComponentById() {
    fail("Not yet implemented");
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
    field.setElementType("Field");
    final ObjectId oid = new ObjectId();
    oid.setName("Account");
    oid.setAbbrName("Acct");
    oid.setId(1);
    field.setOid(oid);
    client.addField("test1", identifier, field);

    field.setCategory("MarketData");
    client.updateFieldById("test1", identifier, 1, field);

    Field field2 = client.findFieldById("test1", identifier, 1);
    field2.setElementType("Field");
    assertNotNull(field2);
    assertEquals("MarketData", field2.getCategory());

    client.deleteRepository("test1", identifier);
  }

  /**
   * Test method for
   * {@link io.fixprotocol.orchestraAPI.client.Client#updateMessageById(java.lang.String, java.lang.Integer, io.swagger.client.model.Message)}.
   */
  @Test
  public void testUpdateMessageById() {
    fail("Not yet implemented");
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
