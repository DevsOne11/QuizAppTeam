package org.example.domain.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Answer {


    private Long id;
    private Long question_id;
    private String answer;
    private Boolean isTrue;
    private Boolean isDeleted;
}
