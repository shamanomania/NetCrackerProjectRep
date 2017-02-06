package netcracker.services;

import netcracker.domain.entities.Certificate;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sid775 on 06.02.2017.
 */
public interface ICertificateService {
    public Certificate findByTitle(String title);
}
