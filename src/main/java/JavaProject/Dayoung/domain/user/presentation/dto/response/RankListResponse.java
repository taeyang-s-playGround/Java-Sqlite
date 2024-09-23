package JavaProject.Dayoung.domain.user.presentation.dto.response;

import JavaProject.Dayoung.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class RankListResponse {

    private final List<RankResponse> rankListResponse;

    private String myName;
    private Integer myScore;
    private Integer myRank;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RankResponse {

        private String name;
        private Integer score;

        public static RankResponse of(User user) {
            return RankResponse.builder()
                .name(user.getName())
                .score(user.getScore())
                .build();
        }
    }
}
