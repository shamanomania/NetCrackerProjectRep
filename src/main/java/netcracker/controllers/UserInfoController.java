package netcracker.controllers;

import netcracker.domain.entities.Person;
import netcracker.repository.PersonRepository;
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

    @Autowired
    public UserInfoController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView getCompanyInfoPageGET(@PathVariable Long id, ModelMap map){
        ModelAndView model = new ModelAndView();
        Person person = personRepository.findOne(id);
        model.setViewName("userForCompany");
        map.put("user", person);
        return model;
    }
}
