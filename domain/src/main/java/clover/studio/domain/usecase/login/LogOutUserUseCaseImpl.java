package clover.studio.domain.usecase.login;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.storage.UserRepository;
import rx.Completable;

public final class LogOutUserUseCaseImpl implements LogOutUserUseCase {

    private final UserRepository userRepository;

    public LogOutUserUseCaseImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Completable execute() {
        return userRepository.saveAccessToken(AccessToken.EMPTY);
    }
}
