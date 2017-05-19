package netcracker.controllers.socialcontrollers;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.domain.entities.Role;
import netcracker.filters.CustomOAuth2AuthenticationToken;
import netcracker.repository.PersonRepository;
import netcracker.repository.RoleRepository;
import netcracker.services.IPersonService;
import netcracker.services.impl.SecurityService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * Created by sivko on 18.05.2017.
 */


@Controller
@RequestMapping(value = "/facebook")
public class FacebookController {

    @Autowired
    private IPersonService userService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SecurityService securityService;
    private static Logger logger = LoggerFactory.getLogger(FacebookController.class);

    @Value("${social.facebook.appId}")
    private String clientId;
    @Value("${social.facebook.appSecret}")
    private String clientSecret;
    @Value("${social.facebook.redirectCallBackUri}")
    private String redirectCallBackUri;
    @Value("${social.facebook.userProfileApi}")
    private String userProfileApi;
    @Value("${social.facebook.query}")
    private String query;


    @RequestMapping(value ="/signin", method = RequestMethod.GET)
    public void fbLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("signin");

        String secretState = "secret" + new Random().nextInt(999_999);
        request.getSession().setAttribute("SECRET_STATE", secretState);

        OAuth20Service service = new ServiceBuilder()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(redirectCallBackUri)
                .grantType("authorization_code")
                .build(FacebookApi.instance());

        String authorizationUrl = service.getAuthorizationUrl();

        response.sendRedirect(authorizationUrl);
    }

    @RequestMapping(value ="/callback", method = RequestMethod.GET)
    public String callback(@RequestParam(value = "code", required = false) String code,
                           HttpServletRequest request, HttpServletResponse response, Model model) {
        logger.debug("callback");
        logger.info("code:{}", code);

        OAuth20Service service = new ServiceBuilder()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(redirectCallBackUri)
                .grantType("authorization_code")
                .build(FacebookApi.instance());



        final String requestUrl = userProfileApi + query;

        final Verifier verifier = new Verifier(code);

        OAuth2AccessToken accessToken = service.getAccessToken(verifier);

        final OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, requestUrl,service);
        service.signRequest(accessToken, oauthRequest);

        final Response resourceResponse = oauthRequest.send();

       // logger.info("code:{}", resourceResponse.getCode());
     //   logger.info("body:{}", resourceResponse.getBody());
      //  logger.info("message:{}",resourceResponse.getMessage());

       final JSONObject obj = new JSONObject(resourceResponse.getBody());
     //  logger.info("json:{}" ,obj.toString());

        String facdebookId = obj.getString("id");
        String name = obj.getString("first_name");
        String email = obj.getString("email");
        String lastname = obj.getString("last_name");

        Person person = userService.findByEmail(email);
        //Register user
        String password = randomAlphabetic(8);
        if(person == null) {
            person = new Person();
            person.setId(Long.parseLong(facdebookId));
            person.setEmail(email);
            person.setFirstName(name);
            person.setLastName(lastname);
            Role role = roleRepository.findByTitle("USER");
            person.setRole(role);
            person.setPassword(bCryptPasswordEncoder.encode(password));
            personRepository.save(person);
        }

        CurrentUser registeredUser = new CurrentUser(person);
        CustomOAuth2AuthenticationToken authenticationToken =
                new CustomOAuth2AuthenticationToken(registeredUser);

        securityService.autologin(email,password);
        return "redirect:/";
    }

}
