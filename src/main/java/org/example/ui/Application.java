package org.example.ui;

import org.example.config.ApplicationContextHolder;
import org.example.criteria.auth.AnswerCriteria;
import org.example.criteria.auth.QuizCriteria;
import org.example.criteria.auth.UserCriteria;
import org.example.domain.auth.Answer;
import org.example.domain.auth.AuthUser;
import org.example.domain.auth.Quiz;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;
import org.example.domain.role.UserRole;
import org.example.dto.answer.AnswerCreateDto;
import org.example.dto.answer.AnswerUpdateDto;
import org.example.dto.auth.UserCreateDto;
import org.example.dto.auth.UserUpdateDto;
import org.example.dto.quiz.QuizCreateDto;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.example.service.auth.AnswerService;
import org.example.service.auth.QuizService;
import org.example.service.auth.UserService;
import org.example.utils.Writer;
import org.hibernate.boot.model.source.internal.hbm.AbstractPluralAssociationElementSourceImpl;

import javax.naming.NamingEnumeration;
import java.util.List;

public class Application {
    private static QuizService quizService = ApplicationContextHolder.getBean(QuizService.class);
    private static UserService userService = ApplicationContextHolder.getBean(UserService.class);
    private static AnswerService answerService = ApplicationContextHolder.getBean(AnswerService.class);

    public static void main(String[] args) {
        /////// user ///////
//        userCreate();
//        userUpdate();
//        userGet();
//        userDelete();
//        userGetAll();

        ///////// quiz //////////
//        quizCreate();
//        quizGet();
//        quizDelete();
//        quizGetAll();

        /////////// answer //////////

//        answerCreate();
//        answerUpdate();
//        answerGet();
//        answerGetAll();
//        answerDelete();


    }

    private static void quizGetAll() {
        ResponseEntity<Data<List<Quiz>>> all = quizService.getAll(new QuizCriteria());
        if (all.getData().getIsOK().equals(true)) {
            Writer.println(all.getData().getBody());
        } else Writer.println(all.getData().getErrorDto().getFriendlyMessage());
    }

    private static void quizDelete() {
        ResponseEntity<Data<Boolean>> delete = quizService.delete(1L);
        if (delete.getData().getIsOK().equals(true)) {
            Writer.println(delete.getData().getBody());
        } else Writer.println(delete.getData().getErrorDto().getFriendlyMessage());
    }

    private static void quizGet() {
        ResponseEntity<Data<Quiz>> dataResponseEntity = quizService.get(1L);
        if (dataResponseEntity.getData().getIsOK().equals(true)) {
            Writer.println(dataResponseEntity.getData().getBody());
        } else Writer.println(dataResponseEntity.getData().getErrorDto().getFriendlyMessage());
    }

    private static void userGetAll() {
        ResponseEntity<Data<List<AuthUser>>> all = userService.getAll(new UserCriteria());
        if (all.getData().getIsOK().equals(true)) {
            Writer.println(all.getData().getBody());
        } else Writer.println(all.getData().getErrorDto().getFriendlyMessage());
    }

    private static void userDelete() {
        ResponseEntity<Data<Boolean>> delete = userService.delete(1L);
        if (delete.getData().getIsOK().equals(true)) {
            Writer.println(delete.getData().getBody());
        } else Writer.println(delete.getData().getErrorDto().getFriendlyMessage());
    }

    private static void answerDelete() {
        ResponseEntity<Data<Boolean>> delete = answerService.delete(1L);
        if (delete.getData().getIsOK().equals(true)) {
            Writer.println(delete.getData().getBody());
        } else Writer.println(delete.getData().getErrorDto().getFriendlyMessage());
    }

    private static void answerGetAll() {
        ResponseEntity<Data<List<Answer>>> all = answerService.getAll(new AnswerCriteria());
        if (all.getData().getIsOK().equals(true)) {
            Writer.println(all.getData().getBody());
        } else Writer.println(all.getData().getErrorDto().getFriendlyMessage());
    }

    private static void answerGet() {
        ResponseEntity<Data<Answer>> dataResponseEntity = answerService.get(1L);
        if (dataResponseEntity.getData().getIsOK().equals(true)) {
            Writer.println(dataResponseEntity.getData().getBody());
        } else Writer.println(dataResponseEntity.getData().getErrorDto().getFriendlyMessage());
    }

    private static void answerUpdate() {
        ResponseEntity<Data<Boolean>> salom = answerService.update(AnswerUpdateDto.builder()
                .answer("saloom")
                .isTrue(false)
                .updated_by(1L)
                .id(1L)
                .build());
        if (salom.getData().getIsOK().equals(true)) {
            Writer.println(salom.getData().getBody());
        } else Writer.println(salom.getData().getErrorDto().getFriendlyMessage());
    }

    private static void answerCreate() {
        ResponseEntity<Data<Boolean>> ans = answerService.create(AnswerCreateDto.builder()
                .created_by(1L)
                .isTrue(true)
                .answer("meni yoshim nechida")
                .build());
        if (ans.getData().getIsOK().equals(true)) {
            Writer.println(ans.getData().getBody());
        } else Writer.println(ans.getData().getErrorDto().getFriendlyMessage());
    }

    private static void userGet() {
        ResponseEntity<Data<AuthUser>> dataResponseEntity = userService.get(1L);
        if (dataResponseEntity.getData().getIsOK().equals(true)) {
            Writer.println(dataResponseEntity.getData().getBody());
        } else Writer.println(dataResponseEntity.getData().getErrorDto().getFriendlyMessage());
    }

    private static void userUpdate() {
        ResponseEntity<Data<Boolean>> name = userService.update(UserUpdateDto.childBuilder()
                .id(1L)
                .username("name")
                .language(LanguageEnum.RU)
                .password("234")
                .build());
        if (name.getData().getIsOK().equals(true)) {
            Writer.println(name.getData().getBody());
        } else Writer.println(name.getData().getErrorDto().getFriendlyMessage());
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
                .username("lll")
                .role(UserRole.ADMIN)
                .build());

        if (john.getData().getIsOK().equals(true)) {
            Writer.println(true);
        } else Writer.println(john.getData().getErrorDto().getFriendlyMessage());
    }
}
