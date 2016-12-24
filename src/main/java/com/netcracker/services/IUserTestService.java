package com.netcracker.services;

import com.netcracker.domain.entities.UserTest;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface IUserTestService {
    public List<UserTest> getAll();
    public List<UserTest> getByName();
    public UserTest getFirst();
}
