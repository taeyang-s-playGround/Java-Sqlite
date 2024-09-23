package JavaProject.Dayoung.domain.code.service;

import JavaProject.Dayoung.domain.code.entity.Code;
import JavaProject.Dayoung.domain.code.presentation.dto.request.CreateCodeRequest;
import JavaProject.Dayoung.domain.code.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateCodeService {

    private final CodeRepository codeRepository;

    public void execute(CreateCodeRequest request) {
        codeRepository.save(Code.builder()
                .codeName(request.getCodeName())
                .build());
    }
}
