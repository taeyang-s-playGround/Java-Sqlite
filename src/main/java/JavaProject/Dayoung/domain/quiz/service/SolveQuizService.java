package JavaProject.Dayoung.domain.quiz.service;

import JavaProject.Dayoung.domain.quiz.presentation.dto.request.SolveQuizRequest;
import JavaProject.Dayoung.infra.openai.config.TemplateConfig;
import JavaProject.Dayoung.infra.openai.domain.ChatGPTResponse;
import JavaProject.Dayoung.infra.openai.repository.ChatGPTRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class SolveQuizService {

    private final TemplateConfig templateConfig;

    public Map<String, String> execute(SolveQuizRequest request) {

        ChatGPTRequest gptRequest = templateConfig.promptMapping(request);
        ResponseEntity<ChatGPTResponse> gptResponse = templateConfig.responseMapping(gptRequest);

        String responseContent = gptResponse.getBody().getChoices().get(0).getMessage().getContent();

        String correctRate = templateConfig.correctRateMatcher(responseContent);
        String feedback = templateConfig.feedbackMatcher(responseContent);

        Map<String, String> result = new HashMap<>();
        result.put("정답률", correctRate);
        result.put("피드백", feedback);

        return result;
    }
}
