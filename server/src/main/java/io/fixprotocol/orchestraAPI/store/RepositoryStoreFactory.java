package io.fixprotocol.orchestraAPI.store;

import io.fixprotocol.orchestraAPI.store.dom.RepositoryDOMStore;

/**
 * Returns the default implementation of a store
 * 
 * todo: other store implementations to come
 * @author Don Mendelson
 *
 */
public class RepositoryStoreFactory {

  public RepositoryStore getRepositoryStore() {
      return new RepositoryDOMStore();
  }
}
