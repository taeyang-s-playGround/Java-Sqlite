package JavaProject.Dayoung.domain.user.presentation.dto.request;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.code.entity.Code;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    private String accountId;

    private String name;

    private Area area;

    private String introduction;

    private Code code;
}
