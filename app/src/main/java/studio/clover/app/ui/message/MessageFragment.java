package studio.clover.app.ui.message;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

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

    @BindView(R.id.fragment_message_progress_bar)
    ProgressBar progressBar;

    @Inject
    MessageContract.Presenter presenter;

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_message_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == R.id.fragment_message_log_out_menu_item) {
            presenter.logOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void clearMessageField() {
        messageEditText.setText("");
    }

    @Override
    public void showLoading() {
        messageEditText.setEnabled(false);
        sendButton.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        messageEditText.setEnabled(true);
        sendButton.setEnabled(true);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyMessageError() {
        Toast.makeText(getContext(), R.string.fragment_message_empty_message_text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUnknownErrorMessage() {
        Toast.makeText(getContext(), R.string.error_unknown_message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.fragment_message_button_send)
    void onSendButtonClicked() {
        presenter.sendMessage(messageEditText.getText().toString());
    }
}
