package com.csii.baselib.mvp;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * 框架要求框架中的每个 Presenter 都需要实现此类,以满足规范
 */
public interface IPresenter extends LifecycleObserver {


    /**
     * 做一些初始化操作
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate();


    /**
     * 在框架中 {@link Activity#onDestroy()} 时会默认调用 {@link IPresenter#onDestroy()}
     */

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy();


    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onLifecycleChanged(LifecycleOwner owner, Lifecycle.Event event);
}
