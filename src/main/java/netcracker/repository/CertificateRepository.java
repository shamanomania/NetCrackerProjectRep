package netcracker.repository;

import netcracker.domain.entities.Certificate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sid775 on 03.02.2017.
 */
@Repository
public interface CertificateRepository extends CrudRepository<Certificate, Long> {

    Certificate findByTitle(String title);

    List<Certificate> findByCompaniesId(Long id);

    @Override
    List<Certificate> findAll();

}
