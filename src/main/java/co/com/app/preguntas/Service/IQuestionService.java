//paquetes
package co.com.app.preguntas.Service;

import co.com.app.preguntas.collection.Question;

//librerias
import co.com.app.preguntas.collection.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//interfaz de servicios preguntas
public interface IQuestionService {

    //listas Preguntas
    Flux<Question> listarPreguntas();

    //guardar Pregunta
    Mono<Question> guardarPregunta(Question question);

    //buscar Pregunta por ID
    Mono<Question> buscarPreguntaPorId(String question);

    //Borrar pregunta
    Mono<Void> eliminarPregunta(String question);
}
