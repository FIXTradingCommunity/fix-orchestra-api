package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Code;
import io.swagger.model.CodeSet;
import io.swagger.model.Component;
import io.swagger.model.Datatype;
import io.swagger.model.ErrorModel;
import io.swagger.model.Field;
import io.swagger.model.Message;
import io.swagger.model.Metadata;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-06T20:15:25.553Z")
public abstract class RepositoriesApiService {
    public abstract Response addCode(String fileid,Integer codesetid,Code code,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addCodeSet(String fileid,CodeSet codeSet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addComponent(String fileid,Component component,Integer toClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addDatatype(String fileid,Datatype datatype,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addField(String fileid,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addMessage(String fileid,Message message,Integer toClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addRepository(Metadata repository,String toClone,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCode(String fileid,Integer codesetid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCodeSet(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteComponent(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteDatatype(String fileid,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteField(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteMessage(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRepository(String fileid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findCodeById(String fileid,Integer codesetid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findCodeSetById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findComponentById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findDatatypeByName(String fileid,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findFieldById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findMessageById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findRepositoryById(String fileid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchCodeSets(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchCodes(String fileid,Integer codesetid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchComponents(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchDatatypes(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchFields(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchMessages(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchRepositories(String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCodeById(String fileid,Integer codesetid,Integer id,Code code,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCodeSetById(String fileid,Integer id,CodeSet codeSet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateComponentById(String fileid,Integer id,Component component,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateDatatypeByName(String fileid,String name,Datatype datatype,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateFieldById(String fileid,Integer id,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateMessageById(String fileid,Integer id,Message message,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateRepositoryById(String fileid,Metadata repository,SecurityContext securityContext) throws NotFoundException;
}
