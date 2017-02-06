package netcracker.repository;

import netcracker.domain.entities.UserTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTestRepository extends CrudRepository<UserTest, Long> {
    List<UserTest> findByName(String name);
}
