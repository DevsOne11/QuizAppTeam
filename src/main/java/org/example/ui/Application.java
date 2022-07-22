package org.example.ui;

import org.example.config.ApplicationContextHolder;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;
import org.example.domain.role.UserRole;
import org.example.dto.auth.UserCreateDto;
import org.example.dto.auth.quiz.QuizCreateDto;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.example.service.auth.QuizService;
import org.example.service.auth.UserService;
import org.example.utils.Writer;

import java.awt.desktop.AppReopenedListener;
import java.lang.ref.WeakReference;

public class Application {
    private static QuizService quizService = ApplicationContextHolder.getBean(QuizService.class);
    private static UserService userService = ApplicationContextHolder.getBean(UserService.class);
    public static void main(String[] args) {
//        userCreate();
        quizCreate();
    }

    private static void quizCreate() {
        ResponseEntity<Data<Boolean>> quiz1 = quizService.create(QuizCreateDto.builder()
                .quizCount(3)
                .quizLevel(QuizLevel.HARD)
                .quizName("quiz1")
                .subject_id(-1L)
                .languageEnum(LanguageEnum.UZ)
                .quizQuestions(null)
                .build());
        if (quiz1.getData().getIsOK()) {
            Writer.println(quiz1.getData().getBody());
        } else Writer.println(quiz1.getData().getErrorDto().getFriendlyMessage());
    }

    private static void userCreate() {
        ResponseEntity<Data<Boolean>> john = userService.create(UserCreateDto.builder()
                .language(LanguageEnum.UZ)
                .password("123")
                .username("john")
                .role(UserRole.ADMIN)
                .build());

        if (john.getData().getIsOK()) {
            Writer.println(john.getData().getBody());
        } else Writer.println(john.getData().getErrorDto().getFriendlyMessage());
    }
}
