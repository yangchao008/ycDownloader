package com.chao.ycdownloader;

/**
 * Created by Administrator on 2017/6/23.
 */

public enum  DownloadState {

    INVALID_STATE(-1),
    START_STATE(1),
    PAUSE_STATE(2),
    RESUME_STATE(3),
    COMPLETE_STATE(4),
    ERROR_STATE(5);

    final int value;
    DownloadState(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }
}
