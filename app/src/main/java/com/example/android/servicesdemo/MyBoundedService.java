package com.example.android.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundedService extends Service {
    public MyBoundedService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    public class MyBinder extends Binder {
        public void logMessage(String msg) {
            Log.i("Minhal", msg);
        }

        public void doWork2() {
        }

        public int doWork3() {
            return 10;
        }
    }
}
