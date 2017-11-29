package studio.clover.app.ui.main;

import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import studio.clover.app.R;
import studio.clover.app.base.BaseActivity;
import studio.clover.app.base.ScopedPresenter;
import studio.clover.app.injection.activity.ActivityComponent;

public final class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void inject(final ActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected ScopedPresenter getPresenter() {
        return presenter;
    }
}
