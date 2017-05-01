package netcracker.JSFManagedBeans;

import netcracker.domain.entities.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;

/**
 * Created by Sid775 on 07.04.2017.
 */

public class CurrentUserData {

    private CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    private Long id = currentUser.getUser().getId();
    private String mail = currentUser.getUser().getEmail();
    private String firstName = currentUser.getUser().getFirstName();
    private String lastName = currentUser.getUser().getLastName();

    public Long getId() { return id; }

    public String getMail() { return mail; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }
}
