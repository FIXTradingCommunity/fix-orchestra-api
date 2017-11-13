package io.fixprotocol.orchestraAPI.store;

import java.util.List;
import java.util.function.Predicate;

import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestra.model.Repository;



public interface RepositoryStore {

  /**
   * Creates a new field in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param field to add to the repository
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void createField(String reposName, String version, Field field) throws RepositoryStoreException;

  /**
   * Creates a new repository if it does not already exist. The key field is
   * {@link Metadata#identifier(String)}
   * 
   * @param metadata describes the repository to be created
   * @param toClone identifier of repository to clone (optional)
   * @return metadata of the successfully added repository. The returned value may be modified from
   *         the {@code metadata} parameter.
   * @throws DuplicateKeyException if the repository already exists
   * @throws RepositoryStoreException if the store operation fails
   */
  Metadata createRepository(Repository repository, String nameToClone, String versionToClone)
      throws RepositoryStoreException;

  /**
   * Deletes one Field if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @throws ResourceNotFoundException if the repository or field to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteField(String reposName, String version, Integer id) throws RepositoryStoreException;

  /**
   * Deletes one repository if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @throws ResourceNotFoundException if the repository to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void deleteRepository(String reposName, String version) throws RepositoryStoreException;

  /**
   * Retrieves a Field by its ID
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id field identifier
   * @return the field
   * @throws ResourceNotFoundException if the repository or field does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Field getFieldById(String reposName, String version, Integer id) throws RepositoryStoreException;

  /**
   * Retrieves all fields in a repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param predicate filter for fields to return
   * @return a list of fields
   * @throws ResourceNotFoundException if the repository does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Field> getFields(String reposName, String version, Predicate<Field> predicate)
      throws RepositoryStoreException;

  /**
   * Retrieves the metadata of all repositories
   * 
   * @param search filter for selection of repositories by their Metadata
   * @return list of Metadata. The identifier field of a Metadata carries the identifier of its
   *         containing repository.
   * @throws RepositoryStoreException if the store operation fails
   */
  List<Metadata> getRepositoriesMetadata(Predicate<Metadata> search)
      throws RepositoryStoreException;

  /**
   * Retrieves the metadata of a repository, if it exists
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @return the metadata of a repository
   * @throws ResourceNotFoundException if the repository to delete does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  Metadata getRepositoryMetadata(String reposName, String version) throws RepositoryStoreException;

  /**
   * Update an existing field
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param id ID of the field to update
   * @param field new value of the field
   * @throws ResourceNotFoundException if the repository or field to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateField(String reposName, String version, Integer id, Field field) throws RepositoryStoreException;

  /**
   * Update the metadata of an existing repository
   * 
   * @param reposName name of Orchestra repository (required)
   * @param version version of Orchestra repository (required)
   * @param repository new value of metadata
   * @throws ResourceNotFoundException if the repository to update does not exist
   * @throws RepositoryStoreException if the store operation fails
   */
  void updateRepositoryMetadata(String reposName, String version, Repository repository)
      throws RepositoryStoreException;

}
