package org.example.ui;

import org.example.config.ApplicationContextHolder;
import org.example.domain.auth.AuthUser;
import org.example.dto.auth.UserUpdateDto;
import org.example.response.Data;
import org.example.response.ResponseEntity;
import org.example.service.auth.UserService;
import org.example.utils.Reader;
import org.example.utils.Writer;

public class TeacherController {
    private static final UserService userService = ApplicationContextHolder.getBean(UserService.class);

    public static void controller() {
        switch (Reader.readLine("1 -> question crud\n" +
                "2 -> options\n" +
                "3 -> History (all quizzes)" +
                "\n" +
                "o -> log out" +
                "q -> quit")) {
            case "1" -> questionCrud();
            case "2" -> optionsCrud();
            case "3" -> history();
            case "o" -> Session.setSessionUser(null);
            case "q" -> System.exit(0);
            default -> controller();
        }
    }

    private static void history() {
        Application.quizGetAll();
    }

    private static void optionsCrud() {
        switch (Reader.readLine("1 -> update\n" +
                "2 -> get\n" +
                "3 -> delete)" +
                "\n" +
                "o -> log out" +
                "q -> quit")) {
            case "1" -> update_();
            case "2" -> get();
            case "3" -> delete();
            case "o" -> Session.setSessionUser(null);
            case "q" -> System.exit(0);
            default -> optionsCrud();
        }
    }

    private static void questionCrud() {
        Application.questionCreate();
    }


    public static void update_() {
        try {
            userService.update(UserUpdateDto.childBuilder()
                    .username(Reader.readLine("username: "))
                    .password(Reader.readLine("password: "))
                    .language(Application.chooseLanguage())
                    .id(Session.sessionUser.getId())
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void get() {
        try {
            ResponseEntity<Data<AuthUser>> dataResponseEntity = userService.get(Session.sessionUser.getId());

            if (dataResponseEntity.getData().getIsOK().equals(true)) {
                Writer.println(dataResponseEntity.getData().getBody());
            } else Writer.println(dataResponseEntity.getData().getErrorDto().getFriendlyMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete() {
       try {
           ResponseEntity<Data<Boolean>> delete = userService.delete(Session.sessionUser.getId());

           if (delete.getData().getIsOK().equals(true)) {
               Writer.println(delete.getData().getBody());
           } else Writer.println(delete.getData().getErrorDto().getFriendlyMessage());
       } catch (Exception e){
           e.printStackTrace();
       }
    }
}