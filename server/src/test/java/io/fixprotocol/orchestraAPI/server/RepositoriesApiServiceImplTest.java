package io.fixprotocol.orchestraAPI.server;
 
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.fixprotocol.orchestra.api.NotFoundException;
import io.fixprotocol.orchestra.model.Actor;
import io.fixprotocol.orchestra.model.Annotation;
import io.fixprotocol.orchestra.model.Appinfo;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Documentation;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Structure;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.Repository;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreFactory;

public class RepositoriesApiServiceImplTest {
  private RepositoriesApiServiceImpl impl;

  @Before
  public void setUp() throws Exception {
    RepositoryStoreFactory storeFactory = new RepositoryStoreFactory();
    impl = new RepositoriesApiServiceImpl(storeFactory.getRepositoryStore());
    
    final Repository repository = new Repository();
    repository.setName("repos1");
    repository.setVersion("999");
    repository.setHasComponents(true);
    final Metadata metadata = new Metadata();
    metadata.description("A test repository");
    metadata.identifier("999");
    repository.setMetadata(metadata);
    impl.addRepository(repository, null, null, null);
  }

  @Test
  public void testSearchAnnotationsStringStringStringStringStringStringIntegerIntegerSecurityContext() throws NotFoundException {
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
    impl.addActor("repos1", "999", actor, null);
    
    Response response = impl.searchAnnotations("repos1", "999", "actor1", "actor", null, null, null, null, null);
    Object entity = response.getEntity();
    assertNotNull(entity);
    assertTrue(entity instanceof Annotation);
    Annotation annotation2 = (Annotation)entity;
    assertNotNull(annotation2);
    assertEquals(1, annotation2.getAppinfo().size());
    assertEquals(1, annotation2.getDocumentation().size());
    Documentation documentation2 = annotation2.getDocumentation().get(0);
    assertEquals("en", documentation2.getLangId());
    assertEquals("ELABORATION", documentation2.getPurpose());
    assertEquals("The best actor", documentation2.getText());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void uploadAndSearch() throws NotFoundException, FileNotFoundException {
    impl.uploadRepositoryById(new FileInputStream("FixRepository44.xml"), 
        null, null);
   
    Response response = impl.searchCodeSets("FIX.4.4", "FIX.4.4", "CorporateAction", null, null, null);
    Object codeSets = response.getEntity();
    assertNotNull(codeSets);
    assertTrue(((List<CodeSet>)codeSets).size() >= 1);
    
    response = impl.searchComponents("FIX.4.4", "FIX.4.4", null, null, null, null);
    Object allComponents = response.getEntity();
    assertNotNull(allComponents);
    response = impl.searchComponents("FIX.4.4", "FIX.4.4", "Common", null, null, null);
    Object someComponents = response.getEntity();
    assertNotNull(someComponents);
    assertTrue(((List<Component>)allComponents).size() > ((List<Component>)someComponents).size());
    
    response = impl.searchFields("FIX.4.4", "FIX.4.4", "CommTyp", null, null, null);
    Object fields = response.getEntity();
    assertNotNull(fields);
    assertTrue(((List<Field>)fields).size() == 1);

    impl.deleteRepository("FIX.4.4", "FIX.4.4", null);
  }

}
