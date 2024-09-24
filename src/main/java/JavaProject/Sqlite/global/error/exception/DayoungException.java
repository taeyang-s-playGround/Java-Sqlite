package JavaProject.Sqlite.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DayoungException extends RuntimeException {
    private final ErrorCode errorCode;
}
