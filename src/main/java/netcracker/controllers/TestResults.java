package netcracker.controllers;

import netcracker.repository.PersonTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView getTestListPageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        model.setViewName("testResults");
        modelMap.put("tests", personTestRepository.findTestByTestCompanyId(603L));
        return model;
    }
}
