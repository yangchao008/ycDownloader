package com.chao.ycdownloader;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public interface DownloadStateListener {

    void onUpdateProgress();

    void onStart();

    void onPause();

    void onResume();

    void onComplete();

    void onDelete();
}
