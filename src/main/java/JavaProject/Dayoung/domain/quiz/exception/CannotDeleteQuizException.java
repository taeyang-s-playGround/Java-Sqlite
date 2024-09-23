package JavaProject.Dayoung.domain.quiz.exception;

import JavaProject.Dayoung.global.error.exception.DayoungException;
import JavaProject.Dayoung.global.error.exception.ErrorCode;

public class CannotDeleteQuizException extends DayoungException {

    public static final DayoungException EXCEPTION = new CannotDeleteQuizException();

    private CannotDeleteQuizException() {
        super(ErrorCode.CANNOT_DELETE_QUIZ);
    }
}
