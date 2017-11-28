package studio.clover.app.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.annimon.stream.Optional;

import javax.inject.Inject;

import butterknife.ButterKnife;
import studio.clover.app.injection.activity.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment implements BackPropagatingFragment {

    @Inject
    protected Resources resources;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().start();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return bindViews(inflater.inflate(getLayoutResourceId(), container, false));
    }

    @LayoutRes
    protected abstract int getLayoutResourceId();

    private View bindViews(final View view) {
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStop() {
        getPresenter().stop();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().activate();
    }

    @Override
    public void onPause() {
        getPresenter().deactivate();
        super.onPause();
    }

    public void onPreDestroy() {
        Optional.ofNullable(getPresenter())
                .ifPresent(ScopedPresenter::destroy);
    }

    @Override
    public void onDestroy() {
        onPreDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onBack() {
        getPresenter().back();
        return true;
    }

    public abstract ScopedPresenter getPresenter();
}
