package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.FieldsApiService;
import io.swagger.api.factories.FieldsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ErrorModel;
import io.swagger.model.Field;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/fields")


@io.swagger.annotations.Api(description = "the fields API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public class FieldsApi  {
   private final FieldsApiService delegate = FieldsApiServiceFactory.getFieldsApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a field", notes = "Adds a field", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addField(@ApiParam(value = "Field to add" ) Field field
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addField(field,securityContext);
    }
    @DELETE
    @Path("/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single field based on the ID supplied", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "field deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "field not found", response = void.class) })
    public Response deleteField(@ApiParam(value = "ID of field to delete",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteField(id,securityContext);
    }
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single field, if found", notes = "", response = Field.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "field response", response = Field.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Field.class) })
    public Response findFieldById(@ApiParam(value = "ID of field to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findFieldById(id,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches fields", notes = "By passing in the appropriate options, you can search for fields ", response = Field.class, responseContainer = "List", tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Field.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Field.class, responseContainer = "List") })
    public Response searchFields(@ApiParam(value = "pass an optional search string for looking up fields") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchFields(searchString,skip,limit,securityContext);
    }
    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single field, if found (idempotent)", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "field updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateFieldById(@ApiParam(value = "ID of field to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "field to update" ,required=true) Field component
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateFieldById(id,component,securityContext);
    }
}
