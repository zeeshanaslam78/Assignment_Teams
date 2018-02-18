package com.xeeshi.assignment_teams;

import android.app.Application;

import com.xeeshi.assignment_teams.di.component.ApplicationComponent;
import com.xeeshi.assignment_teams.di.component.DaggerApplicationComponent;
import com.xeeshi.assignment_teams.di.module.ApplicationModule;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
