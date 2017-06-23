package com.chao.ycdownloader;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import static com.chao.ycdownloader.DownloadService.BIND_SERVICE_OPERATE;
import static com.chao.ycdownloader.DownloadService.DELETE_OPERATE;
import static com.chao.ycdownloader.DownloadService.DOWNLOAD_OPERATE;
import static com.chao.ycdownloader.DownloadService.PAUSE_OPERATE;
import static com.chao.ycdownloader.DownloadService.RESTART_OPERATE;
import static com.chao.ycdownloader.DownloadService.UNBIND_SERVICE_OPERATE;

/**
 * Created by Administrator on 2017/6/22.
 */

public class DownloaderService extends AbstractDownloaderService {

    MyDownloadManager mMyDownloadManager;
    DownloadStateListener mDownloadStateListener;
    Messenger mRemoteService;
    Messenger mMessenger;
    Context mContext;
    Handler mHandler;

    public DownloaderService(Context context,boolean isMultithreading){
        mContext = context;
        autoBindService();
        mMyDownloadManager = new MyDownloadManager(isMultithreading);
    }

//    public DownloaderService(Context context,int threadCount){
//        mContext = context;
//        autoBindService();
//    }

    private void autoBindService() {
        Intent intent = new Intent(mContext,DownloadService.class);
        mContext.bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void unBindService(){
        mContext.unbindService(mServiceConnection);
        sendMessage(UNBIND_SERVICE_OPERATE,null);
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            SyncTaskInfo syncTaskInfo = null;
            if (msg.obj != null){
                syncTaskInfo = (SyncTaskInfo) msg.obj;
            }
            switch (what){
                case DOWNLOAD_OPERATE:
                    mMyDownloadManager.download(syncTaskInfo);
                    break;
                case PAUSE_OPERATE:
                    mMyDownloadManager.pause(syncTaskInfo);
                    break;
                case RESTART_OPERATE:
                    mMyDownloadManager.restart(syncTaskInfo);
                    break;
                case DELETE_OPERATE:
                    mMyDownloadManager.delete(syncTaskInfo);
                    break;
                default:
                    break;
            }
        }

    }

    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mRemoteService = new Messenger(service);
            sendMessage(BIND_SERVICE_OPERATE,null);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mRemoteService = null;
        }
    };

    private void sendMessage(int what,SyncTaskInfo syncTaskInfo) {
        try {
            if (mHandler == null) {
                mHandler = new MyHandler();
                mMessenger = new Messenger(mHandler);
            }
            Message message = Message.obtain(mHandler,what,syncTaskInfo);
            message.replyTo = mMessenger;

            mRemoteService.send(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void download(int userId, int resId, String downloadUrl, String name,String destPath) {
        download(userId,resId,downloadUrl,name, destPath,TaskType.TYPE_UNKNOWN);
    }

    @Override
    public void download(int userId, int resId, String downloadUrl, String name, String destPath, int taskType) {
//        mMyDownloadManager.setParameter(userId,resId,downloadUrl,name,desPath,taskType);
        SyncTaskInfo syncTaskInfo = new SyncTaskInfo();
        syncTaskInfo.userId = userId;
        syncTaskInfo.resId = resId;
        syncTaskInfo.downloadUrl = downloadUrl;
        syncTaskInfo.name = name;
        syncTaskInfo.destPath = destPath;
        syncTaskInfo.taskType = taskType;
        download(syncTaskInfo);
    }

    @Override
    public void download(SyncTaskInfo syncTaskInfo) {
        sendMessage(DOWNLOAD_OPERATE,syncTaskInfo);
    }

    @Override
    public void pause(SyncTaskInfo syncTaskInfo) {
        sendMessage(PAUSE_OPERATE,syncTaskInfo);
    }

    @Override
    public void restart(SyncTaskInfo syncTaskInfo) {
        sendMessage(RESTART_OPERATE,syncTaskInfo);
    }

    @Override
    public void delete(SyncTaskInfo syncTaskInfo) {
        sendMessage(DELETE_OPERATE,syncTaskInfo);
    }

    @Override
    public void setOnDownloadStateListener(DownloadStateListener listener) {
        mDownloadStateListener = listener;
    }

    @Override
    public SyncTaskInfo getTaskInfo(int userId, int resId, String name) {
        return getTaskInfo(userId,new int[]{resId},name);
    }

    @Override
    public SyncTaskInfo getTaskInfo(int userId, int[] resId, String... name) {
        return null;
    }
}
