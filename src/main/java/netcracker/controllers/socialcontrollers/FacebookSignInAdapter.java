package netcracker.controllers.socialcontrollers;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Arrays;

/**
 * Created by sivko on 14.05.2017.
 */
public class FacebookSignInAdapter implements SignInAdapter {
    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
        String loginName;
        if(connection.fetchUserProfile().getEmail()== null)
            loginName = connection.fetchUserProfile().getName().toLowerCase().replaceAll(" ","")+"@facebook.com";
        else loginName =connection.fetchUserProfile().getEmail();
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                       /* connection.fetchUserProfile().getName()*/loginName, null,
                        Arrays.asList(new SimpleGrantedAuthority("1"))));
        return null;
    }
}
