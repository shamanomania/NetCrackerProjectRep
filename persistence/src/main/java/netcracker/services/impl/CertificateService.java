package netcracker.services.impl;

import netcracker.domain.entities.Certificate;
import netcracker.repository.CertificateRepository;
import netcracker.services.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Created by Sid775 on 06.02.2017.
 */
public class CertificateService implements ICertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    public CertificateService(CertificateRepository certificateRepository){
        Assert.notNull(certificateRepository);
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate findByTitle(String title) {
        return certificateRepository.findByTitle(title);

    }
}
