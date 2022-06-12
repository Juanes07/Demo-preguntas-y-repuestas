//paquetes
package co.com.app.preguntas.Repository;
//librerias
import co.com.app.preguntas.collection.Question;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * Repositorio Question
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * repositorio de preguntas
  */
@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {

}
