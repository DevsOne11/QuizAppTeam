package org.example.dto.auth;

import lombok.*;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.UserRole;
import org.example.dto.BaseEntity;
import org.example.dto.GenericEntity;

@Getter
@Setter
@ToString
public class UserDto extends GenericEntity {
    private String username;
    private String password;
    private UserRole role;
    private LanguageEnum language;

    @Builder
    public UserDto(Long id, String username, String password, UserRole role, LanguageEnum language) {
        super(id);
        this.username = username;
        this.password = password;
        this.role = role;
        this.language = language;
    }
}
