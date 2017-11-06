package io.swagger.api.factories;

import io.swagger.api.RepositoriesApiService;
import io.swagger.api.impl.RepositoriesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-06T20:15:25.553Z")
public class RepositoriesApiServiceFactory {
    private final static RepositoriesApiService service = new RepositoriesApiServiceImpl();

    public static RepositoriesApiService getRepositoriesApi() {
        return service;
    }
}
