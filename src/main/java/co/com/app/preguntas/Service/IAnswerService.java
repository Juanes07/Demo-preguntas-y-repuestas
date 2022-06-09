//paquetes
package co.com.app.preguntas.Service;
import co.com.app.preguntas.DTO.AnswerDto;

//librerias
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//interfaz de servicios respuestas
public interface IAnswerService {

    //listas Respuestas
    Flux<AnswerDto> listasRespuestas();

    //guardar Respuestas
    Mono<AnswerDto> guardarRespuestas(AnswerDto answerDto);

    //buscar Respuestas por ID
    Mono<AnswerDto> buscarRespuestasPorId(String answerId);

    //Borrar Respuestas
    Mono<Void> eliminarRespuesta(String answerId);
}
