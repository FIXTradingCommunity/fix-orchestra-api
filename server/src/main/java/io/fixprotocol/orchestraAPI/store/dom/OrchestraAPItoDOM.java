package io.fixprotocol.orchestraAPI.store.dom;

import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBElement;

import org.purl.dc.elements._1.ObjectFactory;
import org.purl.dc.elements._1.SimpleLiteral;
import org.purl.dc.terms.ElementOrRefinementContainer;

import io.fixprotocol._2016.fixrepository.ActorType;
import io.fixprotocol._2016.fixrepository.Annotation;
import io.fixprotocol._2016.fixrepository.Appinfo;
import io.fixprotocol._2016.fixrepository.CodeSetType;
import io.fixprotocol._2016.fixrepository.CodeType;
import io.fixprotocol._2016.fixrepository.ComponentRefType;
import io.fixprotocol._2016.fixrepository.ComponentType;
import io.fixprotocol._2016.fixrepository.Documentation;
import io.fixprotocol._2016.fixrepository.FieldRefType;
import io.fixprotocol._2016.fixrepository.FieldType;
import io.fixprotocol._2016.fixrepository.FlowType;
import io.fixprotocol._2016.fixrepository.GroupRefType;
import io.fixprotocol._2016.fixrepository.GroupType;
import io.fixprotocol._2016.fixrepository.MessageRefType;
import io.fixprotocol._2016.fixrepository.MessageType;
import io.fixprotocol._2016.fixrepository.Repository;
import io.fixprotocol._2016.fixrepository.ResponseType;
import io.fixprotocol._2016.fixrepository.StateMachineType;
import io.fixprotocol._2016.fixrepository.StateType;
import io.fixprotocol._2016.fixrepository.TransitionType;
import io.fixprotocol._2016.fixrepository.TriggerType;
import io.fixprotocol.orchestra.api.RFC3339DateFormat;
import io.fixprotocol.orchestra.model.Actor;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.ComponentRef;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.FieldRef;
import io.fixprotocol.orchestra.model.Flow;
import io.fixprotocol.orchestra.model.Group;
import io.fixprotocol.orchestra.model.GroupProperties;
import io.fixprotocol.orchestra.model.GroupRef;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.MessageRef;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.ObjectId;
import io.fixprotocol.orchestra.model.Response;
import io.fixprotocol.orchestra.model.State;
import io.fixprotocol.orchestra.model.StateMachine;
import io.fixprotocol.orchestra.model.Structure;
import io.fixprotocol.orchestra.model.Transition;
import io.fixprotocol.orchestra.model.Trigger;


public final class OrchestraAPItoDOM {

  private final static RFC3339DateFormat dateFormat = new RFC3339DateFormat();

  public static ActorType ActorToDOM(Actor actor) {
    ActorType actorType = new ActorType();
    actorType.setName(actor.getName());
    actorType.setExtends(actor.getExtends());
    Structure structure = actor.getStructure();
    List<Object> objects = actorType.getFieldOrFieldRefOrComponent();
    populateStructureDOM(structure, objects);
    final io.fixprotocol.orchestra.model.Annotation annotation = actor.getAnnotation();
    if (annotation != null) {
      actorType.setAnnotation(AnnotationToDOM(annotation));
    }
    return actorType;
  }

  public static Annotation AnnotationToDOM(io.fixprotocol.orchestra.model.Annotation annotation) {
    Annotation annotationDOM = new Annotation();
    List<Object> listDOM = annotationDOM.getDocumentationOrAppinfo();
    if (annotation.getAppinfo() != null) {
      for (io.fixprotocol.orchestra.model.Appinfo appinfo : annotation.getAppinfo()) {
        listDOM.add(AppinfoToDOM(appinfo));
      }
    }
    if (annotation.getDocumentation() != null) {
      for (io.fixprotocol.orchestra.model.Documentation documentation : annotation
          .getDocumentation()) {
        listDOM.add(DocumentationToDOM(documentation));
      }
    }
    return annotationDOM;
  }

  public static Appinfo AppinfoToDOM(io.fixprotocol.orchestra.model.Appinfo appinfo) {
    Appinfo appinfoDOM = new Appinfo();
    appinfoDOM.setLangId(appinfo.getLangId());
    appinfoDOM.setPurpose(appinfo.getPurpose());
    appinfoDOM.setContent(appinfo.getText());
    return appinfoDOM;
  }

  public static CodeSetType CodeSetToDOM(CodeSet codeSet) {
    CodeSetType codeSetType = new CodeSetType();
    codeSetType.setAbbrName(codeSet.getOid().getAbbrName());
    codeSetType.setId(BigInteger.valueOf(codeSet.getOid().getId()));
    codeSetType.setName(codeSet.getOid().getName());
    codeSetType.setOid(codeSet.getOid().getOid());
    codeSetType.setSpecUrl(codeSet.getSpecURL());
    codeSetType.setType(codeSet.getType());
    if (codeSet.getCodes() != null) {
      codeSetType.getCode().addAll(codeSet.getCodes().stream().map(OrchestraAPItoDOM::CodeToDOM)
          .collect(Collectors.toList()));
    }
    final io.fixprotocol.orchestra.model.Annotation annotation = codeSet.getAnnotation();
    if (annotation != null) {
      codeSetType.setAnnotation(AnnotationToDOM(annotation));
    }
    return codeSetType;
  }

  public static CodeType CodeToDOM(Code code) {
    CodeType codeType = new CodeType();
    codeType.setAbbrName(code.getOid().getAbbrName());
    codeType.setId(BigInteger.valueOf(code.getOid().getId()));
    codeType.setName(code.getOid().getName());
    codeType.setOid(code.getOid().getOid());
    codeType.setValue(code.getValue());
    final io.fixprotocol.orchestra.model.Annotation annotation = code.getAnnotation();
    if (annotation != null) {
      codeType.setAnnotation(AnnotationToDOM(annotation));
    }
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
    final io.fixprotocol.orchestra.model.Annotation annotation = datatype.getAnnotation();
    if (annotation != null) {
      datatypeDOM.setAnnotation(AnnotationToDOM(annotation));
    }
    return datatypeDOM;
  }

  public static Documentation DocumentationToDOM(
      io.fixprotocol.orchestra.model.Documentation documentation) {
    Documentation documentationDOM = new Documentation();
    documentationDOM.setLangId(documentation.getLangId());
    documentationDOM.setPurpose(documentation.getPurpose());
    documentationDOM.getContent().add(documentation.getText());
    return documentationDOM;
  }

  public static Actor DOMToActor(ActorType actorType) {
    Actor actor = new Actor();
    actor.setExtends(actorType.getExtends());
    actor.setName(actorType.getName());
    Structure structure = new Structure();
    actor.setStructure(structure);
    List<Object> objects = actorType.getFieldOrFieldRefOrComponent();
    populateStructure(objects, structure);
    Annotation annotation = actorType.getAnnotation();
    if (annotation != null) {
      actor.setAnnotation(DOMToAnnotation(annotation));
    }
    return actor;
  }

  public static io.fixprotocol.orchestra.model.Annotation DOMToAnnotation(
      Annotation annotationDOM) {
    io.fixprotocol.orchestra.model.Annotation annotation =
        new io.fixprotocol.orchestra.model.Annotation();
    annotation.setAppinfo(
        annotationDOM.getDocumentationOrAppinfo().stream().filter(o -> o instanceof Appinfo)
            .map(o -> (Appinfo) o).map(OrchestraAPItoDOM::DOMToAppinfo).collect(Collectors.toList()));
    annotation.setDocumentation(annotationDOM.getDocumentationOrAppinfo().stream()
        .filter(o -> o instanceof Documentation).map(o -> (Documentation) o)
        .map(OrchestraAPItoDOM::DOMToDocumentation).collect(Collectors.toList()));
    return annotation;
  }

  public static io.fixprotocol.orchestra.model.Appinfo DOMToAppinfo(Appinfo appinfoDOM) {
    io.fixprotocol.orchestra.model.Appinfo appinfo = new io.fixprotocol.orchestra.model.Appinfo();
    appinfo.setLangId(appinfoDOM.getLangId());
    appinfo.setPurpose(appinfoDOM.getPurpose());
    appinfo.setText(appinfoDOM.getContent());
    return appinfo;
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
    Annotation annotation = codeType.getAnnotation();
    if (annotation != null) {
      code.setAnnotation(DOMToAnnotation(annotation));
    }
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
    codeSet.codes(codeSetType.getCode().stream().map(OrchestraAPItoDOM::DOMToCode)
        .collect(Collectors.toList()));
    Annotation annotation = codeSetType.getAnnotation();
    if (annotation != null) {
      codeSet.setAnnotation(DOMToAnnotation(annotation));
    }
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
    Annotation annotation = datatypeDOM.getAnnotation();
    if (annotation != null) {
      datatype.setAnnotation(DOMToAnnotation(annotation));
    }
    return datatype;
  }

  public static io.fixprotocol.orchestra.model.Documentation DOMToDocumentation(
      Documentation documentationDOM) {
    io.fixprotocol.orchestra.model.Documentation documentation =
        new io.fixprotocol.orchestra.model.Documentation();

    final List<Object> content = documentationDOM.getContent();
    if (!content.isEmpty()) {
      documentation.setText(content.get(0).toString());
      documentation.setLangId(documentationDOM.getLangId());
      documentation.setPurpose(documentationDOM.getPurpose());
    }
    return documentation;
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
    Annotation annotation = fieldType.getAnnotation();
    if (annotation != null) {
      field.setAnnotation(DOMToAnnotation(annotation));
    }
    return field;
  }

  public static Flow DOMToFlow(FlowType flowType) {
    Flow flow = new Flow();
    flow.setDestination(flowType.getDestination());
    flow.setName(flowType.getName());
    flow.setSource(flowType.getSource());
    Annotation annotation = flowType.getAnnotation();
    if (annotation != null) {
      flow.setAnnotation(DOMToAnnotation(annotation));
    }
    return flow;
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

  public static Message DOMToMessage(MessageType messageType) {
    Message message = new Message();
    ObjectId oid = new ObjectId();
    oid.setAbbrName(messageType.getAbbrName());
    oid.setId(messageType.getId().intValue());
    oid.setName(messageType.getName());
    oid.setOid(messageType.getOid());
    message.setOid(oid);
    message.setFlow(messageType.getFlow());
    message.setMsgType(messageType.getMsgType());
    message.setScenario(messageType.getScenario());
    message.setCategory(messageType.getCategory());
    message.setExtends(messageType.getExtends());
    Structure structure = new Structure();
    message.setStructure(structure);
    List<Object> elements = messageType.getStructure().getComponentOrComponentRefOrGroup();
    populateStructure(elements, structure);

    return message;
  }

  public static MessageRef DOMToMessageRef(MessageRefType messageRefType) {
    MessageRef messageRef = new MessageRef();
    messageRef.setName(messageRefType.getName());
    messageRef.setMsgType(messageRefType.getMsgType());
    messageRef.setScenario(messageRefType.getScenario());
    return messageRef;
  }

  public static Metadata DOMToMetadata(ElementOrRefinementContainer element) {
    Metadata metadata = new Metadata();
    List<JAXBElement<SimpleLiteral>> literals = element.getAny();
    literals.forEach(l -> {
      String name = l.getName().getLocalPart();
      final List<String> content = l.getValue().getContent();
      if (!content.isEmpty()) {
        String value = content.get(0);
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
      }
    });
    return metadata;
  }

  public static io.fixprotocol.orchestra.model.Repository DOMToRepository(
      io.fixprotocol._2016.fixrepository.Repository repositoryDOM) {
    io.fixprotocol.orchestra.model.Repository repository = new io.fixprotocol.orchestra.model.Repository();
    repository.setName(repositoryDOM.getName());
    repository.setVersion(repositoryDOM.getVersion());
    repository.setHasComponents(repositoryDOM.isHasComponents());
    repository.setNamespace(repositoryDOM.getNamespace());
    repository.setOid(repositoryDOM.getGuid());
    repository.setSpecURL(repositoryDOM.getSpecUrl());
    if (repositoryDOM.getMetadata() != null) {
      repository.setMetadata(DOMToMetadata(repositoryDOM.getMetadata()));
    }
    return repository;
  }

  public static Response DOMToResponse(ResponseType responseType) {
    Response response = new Response();
    response.setName(responseType.getName());
    response.setWhen(responseType.getWhen());
    responseType.getMessageRefOrAssignOrTrigger().stream().filter(o -> o instanceof String)
        .map(Object::toString).findFirst().ifPresent(response::setAssign);
    responseType.getMessageRefOrAssignOrTrigger().stream().filter(o -> o instanceof MessageRefType)
        .map(o -> (MessageRefType) o).map(OrchestraAPItoDOM::DOMToMessageRef).findFirst()
        .ifPresent(response::setMessageRef);
    responseType.getMessageRefOrAssignOrTrigger().stream().filter(o -> o instanceof TriggerType)
        .map(o -> (TriggerType) o).map(OrchestraAPItoDOM::DOMToTrigger).findFirst()
        .ifPresent(response::setTrigger);
    Annotation annotation = responseType.getAnnotation();
    if (annotation != null) {
      response.setAnnotation(DOMToAnnotation(annotation));
    }    

    return response;
  }

  public static State DOMToState(StateType stateType) {
    State state = new State();
    state.setName(stateType.getName());
    state.setTransitions(stateType.getTransition().stream().map(OrchestraAPItoDOM::DOMToTransition)
        .collect(Collectors.toList()));
    return state;
  }

  public static StateMachine DOMToStateMachine(StateMachineType stateMachineType) {
    StateMachine stateMachine = new StateMachine();
    stateMachine.setName(stateMachineType.getName());
    stateMachine.setInitial(DOMToState(stateMachineType.getInitial()));
    stateMachine.setStates(stateMachineType.getState().stream().map(OrchestraAPItoDOM::DOMToState)
        .collect(Collectors.toList()));
    Annotation annotation = stateMachineType.getAnnotation();
    if (annotation != null) {
      stateMachine.setAnnotation(DOMToAnnotation(annotation));
    }    

    return stateMachine;
  }

  public static Transition DOMToTransition(TransitionType transitionType) {
    Transition transition = new Transition();
    transition.setTarget(transitionType.getTarget());
    transition.setWhen(transitionType.getWhen());
    return transition;
  }

  public static Trigger DOMToTrigger(TriggerType t) {
    Trigger trigger = new Trigger();
    trigger.setName(t.getName());
    trigger.setActor(t.getActor());
    trigger.setStateMachine(t.getStateMachine());
    return trigger;
  }

  public static FieldType FieldToDOM(Field field) {
    FieldType fieldType = new FieldType();
    fieldType.setId(BigInteger.valueOf(field.getOid().getId()));
    fieldType.setName(field.getOid().getName());
    fieldType.setAbbrName(field.getOid().getAbbrName());
    fieldType.setType(field.getType());
    fieldType.setBaseCategory(field.getCategory());
    final io.fixprotocol.orchestra.model.Annotation annotation = field.getAnnotation();
    if (annotation != null) {
      fieldType.setAnnotation(AnnotationToDOM(annotation));
    }    return fieldType;
  }

  public static FlowType FlowToDOM(Flow flow) {
    FlowType flowType = new FlowType();
    flowType.setDestination(flow.getDestination());
    flowType.setName(flow.getName());
    flowType.setSource(flow.getSource());
    final io.fixprotocol.orchestra.model.Annotation annotation = flow.getAnnotation();
    if (annotation != null) {
      flowType.setAnnotation(AnnotationToDOM(annotation));
    }  
    return flowType;
  }

  public static MessageRefType MessageRefToDOM(MessageRef messageRef) {
    MessageRefType messageRefType = new MessageRefType();
    messageRefType.setName(messageRef.getName());
    messageRefType.setMsgType(messageRef.getMsgType());
    messageRefType.setScenario(messageRef.getScenario());
    return messageRefType;
  }

  public static MessageType MessageToDOM(Message message) {
    MessageType messageType = new MessageType();
    final ObjectId oid = message.getOid();
    if (oid != null) {
      messageType.setAbbrName(oid.getAbbrName());
      messageType.setId(BigInteger.valueOf(oid.getId()));
      messageType.setName(oid.getName());
      messageType.setOid(oid.getOid());
    }
    messageType.setCategory(message.getCategory());
    messageType.setExtends(message.getExtends());
    messageType.setFlow(message.getFlow());
    messageType.setMsgType(message.getMsgType());
    messageType.setScenario(message.getScenario());
    messageType.setStructure(new MessageType.Structure());
    List<Object> elements = messageType.getStructure().getComponentOrComponentRefOrGroup();
    Structure structure = message.getStructure();
    populateStructureDOM(structure, elements);
//    final io.fixprotocol.orchestra.model.Annotation annotation = message.getAnnotation();
//    if (annotation != null) {
//      messageType.setAnnotation(AnnotationToDOM(annotation));
//    }  
    return messageType;
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
    repositoryDOM.setHasComponents(repository.isHasComponents());
    repositoryDOM.setNamespace(repository.getNamespace());
    repositoryDOM.setGuid(repository.getOid());
    repositoryDOM.setSpecUrl(repository.getSpecURL());
    if (repository.getMetadata() != null) {
      repositoryDOM.setMetadata(MetadataToDOM(repository.getMetadata()));
    }
    return repositoryDOM;
  }
  public static ResponseType ResponseToDOM(Response response) {
    ResponseType responseType = new ResponseType();
    responseType.setName(response.getName());
    responseType.setWhen(response.getWhen());
    if (response.getAssign() != null) {
      responseType.getMessageRefOrAssignOrTrigger().add(response.getAssign());
    }
    if (response.getMessageRef() != null) {
      responseType.getMessageRefOrAssignOrTrigger().add(MessageRefToDOM(response.getMessageRef()));
    }
    if (response.getTrigger() != null) {
      responseType.getMessageRefOrAssignOrTrigger().add(TriggerToDOM(response.getTrigger()));
    }
    final io.fixprotocol.orchestra.model.Annotation annotation = response.getAnnotation();
    if (annotation != null) {
      responseType.setAnnotation(AnnotationToDOM(annotation));
    } 
    return responseType;
  }

  public static StateMachineType StateMachineToDOM(StateMachine stateMachine) {
    StateMachineType stateMachineType = new StateMachineType();
    stateMachineType.setName(stateMachine.getName());
    stateMachineType.setInitial(StateToDOM(stateMachine.getInitial()));
    stateMachineType.getState().addAll(stateMachine.getStates().stream()
        .map(OrchestraAPItoDOM::StateToDOM).collect(Collectors.toList()));
    final io.fixprotocol.orchestra.model.Annotation annotation = stateMachine.getAnnotation();
    if (annotation != null) {
      stateMachineType.setAnnotation(AnnotationToDOM(annotation));
    } 
    return stateMachineType;
  }

  public static StateType StateToDOM(State state) {
    StateType stateType = new StateType();
    stateType.setName(state.getName());
    if (state.getTransitions() != null) {
      List<TransitionType> transitions = state.getTransitions().stream()
          .map(OrchestraAPItoDOM::TransitionToDOM).collect(Collectors.toList());
      stateType.getTransition().addAll(transitions);
    }
    return stateType;
  }

  public static TransitionType TransitionToDOM(Transition transition) {
    TransitionType transitionType = new TransitionType();
    transitionType.setWhen(transition.getWhen());
    transitionType.setTarget(transition.getTarget());
    return transitionType;
  }

  public static TriggerType TriggerToDOM(Trigger trigger) {
    TriggerType triggerType = new TriggerType();
    triggerType.setName(trigger.getName());
    triggerType.setActor(trigger.getActor());
    triggerType.setStateMachine(trigger.getStateMachine());
    return triggerType;
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
    Annotation annotation = componentType.getAnnotation();
    if (annotation != null) {
      component.setAnnotation(DOMToAnnotation(annotation));
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
    final io.fixprotocol.orchestra.model.Annotation annotation = component.getAnnotation();
    if (annotation != null) {
      componentType.setAnnotation(AnnotationToDOM(annotation));
    }
    componentType.setAnnotation(new Annotation());
  }

  private static void populateStructure(List<Object> elements, Structure structure) {
    // don't let any structure arrays be null
    structure.setComponents(new ArrayList<>());
    structure.setFields(new ArrayList<>());
    structure.setGroups(new ArrayList<>());
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

  private static void populateStructureDOM(Structure structure, List<Object> elements) {
    if (structure.getFields() != null) {
      for (FieldRef fieldRef : structure.getFields()) {
        FieldRefType fieldRefType = new FieldRefType();
        fieldRefType.setAbbrName(fieldRef.getOid().getAbbrName());
        fieldRefType.setId(BigInteger.valueOf(fieldRef.getOid().getId()));
        fieldRefType.setName(fieldRef.getOid().getName());
        fieldRefType.setOid(fieldRef.getOid().getOid());
        elements.add(fieldRefType);
      }
    }
    if (structure.getGroups() != null) {
      for (GroupRef groupRef : structure.getGroups()) {
        GroupRefType groupRefType = new GroupRefType();
        groupRefType.setAbbrName(groupRef.getOid().getAbbrName());
        groupRefType.setId(BigInteger.valueOf(groupRef.getOid().getId()));
        groupRefType.setName(groupRef.getOid().getName());
        groupRefType.setOid(groupRef.getOid().getOid());
        elements.add(groupRefType);
      }
    }
    if (structure.getComponents() != null) {
      for (ComponentRef componentRef : structure.getComponents()) {
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
