package netcracker.controllers;

import netcracker.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sid775 on 01.05.2017.
 */
@Controller
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @RequestMapping("/test/{id}")
    public ModelAndView getTestPage(@PathVariable Long id, ModelMap modelMap){

        ModelAndView model = new ModelAndView();
        model.setViewName("test");
        modelMap.put("test",testRepository.findOne(id));
        return model;
    }
}
