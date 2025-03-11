package com.example.exp4_2_1;

import android.content.BroadcastReceiver;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;

public class Myreceiver extends BroadcastReceiver {
    public Myreceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "收到了广播消息", Toast.LENGTH_LONG).show();
    }
}
