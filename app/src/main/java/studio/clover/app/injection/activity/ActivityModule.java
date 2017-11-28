package studio.clover.app.injection.activity;

import android.content.Context;

import dagger.Module;
import studio.clover.app.injection.ForActivity;

@Module
public final class ActivityModule {

    private final DaggerActivity activity;

    public ActivityModule(final DaggerActivity activity) {
        this.activity = activity;
    }

    @ForActivity
    public Context provideActivityContext() {
        return activity;
    }

    public interface Exposes {

        @ForActivity
        Context provideActivityContext();
    }
}
