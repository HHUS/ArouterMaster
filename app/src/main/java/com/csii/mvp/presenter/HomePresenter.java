package com.csii.mvp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;
import android.support.v7.widget.RecyclerView;

import com.csii.baselib.mvp.BasePresenter;
import com.csii.bean.GankItemBean;
import com.csii.mvp.contract.HomeContract;
import com.csii.mvp.model.HomeModel;

import java.util.List;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import timber.log.Timber;

public class HomePresenter extends BasePresenter<HomeContract.View> {

    RxErrorHandler mErrorHandler;

    private int lastPage = 1;
    private int preEndIndex;

    private HomeModel mModel;

    List<GankItemBean> mDatas;
    private RecyclerView.Adapter mAdapter;
    public HomePresenter(HomeContract.View rootView) {
        super(rootView);
        mModel = new HomeModel();
    }


    /**
     * 使用 2017 Google IO 发布的 Architecture Components 中的 Lifecycles 的新特性 (此特性已被加入 Support library)
     * 使 {@code Presenter} 可以与 {@link SupportActivity} 和 {@link Fragment} 的部分生命周期绑定
     */
    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Timber.e("HomePresenter onCreate");
        requestGirls(true);
    }

    private void requestGirls(final boolean pullToRefresh) {
        if (pullToRefresh) {
            lastPage = 1;
        }


    }


}
