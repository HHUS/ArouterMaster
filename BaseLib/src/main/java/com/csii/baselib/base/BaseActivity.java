package com.csii.baselib.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.csii.baselib.delegate.IActivity;
import com.csii.baselib.mvp.IPresenter;
import com.csii.baselib.mvp.IView;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity, IView {

    protected final String TAG = this.getClass().getSimpleName();

    /**
     * 如果当前页面逻辑简单presenter 可以为null
     */
    protected P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutResId = initView(savedInstanceState);
        if (layoutResId != 0) {
            setContentView(layoutResId);
        }

        initData(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        this.mPresenter = null;

    }

    @Override
    public boolean useEventBus() {
        return true;
    }

    @Override
    public boolean useFragment() {
        return true;
    }
}
