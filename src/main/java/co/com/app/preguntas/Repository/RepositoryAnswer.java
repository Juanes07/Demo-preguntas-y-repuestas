//paquetes
package co.com.app.preguntas.Repository;
//librerias
import co.com.app.preguntas.collection.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Answer
 *
 * @author Juan Esteban Velasquez , Juan Pablo Toro Hurtado
 * @version 1.0.0
 * @since 1.0.0
 */

/**
 * Repositorio de respuestas
 */
@Repository
public interface RepositoryAnswer extends ReactiveMongoRepository<Answer, String> {

}
