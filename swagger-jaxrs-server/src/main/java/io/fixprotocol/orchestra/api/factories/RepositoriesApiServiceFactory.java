package io.fixprotocol.orchestra.api.factories;

import io.fixprotocol.orchestra.api.RepositoriesApiService;
import io.fixprotocol.orchestra.api.impl.RepositoriesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-10T17:21:41.794Z")
public class RepositoriesApiServiceFactory {
    private final static RepositoriesApiService service = new RepositoriesApiServiceImpl();

    public static RepositoriesApiService getRepositoriesApi() {
        return service;
    }
}
