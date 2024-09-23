package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.exception.CannotUpdateQuizException;
import JavaProject.Dayoung.domain.quiz.facade.QuizFacade;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.UpdateQuizRequest;
import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateQuizService {

    private final QuizFacade quizFacade;
    private final UserFacade userFacade;

    public void execute(Long quizId, UpdateQuizRequest request) {
        User user = userFacade.getCurrentUser();
        Quiz quiz = quizFacade.getQuiz(quizId);

        if (!user.equals(quiz.getUser())) {
            throw CannotUpdateQuizException.EXCEPTION;
        }

        quiz.updateQuiz(request.getTitle(), request.getQuestion(), request.getLevel(), request.getCode(), request.getArea());
    }
}
