/**
 * paquetes
 */
package co.com.app.preguntas.Service;
import co.com.app.preguntas.collection.Answer;

/**
 * librerias
 */
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * interfaz de servicios respuestas
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

public interface IAnswerService {

    /**
     * listas Respuestas
     * @return Flux<Answer>
     */
    Flux<Answer> listasRespuestas();

    /**
     * guardar Respuestas
     * @param answer
     * @return Mono<Answer>
     */
    Mono<Answer> guardarRespuestas(Answer answer);

    /**
     * buscar Respuestas por ID
     * @param answerId
     * @return Mono<Answer>
     */
    Mono<Answer> buscarRespuestasPorId(String answerId);

    /**
     * Borrar Respuestas
     * @param answerId
     * @return Mono<Void>
     */
    Mono<Void> eliminarRespuesta(String answerId);

    /**
     * Actualizar Respuesta
     * @param answer
     * @return Mono<Answer>
     */
    Mono<Answer> actualizarRespuesta(Answer answer);
}
