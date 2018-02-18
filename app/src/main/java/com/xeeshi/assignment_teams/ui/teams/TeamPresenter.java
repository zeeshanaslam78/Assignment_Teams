package com.xeeshi.assignment_teams.ui.teams;

import com.xeeshi.assignment_teams.di.scope.PerActivity;
import com.xeeshi.assignment_teams.ui.base.Presenter;

/**
 * Created by ZEESHAN on 15/02/2018.
 */

@PerActivity
public interface TeamPresenter<V extends TeamView> extends Presenter<V> {

    void getAllTeams();
}
