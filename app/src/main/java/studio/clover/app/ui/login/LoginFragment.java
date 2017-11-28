package studio.clover.app.ui.login;

import studio.clover.app.base.BaseFragment;
import studio.clover.app.base.ScopedPresenter;
import studio.clover.app.injection.fragment.FragmentComponent;

public final class LoginFragment extends BaseFragment implements LoginContract.View {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return 0;
    }

    @Override
    public ScopedPresenter getPresenter() {
        return ScopedPresenter.EMPTY;
    }
}
