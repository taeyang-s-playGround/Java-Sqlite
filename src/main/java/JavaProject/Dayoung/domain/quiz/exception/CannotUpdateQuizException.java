package JavaProject.Dayoung.domain.quiz.exception;

import JavaProject.Dayoung.global.error.exception.DayoungException;
import JavaProject.Dayoung.global.error.exception.ErrorCode;

public class CannotUpdateQuizException extends DayoungException {

    public static final DayoungException EXCEPTION = new CannotUpdateQuizException();

    private CannotUpdateQuizException() {
        super(ErrorCode.CANNOT_UPDATE_QUIZ);
    }
}
