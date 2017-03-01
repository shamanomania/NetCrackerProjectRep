package netcracker.repository;

import netcracker.domain.entities.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sid775 on 06.02.2017.
 */
@SuppressWarnings("unchecked")
@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
    @Query("select q from Question q where q.title = :title")
    Question findByTitle(@Param("title") String title);

    @Override
    List<Question> findAll();

    @Override
    Question save(Question question);

}
