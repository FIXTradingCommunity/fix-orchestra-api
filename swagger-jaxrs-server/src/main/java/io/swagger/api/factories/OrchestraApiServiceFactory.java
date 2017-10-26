package io.swagger.api.factories;

import io.swagger.api.OrchestraApiService;
import io.swagger.api.impl.OrchestraApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-26T19:00:28.823Z")
public class OrchestraApiServiceFactory {
    private final static OrchestraApiService service = new OrchestraApiServiceImpl();

    public static OrchestraApiService getOrchestraApi() {
        return service;
    }
}
