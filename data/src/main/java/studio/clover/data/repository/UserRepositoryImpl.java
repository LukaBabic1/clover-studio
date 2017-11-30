package studio.clover.data.repository;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.model.LoginResult;
import clover.studio.domain.model.User;
import clover.studio.domain.repository.UserRepository;
import rx.Completable;
import rx.Single;
import studio.clover.data.network.client.UserClient;
import studio.clover.data.storage.UserSharedPreferences;

public final class UserRepositoryImpl implements UserRepository {

    private static final String ORGANIZATION = "clover";

    private final UserClient userClient;
    private final UserSharedPreferences preferences;

    public UserRepositoryImpl(final UserClient userClient, final UserSharedPreferences preferences) {
        this.userClient = userClient;
        this.preferences = preferences;
    }

    @Override
    public Single<LoginResult> loginUser(final String username, final String password) {
        return userClient.loginUser(ORGANIZATION, username, password);
    }

    @Override
    public Completable saveUser(final User user) {
        return Completable.fromAction(() -> preferences.saveUser(user));
    }

    @Override
    public Completable saveAccessToken(final AccessToken token) {
        return Completable.fromAction(() -> preferences.saveAccessToken(token));
    }

    @Override
    public Single<AccessToken> getAccessToken() {
        return Single.fromCallable(preferences::getAccessToken);
    }
}
