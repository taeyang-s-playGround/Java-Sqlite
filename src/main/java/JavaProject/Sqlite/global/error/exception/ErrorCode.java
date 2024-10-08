package JavaProject.Sqlite.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    //jwt
    EXPIRED_TOKEN(403, "Expired token"),
    INVALID_TOKEN(403, "Invalid token"),

    //user
    USER_NOT_FOUND(404, "User not found"),
    USER_ALREADY_EXISTS(409, "User already exists"),
    PASSWORD_MISMATCH(401, "Password mismatch"),
    WRITER_MISMATCH(403, "Writer mismatch"),
    ACCOUNT_ID_ALREADY_EXISTS(409, "AccountId already exists"),

    //quiz
    QUIZ_NOT_FOUND(404, "Quiz not found"),
    CANNOT_UPDATE_QUIZ(401, "Cannot update quiz"),
    CANNOT_DELETE_QUIZ(401, "Cannot Delete Quiz Exception"),

    //admin
    CODE_MISMATCH(404, "Code mismatch"),
    NOT_ADMIN(403, "Not admin"),

    //petition
    PETITION_NOT_FOUND(404, "Petition not found"),

    //ban
    BAN_NOT_FOUND(404, "Ban not found"),
    BANNED_USER(403, "Banned User"),

    //image
    IMAGE_UPLOAD_FAIL(400, "Image upload fail"),
    WRONG_IMAGE(400, "Wrong Image"),

    //general
    BAD_REQUEST(400, "Bad request"),
    //잘못된 요청으로써 문법상 오류가 있어서 서버가 요청사항을 이해하지 못하는 경우
    INTERNAL_SERVER_ERROR(500, "Internal server error");
    //서버 내부 오류는 웹 서버가 요청사항을 수행할 수 없을 경우에 발생함

    private final int statusCode;
    private final String message;
}
