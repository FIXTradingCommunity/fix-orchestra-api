package io.fixprotocol.orchestraAPI.server;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriBuilder;

import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.RepositoryStore;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;
import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.api.RepositoriesApiService;
import io.swagger.model.Code;
import io.swagger.model.CodeSet;
import io.swagger.model.Component;
import io.swagger.model.Datatype;
import io.swagger.model.Field;
import io.swagger.model.Message;
import io.swagger.model.Metadata;

public class RepositoriesApiServiceImpl extends RepositoriesApiService {
  private final RepositoryStore repositoryStore;

  public RepositoriesApiServiceImpl(RepositoryStore repositoryStore) {
    this.repositoryStore = repositoryStore;
  }

  @Override
  public Response addCode(String fileid, Integer codesetid, Code code,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response addCodeSet(String fileid, CodeSet codeSet, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response addComponent(String fileid, Component component, Integer toClone,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response addDatatype(String fileid, Datatype datatype, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response addField(String fileid, Field field, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response addMessage(String fileid, Message message, Integer toClone,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response addRepository(Metadata metadata, String toClone, SecurityContext securityContext)
      throws NotFoundException {
    try {
      Metadata metadata2 = repositoryStore.addRepository(metadata, toClone);
      return Response
          .created(UriBuilder.fromPath("repositories").path(metadata2.getIdentifier()).build())
          .build();
    } catch (DuplicateKeyException e) {
      return Response.noContent().status(Status.CONFLICT).build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response deleteCode(String fileid, Integer codesetid, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response deleteCodeSet(String fileid, Integer id, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response deleteComponent(String fileid, Integer id, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response deleteDatatype(String fileid, String name, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response deleteField(String fileid, Integer id, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response deleteMessage(String fileid, Integer id, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response deleteRepository(String fileid, SecurityContext securityContext)
      throws NotFoundException {
    try {
      repositoryStore.deleteRepository(fileid);
      return Response.noContent().build();
    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response findCodeById(String fileid, Integer codesetid, Integer id,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response findCodeSetById(String fileid, Integer id, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response findComponentById(String fileid, Integer id, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response findDatatypeByName(String fileid, String name, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response findFieldById(String fileid, Integer id, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response findMessageById(String fileid, Integer id, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response findRepositoryById(String fileid, SecurityContext securityContext)
      throws NotFoundException {
    try {
      Metadata metadata = repositoryStore.getRepository(fileid);
      return Response.ok().entity(metadata).build();

    } catch (ResourceNotFoundException e) {
      return Response.noContent().status(Status.NOT_FOUND).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response searchCodeSets(String fileid, String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response searchCodes(String fileid, Integer codesetid, String searchString, Integer skip,
      Integer limit, SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response searchComponents(String fileid, String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response searchDatatypes(String fileid, String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response searchFields(String fileid, String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response searchMessages(String fileid, String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response searchRepositories(String searchString, Integer skip, Integer limit,
      SecurityContext securityContext) throws NotFoundException {
    try {
      // todo: translate search string to a Predicate
      List<Metadata> filtered = repositoryStore.getRepositories(null);
      List<Metadata> range =
          filtered.subList(skip != null ? skip : 0, limit != null ? limit : filtered.size());
      return Response.ok().entity(range).build();
    } catch (RepositoryStoreException e) {
      return Response.serverError().build();
    }
  }

  @Override
  public Response updateCodeById(String fileid, Integer codesetid, Integer id, Code code,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response updateCodeSetById(String fileid, Integer id, CodeSet codeSet,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response updateComponentById(String fileid, Integer id, Component component,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response updateDatatypeByName(String fileid, String name, Datatype datatype,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response updateFieldById(String fileid, Integer id, Field field,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response updateMessageById(String fileid, Integer id, Message message,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response updateRepositoryById(String fileid, Metadata repository,
      SecurityContext securityContext) throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
}
