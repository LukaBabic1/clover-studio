package clover.studio.domain.repository;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.model.LoginResult;
import clover.studio.domain.model.User;
import rx.Completable;
import rx.Single;

public interface UserRepository {

    Single<LoginResult> loginUser(String username, String password);

    Completable saveAccessToken(AccessToken token);

    Single<AccessToken> getAccessToken();

    Completable saveUser(User user);
}
