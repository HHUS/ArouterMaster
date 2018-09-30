package com.csii;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.csii.baselib.base.BaseActivity;
import com.csii.baselib.utils.DeviceUtils;
import com.csii.mvp.contract.HomeContract;
import com.csii.mvp.presenter.HomePresenter;
import com.csii.photo.DragPhotoActivity;
import com.csii.sunhao.arouter_master.R;

import timber.log.Timber;

public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.View{


    private ImageView imageView;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        imageView = findViewById(R.id.image);


//        AlarmManager,JobScheuler

//        Timber.e("initData");

        float smllWidth = DeviceUtils.getSmllWidthDp(MainActivity.this);
        Timber.e("屏幕的最小宽度（dp）:" + smllWidth);

        mPresenter = new HomePresenter(this);

        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPhotoActivity(MainActivity.this, imageView);

                Toast.makeText(MainActivity.this,"点了了",Toast.LENGTH_SHORT).show();
            }
        });
    }



    public  void startPhotoActivity(Context context, ImageView imageView) {
        Intent intent = new Intent(context, DragPhotoActivity.class);
        int location[] = new int[2];

        imageView.getLocationOnScreen(location);
        intent.putExtra("left", location[0]);
        intent.putExtra("top", location[1]);
        intent.putExtra("height", imageView.getHeight());
        intent.putExtra("width", imageView.getWidth());

        context.startActivity(intent);
        overridePendingTransition(0,0);
    }

    @Override
    public void startLoadMore() {
        Timber.e("startLoadMore");

    }

    @Override
    public void endLoadMore() {
        Timber.e("endLoadMore");
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void launchActivity(@NonNull Intent intent) {

    }


}
