package com.xeeshi.assignment_teams.di.component;

import com.xeeshi.assignment_teams.data.network.TeamsRepository;
import com.xeeshi.assignment_teams.di.module.TestApiModule;
import com.xeeshi.assignment_teams.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by ZEESHAN on 18/02/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {/*ActivityModule.class, */TestApiModule.class})
public interface TestActivityComponent {

    //void inject(MainActivity mainActivity);


    TeamsRepository teamsRepository();

}
