package studio.clover.app.injection.application;

import dagger.Component;

@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentInjects, ApplicationComponentExposes { }
