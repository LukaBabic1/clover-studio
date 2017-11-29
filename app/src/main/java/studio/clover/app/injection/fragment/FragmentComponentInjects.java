package studio.clover.app.injection.fragment;

import studio.clover.app.ui.login.LoginFragment;
import studio.clover.app.ui.login.LoginPresenter;
import studio.clover.app.ui.message.MessageFragment;

public interface FragmentComponentInjects {

    void inject(LoginFragment fragment);

    void inject(LoginPresenter presenter);

    void inject(MessageFragment fragment);
}
