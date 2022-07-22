package org.example.service.auth;

import org.example.config.ApplicationContextHolder;
import org.example.criteria.auth.QuizCriteria;
import org.example.domain.auth.Quiz;
import org.example.dto.auth.quiz.QuizCreateDto;
import org.example.dto.auth.quiz.QuizUpdateDto;
import org.example.repository.auth.QuizRepository;
import org.example.repository.auth.UserRepository;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.example.service.Service;
import org.example.service.ServiceCRUD;

import java.util.List;
import java.util.Optional;

public class QuizService implements Service, ServiceCRUD<
        QuizCreateDto, QuizUpdateDto, Long, QuizCriteria, Quiz> {

    private static QuizService instance;
    private QuizRepository quizRepository = ApplicationContextHolder.getBean(QuizRepository.class);


    public static QuizService getInstance() {
        if (instance == null) {
            instance = new QuizService();
        }
        return instance;
    }


    @Override
    public ResponseEntity<Data<Boolean>> create(QuizCreateDto quizCreateDto) {
        Optional<Boolean> save = quizRepository.save(Quiz.childBuilder()
                .createdBy(-1L)
                .quizQuestions(quizCreateDto.getQuizQuestions())
                .language(quizCreateDto.getLanguageEnum())
                .level(quizCreateDto.getQuizLevel())
                .subject_id(quizCreateDto.getSubject_id())
                .quizName(quizCreateDto.getQuizName())
                .build());

        if (save.isPresent() && save.get().equals(true)){
            return new ResponseEntity<>(new Data<>(true));
        } else new ResponseEntity<>(new Data<>(Data.errorBuilder()
                .friendlyMessage("failed")
                .developerMessage("failed")
                .code(400)
                .build()));

        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(QuizUpdateDto quizUpdateDto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Quiz>> get(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<Quiz>>> getAll(QuizCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long aLong) {
        return null;
    }
}
