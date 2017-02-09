package netcracker.services.impl;

import netcracker.domain.entities.Role;
import netcracker.repository.RoleRepository;
import netcracker.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Sid775 on 09.02.2017.
 */
public class RoleService implements IRoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        Assert.notNull(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getFirst() {
        return roleRepository.findAll().iterator().next();
    }

    @Override
    public Role findByTitle(String title) {
        return roleRepository.findByTitle(title);
    }
}
