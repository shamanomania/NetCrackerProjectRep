package netcracker.JSFManagedBeans;

import netcracker.domain.entities.Person;

import javax.faces.bean.ManagedBean;

/**
 * Created by Sid775 on 07.04.2017.
 */
//@ManagedBean(name = "currentUser")
public class CurrentUserData {

    private Person user ;
    private String mail = user.getEmail();

    public void setUserMail(String mail) {
        this.user.setEmail(mail);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
