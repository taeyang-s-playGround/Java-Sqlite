package JavaProject.Dayoung.domain.user.presentation;

import JavaProject.Dayoung.domain.user.presentation.dto.request.ChangePasswordRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.LoginRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.SignupRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import JavaProject.Dayoung.domain.user.presentation.dto.response.MyInfoResponse;
import JavaProject.Dayoung.domain.user.presentation.dto.response.RankListResponse;
import JavaProject.Dayoung.domain.user.service.*;
import JavaProject.Dayoung.global.security.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static JavaProject.Dayoung.global.config.cache.CacheName.USER;

@Validated
@CacheConfig(cacheNames = USER)
//@Valid는 기본적으로 컨트롤러에서만 동작하며 기본적으로 다른 계층에서는 검증이 되지 않는다
//[@Validated]
//입력 파라미터의 유효성 검증은 컨트롤러에서 최대한 처리하고 넘겨주는 것이 좋다.
//하지만 개발을 하다보면 불가피하게 다른 곳에서 파라미터를 검증해야 할 수 있다.
//여기서 사용해준 이유는 토큰 재발급 때문
@Tag(name = "유저", description = "유저 엔티티입니다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final SignupService signupService;
    private final LoginService loginService;
    private final ReissueService reissueService;
    private final UpdateUserInfoService updateUserInfoService;
    private final ChangePasswordService changePasswordService;
    private final MyInfoService myInfoService;
    private final GetScoreRankService getScoreRankService;
    private final WithdrawalService withdrawalService;

    @PostMapping("/signup")
    @Operation(summary = "유저 회원가입", description = "회원가입 할 때 사용하는 API")
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return signupService.execute(request);
    }

    @PostMapping("/login")
    @Operation(summary = "유저 로그인", description = "로그인 할 때 사용하는 API")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @PutMapping("/reissue")
    @Operation(summary = "유저 토큰 재발급", description = "토큰 재발급 할 때 사용하는 API")
    public TokenResponse reissue(@RequestHeader(name = "refresh-token") @NotNull String refreshToken) {
        return reissueService.execute(refreshToken);
    }

    @GetMapping("/info")
    @Cacheable
    @Operation(summary = "유저 정보 조회", description = "유저 정보 조회 할 때 사용하는 API")
    public MyInfoResponse getExecute() {
        return myInfoService.execute();
    }

    @PatchMapping
    @Operation(summary = "유저 정보 수정", description = "유저 정보 수정 할 때 사용하는 API")
    public void modifyInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }

    @PatchMapping("/password")
    @Operation(summary = "유저 비밀번호 변경", description = "유저 비밀번호 변경 할 때 사용하는 API")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        changePasswordService.execute(request);
    }

    @GetMapping("/rank")
    @Operation(summary = "유저 랭킹", description = "유저 랭킹 해주는 사용하는 API")
    public RankListResponse getScoreRank() {
        return getScoreRankService.execute();
    }

    @DeleteMapping
    @Operation(summary = "회원 탈퇴", description = "회원 탈퇴할 때 사용하는 API")
    public void WithdrawalUser() {
        withdrawalService.execute();
    }
}
