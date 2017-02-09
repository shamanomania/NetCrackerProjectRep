package netcracker.services;


import netcracker.domain.entities.Role;

import java.util.List;

/**
 * Created by Sid775 on 09.02.2017.
 */
public interface IRoleService {
    public List<Role> getAll();
    public Role getFirst();
    public Role findByTitle(String title);
}
