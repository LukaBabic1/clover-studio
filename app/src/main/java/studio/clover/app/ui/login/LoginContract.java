package studio.clover.app.ui.login;

import studio.clover.app.base.BaseView;
import studio.clover.app.base.ScopedPresenter;

public final class LoginContract {

    private LoginContract() {

    }

    public interface Presenter extends ScopedPresenter {

        void singIn(String username, String password);
    }

    public interface View extends BaseView {

        void showInvalidCredentialsError();

        void showUnknownErrorMessage();
    }
}
