package clover.studio.domain.usecase.login;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.model.LoginResult;
import clover.studio.domain.model.User;
import clover.studio.domain.repository.UserRepository;
import rx.Completable;

public final class LoginUserUseCaseImpl implements LoginUserUseCase {

    private final UserRepository userRepository;

    public LoginUserUseCaseImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Completable execute(final Request request) {
        return userRepository.loginUser(request.username, request.password)
                             .doOnSuccess(this::validateLoginResult)
                             .flatMapCompletable(this::saveLoginData);
    }

    private void validateLoginResult(final LoginResult result) {
        if (AccessToken.EMPTY.equals(result.accessToken)) {
            throw new IllegalStateException("Access token is empty");

        } else if (User.EMPTY.id.equals(result.user.id)) {
            throw new IllegalArgumentException("User ID is empty");

        } else if (User.EMPTY.userId.equals(result.user.userId)) {
            throw new IllegalArgumentException("UserId is empty");
        }
    }

    private Completable saveLoginData(final LoginResult result) {
        return Completable.merge(userRepository.saveAccessToken(result.accessToken),
                                 userRepository.saveUser(result.user));
    }
}
