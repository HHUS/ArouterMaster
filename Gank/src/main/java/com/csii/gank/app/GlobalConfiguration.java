package com.csii.gank.app;

import android.app.Application;
import android.content.Context;

import com.csii.baselib.delegate.AppLifecycles;
import com.csii.baselib.module.ConfigModule;

import java.util.List;

import timber.log.Timber;

public class GlobalConfiguration implements ConfigModule{
    @Override
    public void injectApplifecycle(Context context, List<AppLifecycles> appLifecycles) {
        appLifecycles.add(new AppLifecycles() {
            @Override
            public void attachBaseContext(Context context) {

            }

            @Override
            public void onCreate(Application application) {

                Timber.e("执行了 gank onCreate");

            }

            @Override
            public void onTerminate(Application application) {

            }
        });
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> activityLifecycleCallbacks) {

    }
}
