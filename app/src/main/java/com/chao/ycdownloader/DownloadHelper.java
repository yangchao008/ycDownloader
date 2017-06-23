package com.chao.ycdownloader;

/**
 * Created by Administrator on 2017/6/20 0020.
 */

public class DownloadHelper {

    public static DownloaderService getDownloaderService(){
        return new DownloaderService();
    }

    public static DownloaderService getDownloaderService(int threadCount){
        return new DownloaderService(threadCount);
    }


}
