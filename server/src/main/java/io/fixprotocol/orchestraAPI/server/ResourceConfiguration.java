package io.fixprotocol.orchestraAPI.server;

import java.util.logging.Logger;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class ResourceConfiguration extends ResourceConfig {

  public ResourceConfiguration() {
    //packages("io.fixprotocol.orchestraAPI.server");
   register(io.fixprotocol.orchestraAPI.server.RepositoriesApi.class);

    // Register an instance of LoggingFilter.
    register(new LoggingFilter(Logger.getLogger(ResourceConfig.class.getName()), true));
  }
}
