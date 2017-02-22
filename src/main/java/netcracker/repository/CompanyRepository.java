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

    @Query("select c from Company c where c.title = :title")
    Company findByTitle(@Param("title") String title);

    @Query("select c from Company c where c.address = :address")
    Company findByAddress(@Param("address") String address);

    @Override
    List<Company> findAll();
}
