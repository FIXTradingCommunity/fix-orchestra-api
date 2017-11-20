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
import io.fixprotocol._2016.fixrepository.MessageType;
import io.fixprotocol._2016.fixrepository.Repository;
import io.fixprotocol.orchestra.api.RFC3339DateFormat;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.ComponentRef;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.FieldRef;
import io.fixprotocol.orchestra.model.Group;
import io.fixprotocol.orchestra.model.GroupProperties;
import io.fixprotocol.orchestra.model.GroupRef;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.ObjectId;
import io.fixprotocol.orchestra.model.Structure;


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
    if (component instanceof Group) {
      GroupType groupType = new GroupType();
      Group group = (Group) component;
      GroupProperties groupProperties = group.getGroupProperties();
      groupType.setNumInGroupId(BigInteger.valueOf(groupProperties.getNumInGroupId()));
      groupType.setNumInGroupName(groupProperties.getNumInGroupName());
      final Integer maxValue = groupProperties.getImplMaxOccurs();
      if (maxValue != null) {
        groupType.setImplMaxOccurs(maxValue.toString());
      }
      final Integer minValue = groupProperties.getImplMinOccurs();
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
    Component component = new Component();
    populateComponent(componentType, component);
    return component;
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
    ObjectId oid = new ObjectId();
    oid.setName(fieldType.getName());
    oid.setAbbrName(fieldType.getAbbrName());
    oid.setId(fieldType.getId().intValue());
    field.setOid(oid);
    field.setType(fieldType.getType());
    field.setCategory(fieldType.getBaseCategory());
    return field;
  }

  public static Group DOMToGroup(GroupType groupType) {
    Group group = new Group();
    GroupProperties groupProperties = new GroupProperties();
    group.setGroupProperties(groupProperties);
    groupProperties.setNumInGroupId(groupType.getNumInGroupId().intValue());
    groupProperties.setNumInGroupName(groupType.getNumInGroupName());
    final String maxValue = groupType.getImplMaxOccurs();
    if (!"unbounded".equals(maxValue)) {
      groupProperties.setImplMaxOccurs(Integer.parseInt(maxValue));
    }
    final BigInteger implMinOccurs = groupType.getImplMinOccurs();
    if (implMinOccurs != null) {
      final int minValue = implMinOccurs.intValue();
      if (minValue > 0) {
        groupProperties.setImplMinOccurs(minValue);
      }
    }
    populateComponent(groupType, group);
    return group;
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
    fieldType.setType(field.getType());
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

    Structure structure = new Structure();
    component.setStructure(structure);
    List<Object> elements = componentType.getComponentRefOrGroupRefOrFieldRef();
    populateStructure(elements, structure);
  }

  private static void populateStructure(List<Object> elements, Structure structure) {
    for (Object element : elements) {
      if (element instanceof FieldRefType) {
        FieldRefType fieldRefType = (FieldRefType) element;
        FieldRef fieldRef = new FieldRef();
        ObjectId fieldOid = new ObjectId();
        fieldOid.setAbbrName(fieldRefType.getAbbrName());
        fieldOid.setId(fieldRefType.getId().intValue());
        fieldOid.setName(fieldRefType.getName());
        fieldOid.setOid(fieldRefType.getOid());
        fieldRef.setOid(fieldOid);
        structure.addFieldsItem(fieldRef);
      } else if (element instanceof GroupRefType) {
        GroupRefType groupRefType = (GroupRefType) element;
        GroupRef groupRef = new GroupRef();
        ObjectId groupOid = new ObjectId();
        groupOid.setAbbrName(groupRefType.getAbbrName());
        groupOid.setId(groupRefType.getId().intValue());
        groupOid.setName(groupRefType.getName());
        groupOid.setOid(groupRefType.getOid());
        groupRef.setOid(groupOid);
        structure.addGroupsItem(groupRef);
      } else if (element instanceof ComponentRefType) {
        ComponentRefType componentRefType = (ComponentRefType) element;
        ComponentRef componentRef = new ComponentRef();
        ObjectId componentOid = new ObjectId();
        componentOid.setAbbrName(componentRefType.getAbbrName());
        componentOid.setId(componentRefType.getId().intValue());
        componentOid.setName(componentRefType.getName());
        componentOid.setOid(componentRefType.getOid());
        componentRef.setOid(componentOid);
        structure.addComponentsItem(componentRef);
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
    Structure structure = component.getStructure();
    populateStructureDOM(structure, elements);
  }

  private static void populateStructureDOM(Structure structure, List<Object> elements) {
    for (FieldRef fieldRef : structure.getFields()) {
      FieldRefType fieldRefType = new FieldRefType();
      fieldRefType.setAbbrName(fieldRef.getOid().getAbbrName());
      fieldRefType.setId(BigInteger.valueOf(fieldRef.getOid().getId()));
      fieldRefType.setName(fieldRef.getOid().getName());
      fieldRefType.setOid(fieldRef.getOid().getOid());
      elements.add(fieldRefType);
    }
    for (GroupRef groupRef : structure.getGroups()) {
      GroupRefType groupRefType = new GroupRefType();
      groupRefType.setAbbrName(groupRef.getOid().getAbbrName());
      groupRefType.setId(BigInteger.valueOf(groupRef.getOid().getId()));
      groupRefType.setName(groupRef.getOid().getName());
      groupRefType.setOid(groupRef.getOid().getOid());
      elements.add(groupRefType);
    }
    for (ComponentRef componentRef : structure.getComponents()) {
      ComponentRefType componentRefType = new ComponentRefType();
      componentRefType.setAbbrName(componentRef.getOid().getAbbrName());
      componentRefType.setId(BigInteger.valueOf(componentRef.getOid().getId()));
      componentRefType.setName(componentRef.getOid().getName());
      componentRefType.setOid(componentRef.getOid().getOid());
      elements.add(componentRefType);
    }
  }

  public static MessageType MessageToDOM(Message message) {
    MessageType messageType = new MessageType();
    messageType.setAbbrName(message.getOid().getAbbrName());
    messageType.setId(BigInteger.valueOf(message.getOid().getId()));
    messageType.setName(message.getOid().getName());
    messageType.setOid(message.getOid().getOid());
    //messageType.setCategory(message.getCategory());
    //messageType.setExtends(value);
    messageType.setFlow(message.getFlow());
    messageType.setMsgType(message.getMsgType());
    messageType.setScenario(message.getScenario());
    messageType.setStructure(new MessageType.Structure());
    List<Object> elements = messageType.getStructure().getComponentOrComponentRefOrGroup();
    Structure structure = message.getStructure();
    populateStructureDOM(structure, elements);
    return messageType;
  }

  public static Message DOMToMessage(MessageType messageType) {
    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName(messageType.getAbbrName());
    oid.setId(messageType.getId().intValue());
    oid.setName(messageType.getName());
    oid.setOid(messageType.getOid());
    message.setOid(oid );
    message.setFlow(messageType.getFlow());
    message.setMsgType(messageType.getMsgType());
    message.setScenario(messageType.getScenario());
    Structure structure = new Structure();
    message.setStructure(structure );
    List<Object> elements = messageType.getStructure().getComponentOrComponentRefOrGroup();
    populateStructure(elements, structure);

    return message;
  }

}
