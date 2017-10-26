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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public abstract class MessagesApiService {
    public abstract Response addMessage(Message message,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteMessage(Long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findMessageById(Integer id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response searchMessages(String searchString,Integer skip,Integer limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateMessageById(Integer id,Message message,SecurityContext securityContext) throws NotFoundException;
}
