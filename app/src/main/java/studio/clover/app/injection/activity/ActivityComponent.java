package studio.clover.app.injection.activity;

import dagger.Component;
import studio.clover.app.injection.activity.module.ActivityModule;
import studio.clover.app.injection.activity.module.ActivityPresenterModule;
import studio.clover.app.injection.application.ApplicationComponent;
import studio.clover.app.injection.application.module.UseCaseModule;
import studio.clover.app.injection.scope.ActivityScope;

@ActivityScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                ActivityModule.class,
                ActivityPresenterModule.class,
                UseCaseModule.class
        }
)
public interface ActivityComponent extends ActivityComponentInjects, ActivityComponentExposes {}
