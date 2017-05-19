package netcracker.controllers.socialcontrollers;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.apis.VkontakteApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.oauth.OAuthService;
import netcracker.domain.entities.Person;
import netcracker.repository.PersonRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by sivko on 18.05.2017.
 */

@Controller
@RequestMapping("/vk")
public class VKAuthController {
    @Value("${social-vkontakte.client-id}")
    private String clientId;
    @Value("${social-vkontakte.client-secret}")
    private String clientSecret;
    @Value("${social-vkontakte.redirectCallBackUri}")
    private String redirectCallBackUri;
    @Value("${social-vkontakte.scope}")
    private String scope;
    @Value("${social-vkontakte.redirectuserProfileUri}")
    private String userProfileUri;


    private static Logger logger = LoggerFactory.getLogger(VKAuthController.class);
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public void vkLogin(HttpServletRequest request, HttpServletResponse         response) throws IOException {
        final String secretState = "secret" + new Random().nextInt(999_999);
        request.getSession().setAttribute("SECRET_STATE", secretState);

        OAuth20Service service = new ServiceBuilder()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(redirectCallBackUri)
                .grantType("authorization_code")
                .build(VkontakteApi.instance());

        String authorizationUrl = service.getAuthorizationUrl();
        logger.info("redirectURL:{}", authorizationUrl);

        response.sendRedirect(authorizationUrl);
    }

    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback(@RequestParam(value = "code", required = false) String code,
                          // @RequestParam(value = "state", required = false) String state,
                           HttpServletRequest request, ModelMap model) throws IOException {

        OAuth20Service service = new ServiceBuilder()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(redirectCallBackUri)
                .grantType("authorization_code")
                .build(VkontakteApi.instance());

        final Verifier verifier = new Verifier(code);

        OAuth2AccessToken accessToken = service.getAccessToken(verifier);
        //final Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);

        final OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, userProfileUri,service);
        service.signRequest(accessToken, oauthRequest);
        final Response resourceResponse = oauthRequest.send();

        logger.info("code:{}", resourceResponse.getCode());
        logger.info("body:{}", resourceResponse.getBody());
        logger.info("message:{}",resourceResponse.getMessage());

        final JSONObject obj = new JSONObject(resourceResponse.getBody());

        final String userId = obj.getString("uid");
        final String first_name = obj.getString("first_name");
        final String last_name = obj.getString("last_name");

        if (personRepository.findOne(Long.parseLong(userId)) != null) {
            request.getSession().setAttribute("VK_ACCESS_TOKEN", accessToken);
            model.addAttribute("user", personRepository.findOne(Long.parseLong(userId)));
            final Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user instanceof Person) {
                return "account";
            } else {
                return "/personalarea";
            }
        } else {
            final Person user = new Person();
            user.setFirstName(first_name);
            user.setLastName(last_name);
            model.addAttribute("user", user);
            return "/registration";
        }
    }
}
