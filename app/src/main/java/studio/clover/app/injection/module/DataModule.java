package studio.clover.app.injection.module;

import android.content.Context;

import javax.inject.Singleton;

import clover.studio.domain.storage.UserRepository;
import dagger.Module;
import dagger.Provides;
import studio.clover.app.injection.ForApplication;
import studio.clover.data.network.client.UserClient;
import studio.clover.data.repository.UserRepositoryImpl;
import studio.clover.data.storage.UserSharedPreferences;
import studio.clover.data.storage.UserSharedPreferencesImpl;

@Module
public final class DataModule {

    @Provides
    @Singleton
    UserRepository provideUserRepository(final UserClient userClient, final UserSharedPreferences userSharedPreferences) {
        return new UserRepositoryImpl(userClient, userSharedPreferences);
    }

    @Provides
    @Singleton
    UserSharedPreferences provideUserSharedPreferences(@ForApplication final Context context) {
        return UserSharedPreferencesImpl.create(context);
    }

    public interface Exposes {

        UserRepository userRepository();
    }
}
