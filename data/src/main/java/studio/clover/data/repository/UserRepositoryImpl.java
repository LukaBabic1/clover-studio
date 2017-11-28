package studio.clover.data.repository;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.storage.UserRepository;
import rx.Completable;
import rx.Single;
import studio.clover.data.storage.UserSharedPreferences;

public final class UserRepositoryImpl implements UserRepository {

    private final UserSharedPreferences preferences;

    public UserRepositoryImpl(final UserSharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public Single<AccessToken> loginUser(final String username, final String password) {
        return null;
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
