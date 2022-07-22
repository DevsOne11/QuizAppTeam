package org.example.config;

import org.example.repository.auth.QuizRepository;
import org.example.repository.auth.UserRepository;
import org.example.service.auth.QuizService;
import org.example.service.auth.UserService;

public class ApplicationContextHolder {

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        return switch (beanName) {
            case "UserService" -> (T) UserService.getInstance();
            case "UserRepository" -> (T) UserRepository.getInstance();
            case "QuizService" -> (T) QuizService.getInstance();
            case "QuizRepository" -> (T) QuizRepository.getInstance();

            default -> throw new RuntimeException("Bean Not Found");
        };
    }

    public static <T> T getBean(Class<T> clazz) {
        String beanName = clazz.getSimpleName();
        return getBean(beanName);
    }

}
