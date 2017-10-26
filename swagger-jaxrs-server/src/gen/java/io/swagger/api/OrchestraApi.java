package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.OrchestraApiService;
import io.swagger.api.factories.OrchestraApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Component;
import io.swagger.model.ErrorModel;
import io.swagger.model.Field;
import io.swagger.model.Message;
import io.swagger.model.Orchestra;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/orchestra")


@io.swagger.annotations.Api(description = "the orchestra API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T19:00:28.823Z")
public class OrchestraApi  {
   private final OrchestraApiService delegate = OrchestraApiServiceFactory.getOrchestraApi();

    @POST
    @Path("/{fileid}/components")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a component", notes = "Adds a component", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addComponent(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "Component to add" ) Component component
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addComponent(fileid,component,securityContext);
    }
    @POST
    @Path("/{fileid}/fields")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a field", notes = "Adds a field", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addField(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "field to add" ) Field field
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addField(fileid,field,securityContext);
    }
    @POST
    @Path("/{fileid}/messages")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a message scenario", notes = "Adds a message scenario", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addMessage(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "message to add" ) Message message
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addMessage(fileid,message,securityContext);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds an Orchestra file", notes = "Adds an Orchestra file", response = void.class, tags={ "file", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addOrchestra(@ApiParam(value = "Orchestra file to add" ,required=true) Orchestra orchestra
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addOrchestra(orchestra,securityContext);
    }
    @DELETE
    @Path("/{fileid}/components/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single component based on the ID supplied", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "component deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "component not found", response = void.class) })
    public Response deleteComponent(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of field to delete",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteComponent(fileid,id,securityContext);
    }
    @DELETE
    @Path("/{fileid}/fields/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single field based on the ID supplied", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "field deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "field not found", response = void.class) })
    public Response deleteField(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of field to delete",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteField(fileid,id,securityContext);
    }
    @DELETE
    @Path("/{fileid}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single Orchestra file based on the ID supplied", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "file deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "file not found", response = void.class) })
    public Response deleteOrchestra(@ApiParam(value = "ID of Orchestra file to delete",required=true) @PathParam("fileid") String fileid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteOrchestra(fileid,securityContext);
    }
    @GET
    @Path("/{fileid}/components/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single component, if found", notes = "", response = Component.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "component response", response = Component.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Component.class) })
    public Response findComponentById(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of component to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findComponentById(fileid,id,securityContext);
    }
    @GET
    @Path("/{fileid}/fields/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single field, if found", notes = "", response = Field.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "field response", response = Field.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Field.class) })
    public Response findFieldById(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of field to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findFieldById(fileid,id,securityContext);
    }
    @GET
    @Path("/{fileid}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single Orchestra file metadata, if found", notes = "", response = Orchestra.class, tags={ "file", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "file response", response = Orchestra.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Orchestra.class) })
    public Response findOrchestraById(@ApiParam(value = "ID of Orchestra file to fetch",required=true) @PathParam("fileid") String fileid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findOrchestraById(fileid,securityContext);
    }
    @GET
    @Path("/{fileid}/components")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches components", notes = "By passing in the appropriate options, you can search for components ", response = Component.class, responseContainer = "List", tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Component.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Component.class, responseContainer = "List") })
    public Response searchComponents(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "pass an optional search string for looking up components") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchComponents(fileid,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{fileid}/fields")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches fields", notes = "By passing in the appropriate options, you can search for fields ", response = Field.class, responseContainer = "List", tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Field.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Field.class, responseContainer = "List") })
    public Response searchFields(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "pass an optional search string for looking up fields") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchFields(fileid,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{fileid}/messages")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches messages", notes = "By passing in the appropriate options, you can search for messages ", response = Message.class, responseContainer = "List", tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Message.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Message.class, responseContainer = "List") })
    public Response searchMessages(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "pass an optional search string for looking up messages") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchMessages(fileid,searchString,skip,limit,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches Orchestra files", notes = "By passing in the appropriate options, you can search for Orchestra files ", response = Orchestra.class, responseContainer = "List", tags={ "file", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Orchestra.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Orchestra.class, responseContainer = "List") })
    public Response searchOrchestra(@ApiParam(value = "pass an optional search string for looking up components") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchOrchestra(searchString,skip,limit,securityContext);
    }
    @PUT
    @Path("/{fileid}/components/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single component, if found (idempotent)", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "component updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateComponentById(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of component to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "component to update" ,required=true) Component component
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateComponentById(fileid,id,component,securityContext);
    }
    @PUT
    @Path("/{fileid}/fields/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single field, if found (idempotent)", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "field updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateFieldById(@ApiParam(value = "ID of Orchestra file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of field to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "field to update" ,required=true) Field field
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateFieldById(fileid,id,field,securityContext);
    }
    @PUT
    @Path("/{fileid}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a Orchestra file, if found (idempotent)", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "file updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateOrchestraById(@ApiParam(value = "ID of Orchestra file to update",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "Orchestra file to update" ,required=true) Orchestra orchestra
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateOrchestraById(fileid,orchestra,securityContext);
    }
}
