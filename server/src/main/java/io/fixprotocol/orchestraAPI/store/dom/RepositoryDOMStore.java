package io.fixprotocol.orchestraAPI.store.dom;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.fixprotocol._2016.fixrepository.FieldType;
import io.fixprotocol._2016.fixrepository.Fields;
import io.fixprotocol._2016.fixrepository.Repository;

import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Metadata;
import io.fixprotocol.orchestraAPI.store.DuplicateKeyException;
import io.fixprotocol.orchestraAPI.store.RepositoryStore;
import io.fixprotocol.orchestraAPI.store.RepositoryStoreException;
import io.fixprotocol.orchestraAPI.store.ResourceNotFoundException;


/**
 * 
 * Operations are thread-safe.
 * 
 * @author Don Mendelson
 */
public class RepositoryDOMStore implements RepositoryStore {
  
  private class RepositoryKey {
    String reposName;
    String version;
    public RepositoryKey(String reposName, String version) {
      this.reposName = reposName;
      this.version = version;
    }
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      RepositoryKey other = (RepositoryKey) obj;
      if (!getOuterType().equals(other.getOuterType())) {
        return false;
      }
      if (reposName == null) {
        if (other.reposName != null) {
          return false;
        }
      } else if (!reposName.equals(other.reposName)) {
        return false;
      }
      if (version == null) {
        if (other.version != null) {
          return false;
        }
      } else if (!version.equals(other.version)) {
        return false;
      }
      return true;
    } 
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + ((reposName == null) ? 0 : reposName.hashCode());
      result = prime * result + ((version == null) ? 0 : version.hashCode());
      return result;
    }
    private RepositoryDOMStore getOuterType() {
      return RepositoryDOMStore.this;
    }
  }
  private final Map<RepositoryKey, Repository> repositories = new ConcurrentHashMap<>();

  @Override
  public void createField(String reposName, String version, Field field) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(field, "Field missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Fields fields = repository.getFields();
    if (fields == null) {
      fields = new Fields();
      repository.setFields(fields);
    }
    fields.getField().add(OrchestraAPItoDOM.FieldToDOM(field));
  }

  @Override
  public Metadata createRepository(io.fixprotocol.orchestra.model.Repository repository,
      String nameToClone, String versionToClone) throws RepositoryStoreException {
    Objects.requireNonNull(repository, "Repository missing");
    final RepositoryKey key = new RepositoryKey(repository.getName(), repository.getVersion());
    Repository exists = repositories.get(key);
    if (exists != null) {
      throw new DuplicateKeyException(String.format("Duplicate repository with name=%s version=%s", repository.getName(), repository.getVersion()));
    }
    io.fixprotocol._2016.fixrepository.Repository repositoryToAdd;
    if (nameToClone != null && versionToClone != null) {
      Repository repositoryToClone = repositories.get(new RepositoryKey(nameToClone, versionToClone));
      if (repositoryToClone == null) {
        throw new ResourceNotFoundException(
            String.format("Repository with name=%s version=%s not found", nameToClone, versionToClone));
      }
      repositoryToAdd = (io.fixprotocol._2016.fixrepository.Repository) repositoryToClone.clone();
      repositoryToAdd.setName(repository.getName());
      repositoryToAdd.setVersion(repository.getVersion());
      // overwrite metadata if it is provided
      if (repository.getMetadata() != null) {
        repositoryToAdd.setMetadata(OrchestraAPItoDOM.MetadataToDOM(repository.getMetadata()));
      }
    } else {
      repositoryToAdd = OrchestraAPItoDOM.RepositoryToDOM(repository);
    }
    repositories.putIfAbsent(key, repositoryToAdd);
    final Repository repository2 = repositories.get(key);
    return OrchestraAPItoDOM.DOMToMetadata(repository2.getMetadata());
  }

  @Override
  public void deleteField(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Field ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }  
  
    for (FieldType field : repository.getFields().getField()) {
      if (id == field.getId().intValue()) {
        repository.getFields().getField().remove(field);
        return;
      }
    }
    
    throw new ResourceNotFoundException(
        String.format("Field with ID=%d not found", id));
  }

  @Override
  public void deleteRepository(String reposName, String version) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    if (repositories.remove(key) == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
  }

  @Override
  public Field getFieldById(String reposName, String version, Integer id) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Field ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    for (FieldType field : repository.getFields().getField()) {
      if (id == field.getId().intValue()) {
        return OrchestraAPItoDOM.DOMToField(field);
      }
    }
    
    throw new ResourceNotFoundException(
        String.format("Field with ID=%d not found", id));

  }

  @Override
  public List<Metadata> getRepositoriesMetadata(Predicate<Metadata> search) {
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
  public Metadata getRepositoryMetadata(String reposName, String version) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository != null) {
      return OrchestraAPItoDOM.DOMToMetadata(repository.getMetadata());
    } else {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
  }

  @Override
  public void updateRepositoryMetadata(String reposName, String version,
      io.fixprotocol.orchestra.model.Repository repository) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repositoryToUpdate = repositories.get(key);
    if (repositoryToUpdate != null) {
      repositoryToUpdate.setMetadata(OrchestraAPItoDOM.MetadataToDOM(repository.getMetadata()));
    } else {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
  }

  @Override
  public List<Field> getFields(String reposName, String version, Predicate<Field> search) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Field> predicate = search != null ? search : new Predicate<Field>() {

      @Override
      public boolean test(Field t) {
        return true;
      }

    };
    return repository.getFields().getField().stream().map(f -> OrchestraAPItoDOM.DOMToField(f))
        .filter(predicate).collect(Collectors.toList());
  }

  @Override
  public void updateField(String reposName, String version, Integer id, Field field) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Field ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }  
  
    for (int i=0; i < repository.getFields().getField().size(); i++) {
      FieldType fieldType = repository.getFields().getField().get(i);
      if (id == fieldType.getId().intValue()) {
        repository.getFields().getField().set(i, OrchestraAPItoDOM.FieldToDOM(field));
        return;
      }
    }
    
    throw new ResourceNotFoundException(
        String.format("Field with ID=%d not found", id));
  }
}