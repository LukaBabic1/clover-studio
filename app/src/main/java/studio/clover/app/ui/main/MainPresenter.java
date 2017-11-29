package studio.clover.app.ui.main;

import javax.inject.Inject;

import clover.studio.domain.usecase.login.IsUserLoggedInUseCase;
import rx.functions.Action1;
import studio.clover.app.base.BasePresenter;
import studio.clover.app.utils.Actions;

public final class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    IsUserLoggedInUseCase isUserLoggedInUseCase;

    public MainPresenter(final MainContract.View view) {
        super(view);
    }

    @Override
    public void start() {
        super.start();
        viewActionQueue.subscribeTo(isUserLoggedInUseCase.execute()
                                                         .map(this::mapToViewAction)
                                                         .subscribeOn(backgroundScheduler),
                                    Actions.noOpAction1());
    }

    private Action1<MainContract.View> mapToViewAction(final boolean isLoggedIn) {
        if (isLoggedIn) {
            router.showMessageScreen();
        } else {
            router.showLoginScreen();
        }

        return Actions.noOpAction1();
    }
}
