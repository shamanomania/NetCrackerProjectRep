package netcracker.controllers;

import netcracker.domain.entities.Person;
import netcracker.repository.PersonRepository;
import netcracker.repository.PersonTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserInfoController {

    private final PersonRepository personRepository;

    private final PersonTestRepository personTestRepository;

    @Autowired
    public UserInfoController(PersonRepository personRepository, PersonTestRepository personTestRepository) {
        this.personRepository = personRepository;
        this.personTestRepository = personTestRepository;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView getCompanyInfoPageGET(@PathVariable Long id, ModelMap map){
        ModelAndView model = new ModelAndView();
        Person person = personRepository.findOne(id);
        model.setViewName("userForCompany");
        map.put("user", person);
        map.put("passedTests", personTestRepository.findByPersonId(id));
        return model;
    }
}
