package com.csii.baselib.module;

import android.app.Application;
import android.content.Context;

import com.csii.baselib.delegate.AppLifecycles;

import java.util.List;

public interface ConfigModule {


//    void applyOptions(Context context);

    /**
     * 在Application的生命周期中注入一些参数
     * @param context
     * @param appLifecycles
     */
    void injectApplifecycle(Context context, List<AppLifecycles> appLifecycles);

    void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> activityLifecycleCallbacks);

}
