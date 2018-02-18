package com.xeeshi.assignment_teams.di.component;

import com.xeeshi.assignment_teams.di.module.ActivityModule;
import com.xeeshi.assignment_teams.di.module.ApiModule;
import com.xeeshi.assignment_teams.di.scope.PerActivity;
import com.xeeshi.assignment_teams.ui.teams.MainActivity;

import dagger.Component;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, ApiModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
