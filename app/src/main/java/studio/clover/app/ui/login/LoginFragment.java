package studio.clover.app.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import studio.clover.app.R;
import studio.clover.app.base.BaseFragment;
import studio.clover.app.base.ScopedPresenter;
import studio.clover.app.injection.fragment.FragmentComponent;

public final class LoginFragment extends BaseFragment implements LoginContract.View {

    @BindView(R.id.fragment_login_username_edittext)
    EditText usernameEditText;

    @BindView(R.id.fragment_login_username_password)
    EditText passwordEditText;

    @BindView(R.id.fragment_login_sign_in_button)
    Button signInButton;

    @BindView(R.id.fragment_login_progress_bar)
    ProgressBar progressBar;

    @Inject
    LoginContract.Presenter presenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected void inject(final FragmentComponent component) {
        component.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // To avoid typing every time.
        usernameEditText.setText("jobapplicant");
        passwordEditText.setText("pQw4md4YZR");
    }

    @Override
    public ScopedPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showLoading() {
        usernameEditText.setEnabled(false);
        passwordEditText.setEnabled(false);
        signInButton.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        usernameEditText.setEnabled(true);
        passwordEditText.setEnabled(true);
        signInButton.setEnabled(true);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showInvalidCredentialsError() {
        showShortToast(R.string.fragment_login_invalid_username_or_password_message);
    }

    @Override
    public void showUnknownErrorMessage() {
        showShortToast(R.string.fragment_login_unknown_error);
    }

    @OnClick(R.id.fragment_login_sign_in_button)
    void onSignInButtonClicked() {
        presenter.singIn(usernameEditText.getText().toString(), passwordEditText.getText().toString());
    }
}
