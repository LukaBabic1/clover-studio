package studio.clover.app.injection.fragment;

import studio.clover.app.injection.activity.ActivityComponentExposes;
import studio.clover.app.injection.fragment.module.FragmentPresenterModule;

public interface FragmentComponentExposes extends ActivityComponentExposes,
                                                  FragmentPresenterModule.Exposes { }
