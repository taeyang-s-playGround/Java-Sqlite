package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import JavaProject.Dayoung.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class WithdrawalService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void execute() {
        User user = userFacade.getCurrentUser();
        userRepository.delete(user);
    }
}
