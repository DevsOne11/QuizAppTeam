package org.example.domain.auth;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.Domain;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;
import org.hibernate.type.NumericBooleanConverter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Where(clause = "deleted = 0")
public class QuizQuestion implements Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp default now()")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false, name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;


    @Builder.Default
    @Convert(converter = NumericBooleanConverter.class)
    private boolean deleted = false;
    @ManyToOne
    private Quiz quiz;

    @OneToOne
    private Question question;

    @Builder.Default
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isRight = false;

//    @Builder.Default

}
