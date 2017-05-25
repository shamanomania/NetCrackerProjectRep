package netcracker.controllers;

import netcracker.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sid775 on 05.05.2017.
 */
@Controller
public class TestListController {

    final
    TestRepository testRepository;

    @Autowired
    public TestListController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public ModelAndView getTestListPageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        model.setViewName("list_of_tests");
        modelMap.put("tests", testRepository.findAll());
        return model;
    }
}
