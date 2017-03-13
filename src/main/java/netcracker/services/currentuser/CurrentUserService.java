package netcracker.services.currentuser;

import netcracker.domain.entities.CurrentUser;

/**
 * Created by Sid775 on 12.03.2017.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
