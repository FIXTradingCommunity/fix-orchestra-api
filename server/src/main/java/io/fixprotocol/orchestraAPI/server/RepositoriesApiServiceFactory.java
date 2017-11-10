package io.fixprotocol.orchestraAPI.server;

import io.fixprotocol.orchestra.api.RepositoriesApiService;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreFactory;


public class RepositoriesApiServiceFactory {
  private final static RepositoryStoreFactory storeFactory = new RepositoryStoreFactory();
  private final static RepositoriesApiService service =
      new RepositoriesApiServiceImpl(storeFactory.getRepositoryStore());

  public static RepositoriesApiService getRepositoriesApi() {
    return service;
  }
}
