package clover.studio.domain.usecase;

import clover.studio.domain.storage.UserRepository;

public final class LoginUserUseCaseImpl implements LoginUserUseCase {

    private final UserRepository userRepository;

    public LoginUserUseCaseImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
