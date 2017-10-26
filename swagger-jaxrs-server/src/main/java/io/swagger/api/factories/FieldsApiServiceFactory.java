package io.swagger.api.factories;

import io.swagger.api.FieldsApiService;
import io.swagger.api.impl.FieldsApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public class FieldsApiServiceFactory {
    private final static FieldsApiService service = new FieldsApiServiceImpl();

    public static FieldsApiService getFieldsApi() {
        return service;
    }
}
