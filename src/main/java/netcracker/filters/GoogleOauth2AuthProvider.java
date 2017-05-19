package netcracker.filters;

import netcracker.domain.entities.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by sivko on 16.05.2017.
 */
public class GoogleOauth2AuthProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(GoogleOauth2AuthProvider.class);

    @Autowired(required = true)
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("Provider Manager Executed");
        CustomOAuth2AuthenticationToken token = (CustomOAuth2AuthenticationToken) authentication;
        CurrentUser registeredUser = (CurrentUser) token.getPrincipal();
        try {
            registeredUser = (CurrentUser) userDetailsService
                    .loadUserByUsername(registeredUser.getUsername()/*getEmail()*/);
        } catch (UsernameNotFoundException usernameNotFoundException) {
            logger.info("User trying google/login not already a registered user. Register Him !!");
        }
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomOAuth2AuthenticationToken.class
                .isAssignableFrom(authentication);
    }
}
