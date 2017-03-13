package netcracker.controllers;

import netcracker.services.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sid775 on 10.03.2017.
 */
@Controller
public class UsersController {

    private final PersonService userService;

    @Autowired
    public UsersController(PersonService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        return new ModelAndView("users", "users", userService.getAll());
    }

}
