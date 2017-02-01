package netcracker.services;

import netcracker.domain.entities.UserTest;

import java.util.List;

public interface IUserTestService {
    public List<UserTest> getAll();
    public List<UserTest> getByName();
    public UserTest getFirst();
}
