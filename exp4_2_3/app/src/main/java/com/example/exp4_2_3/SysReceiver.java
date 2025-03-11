package com.example.exp4_2_3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class SysReceiver extends BroadcastReceiver {
    public SysReceiver() {}
    @Override
    public void onReceive(Context context, Intent intent) {
        int wifistate = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
        if(wifistate == WifiManager.WIFI_STATE_DISABLED) {
            Toast.makeText(context, "WIFI连接关闭", Toast.LENGTH_LONG).show();
        }
        else if(wifistate == WifiManager.WIFI_STATE_ENABLED){
            Toast.makeText(context, "WIFI已连接", Toast.LENGTH_LONG).show();
        }

    }
}
