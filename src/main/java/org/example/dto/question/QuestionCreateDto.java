package org.example.dto.question;

import lombok.*;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;
import org.example.dto.BaseEntity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionCreateDto implements BaseEntity {
    private String question;
    private Long subject_id;
    private QuizLevel level;
    private LanguageEnum language;
}
