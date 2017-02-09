package netcracker.repository;

import netcracker.domain.entities.UserTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserTestRepository extends CrudRepository<UserTest, Long> {
    @Query("select ut from UserTest ut where ut.name = :name")
    UserTest findByName(@Param("name") String name);

    @Override
    List<UserTest> findAll();
}
