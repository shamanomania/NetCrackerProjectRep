package netcracker.services.impl;

import netcracker.domain.entities.Role;
import netcracker.repository.RoleRepository;
import netcracker.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Sid775 on 09.02.2017.
 */
@Service
public class RoleService implements IRoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        Assert.notNull(roleRepository);
        this.roleRepository = roleRepository;
    }

}
