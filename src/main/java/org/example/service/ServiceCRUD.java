package org.example.service;

import org.example.criteria.Criteria;
import org.example.domain.Domain;
import org.example.dto.BaseEntity;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.hibernate.sql.Update;

import java.io.Serializable;
import java.util.List;

public interface ServiceCRUD <
        CREATE extends BaseEntity,
        UPDATE extends BaseEntity,
        ID extends Serializable,
        CRITERIA extends Criteria,
        AUTH extends Domain>{
    ResponseEntity<Data<Boolean>> create(CREATE create);
    ResponseEntity<Data<Boolean>> update(UPDATE update);
    ResponseEntity<Data<AUTH>> get(ID id);
    ResponseEntity<Data<List<AUTH>>> getAll(CRITERIA criteria);
    ResponseEntity<Data<Boolean>> delete(ID id);
}
