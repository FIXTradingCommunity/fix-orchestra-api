package io.fixprotocol.orchestra.api;

import io.fixprotocol.orchestra.model.Actor;
import io.fixprotocol.orchestra.model.Annotation;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Datatype;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Flow;
import io.fixprotocol.orchestra.model.Group;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.Repository;
import io.fixprotocol.orchestra.model.StateMachine;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;



import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-04-20T16:19:31.788Z")
public abstract class RepositoriesApiService {
    public abstract Response addActor(String reposName,String version,Actor actor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addAnnotation(String reposName,String version, @NotNull String elementId, @NotNull String elementType, String parentId,Annotation annotation,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addCode(String reposName,String version,Integer codesetid,Code code,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addCodeSet(String reposName,String version,CodeSet codeSet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addComponent(String reposName,String version,Component component, Integer toClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addDatatype(String reposName,String version,Datatype datatype,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addField(String reposName,String version,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addFlow(String reposName,String version,Flow flow,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addGroup(String reposName,String version,Group group, Integer toClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addMessage(String reposName,String version,Message message, Integer toClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addMessageResponse(String reposName,String version,Integer id,io.fixprotocol.orchestra.model.Response response,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addRepository(Repository repository, String nameToClone, String versionToClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addStateMachine(String reposName,String version,String name,StateMachine stateMachine,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteActor(String reposName,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteAnnotation(String reposName,String version, @NotNull String elementId, @NotNull String elementType, String parentId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCode(String reposName,String version,Integer codesetid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCodeSet(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteComponent(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteDatatype(String reposName,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteField(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteFlow(String reposName,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteGroup(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteMessage(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteMessageResponse(String reposName,String version,Integer id,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRepository(String reposName,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteStateMachine(String reposName,String version,String name,String smName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response downloadRepositoryById(String reposName,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findActorByName(String reposName,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findCodeById(String reposName,String version,Integer codesetid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findCodeSetById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findComponentById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findDatatypeByName(String reposName,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findFieldById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findFlowByName(String reposName,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findGroupById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findMessageById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findMessageResponseById(String reposName,String version,Integer id,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findRepositoryById(String reposName,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findStateMachine(String reposName,String version,String name,String smName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchActors(String reposName,String version, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchAnnotations(String reposName,String version, @NotNull String elementId, @NotNull String elementType, String parentId, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchCodeSets(String reposName,String version, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchCodes(String reposName,String version,Integer codesetid, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchComponents(String reposName,String version, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchDatatypes(String reposName,String version, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchFields(String reposName,String version, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchFlows(String reposName,String version, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchGroups(String reposName,String version, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchMessageResponses(String reposName,String version,Integer id, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchMessages(String reposName,String version, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchRepositories( String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchStateMachines(String reposName,String version,String name, String searchString, @Min(0) Integer skip, @Min(0) @Max(50) Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateActorByName(String reposName,String version,String name,Actor actor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateAnnotation(String reposName,String version, @NotNull String elementId, @NotNull String elementType,Annotation annotation, String parentId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCodeById(String reposName,String version,Integer codesetid,Integer id,Code code,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCodeSetById(String reposName,String version,Integer id,CodeSet codeSet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateComponentById(String reposName,String version,Integer id,Component component,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateDatatypeByName(String reposName,String version,String name,Datatype datatype,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateFieldById(String reposName,String version,Integer id,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateFlowByName(String reposName,String version,String name,Flow actor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateGroupById(String reposName,String version,Integer id,Group group,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateMessageById(String reposName,String version,Integer id,Message message,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateMessageResponse(String reposName,String version,Integer id,String name,io.fixprotocol.orchestra.model.Response response,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateRepositoryById(String reposName,String version,Repository repository,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateStateMachine(String reposName,String version,String name,String smName,StateMachine stateMachine,SecurityContext securityContext) throws NotFoundException;
    public abstract Response uploadRepositoryById(String reposName,String version,InputStream upfileInputStream, FormDataContentDisposition upfileDetail,SecurityContext securityContext) throws NotFoundException;
    public abstract Response uploadRepositoryForUpdateById(String reposName,String version,InputStream upfileInputStream, FormDataContentDisposition upfileDetail,SecurityContext securityContext) throws NotFoundException;
}
