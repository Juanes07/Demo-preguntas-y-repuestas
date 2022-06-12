package co.com.app.preguntas.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("heroku")
public class HerokuDeployController {
    @GetMapping("/deploy")
    public Mono<String> herokuDeploy(){

        return Mono.just("---> Backend Desplegado <---");

    }
}
