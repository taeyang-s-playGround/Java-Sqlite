package JavaProject.Sqlite.domain.user.service;

import JavaProject.Sqlite.domain.user.entity.User;
import JavaProject.Sqlite.domain.user.entity.type.Role;
import JavaProject.Sqlite.domain.user.exception.UserAlreadyExistException;
import JavaProject.Sqlite.domain.user.presentation.dto.request.SignupRequest;
import JavaProject.Sqlite.domain.user.repository.UserRepository;
import JavaProject.Sqlite.global.security.TokenResponse;
import JavaProject.Sqlite.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(SignupRequest signupRequest) {

        if (userRepository.existsByAccountId(signupRequest.getAccountId())) {
            throw UserAlreadyExistException.EXCEPTION;
        }

        String password = passwordEncoder.encode(signupRequest.getPassword());

        userRepository.save(
            User.builder()
                .accountId(signupRequest.getAccountId())
                .email(signupRequest.getEmail())
                .password(password)
                .name(signupRequest.getName())
                .role(Role.STUDENT)
                .build()
        );


        return jwtTokenProvider.createToken(signupRequest.getAccountId());
    }
}
