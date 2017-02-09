package netcracker.services;

import netcracker.domain.entities.UserTest;

import java.util.List;

public interface IUserTestService {
    public List<UserTest> getAll();
    public UserTest findByName(String name);
    public UserTest getFirst();

}
