package studio.clover.app.injection.application;

import studio.clover.app.injection.application.module.ApiModule;
import studio.clover.app.injection.application.module.ConnectivityModule;
import studio.clover.app.injection.application.module.DataModule;
import studio.clover.app.injection.application.module.ThreadingModule;
import studio.clover.app.injection.application.module.UtilsModule;

public interface ApplicationComponentExposes extends ApplicationModule.Exposes,
                                                     ApiModule.Exposes,
                                                     ConnectivityModule.Exposes,
                                                     DataModule.Exposes,
                                                     ThreadingModule.Exposes,
                                                     UtilsModule.Exposes { }
