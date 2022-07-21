package org.example.domain.auth;


import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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
public class Answer extends Auditable implements Domain {
    @ManyToOne
    private Question question;

    @Column(nullable = false)
    private String answer;

    @Builder.Default
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isTrue = false;


    @Builder(builderMethodName = "childBuilder")
    public Answer(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean deleted, Question question, String answer, Boolean isTrue) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted);
        this.question = question;
        this.answer = answer;
        this.isTrue = isTrue;
    }
}
