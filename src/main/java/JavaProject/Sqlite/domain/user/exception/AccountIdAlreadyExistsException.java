package JavaProject.Sqlite.domain.user.exception;


import JavaProject.Sqlite.global.error.exception.DayoungException;
import JavaProject.Sqlite.global.error.exception.ErrorCode;

public class AccountIdAlreadyExistsException extends DayoungException {
    public static final DayoungException EXCEPTION = new AccountIdAlreadyExistsException();

    private AccountIdAlreadyExistsException() {
        super(ErrorCode.ACCOUNT_ID_ALREADY_EXISTS);
    }
}
