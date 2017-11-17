package io.fixprotocol.orchestraAPI.store.dom;

import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBElement;

import org.purl.dc.elements._1.ObjectFactory;
import org.purl.dc.elements._1.SimpleLiteral;
import org.purl.dc.terms.ElementOrRefinementContainer;

import io.fixprotocol._2016.fixrepository.CodeSetType;
import io.fixprotocol._2016.fixrepository.CodeType;
import io.fixprotocol._2016.fixrepository.ComponentRefType;
import io.fixprotocol._2016.fixrepository.ComponentType;
import io.fixprotocol._2016.fixrepository.FieldRefType;
import io.fixprotocol._2016.fixrepository.FieldType;
import io.fixprotocol._2016.fixrepository.GroupRefType;
import io.fixprotocol._2016.fixrepository.GroupType;
import io.fixprotocol._2016.fixrepository.Repository;
import io.fixprotocol.orchestra.api.RFC3339DateFormat;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.ComponentRef;
import io.fixprotocol.orchestra.model.ElementRef;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.FieldRef;
import io.fixprotocol.orchestra.model.Group;
import io.fixprotocol.orchestra.model.GroupRef;
import io.fixprotocol.orchestra.model.MessageElements;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.ObjectId;


public final class OrchestraAPItoDOM {

  private final static RFC3339DateFormat dateFormat = new RFC3339DateFormat();

  public static CodeSetType CodeSetToDOM(CodeSet codeSet) {
    CodeSetType codeSetType = new CodeSetType();
    codeSetType.setAbbrName(codeSet.getOid().getAbbrName());
    codeSetType.setId(BigInteger.valueOf(codeSet.getOid().getId()));
    codeSetType.setName(codeSet.getOid().getName());
    codeSetType.setOid(codeSet.getOid().getOid());
    codeSetType.setSpecUrl(codeSet.getSpecURL());
    codeSetType.setType(codeSet.getType());
    codeSetType.getCode()
        .addAll(codeSet.getCodes().stream().map(c -> CodeToDOM(c)).collect(Collectors.toList()));
    return codeSetType;
  }

  public static CodeType CodeToDOM(Code code) {
    CodeType codeType = new CodeType();
    codeType.setAbbrName(code.getOid().getAbbrName());
    codeType.setId(BigInteger.valueOf(code.getOid().getId()));
    codeType.setName(code.getOid().getName());
    codeType.setOid(code.getOid().getOid());
    codeType.setValue(code.getValue());
    return codeType;
  }

  public static ComponentType ComponentToDOM(Component component) {
    if (component.getElementType().equals("group")) {
      GroupType groupType = new GroupType();
      Group group = (Group) component;
      groupType.setNumInGroupId(BigInteger.valueOf(group.getNumInGroupId()));
      groupType.setNumInGroupName(group.getNumInGroupName());
      final Integer maxValue = group.getImplMaxOccurs();
      if (maxValue != null) {
        groupType.setImplMaxOccurs(maxValue.toString());
      }
      final Integer minValue = group.getImplMinOccurs();
      if (minValue != null) {
        groupType.setImplMinOccurs(BigInteger.valueOf(minValue));
      }
      populateComponentType(component, groupType);
      return groupType;
    } else {
      ComponentType componentType = new ComponentType();
      populateComponentType(component, componentType);
      return componentType;
    }
  }

  public static io.fixprotocol._2016.fixrepository.Datatype DatatypeToDOM(
      io.fixprotocol.orchestra.model.Datatype datatype) {
    io.fixprotocol._2016.fixrepository.Datatype datatypeDOM =
        new io.fixprotocol._2016.fixrepository.Datatype();
    datatypeDOM.setName(datatype.getName());
    datatypeDOM.setBaseType(datatype.getBaseType());
    return datatypeDOM;
  }

  public static Code DOMToCode(CodeType codeType) {
    Code code = new Code();
    ObjectId oid = new ObjectId();
    oid.setAbbrName(codeType.getAbbrName());
    oid.setId(codeType.getId().intValue());
    oid.setName(codeType.getName());
    oid.setOid(codeType.getOid());
    code.setOid(oid);
    code.setValue(codeType.getValue());
    return code;
  }

  public static CodeSet DOMToCodeSet(CodeSetType codeSetType) {
    CodeSet codeSet = new CodeSet();
    ObjectId oid = new ObjectId();
    oid.setAbbrName(codeSetType.getAbbrName());
    oid.setId(codeSetType.getId().intValue());
    oid.setName(codeSetType.getName());
    oid.setOid(codeSetType.getOid());
    codeSet.setOid(oid);
    codeSet.setSpecURL(codeSetType.getSpecUrl());
    codeSet.setType(codeSetType.getType());
    codeSet.codes(
        codeSetType.getCode().stream().map(ct -> DOMToCode(ct)).collect(Collectors.toList()));
    return codeSet;
  }

  public static Component DOMToComponent(ComponentType componentType) {
    if (componentType instanceof GroupType) {
      GroupType groupType = (GroupType) componentType;
      Group group = new Group();
      group.setElementType("Group");
      group.setNumInGroupId(groupType.getNumInGroupId().intValue());
      group.setNumInGroupName(groupType.getNumInGroupName());
      final String maxValue = groupType.getImplMaxOccurs();
      if (!maxValue.equals("unbounded")) {
        group.setImplMaxOccurs(Integer.parseInt(maxValue));
      }
      final int minValue = groupType.getImplMinOccurs().intValue();
      if (minValue > 0) {
        group.setImplMinOccurs(minValue);
      }
      populateComponent(componentType, group);
      return group;
    } else {
      Component component = new Component();
      component.setElementType("Component");
      populateComponent(componentType, component);
      return component;
    }
  }

  public static io.fixprotocol.orchestra.model.Datatype DOMToDatatype(
      io.fixprotocol._2016.fixrepository.Datatype datatypeDOM) {
    io.fixprotocol.orchestra.model.Datatype datatype =
        new io.fixprotocol.orchestra.model.Datatype();
    datatype.setName(datatypeDOM.getName());
    datatype.setBaseType(datatypeDOM.getBaseType());
    return datatype;
  }

  public static Field DOMToField(FieldType fieldType) {
    Field field = new Field();
    field.setElementType("Field");
    ObjectId oid = new ObjectId();
    oid.setName(fieldType.getName());
    oid.setAbbrName(fieldType.getAbbrName());
    oid.setId(fieldType.getId().intValue());
    field.setOid(oid);
    field.setDatatype(fieldType.getType());
    field.setCategory(fieldType.getBaseCategory());
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
    fieldType.setBaseCategory(field.getCategory());
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

  private static void populateComponent(ComponentType componentType, Component component) {
    ObjectId oid = new ObjectId();
    oid.setAbbrName(componentType.getAbbrName());
    oid.setId(componentType.getId().intValue());
    oid.setName(componentType.getName());
    oid.setOid(componentType.getOid());
    component.setOid(oid);
    component.setCategory(componentType.getCategory());

    MessageElements messageElements = new MessageElements();
    component.setElements(messageElements);
    List<Object> elements = componentType.getComponentRefOrGroupRefOrFieldRef();
    for (Object element : elements) {
      if (element instanceof FieldRefType) {
        FieldRefType fieldRefType = (FieldRefType) element;
        FieldRef fieldRef = new FieldRef();
        fieldRef.elementType("fieldRef");
        ObjectId fieldOid = new ObjectId();
        fieldOid.setAbbrName(fieldRefType.getAbbrName());
        fieldOid.setId(fieldRefType.getId().intValue());
        fieldOid.setName(fieldRefType.getName());
        fieldOid.setOid(fieldRefType.getOid());
        fieldRef.setOid(fieldOid);
        messageElements.add(fieldRef);
      } else if (element instanceof GroupRefType) {
        GroupRefType groupRefType = (GroupRefType) element;
        GroupRef groupRef = new GroupRef();
        groupRef.elementType("groupRef");
        ObjectId groupOid = new ObjectId();
        groupOid.setAbbrName(groupRefType.getAbbrName());
        groupOid.setId(groupRefType.getId().intValue());
        groupOid.setName(groupRefType.getName());
        groupOid.setOid(groupRefType.getOid());
        groupRef.setOid(groupOid);
        messageElements.add(groupRef);
      } else if (element instanceof ComponentRefType) {
        ComponentRefType componentRefType = (ComponentRefType) element;
        ComponentRef componentRef = new ComponentRef();
        componentRef.elementType("componentRef");
        ObjectId componentOid = new ObjectId();
        componentOid.setAbbrName(componentRefType.getAbbrName());
        componentOid.setId(componentRefType.getId().intValue());
        componentOid.setName(componentRefType.getName());
        componentOid.setOid(componentRefType.getOid());
        componentRef.setOid(componentOid);
        messageElements.add(componentRef);
      }
    }
  }

  private static void populateComponentType(Component component, ComponentType componentType) {
    componentType.setAbbrName(component.getOid().getAbbrName());
    componentType.setId(BigInteger.valueOf(component.getOid().getId()));
    componentType.setName(component.getOid().getName());
    componentType.setOid(component.getOid().getOid());
    componentType.setCategory(component.getCategory());

    List<Object> elements = componentType.getComponentRefOrGroupRefOrFieldRef();
    MessageElements messageElements = component.getElements();
    for (ElementRef elementRef : messageElements) {
      if (elementRef instanceof FieldRef) {
        FieldRef fieldRef = (FieldRef) elementRef;
        FieldRefType fieldRefType = new FieldRefType();
        fieldRefType.setAbbrName(fieldRef.getOid().getAbbrName());
        fieldRefType.setId(BigInteger.valueOf(fieldRef.getOid().getId()));
        fieldRefType.setName(fieldRef.getOid().getName());
        fieldRefType.setOid(fieldRef.getOid().getOid());
        elements.add(fieldRefType);
      } else if (elementRef instanceof GroupRef) {
        GroupRef groupRef = (GroupRef) elementRef;
        GroupRefType groupRefType = new GroupRefType();
        groupRefType.setAbbrName(groupRef.getOid().getAbbrName());
        groupRefType.setId(BigInteger.valueOf(groupRef.getOid().getId()));
        groupRefType.setName(groupRef.getOid().getName());
        groupRefType.setOid(groupRef.getOid().getOid());
        elements.add(groupRefType);
      } else if (elementRef instanceof ComponentRef) {
        ComponentRef componentRef = (ComponentRef) elementRef;
        ComponentRefType componentRefType = new ComponentRefType();
        componentRefType.setAbbrName(componentRef.getOid().getAbbrName());
        componentRefType.setId(BigInteger.valueOf(componentRef.getOid().getId()));
        componentRefType.setName(componentRef.getOid().getName());
        componentRefType.setOid(componentRef.getOid().getOid());
        elements.add(componentRefType);
      }
    }

  }

}
