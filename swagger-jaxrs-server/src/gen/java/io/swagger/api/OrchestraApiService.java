package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Component;
import io.swagger.model.ErrorModel;
import io.swagger.model.Field;
import io.swagger.model.Message;
import io.swagger.model.Orchestra;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T19:00:28.823Z")
public abstract class OrchestraApiService {
    public abstract Response addComponent(String fileid,Component component,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addField(String fileid,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addMessage(String fileid,Message message,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addOrchestra(Orchestra orchestra,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteComponent(String fileid,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteField(String fileid,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteOrchestra(String fileid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findComponentById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findFieldById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findOrchestraById(String fileid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchComponents(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchFields(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchMessages(String fileid,String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchOrchestra(String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateComponentById(String fileid,Integer id,Component component,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateFieldById(String fileid,Integer id,Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateOrchestraById(String fileid,Orchestra orchestra,SecurityContext securityContext) throws NotFoundException;
}
