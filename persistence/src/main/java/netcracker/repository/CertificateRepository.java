package netcracker.repository;

import netcracker.domain.entities.Certificate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Sid775 on 03.02.2017.
 */
public interface CertificateRepository extends CrudRepository<Certificate, Long> {
    @Query("select c from Certificate c where c.Title = :Title")
    Certificate findByTitle(@Param("Title") String Title);
}
