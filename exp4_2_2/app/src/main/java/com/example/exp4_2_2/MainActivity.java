package com.example.exp4_2_2;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyRecevier2 recevier = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterMyReceiver(v);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unRegisterMyReceiver(v);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg(v);
            }
        });
    }

    public void RegisterMyReceiver(View view) {
        if(recevier == null) {
            recevier = new MyRecevier2();
            registerReceiver(recevier, new IntentFilter(MyRecevier2.ACTION));
        }
    }

    public void unRegisterMyReceiver(View view){
            if(recevier != null) {
                unregisterReceiver(recevier);
                recevier = null;
            }
    }

    public void sendMsg(View view) {
        sendBroadcast(new Intent(MyRecevier2.ACTION));
    }

}