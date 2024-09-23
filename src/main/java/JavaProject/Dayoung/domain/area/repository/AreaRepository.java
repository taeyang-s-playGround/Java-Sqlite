package JavaProject.Dayoung.domain.area.repository;

import JavaProject.Dayoung.domain.area.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {

    Area findAreaById(Long id);
}
