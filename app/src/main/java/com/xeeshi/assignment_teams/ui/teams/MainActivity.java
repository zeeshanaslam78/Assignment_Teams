package com.xeeshi.assignment_teams.ui.teams;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xeeshi.assignment_teams.R;
import com.xeeshi.assignment_teams.data.network.model.Team;
import com.xeeshi.assignment_teams.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements TeamView {

    @BindString(R.string.no_data_available) String noData;
    @BindString(R.string.no_network_available) String noInternet;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.txt_emptyView) TextView emptyView;
    @BindView(R.id.progressbar) ProgressBar progressBar;

    @Inject
    TeamPresenterImpl<TeamView> teamPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUnbinder(ButterKnife.bind(this));

        getActivityComponent().inject(this);

        initRecyclerView();

        teamPresenter.onAttach(this);
        teamPresenter.getAllTeams();

    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        teamPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void showAllTeams(List<Team> teams) {

        Log.d("Teams", teams.toString());
        List<Team> teamList = new ArrayList<>(teams);
        TeamsAdapter teamsAdapter = new TeamsAdapter(teamList);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setAdapter(teamsAdapter);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void showEmptyView() {
        emptyView.setText(noData);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void noInternetAvailable() {
        emptyView.setText(noInternet);
        emptyView.setVisibility(View.VISIBLE);

    }

}
