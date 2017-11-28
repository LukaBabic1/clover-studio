package studio.clover.app.injection.application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentInjects, ApplicationComponentExposes { }
