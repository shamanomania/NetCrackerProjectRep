package netcracker.services.impl;

import netcracker.domain.entities.Person;
import netcracker.repository.PersonRepository;
import netcracker.services.IPersonService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Sid775 on 11.02.2017.
 */
@Service
public class PersonService implements IPersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        Assert.notNull(personRepository);
        this.personRepository = personRepository;
    }

    @Override
    public Person findByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getFirst() {
        return personRepository.findAll().iterator().next();
    }

    @Override
    public List<Person> getByGender(int sex) {
        return personRepository.getByGender(sex);
    }

    @Override
    public Person findByEmail(String mail) {
        return personRepository.findByEmail(mail);
    }
}
