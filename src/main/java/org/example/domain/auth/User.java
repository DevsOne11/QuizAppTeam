package org.example.domain.auth;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.UserRole;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Builder.Default
//    @Convert(converter = )
    private UserRole role = UserRole.USER;
    private LanguageEnum language = LanguageEnum.UZ;
    @Column(columnDefinition = "")
    private Boolean isDeleted;
    private Integer isActive;
    private Integer tryCount;
}
