package com.example.android.toyvpn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import java.util.logging.LogRecord;

/**
 * Created by 상헌 on 2016-05-29.
 */

public class MainActivity2 extends Activity

{

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);






        InnerClassHandler2 noLeakHandler2 = new InnerClassHandler2(this);

        noLeakHandler2.sendEmptyMessageDelayed(0, 2000); // 2초 뒤에 메시지 전달

    }




    // static inner class 로 선언

    static class InnerClassHandler2 extends Handler

    {

        private final WeakReference<MainActivity2> mActivity;




        InnerClassHandler2(MainActivity2 activity) {

            mActivity = new WeakReference<MainActivity2>(activity);

        }




        public void handleMessage(Message msg)

        {

            MainActivity2 activity = mActivity.get();

            if(activity != null) {

                activity.handleMessage(msg);

            }

        }




    }




    private void handleMessage(Message msg) {

        Intent intent = new Intent(this, DataCheckActivity.class);




        startActivity(intent);


        finish();   // MainActivity 종료

    }

}