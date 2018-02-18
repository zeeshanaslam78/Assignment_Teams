package com.xeeshi.assignment_teams;

import com.xeeshi.assignment_teams.di.component.TestActivityComponent;

/**
 * Created by ZEESHAN on 18/02/2018.
 */

public class TestApplication extends TestApp {

    private TestActivityComponent testActivityComponent;

    public TestActivityComponent getOrCreateTestActivityComponent() {
        if (null == testActivityComponent) {
            /*testActivityComponent = DaggerTestActivityComponent.builder()
                    .applicationModule(getOrCreateApplicationComponent())
                    //.activityModule(new ActivityModule(this))
                    .testApiModule(new TestApiModule())
                    .build();*/



        }

        return testActivityComponent;
    }

}
