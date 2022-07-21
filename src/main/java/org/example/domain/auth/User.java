package org.example.domain.auth;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.*;
import org.example.domain.Domain;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.UserRole;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Where(clause = "deleted = false")
public class User extends Auditable implements Domain {

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Builder.Default
    @Column(nullable = false)
    @Convert(converter = UserRoleConverter.class)
    private UserRole role = UserRole.USER;
    @Builder.Default
    @Column(nullable = false)
    @Convert(converter = LanguageEnumConvertor.class)
    private LanguageEnum language = LanguageEnum.UZ;

    @Column(columnDefinition = "smallint default 1")
    private Integer isActive;

    @Column(columnDefinition = "smallint default 0")
    private Integer tryCount;


    @Builder(builderMethodName = "childBuilder")
    public User(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean deleted, String username, String password, UserRole role, LanguageEnum language, Integer isActive, Integer tryCount) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted);
        this.username = username;
        this.password = password;
        this.role = role;
        this.language = language;
        this.isActive = isActive;
        this.tryCount = tryCount;
    }


    private static class UserRoleConverter implements AttributeConverter<UserRole, String> {

        @Override
        public String convertToDatabaseColumn(UserRole role) {
            return switch (role) {
                case USER -> "user";
                case ADMIN -> "admin";
                case TEACHER -> "teacher";
            };
        }

        @Override
        public UserRole convertToEntityAttribute(String role) {

            return switch (role) {
                case "user" -> UserRole.USER;
                case "admin" -> UserRole.ADMIN;
                case "teacher" -> UserRole.TEACHER;
                default -> null;
            };
        }
    }

    private static class LanguageEnumConvertor implements AttributeConverter<LanguageEnum, String> {
        @Override
        public String convertToDatabaseColumn(LanguageEnum languageEnum) {
            return switch (languageEnum) {
                case UZ -> "uzbek";
                case RU -> "russian";
                case EN -> "english";
            };
        }

        @Override
        public LanguageEnum convertToEntityAttribute(String language) {
            return switch (language) {
                case "uzbek" -> LanguageEnum.UZ;
                case "russian" -> LanguageEnum.RU;
                case "english" -> LanguageEnum.EN;
                default -> null;
            };
        }
    }
}