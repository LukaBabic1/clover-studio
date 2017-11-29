package studio.clover.app.injection.activity;

import studio.clover.app.injection.activity.module.ActivityModule;
import studio.clover.app.injection.application.ApplicationComponentExposes;
import studio.clover.app.injection.application.module.UseCaseModule;

public interface ActivityComponentExposes extends ApplicationComponentExposes,
                                                  ActivityModule.Exposes,
                                                  UseCaseModule.Expoese{ }
