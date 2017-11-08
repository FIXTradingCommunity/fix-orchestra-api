package io.fixprotocol.orchestraAPI.store.dom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.xml.bind.JAXBElement;

import org.purl.dc.elements._1.ObjectFactory;
import org.purl.dc.elements._1.SimpleLiteral;
import org.purl.dc.terms.ElementOrRefinementContainer;

import io.swagger.model.Metadata;

public final class OrchestraAPItoDOM {

  public static ElementOrRefinementContainer MetadataToDOM(Metadata metadata) {
    ElementOrRefinementContainer container = new ElementOrRefinementContainer();
    List<JAXBElement<SimpleLiteral>> literals = container.getAny();
    ObjectFactory objectFactory = new ObjectFactory();

    String coverage = metadata.getCoverage();
    if (coverage != null) {
      SimpleLiteral literal = new SimpleLiteral();
      literal.getContent().add(coverage);
      literals.add(objectFactory.createCoverage(literal));
    }   
    String creator = metadata.getCreator();
    if (creator != null) {
      SimpleLiteral literal = new SimpleLiteral();
      literal.getContent().add(creator);
      literals.add(objectFactory.createCreator(literal));
    }    
    Date date = metadata.getDate();
    if (date != null) {
      SimpleLiteral dateLiteral = new SimpleLiteral();
      dateLiteral.getContent().add(DateFormat.getDateInstance().format(date));
      literals.add(objectFactory.createDate(dateLiteral)); 
    }
    String description = metadata.getDescription();
    if (description != null) {
      SimpleLiteral literal = new SimpleLiteral();
      literal.getContent().add(description);
      literals.add(objectFactory.createDescription(literal));
    }
    String identifier = metadata.getIdentifier();
    if (identifier != null) {
      SimpleLiteral idLiteral = new SimpleLiteral();
      idLiteral.getContent().add(identifier);
      literals.add(objectFactory.createIdentifier(idLiteral)); 
    }
    String publisher = metadata.getPublisher();
    if (publisher != null) {
      SimpleLiteral literal = new SimpleLiteral();
      literal.getContent().add(publisher);
      literals.add(objectFactory.createPublisher(literal));
    } 
    String title = metadata.getTitle();
    if (title != null) {
      SimpleLiteral literal = new SimpleLiteral();
      literal.getContent().add(title);
      literals.add(objectFactory.createTitle(literal));
    }    
//    Date valid = metadata.getValid();
//    if (valid != null) {
//      SimpleLiteral literal = new SimpleLiteral();
//      literal.getContent().add(valid.toString());
//      literals.add(objectFactory.createValid(literal));
//    } 
//    SimpleLiteral contributor = new SimpleLiteral();
//    contributor.getContent().add("RepositoryCompressor");
//    literals.add(objectFactory.createContributor(contributor));
    return container;
  }

  public static Metadata DOMToMetadata(ElementOrRefinementContainer element) {
    Metadata metadata = new Metadata();
    List<JAXBElement<SimpleLiteral>> literals = element.getAny();
    literals.forEach(l -> {
      String name = l.getName().getLocalPart();
      String value = l.getValue().getContent().get(0);
      switch (name) {
        case "coverage":
          metadata.setCoverage(value);
          break;
        case "creator":
          metadata.setCreator(value);
          break;
        case "description":
          metadata.setDescription(value);
          break;
        case "date":
          try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            metadata.setDate(sdf.parse(value));
          } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          break;
        case "identifier":
          metadata.setIdentifier(value);
          break;
        case "publisher":
          metadata.setPublisher(value);
          break;
        case "title":
          metadata.setTitle(value);
          break;
      }
    });
    return metadata;
  }
}
