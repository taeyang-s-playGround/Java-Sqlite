package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.exception.CannotDeleteQuizException;
import JavaProject.Dayoung.domain.quiz.facade.QuizFacade;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteQuizService {

    private final QuizFacade quizFacade;
    private final UserFacade userFacade;
    private final QuizRepository quizRepository;

    public void execute(Long quizId) {
        Quiz quiz = quizFacade.getQuiz(quizId);
        User user = userFacade.getCurrentUser();

        if (!user.equals(quiz.getUser())) {
            throw CannotDeleteQuizException.EXCEPTION;
        }

        quizRepository.delete(quiz);
    }
}
