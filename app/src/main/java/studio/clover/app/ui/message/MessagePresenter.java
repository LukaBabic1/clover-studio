package studio.clover.app.ui.message;

import studio.clover.app.base.BasePresenter;

public final class MessagePresenter extends BasePresenter<MessageContract.View> implements MessageContract.Presenter {

    public MessagePresenter(final MessageContract.View view) {
        super(view);
    }

    @Override
    public void sendMessage(final String message) {

    }
}
