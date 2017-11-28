package clover.studio.domain.storage;

import clover.studio.domain.model.AccessToken;
import rx.Completable;
import rx.Single;

public interface UserRepository {

    Single<AccessToken> loginUser(String username, String password);

    Completable saveAccessToken(AccessToken token);

    Single<AccessToken> getAccessToken();
}
