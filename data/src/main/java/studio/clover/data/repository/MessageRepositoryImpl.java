package studio.clover.data.repository;

import clover.studio.domain.model.AccessToken;
import clover.studio.domain.repository.MessageRepository;
import rx.Completable;
import studio.clover.data.network.client.MessageClient;

public final class MessageRepositoryImpl implements MessageRepository {

    private final MessageClient messageClient;

    public MessageRepositoryImpl(final MessageClient messageClient) {
        this.messageClient = messageClient;
    }

    @Override
    public Completable sendMessage(final AccessToken accessToken, final String message) {
        return messageClient.sendMessage(accessToken, message);
    }
}
