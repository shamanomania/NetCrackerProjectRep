package netcracker.controllers;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sid775 on 10.03.2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView getHomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("home");
        return model;
    }

    @RequestMapping("/ide")
    public String getIDEPage(){
        return "ide";
    }

    @RequestMapping("/ide2")
    public String getIDE2Page(){
        return "ide2";
    }

}
