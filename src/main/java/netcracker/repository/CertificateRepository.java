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
    @Query("select c.id, c.title from Certificate c where c.title = :title ")
    Certificate findByTitle(@Param("title") String title);

    @Override
    List<Certificate> findAll();

}
