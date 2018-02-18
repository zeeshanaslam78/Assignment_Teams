package com.xeeshi.assignment_teams.ui.base;

import com.xeeshi.assignment_teams.di.CheckInternet;
import com.xeeshi.assignment_teams.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ZEESHAN on 17/02/2018.
 */

public class BasePresenter<V extends BaseView> implements Presenter<V> {


    private final SchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;
    private final boolean isNetworkAvailable;

    private V view;

    @Inject
    public BasePresenter(SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable,
                         @CheckInternet boolean isNetworkAvailable) {
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
        this.isNetworkAvailable = isNetworkAvailable;
    }

    @Override
    public void onAttach(V baseView) {
        view = baseView;
    }

    @Override
    public void onDetach() {
        compositeDisposable.dispose();
        view = null;
    }

    public V getView() {
        return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public void checkViewIsAttached() {
        if (!isViewAttached()) throw new ViewNotAttachedException();
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public boolean isNetworkAvailable() {
        return isNetworkAvailable;
    }

    public static class ViewNotAttachedException extends RuntimeException {
        public ViewNotAttachedException() {
            super("Please call Presenter.onAttach(view) before" +
                    " requesting data to the Presenter");
        }
    }

}
