package clover.studio.domain.storage;

import clover.studio.domain.model.AccessToken;
import rx.Completable;
import rx.Single;

public interface UserRepository {

    Completable saveAccessToken(AccessToken token);

    Single<AccessToken> getAccessToken();
}
