package studio.clover.app.injection;

import studio.clover.app.app.CloverApplication;
import studio.clover.app.base.BaseFragment;
import studio.clover.app.injection.activity.ActivityComponent;
import studio.clover.app.injection.activity.ActivityModule;
import studio.clover.app.injection.activity.DaggerActivity;
import studio.clover.app.injection.activity.DaggerActivityComponent;
import studio.clover.app.injection.application.ApplicationComponent;
import studio.clover.app.injection.application.ApplicationModule;
import studio.clover.app.injection.application.DaggerApplicationComponent;
import studio.clover.app.injection.fragment.FragmentComponent;

public final class ComponentFactory {

    public static ApplicationComponent createApplicationComponent(final CloverApplication application) {
        return DaggerApplicationComponent.builder()
                                         .applicationModule(new ApplicationModule(application))
                                         .build();
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity activity, final CloverApplication application) {
        return DaggerActivityComponent.builder()
                                      .applicationComponent(application.getApplicationComponent())
                                      .activityModule(new ActivityModule(activity))
                                      .build();
    }

    public static FragmentComponent createFragmentComponent(final BaseFragment fragment, final ActivityComponent component) {
        return null;
    }
}
