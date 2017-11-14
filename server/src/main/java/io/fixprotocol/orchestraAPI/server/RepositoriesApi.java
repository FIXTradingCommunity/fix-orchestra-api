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

import io.fixprotocol.orchestra.api.NotFoundException;
import io.fixprotocol.orchestra.api.RepositoriesApiService;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Datatype;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Message;
import io.fixprotocol.orchestra.model.Repository;
import io.swagger.annotations.ApiParam;

@Path("/repositories")


@io.swagger.annotations.Api(description = "the repositories API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-10T17:21:41.794Z")
public class RepositoriesApi  {
   private final RepositoriesApiService delegate = RepositoriesApiServiceFactory.getRepositoriesApi();

    @POST
    @Path("/{repos-name}/{version}/codesets/{codesetid}/codes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a Code to CodeSet", notes = "Adds a Code", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addCode(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "Code to add" ) Code code
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addCode(reposName,version,codesetid,code,securityContext);
    }
    @POST
    @Path("/{repos-name}/{version}/codesets")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a CodeSet", notes = "Adds a CodeSet", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addCodeSet(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "CodeSet to add" ) CodeSet codeSet
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addCodeSet(reposName,version,codeSet,securityContext);
    }
    @POST
    @Path("/{repos-name}/{version}/components")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a component", notes = "Adds a component", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addComponent(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "Component to add" ) Component component
,@ApiParam(value = "ID of component to clone") @QueryParam("toClone") Integer toClone
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addComponent(reposName,version,component,toClone,securityContext);
    }
    @POST
    @Path("/{repos-name}/{version}/datatypes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a datatype", notes = "Adds a datatype", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addDatatype(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "Datatype to add" ) Datatype datatype
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addDatatype(reposName,version,datatype,securityContext);
    }
    @POST
    @Path("/{repos-name}/{version}/fields")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a field", notes = "Adds a field", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addField(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "field to add" ) Field field
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addField(reposName,version,field,securityContext);
    }
    @POST
    @Path("/{repos-name}/{version}/messages")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds a message scenario", notes = "Adds a message scenario", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addMessage(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "message to add" ) Message message
,@ApiParam(value = "ID of message to clone") @QueryParam("toClone") Integer toClone
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addMessage(reposName,version,message,toClone,securityContext);
    }
    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "adds an Orchestra repository", notes = "Adds an Orchestra repository", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "item created", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "invalid input, object invalid", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 409, message = "an existing item already exists", response = void.class) })
    public Response addRepository(@ApiParam(value = "Orchestra repository to add" ,required=true) Repository repository
,@ApiParam(value = "name of Orchestra repository to clone") @QueryParam("nameToClone") String nameToClone
,@ApiParam(value = "version of Orchestra repository to clone") @QueryParam("versionToClone") String versionToClone
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addRepository(repository,nameToClone,versionToClone,securityContext);
    }
    @DELETE
    @Path("/{repos-name}/{version}/codesets/{codesetid}/codes/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single Code based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Code deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Code not found", response = void.class) })
    public Response deleteCode(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "ID of Code to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteCode(reposName,version,codesetid,id,securityContext);
    }
    @DELETE
    @Path("/{repos-name}/{version}/codesets/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single CodeSet based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "CodeSet deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "CodeSet not found", response = void.class) })
    public Response deleteCodeSet(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of CodeSet to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteCodeSet(reposName,version,id,securityContext);
    }
    @DELETE
    @Path("/{repos-name}/{version}/components/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single component based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "component deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "component not found", response = void.class) })
    public Response deleteComponent(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of component to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteComponent(reposName,version,id,securityContext);
    }
    @DELETE
    @Path("/{repos-name}/{version}/datatypes/{name}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single datatype based on the name supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "datatype deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "datatype not found", response = void.class) })
    public Response deleteDatatype(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "name of datatype to delete",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteDatatype(reposName,version,name,securityContext);
    }
    @DELETE
    @Path("/{repos-name}/{version}/fields/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single field based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "field deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "field not found", response = void.class) })
    public Response deleteField(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of field to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteField(reposName,version,id,securityContext);
    }
    @DELETE
    @Path("/{repos-name}/{version}/messages/{id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single message scenario based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "message deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "message not found", response = void.class) })
    public Response deleteMessage(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of message to delete",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteMessage(reposName,version,id,securityContext);
    }
    @DELETE
    @Path("/{repos-name}/{version}")
    
    
    @io.swagger.annotations.ApiOperation(value = "deletes a single Orchestra repository  based on the ID supplied", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "repository deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "repository not found", response = void.class) })
    public Response deleteRepository(@ApiParam(value = "name of Orchestra repository to delete",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository to delete",required=true) @PathParam("version") String version
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteRepository(reposName,version,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/codesets/{codesetid}/codes/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single Code, if found", notes = "", response = Code.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Code response", response = Code.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Code.class) })
    public Response findCodeById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "ID of Code to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findCodeById(reposName,version,codesetid,id,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/codesets/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single CodeSet, if found", notes = "", response = CodeSet.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "CodeSet response", response = CodeSet.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = CodeSet.class) })
    public Response findCodeSetById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of CodeSet to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findCodeSetById(reposName,version,id,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/components/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single component, if found", notes = "", response = Component.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "component response", response = Component.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Component.class) })
    public Response findComponentById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of component to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findComponentById(reposName,version,id,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/datatypes/{name}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single datatype, if found", notes = "", response = Datatype.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "datatype response", response = Datatype.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Datatype.class) })
    public Response findDatatypeByName(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "name of datatype to fetch",required=true) @PathParam("name") String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findDatatypeByName(reposName,version,name,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/fields/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single field, if found", notes = "", response = Field.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "field response", response = Field.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Field.class) })
    public Response findFieldById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of field to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findFieldById(reposName,version,id,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/messages/{id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single message scenario, if found", notes = "", response = Message.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "message response", response = Message.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Message.class) })
    public Response findMessageById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of message to fetch",required=true) @PathParam("id") Integer id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findMessageById(reposName,version,id,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns a single Orchestra repository metadata, if found", notes = "", response = Repository.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "repository response", response = Repository.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Repository.class) })
    public Response findRepositoryById(@ApiParam(value = "name of Orchestra repository to fetch",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository to fetch",required=true) @PathParam("version") String version
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findRepositoryById(reposName,version,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/codesets")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches CodeSets", notes = "By passing in the appropriate options, you can search for CodeSets ", response = CodeSet.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = CodeSet.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = CodeSet.class, responseContainer = "List") })
    public Response searchCodeSets(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "pass an optional search string for looking up CodeSets") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchCodeSets(reposName,version,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/codesets/{codesetid}/codes")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches Codes within a CodeSet", notes = "By passing in the appropriate options, you can search for Codes", response = Code.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Code.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Code.class, responseContainer = "List") })
    public Response searchCodes(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "pass an optional search string for looking up Codes") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchCodes(reposName,version,codesetid,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/components")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches components", notes = "By passing in the appropriate options, you can search for components ", response = Component.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Component.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Component.class, responseContainer = "List") })
    public Response searchComponents(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "pass an optional search string for looking up components") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchComponents(reposName,version,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/datatypes")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches datatypes", notes = "By passing in the appropriate options, you can search for datatypes ", response = Datatype.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Datatype.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Datatype.class, responseContainer = "List") })
    public Response searchDatatypes(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "pass an optional search string for looking up datatypes") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchDatatypes(reposName,version,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/fields")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches fields", notes = "By passing in the appropriate options, you can search for fields ", response = Field.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Field.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Field.class, responseContainer = "List") })
    public Response searchFields(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "pass an optional search string for looking up fields") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchFields(reposName,version,searchString,skip,limit,securityContext);
    }
    @GET
    @Path("/{repos-name}/{version}/messages")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches messages", notes = "By passing in the appropriate options, you can search for messages ", response = Message.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Message.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Message.class, responseContainer = "List") })
    public Response searchMessages(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "pass an optional search string for looking up messages") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchMessages(reposName,version,searchString,skip,limit,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "searches Orchestra repositories", notes = "By passing in the appropriate options, you can search for Orchestra repositories", response = Repository.class, responseContainer = "List", tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "search results matching criteria", response = Repository.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "bad input parameter", response = Repository.class, responseContainer = "List") })
    public Response searchRepositories(@ApiParam(value = "pass an optional search string for looking up components") @QueryParam("searchString") String searchString
,@ApiParam(value = "number of records to skip for pagination") @QueryParam("skip") Integer skip
,@ApiParam(value = "maximum number of records to return") @QueryParam("limit") Integer limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchRepositories(searchString,skip,limit,securityContext);
    }
    @PUT
    @Path("/{repos-name}/{version}/codesets/{codesetid}/codes/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single Code, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Code updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateCodeById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of CodeSet",required=true) @PathParam("codesetid") Integer codesetid
,@ApiParam(value = "ID of Code to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "Code to update" ,required=true) Code code
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCodeById(reposName,version,codesetid,id,code,securityContext);
    }
    @PUT
    @Path("/{repos-name}/{version}/codesets/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single CodeSet, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "CodeSet updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateCodeSetById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of CodeSet to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "CodeSet to update" ,required=true) CodeSet codeSet
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateCodeSetById(reposName,version,id,codeSet,securityContext);
    }
    @PUT
    @Path("/{repos-name}/{version}/components/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single component, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "component updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateComponentById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of component to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "component to update" ,required=true) Component component
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateComponentById(reposName,version,id,component,securityContext);
    }
    @PUT
    @Path("/{repos-name}/{version}/datatypes/{name}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single datatype, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "datatype updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateDatatypeByName(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "name of datatype to update",required=true) @PathParam("name") String name
,@ApiParam(value = "datatype to update" ,required=true) Datatype datatype
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateDatatypeByName(reposName,version,name,datatype,securityContext);
    }
    @PUT
    @Path("/{repos-name}/{version}/fields/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single field, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "field updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateFieldById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of field to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "field to update" ,required=true) Field field
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateFieldById(reposName,version,id,field,securityContext);
    }
    @PUT
    @Path("/{repos-name}/{version}/messages/{id}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates a single message scenario, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "message updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateMessageById(@ApiParam(value = "name of Orchestra repository",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository",required=true) @PathParam("version") String version
,@ApiParam(value = "ID of message to update",required=true) @PathParam("id") Integer id
,@ApiParam(value = "message to update" ,required=true) Message message
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateMessageById(reposName,version,id,message,securityContext);
    }
    @PUT
    @Path("/{repos-name}/{version}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Updates an Orchestra repository, if found (idempotent)", notes = "", response = void.class, tags={ "repository", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "repository updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response updateRepositoryById(@ApiParam(value = "name of Orchestra repository to update",required=true) @PathParam("repos-name") String reposName
,@ApiParam(value = "version of Orchestra repository to update",required=true) @PathParam("version") String version
,@ApiParam(value = "Orchestra repository to update" ,required=true) Repository repository
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateRepositoryById(reposName,version,repository,securityContext);
    }
}
