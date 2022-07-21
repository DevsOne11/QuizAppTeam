package org.example.repository.auth;

import org.example.domain.auth.User;
import org.example.repository.Repository;
import org.example.repository.RepositoryCRUD;

import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository, RepositoryCRUD<
        Long, User> {

private UserRepository(){}
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }


    @Override
    public Optional<Boolean> save(User domain) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> update(User domain) {
        return Optional.empty();
    }

    @Override
    public Optional<User> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> delete(Long aLong) {
        return Optional.empty();
    }
}
