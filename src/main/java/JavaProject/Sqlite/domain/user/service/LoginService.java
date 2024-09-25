package JavaProject.Sqlite.domain.user.service;

import JavaProject.Sqlite.domain.user.entity.User;
import JavaProject.Sqlite.domain.user.exception.PasswordMismatchException;
import JavaProject.Sqlite.domain.user.exception.UserNotFoundException;
import JavaProject.Sqlite.domain.user.presentation.dto.request.LoginRequest;
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
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse execute(LoginRequest request) {

        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.createToken(user.getAccountId());
    }
}
