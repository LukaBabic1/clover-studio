package studio.clover.app.injection.application.module;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import studio.clover.app.injection.ForApplication;
import studio.clover.app.utils.connectivity.ConnectivityManagerWrapper;
import studio.clover.app.utils.connectivity.ConnectivityManagerWrapperImpl;
import studio.clover.app.utils.connectivity.ConnectivityReceiver;
import studio.clover.app.utils.connectivity.ConnectivityReceiverImpl;
import studio.clover.app.utils.connectivity.NetworkUtils;
import studio.clover.app.utils.connectivity.NetworkUtilsImpl;

@Module
public final class ConnectivityModule {

    @Provides
    @Singleton
    ConnectivityManagerWrapper provideConnectivityManagerWrapper(@ForApplication final Context context) {
        return new ConnectivityManagerWrapperImpl(context);
    }

    @Provides
    @Singleton
    ConnectivityReceiver provideConnectivityReceiver(@ForApplication final Context context, final NetworkUtils networkUtils,
                                                            @Named(ThreadingModule.BACKGROUND_SCHEDULER) final Scheduler backgroundScheduler) {

        return new ConnectivityReceiverImpl(context, networkUtils, backgroundScheduler);
    }

    @Provides
    @Singleton
    NetworkUtils provideNetworkUtils(final ConnectivityManagerWrapper connectivityManagerWrapper) {
        return new NetworkUtilsImpl(connectivityManagerWrapper);
    }

    public interface Exposes {

        ConnectivityReceiver provideConnectivityReceiver();
    }
}
