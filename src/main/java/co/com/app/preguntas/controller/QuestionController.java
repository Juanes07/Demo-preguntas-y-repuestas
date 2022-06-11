//paquetes
package co.com.app.preguntas.controller;

//importaciones
import co.com.app.preguntas.Service.implementacion.QuestionServiceImpl;
import co.com.app.preguntas.collection.Question;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = " --> Endpoint que nos permite listar todas las preguntas")
    @ApiResponse(responseCode = "200", description = "Se listaron las preguntas")
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
    @Operation(summary = " --> Endpoint que nos permite guardar una pregunta")
    @Parameter(name = "Mono<Question>", description = "Flujo de un solo dato de tipo Question")
    @ApiResponse(responseCode = "200", description = "Se guardo la pregunta")
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
    @Operation(summary = " --> Endpoint que nos permite obtener una pregunta por id")
    @Parameter(name = "Id",description = "Se recibe un id de tipo string")
    @ApiResponse(responseCode = "200", description = "Se obtuvo la pregunta por el id")
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
    @Operation(summary = " --> Endpoint que nos permite eliminar una pregunta por id")
    @Parameter(name = "Id", description = "Se recibe un id de tipo string")
    @ApiResponse(responseCode = "200", description = "Se elimno la pregunta por id")
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
