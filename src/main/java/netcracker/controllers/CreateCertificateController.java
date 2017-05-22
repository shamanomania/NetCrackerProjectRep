package netcracker.controllers;

import netcracker.domain.entities.CurrentUser;
import netcracker.repository.PersonTestRepository;
import netcracker.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateCertificateController {

    private final PersonTestRepository personTestRepository;

    private final TestRepository testRepository;

    @Autowired
    public CreateCertificateController(PersonTestRepository personTestRepository, TestRepository testRepository) {
        this.personTestRepository = personTestRepository;
        this.testRepository = testRepository;
    }

    @RequestMapping(value = "/createsertificate", method = RequestMethod.GET)
    public ModelAndView getCreateSertificatePageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.setViewName("createCertificate");
        modelMap.put("tests", personTestRepository.findTestByTestCompanyId(currentUser.getUser().getCompany().getId()));
        modelMap.put("createdTests", testRepository.findByCompanyId(currentUser.getUser().getCompany().getId()));
        return model;
    }
}
