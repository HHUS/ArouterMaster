package com.csii.baselib.delegate;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

public interface IActivity {

    /**
     * 是否使用EventBus
     *
     * @return
     */
    boolean useEventBus();


    /**
     * 初始化 View, 如果 {@link #initView(Bundle)} 返回 0, 框架则不会调用 {@link Activity#setContentView(int)}
     *
     * @param savedInstanceState
     * @return
     */
    int initView(@Nullable Bundle savedInstanceState);

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    void initData(@Nullable Bundle savedInstanceState);

    /**
     * 这个 Activity 是否会使用 Fragment,框架会根据这个属性判断是否注册 FragmentManager.FragmentLifecycleCallbacks
     * 如果返回false,那意味着这个 Activity 不需要绑定 Fragment,那你再在这个 Activity 中绑定继承于 BaseFragment的 Fragment 将不起任何作用
     * ActivityLifecycle#registerFragmentCallbacks (Fragment 的注册过程)
     *
     * @return
     */
    boolean useFragment();
}
