package io.fixprotocol.orchestraAPI.store.dom;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import io.fixprotocol._2016.fixrepository.Annotation;
import io.fixprotocol._2016.fixrepository.Appinfo;
import io.fixprotocol._2016.fixrepository.Documentation;


public class OrchestraAPItoDOMTest {

  @Test
  public void testAnnotationToDOM() {
    io.fixprotocol.orchestra.model.Annotation annotation = new io.fixprotocol.orchestra.model.Annotation();
    io.fixprotocol.orchestra.model.Documentation documentation = new io.fixprotocol.orchestra.model.Documentation();
    documentation.setLangId("en");
    documentation.setPurpose("SYNOPSIS");
    documentation.setText("The best actor");
    annotation.addDocumentationItem(documentation );
    io.fixprotocol.orchestra.model.Appinfo appinfo = new io.fixprotocol.orchestra.model.Appinfo();
    appinfo.setLangId("en");
    appinfo.setPurpose("SYNOPSIS");
    appinfo.setText("my app info");
    annotation.addAppinfoItem(appinfo);
    Annotation annotationDOM = OrchestraAPItoDOM.AnnotationToDOM(annotation);
    List<Object> objects = annotationDOM.getDocumentationOrAppinfo();
    assertEquals(2, objects.size());
  }

  @Test
  public void testDOMToAnnotation() {
    Annotation annotationDOM = new Annotation();
    List<Object> objects = annotationDOM.getDocumentationOrAppinfo();
    Documentation documentation = new Documentation();
    documentation.setLangId("en");
    documentation.setPurpose("SYNOPSIS");
    documentation.getContent().add("The best actor");
    objects.add(documentation );
    Appinfo appinfo = new Appinfo();
    appinfo.setLangId("en");
    appinfo.setPurpose("SYNOPSIS");
    appinfo.setContent("my app info");
    objects.add(appinfo);
    io.fixprotocol.orchestra.model.Annotation annotation = OrchestraAPItoDOM.DOMToAnnotation(annotationDOM);
    assertEquals(1, annotation.getAppinfo().size());
    assertEquals(1, annotation.getDocumentation().size());
  }

}
