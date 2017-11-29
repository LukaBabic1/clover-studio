package studio.clover.app.injection.activity.module;

import dagger.Module;
import dagger.Provides;
import studio.clover.app.injection.activity.DaggerActivity;
import studio.clover.app.injection.scope.ActivityScope;
import studio.clover.app.ui.main.MainContract;
import studio.clover.app.ui.main.MainPresenter;

@Module
public final class ActivityPresenterModule {

    private final DaggerActivity daggerActivity;

    public ActivityPresenterModule(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Provides
    @ActivityScope
    MainContract.Presenter provideMainPresenter() {
        final MainPresenter presenter = new MainPresenter((MainContract.View) daggerActivity);
        daggerActivity.getActivityComponent().inject(presenter);

        return presenter;
    }
}
