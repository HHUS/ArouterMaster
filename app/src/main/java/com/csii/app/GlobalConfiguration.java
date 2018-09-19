package com.csii.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;


import com.csii.baselib.delegate.AppLifecycles;
import com.csii.baselib.module.ConfigModule;

import java.util.List;

import timber.log.Timber;

/**
 * @author sunhao
 */
public class GlobalConfiguration implements ConfigModule{
    @Override
    public void injectApplifecycle(Context context, List<AppLifecycles> appLifecycles) {
        appLifecycles.add(new AppLifecycles() {
            @Override
            public void attachBaseContext(Context context) {

            }

            @Override
            public void onCreate(Application application) {

                Timber.plant(new Timber.DebugTree());

                Timber.e("执行了 主App下的 onCreate");


            }

            @Override
            public void onTerminate(Application application) {
                Timber.d("执行了 主App下的 onTerminate");
            }
        });
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        lifecycles.add(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
