package netcracker.services.impl;

import netcracker.domain.entities.Certificate;
import netcracker.domain.entities.Test;
import netcracker.repository.CertificateRepository;
import netcracker.repository.TestRepository;
import netcracker.services.ICertificateService;
import netcracker.viewsForms.jsonMap.sertificateCreate.JsonCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sid775 on 06.02.2017.
 */
@Service
public class CertificateService implements ICertificateService {

    private CertificateRepository certificateRepository;

    private TestRepository testRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository, TestRepository testRepository){
        this.testRepository = testRepository;
        Assert.notNull(certificateRepository);
        this.certificateRepository = certificateRepository;
    }

    public Certificate createCertificate(JsonCertificate jsonCertificate){
        Certificate certificate = new Certificate();
        List<Test> tests = new ArrayList<>();
        List<Certificate> certificates = new ArrayList<>();
        certificates.add(certificate);

        for (Long i : jsonCertificate.getTests()) {
            Test test = new Test();
            test = testRepository.findOne(i);
            test.setCertificates(certificates);
            tests.add(test);
            System.out.println(testRepository.findOne(i));
        }
        System.out.println(tests.toString());
        certificate.setTitle(jsonCertificate.getTitle());
        certificate.setTests(tests);
        certificateRepository.save(certificate);
        System.out.println(jsonCertificate.toString());
        return certificate;
    }

}
