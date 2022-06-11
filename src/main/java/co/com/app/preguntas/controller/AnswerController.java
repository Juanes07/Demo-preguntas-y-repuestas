package co.com.app.preguntas.controller;

import co.com.app.preguntas.Service.implementacion.AnswerServiceImpl;
import co.com.app.preguntas.collection.Answer;
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
@RequestMapping("/api/respuestas")
public class AnswerController {

    //inyeccion del servicio
    @Autowired
    private AnswerServiceImpl answerService;

    //EndPoint para listar Respuestas
    @Operation(summary = " --> Endpoint que nos permite listar todas las respuestas")
    @ApiResponse(responseCode = "200", description = "Se listaron las respuestas")
    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<Answer>>> listarRespuestas() {
        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(answerService.listasRespuestas()));

    }

    //EndPoint para guardar respuesta
    @Operation(summary = " --> Endpoint que nos permite guardar una respuesta")
    @Parameter(name = "Mono<Answer>", description = "Flujo de un solo dato de tipo Answer")
    @ApiResponse(responseCode = "200", description = "Se guardo la respuesta")
    @PostMapping("/guardar")
    public Mono<ResponseEntity<Mono<Answer>>> guardarRespuesta(@RequestBody Answer answer) {
        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(answerService.guardarRespuestas(answer)));
    }

    //EndPoint para obtener una respuesta por su Id
    @Operation(summary = " --> Endpoint que nos permite obtener una respuesta por id")
    @Parameter(name = "Id", description = "Se recibe un id de tipo string")
    @ApiResponse(responseCode = "200", description = "Se obtuvo la respuesta por el id")
    @GetMapping("/obtener/{id}")
    public Mono<ResponseEntity<Mono<Answer>>> obtenerRespuestaPorId(@PathVariable("id") String answerid) {
        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(answerService.buscarRespuestasPorId(answerid)));
    }

    //EndPoint para eliminar Respuesta por su Id
    @Operation(summary = " --> Endpoint que nos permite eliminar una respuesta por id")
    @Parameter(name = "Id", description = "Se recibe un id de tipo string")
    @ApiResponse(responseCode = "200", description = "Se elimno la respuesta por id")
    @DeleteMapping("/eliminar/{id}")
    public Mono<ResponseEntity<Mono<Void>>> eliminarRespuestaPorId(@PathVariable("id") String answerId) {
        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(answerService.eliminarRespuesta(answerId)));
    }


    //EndPoint para actualizar una respuesta por id
    @Operation(summary = "--> Endpoint que nos permite actualizar una Respuesta por id")
    @ApiResponse(responseCode = "200", description = "Se Actualizo la Respuesta")
    @PutMapping("/actualizar/{id}")
    public Mono<ResponseEntity<Mono<Answer>>> actualizarUnaRespuesta(@RequestBody Answer answer, @PathVariable("id") String id) {
        return answerService.buscarRespuestasPorId(id)
                .map(answerActualizada -> {
                    answerActualizada.setAnswer(answer.getAnswer());
                    answerActualizada.setPosition(answer.getPosition());
                    return answerService.actualizarRespuesta(answerActualizada);
                }).map(answerMono ->
                        ResponseEntity
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(answerMono));
    }

    //Endpoint para contar las respuestas por id de la pregunta
    @Operation(summary = "--> Endpoint que nos permite obtener el total de respuestas por el id de la pregunta")
    @GetMapping("/total/{id}")
    public Mono<Long> numeroDeRespuestasPorPregunta(@PathVariable("id") String id) {
        return answerService.listasRespuestas()
                .filter(respuesta -> respuesta.getQuestionId()
                        .equals(id)).count();


    }
    //Endpoint para listar las respuestas por id de la pregunta
    @Operation(summary = "--> Endpoint que nos permite listar las respuestas por el id de la pregunta")
    @ApiResponse(responseCode = "200",description = "Se listo correctamente las respuestas")
    @GetMapping("/listarid")
    public Mono<ResponseEntity<Flux<Answer>>> listarRespuestasPorPregunta(@PathVariable("id") String id) {
        return Mono.just(
                ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(answerService.listasRespuestas()
                                .filter(respuesta -> respuesta.getQuestionId()
                                        .equals(id)))
        );
    }


}
