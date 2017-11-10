package io.fixprotocol.orchestra.api;

import io.fixprotocol.orchestra.api.*;
import io.fixprotocol.orchestra.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Datatype;
import io.fixprotocol.orchestra.model.ErrorModel;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.Repository;

import java.util.List;
import io.fixprotocol.orchestra.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-10T17:21:41.794Z")
public abstract class RepositoriesApiService {
    public abstract Response addCode(String reposName,String version,Integer codesetid,Code code,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addCodeSet(String reposName,String version,CodeSet codeSet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addComponent(String reposName,String version,Component component,Integer toClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addDatatype(String reposName,String version,Datatype datatype,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addField(String reposName,String version,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addMessage(String reposName,String version,Message message,Integer toClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addRepository(Repository repository,String nameToClone,String versionToClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCode(String reposName,String version,Integer codesetid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCodeSet(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteComponent(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteDatatype(String reposName,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteField(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteMessage(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRepository(String reposName,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findCodeById(String reposName,String version,Integer codesetid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findCodeSetById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findComponentById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findDatatypeByName(String reposName,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findFieldById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findMessageById(String reposName,String version,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findRepositoryById(String reposName,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchCodeSets(String reposName,String version,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchCodes(String reposName,String version,Integer codesetid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchComponents(String reposName,String version,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchDatatypes(String reposName,String version,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchFields(String reposName,String version,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchMessages(String reposName,String version,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchRepositories(String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCodeById(String reposName,String version,Integer codesetid,Integer id,Code code,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCodeSetById(String reposName,String version,Integer id,CodeSet codeSet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateComponentById(String reposName,String version,Integer id,Component component,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateDatatypeByName(String reposName,String version,String name,Datatype datatype,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateFieldById(String reposName,String version,Integer id,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateMessageById(String reposName,String version,Integer id,Message message,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateRepositoryById(String reposName,String version,Repository repository,SecurityContext securityContext) throws NotFoundException;
}
