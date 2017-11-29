package studio.clover.app.injection.application.module;

import clover.studio.domain.storage.UserRepository;
import clover.studio.domain.usecase.login.IsUserLoggedInUseCase;
import clover.studio.domain.usecase.login.IsUserLoggedInUseCaseImpl;
import clover.studio.domain.usecase.login.LogOutUserUseCase;
import clover.studio.domain.usecase.login.LogOutUserUseCaseImpl;
import clover.studio.domain.usecase.login.LoginUserUseCase;
import clover.studio.domain.usecase.login.LoginUserUseCaseImpl;
import dagger.Module;
import dagger.Provides;

@Module
public final class UseCaseModule {

    @Provides
    LoginUserUseCase provideLoginUserUseCase(final UserRepository userRepository) {
        return new LoginUserUseCaseImpl(userRepository);
    }

    @Provides
    IsUserLoggedInUseCase provideIsUserLoggedInUseCase(final UserRepository userRepository) {
        return new IsUserLoggedInUseCaseImpl(userRepository);
    }

    @Provides
    LogOutUserUseCase provideLogOutUserUseCase(final UserRepository userRepository) {
        return new LogOutUserUseCaseImpl(userRepository);
    }

    public interface Expoese {

        LoginUserUseCase provideLoginUserUseCase();

        IsUserLoggedInUseCase isUserLoggedInUseCase();

        LogOutUserUseCase logOutUserUseCase();
    }
}
