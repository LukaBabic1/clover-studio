package studio.clover.app.injection.application;

import studio.clover.app.injection.module.ApiModule;
import studio.clover.app.injection.module.DataModule;
import studio.clover.app.injection.module.UtilsModule;

public interface ApplicationComponentExposes extends ApplicationModule.Exposes,
                                                     ApiModule.Exposes,
                                                     DataModule.Exposes,
                                                     UtilsModule.Exposes { }
