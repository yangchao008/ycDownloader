package com.chao.ycdownloader;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class SyncTaskInfo {


    public int _id;

    public int userId;

    public int resId;

    public String name;

    public String downloadUrl;

    public String destPath;

    public String describeContent;

    public int downloadState;

    public int progress;

    public int taskType;

    //单个下载任务：多线程，单线程
    public boolean isMultithreading;

    public long createDate;

    public long updateDate;

}
