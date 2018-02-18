package com.xeeshi.assignment_teams.di.module;

import com.xeeshi.assignment_teams.data.network.TeamsRepository;
import com.xeeshi.assignment_teams.di.scope.PerActivity;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ZEESHAN on 18/02/2018.
 */

@Module
public class TestApiModule {

    @Provides
    @PerActivity
    TeamsRepository provideTeamsRepository(Retrofit retrofit) {
        return Mockito.mock(TeamsRepository.class);
    }
}
