package JavaProject.Dayoung.domain.code.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CreateCodeRequest {

    @NotNull(message = "기술스택 분야를 입력하세요")
    private String codeName;
}
