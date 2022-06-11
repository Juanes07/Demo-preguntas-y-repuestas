package co.com.app.preguntas.controller;

import co.com.app.preguntas.Service.implementacion.AnswerServiceImpl;
import co.com.app.preguntas.collection.Answer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @GetMapping("/listar")
    public Mono<ResponseEntity<Flux<Answer>>> listarRespuestas(){
        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(answerService.listasRespuestas()));

    }

    //EndPoint para guardar respuesta
    @PostMapping("/guardar")
    public Mono<ResponseEntity<Mono<Answer>>> guardarRespuesta(@RequestBody Answer answer){
        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(answerService.guardarRespuestas(answer)));
    }

    //EndPoint para obtener una respuesta por su Id
    @GetMapping("/obtener/{id}")
    public Mono<ResponseEntity<Mono<Answer>>> obtenerRespuestaPorId(@PathVariable("id") String answerid){
        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(answerService.buscarRespuestasPorId(answerid)));
    }

    //EndPoint para eliminar Respuesta por su Id
    @DeleteMapping("/eliminar/{id}")
    public Mono<ResponseEntity<Mono<Void>>> eliminarRespuestaPorId(@PathVariable("id")String answerId){
        return Mono.just(ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(answerService.eliminarRespuesta(answerId)));
    }




}
