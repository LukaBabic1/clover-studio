package studio.clover.app.ui.message;

import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import studio.clover.app.R;
import studio.clover.app.base.BaseFragment;
import studio.clover.app.base.ScopedPresenter;
import studio.clover.app.injection.fragment.FragmentComponent;

public final class MessageFragment extends BaseFragment implements MessageContract.View {

    @BindView(R.id.fragment_message_edit_text)
    EditText messageEditText;

    @BindView(R.id.fragment_message_button_send)
    Button sendButton;

    @Inject
    MessageContract.Presenter presenter;

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    protected void inject(final FragmentComponent component) {
        component.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_message;
    }

    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }

    @OnClick(R.id.fragment_message_button_send)
    void onSendButtonClicked() {
        presenter.sendMessage(messageEditText.getText().toString());
    }
}
