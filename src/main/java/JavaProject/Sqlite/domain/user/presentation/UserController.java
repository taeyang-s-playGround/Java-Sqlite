package JavaProject.Sqlite.domain.user.presentation;

import JavaProject.Sqlite.domain.user.presentation.dto.request.ChangePasswordRequest;
import JavaProject.Sqlite.domain.user.presentation.dto.request.LoginRequest;
import JavaProject.Sqlite.domain.user.presentation.dto.request.SignupRequest;
import JavaProject.Sqlite.domain.user.service.*;
import JavaProject.Sqlite.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final SignupService signupService;
    private final LoginService loginService;
    private final ChangePasswordService changePasswordService;
    private final WithdrawalService withdrawalService;

    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return signupService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @PatchMapping("/password")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        changePasswordService.execute(request);
    }

    @DeleteMapping
    public void WithdrawalUser() {
        withdrawalService.execute();
    }
}
