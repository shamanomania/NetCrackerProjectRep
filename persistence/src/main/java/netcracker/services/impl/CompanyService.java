package netcracker.services.impl;

import netcracker.domain.entities.Company;
import netcracker.repository.CompanyRepository;
import netcracker.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Sid775 on 11.02.2017.
 */
@Service
public class CompanyService implements ICompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository){
        Assert.notNull(companyRepository);
        this.companyRepository = companyRepository;
    }

    @Override
    public Company findByTitle(String title) {
        return companyRepository.findByTitle(title);
    }

    @Override
    public Company findByAddres(String addres) {
        return companyRepository.findByAddress(addres);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getFirst() {
        return companyRepository.findAll().iterator().next();
    }
}
