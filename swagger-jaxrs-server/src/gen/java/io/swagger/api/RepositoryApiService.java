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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-27T18:20:26.929Z")
public abstract class RepositoryApiService {
    public abstract Response addCode(String fileid,String codesetid,Code code,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addCodeSet(String fileid,CodeSet codeSet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addComponent(String fileid,Component component,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addDatatype(String fileid,Datatype datatype,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addField(String fileid,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addMessage(String fileid,Message message,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addRepository(Metadata repository,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCode(String fileid,String codesetid,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCodeSet(String fileid,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteComponent(String fileid,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteDatatype(String fileid,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteField(String fileid,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteMessage(String fileid,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRepository(String fileid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findCodeById(String fileid,String codesetid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findCodeSetById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findComponentById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findDatatypeByName(String fileid,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findFieldById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findMessageById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findRepositoryById(String fileid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchCodeSets(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchCodes(String fileid,String codesetid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchComponents(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchDatatypes(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchFields(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchMessages(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchRepository(String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCodeById(String fileid,String codesetid,Integer id,Code code,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCodeSetById(String fileid,Integer id,CodeSet codeSet,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateComponentById(String fileid,Integer id,Component component,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateDatatypeByName(String fileid,String name,Datatype datatype,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateFieldById(String fileid,Integer id,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateMessageById(String fileid,Integer id,Message message,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateRepositoryById(String fileid,Metadata repository,SecurityContext securityContext) throws NotFoundException;
}
