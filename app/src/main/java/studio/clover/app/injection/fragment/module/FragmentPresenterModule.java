package studio.clover.app.injection.fragment.module;

import dagger.Module;
import dagger.Provides;
import studio.clover.app.injection.activity.DaggerFragment;
import studio.clover.app.injection.scope.FragmentScope;
import studio.clover.app.ui.login.LoginContract;
import studio.clover.app.ui.login.LoginPresenter;

@Module
public final class FragmentPresenterModule {

    private final DaggerFragment fragment;

    public FragmentPresenterModule(final DaggerFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    LoginContract.Presenter provideLoginPresenter() {
        final LoginPresenter presenter = new LoginPresenter((LoginContract.View) fragment);
        fragment.getFragmentComponent().inject(presenter);

        return presenter;
    }

    public interface Exposes {

        LoginContract.Presenter loginPresenter();
    }
}
