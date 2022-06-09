//paquetes
package co.com.app.preguntas.Service.implementacion;

//librerias

import co.com.app.preguntas.Repository.QuestionRepository;
import co.com.app.preguntas.Service.IQuestionService;
import co.com.app.preguntas.collection.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class QuestionServiceImpl implements IQuestionService {
    //inyeccion del repositorio
    @Autowired
    private QuestionRepository questionRepository;

    //inyeccion de mapper
    @Autowired
    private ModelMapper modelMapper;

    // servicio listar todas las preguntas
    @Override
    public Flux<Question> listarPreguntas() {

        return questionRepository.findAll();
    }
    //servicio para guardar una pregunta
    @Override
    public Mono<Question> guardarPregunta(Question question) {

        return questionRepository.save(question);
    }
    //Servicio para buscar una pregunta por id
    @Override
    public Mono<Question> buscarPreguntaPorId(String questionId) {

        return questionRepository.findById(questionId);
    }
    //Servicio para eliminar una pregunta por id
    @Override
    public Mono<Void> eliminarPregunta(String questionId) {
        return questionRepository.deleteById(questionId);
    }
}
