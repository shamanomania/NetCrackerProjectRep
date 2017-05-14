package netcracker.services.impl;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.domain.entities.PersonTest;
import netcracker.domain.entities.Test;
import netcracker.repository.PersonRepository;
import netcracker.services.IPersonTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Sid775 on 14.05.2017.
 */
@Service
public class PersonTestService implements IPersonTestService {

    @Autowired
    PersonRepository personRepository;

    public PersonTestService() {
    }

    public PersonTest matchTestToUser(Test test,String resultOfTest){
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PersonTest personTest = new PersonTest();
        Person person = personRepository.findOne(currentUser.getId());
        personTest.setTest(test);
        personTest.setPerson(person);
        personTest.setDate( new java.sql.Date( new Date().getTime()));
        personTest.setResult(resultOfTest);
        return personTest;
    }
}
