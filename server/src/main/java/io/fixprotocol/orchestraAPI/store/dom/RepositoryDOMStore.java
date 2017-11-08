package io.fixprotocol.orchestraAPI.store.dom;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.fixprotocol._2016.fixrepository.Repository;
import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.RepositoryStore;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;
import io.swagger.model.Metadata;

/**
 * 
 * Operations are thread-safe.
 * 
 * @author Don Mendelson
 */
public class RepositoryDOMStore implements RepositoryStore {
  private final Map<String, Repository> repositories = new ConcurrentHashMap<>();

  @Override
  public Metadata addRepository(Metadata metadata, String toClone) throws RepositoryStoreException {
    Objects.requireNonNull(metadata, "Repository metadata missing");
    String identifier = metadata.getIdentifier();
    if (identifier == null) {
      metadata.setIdentifier(generateIdentifier());
    }
    Repository exists = repositories.get(metadata.getIdentifier());
    if (exists != null) {
      throw new DuplicateKeyException("Duplicate repository identifier " + identifier);
    }
    Repository repository;
    if (toClone != null) {
      Repository repositoryToClone = repositories.get(toClone);
      if (repositoryToClone == null) {
        throw new ResourceNotFoundException(
            String.format("Repository with ID %s not found", toClone));
      }
      repository = (Repository) repositoryToClone.clone();
    } else {
      repository = new Repository();
    }
    repository.setMetadata(OrchestraAPItoDOM.MetadataToDOM(metadata));
    repositories.putIfAbsent(metadata.getIdentifier(), repository);
    final Repository repository2 = repositories.get(metadata.getIdentifier());
    return OrchestraAPItoDOM.DOMToMetadata(repository2.getMetadata());
  }

  @Override
  public void deleteRepository(String identifier) throws RepositoryStoreException {
    Objects.requireNonNull(identifier, "Repository identifier missing");
    if (repositories.remove(identifier) == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with ID %s not found", identifier));
    }
  }

  @Override
  public List<Metadata> getRepositories(Predicate<Metadata> search) {
    Predicate<Metadata> predicate = search != null ? search : new Predicate<Metadata>() {

      @Override
      public boolean test(Metadata t) {
        return true;
      }

    };
    return repositories.values().stream().map(r -> OrchestraAPItoDOM.DOMToMetadata(r.getMetadata()))
        .filter(predicate).collect(Collectors.toList());
  }

  @Override
  public Metadata getRepository(String identifier) throws RepositoryStoreException {
    Objects.requireNonNull(identifier, "Repository identifier missing");
    Repository repository = repositories.get(identifier);
    if (repository != null) {
      return OrchestraAPItoDOM.DOMToMetadata(repository.getMetadata());
    } else {
      throw new ResourceNotFoundException(
          String.format("Repository with ID %s not found", identifier));
    }
  }

  private String generateIdentifier() {
    return UUID.randomUUID().toString();
  }

}
