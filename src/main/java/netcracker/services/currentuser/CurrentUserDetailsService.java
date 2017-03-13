package netcracker.services.currentuser;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.services.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Sid775 on 12.03.2017.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private final PersonService userService;

    @Autowired
    public CurrentUserDetailsService(PersonService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Person user = userService.findByEmail(email)
                /*.orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)))*/;
        return new CurrentUser(user);
    }
}
