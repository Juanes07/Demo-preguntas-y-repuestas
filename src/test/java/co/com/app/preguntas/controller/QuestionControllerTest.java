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

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@WebFluxTest(QuestionController.class)
class QuestionControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private QuestionServiceImpl questionService;

    @MockBean
    private AnswerServiceImpl answerService;

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

    @Test
    public  void listarPreguntasTest(){
        webTestClient.get().uri("/api/preguntas/listar")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Question.class)
                .getResponseBody();
    }

    @Test
    public void getQuestionIdTest(){
        webTestClient.get().uri("/api/preguntas/obtener/1")
                .exchange()
                .expectStatus()
                .isOk()
                .returnResult(Question.class)
                .getResponseBody();
    }

    @Test
    public void deleteQuestionTest(){
        webTestClient.delete().uri("/api/preguntas/eliminar/1")
                .exchange()
                .expectStatus()
                .isOk();
    }



}