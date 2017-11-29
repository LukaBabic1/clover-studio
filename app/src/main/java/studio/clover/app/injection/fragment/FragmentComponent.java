package studio.clover.app.injection.fragment;

import dagger.Component;
import studio.clover.app.injection.activity.ActivityComponent;
import studio.clover.app.injection.fragment.module.FragmentPresenterModule;
import studio.clover.app.injection.scope.FragmentScope;

@FragmentScope
@Component(
        dependencies = {
                ActivityComponent.class
        },
        modules = {
                FragmentPresenterModule.class
        }
)
public interface FragmentComponent extends FragmentComponentInjects,
                                           FragmentComponentExposes { }
