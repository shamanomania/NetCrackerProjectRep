package netcracker.controllers;

import netcracker.domain.entities.Company;
import netcracker.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CompanyInfoController {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyInfoController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public ModelAndView getCompanyInfoPageGET(@PathVariable Long id, ModelMap map){
        ModelAndView model = new ModelAndView();
        Company company = companyRepository.findOne(id);
        model.setViewName("companyForUsers");
        map.put("company", company);
        return model;
    }
}
