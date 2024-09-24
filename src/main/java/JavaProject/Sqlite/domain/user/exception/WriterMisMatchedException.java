package JavaProject.Sqlite.domain.user.exception;

import JavaProject.Sqlite.global.error.exception.DayoungException;
import JavaProject.Sqlite.global.error.exception.ErrorCode;

public class WriterMisMatchedException extends DayoungException {
    public static final DayoungException EXCEPTION = new WriterMisMatchedException();

    private WriterMisMatchedException() {
        super(ErrorCode.WRITER_MISMATCH);
    }
}
