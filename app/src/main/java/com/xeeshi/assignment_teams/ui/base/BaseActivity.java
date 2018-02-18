package com.xeeshi.assignment_teams.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xeeshi.assignment_teams.App;
import com.xeeshi.assignment_teams.R;
import com.xeeshi.assignment_teams.di.component.ActivityComponent;
import com.xeeshi.assignment_teams.di.component.DaggerActivityComponent;
import com.xeeshi.assignment_teams.di.module.ActivityModule;
import com.xeeshi.assignment_teams.di.module.ApiModule;

import butterknife.Unbinder;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ActivityComponent mActivityComponent;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent( ((App) getApplication()).getApplicationComponent() )
                .activityModule(new ActivityModule(this))
                .apiModule(new ApiModule())
                .build();

    }

    public void setUnbinder(Unbinder mUnbinder) {
        this.mUnbinder = mUnbinder;
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    protected void onDestroy() {

        if (null != mUnbinder)
            mUnbinder.unbind();

        super.onDestroy();

    }

    private void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    @Override
    public void showError(String message) {
        if (null != message)
            showSnackBar(message);
        else
            showSnackBar(getString(R.string.some_error));
    }

    @Override
    public void showError(int resId) {
        showError(getString(resId));
    }


    @Override
    public void showMessage(String message) {
        if (null != message)
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(int resId) {
        showMessage(getString(resId));
    }



    protected abstract void setUp();
}
