package io.fixprotocol.orchestraAPI.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import io.swagger.api.NotFoundException;
import io.swagger.api.RepositoriesApiService;

import io.swagger.model.Code;
import io.swagger.model.CodeSet;
import io.swagger.model.Component;
import io.swagger.model.Datatype;
import io.swagger.model.Field;
import io.swagger.model.Message;
import io.swagger.model.Metadata;

@Path("/repositories")


@io.swagger.annotations.Api(description = "the repositories API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-06T20:15:25.553Z")
public class RepositoriesApi  {
   private final RepositoriesApiService delegate = RepositoriesApiServiceFactory.getRepositoriesApi();

    @POST
    @Path("/{fileid}/codesets/{codesetid}/codes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a Code to CodeSet", notes = "Adds a Code", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addCode(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "Code to add" ) Code code
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addCode(fileid,codesetid,code,securityContext);
    }
    @POST
    @Path("/{fileid}/codesets")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a CodeSet", notes = "Adds a CodeSet", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addCodeSet(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "CodeSet to add" ) CodeSet codeSet
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addCodeSet(fileid,codeSet,securityContext);
    }
    @POST
    @Path("/{fileid}/components")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a component", notes = "Adds a component", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addComponent(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "Component to add" ) Component component
,@ApiParam(value = "ID of component to clone") @QueryParam("toClone") Integer toClone
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addComponent(fileid,component,toClone,securityContext);
    }
    @POST
    @Path("/{fileid}/datatypes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a datatype", notes = "Adds a datatype", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addDatatype(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "Datatype to add" ) Datatype datatype
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addDatatype(fileid,datatype,securityContext);
    }
    @POST
    @Path("/{fileid}/fields")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a field", notes = "Adds a field", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addField(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "field to add" ) Field field
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addField(fileid,field,securityContext);
    }
    @POST
    @Path("/{fileid}/messages")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a message scenario", notes = "Adds a message scenario", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addMessage(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "message to add" ) Message message
,@ApiParam(value = "ID of message to clone") @QueryParam("toClone") Integer toClone
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addMessage(fileid,message,toClone,securityContext);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds an Orchestra repository file", notes = "Adds an Orchestra repository file", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addRepository(@ApiParam(value = "Orchestra repository file to add" ,required=true) Metadata repository
,@ApiParam(value = "ID of Orchestra repository file to clone") @QueryParam("toClone") String toClone
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRepository(repository,toClone,securityContext);
    }
    @DELETE
    @Path("/{fileid}/codesets/{codesetid}/codes/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single Code based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Code deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Code not found", response = void.class) })
    public Response deleteCode(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "ID of field to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteCode(fileid,codesetid,id,securityContext);
    }
    @DELETE
    @Path("/{fileid}/codesets/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single CodeSet based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "CodeSet deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "CodeSet not found", response = void.class) })
    public Response deleteCodeSet(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of field to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteCodeSet(fileid,id,securityContext);
    }
    @DELETE
    @Path("/{fileid}/components/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single component based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "component deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "component not found", response = void.class) })
    public Response deleteComponent(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of component to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteComponent(fileid,id,securityContext);
    }
    @DELETE
    @Path("/{fileid}/datatypes/{name}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single datatype based on the name supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "datatype deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "datatype not found", response = void.class) })
    public Response deleteDatatype(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "name of datatype to delete",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteDatatype(fileid,name,securityContext);
    }
    @DELETE
    @Path("/{fileid}/fields/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single field based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "field deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "field not found", response = void.class) })
    public Response deleteField(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of field to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteField(fileid,id,securityContext);
    }
    @DELETE
    @Path("/{fileid}/messages/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single message scenario based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "message deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "message not found", response = void.class) })
    public Response deleteMessage(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of message to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteMessage(fileid,id,securityContext);
    }
    @DELETE
    @Path("/{fileid}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single Orchestra repository file based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "file deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "file not found", response = void.class) })
    public Response deleteRepository(@ApiParam(value = "ID of Orchestra repository file to delete",required=true) @PathParam("fileid") String fileid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteRepository(fileid,securityContext);
    }
    @GET
    @Path("/{fileid}/codesets/{codesetid}/codes/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single Code, if found", notes = "", response = Code.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Code response", response = Code.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Code.class) })
    public Response findCodeById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "ID of Code to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findCodeById(fileid,codesetid,id,securityContext);
    }
    @GET
    @Path("/{fileid}/codesets/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single CodeSet, if found", notes = "", response = CodeSet.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "CodeSet response", response = CodeSet.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = CodeSet.class) })
    public Response findCodeSetById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of CodeSet to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findCodeSetById(fileid,id,securityContext);
    }
    @GET
    @Path("/{fileid}/components/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single component, if found", notes = "", response = Component.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "component response", response = Component.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Component.class) })
    public Response findComponentById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of component to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findComponentById(fileid,id,securityContext);
    }
    @GET
    @Path("/{fileid}/datatypes/{name}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single datatype, if found", notes = "", response = Datatype.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "datatype response", response = Datatype.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Datatype.class) })
    public Response findDatatypeByName(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "name of datatype to fetch",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findDatatypeByName(fileid,name,securityContext);
    }
    @GET
    @Path("/{fileid}/fields/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single field, if found", notes = "", response = Field.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "field response", response = Field.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Field.class) })
    public Response findFieldById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of field to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findFieldById(fileid,id,securityContext);
    }
    @GET
    @Path("/{fileid}/messages/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single message scenario, if found", notes = "", response = Message.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "message response", response = Message.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Message.class) })
    public Response findMessageById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of message to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findMessageById(fileid,id,securityContext);
    }
    @GET
    @Path("/{fileid}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single Orchestra repository file metadata, if found", notes = "", response = Metadata.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "file response", response = Metadata.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Metadata.class) })
    public Response findRepositoryById(@ApiParam(value = "ID of Orchestra repository file to fetch",required=true) @PathParam("fileid") String fileid
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findRepositoryById(fileid,securityContext);
    }
    @GET
    @Path("/{fileid}/codesets")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches CodeSets", notes = "By passing in the appropriate options, you can search for CodeSets ", response = CodeSet.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = CodeSet.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = CodeSet.class, responseContainer = "List") })
    public Response searchCodeSets(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "pass an optional search string for looking up CodeSets") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchCodeSets(fileid,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{fileid}/codesets/{codesetid}/codes")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches Codes within a CodeSet", notes = "By passing in the appropriate options, you can search for Codes ", response = Code.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Code.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Code.class, responseContainer = "List") })
    public Response searchCodes(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "pass an optional search string for looking up Codes") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchCodes(fileid,codesetid,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{fileid}/components")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches components", notes = "By passing in the appropriate options, you can search for components ", response = Component.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Component.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Component.class, responseContainer = "List") })
    public Response searchComponents(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "pass an optional search string for looking up components") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchComponents(fileid,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{fileid}/datatypes")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches datatypes", notes = "By passing in the appropriate options, you can search for datatypes ", response = Datatype.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Datatype.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Datatype.class, responseContainer = "List") })
    public Response searchDatatypes(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "pass an optional search string for looking up datatypes") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchDatatypes(fileid,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{fileid}/fields")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches fields", notes = "By passing in the appropriate options, you can search for fields ", response = Field.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Field.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Field.class, responseContainer = "List") })
    public Response searchFields(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
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
    @io.swagger.annotations.ApiOperation(value = "searches messages", notes = "By passing in the appropriate options, you can search for messages ", response = Message.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Message.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Message.class, responseContainer = "List") })
    public Response searchMessages(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "pass an optional search string for looking up messages") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchMessages(fileid,searchString,skip,limit,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches Orchestra repository files", notes = "By passing in the appropriate options, you can search for Orchestra repository files ", response = Metadata.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Metadata.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Metadata.class, responseContainer = "List") })
    public Response searchRepositories(@ApiParam(value = "pass an optional search string for looking up components") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchRepositories(searchString,skip,limit,securityContext);
    }
    @PUT
    @Path("/{fileid}/codesets/{codesetid}/codes/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single Code, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Code updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateCodeById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "ID of Code to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "Code to update" ,required=true) Code code
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCodeById(fileid,codesetid,id,code,securityContext);
    }
    @PUT
    @Path("/{fileid}/codesets/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single CodeSet, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "CodeSet updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateCodeSetById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of CodeSet to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "CodeSet to update" ,required=true) CodeSet codeSet
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCodeSetById(fileid,id,codeSet,securityContext);
    }
    @PUT
    @Path("/{fileid}/components/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single component, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "component updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateComponentById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of component to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "component to update" ,required=true) Component component
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateComponentById(fileid,id,component,securityContext);
    }
    @PUT
    @Path("/{fileid}/datatypes/{name}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single datatype, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "datatype updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateDatatypeByName(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "name of datatype to update",required=true) @PathParam("name") String name
,@ApiParam(value = "datatype to update" ,required=true) Datatype datatype
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateDatatypeByName(fileid,name,datatype,securityContext);
    }
    @PUT
    @Path("/{fileid}/fields/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single field, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "field updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateFieldById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of field to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "field to update" ,required=true) Field field
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateFieldById(fileid,id,field,securityContext);
    }
    @PUT
    @Path("/{fileid}/messages/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single message scenario, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "message updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateMessageById(@ApiParam(value = "ID of Orchestra repository file",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "ID of message to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "message to update" ,required=true) Message message
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateMessageById(fileid,id,message,securityContext);
    }
    @PUT
    @Path("/{fileid}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates an Orchestra repository file, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "file updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateRepositoryById(@ApiParam(value = "ID of Orchestra repository file to update",required=true) @PathParam("fileid") String fileid
,@ApiParam(value = "Orchestra repository file to update" ,required=true) Metadata repository
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateRepositoryById(fileid,repository,securityContext);
    }
}
