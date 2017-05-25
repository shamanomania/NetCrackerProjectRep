package netcracker.services.impl;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.domain.entities.Role;
import netcracker.viewsForms.UserCreateForm;
import netcracker.repository.PersonRepository;
import netcracker.services.IPersonService;
import netcracker.viewsForms.jsonMap.JsonUserData;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public Person findById(Long id) {return personRepository.findOne(id);}

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getFirst() {
        return personRepository.findAll().iterator().next();
    }

    @Override
    public Person findByEmail(String mail) {return personRepository.findByMail(mail);}

    @Override
    public Person create(UserCreateForm form) {
        Person user = new Person();
        Role role = new Role();
        user.setEmail(form.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
//        user.setPassword(form.getPassword());
        role.setId(Long.parseLong(form.getRole()));
        user.setRole(role);
        return personRepository.save(user);
    }

    public Person changeUserInfo(JsonUserData jsonUserData){
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person person = new Person();
        person = currentUser.getUser();
        person.setFirstName(jsonUserData.getFirstName());
        person.setLastName(jsonUserData.getLastName());
        person.setEmail(jsonUserData.getEmail());
        person.setAddress(jsonUserData.getAddress());
        person.setEducation(jsonUserData.getEducation());
        return personRepository.save(person);
    }
}
