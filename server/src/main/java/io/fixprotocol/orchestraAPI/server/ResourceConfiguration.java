package io.fixprotocol.orchestraAPI.server;

import org.glassfish.jersey.server.ResourceConfig;

public class ResourceConfiguration extends ResourceConfig {

  public ResourceConfiguration() {
    // packages("io.fixprotocol.orchestraAPI.server");
    register(io.fixprotocol.orchestraAPI.server.RepositoriesApi.class);

    // Register an instance of LoggingFeature.
    /*register(new LoggingFeature(Logger.getLogger(getClass().getName()), Level.FINE,
        LoggingFeature.Verbosity.PAYLOAD_ANY, Integer.MAX_VALUE));
        */
  }
}
