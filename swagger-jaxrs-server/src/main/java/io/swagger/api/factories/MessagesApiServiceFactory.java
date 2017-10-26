package io.swagger.api.factories;

import io.swagger.api.MessagesApiService;
import io.swagger.api.impl.MessagesApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-10-25T21:01:49.870Z")
public class MessagesApiServiceFactory {
    private final static MessagesApiService service = new MessagesApiServiceImpl();

    public static MessagesApiService getMessagesApi() {
        return service;
    }
}
