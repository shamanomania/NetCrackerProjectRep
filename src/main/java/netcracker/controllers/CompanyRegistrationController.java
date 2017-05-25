package netcracker.controllers;

import netcracker.domain.entities.Company;
import netcracker.services.impl.CompanyService;
import netcracker.viewsForms.CompanyCreateForm;
import netcracker.viewsForms.UserCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CompanyRegistrationController {

    private CompanyService companyService;

    @Autowired
    public CompanyRegistrationController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/companyregistration", method = RequestMethod.GET)
    public ModelAndView getCompanyRegistrationPageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        CompanyCreateForm companyCreateForm = new CompanyCreateForm();
        modelMap.put("companyCreateForm",companyCreateForm);
        model.setViewName("companyRegistration");
        return model;
    }

    @RequestMapping(value = "/companyregistration", method = RequestMethod.POST)
    public String processSignUp(@Valid CompanyCreateForm companyCreateForm, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            return "companyRegistration";
        }else {
            Company company = companyService.create(companyCreateForm);
            companyService.attachUserToCompany(company.getId());
            return "redirect:/user";
        }

    }

}
