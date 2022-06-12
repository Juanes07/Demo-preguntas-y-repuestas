/**
 * paquetes
 */
package co.com.app.preguntas.Service.implementacion;

/**
 * librerias
 */


import co.com.app.preguntas.Repository.RepositoryAnswer;
import co.com.app.preguntas.Service.IAnswerService;
import co.com.app.preguntas.collection.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servicio Answer
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

@Service
public class AnswerServiceImpl implements IAnswerService {

    /**
     * Inyeccion del AnswerRepository
     */
    @Autowired
    private RepositoryAnswer repositoryAnswer;

    /**
     * listar respuestas
     * @return Flux<Answer>
     */
    @Override
    public Flux<Answer> listasRespuestas() {
        return repositoryAnswer.findAll();

    }

    /**
     * Guardar respuesta
     * @param answer
     * @return Mono<Answer>
     */

    @Override
    public Mono<Answer> guardarRespuestas(Answer answer) {
        return repositoryAnswer.save(answer);
    }

    /**
     * Buscar respuestas por id
     * @param answerId
     * @return Mono<Answer>
     */

    @Override
    public Mono<Answer> buscarRespuestasPorId(String answerId) {
        return repositoryAnswer.findById(answerId);
    }

    /**
     * Eliminar una respuesta por id
     * @param answerId
     * @return
     */

    @Override
    public Mono<Void> eliminarRespuesta(String answerId) {

        return repositoryAnswer.deleteById(answerId);
    }

    /**
     * Actualizar la respuesta
     * @param answer
     * @return Mono<Answer>
     */

    @Override
    public Mono<Answer> actualizarRespuesta(Answer answer) {
        return repositoryAnswer.save(answer);
    }
}
