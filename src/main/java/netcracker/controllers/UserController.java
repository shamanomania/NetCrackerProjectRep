package netcracker.controllers;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.repository.PersonTestRepository;
import netcracker.repository.TestRepository;
import netcracker.viewsForms.UserCreateForm;
import netcracker.repository.PersonRepository;
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

    @Autowired
    public UserController(PersonRepository personRepository, PersonTestRepository personTestRepository, TestRepository testRepository) {
        this.personRepository = personRepository;
        this.personTestRepository = personTestRepository;
        this.testRepository = testRepository;
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        ModelAndView model = new ModelAndView();
        model.setViewName("user");
        return model;

        /*return new ModelAndView("user", "user", userService.findById(id)
                *//*.orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id)))*//*);*/
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)//////////////////////////////////
    public String getUserPage(Map<String,Object> model) {

       /* if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass().getSimpleName().equals("String")) {
            String currName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Person user = personRepository.findByMail(currName);
            model.put("loggedUser",user);
            model.put("userEmail",user.getEmail());
            return "user";
        }*/

        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = currentUser.getUser().getId();
        Person user = personRepository.findOne(id);
        model.put("loggedUser",user);
        model.put("testsPassedByUser",personTestRepository.findByPersonId(id));

        if ("USER".equals(currentUser.getRole().getTitle())){
            return "user";
        } else if ("ADMIN".equals(currentUser.getRole().getTitle())){
            model.put("createdTests",testRepository.findByCompanyId(currentUser.getUser().getCompany().getId()));
            return "company";
        }
        return "login";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }


    //@PreAuthorize("hasAuthority('ADMIN')")
    /*@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_create";
        }
        try {
            userService.create(form);
            System.out.println(form.getEmail() + " " + form.getRole());
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }
        return "redirect:/users";
    }*/

}
