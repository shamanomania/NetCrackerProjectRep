package netcracker.repository;

import netcracker.domain.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Locale;

/**
 * Created by Sid775 on 06.02.2017.
 */
public interface PersonRepository extends CrudRepository<Person,Long> {
}
