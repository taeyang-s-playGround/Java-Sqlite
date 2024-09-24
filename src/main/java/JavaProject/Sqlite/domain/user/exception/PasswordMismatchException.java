package JavaProject.Sqlite.domain.user.exception;


import JavaProject.Sqlite.global.error.exception.DayoungException;
import JavaProject.Sqlite.global.error.exception.ErrorCode;

public class PasswordMismatchException extends DayoungException {
    public static final DayoungException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
