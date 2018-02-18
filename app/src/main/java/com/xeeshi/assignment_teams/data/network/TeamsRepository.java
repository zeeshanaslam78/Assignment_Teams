package com.xeeshi.assignment_teams.data.network;

import com.xeeshi.assignment_teams.data.network.model.Team;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ZEESHAN on 13/02/2018.
 */

public interface TeamsRepository {

    @GET("forza-assignment/android/teams.json")
    Observable<List<Team>> listOfTeams();

}
