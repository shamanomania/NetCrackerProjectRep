package netcracker.controllers;

import netcracker.viewsForms.UserCreateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CompanyRegistrationController {

    @RequestMapping(value = "/companyregistration", method = RequestMethod.GET)
    public ModelAndView getCompanyRegistrationPageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        UserCreateForm userCreateForm = new UserCreateForm();
        modelMap.put("userCreateForm",userCreateForm);
        model.setViewName("companyRegistration");
        return model;
    }

    @RequestMapping(value = "/companyregistration", method = RequestMethod.POST)
    public String processSignUp(@Valid UserCreateForm userCreateForm, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            return "companyRegistration";
        }else {
            return "user";
        }

    }

}
