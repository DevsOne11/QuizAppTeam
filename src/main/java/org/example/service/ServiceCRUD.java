package org.example.service;

import org.example.criteria.Criteria;
import org.example.domain.Domain;
import org.example.dto.BaseEntity;
import org.example.response.Data;
import org.example.response.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface ServiceCRUD <
        DTO extends BaseEntity,
        ID extends Serializable,
        CRITERIA extends Criteria,
        AUTH extends Domain>{
    ResponseEntity<Data<Boolean>> create(DTO create);
    ResponseEntity<Data<Boolean>> update(DTO update);
    ResponseEntity<Data<AUTH>> get(ID id);
    ResponseEntity<Data<List<AUTH>>> getAll(CRITERIA criteria);
    ResponseEntity<Data<Boolean>> delete(ID id);
}
