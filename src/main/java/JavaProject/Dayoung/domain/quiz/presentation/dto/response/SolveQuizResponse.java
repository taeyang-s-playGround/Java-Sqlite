package JavaProject.Dayoung.domain.quiz.presentation.dto.response;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SolveQuizResponse {

    private double percent;

    private int score;

    private String myAnswer;

    private String feedback;

    private String title;

    private int solvedPersonCount;

    private int avrScore;
}
