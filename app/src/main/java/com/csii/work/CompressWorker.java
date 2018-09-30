package com.csii.work;

import androidx.annotation.NonNull;

import androidx.work.Worker;

//WorkManager API 调度图像压缩任务
public class CompressWorker extends Worker {
    @NonNull
    @Override
    public WorkerResult doWork() {
        //进行压缩

//        compressImg();
        return WorkerResult.SUCCESS;
    }
}
