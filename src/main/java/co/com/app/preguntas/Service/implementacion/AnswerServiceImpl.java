//paquetes
package co.com.app.preguntas.Service.implementacion;

//librerias


import co.com.app.preguntas.Repository.RepositoryAnswer;
import co.com.app.preguntas.Service.IAnswerService;
import co.com.app.preguntas.collection.Answer;
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
    public Flux<Answer> listasRespuestas() {
        return repositoryAnswer.findAll();

    }

    @Override
    public Mono<Answer> guardarRespuestas(Answer answer) {
        return repositoryAnswer.save(answer);
    }

    @Override
    public Mono<Answer> buscarRespuestasPorId(String answerId) {
        return repositoryAnswer.findById(answerId);
    }

    @Override
    public Mono<Void> eliminarRespuesta(String answerId) {
        repositoryAnswer.deleteById(answerId);
        return Mono.empty();
    }
}
