package JavaProject.Sqlite.global.exception;


import JavaProject.Sqlite.global.error.exception.DayoungException;
import JavaProject.Sqlite.global.error.exception.ErrorCode;

public class InvalidTokenException extends DayoungException {
    public static final DayoungException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
