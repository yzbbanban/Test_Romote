package com.bb.yzbbanban.test_romote.service;

import android.app.Service;
import android.content.Intent;
import android.icu.text.DateIntervalInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.util.*;

/**
 * This Service is Persistent Service. Do some what you want to do here.<br/>
 * <p>
 * Created by Mars on 12/24/15.
 */
public class Service1 extends Service {
    private static final String TAG = "Service1";
    private Timer timer;
    private TimerTask timerTask;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Toast.makeText(Service1.this, "ban", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "handleMessage: ban"+new Date());
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        //TODO do some thing what you want..

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
            }
        };
        timer.schedule(timerTask, 3000, 3000);


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
