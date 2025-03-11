package com.example.exp6_1_1;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private SoundPool sp;
    private int soundId1;
    private int soundId2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //初始化SoundPool
        if (Build.VERSION.SDK_INT >= 21) {
            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setMaxStreams(2);//设置可加载的音频数量
            //AudioAttributes是一个封装音频各种属性的方法
            AudioAttributes.Builder attrBuilder = new AudioAttributes.Builder();
            attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC);//预设音频类型
            builder.setAudioAttributes(attrBuilder.build());//设置音频类型
            sp = builder.build();//创建SoundPool对象
        }
        else {//当系统的SDK版本小于21时
            sp = new SoundPool(2, AudioManager.STREAM_SYSTEM, 0);
        }
        soundId1=sp.load(this,R.raw.winlog,1);
        soundId2=sp.load(this,R.raw.lesson1,2);
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(soundId1,1,1,1,0,1);
            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(soundId2,2,1,1,0,1);
            }
        });
    }
}