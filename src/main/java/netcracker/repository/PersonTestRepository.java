package netcracker.repository;

import netcracker.domain.entities.PersonTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sid775 on 14.05.2017.
 */
@Repository
public interface PersonTestRepository extends CrudRepository<PersonTest,Long> {

    List<PersonTest> findByPersonId(Long id);

}
