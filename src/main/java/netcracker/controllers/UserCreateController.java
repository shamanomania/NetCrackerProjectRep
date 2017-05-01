package netcracker.controllers;

import netcracker.services.impl.PersonService;
import netcracker.viewsForms.UserCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Sid775 on 30.04.2017.
 */
@Controller
@RequestMapping("/signup")
public class UserCreateController {

    @Autowired
    private PersonService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String signUp(ModelMap model){
        UserCreateForm userCreateForm = new UserCreateForm();
        model.put("userCreateForm",userCreateForm);
        return "user_create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSignUp(@Valid UserCreateForm userCreateForm, BindingResult result,ModelMap model){
        if (result.hasErrors()){
            return "user_create";
        }else {
            userService.create(userCreateForm);
            return "redirect:/login";
        }

    }
}
