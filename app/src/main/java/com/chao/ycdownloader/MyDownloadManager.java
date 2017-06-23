package com.chao.ycdownloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/23.
 */

public class MyDownloadManager implements Downloader{

    static ExecutorService mExecutorService;
    public boolean isMultithreading;



    public MyDownloadManager(){
    }

    public MyDownloadManager(boolean isMultithreading){
        this.isMultithreading = isMultithreading;
    }

//    public void setParameter(int userId, int resId, String downloadUrl, String name,String desPath, int taskType){
//
//    }

    static {
        mExecutorService = Executors.newFixedThreadPool(3);
    }

    @Override
    public void download(SyncTaskInfo syncTaskInfo) {
        syncTaskInfo.downloadState = DownloadState.START_STATE.getValue();
        syncTaskInfo.isMultithreading = this.isMultithreading;
        syncTaskInfo.progress = -1;
    }

    @Override
    public void pause(SyncTaskInfo syncTaskInfo) {
        syncTaskInfo.downloadState = DownloadState.PAUSE_STATE.getValue();
        if (syncTaskInfo.isMultithreading != this.isMultithreading){
            this.isMultithreading = syncTaskInfo.isMultithreading;
        }
    }

    @Override
    public void restart(SyncTaskInfo syncTaskInfo) {
        syncTaskInfo.downloadState = DownloadState.RESUME_STATE.getValue();
        if (syncTaskInfo.isMultithreading != this.isMultithreading){
            this.isMultithreading = syncTaskInfo.isMultithreading;
        }
    }

    @Override
    public void delete(SyncTaskInfo syncTaskInfo) {

    }
}
