package com.csii.work;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class WorkActivity extends AppCompatActivity{
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //添加任务约束条件

        Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .build();

        //Demo
        //使用WorkManager进行任务调度，进行压缩图片
        OneTimeWorkRequest compressWork = new OneTimeWorkRequest
                .Builder(CompressWorker.class)
                .setConstraints(constraints)
                .build();

        WorkManager.getInstance().enqueue(compressWork);

        /**
         * WorkManager会选择适当的时间运行这个任务，平衡诸如系统负载，
         * 设备是否插入等考虑因素。在多数情况下，如果我们没有指定任何约束条件，
         * WorkManager会立即运行我们的任务。如果我们需要检查任务的状态
         * 我们可以通过获取合适的LiveData <WorkStatus>的句柄来获取WorkStatus对象。
         */
//        WorkManager.getInstance().getStatusById(compressWork.getId())
//                .observe(owner,workStatus -> {
//
//                });


//        取消任务
//        当我们将任务入列后，我们还可以取消这个任务。要取消任务，我们需要这个任务的Work ID，当然Work ID可以从WorkRequest对象中获取。例如，以下代码将取消上一节中的compressionWork请求：

        /**
         * WorkManager 会尽最大努力取消任务，但实质上这是不确定的 - 当我们尝试取消任务时，任务可能已经运行或完成。
         * WorkManager还提供方法来取消
         * 唯一工作序列（这个概念在下面会讲到）中的所有任务，或尽最大努力的取消具有指定标记的所有任务。
         */
        UUID compressionWorkId = compressWork.getId();
        WorkManager.getInstance().cancelWorkById(compressionWorkId);


        //WorkManager API 的核心功能可以使开发者能够创建简单的、即开即忘的任务

        //创建重复执行的任务
        

    }
}
