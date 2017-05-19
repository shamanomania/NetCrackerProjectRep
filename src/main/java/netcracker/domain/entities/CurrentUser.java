package netcracker.domain.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sid775 on 12.03.2017.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    public static final List<GrantedAuthority> DEFAULT_ROLES;

    static {
        DEFAULT_ROLES = new ArrayList<GrantedAuthority>(1);
        GrantedAuthority defaultRole = new SimpleGrantedAuthority("USER");
        DEFAULT_ROLES.add(defaultRole);
    }

    private Person user;

    public CurrentUser(Person user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().getTitle()/*user.getRoleEnum().toString()*/));
        System.out.println(user.getEmail() + "  " + user.getPassword() + "  " + user.getRole());
        this.user = user;
    }

    public Person getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

/*    public RoleEnum getRoleEnum() {
        return user.getRoleEnum();
    }

    public Role getRole(){return user.getRole();}

    public String getFirstName(){return user.getFirstName();}*/

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }

    public Role getRole() {
        return user.getRole();
    }
}
