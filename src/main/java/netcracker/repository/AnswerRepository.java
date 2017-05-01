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
@SuppressWarnings("unchecked")
@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {

    List<Answer> findAnswersByQuestionId(Long id);

    @Override
    Answer save(Answer answer);



}
