package com.csii.mvp.contract;

import android.app.Activity;

import com.csii.bean.GankItemBean;
import com.csii.baselib.mvp.BaseResponse;
import com.csii.baselib.mvp.IModel;
import com.csii.baselib.mvp.IView;

import java.util.List;

import io.reactivex.Flowable;


/**
 * 展示Contract的用法
 */
public interface HomeContract {

    interface View extends IView{
        void startLoadMore();

        void endLoadMore();

        Activity getActivity();
    }


    /**
     * 外部只需要关心Model层返回的数据
     */
    interface Model extends IModel {

        Flowable<BaseResponse<List<GankItemBean>>> getGirlList(int num, int page);

    }

}
