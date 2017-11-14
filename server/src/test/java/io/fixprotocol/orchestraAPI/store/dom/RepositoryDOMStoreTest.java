package io.fixprotocol.orchestraAPI.store.dom;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.ObjectId;
import io.fixprotocol.orchestra.model.Repository;
import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;


public class RepositoryDOMStoreTest {

  private RepositoryDOMStore store;
  private final Random random = new Random();
  
  @Before
  public void setup() {
    store = new RepositoryDOMStore();
  }

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
    store.createCode("test1", identifier, 4, code );
    
    CodeSet codeSet2 = store.getCodeSetById("test1", identifier, 4);
    assertNotNull(codeSet2);
    assertEquals("AdvSideCodeSet", codeSet2.getOid().getName());
    
    Code code2 = store.getCodeById("test1", identifier, 4, 4001);
    assertNotNull(code2);
    assertEquals("Buy", code2.getOid().getName());
  }
  
  
  @Test
  public void addFindField() throws RepositoryStoreException {
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
    
    field.setDatatype("UTCDateOnly");
    field.setCategory("MarketData");
    store.updateField("test1", identifier, 1, field);
    
    field2 = store.getFieldById("test1", identifier, 1);
    assertEquals("Account", field2.getOid().getName());
    assertEquals("UTCDateOnly", field2.getDatatype());
    assertEquals("MarketData", field2.getCategory());
    
    store.deleteField("test1", identifier, 1);
    
    try {
      store.getFieldById("test1", identifier, 1);
      fail("ResourceNotFoundException expected");
    } catch (ResourceNotFoundException e) {
      
    } catch (Exception e) {
      fail("Wrong exception; ResourceNotFoundException expected");
    }

    store.deleteRepository(repository.getName(), identifier);
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

  @Test(expected = ResourceNotFoundException.class)
  public void toCloneNotFound() throws RepositoryStoreException {
    Repository repository = new Repository();
    store.createRepository(repository, "foo", "1");
  }

}
