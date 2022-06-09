//paquetes
package co.com.app.preguntas.Repository;
//librerias
import co.com.app.preguntas.collection.Question;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//repositorio de preguntas
@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {

}
