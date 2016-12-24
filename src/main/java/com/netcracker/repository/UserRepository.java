package com.netcracker.repository;

import com.netcracker.domain.entities.UserTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserTest, Long> {
    List<UserTest> findByName(String name);
}
