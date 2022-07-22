package org.example.service.auth;

import org.example.config.ApplicationContextHolder;
import org.example.criteria.auth.UserCriteria;
import org.example.domain.auth.AuthUser;
import org.example.dto.auth.UserCreateDto;
import org.example.dto.auth.UserUpdateDto;
import org.example.repository.auth.UserRepository;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.example.service.Service;
import org.example.service.ServiceCRUD;

import java.util.List;
import java.util.Optional;

public class UserService implements Service, ServiceCRUD<
        UserCreateDto, UserUpdateDto, Long, UserCriteria, AuthUser> {

    private UserRepository userRepository = ApplicationContextHolder.getBean(UserRepository.class);

    private UserService(){}
    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }


    @Override
    public ResponseEntity<Data<Boolean>> create(UserCreateDto userCreateDto) {
        try {
            Optional<Boolean> save = userRepository.save(AuthUser.childBuilder()
                    .username(userCreateDto.getUsername())
                    .password(userCreateDto.getPassword())
                    .createdBy(-1l)
                    .role(userCreateDto.getRole())
                    .language(userCreateDto.getLanguage())
                    .build());

            if (save.isPresent() && save.get().equals(true)) {
                new ResponseEntity<>(new Data<>(true));
            } else new ResponseEntity<>(new Data<>(Data.errorBuilder()
                    .code(400)
                    .developerMessage("failed")
                    .friendlyMessage("failed")
                    .build()));
        } catch (Exception e){
            return new ResponseEntity<>(new Data<>(Data.errorBuilder()
                    .friendlyMessage(e.getMessage())
                    .build()), 400);
        }
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(UserUpdateDto userUpdateDto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<AuthUser>> get(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<AuthUser>>> getAll(UserCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long aLong) {
        return null;
    }
}
