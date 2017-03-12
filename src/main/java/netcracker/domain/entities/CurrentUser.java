package netcracker.domain.entities;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Sid775 on 12.03.2017.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Person user;

    public CurrentUser(Person user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Person getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public RoleEnum getRoleEnum() {
        return user.getRoleEnum();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
