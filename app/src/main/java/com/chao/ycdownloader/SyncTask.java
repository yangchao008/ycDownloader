package com.chao.ycdownloader;

import android.support.annotation.NonNull;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/6/23.
 */

public class SyncTask<T> extends FutureTask<T>{
    public SyncTask(@NonNull Callable<T> callable) {
        super(callable);
    }

    public SyncTask(@NonNull Runnable runnable, T result) {
        super(runnable, result);
    }
}
