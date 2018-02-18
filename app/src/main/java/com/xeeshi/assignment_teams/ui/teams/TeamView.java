package com.xeeshi.assignment_teams.ui.teams;

import com.xeeshi.assignment_teams.data.network.model.Team;
import com.xeeshi.assignment_teams.ui.base.BaseView;

import java.util.List;

/**
 * Created by ZEESHAN on 15/02/2018.
 */

public interface TeamView extends BaseView {

    void showAllTeams(List<Team> teams);

    void showEmptyView();
}
