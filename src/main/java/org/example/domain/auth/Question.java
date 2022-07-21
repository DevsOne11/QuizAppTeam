package org.example.domain.auth;

import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;

public class Question {
    private Long id;
    private String question;
    private Long subject_id;
    private QuizLevel level;
    private LanguageEnum language;
    private Boolean isDeleted;
}
