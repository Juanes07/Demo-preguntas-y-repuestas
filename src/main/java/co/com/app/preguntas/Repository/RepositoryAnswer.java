//paquetes
package co.com.app.preguntas.Repository;
//librerias
import co.com.app.preguntas.collection.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

//Repositorio de rspuestas
@Repository
public interface RepositoryAnswer extends ReactiveMongoRepository<Answer, String> {

}
