package org.example.ui;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.role.UserRole;
import org.example.dto.auth.UserDto;

import java.util.Objects;

public class Session {
    public static SessionUser sessionUser;


    public static void setSessionUser(UserDto userDto) {
        if (Objects.isNull(userDto))
            sessionUser = null;
        else sessionUser = new SessionUser(userDto);
    }

    @Getter
    @Setter
    public static class SessionUser {

        private Long id;
        private String username;

        public UserRole role;

        public SessionUser(UserDto session) {

            this.id = session.id;
            this.username = session.getUsername();
            this.role = session.getRole();
        }

    }
}
