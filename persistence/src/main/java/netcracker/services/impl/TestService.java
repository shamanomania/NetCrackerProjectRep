package netcracker.services.impl;

import netcracker.domain.entities.Test;
import netcracker.repository.TestRepository;
import netcracker.services.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
public class TestService implements ITestService {

    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository){
        Assert.notNull(testRepository);
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Test getFirst() {
        return testRepository.findAll().iterator().next();
    }
}
