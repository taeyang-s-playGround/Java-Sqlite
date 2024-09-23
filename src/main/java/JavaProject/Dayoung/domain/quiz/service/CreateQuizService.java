package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.entity.Quiz;
import JavaProject.Dayoung.domain.quiz.presentation.dto.request.CreateQuizRequest;
import JavaProject.Dayoung.domain.quiz.repository.QuizRepository;
import JavaProject.Dayoung.domain.user.entity.User;
import JavaProject.Dayoung.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateQuizService {

    private final QuizRepository quizRepository;
    private final UserFacade userFacade;

    public void execute(CreateQuizRequest request) {
        User user = userFacade.getCurrentUser();

        quizRepository.save(Quiz.builder()
                //.area() 일단 보류
                //.code()
                .level(request.getLevel())
                .question(request.getQuestion())
                .title(request.getTitle())
                .build());
    }
}
