package com.chao.ycdownloader;

import android.content.Context;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class DownloadHelper {

    public static DownloaderService getDownloaderService(Context context,boolean isMultithreading){
        return new DownloaderService(context,isMultithreading);
    }

//    public static DownloaderService getDownloaderService(Context context,int threadCount){
//        return new DownloaderService(context,threadCount);
//    }


}
