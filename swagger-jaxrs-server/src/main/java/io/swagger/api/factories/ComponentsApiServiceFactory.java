package io.swagger.api.factories;

import io.swagger.api.ComponentsApiService;
import io.swagger.api.impl.ComponentsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public class ComponentsApiServiceFactory {
    private final static ComponentsApiService service = new ComponentsApiServiceImpl();

    public static ComponentsApiService getComponentsApi() {
        return service;
    }
}
