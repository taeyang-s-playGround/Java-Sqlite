package JavaProject.Sqlite.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    private String accountId;

    private String name;

    private String introduction;

}
