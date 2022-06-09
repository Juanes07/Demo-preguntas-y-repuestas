//paquetes
package co.com.app.preguntas.Service;

import co.com.app.preguntas.DTO.QuestionDto;

//librerias
import co.com.app.preguntas.collection.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//interfaz de servicios preguntas
public interface IQuestionService {

    //listas Preguntas
    Flux<QuestionDto> listarPreguntas();

    //guardar Pregunta
    Mono<QuestionDto> guardarPregunta(QuestionDto questionDto);

    //buscar Pregunta por ID
    Mono<QuestionDto> buscarPreguntaPorId(String questionId);

    //Borrar pregunta
    Mono<Void> eliminarPregunta(String questionId);
}
