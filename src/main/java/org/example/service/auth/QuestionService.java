package org.example.service.auth;

import org.example.criteria.auth.QuestionCriteria;
import org.example.domain.auth.Question;
import org.example.dto.quiz.QuizCreateDto;
import org.example.dto.quiz.QuizUpdateDto;
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
public class QuestionService implements Service, ServiceCRUD<QuizCreateDto, QuizUpdateDto, Long, QuestionCriteria, Question> {
    @Override
    public ResponseEntity<Data<Boolean>> create(QuizCreateDto quizCreateDto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(QuizUpdateDto quizUpdateDto) {
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
