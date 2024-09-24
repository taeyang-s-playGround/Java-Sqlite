package JavaProject.Sqlite.global.exception;


import JavaProject.Sqlite.global.error.exception.DayoungException;
import JavaProject.Sqlite.global.error.exception.ErrorCode;

public class ExpiredTokenException extends DayoungException {
    public static final DayoungException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
