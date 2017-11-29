package studio.clover.app.ui.login;

import javax.inject.Inject;

import clover.studio.domain.usecase.login.LoginUserUseCase;
import studio.clover.app.base.BasePresenter;
import studio.clover.data.network.NetworkErrorHandler;

public final class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Inject
    LoginUserUseCase loginUserUseCase;

    public LoginPresenter(final LoginContract.View view) {
        super(view);
    }

    @Override
    public void singIn(final String username, final String password) {
        doIfViewNotNull(LoginContract.View::showLoading);
        viewActionQueue.subscribeTo(loginUserUseCase.execute(new LoginUserUseCase.Request(username, password))
                                                    .subscribeOn(backgroundScheduler),
                                    view -> {
                                        view.hideLoading();
                                        router.showMessageScreen();
                                    },
                                    this::processLogInError);
    }

    private void processLogInError(final Throwable throwable) {
        if (throwable instanceof NetworkErrorHandler.ApiInvalidCredentialsException) {
            doIfViewNotNull(LoginContract.View::showInvalidCredentialsError);
        } else {
            doIfViewNotNull(LoginContract.View::showUnknownErrorMessage);
        }
    }
}
