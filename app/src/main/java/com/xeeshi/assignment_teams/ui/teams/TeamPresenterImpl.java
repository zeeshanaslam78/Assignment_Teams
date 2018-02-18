package com.xeeshi.assignment_teams.ui.teams;

import com.xeeshi.assignment_teams.data.network.TeamsRepository;
import com.xeeshi.assignment_teams.data.network.model.Team;
import com.xeeshi.assignment_teams.di.CheckInternet;
import com.xeeshi.assignment_teams.rx.SchedulerProvider;
import com.xeeshi.assignment_teams.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by ZEESHAN on 15/02/2018.
 */

public class TeamPresenterImpl<V extends TeamView> extends BasePresenter<V>
        implements TeamPresenter<V> {

    private final TeamsRepository teamsRepository;

    @Inject
    public TeamPresenterImpl(SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable,
                             @CheckInternet boolean isNetworkAvailable,
                             TeamsRepository teamsRepository) {
        super(schedulerProvider, compositeDisposable, isNetworkAvailable);
        this.teamsRepository = teamsRepository;
    }

    @Override
    public void getAllTeams() {

        if (null != getView())
            getView().showProgressBar();

        if (isNetworkAvailable()) {
            getCompositeDisposable().add(teamsRepository.listOfTeams()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<List<Team>>() {
                        @Override
                        public void accept(List<Team> teams) throws Exception {
                            if (null != TeamPresenterImpl.this.getView()) {
                                if (null != teams && teams.size() > 0) {
                                    TeamPresenterImpl.this.getView().hideProgressBar();
                                    TeamPresenterImpl.this.getView().showAllTeams(teams);
                                } else {
                                    TeamPresenterImpl.this.getView().hideProgressBar();
                                    TeamPresenterImpl.this.getView().showEmptyView();
                                }
                            }
                        }
                    }, e -> {
                        if (null != getView())
                            getView().showError(e.getMessage());
                    }));
        } else {
            if (null != getView()) {
                getView().hideProgressBar();
                getView().noInternetAvailable();
            }
        }
    }

}
