package io.fixprotocol.orchestraAPI.store.dom;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import io.fixprotocol._2016.fixrepository.ActorType;
import io.fixprotocol._2016.fixrepository.Actors;
import io.fixprotocol._2016.fixrepository.CodeSetType;
import io.fixprotocol._2016.fixrepository.CodeSets;
import io.fixprotocol._2016.fixrepository.CodeType;
import io.fixprotocol._2016.fixrepository.ComponentType;
import io.fixprotocol._2016.fixrepository.Components;
import io.fixprotocol._2016.fixrepository.Datatypes;
import io.fixprotocol._2016.fixrepository.FieldType;
import io.fixprotocol._2016.fixrepository.Fields;
import io.fixprotocol._2016.fixrepository.FlowType;
import io.fixprotocol._2016.fixrepository.GroupType;
import io.fixprotocol._2016.fixrepository.MessageType;
import io.fixprotocol._2016.fixrepository.MessageType.Responses;
import io.fixprotocol._2016.fixrepository.Messages;
import io.fixprotocol._2016.fixrepository.Repository;
import io.fixprotocol._2016.fixrepository.ResponseType;
import io.fixprotocol._2016.fixrepository.StateMachineType;
import io.fixprotocol.orchestra.model.Actor;
import io.fixprotocol.orchestra.model.Annotation;
import io.fixprotocol.orchestra.model.Appinfo;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Datatype;
import io.fixprotocol.orchestra.model.Documentation;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Flow;
import io.fixprotocol.orchestra.model.Group;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.Response;
import io.fixprotocol.orchestra.model.StateMachine;
import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.ElementType;
import io.fixprotocol.orchestraAPI.store.RepositoryStore;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;


/**
 * 
 * Operations are thread-safe.
 * 
 * @author Don Mendelson
 */
public class RepositoryDOMStore implements RepositoryStore {

  private class RepositoryKey {
    final String reposName;
    final String version;

    RepositoryKey(String reposName, String version) {
      this.reposName = reposName;
      this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      RepositoryKey other = (RepositoryKey) obj;
      if (!getOuterType().equals(other.getOuterType())) {
        return false;
      }
      if (reposName == null) {
        if (other.reposName != null) {
          return false;
        }
      } else if (!reposName.equals(other.reposName)) {
        return false;
      }
      if (version == null) {
        return other.version == null;
      } else
        return version.equals(other.version);
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + ((reposName == null) ? 0 : reposName.hashCode());
      result = prime * result + ((version == null) ? 0 : version.hashCode());
      return result;
    }

    private RepositoryDOMStore getOuterType() {
      return RepositoryDOMStore.this;
    }
  }

  private final Map<RepositoryKey, Repository> repositories = new ConcurrentHashMap<>();

  @Override
  public void createActor(String reposName, String version, Actor actor)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(actor, "Actor missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<ActorType> actors = getActorList(repository);

    if (actors.stream().anyMatch(a -> actor.getName().equals(a.getName()))) {
      throw new DuplicateKeyException(String.format("Duplicate actor %s", actor.getName()));
    }

    repository.getActors().getActorOrFlow().add(OrchestraAPItoDOM.ActorToDOM(actor));
  }

  @Override
  public void createAnnotation(String reposName, String version, String elementId,
      ElementType elementType, String parentId, Annotation annotation)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(elementType, "Element type missing");
    Objects.requireNonNull(elementId, "Element ID or name missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    switch (elementType) {
      case actor:
        List<ActorType> actors = getActorList(repository);
        Optional<ActorType> optActor =
            actors.stream().filter(a -> elementId.equals(a.getName())).findFirst();
        if (optActor.isPresent()) {
          optActor.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(String.format("Actor %s not found", elementId));
        }
        break;
      case code:
        Objects.requireNonNull(parentId, "Parent ID missing");

        List<CodeSetType> codeSets = getCodeSets(repository);
        Optional<CodeSetType> optCodeSet = codeSets.stream()
            .filter(cs -> Integer.parseInt(parentId) == cs.getId().intValue()).findFirst();
        if (optCodeSet.isPresent()) {
          List<CodeType> codes = optCodeSet.get().getCode();
          Optional<CodeType> optCode = codes.stream()
              .filter(c -> c.getId().intValue() == Integer.parseInt(elementId)).findFirst();
          if (optCode.isPresent()) {
            optCode.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
          } else {
            throw new ResourceNotFoundException(
                String.format("Code with ID=%s not found", elementId));
          }
        } else {
          throw new ResourceNotFoundException(
              String.format("CodeSet with ID=%s not found", parentId));
        }
        break;
      case codeSet:
        List<CodeSetType> codeSets2 = getCodeSets(repository);
        Optional<CodeSetType> optCodeSet2 = codeSets2.stream()
            .filter(cs -> Integer.parseInt(elementId) == cs.getId().intValue()).findFirst();
        if (optCodeSet2.isPresent()) {
          optCodeSet2.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("CodeSet with ID=%s not found", elementId));
        }
        break;
      case component:
        List<ComponentType> components = getComponentList(repository);

        Optional<ComponentType> optComponent = components.stream()
            .filter(c -> Integer.parseInt(elementId) == c.getId().intValue()).findFirst();

        if (optComponent.isPresent()) {
          optComponent.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("Component with ID=%s not found", elementId));
        }
        break;
      case datatype:
        List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

        Optional<io.fixprotocol._2016.fixrepository.Datatype> optDatatype =
            datatypes.stream().filter(d -> elementId.equals(d.getName())).findFirst();

        if (optDatatype.isPresent()) {
          optDatatype.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(String.format("Datatype %s not found", elementId));
        }
        break;
      case field:
        List<FieldType> fields = getFieldList(repository);

        Optional<FieldType> optField = fields.stream()
            .filter(f -> Integer.parseInt(elementId) == f.getId().intValue()).findFirst();

        if (optField.isPresent()) {
          optField.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("Field with ID=%s not found", elementId));
        }
        break;
      case flow:
        List<FlowType> flows = getFlowList(repository);
        Optional<FlowType> optFlow =
            flows.stream().filter(f -> elementId.equals(f.getName())).findFirst();

        if (optFlow.isPresent()) {
          optFlow.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(String.format("Flow %s not found", elementId));
        }
        break;
      case group:
        List<ComponentType> components2 = getComponentList(repository);

        Optional<GroupType> optGroup =
            components2.stream().filter(c -> Integer.parseInt(elementId) == c.getId().intValue())
                .filter(c -> c instanceof GroupType).map(c -> (GroupType) c).findFirst();

        if (optGroup.isPresent()) {
          optGroup.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("Group with ID=%s not found", elementId));
        }
        break;
      case message:
        List<MessageType> messages = getMessageList(repository);

        Optional<MessageType> optMessage = messages.stream()
            .filter(m -> Integer.parseInt(elementId) == m.getId().intValue()).findFirst();

        if (optMessage.isPresent()) {
          optMessage.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("Message with ID=%s not found", elementId));
        }
        break;
      case response:
        Objects.requireNonNull(parentId, "Parent ID or name missing");

        List<MessageType> messages2 = getMessageList(repository);

        Optional<MessageType> optMessage2 = messages2.stream()
            .filter(m -> Integer.parseInt(parentId) == m.getId().intValue()).findFirst();

        if (optMessage2.isPresent()) {
          List<ResponseType> responses = getResponseList(optMessage2.get());
          Optional<ResponseType> optResponse =
              responses.stream().filter(r -> elementId.equals(r.getName())).findFirst();
          if (optResponse.isPresent()) {
            optResponse.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
          } else {
            throw new ResourceNotFoundException(
                String.format("Message response %s not found", elementId));
          }
        } else {
          throw new ResourceNotFoundException(
              String.format("Message with ID=%s not found", parentId));
        }
        break;
      case stateMachine:
        List<ActorType> actors2 = getActorList(repository);
        Optional<ActorType> optActor2 =
            actors2.stream().filter(a -> parentId.equals(a.getName())).findFirst();

        if (optActor2.isPresent()) {
          List<Object> elements = optActor2.get().getFieldOrFieldRefOrComponent();
          Optional<StateMachineType> optStateMachine = elements.stream()
              .filter(o -> o instanceof StateMachineType).map(o -> (StateMachineType) o)
              .filter(sm -> elementId.equals(sm.getName())).findFirst();
          if (optStateMachine.isPresent()) {
            optStateMachine.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
          } else {
            throw new ResourceNotFoundException(
                String.format("StateMachine %s not found", elementId));
          }

        } else {
          throw new ResourceNotFoundException(String.format("Actor %s not found", parentId));
        }
        break;
    }
  }

  @Override
  public void createCode(String reposName, String version, Integer codesetid, Code code)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codesetid, "CodeSet ID missing");
    Objects.requireNonNull(code, "Code missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<CodeSetType> codeSets = getCodeSets(repository);

    for (CodeSetType codeSet : codeSets) {
      if (codesetid == codeSet.getId().intValue()) {
        List<CodeType> codes = codeSet.getCode();
        if (codes.stream().anyMatch(c -> c.getId().intValue() == code.getOid().getId())) {
          throw new DuplicateKeyException(
              String.format("Duplicate code with ID=%d", code.getOid().getId()));
        }
        codes.add(OrchestraAPItoDOM.CodeToDOM(code));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", codesetid));
  }

  @Override
  public void createCodeSet(String reposName, String version, CodeSet codeSet)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codeSet, "CodeSet missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);
    if (codeSets.stream().anyMatch(cs -> codeSet.getOid().getId() == cs.getId().intValue())) {
      throw new DuplicateKeyException(
          String.format("Duplicate field with ID=%d", codeSet.getOid().getId()));
    }
    codeSets.add(OrchestraAPItoDOM.CodeSetToDOM(codeSet));
  }

  @Override
  public void createComponent(String reposName, String version, Component component,
      Integer toClone) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(component, "Component missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<ComponentType> components = getComponentList(repository);

    if (components.stream().anyMatch(c -> component.getOid().getId() == c.getId().intValue())) {
      throw new DuplicateKeyException(
          String.format("Duplicate component with ID=%d", component.getOid().getId()));
    }

    if (toClone != null) {
      ComponentType componentTypeToClone = null;
      for (ComponentType componentType : components) {
        if (toClone == componentType.getId().intValue()) {
          componentTypeToClone = componentType;
          break;
        }
      }
      if (componentTypeToClone == null) {
        throw new ResourceNotFoundException(
            String.format("Component with ID=%d not found", toClone));
      }
      ComponentType clone = (ComponentType) componentTypeToClone.clone();
      clone.setAbbrName(component.getOid().getAbbrName());
      clone.setId(BigInteger.valueOf(component.getOid().getId()));
      clone.setName(component.getOid().getName());
      clone.setOid(component.getOid().getOid());
      components.add(clone);
    } else {
      components.add(OrchestraAPItoDOM.ComponentToDOM(component));
    }
  }

  @Override
  public void createDatatype(String reposName, String version, Datatype datatype)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(datatype, "Datatype missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    if (datatypes.stream().anyMatch(d -> datatype.getName().equals(d.getName()))) {
      throw new DuplicateKeyException(String.format("Duplicate datatype %s", datatype.getName()));
    }
    datatypes.add(OrchestraAPItoDOM.DatatypeToDOM(datatype));
  }

  @Override
  public void createField(String reposName, String version, Field field)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(field, "Field missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<FieldType> fields = getFieldList(repository);

    if (fields.stream().anyMatch(f -> field.getOid().getId() == f.getId().intValue())) {
      throw new DuplicateKeyException(
          String.format("Duplicate field with ID=%d", field.getOid().getId()));
    }
    fields.add(OrchestraAPItoDOM.FieldToDOM(field));
  }

  @Override
  public void createFlow(String reposName, String version, Flow flow)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(flow, "Flow missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<FlowType> flows = getFlowList(repository);

    if (flows.stream().anyMatch(f -> flow.getName().equals(f.getName()))) {
      throw new DuplicateKeyException(String.format("Duplicate flow %s", flow.getName()));
    }
    repository.getActors().getActorOrFlow().add(OrchestraAPItoDOM.FlowToDOM(flow));
  }

  @Override
  public void createMessage(String reposName, String version, Message message, Integer toClone)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(message, "Message missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<MessageType> messages = getMessageList(repository);

    if (messages.stream().anyMatch(m -> message.getOid().getId() == m.getId().intValue())) {
      throw new DuplicateKeyException(
          String.format("Duplicate message with ID=%d", message.getOid().getId()));
    }

    if (toClone != null) {
      MessageType messageTypeToClone = null;
      for (MessageType messageType : messages) {
        if (toClone == messageType.getId().intValue()) {
          messageTypeToClone = messageType;
          break;
        }
      }
      if (messageTypeToClone == null) {
        throw new ResourceNotFoundException(String.format("Message with ID=%d not found", toClone));
      }
      MessageType clone = (MessageType) messageTypeToClone.clone();
      clone.setAbbrName(message.getOid().getAbbrName());
      clone.setId(BigInteger.valueOf(message.getOid().getId()));
      clone.setName(message.getOid().getName());
      clone.setOid(message.getOid().getOid());
      clone.setScenario(message.getScenario());
      clone.setExtends(message.getExtends());
      messages.add(clone);
    } else {
      messages.add(OrchestraAPItoDOM.MessageToDOM(message));
    }
  }

  @Override
  public void createMessageResponse(String reposName, String version, Integer id, Response response)
      throws RepositoryStoreException {
    Objects.requireNonNull(response, "Message response value missing");
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Message ID missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<MessageType> messageList = getMessageList(repository);

    for (MessageType messageType : messageList) {
      if (id == messageType.getId().intValue()) {
        List<ResponseType> responseList = getResponseList(messageType);
        if (responseList.stream().anyMatch(r -> response.getName().equals(r.getName()))) {
          throw new DuplicateKeyException(
              String.format("Duplicate response %s", response.getName()));
        }
        responseList.add(OrchestraAPItoDOM.ResponseToDOM(response));
        return;
      }
    }
    throw new ResourceNotFoundException(String.format("Message with ID=%d not found", id));
  }

  @Override
  public Metadata createRepository(io.fixprotocol.orchestra.model.Repository repository,
      String nameToClone, String versionToClone) throws RepositoryStoreException {
    Objects.requireNonNull(repository, "Repository missing");
    final RepositoryKey key = new RepositoryKey(repository.getName(), repository.getVersion());
    Repository exists = repositories.get(key);
    if (exists != null) {
      throw new DuplicateKeyException(String.format("Duplicate repository with name=%s version=%s",
          repository.getName(), repository.getVersion()));
    }
    io.fixprotocol._2016.fixrepository.Repository repositoryToAdd;
    if (nameToClone != null && versionToClone != null) {
      Repository repositoryToClone =
          repositories.get(new RepositoryKey(nameToClone, versionToClone));
      if (repositoryToClone == null) {
        throw new ResourceNotFoundException(String
            .format("Repository with name=%s version=%s not found", nameToClone, versionToClone));
      }
      repositoryToAdd = (io.fixprotocol._2016.fixrepository.Repository) repositoryToClone.clone();
      repositoryToAdd.setName(repository.getName());
      repositoryToAdd.setVersion(repository.getVersion());
      // overwrite metadata if it is provided
      if (repository.getMetadata() != null) {
        repositoryToAdd.setMetadata(OrchestraAPItoDOM.MetadataToDOM(repository.getMetadata()));
      }
    } else {
      repositoryToAdd = OrchestraAPItoDOM.RepositoryToDOM(repository);
    }
    repositories.putIfAbsent(key, repositoryToAdd);
    final Repository repository2 = repositories.get(key);
    return OrchestraAPItoDOM.DOMToMetadata(repository2.getMetadata());
  }

  @Override
  public Metadata createRepositoryFromFile(InputStream stream) throws RepositoryStoreException {
    try {
      Objects.requireNonNull(stream, "File missing");
      Repository repository = unMarshal(stream);
      final RepositoryKey key = new RepositoryKey(repository.getName(), repository.getVersion());
      Repository exists = repositories.get(key);
      if (exists != null) {
        throw new DuplicateKeyException(
            String.format("Duplicate repository with name=%s version=%s", repository.getName(),
                repository.getVersion()));
      }
      repositories.putIfAbsent(key, repository);
      final Repository repository2 = repositories.get(key);
      return OrchestraAPItoDOM.DOMToMetadata(repository2.getMetadata());
    } catch (JAXBException e) {
      throw new RepositoryStoreException("Unable to read or parse repository file", e);
    }
  }

  @Override
  public void createStateMachine(String reposName, String version, String actor,
      StateMachine stateMachine) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(actor, "Actor name missing");
    Objects.requireNonNull(actor, "StateMachine value missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<ActorType> actors = getActorList(repository);

    for (ActorType actorType : actors) {
      if (actor.equals(actorType.getName())) {
        List<Object> elements = actorType.getFieldOrFieldRefOrComponent();
        if (elements.stream().filter(o -> o instanceof StateMachineType)
            .map(o -> (StateMachineType) o)
            .anyMatch(sm -> sm.getName().equals(stateMachine.getName()))) {
          throw new DuplicateKeyException(
              String.format("Duplicate state machine with name=%s", stateMachine.getName()));
        }
        elements.add(OrchestraAPItoDOM.StateMachineToDOM(stateMachine));
        return;
      }
    }
    throw new ResourceNotFoundException(String.format("Actor with name=%s not found", actor));
  }

  @Override
  public void deleteActor(String reposName, String version, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Actor name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    Actors actors = repository.getActors();
    if (actors == null) {
      throw new ResourceNotFoundException(String.format("Actor %s not found", name));
    }

    List<Object> actorsOrFlows = actors.getActorOrFlow();
    for (Object obj : actorsOrFlows) {
      if (obj instanceof ActorType) {
        ActorType actorType = (ActorType) obj;
        if (actorType.getName().equals(name)) {
          actorsOrFlows.remove(obj);
          return;
        }
      }
    }

    throw new ResourceNotFoundException(String.format("Actor %s not found", name));
  }

  @Override
  public void deleteAnnotation(String reposName, String version, String elementId,
      ElementType elementType, String parentId) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(elementType, "Element type missing");
    Objects.requireNonNull(elementId, "Element ID or name missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    switch (elementType) {
      case actor:
        List<ActorType> actors = getActorList(repository);
        Optional<ActorType> optActor =
            actors.stream().filter(a -> elementId.equals(a.getName())).findFirst();
        if (optActor.isPresent()) {
          optActor.get().setAnnotation(null);
        } else {
          throw new ResourceNotFoundException(String.format("Actor %s not found", elementId));
        }
        break;
      case code:
        Objects.requireNonNull(parentId, "Parent ID missing");

        List<CodeSetType> codeSets = getCodeSets(repository);
        Optional<CodeSetType> optCodeSet = codeSets.stream()
            .filter(cs -> Integer.parseInt(parentId) == cs.getId().intValue()).findFirst();
        if (optCodeSet.isPresent()) {
          List<CodeType> codes = optCodeSet.get().getCode();
          Optional<CodeType> optCode = codes.stream()
              .filter(c -> c.getId().intValue() == Integer.parseInt(elementId)).findFirst();
          if (optCode.isPresent()) {
            optCode.get().setAnnotation(null);
          } else {
            throw new ResourceNotFoundException(
                String.format("Code with ID=%s not found", elementId));
          }
        } else {
          throw new ResourceNotFoundException(
              String.format("CodeSet with ID=%s not found", parentId));
        }
        break;
      case codeSet:
        List<CodeSetType> codeSets2 = getCodeSets(repository);
        Optional<CodeSetType> optCodeSet2 = codeSets2.stream()
            .filter(cs -> Integer.parseInt(elementId) == cs.getId().intValue()).findFirst();
        if (optCodeSet2.isPresent()) {
          optCodeSet2.get().setAnnotation(null);
        } else {
          throw new ResourceNotFoundException(
              String.format("CodeSet with ID=%s not found", elementId));
        }
        break;
      case component:
        List<ComponentType> components = getComponentList(repository);

        Optional<ComponentType> optComponent = components.stream()
            .filter(c -> Integer.parseInt(elementId) == c.getId().intValue()).findFirst();

        if (optComponent.isPresent()) {
          optComponent.get().setAnnotation(null);
        } else {
          throw new ResourceNotFoundException(
              String.format("Component with ID=%s not found", elementId));
        }
        break;
      case datatype:
        List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

        Optional<io.fixprotocol._2016.fixrepository.Datatype> optDatatype =
            datatypes.stream().filter(d -> elementId.equals(d.getName())).findFirst();

        if (optDatatype.isPresent()) {
          optDatatype.get().setAnnotation(null);
        } else {
          throw new ResourceNotFoundException(String.format("Datatype %s not found", elementId));
        }
        break;
      case field:
        List<FieldType> fields = getFieldList(repository);

        Optional<FieldType> optField = fields.stream()
            .filter(f -> Integer.parseInt(elementId) == f.getId().intValue()).findFirst();

        if (optField.isPresent()) {
          optField.get().setAnnotation(null);
        } else {
          throw new ResourceNotFoundException(
              String.format("Field with ID=%s not found", elementId));
        }
        break;
      case flow:
        List<FlowType> flows = getFlowList(repository);
        Optional<FlowType> optFlow =
            flows.stream().filter(f -> elementId.equals(f.getName())).findFirst();

        if (optFlow.isPresent()) {
          optFlow.get().setAnnotation(null);
        } else {
          throw new ResourceNotFoundException(String.format("Flow %s not found", elementId));
        }
        break;
      case group:
        List<ComponentType> components2 = getComponentList(repository);

        Optional<GroupType> optGroup =
            components2.stream().filter(c -> Integer.parseInt(elementId) == c.getId().intValue())
                .filter(c -> c instanceof GroupType).map(c -> (GroupType) c).findFirst();

        if (optGroup.isPresent()) {
          optGroup.get().setAnnotation(null);
        } else {
          throw new ResourceNotFoundException(
              String.format("Group with ID=%s not found", elementId));
        }
        break;
      case message:
        List<MessageType> messages = getMessageList(repository);

        Optional<MessageType> optMessage = messages.stream()
            .filter(m -> Integer.parseInt(elementId) == m.getId().intValue()).findFirst();

        if (optMessage.isPresent()) {
          optMessage.get().setAnnotation(null);
        } else {
          throw new ResourceNotFoundException(
              String.format("Message with ID=%s not found", elementId));
        }
        break;
      case response:
        Objects.requireNonNull(parentId, "Parent ID or name missing");

        List<MessageType> messages2 = getMessageList(repository);

        Optional<MessageType> optMessage2 = messages2.stream()
            .filter(m -> Integer.parseInt(parentId) == m.getId().intValue()).findFirst();

        if (optMessage2.isPresent()) {
          List<ResponseType> responses = getResponseList(optMessage2.get());
          Optional<ResponseType> optResponse =
              responses.stream().filter(r -> elementId.equals(r.getName())).findFirst();
          if (optResponse.isPresent()) {
            optResponse.get().setAnnotation(null);
          } else {
            throw new ResourceNotFoundException(
                String.format("Message response %s not found", elementId));
          }
        } else {
          throw new ResourceNotFoundException(
              String.format("Message with ID=%s not found", parentId));
        }
        break;
      case stateMachine:
        List<ActorType> actors2 = getActorList(repository);
        Optional<ActorType> optActor2 =
            actors2.stream().filter(a -> parentId.equals(a.getName())).findFirst();

        if (optActor2.isPresent()) {
          List<Object> elements = optActor2.get().getFieldOrFieldRefOrComponent();
          Optional<StateMachineType> optStateMachine = elements.stream()
              .filter(o -> o instanceof StateMachineType).map(o -> (StateMachineType) o)
              .filter(sm -> elementId.equals(sm.getName())).findFirst();
          if (optStateMachine.isPresent()) {
            optStateMachine.get().setAnnotation(null);
          } else {
            throw new ResourceNotFoundException(
                String.format("StateMachine %s not found", elementId));
          }

        } else {
          throw new ResourceNotFoundException(String.format("Actor %s not found", parentId));
        }
        break;
    }
  }

  @Override
  public void deleteCode(String reposName, String version, Integer codesetid, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codesetid, "CodeSet ID missing");
    Objects.requireNonNull(id, "Code ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);
    for (CodeSetType codeSet : codeSets) {
      if (codesetid == codeSet.getId().intValue()) {
        List<CodeType> codes = codeSet.getCode();
        for (CodeType codeType : codes) {
          if (codeType.getId().intValue() == id) {
            codes.remove(codeType);
            return;
          }
        }
        throw new ResourceNotFoundException(String.format("Code with ID=%d not found", id));
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", codesetid));
  }

  @Override
  public void deleteCodeSet(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "CodeSet ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);
    for (CodeSetType codeSet : codeSets) {
      if (id == codeSet.getId().intValue()) {
        codeSets.remove(codeSet);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
  }

  @Override
  public void deleteComponent(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Component ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<ComponentType> components = getComponentList(repository);
    for (ComponentType component : components) {
      if (id == component.getId().intValue()) {
        components.remove(component);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Component with ID=%d not found", id));
  }

  @Override
  public void deleteDatatype(String reposName, String version, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Datatype name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    for (io.fixprotocol._2016.fixrepository.Datatype datatype : datatypes) {
      if (name.equals(datatype.getName())) {
        datatypes.remove(datatype);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Datetype %s not found", name));
  }

  @Override
  public void deleteField(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Field ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<FieldType> fields = getFieldList(repository);
    for (FieldType field : fields) {
      if (id == field.getId().intValue()) {
        fields.remove(field);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Field with ID=%d not found", id));
  }

  @Override
  public void deleteFlow(String reposName, String version, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Flow name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    Actors actors = repository.getActors();
    if (actors == null) {
      throw new ResourceNotFoundException(String.format("Flow %s not found", name));
    }

    List<Object> actorsOrFlows = actors.getActorOrFlow();
    for (Object obj : actorsOrFlows) {
      if (obj instanceof FlowType) {
        FlowType flowType = (FlowType) obj;
        if (flowType.getName().equals(name)) {
          actorsOrFlows.remove(obj);
          return;
        }
      }
    }

    throw new ResourceNotFoundException(String.format("Flow %s not found", name));
  }

  @Override
  public void deleteGroup(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    deleteComponent(reposName, version, id);
  }

  @Override
  public void deleteMessage(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Message ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<MessageType> messages = getMessageList(repository);
    for (MessageType message : messages) {
      if (id == message.getId().intValue()) {
        messages.remove(message);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Message with ID=%d not found", id));
  }

  @Override
  public void deleteMessageResponse(String reposName, String version, Integer id, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Message ID missing");
    Objects.requireNonNull(name, "Response name missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<MessageType> messageList = getMessageList(repository);

    for (MessageType messageType : messageList) {
      if (id == messageType.getId().intValue()) {
        List<ResponseType> responseList = getResponseList(messageType);
        for (ResponseType responseType : responseList) {
          if (name.equals(responseType.getName())) {
            responseList.remove(responseType);
            return;
          }
        }
        throw new ResourceNotFoundException(String.format("Response %s not found", name));
      }
    }
    throw new ResourceNotFoundException(String.format("Message with ID=%d not found", id));
  }

  @Override
  public void deleteRepository(String reposName, String version) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    if (repositories.remove(key) == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
  }

  @Override
  public void deleteStateMachine(String reposName, String version, String actor, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(actor, "Actor name missing");
    Objects.requireNonNull(name, "StateMachine name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<ActorType> actorList = getActorList(repository);
    for (ActorType actorType : actorList) {
      if (actor.equals(actorType.getName())) {
        List<Object> elements = actorType.getFieldOrFieldRefOrComponent();
        for (int i = 0; i < elements.size(); i++) {
          if (elements.get(i) instanceof StateMachineType
              && name.equals(((StateMachineType) elements.get(i)).getName())) {
            elements.remove(i);
            return;
          }
        }
        throw new ResourceNotFoundException(String.format("State machine %s not found", name));

      }
    }

    throw new ResourceNotFoundException(String.format("Actor %s not found", name));
  }

  @Override
  public Actor getActor(String reposName, String version, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Actor name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<ActorType> actors = getActorList(repository);
    Optional<ActorType> optActor =
        actors.stream().filter(a -> name.equals(a.getName())).findFirst();

    if (optActor.isPresent()) {
      return OrchestraAPItoDOM.DOMToActor(optActor.get());
    } else {
      throw new ResourceNotFoundException(String.format("Actor %s not found", name));
    }
  }

  @Override
  public List<Actor> getActors(String reposName, String version, Predicate<Actor> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Actor> predicate = search != null ? search : t -> true;

    List<ActorType> actors = getActorList(repository);

    return actors.stream().map(OrchestraAPItoDOM::DOMToActor).filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public Annotation getAnnotations(String reposName, String version, String elementId,
      ElementType elementType, String parentId, Predicate<Documentation> documentationSearch,
      Predicate<Appinfo> appInfoSearch) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(elementType, "Element type missing");
    Objects.requireNonNull(elementId, "Element ID or name missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    Predicate<Documentation> documentationPredicate =
        documentationSearch != null ? documentationSearch : t -> true;
    Predicate<Appinfo> appInfoPredicate = appInfoSearch != null ? appInfoSearch : t -> true;

    Annotation annotation = null;
    switch (elementType) {
      case actor:
        List<ActorType> actors = getActorList(repository);
        Optional<ActorType> optActor =
            actors.stream().filter(a -> elementId.equals(a.getName())).findFirst();
        if (optActor.isPresent()) {
          annotation = OrchestraAPItoDOM.DOMToAnnotation(optActor.get().getAnnotation());
        } else {
          throw new ResourceNotFoundException(String.format("Actor %s not found", elementId));
        }
        break;
      case code:
        Objects.requireNonNull(parentId, "Parent ID missing");

        List<CodeSetType> codeSets = getCodeSets(repository);
        Optional<CodeSetType> optCodeSet = codeSets.stream()
            .filter(cs -> Integer.parseInt(parentId) == cs.getId().intValue()).findFirst();
        if (optCodeSet.isPresent()) {
          List<CodeType> codes = optCodeSet.get().getCode();
          Optional<CodeType> optCode = codes.stream()
              .filter(c -> c.getId().intValue() == Integer.parseInt(elementId)).findFirst();
          if (optCode.isPresent()) {
            annotation = OrchestraAPItoDOM.DOMToAnnotation(optCode.get().getAnnotation());
          } else {
            throw new ResourceNotFoundException(
                String.format("Code with ID=%s not found", elementId));
          }
        } else {
          throw new ResourceNotFoundException(
              String.format("CodeSet with ID=%s not found", parentId));
        }
        break;
      case codeSet:
        List<CodeSetType> codeSets2 = getCodeSets(repository);
        Optional<CodeSetType> optCodeSet2 = codeSets2.stream()
            .filter(cs -> Integer.parseInt(elementId) == cs.getId().intValue()).findFirst();
        if (optCodeSet2.isPresent()) {
          annotation = OrchestraAPItoDOM.DOMToAnnotation(optCodeSet2.get().getAnnotation());
        } else {
          throw new ResourceNotFoundException(
              String.format("CodeSet with ID=%s not found", elementId));
        }
        break;
      case component:
        List<ComponentType> components = getComponentList(repository);

        Optional<ComponentType> optComponent = components.stream()
            .filter(c -> Integer.parseInt(elementId) == c.getId().intValue()).findFirst();

        if (optComponent.isPresent()) {
          annotation = OrchestraAPItoDOM.DOMToAnnotation(optComponent.get().getAnnotation());

        } else {
          throw new ResourceNotFoundException(
              String.format("Component with ID=%s not found", elementId));
        }
        break;
      case datatype:
        List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

        Optional<io.fixprotocol._2016.fixrepository.Datatype> optDatatype =
            datatypes.stream().filter(d -> elementId.equals(d.getName())).findFirst();

        if (optDatatype.isPresent()) {
          annotation = OrchestraAPItoDOM.DOMToAnnotation(optDatatype.get().getAnnotation());

        } else {
          throw new ResourceNotFoundException(String.format("Datatype %s not found", elementId));
        }
        break;
      case field:
        List<FieldType> fields = getFieldList(repository);

        Optional<FieldType> optField = fields.stream()
            .filter(f -> Integer.parseInt(elementId) == f.getId().intValue()).findFirst();

        if (optField.isPresent()) {
          annotation = OrchestraAPItoDOM.DOMToAnnotation(optField.get().getAnnotation());
        } else {
          throw new ResourceNotFoundException(
              String.format("Field with ID=%s not found", elementId));
        }
        break;
      case flow:
        List<FlowType> flows = getFlowList(repository);
        Optional<FlowType> optFlow =
            flows.stream().filter(f -> elementId.equals(f.getName())).findFirst();

        if (optFlow.isPresent()) {
          annotation = OrchestraAPItoDOM.DOMToAnnotation(optFlow.get().getAnnotation());
        } else {
          throw new ResourceNotFoundException(String.format("Flow %s not found", elementId));
        }
        break;
      case group:
        List<ComponentType> components2 = getComponentList(repository);

        Optional<GroupType> optGroup =
            components2.stream().filter(c -> Integer.parseInt(elementId) == c.getId().intValue())
                .filter(c -> c instanceof GroupType).map(c -> (GroupType) c).findFirst();

        if (optGroup.isPresent()) {
          annotation = OrchestraAPItoDOM.DOMToAnnotation(optGroup.get().getAnnotation());
        } else {
          throw new ResourceNotFoundException(
              String.format("Group with ID=%s not found", elementId));
        }
        break;
      case message:
        List<MessageType> messages = getMessageList(repository);

        Optional<MessageType> optMessage = messages.stream()
            .filter(m -> Integer.parseInt(elementId) == m.getId().intValue()).findFirst();

        if (optMessage.isPresent()) {
          annotation = OrchestraAPItoDOM.DOMToAnnotation(optMessage.get().getAnnotation());
        } else {
          throw new ResourceNotFoundException(
              String.format("Message with ID=%s not found", elementId));
        }
        break;
      case response:
        Objects.requireNonNull(parentId, "Parent ID or name missing");

        List<MessageType> messages2 = getMessageList(repository);

        Optional<MessageType> optMessage2 = messages2.stream()
            .filter(m -> Integer.parseInt(parentId) == m.getId().intValue()).findFirst();

        if (optMessage2.isPresent()) {
          List<ResponseType> responses = getResponseList(optMessage2.get());
          Optional<ResponseType> optResponse =
              responses.stream().filter(r -> elementId.equals(r.getName())).findFirst();
          if (optResponse.isPresent()) {
            annotation = OrchestraAPItoDOM.DOMToAnnotation(optResponse.get().getAnnotation());
          } else {
            throw new ResourceNotFoundException(
                String.format("Message response %s not found", elementId));
          }
        } else {
          throw new ResourceNotFoundException(
              String.format("Message with ID=%s not found", parentId));
        }
        break;
      case stateMachine:
        List<ActorType> actors2 = getActorList(repository);
        Optional<ActorType> optActor2 =
            actors2.stream().filter(a -> parentId.equals(a.getName())).findFirst();

        if (optActor2.isPresent()) {
          List<Object> elements = optActor2.get().getFieldOrFieldRefOrComponent();
          Optional<StateMachineType> optStateMachine = elements.stream()
              .filter(o -> o instanceof StateMachineType).map(o -> (StateMachineType) o)
              .filter(sm -> elementId.equals(sm.getName())).findFirst();
          if (optStateMachine.isPresent()) {
            annotation = OrchestraAPItoDOM.DOMToAnnotation(optStateMachine.get().getAnnotation());
          } else {
            throw new ResourceNotFoundException(
                String.format("StateMachine %s not found", elementId));
          }

        } else {
          throw new ResourceNotFoundException(String.format("Actor %s not found", parentId));
        }
        break;
    }
    if (annotation == null) {
      throw new ResourceNotFoundException("Annotation not found");
    }
    Annotation filtered = new Annotation();
    annotation.getAppinfo().stream().filter(appInfoPredicate).forEach(filtered::addAppinfoItem);
    annotation.getDocumentation().stream().filter(documentationPredicate)
        .forEach(filtered::addDocumentationItem);
    return filtered;
  }

  @Override
  public Code getCodeById(String reposName, String version, Integer codesetid, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codesetid, "CodeSet ID missing");
    Objects.requireNonNull(id, "Code ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);
    Optional<CodeSetType> optCodeSet =
        codeSets.stream().filter(cs -> codesetid == cs.getId().intValue()).findFirst();
    if (optCodeSet.isPresent()) {
      List<CodeType> codes = optCodeSet.get().getCode();
      Optional<CodeType> optCode =
          codes.stream().filter(c -> c.getId().intValue() == id).findFirst();
      if (optCode.isPresent()) {
        return OrchestraAPItoDOM.DOMToCode(optCode.get());
      } else {
        throw new ResourceNotFoundException(String.format("Code with ID=%d not found", id));
      }
    } else {
      throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
    }
  }

  @Override
  public List<Code> getCodes(String reposName, String version, Integer codesetid,
      Predicate<Code> search) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codesetid, "CodeSet ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    Predicate<Code> predicate = search != null ? search : t -> true;

    List<CodeSetType> codeSets = getCodeSets(repository);
    Optional<CodeSetType> optCodeSet =
        codeSets.stream().filter(cs -> codesetid == cs.getId().intValue()).findFirst();
    if (optCodeSet.isPresent()) {
      List<CodeType> codes = optCodeSet.get().getCode();
      return codes.stream().map(OrchestraAPItoDOM::DOMToCode).filter(predicate)
          .collect(Collectors.toList());
    } else {
      throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", codesetid));
    }
  }

  @Override
  public CodeSet getCodeSetById(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "CodeSet ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<CodeSetType> codeSets = getCodeSets(repository);
    Optional<CodeSetType> optCodeSet =
        codeSets.stream().filter(cs -> id == cs.getId().intValue()).findFirst();
    if (optCodeSet.isPresent()) {
      return OrchestraAPItoDOM.DOMToCodeSet(optCodeSet.get());
    } else {
      throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
    }
  }

  @Override
  public List<CodeSet> getCodeSets(String reposName, String version, Predicate<CodeSet> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<CodeSet> predicate = search != null ? search : t -> true;
    List<CodeSetType> codeSets = getCodeSets(repository);

    return codeSets.stream().map(OrchestraAPItoDOM::DOMToCodeSet).filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public Component getComponentById(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Component ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<ComponentType> components = getComponentList(repository);

    Optional<ComponentType> optComponent =
        components.stream().filter(c -> id == c.getId().intValue()).findFirst();

    if (optComponent.isPresent()) {
      return OrchestraAPItoDOM.DOMToComponent(optComponent.get());
    } else {
      throw new ResourceNotFoundException(String.format("Component with ID=%d not found", id));
    }
  }

  @Override
  public List<Component> getComponents(String reposName, String version,
      Predicate<Component> search) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Component> predicate = search != null ? search : t -> true;
    List<ComponentType> components = getComponentList(repository);

    // ComponentType only, not subclass
    return components.stream().filter(c -> c.getClass().equals(ComponentType.class))
        .map(OrchestraAPItoDOM::DOMToComponent).filter(predicate).collect(Collectors.toList());
  }

  @Override
  public Datatype getDatatype(String reposName, String version, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Datatype name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    Optional<io.fixprotocol._2016.fixrepository.Datatype> optDatatype =
        datatypes.stream().filter(d -> name.equals(d.getName())).findFirst();

    if (optDatatype.isPresent()) {
      return OrchestraAPItoDOM.DOMToDatatype(optDatatype.get());
    } else {
      throw new ResourceNotFoundException(String.format("Datatype %s not found", name));
    }
  }

  @Override
  public List<Datatype> getDatatypes(String reposName, String version, Predicate<Datatype> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Datatype> predicate = search != null ? search : t -> true;

    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    return datatypes.stream().map(OrchestraAPItoDOM::DOMToDatatype).filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public Field getFieldById(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Field ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<FieldType> fields = getFieldList(repository);

    Optional<FieldType> optField =
        fields.stream().filter(f -> id == f.getId().intValue()).findFirst();

    if (optField.isPresent()) {
      return OrchestraAPItoDOM.DOMToField(optField.get());
    } else {
      throw new ResourceNotFoundException(String.format("Field with ID=%d not found", id));
    }
  }

  @Override
  public List<Field> getFields(String reposName, String version, Predicate<Field> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Field> predicate = search != null ? search : t -> true;
    List<FieldType> fields = getFieldList(repository);

    return fields.stream().map(OrchestraAPItoDOM::DOMToField).filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public Flow getFlow(String reposName, String version, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Flow name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<FlowType> flows = getFlowList(repository);

    Optional<FlowType> optFlow = flows.stream().filter(f -> name.equals(f.getName())).findFirst();

    if (optFlow.isPresent()) {
      return OrchestraAPItoDOM.DOMToFlow(optFlow.get());
    } else {
      throw new ResourceNotFoundException(String.format("Flow %s not found", name));
    }
  }

  @Override
  public List<Flow> getFlows(String reposName, String version, Predicate<Flow> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Flow> predicate = search != null ? search : t -> true;

    List<FlowType> flows = getFlowList(repository);

    return flows.stream().map(OrchestraAPItoDOM::DOMToFlow).filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public Group getGroupById(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Component ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<ComponentType> components = getComponentList(repository);

    Optional<GroupType> optGroup = components.stream().filter(c -> id == c.getId().intValue())
        .filter(c -> c instanceof GroupType).map(c -> (GroupType) c).findFirst();

    if (optGroup.isPresent()) {
      return OrchestraAPItoDOM.DOMToGroup(optGroup.get());
    } else {
      throw new ResourceNotFoundException(String.format("Group with ID=%d not found", id));
    }
  }

  @Override
  public List<Group> getGroups(String reposName, String version, Predicate<Group> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Group> predicate = search != null ? search : t -> true;
    List<ComponentType> components = getComponentList(repository);

    Function<ComponentType, GroupType> subclass = c -> (GroupType) c;

    return components.stream().filter(c -> c instanceof GroupType).map(subclass)
        .map(OrchestraAPItoDOM::DOMToGroup).filter(predicate).collect(Collectors.toList());
  }

  @Override
  public Message getMessageById(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Message ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<MessageType> messages = getMessageList(repository);

    Optional<MessageType> optMessage =
        messages.stream().filter(f -> id == f.getId().intValue()).findFirst();

    if (optMessage.isPresent()) {
      return OrchestraAPItoDOM.DOMToMessage(optMessage.get());
    } else {
      throw new ResourceNotFoundException(String.format("Message with ID=%d not found", id));
    }
  }

  @Override
  public Response getMessageResponse(String reposName, String version, Integer id, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Message ID missing");
    Objects.requireNonNull(name, "Response name missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<MessageType> messages = getMessageList(repository);

    Optional<MessageType> optMessage =
        messages.stream().filter(m -> id == m.getId().intValue()).findFirst();

    if (optMessage.isPresent()) {
      List<ResponseType> responses = getResponseList(optMessage.get());
      Optional<ResponseType> optResponse =
          responses.stream().filter(r -> name.equals(r.getName())).findFirst();
      if (optResponse.isPresent()) {
        return OrchestraAPItoDOM.DOMToResponse(optResponse.get());
      } else {
        throw new ResourceNotFoundException(String.format("Message response %s not found", name));
      }
    } else {
      throw new ResourceNotFoundException(String.format("Message with ID=%d not found", id));
    }
  }

  @Override
  public List<Response> getMessageResponses(String reposName, String version, Integer id,
      Predicate<Response> search) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Message ID missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Response> predicate = search != null ? search : t -> true;

    List<MessageType> messages = getMessageList(repository);

    for (MessageType messageType : messages) {
      if (id == messageType.getId().intValue()) {
        List<ResponseType> responseList = getResponseList(messageType);
        return responseList.stream().map(OrchestraAPItoDOM::DOMToResponse).filter(predicate)
            .collect(Collectors.toList());
      }
    }
    throw new ResourceNotFoundException(String.format("Message with ID=%d not found", id));


  }

  @Override
  public List<Message> getMessages(String reposName, String version, Predicate<Message> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Message> predicate = search != null ? search : t -> true;
    List<MessageType> messages = getMessageList(repository);

    return messages.stream().map(OrchestraAPItoDOM::DOMToMessage).filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public List<Metadata> getRepositoriesMetadata(Predicate<Metadata> search) {
    Predicate<Metadata> predicate = search != null ? search : t -> true;
    return repositories.values().stream().map(r -> OrchestraAPItoDOM.DOMToMetadata(r.getMetadata()))
        .filter(predicate).collect(Collectors.toList());
  }

  @Override
  public File getRepositoryFile(String reposName, String version) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository != null) {
      try {
        return marshal(repository);
      } catch (JAXBException | IOException e) {
        throw new RepositoryStoreException("Unable to produce repository file", e);
      }
    } else {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
  }

  @Override
  public Metadata getRepositoryMetadata(String reposName, String version)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository != null) {
      return OrchestraAPItoDOM.DOMToMetadata(repository.getMetadata());
    } else {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
  }

  @Override
  public StateMachine getStateMachine(String reposName, String version, String actor, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(actor, "Actor name missing");
    Objects.requireNonNull(name, "StateMachine name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<ActorType> actors = getActorList(repository);
    Optional<ActorType> optActor =
        actors.stream().filter(a -> actor.equals(a.getName())).findFirst();

    if (optActor.isPresent()) {
      List<Object> elements = optActor.get().getFieldOrFieldRefOrComponent();
      Optional<StateMachineType> optStateMachine =
          elements.stream().filter(o -> o instanceof StateMachineType)
              .map(o -> (StateMachineType) o).filter(sm -> name.equals(sm.getName())).findFirst();
      if (optStateMachine.isPresent()) {
        return OrchestraAPItoDOM.DOMToStateMachine(optStateMachine.get());
      } else {
        throw new ResourceNotFoundException(String.format("StateMachine %s not found", name));
      }

    } else {
      throw new ResourceNotFoundException(String.format("Actor %s not found", name));
    }
  }

  @Override
  public List<StateMachine> getStateMachines(String reposName, String version,
      Predicate<StateMachine> search) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<StateMachine> predicate = search != null ? search : t -> true;

    List<ActorType> actors = getActorList(repository);

    return actors.stream().flatMap(a -> a.getFieldOrFieldRefOrComponent().stream())
        .filter(o -> o instanceof StateMachineType).map(o -> (StateMachineType) o)
        .map(OrchestraAPItoDOM::DOMToStateMachine).filter(predicate).collect(Collectors.toList());
  }


  @Override
  public void updateActor(String reposName, String version, String name, Actor actor)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Actor name missing");
    Objects.requireNonNull(actor, "Actor value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    Actors actors = repository.getActors();
    if (actors == null) {
      throw new ResourceNotFoundException(String.format("Actor %s not found", name));
    }

    List<Object> actorsOrFlows = actors.getActorOrFlow();
    for (int i = 0; i < actorsOrFlows.size(); i++) {
      if (actorsOrFlows.get(i) instanceof ActorType) {
        ActorType actorType = (ActorType) actorsOrFlows.get(i);
        if (actorType.getName().equals(name)) {
          actorsOrFlows.set(i, OrchestraAPItoDOM.ActorToDOM(actor));
          return;
        }
      }
    }

    throw new ResourceNotFoundException(String.format("Actor %s not found", name));
  }

  @Override
  public void updateAnnotation(String reposName, String version, String elementId,
      ElementType elementType, String parentId, Annotation annotation)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(elementType, "Element type missing");
    Objects.requireNonNull(elementId, "Element ID or name missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    switch (elementType) {
      case actor:
        List<ActorType> actors = getActorList(repository);
        Optional<ActorType> optActor =
            actors.stream().filter(a -> elementId.equals(a.getName())).findFirst();
        if (optActor.isPresent()) {
          optActor.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(String.format("Actor %s not found", elementId));
        }
        break;
      case code:
        Objects.requireNonNull(parentId, "Parent ID missing");

        List<CodeSetType> codeSets = getCodeSets(repository);
        Optional<CodeSetType> optCodeSet = codeSets.stream()
            .filter(cs -> Integer.parseInt(parentId) == cs.getId().intValue()).findFirst();
        if (optCodeSet.isPresent()) {
          List<CodeType> codes = optCodeSet.get().getCode();
          Optional<CodeType> optCode = codes.stream()
              .filter(c -> c.getId().intValue() == Integer.parseInt(elementId)).findFirst();
          if (optCode.isPresent()) {
            optCode.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
          } else {
            throw new ResourceNotFoundException(
                String.format("Code with ID=%s not found", elementId));
          }
        } else {
          throw new ResourceNotFoundException(
              String.format("CodeSet with ID=%s not found", parentId));
        }
        break;
      case codeSet:
        List<CodeSetType> codeSets2 = getCodeSets(repository);
        Optional<CodeSetType> optCodeSet2 = codeSets2.stream()
            .filter(cs -> Integer.parseInt(elementId) == cs.getId().intValue()).findFirst();
        if (optCodeSet2.isPresent()) {
          optCodeSet2.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("CodeSet with ID=%s not found", elementId));
        }
        break;
      case component:
        List<ComponentType> components = getComponentList(repository);

        Optional<ComponentType> optComponent = components.stream()
            .filter(c -> Integer.parseInt(elementId) == c.getId().intValue()).findFirst();

        if (optComponent.isPresent()) {
          optComponent.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("Component with ID=%s not found", elementId));
        }
        break;
      case datatype:
        List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

        Optional<io.fixprotocol._2016.fixrepository.Datatype> optDatatype =
            datatypes.stream().filter(d -> elementId.equals(d.getName())).findFirst();

        if (optDatatype.isPresent()) {
          optDatatype.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(String.format("Datatype %s not found", elementId));
        }
        break;
      case field:
        List<FieldType> fields = getFieldList(repository);

        Optional<FieldType> optField = fields.stream()
            .filter(f -> Integer.parseInt(elementId) == f.getId().intValue()).findFirst();

        if (optField.isPresent()) {
          optField.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("Field with ID=%s not found", elementId));
        }
        break;
      case flow:
        List<FlowType> flows = getFlowList(repository);
        Optional<FlowType> optFlow =
            flows.stream().filter(f -> elementId.equals(f.getName())).findFirst();

        if (optFlow.isPresent()) {
          optFlow.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(String.format("Flow %s not found", elementId));
        }
        break;
      case group:
        List<ComponentType> components2 = getComponentList(repository);

        Optional<GroupType> optGroup =
            components2.stream().filter(c -> Integer.parseInt(elementId) == c.getId().intValue())
                .filter(c -> c instanceof GroupType).map(c -> (GroupType) c).findFirst();

        if (optGroup.isPresent()) {
          optGroup.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("Group with ID=%s not found", elementId));
        }
        break;
      case message:
        List<MessageType> messages = getMessageList(repository);

        Optional<MessageType> optMessage = messages.stream()
            .filter(m -> Integer.parseInt(elementId) == m.getId().intValue()).findFirst();

        if (optMessage.isPresent()) {
          optMessage.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
        } else {
          throw new ResourceNotFoundException(
              String.format("Message with ID=%s not found", elementId));
        }
        break;
      case response:
        Objects.requireNonNull(parentId, "Parent ID or name missing");

        List<MessageType> messages2 = getMessageList(repository);

        Optional<MessageType> optMessage2 = messages2.stream()
            .filter(m -> Integer.parseInt(parentId) == m.getId().intValue()).findFirst();

        if (optMessage2.isPresent()) {
          List<ResponseType> responses = getResponseList(optMessage2.get());
          Optional<ResponseType> optResponse =
              responses.stream().filter(r -> elementId.equals(r.getName())).findFirst();
          if (optResponse.isPresent()) {
            optResponse.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
          } else {
            throw new ResourceNotFoundException(
                String.format("Message response %s not found", elementId));
          }
        } else {
          throw new ResourceNotFoundException(
              String.format("Message with ID=%s not found", parentId));
        }
        break;
      case stateMachine:
        List<ActorType> actors2 = getActorList(repository);
        Optional<ActorType> optActor2 =
            actors2.stream().filter(a -> parentId.equals(a.getName())).findFirst();

        if (optActor2.isPresent()) {
          List<Object> elements = optActor2.get().getFieldOrFieldRefOrComponent();
          Optional<StateMachineType> optStateMachine = elements.stream()
              .filter(o -> o instanceof StateMachineType).map(o -> (StateMachineType) o)
              .filter(sm -> elementId.equals(sm.getName())).findFirst();
          if (optStateMachine.isPresent()) {
            optStateMachine.get().setAnnotation(OrchestraAPItoDOM.AnnotationToDOM(annotation));
          } else {
            throw new ResourceNotFoundException(
                String.format("StateMachine %s not found", elementId));
          }

        } else {
          throw new ResourceNotFoundException(String.format("Actor %s not found", parentId));
        }
        break;
    }
  }

  @Override
  public void updateCode(String reposName, String version, Integer codesetid, Integer id, Code code)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "CodeSet ID missing");
    Objects.requireNonNull(code, "Code value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<CodeSetType> codeSets = getCodeSets(repository);
    for (CodeSetType codeSet : codeSets) {
      if (codesetid == codeSet.getId().intValue()) {
        List<CodeType> codes = codeSet.getCode();
        for (int i = 0; i < codes.size(); i++) {
          if (codes.get(i).getId().intValue() == id) {
            codes.set(i, OrchestraAPItoDOM.CodeToDOM(code));
            return;
          }
        }
        throw new ResourceNotFoundException(String.format("Code with ID=%d not found", id));
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
  }

  @Override
  public void updateCodeSet(String reposName, String version, Integer id, CodeSet codeSet)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "CodeSet ID missing");
    Objects.requireNonNull(codeSet, "CodeSet value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);

    for (int i = 0; i < codeSets.size(); i++) {
      CodeSetType codeSetType = codeSets.get(i);
      if (id == codeSetType.getId().intValue()) {
        codeSets.set(i, OrchestraAPItoDOM.CodeSetToDOM(codeSet));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
  }

  @Override
  public void updateComponent(String reposName, String version, Integer id, Component component)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Component ID missing");
    Objects.requireNonNull(component, "Component value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<ComponentType> components = getComponentList(repository);

    for (int i = 0; i < components.size(); i++) {
      ComponentType componentType = components.get(i);
      if (id == componentType.getId().intValue()) {
        components.set(i, OrchestraAPItoDOM.ComponentToDOM(component));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Component with ID=%d not found", id));
  }

  @Override
  public void updateDatatype(String reposName, String version, String name, Datatype datatype)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Datatype name missing");
    Objects.requireNonNull(datatype, "Datatype value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    for (int i = 0; i < datatypes.size(); i++) {
      io.fixprotocol._2016.fixrepository.Datatype datatypeDOM = datatypes.get(i);
      if (name.equals(datatypeDOM.getName())) {
        datatypes.set(i, OrchestraAPItoDOM.DatatypeToDOM(datatype));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Datatype %s not found", name));
  }

  @Override
  public void updateField(String reposName, String version, Integer id, Field field)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Field ID missing");
    Objects.requireNonNull(field, "Field value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<FieldType> fields = getFieldList(repository);

    for (int i = 0; i < fields.size(); i++) {
      FieldType fieldType = fields.get(i);
      if (id == fieldType.getId().intValue()) {
        fields.set(i, OrchestraAPItoDOM.FieldToDOM(field));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Field with ID=%d not found", id));
  }

  @Override
  public void updateFlow(String reposName, String version, String name, Flow flow)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Flow name missing");
    Objects.requireNonNull(flow, "Flow value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    Actors actors = repository.getActors();
    if (actors == null) {
      throw new ResourceNotFoundException(String.format("Flow %s not found", name));
    }

    List<Object> actorsOrFlows = actors.getActorOrFlow();
    for (int i = 0; i < actorsOrFlows.size(); i++) {
      if (actorsOrFlows.get(i) instanceof FlowType) {
        FlowType flowType = (FlowType) actorsOrFlows.get(i);
        if (flowType.getName().equals(name)) {
          actorsOrFlows.set(i, OrchestraAPItoDOM.FlowToDOM(flow));
          return;
        }
      }
    }

    throw new ResourceNotFoundException(String.format("Actor %s not found", name));
  }

  @Override
  public void updateGroup(String reposName, String version, Integer id, Group group)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Group ID missing");
    Objects.requireNonNull(group, "Group value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<ComponentType> components = getComponentList(repository);

    for (int i = 0; i < components.size(); i++) {
      ComponentType componentType = components.get(i);
      if (id == componentType.getId().intValue()) {
        components.set(i, OrchestraAPItoDOM.ComponentToDOM(group));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Group with ID=%d not found", id));
  }

  @Override
  public void updateMessage(String reposName, String version, Integer id, Message message)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Message ID missing");
    Objects.requireNonNull(message, "Message value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<MessageType> messages = getMessageList(repository);

    for (int i = 0; i < messages.size(); i++) {
      MessageType messageType = messages.get(i);
      if (id == messageType.getId().intValue()) {
        messages.set(i, OrchestraAPItoDOM.MessageToDOM(message));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Component with ID=%d not found", id));
  }

  @Override
  public void updateMessageResponse(String reposName, String version, Integer id, String name,
      Response response) throws RepositoryStoreException {
    Objects.requireNonNull(response, "Message response value missing");
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Message ID missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<MessageType> messageList = getMessageList(repository);

    for (MessageType messageType : messageList) {
      if (id == messageType.getId().intValue()) {
        List<ResponseType> responseList = getResponseList(messageType);
        for (int j = 0; j < responseList.size(); j++) {
          ResponseType responseType = responseList.get(j);
          if (response.getName().equals(responseType.getName())) {
            responseList.set(j, OrchestraAPItoDOM.ResponseToDOM(response));
            return;
          }
        }
        throw new ResourceNotFoundException(String.format("Response %s not found", name));
      }
    }
    throw new ResourceNotFoundException(String.format("Message with ID=%d not found", id));
  }

  @Override
  public void updateRepositoryFromFile(InputStream stream)
      throws ResourceNotFoundException, RepositoryStoreException {
    Objects.requireNonNull(stream, "File missing");
    try {
      Repository repository = unMarshal(stream);
      final RepositoryKey key = new RepositoryKey(repository.getName(), repository.getVersion());
      Repository exists = repositories.get(key);
      if (exists == null) {
        throw new ResourceNotFoundException(
            String.format("Repository not found with name=%s version=%s", repository.getName(),
                repository.getVersion()));
      }
      repositories.put(key, repository);
    } catch (JAXBException e) {
      throw new RepositoryStoreException("Unable to read or parse repository file", e);
    }
  }

  @Override
  public void updateRepositoryMetadata(String reposName, String version,
      io.fixprotocol.orchestra.model.Repository repository) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repositoryToUpdate = repositories.get(key);
    if (repositoryToUpdate != null) {
      repositoryToUpdate.setMetadata(OrchestraAPItoDOM.MetadataToDOM(repository.getMetadata()));
    } else {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
  }

  @Override
  public void updateStateMachine(String reposName, String version, String actor, String name,
      StateMachine stateMachine) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(actor, "Actor name missing");
    Objects.requireNonNull(name, "StateMachine name missing");
    Objects.requireNonNull(stateMachine, "StateMachine value missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    Actors actors = repository.getActors();
    if (actors == null) {
      throw new ResourceNotFoundException(String.format("Actor %s not found", actor));
    }

    Optional<ActorType> opt = actors.getActorOrFlow().stream().filter(o -> o instanceof ActorType)
        .map(o -> (ActorType) o).filter(a -> actor.equals(a.getName())).findFirst();
    if (opt.isPresent()) {
      ActorType actorType = opt.get();
      List<Object> elements = actorType.getFieldOrFieldRefOrComponent();
      for (int j = 0; j < elements.size(); j++) {
        if (elements.get(j) instanceof StateMachineType) {
          StateMachineType stateMachineType = (StateMachineType) elements.get(j);
          if (name.equals(stateMachineType.getName())) {
            elements.set(j, OrchestraAPItoDOM.StateMachineToDOM(stateMachine));
            return;
          }
        }
      }
      throw new ResourceNotFoundException(String.format("StateMachine %s not found", name));
    } else {
      throw new ResourceNotFoundException(String.format("Actor %s not found", actor));
    }
  }

  private List<ActorType> getActorList(Repository repository) {
    Actors actors = repository.getActors();
    if (actors == null) {
      actors = new Actors();
      repository.setActors(actors);
    }
    return actors.getActorOrFlow().stream().filter(o -> o instanceof ActorType)
        .map(o -> (ActorType) o).collect(Collectors.toList());
  }

  private List<CodeSetType> getCodeSets(Repository repository) {
    CodeSets codeSets = repository.getCodeSets();
    if (codeSets == null) {
      codeSets = new CodeSets();
      repository.setCodeSets(codeSets);
    }
    return codeSets.getCodeSet();
  }

  private List<ComponentType> getComponentList(Repository repository) {
    Components components = repository.getComponents();
    if (components == null) {
      components = new Components();
      repository.setComponents(components);
    }
    return components.getComponentOrGroup();
  }

  private List<io.fixprotocol._2016.fixrepository.Datatype> getDatatypeList(Repository repository) {
    Datatypes datatypes = repository.getDatatypes();
    if (datatypes == null) {
      datatypes = new Datatypes();
      repository.setDatatypes(datatypes);
    }
    return datatypes.getDatatype();
  }

  private List<FieldType> getFieldList(Repository repository) {
    Fields fields = repository.getFields();
    if (fields == null) {
      fields = new Fields();
      repository.setFields(fields);
    }
    return fields.getField();
  }

  private List<FlowType> getFlowList(Repository repository) {
    Actors actors = repository.getActors();
    if (actors == null) {
      actors = new Actors();
      repository.setActors(actors);
    }
    return actors.getActorOrFlow().stream().filter(o -> o instanceof FlowType)
        .map(o -> (FlowType) o).collect(Collectors.toList());
  }

  private List<MessageType> getMessageList(Repository repository) {
    Messages messages = repository.getMessages();
    if (messages == null) {
      messages = new Messages();
      repository.setMessages(messages);
    }
    return messages.getMessage();
  }

  private List<ResponseType> getResponseList(MessageType messageType) {
    Responses responses = messageType.getResponses();
    if (responses == null) {
      responses = new Responses();
      messageType.setResponses(responses);
    }
    return responses.getResponse();
  }

  private File marshal(Repository repository) throws JAXBException, IOException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Repository.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    File file = File.createTempFile("REP", ".xml");
    marshaller.marshal(repository, file);
    return file;
  }

  private Repository unMarshal(InputStream stream) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Repository.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    return (Repository) unmarshaller.unmarshal(stream);
  }
}
