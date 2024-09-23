package JavaProject.Dayoung.domain.quiz.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SolveQuizRequest {

    @NotNull(message = "문제를 입력하세요")
    @Size(min = 1, max = 1000)
    private String quiz;

    @NotNull(message = "답변을 입력하세요")
    @Size(min = 1, max = 1000)
    private String answer;
}
