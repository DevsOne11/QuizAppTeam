package org.example.repository.auth;

import org.example.domain.auth.Question;
import org.example.repository.Repository;
import org.example.repository.RepositoryCRUD;

import java.util.List;
import java.util.Optional;

/**
 * @author Shoniyazova Matlyuba
 * @project QuizAppTeam
 * @since 22/07/22  13:45 (Friday)
 */
public class QuestionRepository  implements Repository, RepositoryCRUD<Long, Question> {
    private QuestionRepository() {
    }

    private static QuestionRepository instance;

    public static QuestionRepository getInstance() {
        if (instance == null) {
            instance = new QuestionRepository();
        }
        return instance;
    }


    @Override
    public Optional<Boolean> save(Question domain) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> update(Question domain) {
        return Optional.empty();
    }

    @Override
    public Optional<Question> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Question>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> delete(Long aLong) {
        return Optional.empty();
    }
}
