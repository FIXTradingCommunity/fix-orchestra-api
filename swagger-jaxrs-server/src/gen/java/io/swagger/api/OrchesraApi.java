package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.OrchesraApiService;
import io.swagger.api.factories.OrchesraApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ErrorModel;
import io.swagger.model.Message;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/orchesra")


@io.swagger.annotations.Api(description = "the orchesra API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T19:00:28.823Z")
public class OrchesraApi  {
   private final OrchesraApiService delegate = OrchesraApiServiceFactory.getOrchesraApi();

    @DELETE
    @Path("/{fileid}/messages/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single message based on the ID supplied", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "message deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "message not found", response = void.class) })
    public Response deleteMessage(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of message to delete",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteMessage(fileid,id,securityContext);
    }
    @GET
    @Path("/{fileid}/messages/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single message, if found", notes = "", response = Message.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "message response", response = Message.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Message.class) })
    public Response findMessageById(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of message to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findMessageById(fileid,id,securityContext);
    }
    @PUT
    @Path("/{fileid}/messages/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single message, if found (idempotent)", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "message updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateMessageById(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of message to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "message to update" ,required=true) Message message
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateMessageById(fileid,id,message,securityContext);
    }
}
