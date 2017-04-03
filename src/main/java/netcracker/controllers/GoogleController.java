package netcracker.controllers;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by sivko on 02.04.2017.
 */

@Controller
@EnableOAuth2Sso
public class GoogleController {
    @RequestMapping("/goInt")
    public String GoogleAp() {
        return "goInt";
    }
}
