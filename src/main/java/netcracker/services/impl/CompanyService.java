package netcracker.services.impl;

import netcracker.domain.entities.Company;
import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.Images;
import netcracker.domain.entities.Person;
import netcracker.repository.CompanyRepository;
import netcracker.repository.PersonRepository;
import netcracker.services.ICompanyService;
import netcracker.viewsForms.CompanyCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sid775 on 11.02.2017.
 */
@Service
public class CompanyService implements ICompanyService {

    private CompanyRepository companyRepository;

    private PersonRepository personRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    public CompanyService(CompanyRepository companyRepository, PersonRepository personRepository){
        this.personRepository = personRepository;
        Assert.notNull(companyRepository);
        this.companyRepository = companyRepository;
    }


    public Company create(CompanyCreateForm companyCreateForm){
        Company company = new Company();
        List<Company> companyies = new ArrayList<>();
        companyies.add(company);
        company.setName(companyCreateForm.getName());
        company.setTitle(companyCreateForm.getTitle());
        company.setAddress(companyCreateForm.getAddress());
        Images image = imageService.findTop();
        image.setCompanies(companyies);
        company.setImage(image);
        System.out.println(companyCreateForm.getName()+ companyCreateForm.getTitle()+companyCreateForm.getAddress());
        companyRepository.save(company);
        return company;
    }

    public void attachUserToCompany(Long id){
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Person user = new Person();
        user = currentUser.getUser();
        user.setCompany(companyRepository.findOne(id));
        System.out.println(currentUser.getUser().toString());
        personRepository.save(user);
    }

}
