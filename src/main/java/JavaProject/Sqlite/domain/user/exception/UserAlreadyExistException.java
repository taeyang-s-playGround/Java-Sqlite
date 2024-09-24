package JavaProject.Sqlite.domain.user.exception;


import JavaProject.Sqlite.global.error.exception.DayoungException;
import JavaProject.Sqlite.global.error.exception.ErrorCode;

public class UserAlreadyExistException extends DayoungException {
    public static final DayoungException EXCEPTION = new UserAlreadyExistException();

    private UserAlreadyExistException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
