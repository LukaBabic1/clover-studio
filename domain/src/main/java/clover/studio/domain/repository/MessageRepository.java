package clover.studio.domain.repository;

import clover.studio.domain.model.AccessToken;
import rx.Completable;

public interface MessageRepository {

    Completable sendMessage(AccessToken accessToken, String message);
}
