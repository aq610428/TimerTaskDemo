package com.idea.timertask.timertaskdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer timer = new Timer(true);
    private TextView text_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_time= (TextView) findViewById(R.id.text_time);
        //启动定时器
        timer.schedule(task, 0, 2000);
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                //todo something....
                Log.e("TimerTask","我两秒执行一次.......");
            }
        }
    };


    //任务
    private TimerTask task = new TimerTask() {
        public void run() {
            Message msg = new Message();
            msg.what = 1;
            handler.sendMessage(msg);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }
}
