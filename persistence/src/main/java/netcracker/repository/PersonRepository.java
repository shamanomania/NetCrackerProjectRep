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
    @Query("select p from Person p where p.name = :name")
    Person findByName(@Param("name") String name);

    @Query("select p from Person p where p.sex = :sex")
    List<Person> getByGender(@Param("sex") int sex);

    @Query("select p from Person p where p.mail = :mail")
    Person findByEmail(@Param("mail") String mail);

    @Override
    List<Person> findAll();
}
