package com.csii.baselib.delegate;

import android.app.Application;
import android.content.Context;

/**
 * 代理 Application的生命周期
 */
public interface AppLifecycles {

    void attachBaseContext(Context context);

    void onCreate(Application application);

    void onTerminate(Application application);

}
