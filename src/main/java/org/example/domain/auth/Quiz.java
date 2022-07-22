package org.example.domain.auth;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.Domain;
import org.example.domain.role.LanguageEnum;
import org.example.domain.role.QuizLevel;
import org.hibernate.annotations.Where;
import org.hibernate.type.NumericBooleanConverter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Where(clause = "deleted = false")
public class Quiz extends Auditable implements Domain {
    @Column(nullable = false, unique = true)
    private String quizName;

    @Column(nullable = false)
    private Long subject_id;

    @Column(nullable = false)
    @Convert(converter = LevelStringConverter.class)
    private QuizLevel level = QuizLevel.EASY;


    @Column(nullable = false)
    @Convert(converter = LanguageEnumConvertor.class)
    private LanguageEnum language = LanguageEnum.UZ;

//    @Builder.Default
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean isCompleted = false;

    @Column(columnDefinition = "smallint default 0")
    private Integer quizCount;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = QuizQuestion.class)
    private List<QuizQuestion> quizQuestions;

    private Integer ball;
    @Builder(builderMethodName = "childBuilder")
    public Quiz(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Long createdBy, Long updatedBy, boolean deleted, String quizName, Long subject_id, QuizLevel level, LanguageEnum language, Boolean isCompleted, Integer quizCount, List<QuizQuestion> quizQuestions) {
        super(id, createdAt, updatedAt, createdBy, updatedBy, deleted);
        this.quizName = quizName;
        this.subject_id = subject_id;
        this.level = level;
        this.language = language;
        this.isCompleted = isCompleted;
        this.quizCount = quizCount;
        this.quizQuestions = quizQuestions;
    }

    static class LevelStringConverter implements AttributeConverter<QuizLevel, String> {
        @Override
        public String convertToDatabaseColumn(QuizLevel quizLevel) {
            return switch (quizLevel) {
                case EASY -> "easy";
                case MEDIUM -> "medium";
                case HARD -> "hard";
            };
        }

        @Override
        public QuizLevel convertToEntityAttribute(String s) {
            return switch (s) {
                case "easy" -> QuizLevel.EASY;
                case "medium" -> QuizLevel.MEDIUM;
                case "hard" -> QuizLevel.HARD;
                default -> null;
            };
        }
    }

    static class LanguageEnumConvertor implements AttributeConverter<LanguageEnum, String> {
        @Override
        public String convertToDatabaseColumn(LanguageEnum languageEnum) {
            return switch (languageEnum) {
                case UZ -> "uzbek";
                case RU -> "russian";
                case EN -> "english";
            };
        }

        @Override
        public LanguageEnum convertToEntityAttribute(String language) {
            return switch (language) {
                case "uzbek" -> LanguageEnum.UZ;
                case "russian" -> LanguageEnum.RU;
                case "english" -> LanguageEnum.EN;
                default -> null;
            };
        }
    }
}
