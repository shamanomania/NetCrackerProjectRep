package netcracker.services.currentuser;

import netcracker.domain.entities.CurrentUser;
import netcracker.domain.entities.RoleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Sid775 on 12.03.2017.
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && ("ADMIN".equals(currentUser.getRole().toString()) || currentUser.getId().equals(userId));
    }
}
