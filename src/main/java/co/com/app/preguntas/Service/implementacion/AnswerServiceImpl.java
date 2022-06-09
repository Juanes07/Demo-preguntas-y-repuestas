//paquetes
package co.com.app.preguntas.Service.implementacion;

//librerias
import co.com.app.preguntas.DTO.AnswerDto;
import co.com.app.preguntas.Repository.RepositoryAnswer;
import co.com.app.preguntas.Service.IAnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private RepositoryAnswer repositoryAnswer;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Flux<AnswerDto> listasRespuestas() {
        return null;
    }

    @Override
    public Mono<AnswerDto> guardarRespuestas(AnswerDto answerDto) {
        return null;
    }

    @Override
    public Mono<AnswerDto> buscarRespuestasPorId(String answerId) {
        return null;
    }

    @Override
    public Mono<Void> eliminarRespuesta(String answerId) {
        return null;
    }
}
