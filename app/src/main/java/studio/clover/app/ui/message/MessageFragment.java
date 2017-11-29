package studio.clover.app.ui.message;

import studio.clover.app.R;
import studio.clover.app.base.BaseFragment;
import studio.clover.app.base.ScopedPresenter;
import studio.clover.app.injection.fragment.FragmentComponent;

public final class MessageFragment extends BaseFragment implements MessageContract.View {

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
        return ScopedPresenter.EMPTY;
    }
}
