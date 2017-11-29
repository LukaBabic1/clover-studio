package studio.clover.app.injection.application;

import studio.clover.app.injection.application.module.ApiModule;
import studio.clover.app.injection.application.module.DataModule;
import studio.clover.app.injection.application.module.UtilsModule;

public interface ApplicationComponentExposes extends ApplicationModule.Exposes,
                                                     ApiModule.Exposes,
                                                     DataModule.Exposes,
                                                     UtilsModule.Exposes { }
