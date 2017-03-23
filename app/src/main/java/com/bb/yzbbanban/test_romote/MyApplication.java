package com.bb.yzbbanban.test_romote;

import android.app.Application;
import android.content.Context;

import com.bb.yzbbanban.test_romote.receiver.Receiver1;
import com.bb.yzbbanban.test_romote.receiver.Receiver2;
import com.bb.yzbbanban.test_romote.service.Service1;
import com.bb.yzbbanban.test_romote.service.Service2;
import com.marswin89.marsdaemon.DaemonClient;
import com.marswin89.marsdaemon.DaemonConfigurations;

/**
 * Created by YZBbanban on 2017/3/21.
 */

public class MyApplication extends Application {
    private DaemonClient mDaemonClient;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mDaemonClient = new DaemonClient(createDaemonConfigurations());
        mDaemonClient.onAttachBaseContext(base);
    }



    private DaemonConfigurations createDaemonConfigurations(){
        DaemonConfigurations.DaemonConfiguration configuration1 = new DaemonConfigurations.DaemonConfiguration(
                "com.bb.yzbbanban.test_romote:process11",
                Service1.class.getCanonicalName(),
                Receiver1.class.getCanonicalName());
        DaemonConfigurations.DaemonConfiguration configuration2 = new DaemonConfigurations.DaemonConfiguration(
                "com.bb.yzbbanban.test_romote:process22",
                Service2.class.getCanonicalName(),
                Receiver2.class.getCanonicalName());
        DaemonConfigurations.DaemonListener listener = new MyDaemonListener();
        //return new DaemonConfigurations(configuration1, configuration2);//listener can be null
        return new DaemonConfigurations(configuration1, configuration2, listener);
    }


    class MyDaemonListener implements DaemonConfigurations.DaemonListener{
        @Override
        public void onPersistentStart(Context context) {
        }

        @Override
        public void onDaemonAssistantStart(Context context) {
        }

        @Override
        public void onWatchDaemonDaed() {
        }
    }


}
