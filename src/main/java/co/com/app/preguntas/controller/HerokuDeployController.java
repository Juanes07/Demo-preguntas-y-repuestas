package co.com.app.preguntas.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
/**
 * Controlador HerokuDeploy
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

@CrossOrigin("*")
@RestController
@RequestMapping("heroku")
public class HerokuDeployController {

    /**
     * Endpoint para motrar que el backend se desplego en heroku
     * @return
     */
    @GetMapping("/deploy")
    public Mono<String> herokuDeploy(){

        return Mono.just("---> Backend Desplegado <---");

    }
}
