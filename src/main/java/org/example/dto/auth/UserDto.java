package org.example.dto.auth;

import lombok.*;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.UserRole;
import org.example.dto.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class UserDto implements BaseEntity {
    private String username;
    private String password;
    private UserRole role;
    private LanguageEnum language;
}
