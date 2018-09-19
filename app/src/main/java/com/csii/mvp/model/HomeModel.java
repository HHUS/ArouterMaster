package com.csii.mvp.model;

import com.csii.baselib.http.RetrofitClient;
import com.csii.baselib.mvp.BaseResponse;
import com.csii.bean.GankItemBean;
import com.csii.mvp.ApiService;
import com.csii.mvp.contract.HomeContract;

import java.util.List;

import io.reactivex.Flowable;

public class HomeModel implements HomeContract.Model {
    @Override
    public Flowable<BaseResponse<List<GankItemBean>>> getGirlList(int num, int page) {
        return RetrofitClient.getInstance().createService(ApiService.class).getGirlList(num,page);
    }

    @Override
    public void onDestroy() {

    }
}
