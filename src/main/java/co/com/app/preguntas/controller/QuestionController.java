//paquetes
package co.com.app.preguntas.controller;

//importaciones

import co.com.app.preguntas.Service.implementacion.QuestionServiceImpl;
import co.com.app.preguntas.collection.Question;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador Question
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/api/preguntas")
public class QuestionController {

    //inyectamos el servicio
    @Autowired
    private QuestionServiceImpl questionService;


    /**
     * Endpoint  para listar preguntas
     * @return Flux<Question>
     */
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

    /**
     * Endpoint para guardar una pregunta
     * @param question
     * @return Mono<Question>
     */
    @Operation(summary = " --> Endpoint que nos permite guardar una pregunta")
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

    /**
     * Endpoint para obtener una pregunta por id
     * @param id
     * @return Mono<Question>
     */
    @Operation(summary = " --> Endpoint que nos permite obtener una pregunta por id")
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

    /**
     * Endpoint para eliminar una pregunta por id
     * @param id
     * @return Mono<Void>
     */
    @Operation(summary = " --> Endpoint que nos permite eliminar una pregunta por id")
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

    /**
     * Endpoint para actualizar la pregunta por id
     * @param question
     * @param id
     * @return Mono<Question>
     */
    @Operation(summary = " --> Endpoint que nos permite actualizar una pregunta por id")
    @ApiResponse(responseCode = "200",description = "Se Actualizo la pregunta")
    @PutMapping("/actualizar/{id}")
    public Mono<ResponseEntity<Mono<Question>>> actulizarUnaPregunta(@RequestBody Question question, @PathVariable("id") String id) {
        return questionService.buscarPreguntaPorId(id).map(questionActualizada ->
        {
            questionActualizada.setQuestion(question.getQuestion());
            questionActualizada.setType(question.getType());
            questionActualizada.setCategory(question.getCategory());
            return questionService.actualizarPregunta(questionActualizada);
        }).map(questionMono -> ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(questionMono));
    }


    /**
     * EndPoint para contar preguntas
     * @return Mono<Long>
     */
    @GetMapping("/total")
    @Operation(summary = "Nos permite obtener el numero total de preguntas")
    public Mono<Long> NumeroPreguntasTotales(){
        return questionService.listarPreguntas().count();
    }

}
