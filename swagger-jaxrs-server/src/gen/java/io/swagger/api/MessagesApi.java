package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.MessagesApiService;
import io.swagger.api.factories.MessagesApiServiceFactory;

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

@Path("/messages")


@io.swagger.annotations.Api(description = "the messages API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public class MessagesApi  {
   private final MessagesApiService delegate = MessagesApiServiceFactory.getMessagesApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a message scenario", notes = "Adds a message scenario", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addMessage(@ApiParam(value = "Message to add" ) Message message
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addMessage(message,securityContext);
    }
    @DELETE
    @Path("/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single message based on the ID supplied", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "message deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "message not found", response = void.class) })
    public Response deleteMessage(@ApiParam(value = "ID of message to delete",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteMessage(id,securityContext);
    }
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single message, if found", notes = "", response = Message.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "message response", response = Message.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Message.class) })
    public Response findMessageById(@ApiParam(value = "ID of message to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findMessageById(id,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches messages", notes = "By passing in the appropriate options, you can search for messages ", response = Message.class, responseContainer = "List", tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Message.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Message.class, responseContainer = "List") })
    public Response searchMessages(@ApiParam(value = "pass an optional search string for looking up messages") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchMessages(searchString,skip,limit,securityContext);
    }
    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single message, if found (idempotent)", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "message updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateMessageById(@ApiParam(value = "ID of message to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "message to update" ,required=true) Message message
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateMessageById(id,message,securityContext);
    }
}
