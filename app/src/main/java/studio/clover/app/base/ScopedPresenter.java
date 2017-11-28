package studio.clover.app.base;

public interface ScopedPresenter {

    ScopedPresenter EMPTY = NoOpScopedPresenter.INSTANCE;

    void start();

    void activate();

    void deactivate();

    void stop();

    void destroy();

    void back();
}

