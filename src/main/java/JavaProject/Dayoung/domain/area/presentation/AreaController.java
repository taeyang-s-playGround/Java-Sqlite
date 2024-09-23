package JavaProject.Dayoung.domain.area.presentation;

import JavaProject.Dayoung.domain.area.presentation.dto.request.CreateAreaRequest;
import JavaProject.Dayoung.domain.area.service.CreateAreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "분야", description = "분야 도메인")
@RequestMapping("/areas")
@RestController
public class AreaController {

    private final CreateAreaService createAreaService;

    @PostMapping
    @Operation(summary = "분야 생성", description = "분야를 어드민이 추가하는 API")
    public void createArea(@RequestBody @Valid CreateAreaRequest request) {
        createAreaService.execute(request);
    }
}
