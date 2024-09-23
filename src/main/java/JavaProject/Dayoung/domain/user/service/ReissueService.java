package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.global.security.TokenResponse;
import JavaProject.Dayoung.global.security.jwt.JwtReissueUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReissueService {

    private final JwtReissueUtil jwtReissueUtil;

    public TokenResponse execute(String refreshToken) {
        return jwtReissueUtil.reissue(refreshToken);
    }
}
