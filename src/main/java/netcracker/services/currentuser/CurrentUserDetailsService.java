package netcracker.services.currentuser;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.repository.PersonRepository;
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
    private final PersonRepository personRepository;

    @Autowired
    public CurrentUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Person user = personRepository.findByMail(email)
                /*.orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)))*/;
        return new CurrentUser(user);
    }
}
