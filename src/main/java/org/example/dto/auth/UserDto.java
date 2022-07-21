package org.example.dto.auth;

import lombok.*;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.UserRole;
import org.example.dto.BaseEntity;
import org.example.dto.GenericEntity;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto extends GenericEntity implements BaseEntity {
    private String username;
    private String password;
    private UserRole role;
    private LanguageEnum language;

    @Builder
    public UserDto(String username, String password, UserRole role, LanguageEnum language) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.language = language;
    }
}
