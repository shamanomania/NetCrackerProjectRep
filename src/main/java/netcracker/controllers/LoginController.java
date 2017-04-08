package netcracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sid775 on 10.03.2017.
 */
@Controller
//@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/user")
    public ModelAndView getUserPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user");
        return model;
    }

    @RequestMapping(value = "/signup")
    public ModelAndView getSingUpPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("user_create");
        return model;
    }
    /*@GetMapping("/login")
    public String login(){
        return "login";
    }*/

}
