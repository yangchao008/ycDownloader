package com.chao.ycdownloader;

/**
 * Created by Administrator on 2017/6/23.
 */

public interface Downloader {

    void download(SyncTaskInfo syncTaskInfo);

    void pause(SyncTaskInfo syncTaskInfo);

    void restart(SyncTaskInfo syncTaskInfo);

    void delete(SyncTaskInfo syncTaskInfo);
}
