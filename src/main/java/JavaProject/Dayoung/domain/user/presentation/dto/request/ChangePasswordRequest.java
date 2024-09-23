package JavaProject.Dayoung.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class ChangePasswordRequest {

    @NotNull
    private String oldPassword;

    @NotNull(message = "message = \"8자 이상 20자 미만으로 새비밀번호를 입력해 주세요")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!#$%&'()*+,./:;<=>?@＼^_`{|}~])[a-zA-Z0-9!#$%&'()*+,./:;<=>?@＼^_`{|}~]{8,60}$")
    private String newPassword;
}
