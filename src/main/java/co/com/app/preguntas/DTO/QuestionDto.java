package co.com.app.preguntas.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    //Atributos
    private String userId;
    private String question;
    private String type;
    private String category;

}
