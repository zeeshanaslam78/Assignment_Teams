package com.xeeshi.assignment_teams.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

public interface BaseView {

    void showProgressBar();

    void hideProgressBar();

    void showError(@StringRes int resId);

    void showError(String message);

    void showMessage(@StringRes int resId);

    void showMessage(String message);

    void noInternetAvailable();

}
