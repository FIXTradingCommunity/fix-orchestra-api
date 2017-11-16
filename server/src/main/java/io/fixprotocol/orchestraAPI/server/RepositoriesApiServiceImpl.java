package io.fixprotocol.orchestraAPI.server;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriBuilder;

import io.fixprotocol.orchestra.api.ApiResponseMessage;
import io.fixprotocol.orchestra.api.NotFoundException;
import io.fixprotocol.orchestra.api.RepositoriesApiService;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Datatype;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.Repository;
import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.RepositoryStore;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;


public class RepositoriesApiServiceImpl extends RepositoriesApiService {
  private final RepositoryStore repositoryStore;
  private final Logger logger;

  public RepositoriesApiServiceImpl(RepositoryStore repositoryStore) {
    this.repositoryStore = repositoryStore;
    logger = Logger.getLogger(getClass().getName());
  }

  @Override
  public Response addCode(String reposName, String version, Integer codesetid, Code code,
      SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.createCode(reposName, version, codesetid, code);
      return Response.created(UriBuilder.fromPath("repositories").path(reposName).path(version)
          .path("codesets").path(codesetid.toString()).path("codes")
          .path(code.getOid().getId().toString()).build()).build();
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
      return Response.created(UriBuilder.fromPath("repositories").path(reposName).path(version)
          .path("codesets").path(Integer.toString(codeSet.getOid().getId())).build()).build();
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
      repositoryStore.createComponent(reposName, version, component,
          toClone);
      return Response.created(UriBuilder.fromPath("repositories").path(reposName)
          .path(version).path("components").path(component.getOid().getId().toString()).build()).build();
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
      return Response.created(UriBuilder.fromPath("repositories").path(reposName).path(version)
          .path("datatypes").path(datatype.getName()).build()).build();
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
      return Response.created(UriBuilder.fromPath("repositories").path(reposName).path(version)
          .path("fields").path(Integer.toString(field.getOid().getId())).build()).build();
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
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response addRepository(Repository repository, String nameToClone, String versionToClone,
      SecurityContext securityContext) throws NotFoundException {
    try {
      Metadata metadata = repositoryStore.createRepository(repository, nameToClone, versionToClone);
      return Response.created(UriBuilder.fromPath("repositories").path(repository.getName())
          .path(repository.getVersion()).build()).build();
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
  public Response deleteMessage(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
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
    }  }

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
  public Response findMessageById(String reposName, String version, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
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
  public Response searchCodes(String reposName, String version, Integer codesetid,
      String searchString, Integer skip, Integer limit, SecurityContext securityContext)
      throws NotFoundException {
    try {
      // todo: translate search string to a Predicate
      List<Code> filtered = repositoryStore.getCodes(reposName, version, codesetid, null);
      List<Code> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchCodeSets(String reposName, String version, String searchString,
      Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      // todo: translate search string to a Predicate
      List<CodeSet> filtered = repositoryStore.getCodeSets(reposName, version, null);
      List<CodeSet> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchComponents(String reposName, String version, String searchString,
      Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      // todo: translate search string to a Predicate
      List<Component> filtered = repositoryStore.getComponents(reposName, version, null);
      List<Component> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      logger.log(Level.WARNING, "Server error", e);
      return Response.serverError().build();
    }  
    }

  @Override
  public Response searchDatatypes(String reposName, String version, String searchString,
      Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      // todo: translate search string to a Predicate
      List<Datatype> filtered = repositoryStore.getDatatypes(reposName, version, null);
      List<Datatype> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchFields(String reposName, String version, String searchString, Integer skip,
      Integer limit, SecurityContext securityContext) throws NotFoundException {
    try {
      // todo: translate search string to a Predicate
      List<Field> filtered = repositoryStore.getFields(reposName, version, null);
      List<Field> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchMessages(String reposName, String version, String searchString,
      Integer skip, Integer limit, SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response searchRepositories(String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    try {
      // todo: translate search string to a Predicate
      List<Metadata> filtered = repositoryStore.getRepositoriesMetadata(null);
      List<Metadata> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
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
      return Response.serverError().build();
    }  }

  @Override
  public Response updateDatatypeByName(String reposName, String version, String name,
      Datatype datatype, SecurityContext securityContext) throws NotFoundException {
    try {
      repositoryStore.updateDatatype(reposName, version, name, datatype);
      return Response.ok().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    } // do some magic!
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
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateMessageById(String reposName, String version, Integer id, Message message,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
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
      return Response.serverError().build();
    }
  }
}
