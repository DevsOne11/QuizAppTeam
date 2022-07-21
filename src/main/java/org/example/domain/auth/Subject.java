package org.example.domain.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.example.domain.Domain;
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
public class Subject extends Auditable implements Domain {

    @Builder(builderMethodName = "childBuilder")
    public Subject(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean deleted, String code, String name, String description, List<Question> questions) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted);
        this.code = code;
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    @Column(unique = true, nullable = false)
    private String code;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "subject")
    private List<Question> questions;
}
