package netcracker.JSFManagedBeans;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Person;
import netcracker.repository.PersonRepository;
import netcracker.services.impl.PersonService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Мария on 24.02.2017.
 */
@ManagedBean (name = "editor")
@RequestScoped
public class EditorBean {
    private String value = "Main page";
    private String save = "save";
    private String update = "update";
    private String delete = "delete";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
}
