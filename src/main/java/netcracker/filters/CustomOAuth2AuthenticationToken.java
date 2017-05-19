package netcracker.filters;

import netcracker.domain.entities.CurrentUser;
import netcracker.services.currentuser.CurrentUserServiceImpl;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by sivko on 16.05.2017.
 */
public class CustomOAuth2AuthenticationToken extends AbstractAuthenticationToken {

    private CurrentUser registeredUser;

    public CustomOAuth2AuthenticationToken(
            Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public CustomOAuth2AuthenticationToken(CurrentUser registeredUser) {
        super(CurrentUser.DEFAULT_ROLES);
        this.registeredUser = registeredUser;
    }

    @Override
    public Object getCredentials() {
        return "NOT_REQUIRED";
    }

    @Override
    public Object getPrincipal() {
        return registeredUser;
    }


    public CurrentUser getUserDetail() {
        return registeredUser;
    }


    public void setUserDetail(CurrentUser registeredUser) {
        this.registeredUser = registeredUser;
        setDetails(registeredUser);
    }
}
