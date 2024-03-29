package netcracker.controllers;

import netcracker.domain.entities.CurrentUser;
import netcracker.repository.PersonTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestResults {

    private final PersonTestRepository personTestRepository;

    @Autowired
    public TestResults(PersonTestRepository personTestRepository) {
        this.personTestRepository = personTestRepository;
    }

    @RequestMapping(value = "/testresults", method = RequestMethod.GET)
    public ModelAndView getResultOfTestsPageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long companyId = currentUser.getUser().getCompany().getId();
        model.setViewName("testResults");
        modelMap.put("tests", personTestRepository.findTestByTestCompanyId(companyId));
        return model;
    }
}
