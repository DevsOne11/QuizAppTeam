package org.example.dto.auth;

import lombok.*;
import org.example.domain.auth.Answer;
import org.example.domain.auth.Subject;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;
import org.example.dto.BaseEntity;

import java.util.List;

/**
 * @author Shoniyazova Matlyuba
 * @project QuizAppTeam
 * @since 22/07/22  13:40 (Friday)
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class QuestionDto implements BaseEntity {
    private String question;
    private Subject subject;
    private QuizLevel level;
    private LanguageEnum language;
    private List<Answer> answers;
}
