/**
 * paquetes
 */
package co.com.app.preguntas.Service.implementacion;

/**
 * librerias
 */

import co.com.app.preguntas.Repository.QuestionRepository;
import co.com.app.preguntas.Service.IQuestionService;
import co.com.app.preguntas.collection.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servicio Question
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */



@Service
public class QuestionServiceImpl implements IQuestionService {
    /**
     * inyeccion del repositorio
     */
    @Autowired
    private QuestionRepository questionRepository;

    /**
     * inyeccion de mapper
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * servicio listar todas las preguntas
     * @return Flux<Question>
     */
    @Override
    public Flux<Question> listarPreguntas() {

        return questionRepository.findAll();
    }

    /**
     * servicio para guardar una pregunta
     * @param question
     * @return Mono<Question>
     */
    @Override
    public Mono<Question> guardarPregunta(Question question) {

        return questionRepository.save(question);
    }

    /**
     * Servicio para buscar una pregunta por id
     * @param questionId
     * @return Mono<Question>
     */
    @Override
    public Mono<Question> buscarPreguntaPorId(String questionId) {

        return questionRepository.findById(questionId);
    }

    /**
     * Servicio para eliminar una pregunta por id
     * @param questionId
     * @return Mono<Void>
     */
    @Override
    public Mono<Void> eliminarPregunta(String questionId) {
        return questionRepository.deleteById(questionId);
    }

    /**
     * Servicio para actualizar una pregunta
     * @param question
     * @return Mono<Question>
     */
    @Override
    public Mono<Question> actualizarPregunta(Question question) {

        return questionRepository.save(question);
    }


}
