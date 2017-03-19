package netcracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by Sid775 on 10.03.2017.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }*/

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
