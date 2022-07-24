package org.example.ui;

import org.example.utils.Reader;

public class UserController {
    public static void controller(){
        switch (Reader.readLine("1 -> solve quiz\n" +
                "=================================\n" +
                "2 -> update\n" +
                "3 -> get\n" +
                "4 -> delete\n" +
                "5 -> log out\n" +
                "q -> Quit")){
            case "1" -> solveQuiz();
            case "2" -> TeacherController.update_();
            case "3" -> TeacherController.get();
            case "4" -> TeacherController.delete();
            case "5" -> Session.setSessionUser(null);
            case "q" -> {return;}
        }
    }

    private static void solveQuiz() {
        Application.questionCreate();
        //////
    }
}
