package studio.clover.data.storage;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.model.User;

public interface UserSharedPreferences {

    void saveAccessToken(AccessToken token);

    AccessToken getAccessToken();

    void saveUser(User user);
}
