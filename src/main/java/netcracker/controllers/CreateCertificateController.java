package netcracker.controllers;

import netcracker.domain.entities.CurrentUser;
import netcracker.repository.PersonTestRepository;
import netcracker.repository.TestRepository;
import netcracker.services.impl.CertificateService;
import netcracker.viewsForms.jsonMap.sertificateCreate.JsonCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateCertificateController {

    private final PersonTestRepository personTestRepository;

    private final TestRepository testRepository;

    private final CertificateService certificateService;

    @Autowired
    public CreateCertificateController(PersonTestRepository personTestRepository, TestRepository testRepository, CertificateService certificateService) {
        this.personTestRepository = personTestRepository;
        this.testRepository = testRepository;
        this.certificateService = certificateService;
    }

    @RequestMapping(value = "/createcertificate", method = RequestMethod.GET)
    public ModelAndView getCreateSertificatePageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.setViewName("createCertificate");
        modelMap.put("tests", personTestRepository.findTestByTestCompanyId(currentUser.getUser().getCompany().getId()));
        modelMap.put("createdTests", testRepository.findByCompanyId(currentUser.getUser().getCompany().getId()));
        return model;
    }

    @RequestMapping(value = "/createcertificate", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String getCreateSertificatePagePOST(@RequestBody JsonCertificate jsonCertificate){
        ModelAndView model = new ModelAndView();
        model.setViewName("createCertificate");
        certificateService.createCertificate(jsonCertificate);
        return "redirect:/user";
    }
}
