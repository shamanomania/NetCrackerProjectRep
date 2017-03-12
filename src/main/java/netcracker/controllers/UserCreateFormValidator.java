package netcracker.controllers;

import netcracker.formEntity.UserCreateForm;
import netcracker.services.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
import java.lang.*;

/**
 * Created by Sid775 on 10.03.2017.
 */
@Component
public class UserCreateFormValidator implements Validator {

    private final PersonService userService;

    @Autowired
    public UserCreateFormValidator(PersonService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        if (userService.findByEmail(form.getEmail()) != null/*.isPresent()*/) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }
}
