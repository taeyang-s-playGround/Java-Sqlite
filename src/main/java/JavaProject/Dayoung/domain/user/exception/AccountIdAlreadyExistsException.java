package JavaProject.Dayoung.domain.user.exception;


import JavaProject.Dayoung.global.error.exception.DayoungException;
import JavaProject.Dayoung.global.error.exception.ErrorCode;

public class AccountIdAlreadyExistsException extends DayoungException {
    public static final DayoungException EXCEPTION = new AccountIdAlreadyExistsException();

    private AccountIdAlreadyExistsException() {
        super(ErrorCode.ACCOUNT_ID_ALREADY_EXISTS);
    }
}
