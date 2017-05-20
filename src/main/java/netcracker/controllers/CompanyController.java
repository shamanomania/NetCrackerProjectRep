package netcracker.controllers;

import netcracker.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Sid775 on 20.05.2017.
 */
@Controller
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;


}
