package org.example.ui;

import org.example.utils.Reader;

public class AdminController {
    public static void controller(){
        switch (Reader.readLine("1 -> subject crud\n" +
                "2 -> user crud\n" +
                "3 -> History\n" +
                "o -> log out" +
                "q -> quit")){
            case "1" -> subjectCrud();
            case "2"  -> userCrud();
            case "3" -> history();
            case "o" -> Session.setSessionUser(null);
            case "q" -> System.exit(0);
            default -> controller();
        }
    }

    private static void history() {
        Application.quizGetAll();
    }

    private static void userCrud() {
        switch (Reader.readLine("1 -> user create\n" +
                "2 -> user update\n" +
                "3 -> user get\n" +
                "4 -> user delete\n" +
                "5 -> users get\n" +
                "o -> log out\n" +
                "q -> Quit")){
            case "1" -> Application.userCreate();
            case "2" -> Application.userUpdate();
            case "3" -> Application.userGet();
            case "4" -> Application.userDelete();
            case "5" -> Application.userGetAll();
            case "o" -> Session.setSessionUser(null);
            case "q" -> System.exit(0);
            default -> userCrud();
        }
    }

    private static void subjectCrud() {
        switch (Reader.readLine("1 -> subject create\n" +
                "2 -> subject update\n" +
                "3 -> subject get\n" +
                "4 -> subject delete\n" +
                "5 -> subjects get\n" +
                "o -> log out\n" +
                "q -> Quit")){
            case "1" -> Application.subjectCreate();
            case "2" -> Application.subjectUpdate();
            case "3" -> Application.subjectGet();
            case "4" -> Application.subjectDelete();
            case "5" -> Application.subjectGetAll();
            case "o" -> Session.setSessionUser(null);
            case "q" -> System.exit(0);
            default -> userCrud();
        }
    }
}
