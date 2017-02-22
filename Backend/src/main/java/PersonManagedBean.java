//import netcracker.domain.entities.Person;
//import netcracker.services.impl.PersonService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by Sid775 on 17.02.2017.
 */
@ManagedBean(name = "personMB")
@SessionScoped
public class PersonManagedBean {

    private String value = "111";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
