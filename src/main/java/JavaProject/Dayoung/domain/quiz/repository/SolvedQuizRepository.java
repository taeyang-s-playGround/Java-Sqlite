package JavaProject.Dayoung.domain.quiz.repository;

import JavaProject.Dayoung.domain.quiz.entity.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolvedQuizRepository extends CrudRepository<SolvedQuiz, Long> {

    List<SolvedQuiz> findAllById(Long id);

    List<SolvedQuiz> findAllByUserIdAndIsSolved(Long userId, IsSolved isSolved);
}
