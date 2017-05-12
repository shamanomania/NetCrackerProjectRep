package netcracker.controllers;

import netcracker.services.impl.TestService;
import netcracker.viewsForms.jsonMap.testCreate.JsonTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Sid775 on 05.05.2017.
 */
@Controller
public class TestCreateController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/tests/create", method = RequestMethod.GET)
    public ModelAndView getTestCreatePageGET(){
        ModelAndView model = new ModelAndView();
        model.setViewName("test_create");
        return model;
    }


    @RequestMapping(value = "/tests/create",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String getTestCreatePageJSON(@RequestBody JsonTest test){
        ModelAndView model = new ModelAndView();
        model.setViewName("test_create");
        //System.out.println(test.getQuestions().get(0).getRightAnswers());
        //System.out.println(test.toString());
        System.out.println(testService.createTest(test));
        return "redirect:/tests";
    }
}
