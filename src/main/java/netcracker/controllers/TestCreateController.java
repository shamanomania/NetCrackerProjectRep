package netcracker.controllers;

import netcracker.repository.TestRepository;
import netcracker.services.impl.TestService;
import netcracker.viewsForms.jsonMap.test.JsonResponse;
import netcracker.viewsForms.jsonMap.testCreate.JsonTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


/**
 * Created by Sid775 on 05.05.2017.
 */
@Controller
public class TestCreateController {

    final
    TestService testService;

    @Autowired
    public TestCreateController(TestService testService) {
        this.testService = testService;
    }

    @Autowired
    public TestRepository testRepository;

    @RequestMapping(value = "/tests/create", method = RequestMethod.GET)
    public ModelAndView getTestCreatePageGET(ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        model.setViewName("test_create");
        modelMap.put("tests", testRepository.findAll());
        modelMap.put("images", testRepository.findAll());
        return model;
    }


    @RequestMapping(value = "/tests/create",method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public @ResponseBody JsonResponse getTestCreatePageJSON(@RequestBody JsonTest test){
        ModelAndView model = new ModelAndView();
        model.setViewName("test_create");
        JsonResponse jsonResponse = new JsonResponse();
        //System.out.println(test.getQuestions().get(0).getRightAnswers());
        //System.out.println(test.toString());
        System.out.println(testService.createTest(test));
        return jsonResponse;
    }

}
