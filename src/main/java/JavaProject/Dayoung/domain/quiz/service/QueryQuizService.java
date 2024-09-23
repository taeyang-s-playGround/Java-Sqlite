package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.entity.SolvedQuiz;
import JavaProject.Dayoung.domain.quiz.entity.type.IsSolved;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import JavaProject.Dayoung.domain.quiz.presentation.dto.response.QuizListResponse;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import JavaProject.Dayoung.domain.quiz.repository.SolvedQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryQuizService {

    private final QuizRepository quizRepository;
    private final SolvedQuizRepository solvedQuizRepository;

    public List<QuizListResponse> execute(String title, List<Area> area, List<Level> level, IsSolved isSolved) {

        List<Quiz> quizzes = quizRepository.findAllByTitleContainingAndAreaInAndLevelIn(title, area, level);

        return quizzes.stream()
                .filter(quiz -> {
                    List<SolvedQuiz> solvedQuizzes = solvedQuizRepository.findAllById(quiz.getId());
                    return solvedQuizzes.stream().anyMatch(solvedQuiz -> solvedQuiz.getIsSolved() == isSolved);
                })
                .map(QuizListResponse::new)
                .collect(Collectors.toList());
    }
}
