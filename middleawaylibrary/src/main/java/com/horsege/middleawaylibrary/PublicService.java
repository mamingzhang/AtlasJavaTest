package com.horsege.middleawaylibrary;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PublicService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();

        Log.v("mmz", "PublicService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("mmz", "PublicService onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("mmz", "PublicService onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
