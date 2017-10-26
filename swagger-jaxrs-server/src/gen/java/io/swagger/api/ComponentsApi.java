package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ComponentsApiService;
import io.swagger.api.factories.ComponentsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Component;
import io.swagger.model.ErrorModel;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/components")


@io.swagger.annotations.Api(description = "the components API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public class ComponentsApi  {
   private final ComponentsApiService delegate = ComponentsApiServiceFactory.getComponentsApi();

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a component", notes = "Adds a component", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addComponent(@ApiParam(value = "Component to add" ) Component component
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addComponent(component,securityContext);
    }
    @DELETE
    @Path("/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single component based on the ID supplied", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "component deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "component not found", response = void.class) })
    public Response deleteComponent(@ApiParam(value = "ID of field to delete",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteComponent(id,securityContext);
    }
    @GET
    @Path("/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single component, if found", notes = "", response = Component.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "component response", response = Component.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Component.class) })
    public Response findComponentById(@ApiParam(value = "ID of component to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findComponentById(id,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches components", notes = "By passing in the appropriate options, you can search for components ", response = Component.class, responseContainer = "List", tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Component.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Component.class, responseContainer = "List") })
    public Response searchComponents(@ApiParam(value = "pass an optional search string for looking up components") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchComponents(searchString,skip,limit,securityContext);
    }
    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single component, if found (idempotent)", notes = "", response = void.class, tags={ "messages", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "component updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateComponentById(@ApiParam(value = "ID of component to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "component to update" ,required=true) Component component
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateComponentById(id,component,securityContext);
    }
}
