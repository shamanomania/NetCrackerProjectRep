package netcracker.repository;

import netcracker.domain.entities.Question;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sid775 on 06.02.2017.
 */
public interface QuestionRepository extends CrudRepository<Question,Long> {
}
