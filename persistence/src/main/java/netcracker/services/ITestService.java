package netcracker.services;

import netcracker.domain.entities.Test;

import java.util.List;

/**
 * Created by Sid775 on 02.02.2017.
 */
public interface ITestService {
    public List<Test> getAll();
    public Test getFirst();
}
