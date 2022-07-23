package org.example.dto.quiz;

import lombok.Builder;
import org.example.domain.role.QuizLevel;
import org.example.dto.GenericEntity;

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
