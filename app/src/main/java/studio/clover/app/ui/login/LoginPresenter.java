package studio.clover.app.ui.login;

import studio.clover.app.base.BasePresenter;

public final class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    public LoginPresenter(final LoginContract.View view) {
        super(view);
    }
}
