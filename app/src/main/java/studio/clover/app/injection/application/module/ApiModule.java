package studio.clover.app.injection.application.module;

import javax.inject.Singleton;

import clover.studio.domain.StringUtils;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import studio.clover.app.BuildConfig;
import studio.clover.data.network.converter.ApiConverter;
import studio.clover.data.network.converter.ApiConverterImpl;
import studio.clover.data.network.client.UserClient;
import studio.clover.data.network.client.UserClientImpl;
import studio.clover.data.network.configuration.Urls;
import studio.clover.data.network.configuration.UrlsImpl;
import studio.clover.data.network.serice.UserService;

@Module
public final class ApiModule {

    @Provides
    @Singleton
    Urls provideUrls() {
        return new UrlsImpl();
    }

    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(final HttpLoggingInterceptor interceptor) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(interceptor);
        }

        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(final Urls urls, final OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(urls.getServerUrl().value)
                                     .client(okHttpClient)
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                     .build();
    }

    @Provides
    @Singleton
    ApiConverter provideApiConverter(final StringUtils stringUtils) {
        return new ApiConverterImpl(stringUtils);
    }

    @Provides
    @Singleton
    UserService provideUserService(final Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

    @Provides
    @Singleton
    UserClient provideUserClient(final ApiConverter apiConverter, final UserService userService) {
        return new UserClientImpl(apiConverter, userService);
    }

    public interface Exposes {

    }
}
