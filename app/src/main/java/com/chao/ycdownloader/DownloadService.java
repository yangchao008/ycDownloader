package com.chao.ycdownloader;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/6/22.
 */

public class DownloadService extends Service{
    Messenger mMessenger;
    MyHandler mHandler;

    public static final int BIND_SERVICE_OPERATE = 0;
    public static final int UNBIND_SERVICE_OPERATE = 1;

    public static final int DOWNLOAD_OPERATE = 10;
    public static final int PAUSE_OPERATE = 11;
    public static final int RESTART_OPERATE = 12;
    public static final int DELETE_OPERATE = 13;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (mHandler == null){
            mHandler = new MyHandler();
            mMessenger = new Messenger(new MyHandler());
        }
        return mMessenger.getBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Messenger messenger = msg.replyTo;
            int what = msg.what;
            switch (what){
                case BIND_SERVICE_OPERATE:
                    break;
                case UNBIND_SERVICE_OPERATE:
                    break;
                case DOWNLOAD_OPERATE:
                case PAUSE_OPERATE:
                case RESTART_OPERATE:
                case DELETE_OPERATE:
                    try {
                        Message message = Message.obtain(mHandler,what,msg.obj);
                        messenger.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }

     }
}
