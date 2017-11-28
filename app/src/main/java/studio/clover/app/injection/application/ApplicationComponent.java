package studio.clover.app.injection.application;

import javax.inject.Singleton;

import dagger.Component;
import studio.clover.app.injection.module.ApiModule;
import studio.clover.app.injection.module.DataModule;
import studio.clover.app.injection.module.UtilsModule;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class,
                DataModule.class,
                UtilsModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentInjects,
                                              ApplicationComponentExposes { }
