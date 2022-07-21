package org.example.domain.auth;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.NumericBooleanConverter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@MappedSuperclass
public class Auditable {
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
}
