package netcracker.controllers;

import netcracker.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CertificateController {

    private CertificateRepository certificateRepository;

    @Autowired
    public CertificateController(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @RequestMapping(value = "/certificate/{id}", method = RequestMethod.GET)
    public ModelAndView getCertificatePage(@PathVariable Long id, ModelMap modelMap){
        ModelAndView model = new ModelAndView();
        model.setViewName("usersCertificate");
        modelMap.put("certificate",certificateRepository.findOne(id));
        return model;
    }
}
