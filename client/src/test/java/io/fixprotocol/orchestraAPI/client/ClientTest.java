/**
 * 
 */
package io.fixprotocol.orchestraAPI.client;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.fixprotocol.orchestra.client.ApiClient;
import io.fixprotocol.orchestra.client.ApiException;
import io.fixprotocol.orchestra.client.api.RepositoryApi;
import io.fixprotocol.orchestra.client.model.Metadata;
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
    apiInstance.setApiClient(apiClient );
    client = new Client(apiInstance);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#addCode(java.lang.String, java.lang.Integer, io.swagger.client.model.Code)}.
   */
  @Test
  public void testAddCode() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#addCodeSet(java.lang.String, io.swagger.client.model.CodeSet)}.
   */
  @Test
  public void testAddCodeSet() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#addComponent(java.lang.String, io.swagger.client.model.Component)}.
   */
  @Test
  public void testAddComponentStringComponent() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#addComponent(java.lang.String, io.swagger.client.model.Component, java.lang.Integer)}.
   */
  @Test
  public void testAddComponentStringComponentInteger() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#addDatatype(java.lang.String, io.swagger.client.model.Datatype)}.
   */
  @Test
  public void testAddDatatype() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#addField(java.lang.String, io.swagger.client.model.Field)}.
   */
  @Test
  public void testAddField() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#addMessage(java.lang.String, io.swagger.client.model.Message)}.
   */
  @Test
  public void testAddMessageStringMessage() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#addMessage(java.lang.String, io.swagger.client.model.Message, java.lang.Integer)}.
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
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#deleteCode(java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testDeleteCode() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#deleteCodeSet(java.lang.String, java.lang.Integer)}.
   */
  @Test
  public void testDeleteCodeSet() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#deleteComponent(java.lang.String, java.lang.Integer)}.
   */
  @Test
  public void testDeleteComponent() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#deleteDatatype(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testDeleteDatatype() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#deleteField(java.lang.String, java.lang.Integer)}.
   */
  @Test
  public void testDeleteField() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#deleteMessage(java.lang.String, java.lang.Integer)}.
   */
  @Test
  public void testDeleteMessage() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#deleteRepository(java.lang.String)}.
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

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#findCodeById(java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testFindCodeById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#findCodeSetById(java.lang.String, java.lang.Integer)}.
   */
  @Test
  public void testFindCodeSetById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#findComponentById(java.lang.String, java.lang.Integer)}.
   */
  @Test
  public void testFindComponentById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#findDatatypeByName(java.lang.String, java.lang.String)}.
   */
  @Test
  public void testFindDatatypeByName() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#findFieldById(java.lang.String, java.lang.Integer)}.
   */
  @Test
  public void testFindFieldById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#findMessageById(java.lang.String, java.lang.Integer)}.
   */
  @Test
  public void testFindMessageById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#findRepositoryById(java.lang.String)}.
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
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#searchCodeSets(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testSearchCodeSets() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#searchCodes(java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testSearchCodes() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#searchComponents(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testSearchComponents() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#searchDatatypes(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testSearchDatatypes() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#searchFields(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testSearchFields() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#searchMessages(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)}.
   */
  @Test
  public void testSearchMessages() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#searchRepositories(java.lang.String, java.lang.Integer, java.lang.Integer)}.
   * @throws ApiException 
   */
  @Test
  public void testSearchRepositories() throws ApiException {
    List<Repository> metadataList = client.searchRepositories(null, null, null);
    assertNotNull(metadataList);
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#updateCodeById(java.lang.String, java.lang.Integer, java.lang.Integer, io.swagger.client.model.Code)}.
   */
  @Test
  public void testUpdateCodeById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#updateCodeSetById(java.lang.String, java.lang.Integer, io.swagger.client.model.CodeSet)}.
   */
  @Test
  public void testUpdateCodeSetById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#updateComponentById(java.lang.String, java.lang.Integer, io.swagger.client.model.Component)}.
   */
  @Test
  public void testUpdateComponentById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#updateDatatypeByName(java.lang.String, java.lang.String, io.swagger.client.model.Datatype)}.
   */
  @Test
  public void testUpdateDatatypeByName() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#updateFieldById(java.lang.String, java.lang.Integer, io.swagger.client.model.Field)}.
   */
  @Test
  public void testUpdateFieldById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#updateMessageById(java.lang.String, java.lang.Integer, io.swagger.client.model.Message)}.
   */
  @Test
  public void testUpdateMessageById() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link io.fixprotocol.orchestraAPI.client.Client#updateRepositoryById(java.lang.String, io.swagger.client.model.Metadata)}.
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
