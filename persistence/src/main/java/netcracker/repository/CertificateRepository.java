package netcracker.repository;

import netcracker.domain.entities.Certificate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Sid775 on 03.02.2017.
 */
public interface CertificateRepository extends CrudRepository<Certificate, Long> {
    List<Certificate> findByName(String Title);
}
