package com.example.android.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

public class MyStartedService extends Service {
    public MyStartedService() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                int counter = 0;
                while (counter < 100){
                    Log.i("Minhal", counter +" " + new Date());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter++;
                }

                stopSelf();
                return null;
            }
        }.execute();
        return START_REDELIVER_INTENT;

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
