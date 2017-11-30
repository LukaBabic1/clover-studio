package clover.studio.domain.usecase.message;

import clover.studio.domain.repository.MessageRepository;
import clover.studio.domain.repository.UserRepository;
import rx.Completable;

public final class SendMessageUseCaseImpl implements SendMessageUseCase {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public SendMessageUseCaseImpl(final MessageRepository messageRepository, final UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Completable execute(final String message) {
        return userRepository.getAccessToken()
                             .flatMapCompletable(accessToken -> messageRepository.sendMessage(accessToken, message));
    }
}
