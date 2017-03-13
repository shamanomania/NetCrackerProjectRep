package netcracker.formEntity;

import netcracker.domain.entities.RoleEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Sid775 on 10.03.2017.
 */
public class UserCreateForm {

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private RoleEnum role = RoleEnum.USER;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public RoleEnum getRole() {return role;}
}
