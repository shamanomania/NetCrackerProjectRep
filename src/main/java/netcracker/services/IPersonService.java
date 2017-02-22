package netcracker.services;

import netcracker.domain.entities.Person;

import java.util.List;

/**
 * Created by Sid775 on 11.02.2017.
 */
public interface IPersonService {

    public Person findByName(String name);

    public List<Person> getAll();

    public Person getFirst();

    public List<Person> getByGender(int sex);

    public Person findByEmail(String mail);
}
