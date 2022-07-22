package org.example.service.auth;

import org.example.criteria.auth.QuestionCriteria;
import org.example.domain.auth.Question;
import org.example.dto.auth.QuestionDto;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.example.service.Service;
import org.example.service.ServiceCRUD;

import java.util.List;

/**
 * @author Shoniyazova Matlyuba
 * @project QuizAppTeam
 * @since 22/07/22  13:48 (Friday)
 */
public class QuestionService implements Service, ServiceCRUD<QuestionDto,Long, QuestionCriteria, Question> {
    @Override
    public ResponseEntity<Data<Boolean>> create(QuestionDto create) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(QuestionDto update) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Question>> get(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<Question>>> getAll(QuestionCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long aLong) {
        return null;
    }
}
