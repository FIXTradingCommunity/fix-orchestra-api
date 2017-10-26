package io.swagger.api.factories;

import io.swagger.api.OrchesraApiService;
import io.swagger.api.impl.OrchesraApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T19:00:28.823Z")
public class OrchesraApiServiceFactory {
    private final static OrchesraApiService service = new OrchesraApiServiceImpl();

    public static OrchesraApiService getOrchesraApi() {
        return service;
    }
}
