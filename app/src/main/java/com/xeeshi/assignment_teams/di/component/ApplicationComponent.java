package com.xeeshi.assignment_teams.di.component;

import android.app.Application;
import android.content.Context;

import com.xeeshi.assignment_teams.App;
import com.xeeshi.assignment_teams.di.ApplicationContext;
import com.xeeshi.assignment_teams.di.CheckInternet;
import com.xeeshi.assignment_teams.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    Retrofit retrofit();
    OkHttpClient okHttpClient();

    @CheckInternet
    boolean checkNetwork();

}
