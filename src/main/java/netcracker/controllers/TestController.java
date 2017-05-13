package netcracker.controllers;

import netcracker.repository.TestRepository;
import netcracker.services.impl.TestService;
import netcracker.viewsForms.jsonMap.test.JsonResponse;
import netcracker.viewsForms.jsonMap.test.JsonTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



/**
 * Created by Sid775 on 01.05.2017.
 */
@Controller
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public ModelAndView getTestPageGET(@PathVariable Long id, ModelMap modelMap){

        ModelAndView model = new ModelAndView();
        model.setViewName("test");
        modelMap.put("test",testRepository.findOne(id));
        return model;
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public @ResponseBody JsonResponse getTestPage(@PathVariable Long id, @RequestBody JsonTest test, ModelMap modelMap){
        JsonResponse response  = testService.testPassTest(test);


        //response.setResult("SUCCESS");
        //response = testService.passTest(test);
        return response;
    }

}
