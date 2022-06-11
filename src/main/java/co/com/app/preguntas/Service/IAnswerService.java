//paquetes
package co.com.app.preguntas.Service;
import co.com.app.preguntas.collection.Answer;

//librerias
import co.com.app.preguntas.collection.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//interfaz de servicios respuestas
public interface IAnswerService {

    //listas Respuestas
    Flux<Answer> listasRespuestas();

    //guardar Respuestas
    Mono<Answer> guardarRespuestas(Answer answer);

    //buscar Respuestas por ID
    Mono<Answer> buscarRespuestasPorId(String answerId);

    //Borrar Respuestas
    Mono<Void> eliminarRespuesta(String answerId);

    //Actualizar Respuesta
    Mono<Answer> actualizarRespuesta(Answer answer);
}
