package com.netcracker.services.impl;

import com.netcracker.domain.entities.UserTest;
import com.netcracker.repository.UserRepository;
import com.netcracker.services.IUserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;

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
