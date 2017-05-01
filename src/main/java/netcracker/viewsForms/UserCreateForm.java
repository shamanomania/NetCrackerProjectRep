package netcracker.viewsForms;


import netcracker.viewsForms.validator.FieldEquals;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Sid775 on 10.03.2017.
 */
@FieldEquals(field = "password" , equalsTo = "passwordRepeated")
public class UserCreateForm {

    @Email
    private String email = "";

    @NotEmpty(message = "Enter password!")
    @Size(min=3, message = "Password min size 3!")
    private String password = "";

    @NotEmpty(message = "Enter password approve!")
    private String passwordRepeated = "";

    private String role = "";


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
