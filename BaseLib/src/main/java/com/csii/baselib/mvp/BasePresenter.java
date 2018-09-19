package com.csii.baselib.mvp;

import android.app.Activity;
import android.app.Service;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;
import android.view.View;

import com.csii.baselib.utils.Preconditions;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

/**
 * 基类 Presenter
 */
public class BasePresenter<V extends IView> implements IPresenter {

    protected final String TAG = this.getClass().getSimpleName();

    protected CompositeDisposable mCompositeDisposable;

    protected V mRootView;


    /**
     * @param rootView
     */
    public BasePresenter(V rootView) {
        Preconditions.checkNotNull(rootView, "%s cannot be null", IView.class.getName());
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }

    @Override
    public void onCreate() {
        Timber.e("实现了： onCreate");

        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    public void onStart() {

        if (mRootView != null && mRootView instanceof LifecycleOwner) {
            ((LifecycleOwner) mRootView).getLifecycle().addObserver(this);
        }

    }


    /**
     * 在框架中 {@link Activity#onDestroy()} 时会默认调用 {@link IPresenter#onDestroy()}
     * <p>
     * 只有当mRootView不为 null, 并且mRootView实现了LifecycleOwner时, 此方法才会被调用
     * 所以当您想在 Service 以及一些自定义 View或自定义类中使用 Presenter 时
     * 您也将不能继续使用 OnLifecycleEvent绑定生命周期
     */
    @Override
    public void onDestroy() {

        if (mRootView != null && mRootView instanceof LifecycleOwner) {
            ((LifecycleOwner) mRootView).getLifecycle().removeObserver(this);
        }

        Timber.e("实现了： onDestroy");
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }

        unDisponse();

        this.mRootView = null;
        this.mCompositeDisposable = null;
    }

    @Override
    public void onLifecycleChanged(LifecycleOwner owner, Lifecycle.Event event) {

    }


    /**
     * 停止集合正在执行的Rxjava任务
     */
    private void unDisponse() {

        if (mCompositeDisposable != null) {
            //保证Activity结束时取消正在执行的订阅
            mCompositeDisposable.clear();
        }
    }

    /**
     * 将Disposable中统一管理
     * 可在 Activity-onDestroy() 中使用unDispose() 停止正在执行的 RxJava 任务,避免内存泄漏
     *
     * @param disposable
     */
    public void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        //将所有 Disposable 放入集中处理
        mCompositeDisposable.add(disposable);
    }


    /**
     * 是否使用,默认为使用(true)，
     *
     * @return
     */
    public boolean useEventBus() {
        return false;
    }
}
