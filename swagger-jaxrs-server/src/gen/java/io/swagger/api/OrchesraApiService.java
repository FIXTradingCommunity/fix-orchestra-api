package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ErrorModel;
import io.swagger.model.Message;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T19:00:28.823Z")
public abstract class OrchesraApiService {
    public abstract Response deleteMessage(String fileid,Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findMessageById(String fileid,Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateMessageById(String fileid,Integer id,Message message,SecurityContext securityContext) throws NotFoundException;
}
