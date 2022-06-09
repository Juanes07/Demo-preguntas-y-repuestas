//paquetes
package co.com.app.preguntas.Service.implementacion;

//librerias
import co.com.app.preguntas.DTO.QuestionDto;
import co.com.app.preguntas.Repository.QuestionRepository;
import co.com.app.preguntas.Service.IQuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Flux<QuestionDto> listarPreguntas() {
        return null;
    }

    @Override
    public Mono<QuestionDto> guardarPregunta(QuestionDto questionDto) {
        return null;
    }

    @Override
    public Mono<QuestionDto> buscarPreguntaPorId(String questionId) {
        return null;
    }

    @Override
    public Mono<Void> eliminarPregunta(String questionId) {
        return null;
    }
}
