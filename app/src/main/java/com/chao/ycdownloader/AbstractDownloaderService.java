package com.chao.ycdownloader;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public abstract class AbstractDownloaderService implements Downloader{

    public abstract void download(int userId,int resId,String downloadUrl,String name,String destPath);

    public abstract void download(int userId,int resId,String downloadUrl,String name,String destPath,
                           int taskType);

    public abstract void setOnDownloadStateListener(DownloadStateListener listener);

    public abstract SyncTaskInfo getTaskInfo(int userId, int resId, String name);

    public abstract SyncTaskInfo getTaskInfo(int userId, int[] resId, String... name);

}
