package com.example.exp4_2_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyRecevier2 extends BroadcastReceiver {
    public static String ACTION = "LearnBroadcastrecevier2.MyReceiver2";
    public  MyRecevier2(){

    }
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "收到一个广播消息", Toast.LENGTH_LONG).show();
    }
}
