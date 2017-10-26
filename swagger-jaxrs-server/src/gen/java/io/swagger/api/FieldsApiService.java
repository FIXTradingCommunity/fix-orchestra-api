package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ErrorModel;
import io.swagger.model.Field;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public abstract class FieldsApiService {
    public abstract Response addField(Field field,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteField(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findFieldById(Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchFields(String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateFieldById(Integer id,Field component,SecurityContext securityContext) throws NotFoundException;
}
