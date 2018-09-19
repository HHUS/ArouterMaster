package com.csii.mvp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.csii.mvp.contract.HomeContract;

public class HomeView implements HomeContract.View {
    @Override
    public void startLoadMore() {

    }

    @Override
    public void endLoadMore() {

    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {

    }
}
