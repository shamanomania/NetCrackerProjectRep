package netcracker;

import netcracker.services.IUserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private IUserTestService iUserTestService;

    @Autowired
    public HelloController(IUserTestService iUserTestService) {
        Assert.notNull(iUserTestService);
        this.iUserTestService = iUserTestService;
    }

    @RequestMapping("/")
    public String index() {
        return "Hello, world!";
    }

//    @RequestMapping("/getusers")
//    public String getUsers() {
//        return iUserTestService.getFirst().getName();
//    }
}
