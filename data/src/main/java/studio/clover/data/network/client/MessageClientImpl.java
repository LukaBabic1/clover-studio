package studio.clover.data.network.client;

import clover.studio.domain.model.AccessToken;
import rx.Completable;
import studio.clover.data.network.apimodel.ApiSendMessageRequest;
import studio.clover.data.network.serice.MessageService;

public final class MessageClientImpl implements MessageClient {

    private static final String CONTENT_TYPE_VALUE = "application/json; charset=utf-8";
    private static final String API_KEY = "GMUwQIHielm7b1ZQNNJYMAfCC508Giof";

    private static final int TARGET_TYPE = 3;
    private static final int MESSAGE_TYPE = 1;

    private static final String TARGET = "5a05ccd4829e64fd1dcd7732";

    private final MessageService messageService;

    public MessageClientImpl(final MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public Completable sendMessage(final AccessToken accessToken, final String message) {
        return messageService.sendMessage(CONTENT_TYPE_VALUE, API_KEY, accessToken.value, new ApiSendMessageRequest(TARGET_TYPE, MESSAGE_TYPE, TARGET, message))
                             .toCompletable();
    }
}
