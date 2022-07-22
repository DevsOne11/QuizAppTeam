package org.example.dto.auth.quiz;

import lombok.Builder;
import org.example.domain.auth.QuizQuestion;
import org.example.domain.auth.Subject;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;
import org.example.dto.GenericEntity;

import java.util.List;

public class QuizUpdateDto extends GenericEntity {
    private String quizName;
    private QuizLevel quizLevel;

    @Builder
    public QuizUpdateDto(Long id, String quizName, QuizLevel quizLevel) {
        super(id);
        this.quizName = quizName;
        this.quizLevel = quizLevel;
    }
}
