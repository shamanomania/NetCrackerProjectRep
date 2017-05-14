package netcracker.services.impl;

import netcracker.domain.entities.Person;
import netcracker.domain.entities.Role;
import netcracker.repository.PersonRepository;
import netcracker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * Created by sivko on 14.05.2017.
 */
@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private PersonRepository userRepository;

    @Autowired
    Facebook facebook;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public String execute(Connection<?> connection) {
        Person user = new Person();
        user.setFirstName(connection.fetchUserProfile().getFirstName());
        user.setLastName(connection.fetchUserProfile().getLastName());
        UserProfile profile = connection.fetchUserProfile();
        ConnectionKey connectionKey = connection.getKey();
        String usn = connectionKey.getProviderUserId();
        String email = profile.getEmail();
        if(email == null) {
            user.setEmail(connection.fetchUserProfile().getName().toLowerCase().replaceAll(" ","")+"@facebook.com");
        }else user.setEmail(email);

        if(!(userRepository.findByMail(user.getEmail())==null)){
            return userRepository.findByMail(user.getEmail()).toString();
        }
        user.setPassword(bCryptPasswordEncoder.encode(randomAlphabetic(8)));
        Role role = roleRepository.findByTitle("USER");
        user.setRole(role);
        userRepository.save(user);
        return user.toString();
    }
}
