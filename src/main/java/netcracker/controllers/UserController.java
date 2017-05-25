package netcracker.controllers;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.repository.CertificateRepository;
import netcracker.repository.PersonTestRepository;
import netcracker.repository.TestRepository;
import netcracker.services.impl.PersonService;
import netcracker.viewsForms.UserCreateForm;
import netcracker.repository.PersonRepository;
import netcracker.viewsForms.jsonMap.JsonUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class UserController {

    private final PersonTestRepository personTestRepository;

    private final PersonRepository personRepository;

    private final TestRepository testRepository;

    private final CertificateRepository certificateRepository;

    private final PersonService personService;

    @Autowired
    public UserController(PersonRepository personRepository, PersonTestRepository personTestRepository, TestRepository testRepository, CertificateRepository certificateRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personTestRepository = personTestRepository;
        this.testRepository = testRepository;
        this.certificateRepository = certificateRepository;
        this.personService = personService;
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("user");
        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserPage(Map<String,Object> model) {


        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = currentUser.getUser().getId();
        Person user = personRepository.findOne(id);
        model.put("loggedUser",user);
        System.out.println(user.getCertificates());
        model.put("testsPassedByUser",personTestRepository.findByPersonId(id));

        if ("USER".equals(currentUser.getRole().getTitle())){
            return "user";
        } else if ("ADMIN".equals(currentUser.getRole().getTitle())){
            if (currentUser.getUser().getCompany() != null) {
                model.put("createdTests", testRepository.findByCompanyId(currentUser.getUser().getCompany().getId()));
                model.put("createdCertificates", certificateRepository.findByCompanyId(currentUser.getUser().getCompany().getId()));
            }
            System.out.println("company login");
            return "company";
        }
        return "login?error";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String getUserPageChange(@RequestBody JsonUserData jsonUserData){
        //response.setResult("SUCCESS");
        //response = testService.passTest(test);
        personService.changeUserInfo(jsonUserData);
        return "redirect:/user";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }



}
