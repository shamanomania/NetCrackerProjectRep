package netcracker.domain.entities;

import netcracker.JSFManagedBeans.CurrentUserData;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Sid775 on 12.03.2017.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Person user;
    private CurrentUserData currentUserData;

    public CurrentUser(Person user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().getTitle()/*user.getRoleEnum().toString()*/));
        System.out.println(user.getEmail() + "  " + user.getPassword() + "  " + user.getRoleEnum().toString());
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

    public Role getRole(){return user.getRole();}

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
