package netcracker.repository;

import netcracker.domain.entities.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Sid775 on 06.02.2017.
 */
public interface QuestionRepository extends CrudRepository<Question,Long> {
    @Query("select q from Question q where u.title = :title")
    Question findByTitle(@Param("title") String title);

    @Override
    List<Question> findAll();
}
