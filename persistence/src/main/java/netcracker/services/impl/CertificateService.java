package netcracker.services.impl;

import netcracker.domain.entities.Certificate;
import netcracker.repository.CertificateRepository;
import netcracker.services.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Sid775 on 06.02.2017.
 */
@Service
public class CertificateService implements ICertificateService {

    private static final Logger log = Logger.getLogger(CertificateService.class);


    private CertificateRepository certificateRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository){
        Assert.notNull(certificateRepository);
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate findByTitle(String title) {
        log.info("Start query");
        log.info("Найден обект с title:   " + title);
        return certificateRepository.findByTitle(title);
    }

    @Override
    public List<Certificate> getAll() {
        return certificateRepository.findAll();
    }

    @Override
    public Certificate getFirst() {
        return certificateRepository.findAll().iterator().next();
    }
}
