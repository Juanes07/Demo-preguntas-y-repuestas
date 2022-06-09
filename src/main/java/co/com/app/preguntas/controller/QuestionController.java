//paquetes
package co.com.app.preguntas.controller;

//importaciones
import co.com.app.preguntas.Service.implementacion.QuestionServiceImpl;
import co.com.app.preguntas.collection.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/preguntas")
public class QuestionController {

    //inyectamos el servicio
    @Autowired
    private QuestionServiceImpl questionService;


    //Endpoint  para listar preguntas
    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<Question>>> listarPreguntas() {
        return Mono.just(
                ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(questionService.listarPreguntas())
        );

    }

    //Endpoint para guardar una pregunta
    @PostMapping("/guardar")
    public Mono<ResponseEntity<Mono<Question>>> guardarUnaPregunta(@RequestBody Question question) {
        return Mono.just(
                ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(questionService.guardarPregunta(question))
        );

    }

    //Endpoint para obtener una pregunta por id
    @GetMapping("/obtener/{id}")
    public Mono<ResponseEntity<Mono<Question>>> obtenerPreguntaPorId(@PathVariable("id") String id) {
        return Mono.just(
                ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(questionService.buscarPreguntaPorId(id))
        );

    }

    //Endpoint para eliminar una pregunta por id
    @DeleteMapping("/eliminar/{id}")
    public Mono<ResponseEntity<Mono<Void>>> eliminarPreguntaPorId(@PathVariable("id") String id) {
        return Mono.just(
                ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(questionService.eliminarPregunta(id))
        );
    }

}
