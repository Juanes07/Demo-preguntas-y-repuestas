package co.com.app.preguntas.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    //Atributos
    
    private String userId;
    private String questionId;
    private String answer;
    private Integer Position;
}
