package JavaProject.Dayoung.domain.code.presentation;

import JavaProject.Dayoung.domain.code.presentation.dto.request.CreateCodeRequest;
import JavaProject.Dayoung.domain.code.service.CreateCodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "기술 스택", description = "기술 스택 도메인")
@RequestMapping("/codes")
@RestController
public class CodeController {

    private final CreateCodeService createCodeService;

    @PostMapping
    @Operation(summary = "기술 스택 생성", description = "기술스택을 어드민이 추가하는 API")
    public void createCode(@RequestBody @Valid CreateCodeRequest request) {
        createCodeService.execute(request);
    }
}
