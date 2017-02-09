package netcracker.repository;

import netcracker.domain.entities.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Sid775 on 06.02.2017.
 */
public interface TestRepository extends CrudRepository<Test,Long> {
    @Override
    List<Test> findAll();
}
