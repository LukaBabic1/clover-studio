package studio.clover.app.injection.activity;

import studio.clover.app.ui.main.MainActivity;
import studio.clover.app.ui.main.MainPresenter;

public interface ActivityComponentInjects {

    void inject(MainActivity activity);

    void inject(MainPresenter presenter);
}
