package org.example.repository.auth;

import org.example.domain.auth.Answer;
import org.example.repository.Repository;
import org.example.repository.RepositoryCRUD;

import java.util.List;
import java.util.Optional;

/**
 * @Author :  Asliddin Ziyodullaev
 * @Date :  10:09   22/07/22
 * @Project :  QuizAppTeam
 */
public class AnswerRepository implements Repository , RepositoryCRUD<Long,Answer> {


    private AnswerRepository() {
    }

    private static AnswerRepository instance;

    public static AnswerRepository getInstance() {
        if (instance == null) {
            instance = new AnswerRepository();
        }
        return instance;
    }



    @Override
    public Optional<Boolean> save(Answer domain) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> update(Answer domain) {
        return Optional.empty();
    }

    @Override
    public Optional<Answer> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Answer>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> delete(Long aLong) {
        return Optional.empty();
    }
}
