package com.bb.yzbbanban.test_romote.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * This Service is Persistent Service. Do some what you want to do here.<br/>
 *
 * Created by Mars on 12/24/15.
 */
public class Service1 extends Service{
    private static final String TAG = "Service1";
    @Override
    public void onCreate() {
        super.onCreate();
        //TODO do some thing what you want..
        Toast.makeText(this, "ban", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "ban", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "ban", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "ban", Toast.LENGTH_SHORT).show();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
