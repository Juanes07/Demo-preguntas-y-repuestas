//paquetes
package co.com.app.preguntas.collection;

//librerias

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "preguntas")
public class Question {
    //Atributos
    @Id
    private String id;
    private String userId;
    private String question;
    private String type;
    private String category;
    private List<Answer> answers;

}
