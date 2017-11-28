package studio.clover.app.injection.activity;

import dagger.Component;
import studio.clover.app.injection.application.ApplicationComponent;
import studio.clover.app.injection.scope.ActivityScope;

@ActivityScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                ActivityModule.class
        }
)
public interface ActivityComponent { }
