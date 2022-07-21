package org.example.domain.auth;

import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;

public class Quiz {
    private Long id;
    private String quiz_name;
    private Long subject_id;
    private Long user_id;
    private QuizLevel level;
    private Boolean isDeleted;
    private LanguageEnum language;
    private Boolean isCompleted;
    private Integer quizCount;


}
