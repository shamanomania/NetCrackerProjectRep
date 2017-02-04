package netcracker.repository;

import netcracker.domain.entities.Certificate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CertificateRepository extends CrudRepository<Certificate, Long> {
    /*List<Certificate> findByName(String Title);*/
}
