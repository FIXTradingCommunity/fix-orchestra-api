package io.fixprotocol.orchestraAPI.server;

import org.glassfish.jersey.server.ResourceConfig;

public class ResourceConfiguration extends ResourceConfig {

  public ResourceConfiguration() {
    packages("io.fixprotocol.orchestraAPI.server");
    register(RepositoriesApi.class);
  }

}
