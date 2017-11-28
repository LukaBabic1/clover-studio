package studio.clover.app.ui;

import android.support.v4.app.FragmentManager;

import studio.clover.app.R;
import studio.clover.app.ui.login.LoginFragment;
import studio.clover.app.utils.UnimplementedMethodException;

public final class RouterImpl implements Router {

    private static final int CONTAINER_ID = R.id.activity_main_fragment_container;

    private final FragmentManager fragmentManager;

    public RouterImpl(final FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void showLoginScreen() {
        fragmentManager.beginTransaction()
                       .replace(CONTAINER_ID, LoginFragment.newInstance())
                       .commit();
    }

    @Override
    public void showMessageScreen() {
        throw new UnimplementedMethodException();
    }
}
