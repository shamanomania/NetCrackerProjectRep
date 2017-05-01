package netcracker.repository;

import netcracker.domain.entities.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sid775 on 06.02.2017.
 */
@Repository
public interface CompanyRepository extends CrudRepository<Company, Long>{

    Company findByTitle(String title);

    Company findByAddress(String address);

    @Override
    List<Company> findAll();
}
