package netcracker;


import javax.faces.bean.ManagedBean;

/**
 * Created by Мария on 24.02.2017.
 */
@ManagedBean (name = "editor")
public class EditorBean {
    private String value = "!";

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
