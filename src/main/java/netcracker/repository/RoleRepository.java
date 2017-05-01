package netcracker.repository;

import netcracker.domain.entities.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sid775 on 06.02.2017.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

    Role findByTitle(String title);

    @Override
    List<Role> findAll();
}
