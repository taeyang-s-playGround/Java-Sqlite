package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizListResponse {

    private final Long quizId;

    private final String title;

    private final String question;

    private final Area area;

    private final Level level;

    public QuizListResponse(Quiz quiz) {
        this.quizId = quiz.getId();
        this.title = quiz.getTitle();
        this.question = quiz.getQuestion();
        this.area = quiz.getArea();
        this.level = quiz.getLevel();
    }
}
