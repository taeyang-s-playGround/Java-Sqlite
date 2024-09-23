package JavaProject.Dayoung.domain.user.service;

import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import JavaProject.Dayoung.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateUserInfoService {

    private final UserFacade userFacade;

    public void execute(UpdateUserInfoRequest updateUserInfoRequest) {
        User user = userFacade.getCurrentUser();

        user.modifyInfo(updateUserInfoRequest.getAccountId(),
                updateUserInfoRequest.getName(),
                updateUserInfoRequest.getArea(),
                updateUserInfoRequest.getIntroduction());
    }
}
