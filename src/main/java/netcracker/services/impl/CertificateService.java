package netcracker.services.impl;

import netcracker.domain.entities.Certificate;
import netcracker.domain.entities.Company;
import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Test;
import netcracker.repository.CertificateRepository;
import netcracker.repository.CompanyRepository;
import netcracker.repository.TestRepository;
import netcracker.services.ICertificateService;
import netcracker.viewsForms.jsonMap.sertificateCreate.JsonCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private CompanyRepository companyRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository, TestRepository testRepository, CompanyRepository companyRepository){
        this.testRepository = testRepository;
        this.companyRepository = companyRepository;
        Assert.notNull(certificateRepository);
        this.certificateRepository = certificateRepository;
    }

    public Certificate createCertificate(JsonCertificate jsonCertificate){

        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Certificate certificate = new Certificate();
        List<Test> tests = new ArrayList<>();
        List<Certificate> certificates = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        Company company = new Company();
        company =companyRepository.findOne(currentUser.getUser().getCompany().getId());
        certificates.add(certificate);
        company.setCertificates(certificates);
        companies.add(company);
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
        certificate.setCompany(company);
        certificateRepository.save(certificate);
        System.out.println(jsonCertificate.toString());
        return certificate;
    }

}
