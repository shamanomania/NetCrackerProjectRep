package netcracker.controllers;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sid775 on 10.03.2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomePage() {
        return "home";
    }

    @RequestMapping("/ide")
    public String getIDEPage(){
        return "ide";
    }

}
