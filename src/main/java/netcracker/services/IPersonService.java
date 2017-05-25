package netcracker.services;

import netcracker.domain.entities.Person;
import netcracker.viewsForms.UserCreateForm;

import java.util.List;

/**
 * Created by Sid775 on 11.02.2017.
 */
public interface IPersonService {

    public Person findById(Long id);


    public List<Person> getAll();

    public Person getFirst();

    public Person findByEmail(String mail);

    Person create(UserCreateForm form);
}
