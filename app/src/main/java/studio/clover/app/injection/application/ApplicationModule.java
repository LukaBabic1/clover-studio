package studio.clover.app.injection.application;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import studio.clover.app.app.CloverApplication;
import studio.clover.app.injection.ForApplication;

@Module
public final class ApplicationModule {

    private final CloverApplication cloverApplication;

    public ApplicationModule(final CloverApplication cloverApplication) {
        this.cloverApplication = cloverApplication;
    }

    @Provides
    @ForApplication
    Context provideApplicationContext() {
        return cloverApplication;
    }

    public interface Exposes {

        @ForApplication
        Context context();
    }
}
