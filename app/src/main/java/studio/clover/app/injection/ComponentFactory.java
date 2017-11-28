package studio.clover.app.injection;

import studio.clover.app.app.CloverApplication;
import studio.clover.app.injection.activity.ActivityComponent;
import studio.clover.app.injection.activity.DaggerActivity;
import studio.clover.app.injection.activity.DaggerFragment;
import studio.clover.app.injection.application.ApplicationComponent;

public final class ComponentFactory {

    public static ApplicationComponent createApplicationComponent(final CloverApplication application) {
        return null;
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity activity, final CloverApplication application) {
        return null;
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment fragment, final ActivityComponent component) {
        return null;
    }
}
