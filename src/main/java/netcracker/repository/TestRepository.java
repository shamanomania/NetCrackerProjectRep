package netcracker.repository;

import netcracker.domain.entities.Question;
import netcracker.domain.entities.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sid775 on 06.02.2017.
 */
@Repository
public interface TestRepository extends CrudRepository<Test,Long> {
    @Override
    List<Test> findAll();
}
