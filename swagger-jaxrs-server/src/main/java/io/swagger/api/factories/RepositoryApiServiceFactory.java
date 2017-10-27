package io.swagger.api.factories;

import io.swagger.api.RepositoryApiService;
import io.swagger.api.impl.RepositoryApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-27T18:20:26.929Z")
public class RepositoryApiServiceFactory {
    private final static RepositoryApiService service = new RepositoryApiServiceImpl();

    public static RepositoryApiService getRepositoryApi() {
        return service;
    }
}
