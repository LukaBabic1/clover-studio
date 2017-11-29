package studio.clover.app.injection;

import studio.clover.app.app.CloverApplication;
import studio.clover.app.injection.activity.ActivityComponent;
import studio.clover.app.injection.activity.module.ActivityModule;
import studio.clover.app.injection.activity.DaggerActivity;
import studio.clover.app.injection.activity.DaggerActivityComponent;
import studio.clover.app.injection.activity.DaggerFragment;
import studio.clover.app.injection.activity.module.ActivityPresenterModule;
import studio.clover.app.injection.application.ApplicationComponent;
import studio.clover.app.injection.application.ApplicationModule;
import studio.clover.app.injection.application.DaggerApplicationComponent;
import studio.clover.app.injection.application.module.UseCaseModule;
import studio.clover.app.injection.fragment.DaggerFragmentComponent;
import studio.clover.app.injection.fragment.FragmentComponent;
import studio.clover.app.injection.fragment.module.FragmentPresenterModule;

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
                                      .activityPresenterModule(new ActivityPresenterModule(activity))
                                      .useCaseModule(new UseCaseModule())
                                      .build();
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment fragment, final ActivityComponent component) {
        return DaggerFragmentComponent.builder()
                                      .activityComponent(component)
                                      .fragmentPresenterModule(new FragmentPresenterModule(fragment))
                                      .build();
    }
}
