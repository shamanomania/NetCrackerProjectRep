package netcracker.services.impl;

import netcracker.domain.entities.UserTest;
import netcracker.repository.UserRepository;
import netcracker.services.IUserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.util.List;

//TODO: Leave only service or repository for working with DB entities
@Service
public class UserTestService implements IUserTestService {

    private UserRepository userRepository;

    @Autowired
    public UserTestService(UserRepository userRepository){
        Assert.notNull(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public List<UserTest> getAll() {
        return null;
    }

    @Override
    public UserTest getFirst() {
        return userRepository.findAll().iterator().next();
    }

    @Override
    public List<UserTest> getByName() {
        return null;
    }
}
