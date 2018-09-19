package com.csii.mvp;

import com.csii.bean.GankItemBean;
import com.csii.baselib.mvp.BaseResponse;
import com.csii.mvp.model.LoginBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/api/data/")
    Flowable<BaseResponse<List<GankItemBean>>> getGirlList(@Path("num") int num, @Path("page") int page);

    /**
     * 登陆
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Flowable<BaseResponse<LoginBean>> login(@Field("username") String username,
                                              @Field("password") String password);

}
