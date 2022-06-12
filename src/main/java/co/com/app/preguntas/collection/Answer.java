//paquetes
package co.com.app.preguntas.collection;

//librerias

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Coleccion Answer
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "respuestas")
public class Answer {
    //Atributos

    @Id
    private String id;
    private String userId;
    private String questionId;
    private String answer;
    private Integer Position;
}
