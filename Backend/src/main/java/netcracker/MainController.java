package netcracker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sid775 on 21.02.2017.
 */
@RestController
public class MainController {
    @RequestMapping("/index")
    public String index(){
        return "111";
    }
}
