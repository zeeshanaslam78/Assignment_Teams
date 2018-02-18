package com.xeeshi.assignment_teams.ui.teams;

import com.xeeshi.assignment_teams.data.network.TeamsRepository;
import com.xeeshi.assignment_teams.data.network.model.Team;
import com.xeeshi.assignment_teams.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ZEESHAN on 18/02/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class TeamPresenterTest {
    @Mock TeamView teamView;
    @Mock TeamsRepository teamsRepository;

    private TeamPresenterImpl<TeamView> teamPresenter;
    private TestScheduler testScheduler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        testScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(testScheduler);

        teamPresenter = new TeamPresenterImpl<>(
                testSchedulerProvider,
                compositeDisposable,
                true, teamsRepository);
    }

    @Test
    public void testGetAllTeamsCallsCorrectly() {
        teamPresenter.onAttach(teamView);

        List<Team> list = new ArrayList<>();
        list.add(new Team("Arsenal", false, "England"));

        Observable<List<Team>> listObservable = Observable.just(list).subscribeOn(testScheduler);
        when(teamsRepository.listOfTeams()).thenReturn(listObservable);

        teamPresenter.getAllTeams();

        verify(teamView, times(1)).showProgressBar();
        verify(teamView, never()).showEmptyView();

        testScheduler.triggerActions();

        verify(teamView, times(1 )).hideProgressBar();
        verify(teamView, times(1)).showAllTeams(anyList());

    }

    @After
    public void tearDown() {
        teamPresenter.onDetach();
    }


}
