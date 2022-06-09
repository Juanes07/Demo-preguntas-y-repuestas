//paquetes
package co.com.app.preguntas.Service.implementacion;

//librerias

import co.com.app.preguntas.DTO.AnswerDto;
import co.com.app.preguntas.Repository.RepositoryAnswer;
import co.com.app.preguntas.Service.IAnswerService;
import co.com.app.preguntas.collection.Answer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private RepositoryAnswer repositoryAnswer;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Flux<AnswerDto> listasRespuestas() {
        //uso del servicio
        Flux<Answer> listaDeRespuestas = repositoryAnswer.findAll();
        //Answer a AnswerDto
        Flux<AnswerDto> listarDeRespuestasDto = listaDeRespuestas.map(answer -> modelMapper.map(answer, AnswerDto.class));
        return listarDeRespuestasDto;
    }

    @Override
    public Mono<AnswerDto> guardarRespuestas(AnswerDto answerDto) {
        //AnswerDto a Answer
        Answer answer = modelMapper.map(answerDto, Answer.class);
        //uso del servivio
        Mono<Answer> answerService = repositoryAnswer.save(answer);
        //Answer a AnswerDto
        Mono<AnswerDto> retornoDto = modelMapper.map(answerService, (Type) AnswerDto.class);

        return retornoDto;
    }

    @Override
    public Mono<AnswerDto> buscarRespuestasPorId(String answerId) {
        //uso del servicio
        Mono<Answer> answer = repositoryAnswer.findById(answerId);
        // Mono<Answer> a Mono<AnswerDto>
        Mono<AnswerDto> retornoDto = modelMapper.map(answer, (Type) AnswerDto.class);
        return retornoDto;
    }

    @Override
    public Mono<Void> eliminarRespuesta(String answerId) {
        repositoryAnswer.deleteById(answerId);
        return Mono.empty();
    }
}
