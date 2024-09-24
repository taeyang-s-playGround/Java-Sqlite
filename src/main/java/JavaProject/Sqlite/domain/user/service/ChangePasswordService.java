package JavaProject.Sqlite.domain.user.service;

import JavaProject.Sqlite.domain.user.entity.User;
import JavaProject.Sqlite.domain.user.exception.PasswordMismatchException;
import JavaProject.Sqlite.domain.user.facade.UserFacade;
import JavaProject.Sqlite.domain.user.presentation.dto.request.ChangePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChangePasswordService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;

    public void execute(ChangePasswordRequest changePasswordRequest) {
        User user = userFacade.getCurrentUser();

        if (!passwordEncoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        user.changePassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
    }
}
