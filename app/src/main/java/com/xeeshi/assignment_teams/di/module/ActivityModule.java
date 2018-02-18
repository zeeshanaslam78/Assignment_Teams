package com.xeeshi.assignment_teams.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.xeeshi.assignment_teams.data.network.model.Team;
import com.xeeshi.assignment_teams.di.ActivityContext;
import com.xeeshi.assignment_teams.di.scope.PerActivity;
import com.xeeshi.assignment_teams.ui.teams.TeamPresenter;
import com.xeeshi.assignment_teams.ui.teams.TeamPresenterImpl;
import com.xeeshi.assignment_teams.ui.teams.TeamView;
import com.xeeshi.assignment_teams.ui.teams.TeamsAdapter;
import com.xeeshi.assignment_teams.rx.AppSchedulerProvider;
import com.xeeshi.assignment_teams.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() { return appCompatActivity; }

    @Provides
    AppCompatActivity provideActivity() { return appCompatActivity; }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider providerSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    TeamsAdapter provideTeamsAdapter() {
        return new TeamsAdapter(new ArrayList<Team>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity appCompatActivity) {
        return new LinearLayoutManager(appCompatActivity);
    }

    @Provides
    @PerActivity
    TeamPresenter<TeamView> provideTeamViewTeamPresenter(TeamPresenterImpl<TeamView> teamPresenter) {
        return teamPresenter;
    }



}
