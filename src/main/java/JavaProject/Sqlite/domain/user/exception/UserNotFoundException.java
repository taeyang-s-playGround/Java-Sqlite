package JavaProject.Sqlite.domain.user.exception;


import JavaProject.Sqlite.global.error.exception.DayoungException;
import JavaProject.Sqlite.global.error.exception.ErrorCode;

public class UserNotFoundException extends DayoungException {
    public static final DayoungException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
