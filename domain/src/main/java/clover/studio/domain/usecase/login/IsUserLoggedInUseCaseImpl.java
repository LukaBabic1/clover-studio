package clover.studio.domain.usecase.login;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.storage.UserRepository;
import rx.Single;

public final class IsUserLoggedInUseCaseImpl implements IsUserLoggedInUseCase {

    private final UserRepository userRepository;

    public IsUserLoggedInUseCaseImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Single<Boolean> execute() {
        return userRepository.getAccessToken()
                             .map(AccessToken.EMPTY::equals)
                             .map(isEmptyToken -> !isEmptyToken);
    }
}
