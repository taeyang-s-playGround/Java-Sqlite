package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.area.repository.AreaRepository;
import JavaProject.Dayoung.domain.code.entity.Code;
import JavaProject.Dayoung.domain.code.repository.CodeRepository;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.CategoryListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryCategoryService {

    private final CodeRepository codeRepository;
    private final AreaRepository areaRepository;

    public CategoryListResponse execute() {

        List<Code> codes = codeRepository.findAll();
        List<Area> areas = areaRepository.findAll();

        return new CategoryListResponse(codes, areas);
    }
}
