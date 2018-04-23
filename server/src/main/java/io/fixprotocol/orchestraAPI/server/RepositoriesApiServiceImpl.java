package io.fixprotocol.orchestraAPI.server;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriBuilder;

import io.fixprotocol.orchestra.api.NotFoundException;
import io.fixprotocol.orchestra.api.RepositoriesApiService;
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
import io.fixprotocol.orchestra.model.Repository;
import io.fixprotocol.orchestra.model.StateMachine;
import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.ElementType;
import io.fixprotocol.orchestraAPI.store.RepositoryStore;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;


public class RepositoriesApiServiceImpl extends RepositoriesApiService {
  private final Logger logger;
  private final RepositoryStore repositoryStore;

  public RepositoriesApiServiceImpl(RepositoryStore repositoryStore) {
    this.repositoryStore = repositoryStore;
    logger = Logger.getLogger(getClass().getName());
  }

  @Override
  public Response addActor(String reposName, String version, Actor actor,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createActor(reposName, version, actor);
      return Response.created(createActorUri(reposName, version, actor.getName())).build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addAnnotation(String reposName, String version, String elementId,
      String elementType, String parentId, Annotation annotation, SecurityContext securityContext)
      throws NotFoundException {
    try {
      repositoryStore.createAnnotation(reposName, version, elementId,
          ElementType.valueOf(elementType), parentId, annotation);
      return Response.created(createAnnotationUri(reposName, version, elementId,
          ElementType.valueOf(elementType), parentId)).build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addCode(String reposName, String version, Integer codesetid, Code code,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createCode(reposName, version, codesetid, code);
      return Response.created(
          createCodeUri(reposName, version, codesetid.toString(), code.getOid().getId().toString()))
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addCodeSet(String reposName, String version, CodeSet codeSet,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createCodeSet(reposName, version, codeSet);
      return Response
          .created(createCodeSetUri(reposName, version, Integer.toString(codeSet.getOid().getId())))
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addComponent(String reposName, String version, Component component,
      Integer toClone, SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createComponent(reposName, version, component, toClone);
      return Response
          .created(createComponentUri(reposName, version, component.getOid().getId().toString()))
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addDatatype(String reposName, String version, Datatype datatype,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createDatatype(reposName, version, datatype);
      return Response.created(createDatatypeUri(reposName, version, datatype.getName())).build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addField(String reposName, String version, Field field,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createField(reposName, version, field);
      return Response.created(createFieldUri(reposName, version, field.getOid().getId().toString()))
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addFlow(String reposName, String version, Flow flow,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createFlow(reposName, version, flow);
      return Response.created(createFlowUri(reposName, version, flow.getName())).build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addGroup(String reposName, String version, Group group, Integer toClone,
      SecurityContext arg4) throws NotFoundException {
    try {
      repositoryStore.createComponent(reposName, version, group, toClone);
      return Response.created(createGroupUri(reposName, version, group.getOid().getId().toString()))
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addMessage(String reposName, String version, Message message, Integer toClone,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createMessage(reposName, version, message, toClone);
      return Response
          .created(createMessageUri(reposName, version, message.getOid().getId().toString()))
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addMessageResponse(String reposName, String version, Integer id,
      io.fixprotocol.orchestra.model.Response response, SecurityContext securityContext)
      throws NotFoundException {
    try {
      repositoryStore.createMessageResponse(reposName, version, id, response);
      return Response
          .created(createMessageResponseUri(reposName, version, id.toString(), response.getName()))
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addRepository(Repository repository, String nameToClone, String versionToClone,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createRepository(repository, nameToClone, versionToClone);
      return Response.created(createRepositoryUri(repository)).build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response addStateMachine(String reposName, String version, String actor,
      StateMachine stateMachine, SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createStateMachine(reposName, version, actor, stateMachine);
      return Response
          .created(createStateMachineUri(reposName, version, actor, stateMachine.getName()))
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteActor(String reposName, String version, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteActor(reposName, version, name);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteAnnotation(String reposName, String version, String elementId,
      String elementType, String parentId, SecurityContext securityContext)
      throws NotFoundException {
    try {
      repositoryStore.deleteAnnotation(reposName, version, elementId,
          ElementType.valueOf(elementType), parentId);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteCode(String reposName, String version, Integer codesetid, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteCode(reposName, version, codesetid, id);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteCodeSet(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteCodeSet(reposName, version, id);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteComponent(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteComponent(reposName, version, id);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteDatatype(String reposName, String version, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteDatatype(reposName, version, name);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteField(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteField(reposName, version, id);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteFlow(String reposName, String version, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteFlow(reposName, version, name);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteGroup(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteGroup(reposName, version, id);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteMessage(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteMessage(reposName, version, id);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteMessageResponse(String reposName, String version, Integer id, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteMessageResponse(reposName, version, id, name);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteRepository(String reposName, String version,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteRepository(reposName, version);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteStateMachine(String reposName, String version, String actor, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.deleteStateMachine(reposName, version, actor, name);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response downloadRepositoryById(String reposName, String version, SecurityContext arg2)
      throws NotFoundException {
    File file = null;
    try {
      file = repositoryStore.getRepositoryFile(reposName, version);
      logger.log(Level.INFO, "Repository file {0}", file);
      Response response = Response.ok().entity(file).build();
      response.getHeaders().add("Content-Disposition",
          String.format("attachment; filename=%s_%s.xml", reposName, version));
      return response;
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    } finally {
      if (file != null) {
        // processing seems to be async, so can't delete immediately
        file.deleteOnExit();
      }
    }
  }

  @Override
  public Response findActorByName(String reposName, String version, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Actor actor = repositoryStore.getActor(reposName, version, name);
      return Response.ok().entity(actor).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response findCodeById(String reposName, String version, Integer codesetid, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Code code = repositoryStore.getCodeById(reposName, version, codesetid, id);
      return Response.ok().entity(code).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response findCodeSetById(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      CodeSet codeSet = repositoryStore.getCodeSetById(reposName, version, id);
      return Response.ok().entity(codeSet).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response findComponentById(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Component component = repositoryStore.getComponentById(reposName, version, id);
      return Response.ok().entity(component).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response findDatatypeByName(String reposName, String version, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Datatype datatype = repositoryStore.getDatatype(reposName, version, name);
      return Response.ok().entity(datatype).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response findFieldById(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Field field = repositoryStore.getFieldById(reposName, version, id);
      return Response.ok().entity(field).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response findFlowByName(String reposName, String version, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Flow flow = repositoryStore.getFlow(reposName, version, name);
      return Response.ok().entity(flow).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response findGroupById(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Group group = repositoryStore.getGroupById(reposName, version, id);
      return Response.ok().entity(group).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response findMessageById(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Message messsage = repositoryStore.getMessageById(reposName, version, id);
      return Response.ok().entity(messsage).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response findMessageResponseById(String reposName, String version, Integer id, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      io.fixprotocol.orchestra.model.Response response =
          repositoryStore.getMessageResponse(reposName, version, id, name);
      return Response.ok().entity(response).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response findRepositoryById(String reposName, String version,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Metadata metadata = repositoryStore.getRepositoryMetadata(reposName, version);
      return Response.ok().entity(metadata).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response findStateMachine(String reposName, String version, String actor, String name,
      SecurityContext securityContext) throws NotFoundException {
    try {
      StateMachine stateMachine = repositoryStore.getStateMachine(reposName, version, actor, name);
      return Response.ok().entity(stateMachine).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }


  /**
   * Search string matches if contained within Actor name, case insensitive
   */
  @Override
  public Response searchActors(String reposName, String version, String searchString, Integer skip,
      Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Actor> predicate = searchString != null
          ? actor -> ServiceUtil.isMatch(searchString, new String[] {actor.getName()})
          : t -> true;

      List<Actor> filtered = repositoryStore.getActors(reposName, version, predicate);
      List<Actor> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchAnnotations(String reposName, String version, String elementId,
      String elementType, String parentId, String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Documentation> documentationPredicate =
          searchString != null
              ? d -> searchString.equals(d.getPurpose()) || searchString.equals(d.getLangId())
                  || searchString.equalsIgnoreCase("documentation")
              : t -> true;

      Predicate<Appinfo> appInfoPredicate =
          searchString != null
              ? a -> searchString.equals(a.getPurpose()) || searchString.equals(a.getLangId())
                  || searchString.equalsIgnoreCase("appinfo")
              : t -> true;

      Annotation filtered = repositoryStore.getAnnotations(reposName, version, elementId,
          ElementType.valueOf(elementType), parentId, documentationPredicate, appInfoPredicate);
      Annotation range;

      if (skip != null || limit != null) {
        range = new Annotation();
        final List<Appinfo> appinfoList = filtered.getAppinfo();
        if (appinfoList != null) {
          range.setAppinfo(appinfoList.subList(skip != null ? skip : 0,
              limit != null ? Math.min(limit, appinfoList.size()) : appinfoList.size()));
        }
        final List<Documentation> documentationList = filtered.getDocumentation();
        if (documentationList != null) {
          range.setDocumentation(documentationList.subList(
              skip != null ? Math.min(0, skip - range.getAppinfo().size()) : 0,
              limit != 0 ? limit - range.getAppinfo().size() : appinfoList.size()));
        }
      } else {
        range = filtered;
      }

      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Server error", e);
      return Response.serverError().build();
    }
  }

  /**
   * Search string matches if contained within Code name or abbrName, case insensitive
   */
  @Override
  public Response searchCodes(String reposName, String version, Integer codesetid,
      String searchString, Integer skip, Integer limit, SecurityContext securityContext)
      throws NotFoundException {
    try {
      Predicate<Code> predicate = searchString != null 
          ? code -> ServiceUtil.isMatch(searchString, new String[] {code.getOid().getName(), code.getOid().getAbbrName()}) 
          : t -> true;

      List<Code> filtered = repositoryStore.getCodes(reposName, version, codesetid, predicate);
      List<Code> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  /**
   * Search string matches if contained within CodeSet name or abbrName, case insensitive
   */
  @Override
  public Response searchCodeSets(String reposName, String version, String searchString,
      Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<CodeSet> predicate = searchString != null
          ? codeSet -> ServiceUtil.isMatch(searchString,
              new String[] {codeSet.getOid().getName(), codeSet.getOid().getAbbrName()})
          : t -> true;

      List<CodeSet> filtered = repositoryStore.getCodeSets(reposName, version, predicate);
      List<CodeSet> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  /**
   * Search string matches if contained within Component name, abbrName or category, case insensitive
   */
  @Override
  public Response searchComponents(String reposName, String version, String searchString,
      Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Component> predicate =
          searchString != null
              ? c -> ServiceUtil.isMatch(searchString,
                  new String[] {c.getOid().getName(), c.getOid().getAbbrName(), c.getCategory()})
              : t -> true;

      List<Component> filtered = repositoryStore.getComponents(reposName, version, predicate);
      List<Component> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  /**
   * Search string matches if contained within Datatype name or basetype, case insensitive
   */
  @Override
  public Response searchDatatypes(String reposName, String version, String searchString,
      Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Datatype> predicate = searchString != null
          ? datatype -> ServiceUtil.isMatch(searchString, new String[] {datatype.getName(), datatype.getBaseType()})
          : t -> true;

      List<Datatype> filtered = repositoryStore.getDatatypes(reposName, version, predicate);
      List<Datatype> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  /**
   * Search string matches if contained within Field name, abbrName or category, case insensitive
   */
  @Override
  public Response searchFields(String reposName, String version, String searchString, Integer skip,
      Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Field> predicate =
          searchString != null
              ? field -> ServiceUtil.isMatch(searchString,
                  new String[] {field.getOid().getName(), field.getOid().getAbbrName(), field.getCategory()})
              : t -> true;

      List<Field> filtered = repositoryStore.getFields(reposName, version, predicate);
      List<Field> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  /**
   * Search string matches if contained within Flow name, source or destination, case insensitive
   */
  @Override
  public Response searchFlows(String reposName, String version, String searchString, Integer skip,
      Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Flow> predicate =
          searchString != null 
              ? flow -> ServiceUtil.isMatch(searchString,
                  new String[] {flow.getName(), flow.getSource(), flow.getDestination()})
              : t -> true;

      List<Flow> filtered = repositoryStore.getFlows(reposName, version, predicate);
      List<Flow> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  /**
   * Search string matches if contained within Group name, abbrName or category, case insensitive
   */
  @Override
  public Response searchGroups(String reposName, String version, String searchString, Integer skip,
      Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Group> predicate =
          searchString != null
              ? g -> ServiceUtil.isMatch(searchString,
                  new String[] {g.getOid().getName(), g.getOid().getAbbrName(), g.getCategory()})
              : t -> true;

      List<Group> filtered = repositoryStore.getGroups(reposName, version, predicate);
      List<Group> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchMessageResponses(String reposName, String version, Integer id,
      String searchString, Integer skip, Integer limit, SecurityContext securityContext)
      throws NotFoundException {
    try {
      Predicate<io.fixprotocol.orchestra.model.Response> predicate =
          searchString != null ? r -> searchString.equals(r.getName()) : r -> true;

      List<io.fixprotocol.orchestra.model.Response> filtered =
          repositoryStore.getMessageResponses(reposName, version, id, predicate);
      List<io.fixprotocol.orchestra.model.Response> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  /**
   * Search string matches if contained within Group Message name, abbrName, scenario or category, case insensitive
   */
  @Override
  public Response searchMessages(String reposName, String version, String searchString,
      Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Message> predicate = searchString != null
          ? m -> ServiceUtil
              .isMatch(
                  searchString,
                  new String[] {m.getOid().getName(), m.getOid().getAbbrName(), m.getScenario(),
                      m.getCategory()})
          : t -> true;

      List<Message> filtered = repositoryStore.getMessages(reposName, version, predicate);
      List<Message> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchRepositories(String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Predicate<Repository> predicate = searchString != null
          ? r -> ServiceUtil.isMatch(searchString, new String[] {r.getName(), r.getVersion()})
          : t -> true;
      List<Metadata> filtered = repositoryStore.getRepositoriesMetadata(predicate);
      List<Metadata> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchStateMachines(String reposName, String version, String actor,
      String searchString, Integer skip, Integer limit, SecurityContext securityContext)
      throws NotFoundException {
    try {
      Predicate<StateMachine> predicate =
          searchString != null ? stateMachine -> searchString.equals(stateMachine.getName())
              : t -> true;

      List<StateMachine> filtered = repositoryStore.getStateMachines(reposName, version, predicate);
      List<StateMachine> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateActorByName(String reposName, String version, String name, Actor actor,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateActor(reposName, version, name, actor);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateAnnotation(String reposName, String version, String elementId,
      String elementType, Annotation annotation, String parentId, SecurityContext securityContext)
      throws NotFoundException {
    try {
      repositoryStore.updateAnnotation(reposName, version, elementId,
          ElementType.valueOf(elementType), parentId, annotation);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateCodeById(String reposName, String version, Integer codesetid, Integer id,
      Code code, SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateCode(reposName, version, codesetid, id, code);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateCodeSetById(String reposName, String version, Integer id, CodeSet codeSet,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateCodeSet(reposName, version, id, codeSet);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateComponentById(String reposName, String version, Integer id,
      Component component, SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateComponent(reposName, version, id, component);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateDatatypeByName(String reposName, String version, String name,
      Datatype datatype, SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateDatatype(reposName, version, name, datatype);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateFieldById(String reposName, String version, Integer id, Field field,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateField(reposName, version, id, field);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateFlowByName(String reposName, String version, String name, Flow flow,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateFlow(reposName, version, name, flow);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateGroupById(String reposName, String version, Integer id, Group group,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateGroup(reposName, version, id, group);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateMessageById(String reposName, String version, Integer id, Message message,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateMessage(reposName, version, id, message);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateMessageResponse(String reposName, String version, Integer id, String name,
      io.fixprotocol.orchestra.model.Response response, SecurityContext securityContext)
      throws NotFoundException {
    try {
      repositoryStore.updateMessageResponse(reposName, version, id, name, response);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }

  }

  @Override
  public Response updateRepositoryById(String reposName, String version, Repository repository,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateRepositoryMetadata(reposName, version, repository);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateStateMachine(String reposName, String version, String actor, String name,
      StateMachine stateMachine, SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateStateMachine(reposName, version, actor, name, stateMachine);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  public Response uploadRepositoryById(String reposName, String version,
      InputStream upfileInputStream, FormDataContentDisposition upfileDetail,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createRepositoryFromFile(upfileInputStream);
      return Response.created(createRepositoryUri(reposName, version)).build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  public Response uploadRepositoryForUpdateById(String reposName, String version,
      InputStream upfileInputStream, FormDataContentDisposition upfileDetail,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateRepositoryFromFile(upfileInputStream);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }  }

  private URI createActorUri(String reposName, String version, String actorName) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("actors")
        .path(actorName).build();
  }

  private URI createAnnotationUri(String reposName, String version, String elementId,
      ElementType elementType, String parentId) {
     UriBuilder builder = UriBuilder.fromPath("repositories").path(reposName)
         .queryParam("elementId", elementId).queryParam("elementType", elementType);
     if (parentId != null) {
       builder.queryParam("parentId", parentId);
     }
     return builder.build();
  }

  private URI createCodeSetUri(String reposName, String version, String idAsString) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("codesets")
        .path(idAsString).build();
  }

  private URI createCodeUri(String reposName, String version, String codesetIdAsString,
      String codeIdAsString) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("codesets")
        .path(codesetIdAsString).path("codes").path(codeIdAsString).build();
  }

  private URI createComponentUri(String reposName, String version, String idAsString) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("components")
        .path(idAsString).build();
  }

  private URI createDatatypeUri(String reposName, String version, String name) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("datatypes")
        .path(name).build();
  }

  private URI createFieldUri(String reposName, String version, String idAsString) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("fields")
        .path(idAsString).build();
  }

  private URI createFlowUri(String reposName, String version, String name) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("actors")
        .path(name).build();
  }

  private URI createGroupUri(String reposName, String version, String idAsString) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("components")
        .path(idAsString).build();
  }

  private URI createMessageResponseUri(String reposName, String version, String messageIdAsString,
      String name) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("messages")
        .path(messageIdAsString).path("responses").path(name).build();
  }

  private URI createMessageUri(String reposName, String version, String idAsString) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("messages")
        .path(idAsString).build();
  }
  
  private URI createRepositoryUri(Repository repository) {
    return createRepositoryUri(repository.getName(), repository.getVersion());
  }
  
  private URI createRepositoryUri(String name, String version) {
    return UriBuilder.fromPath("repositories").path(name)
        .path(version).build();
  }
  
  private URI createStateMachineUri(String reposName, String version, String actor,
      String stateMachine) {
    return UriBuilder.fromPath("repositories").path(reposName).path(version).path("actors")
        .path(actor).path("statemachines").path(stateMachine).build();
  }

}
