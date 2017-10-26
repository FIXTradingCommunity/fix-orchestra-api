package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Component;
import io.swagger.model.ErrorModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public abstract class ComponentsApiService {
    public abstract Response addComponent(Component component,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteComponent(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findComponentById(Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchComponents(String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateComponentById(Integer id,Component component,SecurityContext securityContext) throws NotFoundException;
}
