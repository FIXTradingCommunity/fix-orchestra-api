package io.fixprotocol.orchestraAPI.store.dom;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;
import io.swagger.model.Metadata;

public class RepositoryDOMStoreTest {

  private RepositoryDOMStore store;
  
  @Before
  public void setup() {
    store = new RepositoryDOMStore();
  }

  @Test
  public void addRepository() throws RepositoryStoreException {
    Metadata metadata = new Metadata();
    metadata.setTitle("My repository 1");
    Metadata metadata2 = store.addRepository(metadata, null);
    assertEquals(metadata.getTitle(), metadata2.getTitle());
    assertNotNull(metadata2.getIdentifier());

    store.deleteRepository(metadata2.getIdentifier());
  }

  @Test
  public void cloneRepository() throws RepositoryStoreException {
    Metadata metadata = new Metadata();
    metadata.setTitle("My repository 1");
    Metadata metadata2 = store.addRepository(metadata, null);
    String id2 = metadata2.getIdentifier();
    Metadata metadata3 = new Metadata();
    metadata3.setTitle("My repository 2");
    Metadata metadata4 = store.addRepository(metadata3, id2);
    assertNotNull(metadata3);
    assertNotEquals(id2, metadata4.getIdentifier());

    List<Metadata> list = store.getRepositories(null);
    assertEquals(2, list.size());

    store.deleteRepository(metadata2.getIdentifier());
    store.deleteRepository(metadata4.getIdentifier());

    list = store.getRepositories(null);
    assertEquals(0, list.size());
  }

  @Test(expected = DuplicateKeyException.class)
  public void duplicateRepository() throws RepositoryStoreException {
    Metadata metadata = new Metadata();
    metadata.setTitle("My repository 1");
    Metadata metadata2 = store.addRepository(metadata, null);
    Metadata metadata3 = new Metadata();
    metadata3.identifier(metadata2.getIdentifier());
    store.addRepository(metadata3, null);

    store.deleteRepository(metadata2.getIdentifier());
  }

  @Test
  public void getRepository() throws RepositoryStoreException {
    Metadata metadata = new Metadata();
    metadata.setTitle("My repository 1");
    Metadata metadata2 = store.addRepository(metadata, null);
    assertEquals(metadata.getTitle(), metadata2.getTitle());
    assertNotNull(metadata2.getIdentifier());

    Metadata metadata3 = store.getRepository(metadata2.getIdentifier());
    assertEquals(metadata2.getIdentifier(), metadata3.getIdentifier());
  }

  @Test(expected = ResourceNotFoundException.class)
  public void toCloneNotFound() throws RepositoryStoreException {
    Metadata metadata = new Metadata();
    metadata.setTitle("My repository 1");
    store.addRepository(metadata, "foobar");
  }

}
