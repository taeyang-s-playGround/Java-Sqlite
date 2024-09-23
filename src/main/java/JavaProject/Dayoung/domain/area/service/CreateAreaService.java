package JavaProject.Dayoung.domain.area.service;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.area.presentation.dto.request.CreateAreaRequest;
import JavaProject.Dayoung.domain.area.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateAreaService {

    private final AreaRepository areaRepository;

    public void execute(CreateAreaRequest request) {
        areaRepository.save(Area.builder()
                .areaName(request.getAreaName())
                .build());
    }
}
