package org.example.repository;

import org.example.domain.Domain;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface RepositoryCRUD <
        ID extends Serializable,
        AUTH extends Domain>{

    Optional<Boolean> save(AUTH domain);
    Optional<Boolean> update(AUTH domain);
    Optional<AUTH> get(ID id);
    Optional<List<AUTH>> getAll();
    Optional<Boolean> delete(ID id);

}
