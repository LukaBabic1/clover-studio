package studio.clover.app.injection.application.module;

import javax.inject.Singleton;

import clover.studio.domain.StringUtils;
import dagger.Module;
import dagger.Provides;
import studio.clover.data.utils.StringUtilsImpl;

@Module
public final class UtilsModule {

    @Provides
    @Singleton
    StringUtils provideStringUtils() {
        return new StringUtilsImpl();
    }

    public interface Exposes {

        StringUtils stringUtils();
    }
}
