package studio.clover.app.app;

import android.app.Application;
import android.content.Context;

import studio.clover.app.injection.ComponentFactory;
import studio.clover.app.injection.application.ApplicationComponent;

public final class CloverApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static CloverApplication from(final Context context) {
        return CloverApplication.class.cast(context.getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent().inject(this);
    }

    private ApplicationComponent initApplicationComponent() {
        return applicationComponent = ComponentFactory.createApplicationComponent(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
