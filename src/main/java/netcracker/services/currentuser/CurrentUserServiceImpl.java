package netcracker.services.currentuser;

import netcracker.domain.entities.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sid775 on 12.03.2017.
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    public static final List<GrantedAuthority> DEFAULT_ROLES;

    static {
        DEFAULT_ROLES = new ArrayList<GrantedAuthority>(1);
        GrantedAuthority defaultRole = new SimpleGrantedAuthority("USER");
        DEFAULT_ROLES.add(defaultRole);
    }

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && ("ADMIN".equals(currentUser.getRole().toString()) || currentUser.getId().equals(userId));
    }
}
