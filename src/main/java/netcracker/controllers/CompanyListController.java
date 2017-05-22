package netcracker.controllers;

import netcracker.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sid775 on 20.05.2017.
 */
@Controller
public class CompanyListController {

    final
    CompanyRepository companyRepository;

    @Autowired
    public CompanyListController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public ModelAndView getCompaniesListPageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        model.setViewName("companies");
        modelMap.put("companies",companyRepository.findAll());
        return model;
    }
}
