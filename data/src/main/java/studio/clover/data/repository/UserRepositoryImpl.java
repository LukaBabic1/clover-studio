package studio.clover.data.repository;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.storage.UserRepository;
import rx.Completable;
import rx.Single;
import studio.clover.data.storage.UserSharedPreferences;

public final class UserRepositoryImpl implements UserRepository {

    private final UserSharedPreferences userSharedPreferences;

    public UserRepositoryImpl(final UserSharedPreferences userSharedPreferences) {
        this.userSharedPreferences = userSharedPreferences;
    }

    @Override
    public Completable saveAccessToken(final AccessToken token) {
        return Completable.fromAction(() -> userSharedPreferences.saveAccessToken(token));
    }

    @Override
    public Single<AccessToken> getAccessToken() {
        return Single.fromCallable(userSharedPreferences::getAccessToken);
    }
}
