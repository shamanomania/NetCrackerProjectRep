package netcracker.repository;

import netcracker.domain.entities.Images;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sid775 on 06.02.2017.
 */
@Repository
public interface ImagesRepository extends CrudRepository<Images,Long> {
}
