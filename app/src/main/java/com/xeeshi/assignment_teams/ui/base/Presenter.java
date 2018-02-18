package com.xeeshi.assignment_teams.ui.base;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

public interface Presenter<V extends BaseView> {

    void onAttach(V baseView);

    void onDetach();

}
