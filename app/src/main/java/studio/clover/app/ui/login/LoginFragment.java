package studio.clover.app.ui.login;

import javax.inject.Inject;

import studio.clover.app.R;
import studio.clover.app.base.BaseFragment;
import studio.clover.app.base.ScopedPresenter;
import studio.clover.app.injection.fragment.FragmentComponent;

public final class LoginFragment extends BaseFragment implements LoginContract.View {

    @Inject
    LoginContract.Presenter presenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected void inject(final FragmentComponent component) {
        component.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_login;
    }

    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }
}
