package netcracker.repository;

import netcracker.domain.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

/**
 * Created by Sid775 on 06.02.2017.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

    Person findByName(String name);

    List<Person> findBySex(int sex);

    Person findByMail(String mail);

    @Override
    List<Person> findAll();
}
