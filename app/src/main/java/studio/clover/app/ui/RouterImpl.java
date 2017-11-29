package studio.clover.app.ui;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

import studio.clover.app.R;
import studio.clover.app.ui.login.LoginFragment;
import studio.clover.app.utils.UnimplementedMethodException;

public final class RouterImpl implements Router {

    private static final int CONTAINER_ID = R.id.activity_main_fragment_container;

    private final Activity activity;
    private final FragmentManager fragmentManager;

    public RouterImpl(final Activity activity, final FragmentManager fragmentManager) {
        this.activity = activity;
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

    @Override
    public void goBack() {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            activity.finish();
        } else {
            fragmentManager.popBackStack();
        }
    }
}
