package netcracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
