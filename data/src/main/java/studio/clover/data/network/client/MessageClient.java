package studio.clover.data.network.client;

import clover.studio.domain.model.AccessToken;
import rx.Completable;

public interface MessageClient {

    Completable sendMessage(AccessToken accessToken, String message);
}
