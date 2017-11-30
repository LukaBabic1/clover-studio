package studio.clover.app.ui.message;

import javax.inject.Inject;

import clover.studio.domain.StringUtils;
import clover.studio.domain.usecase.login.LogOutUserUseCase;
import clover.studio.domain.usecase.message.SendMessageUseCase;
import studio.clover.app.base.BasePresenter;

public final class MessagePresenter extends BasePresenter<MessageContract.View> implements MessageContract.Presenter {

    @Inject
    LogOutUserUseCase logOutUserUseCase;

    @Inject
    SendMessageUseCase sendMessageUseCase;

    @Inject
    StringUtils stringUtils;

    public MessagePresenter(final MessageContract.View view) {
        super(view);
    }

    @Override
    public void sendMessage(final String message) {
        if (stringUtils.isEmpty(message)) {
            doIfViewNotNull(MessageContract.View::showEmptyMessageError);
        } else {
            sendMessageInternal(message);
        }
    }

    private void sendMessageInternal(final String message) {
        viewActionQueue.subscribeTo(sendMessageUseCase.execute(message)
                                                      .subscribeOn(backgroundScheduler),
                                    view -> {
                                        view.hideLoading();
                                        view.clearMessageField();
                                    },
                                    throwable -> doIfViewNotNull(MessageContract.View::showUnknownErrorMessage));
    }

    @Override
    public void logOut() {
        doIfViewNotNull(MessageContract.View::showLoading);
        viewActionQueue.subscribeTo(logOutUserUseCase.execute()
                                                     .subscribeOn(backgroundScheduler),
                                    view -> {
                                        view.hideLoading();
                                        router.showLoginScreen();
                                    },
                                    throwable -> {
                                        doIfViewNotNull(MessageContract.View::hideLoading);
                                        doIfViewNotNull(MessageContract.View::showUnknownErrorMessage);
                                    });
    }
}
