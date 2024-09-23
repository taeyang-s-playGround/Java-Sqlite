package JavaProject.Dayoung.domain.quiz.presentation.dto.request;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.code.entity.Code;
import JavaProject.Dayoung.domain.quiz.entity.type.Level;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateQuizRequest {

    private String title;

    private String question;

    private Level level;

    private Code code;

    private Area area;
}
