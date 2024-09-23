package JavaProject.Dayoung.domain.quiz.exception;

import JavaProject.Dayoung.global.error.exception.DayoungException;
import JavaProject.Dayoung.global.error.exception.ErrorCode;

public class QuizNotFoundException extends DayoungException {

    public static final DayoungException EXCEPTION = new QuizNotFoundException();

    private QuizNotFoundException() {
        super(ErrorCode.QUIZ_NOT_FOUND);
    }
}
