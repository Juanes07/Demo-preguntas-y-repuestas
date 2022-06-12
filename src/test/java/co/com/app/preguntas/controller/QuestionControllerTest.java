package co.com.app.preguntas.controller;

import co.com.app.preguntas.Service.implementacion.AnswerServiceImpl;
import co.com.app.preguntas.Service.implementacion.QuestionServiceImpl;
import co.com.app.preguntas.collection.Answer;
import co.com.app.preguntas.collection.Question;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Guardar Question Test
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

@RunWith(SpringRunner.class)
@WebFluxTest(QuestionController.class)
class QuestionControllerTest {
    /**
     * Inyeccion webTestClient
     */

    @Autowired
    private WebTestClient webTestClient;

    /**
     * Inyeccion questionService
     */

    @MockBean
    private QuestionServiceImpl questionService;

    /**
     * Inyeccion answerService
     */

    @MockBean
    private AnswerServiceImpl answerService;

    /**
     * guardarQuestionTest
     */
    @Test
    public void guardarQuestionTest(){
        Answer answer = new Answer("1", "2", "15", "es asi", 5);
        List<Answer> answers = new ArrayList<>();
        answers.add(answer);
        Question   question = new Question(
                "1","1","pregunta","desarrollo","java", answers);

        webTestClient.post().uri("/api/preguntas/guardar")
                .body(Mono.just(question), Question.class)
                .exchange().expectStatus().isOk();
    }

    /**
     * Listar Preguntas Test
     */

    @Test
    public  void listarPreguntasTest(){
        webTestClient.get().uri("/api/preguntas/listar")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Question.class)
                .getResponseBody();
    }

    /**
     * get Question Id Test
     */
    @Test
    public void getQuestionIdTest(){
        webTestClient.get().uri("/api/preguntas/obtener/1")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Question.class)
                .getResponseBody();
    }

    /**
     * Delete Question Test
     */

    @Test
    public void deleteQuestionTest(){
        webTestClient.delete().uri("/api/preguntas/eliminar/1")
                .exchange()
                .expectStatus()
                .isOk();
    }



}