package com.csii.baselib.base;

import android.app.Application;
import android.content.Context;

import com.csii.baselib.delegate.AppDelegate;
import com.csii.baselib.delegate.AppLifecycles;

import timber.log.Timber;

/**
 * 每个模块都使用
 */
public class BaseApplication extends Application {

    private AppLifecycles mAppDelegate;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        if (mAppDelegate == null) {
            this.mAppDelegate = new AppDelegate(base);
        }

        this.mAppDelegate.attachBaseContext(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mAppDelegate != null) {
            mAppDelegate.onCreate(this);
        }

        Timber.d("BaseApplication onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        if (mAppDelegate != null) {
            this.mAppDelegate.onTerminate(this);
        }
    }
}
