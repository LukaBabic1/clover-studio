package clover.studio.domain.usecase.message;

import rx.Completable;

public interface SendMessageUseCase {

    Completable execute(String message);
}
