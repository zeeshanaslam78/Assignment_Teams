package com.xeeshi.assignment_teams.ui.teams;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xeeshi.assignment_teams.R;
import com.xeeshi.assignment_teams.data.network.model.Team;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZEESHAN on 13/02/2018.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamViewHolder> {

    private List<Team> teamList;

    public TeamsAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_list_row, parent, false);

        return new TeamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.name.setText(team.getName());
        holder.national.setText(String.valueOf(team.getNational()));
        holder.countryName.setText(team.getCountryName());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }


    public static class TeamViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_name) TextView name;
        @BindView(R.id.txt_national_team) TextView national;
        @BindView(R.id.txt_country_name) TextView countryName;

        public TeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
