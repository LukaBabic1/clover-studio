package studio.clover.app.ui.message;

import studio.clover.app.base.BaseView;
import studio.clover.app.base.ScopedPresenter;

public final class MessageContract {

    private MessageContract() {

    }

    public interface Presenter extends ScopedPresenter {

        void sendMessage(String message);
    }

    public interface View extends BaseView {

    }
}
