package JavaProject.Dayoung.domain.area.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateAreaRequest {

    @NotBlank(message = "분야를 입력해 주세요")
    private String areaName;
}
