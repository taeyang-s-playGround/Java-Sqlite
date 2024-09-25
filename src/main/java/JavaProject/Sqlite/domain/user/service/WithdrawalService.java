package JavaProject.Sqlite.domain.user.service;

import JavaProject.Sqlite.domain.user.entity.User;
import JavaProject.Sqlite.domain.user.facade.UserFacade;
import JavaProject.Sqlite.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void execute() {
        User user = userFacade.getCurrentUser();
        userRepository.delete(user);
    }
}
