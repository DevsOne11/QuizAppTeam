package org.example.domain.auth;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.Domain;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Where(clause = "deleted = false")
public class Question extends Auditable implements Domain {

    @Column(nullable = false)
    private String question;

    @ManyToOne
    private Subject subject;

//    @Builder.Default
//    @Column(nullable = false)
    @Convert(converter = Quiz.LevelStringConverter.class)
    private QuizLevel level = QuizLevel.EASY;

//    @Builder.Default
//    @Column(nullable = false)
    @Convert(converter = Quiz.LanguageEnumConvertor.class)
    private LanguageEnum language = LanguageEnum.UZ;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;


    @Builder(builderMethodName = "childBuilder")
    public Question(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean deleted, String question, Subject subject, QuizLevel level, LanguageEnum language, List<Answer> answers) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted);
        this.question = question;
        this.subject = subject;
        this.level = level;
        this.language = language;
        this.answers = answers;
    }
}
