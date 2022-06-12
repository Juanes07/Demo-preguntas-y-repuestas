/**
 * paquetes
 */
package co.com.app.preguntas.Service;


import co.com.app.preguntas.collection.Question;
/**
 * librerias
 */

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * interfaz de servicios preguntas
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IQuestionService {

    /**
     * listas Preguntas
     * @return Flux<Question>
     */
    Flux<Question> listarPreguntas();

    /**
     * guardar Pregunta
     * @param question
     * @return Mono<Question>
     */
    Mono<Question> guardarPregunta(Question question);

    /**
     * buscar Pregunta por ID
     * @param question
     * @return
     */
    Mono<Question> buscarPreguntaPorId(String question);

    /**
     * Borrar pregunta
     * @param question
     * @return Mono<Void>
     */
    Mono<Void> eliminarPregunta(String question);

    /**
     * Actualizar pregunta
     * @param question
     * @return Mono<Question>
     */
    Mono<Question> actualizarPregunta(Question question);



}
