package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

    List<Quiz> findAllByTitleContainingAndAreaInAndLevelIn(String title, List<Area> area, List<Level> level);

    Quiz findQuizById(Long id);
}
