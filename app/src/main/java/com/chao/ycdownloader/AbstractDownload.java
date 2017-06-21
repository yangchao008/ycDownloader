package com.chao.ycdownloader;

import com.chao.ycdownloader.bean.TaskInfo;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public abstract class AbstractDownload {

    abstract void download(int userId,int resId,String downloadUrl,String desPath,String name);

    abstract void download(int userId,int resId,String downloadUrl,String desPath,String name,
                           int taskType);

    abstract void pause(TaskInfo taskInfo);

    abstract void restart(TaskInfo taskInfo);

    abstract void delete(TaskInfo taskInfo);

    abstract void setOnDownloadStateListener(DownloadStateListener listener);

    public TaskInfo getTaskInfo(int userId,int resId){
        return getTaskInfo(userId,resId);
    }

    public TaskInfo getTaskInfo(int userId,int... resId){
        return null;
    }

}
