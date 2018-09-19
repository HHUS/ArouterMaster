package com.csii.baselib.delegate;

import android.app.Application;
import android.content.Context;

import com.csii.baselib.integration.ManifestParser;
import com.csii.baselib.module.ConfigModule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunhao
 * <p>
 * 通过代理模式，委派AppDelegate去代理Application的生命周期
 * 由AppDelegate创建时通过反射的手段初始化
 */
public class AppDelegate implements AppLifecycles {

    private Application mApplication;

    private List<AppLifecycles> mAppLifecycles = new ArrayList<>();

    private List<ConfigModule> mModules;


    public AppDelegate(Context context) {
        //通过反射执行
        this.mModules = new ManifestParser(context).parse();

        //遍历之前获得的集合, 执行每一个 ConfigModule 实现类的某些方法
        for (ConfigModule module : mModules) {
            //将框架外部, 开发者实现的 Application 的生命周期回调 (AppLifecycles) 存入 mAppLifecycles 集合 (此时还未注册回调)
            module.injectApplifecycle(context, mAppLifecycles);
        }
    }

    @Override
    public void attachBaseContext(Context context) {

        for (AppLifecycles lifecycle : mAppLifecycles) {
            lifecycle.attachBaseContext(context);
        }

    }

    @Override
    public void onCreate(Application application) {

        this.mApplication = application;


        //执行框架外部,开发者扩展的App onCreate逻辑
        for (AppLifecycles lifecycle : mAppLifecycles) {
            lifecycle.onCreate(application);
        }

    }

    @Override
    public void onTerminate(Application application) {

        if(mAppLifecycles != null && mAppLifecycles.size() > 0) {
            for (AppLifecycles lifecycle : mAppLifecycles) {
                lifecycle.onTerminate(application);
            }
        }

        this.mAppLifecycles = null;
        this.mApplication = null;

    }
}
