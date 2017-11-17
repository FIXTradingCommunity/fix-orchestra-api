package io.fixprotocol.orchestraAPI.store.dom;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import io.fixprotocol._2016.fixrepository.CodeSetType;
import io.fixprotocol._2016.fixrepository.CodeSets;
import io.fixprotocol._2016.fixrepository.CodeType;
import io.fixprotocol._2016.fixrepository.ComponentType;
import io.fixprotocol._2016.fixrepository.Components;
import io.fixprotocol._2016.fixrepository.Datatypes;
import io.fixprotocol._2016.fixrepository.FieldType;
import io.fixprotocol._2016.fixrepository.Fields;
import io.fixprotocol._2016.fixrepository.GroupType;
import io.fixprotocol._2016.fixrepository.Repository;
import io.fixprotocol.orchestra.model.Code;
import io.fixprotocol.orchestra.model.CodeSet;
import io.fixprotocol.orchestra.model.Component;
import io.fixprotocol.orchestra.model.Datatype;
import io.fixprotocol.orchestra.model.Field;
import io.fixprotocol.orchestra.model.Group;
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
  public void createCode(String reposName, String version, Integer codesetid, Code code)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codesetid, "CodeSet ID missing");
    Objects.requireNonNull(code, "Code missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<CodeSetType> codeSets = getCodeSets(repository);

    for (CodeSetType codeSet : codeSets) {
      if (codesetid == codeSet.getId().intValue()) {
        List<CodeType> codes = codeSet.getCode();
        for (CodeType codeType : codes) {
          if (codeType.getId().intValue() == code.getOid().getId()) {
            throw new DuplicateKeyException(
                String.format("Duplicate code with ID=%d", code.getOid().getId()));
          }
        }
        codes.add(OrchestraAPItoDOM.CodeToDOM(code));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", codesetid));
  }

  @Override
  public void createCodeSet(String reposName, String version, CodeSet codeSet)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codeSet, "CodeSet missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);

    for (int i = 0; i < codeSets.size(); i++) {
      CodeSetType fieldType = codeSets.get(i);
      if (codeSet.getOid().getId() == fieldType.getId().intValue()) {
        throw new DuplicateKeyException(
            String.format("Duplicate field with ID=%d", codeSet.getOid().getId()));
      }
    }
    codeSets.add(OrchestraAPItoDOM.CodeSetToDOM(codeSet));
  }

  @Override
  public void createComponent(String reposName, String version, Component component,
      Integer toClone) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(component, "Component missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<ComponentType> components = getComponentList(repository);

    for (int i = 0; i < components.size(); i++) {
      ComponentType componentType = components.get(i);
      if (component.getOid().getId() == componentType.getId().intValue()) {
        throw new DuplicateKeyException(
            String.format("Duplicate component with ID=%d", component.getOid().getId()));
      }
    }
    components.add(OrchestraAPItoDOM.ComponentToDOM(component));
  }

  @Override
  public void createDatatype(String reposName, String version, Datatype datatype)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(datatype, "Datatype missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    for (int i = 0; i < datatypes.size(); i++) {
      io.fixprotocol._2016.fixrepository.Datatype datatypeDOM = datatypes.get(i);
      if (datatype.getName().equals(datatypeDOM.getName())) {
        throw new DuplicateKeyException(String.format("Duplicate datatype %s", datatype.getName()));
      }
    }
    datatypes.add(OrchestraAPItoDOM.DatatypeToDOM(datatype));
  }

  @Override
  public void createField(String reposName, String version, Field field)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(field, "Field missing");
    Repository repository = repositories.get(new RepositoryKey(reposName, version));
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<FieldType> fields = getFieldList(repository);

    for (int i = 0; i < fields.size(); i++) {
      FieldType fieldType = fields.get(i);
      if (field.getOid().getId() == fieldType.getId().intValue()) {
        throw new DuplicateKeyException(
            String.format("Duplicate field with ID=%d", field.getOid().getId()));
      }
    }
    fields.add(OrchestraAPItoDOM.FieldToDOM(field));
  }

  @Override
  public Metadata createRepository(io.fixprotocol.orchestra.model.Repository repository,
      String nameToClone, String versionToClone) throws RepositoryStoreException {
    Objects.requireNonNull(repository, "Repository missing");
    final RepositoryKey key = new RepositoryKey(repository.getName(), repository.getVersion());
    Repository exists = repositories.get(key);
    if (exists != null) {
      throw new DuplicateKeyException(String.format("Duplicate repository with name=%s version=%s",
          repository.getName(), repository.getVersion()));
    }
    io.fixprotocol._2016.fixrepository.Repository repositoryToAdd;
    if (nameToClone != null && versionToClone != null) {
      Repository repositoryToClone =
          repositories.get(new RepositoryKey(nameToClone, versionToClone));
      if (repositoryToClone == null) {
        throw new ResourceNotFoundException(String
            .format("Repository with name=%s version=%s not found", nameToClone, versionToClone));
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
  public void createRepositoryFromFile(File file) throws RepositoryStoreException {
    try {
      Objects.requireNonNull(file, "File missing");
      Repository repository = unMarshal(file);
      final RepositoryKey key = new RepositoryKey(repository.getName(), repository.getVersion());
      Repository exists = repositories.get(key);
      if (exists != null) {
        throw new DuplicateKeyException(
            String.format("Duplicate repository with name=%s version=%s", repository.getName(),
                repository.getVersion()));
      }
      repositories.putIfAbsent(key, repository);
    } catch (JAXBException e) {
      throw new RepositoryStoreException("Unable to read or parse repository file", e);
    }
  }

  @Override
  public void deleteCode(String reposName, String version, Integer codesetid, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codesetid, "CodeSet ID missing");
    Objects.requireNonNull(id, "Code ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);
    for (CodeSetType codeSet : codeSets) {
      if (codesetid == codeSet.getId().intValue()) {
        List<CodeType> codes = codeSet.getCode();
        for (CodeType codeType : codes) {
          if (codeType.getId().intValue() == id) {
            codes.remove(codeType);
            return;
          }
        }
        throw new ResourceNotFoundException(String.format("Code with ID=%d not found", id));
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", codesetid));
  }

  @Override
  public void deleteCodeSet(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "CodeSet ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);
    for (CodeSetType codeSet : codeSets) {
      if (id == codeSet.getId().intValue()) {
        codeSets.remove(codeSet);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
  }

  @Override
  public void deleteComponent(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Component ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<ComponentType> components = getComponentList(repository);
    for (ComponentType component : components) {
      if (id == component.getId().intValue()) {
        components.remove(component);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Component with ID=%d not found", id));
  }

  @Override
  public void deleteDatatype(String reposName, String version, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Datatype name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    for (io.fixprotocol._2016.fixrepository.Datatype datatype : datatypes) {
      if (name.equals(datatype.getName())) {
        datatypes.remove(datatype);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Datetype %s not found", name));
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

    List<FieldType> fields = getFieldList(repository);
    for (FieldType field : fields) {
      if (id == field.getId().intValue()) {
        fields.remove(field);
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Field with ID=%d not found", id));
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
  public Code getCodeById(String reposName, String version, Integer codesetid, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codesetid, "CodeSet ID missing");
    Objects.requireNonNull(id, "Code ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);
    for (CodeSetType codeSet : codeSets) {
      if (codesetid == codeSet.getId().intValue()) {
        List<CodeType> codes = codeSet.getCode();
        for (CodeType codeType : codes) {
          if (codeType.getId().intValue() == id) {
            return OrchestraAPItoDOM.DOMToCode(codeType);
          }
        }
        throw new ResourceNotFoundException(String.format("Code with ID=%d not found", id));
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", codesetid));
  }

  @Override
  public List<Code> getCodes(String reposName, String version, Integer codesetid,
      Predicate<Code> search) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(codesetid, "CodeSet ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    Predicate<Code> predicate = search != null ? search : new Predicate<Code>() {

      @Override
      public boolean test(Code t) {
        return true;
      }

    };

    List<CodeSetType> codeSets = getCodeSets(repository);
    for (CodeSetType codeSet : codeSets) {
      if (codesetid == codeSet.getId().intValue()) {
        List<CodeType> codes = codeSet.getCode();
        return codes.stream().map(c -> OrchestraAPItoDOM.DOMToCode(c)).filter(predicate)
            .collect(Collectors.toList());
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", codesetid));
  }

  @Override
  public CodeSet getCodeSetById(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "CodeSet ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<CodeSetType> codeSets = getCodeSets(repository);

    for (CodeSetType codeSet : codeSets) {
      if (id == codeSet.getId().intValue()) {
        return OrchestraAPItoDOM.DOMToCodeSet(codeSet);
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
  }

  @Override
  public List<CodeSet> getCodeSets(String reposName, String version, Predicate<CodeSet> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<CodeSet> predicate = search != null ? search : new Predicate<CodeSet>() {

      @Override
      public boolean test(CodeSet t) {
        return true;
      }

    };
    List<CodeSetType> codeSets = getCodeSets(repository);

    return codeSets.stream().map(cs -> OrchestraAPItoDOM.DOMToCodeSet(cs)).filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public Component getComponentById(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Component ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<ComponentType> components = getComponentList(repository);

    for (ComponentType component : components) {
      if (id == component.getId().intValue()) {
        return OrchestraAPItoDOM.DOMToComponent(component);
      }
    }

    throw new ResourceNotFoundException(String.format("Component with ID=%d not found", id));
  }

  @Override
  public List<Component> getComponents(String reposName, String version,
      Predicate<Component> search) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Component> predicate = search != null ? search : new Predicate<Component>() {

      @Override
      public boolean test(Component t) {
        return true;
      }

    };
    List<ComponentType> components = getComponentList(repository);

    // ComponentType only, not subclass
    return components.stream().filter(c -> c.getClass().equals(ComponentType.class) ).map(c -> OrchestraAPItoDOM.DOMToComponent(c)).filter(predicate)
        .collect(Collectors.toList());
  }

  @Override
  public Datatype getDatatype(String reposName, String version, String name)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Datatype name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    for (io.fixprotocol._2016.fixrepository.Datatype datatype : datatypes) {
      if (name.equals(datatype.getName())) {
        return OrchestraAPItoDOM.DOMToDatatype(datatype);
      }
    }

    throw new ResourceNotFoundException(String.format("Datatype %s not found", name));


  }

  @Override
  public List<Datatype> getDatatypes(String reposName, String version, Predicate<Datatype> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Datatype> predicate = search != null ? search : new Predicate<Datatype>() {

      @Override
      public boolean test(Datatype t) {
        return true;
      }

    };

    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    return datatypes.stream().map(d -> OrchestraAPItoDOM.DOMToDatatype(d)).filter(predicate)
        .collect(Collectors.toList());

  }

  @Override
  public Field getFieldById(String reposName, String version, Integer id)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Field ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<FieldType> fields = getFieldList(repository);

    for (FieldType field : fields) {
      if (id == field.getId().intValue()) {
        return OrchestraAPItoDOM.DOMToField(field);
      }
    }

    throw new ResourceNotFoundException(String.format("Field with ID=%d not found", id));
  }

  @Override
  public List<Field> getFields(String reposName, String version, Predicate<Field> search)
      throws RepositoryStoreException {
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
    List<FieldType> fields = getFieldList(repository);

    return fields.stream().map(f -> OrchestraAPItoDOM.DOMToField(f)).filter(predicate)
        .collect(Collectors.toList());
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
  public File getRepositoryFile(String reposName, String version) throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository != null) {
      try {
        return marshal(repository);
      } catch (JAXBException | IOException e) {
        throw new RepositoryStoreException("Unable to produce repository file", e);
      }
    } else {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
  }

  @Override
  public Metadata getRepositoryMetadata(String reposName, String version)
      throws RepositoryStoreException {
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
  public void updateCode(String reposName, String version, Integer codesetid, Integer id, Code code)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "CodeSet ID missing");
    Objects.requireNonNull(code, "Code missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    List<CodeSetType> codeSets = getCodeSets(repository);
    for (CodeSetType codeSet : codeSets) {
      if (codesetid == codeSet.getId().intValue()) {
        List<CodeType> codes = codeSet.getCode();
        for (int i = 0; i < codes.size(); i++) {
          if (codes.get(i).getId().intValue() == id) {
            codes.set(i, OrchestraAPItoDOM.CodeToDOM(code));
            return;
          }
        }
        throw new ResourceNotFoundException(String.format("Code with ID=%d not found", id));
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
  }

  @Override
  public void updateCodeSet(String reposName, String version, Integer id, CodeSet codeSet)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "CodeSet ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<CodeSetType> codeSets = getCodeSets(repository);

    for (int i = 0; i < codeSets.size(); i++) {
      CodeSetType codeSetType = codeSets.get(i);
      if (id == codeSetType.getId().intValue()) {
        codeSets.set(i, OrchestraAPItoDOM.CodeSetToDOM(codeSet));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("CodeSet with ID=%d not found", id));
  }

  @Override
  public void updateComponent(String reposName, String version, Integer id, Component component)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(id, "Component ID missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<ComponentType> components = getComponentList(repository);

    for (int i = 0; i < components.size(); i++) {
      ComponentType componentType = components.get(i);
      if (id == componentType.getId().intValue()) {
        components.set(i, OrchestraAPItoDOM.ComponentToDOM(component));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Component with ID=%d not found", id));
  }

  @Override
  public void updateDatatype(String reposName, String version, String name, Datatype datatype)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    Objects.requireNonNull(name, "Datatype name missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);

    final Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }

    List<io.fixprotocol._2016.fixrepository.Datatype> datatypes = getDatatypeList(repository);

    for (int i = 0; i < datatypes.size(); i++) {
      io.fixprotocol._2016.fixrepository.Datatype datatypeDOM = datatypes.get(i);
      if (name.equals(datatypeDOM.getName())) {
        datatypes.set(i, OrchestraAPItoDOM.DatatypeToDOM(datatype));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Datatype %s not found", name));
  }

  @Override
  public void updateField(String reposName, String version, Integer id, Field field)
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

    List<FieldType> fields = getFieldList(repository);

    for (int i = 0; i < fields.size(); i++) {
      FieldType fieldType = fields.get(i);
      if (id == fieldType.getId().intValue()) {
        fields.set(i, OrchestraAPItoDOM.FieldToDOM(field));
        return;
      }
    }

    throw new ResourceNotFoundException(String.format("Field with ID=%d not found", id));
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

  private List<CodeSetType> getCodeSets(Repository repository) {
    CodeSets codeSets = repository.getCodeSets();
    if (codeSets == null) {
      codeSets = new CodeSets();
      repository.setCodeSets(codeSets);
    }
    return codeSets.getCodeSet();
  }

  private List<io.fixprotocol._2016.fixrepository.Datatype> getDatatypeList(Repository repository) {
    Datatypes datatypes = repository.getDatatypes();
    if (datatypes == null) {
      datatypes = new Datatypes();
      repository.setDatatypes(datatypes);
    }
    return datatypes.getDatatype();
  }

  private List<ComponentType> getComponentList(Repository repository) {
    Components components = repository.getComponents();
    if (components == null) {
      components = new Components();
      repository.setComponents(components);
    }
    return components.getComponentOrGroup();
  }

  private List<FieldType> getFieldList(Repository repository) {
    Fields fields = repository.getFields();
    if (fields == null) {
      fields = new Fields();
      repository.setFields(fields);
    }
    return fields.getField();
  }

  private File marshal(Repository repository) throws JAXBException, IOException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Repository.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    File file = File.createTempFile("REP", ".xml");
    marshaller.marshal(repository, file);
    return file;
  }

  private Repository unMarshal(File file) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Repository.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    return (Repository) unmarshaller.unmarshal(file);
  }

  @Override
  public List<Group> getGroups(String reposName, String version, Predicate<Group> search)
      throws RepositoryStoreException {
    Objects.requireNonNull(reposName, "Repository name missing");
    Objects.requireNonNull(version, "Repository version missing");
    final RepositoryKey key = new RepositoryKey(reposName, version);
    Repository repository = repositories.get(key);
    if (repository == null) {
      throw new ResourceNotFoundException(
          String.format("Repository with name=%s version=%s not found", reposName, version));
    }
    Predicate<Group> predicate = search != null ? search : new Predicate<Group>() {

      @Override
      public boolean test(Group t) {
        return true;
      }

    };
    List<ComponentType> components = getComponentList(repository);

    Function<ComponentType, GroupType> subclass = c -> (GroupType) c;

    return components.stream().filter(c -> c instanceof GroupType).map(c -> subclass.apply(c))
        .map(g -> OrchestraAPItoDOM.DOMToGroup(g)).filter(predicate).collect(Collectors.toList());
  }

}
