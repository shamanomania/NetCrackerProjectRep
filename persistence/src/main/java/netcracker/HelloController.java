package netcracker;

import netcracker.domain.entities.UserTest;
import netcracker.services.ICertificateService;
import netcracker.services.IUserTestService;
import netcracker.services.impl.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private IUserTestService iUserTestService;
    private ICertificateService iCertificateService;

    @Autowired
    public HelloController(IUserTestService iUserTestService) {
        Assert.notNull(iUserTestService);
        this.iUserTestService = iUserTestService;
    }



    @RequestMapping("/")
    public String index() {
        return "Hello, world!" + iCertificateService.findByTitle("1");
    }


//    @RequestMapping("/getusers")
//    public String getUsers() {
//        return iUserTestService.getFirst().getName();
//    }
}
