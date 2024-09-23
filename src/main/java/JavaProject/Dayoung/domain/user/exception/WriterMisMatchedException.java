package JavaProject.Dayoung.domain.user.exception;

import JavaProject.Dayoung.global.error.exception.DayoungException;
import JavaProject.Dayoung.global.error.exception.ErrorCode;

public class WriterMisMatchedException extends DayoungException {
    public static final DayoungException EXCEPTION = new WriterMisMatchedException();

    private WriterMisMatchedException() {
        super(ErrorCode.WRITER_MISMATCH);
    }
}
