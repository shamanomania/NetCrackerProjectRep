package netcracker.services;

import netcracker.domain.entities.Company;

import java.util.List;

/**
 * Created by Sid775 on 11.02.2017.
 */
public interface ICompanyService {
    public Company findByTitle(String title);

    public Company findByAddres(String addres);

    List<Company> getAll();

    Company getFirst();
}
