package io.fixprotocol.orchestraAPI.store;

import java.util.List;
import java.util.function.Predicate;

import io.swagger.model.Metadata;

public interface RepositoryStore {

  /**
   * Creates a new repository if it does not already exist. The key field is {@link Metadata#identifier(String)}
   * @param metadata describes the repository to be created
   * @param toClone identifier of repository to clone (optional)
   * @return metadata of the successfully added repository. The returned value may be modified from the {@code metadata} parameter.
   * @throws DuplicateKeyException if the repository already exists
   * @throws RepositoryStoreException if the store operation fails
   */
  Metadata addRepository(Metadata metadata, String toClone) throws RepositoryStoreException;
  
  /**
   * Deletes one repository if it exists
   * @param identifier identifier of the repository to delete
   * @throws ResourceNotFoundException if the repository to delete does not exist
   * @throws RepositoryStoreException if the store operation fails 
   */
  void deleteRepository(String identifier) throws RepositoryStoreException;
  
  /**
   * Retrieves the metadata of a repository, if it exists
   * @param identifier identifier of the repository to delete
   * @return the metadata of a repository
   * @throws ResourceNotFoundException if the repository to delete does not exist
   * @throws RepositoryStoreException if the store operation fails 
   */
  Metadata getRepository(String identifier) throws RepositoryStoreException;
  
  /**
   * Retrieves the metadata of all repositories
   * @param search filter for selection of repositories by their Metadata
   * @return list of repository Metadata
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Metadata> getRepositories(Predicate<Metadata> search) throws RepositoryStoreException;

}
