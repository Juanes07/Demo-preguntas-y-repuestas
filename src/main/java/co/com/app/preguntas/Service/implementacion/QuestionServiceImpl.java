//paquetes
package co.com.app.preguntas.Service.implementacion;

//librerias

import co.com.app.preguntas.DTO.QuestionDto;
import co.com.app.preguntas.Repository.QuestionRepository;
import co.com.app.preguntas.Service.IQuestionService;
import co.com.app.preguntas.collection.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Flux<QuestionDto> listarPreguntas() {
        //uso del servicio
        Flux<Question> listaDePreguntas = questionRepository.findAll();
        // Question a QuestionDto
        Flux<QuestionDto> listaDePregtuntasDto = listaDePreguntas.map(question -> modelMapper.map(question, QuestionDto.class));
        return listaDePregtuntasDto;
    }

    @Override
    public Mono<QuestionDto> guardarPregunta(QuestionDto questionDto) {
        //QuestionDto a Question
        Question question = modelMapper.map(questionDto, Question.class);
        //uso del servicio
        Mono<Question> questionService = questionRepository.save(question);
        //Question a QuestionDto
        Mono<QuestionDto> retornoDto = modelMapper.map(questionService, (Type) QuestionDto.class);
        return retornoDto;
    }

    @Override
    public Mono<QuestionDto> buscarPreguntaPorId(String questionId) {
        //uso del servicio
        Mono<Question> question = questionRepository.findById(questionId);
        // Mono<Question> a Mono<QuestionDto>
        Mono<QuestionDto> retornoDto = modelMapper.map(question, (Type) QuestionDto.class);
        return retornoDto;
    }

    @Override
    public Mono<Void> eliminarPregunta(String questionId) {
        questionRepository.deleteById(questionId);
        return Mono.empty();
    }
}
