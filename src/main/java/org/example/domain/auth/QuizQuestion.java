package org.example.domain.auth;

import jakarta.persistence.*;
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

    @OneToOne
    private Question question;

//    @Builder.Default
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isRight = false;

//    @Builder.Default

    @Builder(builderMethodName = "childBuilder")
    public QuizQuestion(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean deleted, Quiz quiz, Question question, Boolean isRight) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted);
        this.quiz = quiz;
        this.question = question;
        this.isRight = isRight;
    }
}
