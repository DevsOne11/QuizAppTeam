package org.example.service.auth;

import org.example.criteria.auth.UserCriteria;
import org.example.domain.auth.User;
import org.example.dto.auth.UserCreateDto;
import org.example.dto.auth.UserDto;
import org.example.dto.auth.UserUpdateDto;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.example.service.Service;
import org.example.service.ServiceCRUD;

import java.util.List;

public class UserService implements Service, ServiceCRUD<
        UserCreateDto, UserUpdateDto, Long, UserCriteria, User> {

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
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(UserUpdateDto userUpdateDto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<User>> get(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Data<List<User>>> getAll(UserCriteria criteria) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long aLong) {
        return null;
    }
}
