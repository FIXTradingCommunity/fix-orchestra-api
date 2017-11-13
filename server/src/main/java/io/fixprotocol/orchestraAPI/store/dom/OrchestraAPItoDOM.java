package io.fixprotocol.orchestraAPI.store.dom;

import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.purl.dc.elements._1.ObjectFactory;
import org.purl.dc.elements._1.SimpleLiteral;
import org.purl.dc.terms.ElementOrRefinementContainer;

import io.fixprotocol._2016.fixrepository.FieldType;
import io.fixprotocol._2016.fixrepository.Repository;
import io.fixprotocol.orchestra.api.RFC3339DateFormat;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.ObjectId;


public final class OrchestraAPItoDOM {

  private final static RFC3339DateFormat dateFormat = new RFC3339DateFormat();

  public static Field DOMToField(FieldType fieldType) {
    Field field = new Field();
    ObjectId oid = new ObjectId();
    field.setOid(oid);
    oid.setName(fieldType.getName());
    oid.setAbbrName(fieldType.getAbbrName());
    oid.setId(fieldType.getId().intValue());
    field.setDatatype(fieldType.getType());
    return field;
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
            metadata.setDate(
                dateFormat.parse(value).toInstant().atZone(ZoneId.of("UTC")).toLocalDate());
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
        case "subject":
          metadata.setSubject(value);
          break;
        case "title":
          metadata.setTitle(value);
          break;
      }
    });
    return metadata;
  }

  public static FieldType FieldToDOM(Field field) {
    FieldType fieldType = new FieldType();
    fieldType.setId(BigInteger.valueOf(field.getOid().getId()));
    fieldType.setName(field.getOid().getName());
    fieldType.setAbbrName(field.getOid().getAbbrName());
    fieldType.setType(field.getDatatype());
    return fieldType;
  }

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
    LocalDate date = metadata.getDate();
    if (date != null) {
      SimpleLiteral dateLiteral = new SimpleLiteral();
      dateLiteral.getContent()
          .add(dateFormat.format(Date.from(date.atStartOfDay(ZoneId.of("UTC")).toInstant())));
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
    String subject = metadata.getSubject();
    if (subject != null) {
      SimpleLiteral literal = new SimpleLiteral();
      literal.getContent().add(subject);
      literals.add(objectFactory.createSubject(literal));
    }
    String title = metadata.getTitle();
    if (title != null) {
      SimpleLiteral literal = new SimpleLiteral();
      literal.getContent().add(title);
      literals.add(objectFactory.createTitle(literal));
    }
    // Date valid = metadata.getValid();
    // if (valid != null) {
    // SimpleLiteral literal = new SimpleLiteral();
    // literal.getContent().add(valid.toString());
    // literals.add(objectFactory.createValid(literal));
    // }
    // SimpleLiteral contributor = new SimpleLiteral();
    // contributor.getContent().add("RepositoryCompressor");
    // literals.add(objectFactory.createContributor(contributor));
    return container;
  }

  public static io.fixprotocol._2016.fixrepository.Repository RepositoryToDOM(
      io.fixprotocol.orchestra.model.Repository repository) {
    Repository repositoryDOM = new Repository();
    repositoryDOM.setName(repository.getName());
    repositoryDOM.setVersion(repository.getVersion());
    repositoryDOM.setHasComponents(repository.getHasComponents());
    repositoryDOM.setNamespace(repository.getNamespace());
    repositoryDOM.setGuid(repository.getOid());
    repositoryDOM.setSpecUrl(repository.getSpecURL());
    if (repository.getMetadata() != null) {
      repositoryDOM.setMetadata(MetadataToDOM(repository.getMetadata()));
    }
    return repositoryDOM;
  }
}
