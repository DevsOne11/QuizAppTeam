package org.example.dto.question;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;
import org.example.dto.GenericEntity;



@Setter
public class QuestionUpdateDto extends GenericEntity {
    private String question;
    private Long subject_id;
    private QuizLevel level;
    private LanguageEnum language;


    @Builder
    public QuestionUpdateDto(Long id, String question, Long subject_id, QuizLevel level, LanguageEnum language) {
        super(id);
        this.question = question;
        this.subject_id = subject_id;
        this.level = level;
        this.language = language;
    }
}
