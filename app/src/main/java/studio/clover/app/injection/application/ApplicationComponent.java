package studio.clover.app.injection.application;

import javax.inject.Singleton;

import dagger.Component;
import studio.clover.app.injection.application.module.ApiModule;
import studio.clover.app.injection.application.module.ConnectivityModule;
import studio.clover.app.injection.application.module.DataModule;
import studio.clover.app.injection.application.module.ThreadingModule;
import studio.clover.app.injection.application.module.UtilsModule;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class,
                ConnectivityModule.class,
                DataModule.class,
                ThreadingModule.class,
                UtilsModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentInjects,
                                              ApplicationComponentExposes { }
