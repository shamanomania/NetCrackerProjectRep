package netcracker.controllers;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.viewsForms.UserCreateForm;
import netcracker.repository.PersonRepository;
import netcracker.services.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Sid775 on 10.03.2017.
 */
@Controller
public class UserController {

    private final PersonService userService;
    private final PersonRepository personRepository;

    //private SecurityContextHolderAwareRequestWrapper securityContextHolderAwareRequestWrapper = new SecurityContextHolderAwareRequestWrapper();

    @Autowired
    public UserController(PersonService userService, PersonRepository personRepository) {
        this.userService = userService;
        this.personRepository = personRepository;
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
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = currentUser.getUser().getId();
        Person user = personRepository.findOne(id);
        model.put("loggedUser",user);
        model.put("userEmail",user.getEmail());
        /*if (securityContextHolderAwareRequestWrapper.isUserInRole("USER")){
            return "user";
        } else if (securityContextHolderAwareRequestWrapper.isUserInRole("ADMIN")){
            return "company";
        }*/
        return null;
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
