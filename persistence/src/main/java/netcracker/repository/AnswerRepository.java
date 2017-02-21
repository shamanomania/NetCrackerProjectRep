package netcracker.repository;

import netcracker.domain.entities.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yaroslav on 21.02.2017.
 */
@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {
    
    @Query("select a from Answer a where a.question.id = :id")
    List<Answer> findAnswersByQuestionID(@Param("id") Long id);
    
}
