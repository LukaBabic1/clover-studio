package studio.clover.app.injection.activity.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import studio.clover.app.injection.ForActivity;
import studio.clover.app.injection.activity.DaggerActivity;
import studio.clover.app.injection.scope.ActivityScope;
import studio.clover.app.ui.Router;
import studio.clover.app.ui.RouterImpl;
import studio.clover.app.utils.ActivityUtils;
import studio.clover.app.utils.ActivityUtilsImpl;

@Module
public final class ActivityModule {

    private final DaggerActivity activity;

    public ActivityModule(final DaggerActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    ActivityUtils provideActivityUtils() {
        return new ActivityUtilsImpl();
    }

    @Provides
    @ForActivity
    Context provideActivityContext() {
        return activity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    Router provideRouter(final FragmentManager fragmentManager) {
        return new RouterImpl(activity, fragmentManager);
    }

    public interface Exposes {

        ActivityUtils activityUtils();

        @ForActivity
        Context provideActivityContext();

        Router router();
    }
}
