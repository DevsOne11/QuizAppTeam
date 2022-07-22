package org.example.service.auth;

import org.example.criteria.auth.AnswerCriteria;
import org.example.domain.auth.Answer;
import org.example.dto.auth.AnswerDto;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.example.service.Service;
import org.example.service.ServiceCRUD;

import java.awt.*;
import java.util.List;

/**
 * @Author :  Asliddin Ziyodullaev
 * @Date :  10:10   22/07/22
 * @Project :  QuizAppTeam
 */
public class AnswerService implements Service, ServiceCRUD<AnswerDto,Long, AnswerCriteria, Answer> {
    @Override
    public ResponseEntity<Data<Boolean>> create(AnswerDto create) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(AnswerDto update) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Answer>> get(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<Answer>>> getAll(AnswerCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long aLong) {
        return null;
    }
}
