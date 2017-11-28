package studio.clover.data.storage;

import clover.studio.domain.model.AccessToken;

public interface UserSharedPreferences {

    void saveAccessToken(AccessToken token);

    AccessToken getAccessToken();
}
