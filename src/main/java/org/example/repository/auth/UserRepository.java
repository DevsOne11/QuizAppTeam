package org.example.repository.auth;

import org.example.config.HibernateConfigurer;
import org.example.domain.auth.AuthUser;
import org.example.repository.Repository;
import org.example.repository.RepositoryCRUD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository, RepositoryCRUD<
        Long, AuthUser> {

   private SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();

    private UserRepository() {
    }

    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }


    @Override
    public Optional<Boolean> save(AuthUser domain) {
       try{
           Session session = sessionFactory.openSession();
           session.getTransaction().begin();
           session.persist(domain);
           session.getTransaction().commit();
           session.close();
           return Optional.of(true);
       } catch (Exception e){
         e.printStackTrace();
       }
       return Optional.empty();
    }

    @Override
    public Optional<Boolean> update(AuthUser domain) {
        try {

            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.update(domain);
            session.getTransaction().commit();
            session.close();
            return Optional.of(true);
        } catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<AuthUser> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<AuthUser>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> delete(Long aLong) {
        return Optional.empty();
    }
}
