package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.area.repository.AreaRepository;
import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.entity.type.Role;
import JavaProject.Dayoung.domain.user.exception.UserAlreadyExistException;
import JavaProject.Dayoung.domain.user.presentation.dto.request.SignupRequest;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import JavaProject.Dayoung.global.security.TokenResponse;
import JavaProject.Dayoung.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignupService {

    private final UserRepository userRepository;
    private final AreaRepository areaRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(SignupRequest signupRequest) {

        if (userRepository.existsByAccountId(signupRequest.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        String password = passwordEncoder.encode(signupRequest.getPassword());

        if (signupRequest.getAreaId() != null) {
            Area area = areaRepository.findAreaById(signupRequest.getAreaId());

            userRepository.save(
                User.builder()
                    .accountId(signupRequest.getAccountId())
                    .email(signupRequest.getEmail())
                    .password(password)
                    .name(signupRequest.getName())
                    .introduction(signupRequest.getIntroduction())
                    .area(area)
                    .role(Role.STUDENT)
                    .score(0)
                    .build()
            );
        } else {
            userRepository.save(
                User.builder()
                    .accountId(signupRequest.getAccountId())
                    .email(signupRequest.getEmail())
                    .password(password)
                    .name(signupRequest.getName())
                    .introduction(signupRequest.getIntroduction())
                    .area(null)
                    .role(Role.STUDENT)
                    .score(0)
                    .build()
            );
        }

        return jwtTokenProvider.createToken(signupRequest.getAccountId());
    }
}
