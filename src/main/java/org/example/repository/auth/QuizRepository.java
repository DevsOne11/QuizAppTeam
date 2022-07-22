package org.example.repository.auth;

import org.example.config.HibernateConfigurer;
import org.example.domain.auth.Quiz;
import org.example.repository.Repository;
import org.example.repository.RepositoryCRUD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class QuizRepository implements Repository, RepositoryCRUD<
        Long, Quiz> {

    private static QuizRepository instance;

    public static QuizRepository getInstance() {
        if (instance == null) {
            instance = new QuizRepository();
        }
        return instance;
    }
    private final SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
    @Override
    public Optional<Boolean> save(Quiz domain) {
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
    public Optional<Boolean> update(Quiz domain) {
        return Optional.empty();
    }

    @Override
    public Optional<Quiz> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Quiz>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> delete(Long aLong) {
        return Optional.empty();
    }
}
