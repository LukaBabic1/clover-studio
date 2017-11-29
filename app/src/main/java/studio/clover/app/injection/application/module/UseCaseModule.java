package studio.clover.app.injection.application.module;

import clover.studio.domain.storage.UserRepository;
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

    public interface Expoese {

        LoginUserUseCase provideLoginUserUseCase();
    }
}
