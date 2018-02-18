package com.xeeshi.assignment_teams;

import com.xeeshi.assignment_teams.di.component.ApplicationComponent;
import com.xeeshi.assignment_teams.di.component.DaggerApplicationComponent;
import com.xeeshi.assignment_teams.di.module.ApplicationModule;

/**
 * Created by ZEESHAN on 18/02/2018.
 */

public class TestApp extends App {

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getOrCreateApplicationComponent() {
        if (null == applicationComponent) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }

        return applicationComponent;
    }

}
