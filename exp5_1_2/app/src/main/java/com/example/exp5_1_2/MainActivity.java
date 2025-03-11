package com.example.exp5_1_2;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.textView);
        String state = Environment.getExternalStorageState();
        File sdcard=Environment.getDataDirectory();
        textView.setText("SD卡:" + sdcard.getPath());
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isWritable()){
                    textView.setText("SD卡不可用");
                    return;
                }
                File sdcard=Environment.getExternalStorageDirectory();
                File mf=new File(sdcard,"myfile.txt");
                //File mf=new File("/storage/emulated/0/myfile.txt");
                try {
                    mf.createNewFile();
                    String data = "在SD卡文件中的数据";
                    FileOutputStream fos = new FileOutputStream(mf);
                    OutputStreamWriter osw=new OutputStreamWriter(fos);
                    osw.write(data);
                    osw.flush();
                    fos.flush();
                    osw.close();
                    fos.close();
                    textView.setText("数据已经写入外部文件");
                } catch (Exception e) {
                    textView.setText(e.getMessage());
                }
            }
        });
        Button btn2=(Button)findViewById(R.id.button2) ;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isReadable()){
                    textView.setText("SD卡不可读");
                    return;
                }
                File sdcard=Environment.getExternalStorageDirectory();
                File mf=new File(sdcard,"myfile.txt");
                try {
                    FileInputStream fis = new FileInputStream(mf);
                    InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
                    char[] data2=new char[fis.available()];
                    isr.read(data2);
                    isr.close();
                    fis.close();
                    textView.setText(new String(data2));
                } catch (Exception e) {
                    textView.setText(e.getMessage());
                }
            }
        });
    }
    private boolean isReadable(){//检测存储卡是否可读
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED) ||
                state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            return true;
        }
        return false;
    }
    private boolean isWritable(){//检测存储卡是否可写
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }
}