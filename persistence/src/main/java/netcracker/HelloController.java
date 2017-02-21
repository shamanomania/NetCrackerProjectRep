package netcracker;

import netcracker.domain.entities.UserTest;
import netcracker.repository.CertificateRepository;
import netcracker.services.ICertificateService;
import netcracker.services.IUserTestService;
import netcracker.services.impl.CertificateService;
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
    public HelloController(IUserTestService iUserTestService,ICertificateService iCertificateService) {
        Assert.notNull(iUserTestService);
        this.iUserTestService = iUserTestService;

        Assert.notNull(iCertificateService);
        this.iCertificateService = iCertificateService;
    }



    @RequestMapping("/")
    public String index() {
        String getAllResult = null;
        //For print List (var might be StringBuilder!!!)
        for (int i =0; i <iUserTestService.getAll().size(); i++){
            getAllResult = getAllResult + iUserTestService.getAll().get(i).toString();
        }
        return "Hello, world!" + getAllResult;//iUserTestService.findByName("name1");//iCertificateService.findByTitle("title1").toString();
    }


    @RequestMapping("/getusers")
    public String getUsers() {
        return iUserTestService.getFirst().getName();
    }
}
