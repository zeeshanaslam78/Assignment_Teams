package com.xeeshi.assignment_teams.rx;

import io.reactivex.Scheduler;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
