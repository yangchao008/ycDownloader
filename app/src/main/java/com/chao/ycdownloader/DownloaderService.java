package com.chao.ycdownloader;

import com.chao.ycdownloader.bean.TaskInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/22.
 */

public class DownloaderService extends AbstractDownload{

    static ExecutorService mExecutorService;

    static {
        mExecutorService = Executors.newFixedThreadPool(3);
    }

    public DownloaderService(){

    }

    public DownloaderService(int threadCount){
    }

    @Override
    void download(int userId, int resId, String downloadUrl, String desPath, String name) {

    }

    @Override
    void download(int userId, int resId, String downloadUrl, String desPath, String name, int taskType) {

    }

    @Override
    void pause(TaskInfo taskInfo) {

    }

    @Override
    void restart(TaskInfo taskInfo) {

    }

    @Override
    void delete(TaskInfo taskInfo) {

    }

    @Override
    void setOnDownloadStateListener(DownloadStateListener listener) {

    }

    @Override
    TaskInfo getTaskInfo(int userId, int resId, String name) {
        return null;
    }

    @Override
    TaskInfo getTaskInfo(int userId, int[] resId, String... name) {
        return null;
    }
}
