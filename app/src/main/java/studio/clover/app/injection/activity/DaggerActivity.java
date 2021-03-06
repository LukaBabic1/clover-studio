package studio.clover.app.injection.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import studio.clover.app.app.CloverApplication;
import studio.clover.app.injection.ComponentFactory;

public abstract class DaggerActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getActivityComponent());
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this, getCloverApplication());
        }

        return activityComponent;
    }

    private CloverApplication getCloverApplication() {
        return CloverApplication.from(this);
    }

    protected abstract void inject(final ActivityComponent component);
}

