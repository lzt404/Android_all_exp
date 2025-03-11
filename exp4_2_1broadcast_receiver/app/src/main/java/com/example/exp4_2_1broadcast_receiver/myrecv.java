package com.example.exp4_2_1broadcast_receiver;

import android.content.BroadcastReceiver;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;


public class myrecv extends BroadcastReceiver {
    public myrecv() {

    }
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "收到一个广播消息", Toast.LENGTH_SHORT).show();
    }
}
