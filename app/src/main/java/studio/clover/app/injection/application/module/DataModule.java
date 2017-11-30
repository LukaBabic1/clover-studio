package studio.clover.app.injection.application.module;

import android.content.Context;

import javax.inject.Singleton;

import clover.studio.domain.repository.MessageRepository;
import clover.studio.domain.repository.UserRepository;
import dagger.Module;
import dagger.Provides;
import studio.clover.app.injection.ForApplication;
import studio.clover.data.network.client.MessageClient;
import studio.clover.data.network.client.UserClient;
import studio.clover.data.repository.MessageRepositoryImpl;
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
    MessageRepository provideMessageRepository(final MessageClient messageClient) {
        return new MessageRepositoryImpl(messageClient);
    }

    @Provides
    @Singleton
    UserSharedPreferences provideUserSharedPreferences(@ForApplication final Context context) {
        return UserSharedPreferencesImpl.create(context);
    }

    public interface Exposes {

        MessageRepository messagRepository();

        UserRepository userRepository();
    }
}
