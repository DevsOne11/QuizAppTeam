package org.example.domain.auth;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.domain.Domain;
import org.hibernate.annotations.Where;
import org.hibernate.type.NumericBooleanConverter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Where(clause = "deleted = false")
public class QuizQuestion extends Auditable implements Domain {

    @ManyToOne
    private Quiz quiz;

    @ManyToMany
    private Question question;

    @Builder.Default
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isRight = false;

    @Builder.Default
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isDeleted = false;

    @Builder(builderMethodName = "childBuilder")
    public QuizQuestion(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean deleted, Quiz quiz, Question question, Boolean isRight, Boolean isDeleted) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted);
        this.quiz = quiz;
        this.question = question;
        this.isRight = isRight;
        this.isDeleted = isDeleted;
    }
}
