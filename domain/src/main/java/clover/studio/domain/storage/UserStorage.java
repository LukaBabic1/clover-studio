package clover.studio.domain.storage;

import clover.studio.domain.model.AccessToken;

public interface UserStorage {

    void saveAccessToken(AccessToken token);

    AccessToken getAccessToken();
}
