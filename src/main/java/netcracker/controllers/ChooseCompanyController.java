package netcracker.controllers;

import netcracker.repository.CompanyRepository;
import netcracker.services.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ChooseCompanyController {

    private CompanyRepository companyRepository;

    private CompanyService companyService;

    @Autowired
    public ChooseCompanyController(CompanyRepository companyRepository, CompanyService companyService) {
        this.companyRepository = companyRepository;
        this.companyService = companyService;
    }

    @RequestMapping(value = "/choosecompany", method = RequestMethod.GET)
    public ModelAndView getChooseCompanyPageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        modelMap.put("companies",companyRepository.findAll());
        model.setViewName("chooseCompany");
        return  model;
    }

    @RequestMapping(value = "/choosecompany", method = RequestMethod.POST)
    public String getChooseCompanyPagePOST(HttpServletRequest request, ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        modelMap.put("companies",companyRepository.findAll());
        companyService.attachUserToCompany(Long.valueOf(request.getParameter("companyId")));
        model.setViewName("chooseCompany");
        return  "redirect:/user";
    }
}
