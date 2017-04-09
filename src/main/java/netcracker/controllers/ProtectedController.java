package netcracker.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sivko on 09.04.2017.
 */
@RestController
@RequestMapping(value = "/protected")
public class ProtectedController{

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Authentication index(OAuth2Authentication authentication) {
        return authentication;
    }
}