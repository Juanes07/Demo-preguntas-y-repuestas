package co.com.app.preguntas.controller;

import co.com.app.preguntas.Service.implementacion.AnswerServiceImpl;
import co.com.app.preguntas.collection.Answer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

/**
 * Test Controlador Answer
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

@RunWith(SpringRunner.class)
@WebFluxTest(AnswerController.class)
class AnswerControllerTest {

    /**
     * Inyeccion de WebTestClient
     */
    @Autowired
    private WebTestClient webTestClient;

    /**
     * Inyeccion de AnswerService
     */

    @MockBean
    private AnswerServiceImpl answerService;

    /**
     * guardar Answer Test
     */
    @Test
    public void guardarAnswerTest() {

        Answer answer = new Answer("1", "2", "15", "es asi", 5);

        webTestClient.post().uri("/api/respuestas/guardar").body(Mono.just(answer), Answer.class)
                .exchange()
                .expectStatus()
                .isOk();


    }

    /**
     * listar Respuestas Test
     */

    @Test
    public void listarRespuestasTest() {

        webTestClient.get().uri("/api/respuestas/listar")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Answer.class)
                .getResponseBody();


    }

    /**
     * get AnswerId Test
     */
    @Test
    public void getAnswerIdTest() {

        webTestClient.get().uri("/api/respuestas/obtener/1")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Answer.class)
                .getResponseBody();


    }

    /**
     * delete Answer Test
     */
    @Test
    public void deleteAnswerTest(){

        webTestClient.delete().uri("/api/respuestas/eliminar/1")
                .exchange()
                .expectStatus()
                .isOk();


    }

}

