package JavaProject.Sqlite.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class MyInfoResponse {

    private String accountId;

    private String name;

    private String introduction;

    private int myRank;

    private List<Long> unsolvedQuizIds;
}
