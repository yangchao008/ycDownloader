package com.chao.ycdownloader;

import com.chao.ycdownloader.bean.TaskInfo;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class DownloadHelper extends AbstractDownload {
    DownloadStateListener mDownloadStateListener;

    @Override
    void download(int userId, int resId, String downloadUrl, String desPath, String name) {
        download(userId,resId,downloadUrl,desPath,name,TaskType.TYPE_UNKNOWN);
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
        mDownloadStateListener = listener;
    }
}
